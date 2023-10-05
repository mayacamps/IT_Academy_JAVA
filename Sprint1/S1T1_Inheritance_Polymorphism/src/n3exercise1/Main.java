package n3exercise1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	/*
	README. Editor's unique variable is their ID. Therefore,
	when taking actions that require knowing WHICH editor we need,
	we are going to ask for the ID, and not their name 
	(Example: deleting editor, adding news to editor).
	 */

	public static ArrayList<Editor> editors = new ArrayList<Editor>();
	public static Scanner en = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int menuOpt;
		String message;
		
		// MAIN LOOP - Option menu
		do {
			System.out.println("Option menu:\n"
					+ "1. Add Editor\n"
					+ "2. Delete Editor\n"
					+ "3. Add News to Editor\n"
					+ "4. Delete News\n"
					+ "5. Show all Editor's News\n"
					+ "6. Get News' Score\n"
					+ "7. Get New's Price\n"
					+ "8. Exit\n");
			
			try { 
				menuOpt = en.nextInt();
			} catch (InputMismatchException e) {
				menuOpt = 0;
			}
			en.nextLine(); // clean buffer
			
			switch (menuOpt) {
			case 1:
				System.out.println("You selected add editor.");
				message = addEditor();
				break;
			case 2:
				System.out.println("You selected delete editor.");
				message = deleteEditor();
				break;
			case 3:
				System.out.println("You selected create news.");
				message = createNews();
				break;
			case 4:
				System.out.println("You selected delete news.");
				message = deleteNews();
				break;
			case 5:
				System.out.println("You selected show all Editor's news.");
				message = showNews();
				break;
			case 6:
				System.out.println("You selected news point calculation.");
				message = calcPoints();
				break;
			case 7:
				System.out.println("You selected news price calculation.");
				message = calcPrice();
				break;
			case 8:
				message = "Bye!\n";
				break;
			default:
				message = "Please choose a valid option.\n";
				break;
			}
		
			System.out.println(message);
		} while (menuOpt != 8);
	
	}
	
	// METHODS
	public static String getEditorName() {
		String name;
		
		System.out.println("Please introduce the editor's name: ");
		name = en.nextLine();
		
		return name;
	}
	
	public static String getEditorId() {
		String id;
		
		System.out.println("Please introduce the editor's id: ");
		id = en.nextLine();
		
		return id;
	}
	
	public static String getHeadline() {
		String hline;
		
		System.out.println("Please introduce the new's headline: ");
		hline = en.nextLine();
		
		return hline;
	}
	
	public static String getComp() {
		String comp;
		
		System.out.println("What competition is it about?");
		comp = en.nextLine();
		
		return comp;
	}
	
	public static String getTeam() {
		String team;
		
		System.out.println("What team is it about?");
		team = en.nextLine();
		
		return team;
	}
	
	public static String getPlayer() {
		String player;
		
		System.out.println("What player is it about?");
		player = en.nextLine();
		
		return player;
	}
	
	public static int findEditor(String id) {
		int pos = -1;
		
//		int i = 0;
//		boolean found = false;
//		while (i < editors.size() && !found) {
//			if (editors.get(i).getId().equalsIgnoreCase(id)) {
//				found = true;
//				pos = i;
//			} else {
//				i++;
//			}
//		}
		
		for (int i = 0; i < editors.size(); i++ ) {
			if (editors.get(i).getId().equalsIgnoreCase(id)) {
				pos = i;
				return pos;
			}
		}
		
		return pos;
	}
	
	public static String addEditor() {
		int pos = -1;
		String name, id;
		String message = "Oops! Editor is already registered.\n";
		
		name = getEditorName();
		id = getEditorId();
		pos = findEditor(id);
		
		if (pos == -1) {
			editors.add(new Editor(name, id));
			message = "Editor added successfully.\n";
		}
		
		return message;
	}
	
	public static String deleteEditor() {
		int pos;
		String id;
		String message = "There are no editors registered.\n";
		
		if (editors.size() != 0) {
			message = "This editor is not yet registered.\n";
			
			id = getEditorId();
			pos = findEditor(id);
			
			if (pos != -1) {
				editors.remove(pos);
				message = "Editor successfully deleted.\n";
			}	
		}
		
		return message;
	}
	
	public static String createNews() {
		
		int pos, sportOpt;
		String id, message = "There are no editors registered.\n";
		
		if (editors.size() != 0) {
			message = "This editor is not yet registered.\n";
			
			id = getEditorId();
			pos = findEditor(id);
			
			if (pos != -1) {
				do {
					System.out.println("What sport is it about?\n"
							+ "1. Football\n"
							+ "2. Basketball\n"
							+ "3. Tennis\n"
							+ "4. Formula 1\n"
							+ "5. Motorcycling\n");
					try { 
						sportOpt = en.nextInt();
					} catch (InputMismatchException e) {
						sportOpt = 0;
					}
				
					en.nextLine();		
					
					switch (sportOpt) {
					case 1:
						message = createFballNews(pos);
						break;
					case 2:
						message = createBballNews(pos);
						break;
					case 3:
						message = createTennisNews(pos);
						break;
					case 4:
						message = createF1News(pos);
						break;
					case 5:
						message = createMotoNews(pos);
						break;
					default:
						System.out.println("Please choose a valid option.\n");
						break;
					}
				} while (sportOpt < 1 || sportOpt >5);
			}	
		}
		return message;
	}
	
	public static String createFballNews(int pos) {
		String headline, comp, team, player;
		
		headline = getHeadline();
		comp = getComp();
		team = getTeam();
		player = getPlayer();
		
		editors.get(pos).setAllNews(new FballNews(headline, comp, team, player));
		
		return "Football news successsfully created.\n";
	}
	
	public static String createBballNews(int pos) {
		String headline, comp, team;
		
		headline = getHeadline();
		comp = getComp();
		team = getTeam();
		
		editors.get(pos).setAllNews(new BballNews(headline, comp, team));
		
		return "Basketball news successfully created.\n";
	}
	
	public static String createTennisNews(int pos) {
		String headline, comp, player;
		
		headline = getHeadline();
		comp = getComp();
		player = getPlayer();
		
		editors.get(pos).setAllNews(new TennisNews(headline, comp, player));
		
		return "Tennis news successfully created.\n";
	}
	
	public static String createF1News(int pos) {
		String headline, comp;
		
		headline = getHeadline();
		comp = getComp();
		
		editors.get(pos).setAllNews(new F1News(headline, comp));
		
		return "Formula 1 news successfully created.\n";
	}
	
	public static String createMotoNews(int pos) {
		String headline, comp;
		
		headline = getHeadline();
		comp = getComp();
		
		editors.get(pos).setAllNews(new MotoNews(headline, comp));
		
		return "Motorcycle news successfully created.\n";
	}
	
	public static String showNews() {
		int pos = -1;
		
		String id;
		String message = "There are no editors registered.\n";
		
		if (editors.size() != 0) {
			id = getEditorId();
			pos = findEditor(id);
			message = "This editor is not registered.\n";
			
			if (pos != -1) {
				message = "The editor has no news registered.\n";
				
				if (editors.get(pos).getAllNews().size() != 0) {
					message = "";
					for (int i = 0; i < editors.get(pos).getAllNews().size(); i++) {
						News eachNews = editors.get(pos).getAllNews().get(i);
						message += "News #" + (i+1) + ":\n" + eachNews.toString() + "\n";
					}
				}
			}
		}
		
		return message;
	}
	
	public static String deleteNews() {
		int pos = -1;
		String id, headline;
		String message = "There are no editors registered.\n";
		boolean found = false;
		
		if (editors.size() != 0) {
			id = getEditorId();
			pos = findEditor(id);
			message = "This editor is not registered.\n";
			
			if (pos != -1) {
				message = "The editor has no news registered.\n";
				
				if (editors.get(pos).getAllNews().size() != 0) {
					headline = getHeadline();
					message = "This editor's news is not registered.\n";
					
					int i = 0;
					while (i < editors.get(pos).getAllNews().size() && !found) {
						News eachNews = editors.get(pos).getAllNews().get(i);
						if (eachNews.getHeadline().equalsIgnoreCase(headline)) {
							editors.get(pos).getAllNews().remove(i);
							found = true;
							message = "News succefully deleted.\n";
						} else {
							i++;
						}
					}
				}
			}
		}	
		return message;
	}
	
	
	public static String calcPoints() {
		int pos = -1;
		String id, headline;
		String message = "There are no editors registered.\n";
		boolean found = false;
		
		if (editors.size() != 0) {
			id = getEditorId();
			pos = findEditor(id);
			message = "This editor is not registered.\n";
			
			if (pos != -1) {
				message = "The editor has no news registered.\n";
				
				if (editors.get(pos).getAllNews().size() != 0) {
					headline = getHeadline();
					message = "This editor's news is not registered.\n";
					
					int i = 0;
					do {
						News eachNews = editors.get(pos).getAllNews().get(i);
						if (eachNews.getHeadline().equalsIgnoreCase(headline)) {
							message = "Points: " + editors.get(pos).getAllNews().get(i).calcNewsPoints() + "\n";
							found = true;
						} else {
							i++;
						}
					} while (!found && i < editors.get(pos).getAllNews().size());
					
				}
			}
		}
		return message;
	}
	
	public static String calcPrice() {
		int pos = -1;
		String id, headline;
		String message = "There are no editors registered.\n";
		boolean found = false;
		
		if (editors.size() != 0) {
			id = getEditorId();
			pos = findEditor(id);
			message = "This editor is not registered.\n";
			
			if (pos != -1) {
				message = "The editor has no news registered.\n";
				
				if (editors.get(pos).getAllNews().size() != 0) {
					headline = getHeadline();
					message = "This editor's news is not registered.\n";
					
					int i = 0;
					while (i < editors.get(pos).getAllNews().size() && !found) {
						News eachNews = editors.get(pos).getAllNews().get(i);
						if (eachNews.getHeadline().equalsIgnoreCase(headline)) {
							message = "Price: " + editors.get(pos).getAllNews().get(i).calcNewsPrice() + "\n";
							found = true;
						} else {
							i++;
						}
					}
				}
			}
		}
		return message;
	}
	
	
	
}
