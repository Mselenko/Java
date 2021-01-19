package com.semanticsquare.thrillio.bigjobs;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Weblink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class WebPageDownloaderTask implements Runnable {
	
	private static BookmarkDao dao =new BookmarkDao();
	
	private static final long TIME_FRAME = 3000000000L;
	
	private boolean downloadAll = false;
	
	ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);
	
	
	private static class Downloader<T extends Weblink> implements Callable<T> {
		private T weblink;
		public Downloader(T weblink) {
			this.weblink = weblink;
		}
		public T call() {
			try {
				if (!weblink.getUrl().endsWith(".pdf")) {
					weblink.setDownloadStatus(Weblink.DownloadStatus.FAILED);
					
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);			
				}else {
					weblink.setDownloadStatus(Weblink.DownloadStatus.NOT_ELIGIBLE);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return weblink;
		}
	}

	public WebPageDownloaderTask(boolean downloadAll) {
		this.downloadAll = downloadAll;
	}

	@Override
	public void run() {
		
		
		while(!Thread.currentThread().isInterrupted()) {
			
			List<Weblink> weblinks = getWeblinks();
			
			if(weblinks.size() > 0) {
				download(weblinks);
				
			}else {
				System.out.println("No New Weblinks..");
			}
			
			try {
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		downloadExecutor.shutdown();

	}

	private void download(List<Weblink> weblinks) {
		long endTime = System.nanoTime() + TIME_FRAME;
		List<Downloader<Weblink>> tasks = getTasks(weblinks);
		List<Future<Weblink>> futures = new ArrayList<>();
		
		try {
			futures = downloadExecutor.invokeAll(tasks, TIME_FRAME, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Future<Weblink> future : futures) {
			try {
				if (!future.isCancelled()) {
					Weblink weblink = future.get();
					String webpage = weblink.getHtmlPage();
					
					if(webpage != null) {
						IOUtil.write(webpage, weblink.getId());
						weblink.setDownloadStatus(Weblink.DownloadStatus.SUCCESS);
						System.out.println("Successfully downloaded!");
					}else {
						System.out.println("Download failed");
					}
				} else {
					System.out.println("\n\nTask is cancelled --> " + Thread.currentThread());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}


		
	}

	private List<Downloader<Weblink>> getTasks(List<Weblink> weblinks) {
		List<Downloader<Weblink>> task = new ArrayList<>();
		
		for(Weblink weblink : weblinks) {
			task.add(new Downloader<Weblink>(weblink));
		}
		
		return task;
	}

	private List<Weblink> getWeblinks() {
		List<Weblink> weblinks = null; 
		
		if(downloadAll) {
			weblinks = dao.getAllWeblinks();
			downloadAll = false;
		}else {
			weblinks = dao.getWeblinks(Weblink.DownloadStatus.NOT_ATTEMPTED);
		}
		return weblinks;
	}

}
