package n3exercise1;

import java.util.ArrayList;

public class Editor {
	
	// ATRIBUTES
	private String name;
	private final String id;
	private static int sou = 1500;
	private ArrayList<News> allNews;
 
	// CONSTRUCTOR
	public Editor(String name, String id) {
		this.name = name;
		this.id = id;
		this.allNews = new ArrayList<News>();
	}

	// GETTERS N SETTERS
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public static int getSou() {
		return sou;
	}
	
	public ArrayList<News> getAllNews() {
		return allNews;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public static void setSou(int nouSou) {
		Editor.sou = nouSou;
	}

	public void setAllNews(News news) {
		allNews.add(news);
	}
	

}
