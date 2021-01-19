package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.thrillio.bigjobs.WebPageDownloaderTask;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

// Controller -> Manager -> Dao -> DataStore

public class Launch {

	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;
	
	
	private static void loadData() {
		System.out.println("1. Loading Data..");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
//		System.out.println("2. Printing Data..");
//		printUserData();
//		printBookmarkData();
	}
	
	
	
	private static void printBookmarkData() {
		for(List<Bookmark> bookmarkList: bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);	
			}
			
		}
		
	}


	private static void start() {	
		for(User user: users) {
			View.browse(user, bookmarks);
		}
		
	}

	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
		
	}
	
	private static void runDownloaderJob() {
		WebPageDownloaderTask task = new WebPageDownloaderTask(true);
		(new Thread(task)).start();
	}	


	public static void main(String[] args) {
		loadData();
		start();
		runDownloaderJob();

	}


}