package com.semanticsquare.thrillio;

import java.util.ArrayList;
import java.util.List;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;
import com.semanticsquare.thrillio.util.IOUtil;

public class DataStore {
	
	private static List<User> users= new ArrayList<>();
	private static List<List<Bookmark>> bookmarks = new ArrayList<>();
	private static List<UserBookmark> userBookmarks = new ArrayList<>();

	
	public static List<User> getUsers() {
		return users;
	}

	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}

	public static List<UserBookmark> getUserBookmarks() {
		return userBookmarks;
	}
	
	public static void loadData() {
		loadUsers();
		loadWeblinks();
		loadMovies();
		loadBooks();
	}
	
	private static void loadUsers() {
		
		//String[] data = new String[TOTAL_USER_COUNT];
		List<String> data = new ArrayList<>();
    	IOUtil.read(data, "User");
    	for (String row : data) {
    		String[] values = row.split("\t");
    		
    		Gender gender = Gender.MALE;
    		if (values[5].equals("f")) {
    			gender = Gender.FEMALE;
    		} else if (values[5].equals("t")) {
    			gender = Gender.TRANSGENDER;
    		}
    		
    		User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
    		users.add(user);
    	}
//		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE,	UserType.USER);
//		users[1] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE,	UserType.USER);
//		users[2] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE,	UserType.USER);
//		users[3] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE,	UserType.USER);
//		users[4] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE,	UserType.USER);
	}
	
//	private static void loadWeblinks() {
//		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//	}
//	
//	private static void loadMovies() {
//		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000,"", "Citizen Kane",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.CLASSICS,	8.5);
//		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3000,"", "Citizen Kane",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.CLASSICS,	8.5);
//		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3000,"", "Citizen Kane",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.CLASSICS,	8.5);
//		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3000,"", "Citizen Kane",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.CLASSICS,	8.5);
//		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3000,"", "Citizen Kane",	1941,	new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},	MovieGenre.CLASSICS,	8.5);
//	}
//	private static void loadBooks() {
//		bookmarks[1][0] = BookmarkManager.getInstance().createBook(4000, "Walden",1854,	"Wilder Publications", new String[]	{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
//		bookmarks[1][1] = BookmarkManager.getInstance().createBook(4000, "Walden",1854,	"Wilder Publications", new String[]	{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
//		bookmarks[1][2] = BookmarkManager.getInstance().createBook(4000, "Walden",1854,	"Wilder Publications", new String[]	{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
//		bookmarks[1][3] = BookmarkManager.getInstance().createBook(4000, "Walden",1854,	"Wilder Publications", new String[]	{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
//		bookmarks[1][4] = BookmarkManager.getInstance().createBook(4000, "Walden",1854,	"Wilder Publications", new String[]	{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
//	}
	
	
	private static void loadWeblinks() {
		List<String> data = new ArrayList<>();
    	IOUtil.read(data, "WebLink");
    	
    	List<Bookmark> bookmarkList = new ArrayList<>();
    	for (String row : data) {
    		String[] values = row.split("\t");
    		Bookmark bookmark = BookmarkManager.getInstance().createWeblink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
    		bookmarkList.add(bookmark);
    	}
    	bookmarks.add(bookmarkList);
	}
	
	private static void loadMovies() {
		List<String> data = new ArrayList<>();
    	IOUtil.read(data, "Movie");
    	
    	List<Bookmark> bookmarkList = new ArrayList<>();
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] cast = values[3].split(",");
    		String[] directors = values[4].split(",");
    		Bookmark bookmark = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
    		bookmarkList.add(bookmark);
    	}
    	bookmarks.add(bookmarkList);
	}
	
	private static void loadBooks() {		    	
		List<String> data = new ArrayList<>();
    	IOUtil.read(data, "Book");
    	List<Bookmark> bookmarkList = new ArrayList<>();
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] authors = values[4].split(",");
    		Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, BookGenre.valueOf(values[5]), Double.parseDouble(values[6])/*, values[7]*/);
    		bookmarkList.add(bookmark);
    	}
    	bookmarks.add(bookmarkList);
    }	

	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}
	
}