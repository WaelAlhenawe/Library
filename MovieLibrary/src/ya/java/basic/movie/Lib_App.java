package ya.java.basic.movie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lib_App {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Boolean ok = true;
		input.useDelimiter(System.getProperty("line.separator"));

		Library<Movie> lib = new M_Library();
//		config(lib);
		System.out.println("Library Program has been configured with 12 movies");

		do {
			int choice = mainMenu();

			switch (choice) {
			case 1 : case 3 :
				lib.showLibraryContents();
				if (choice == 3) {
					removing(lib);
				}
				break;
			case 2:
				lib.addItem(creatMovieMenu());
				break;
			case 4:
				List <Movie> result;
				result = lib.searchItem();
				if (result.equals(Collections.emptyList())) continue;
				else {
					for ( Movie m : result) {
						System.out.println(m);
					}
				}
				break;
			case 5:
				lib.storeItemsToTextfile("database.txt");
				System.out.println("All Data has been Saved To Text File");
				break;
			case 6:
				lib.readItemsFromTextfile("database.txt");
				break;
			case 0:
				ok = false;
				break;

			}
		} while (ok);


	}

	private static void config(Library<Movie> temp) {


		Movie[] bondMovies = new Movie[17];

		bondMovies[0] = new Movie("Dr No", "Sean Connory", 1962, 109);
		bondMovies[1] = new Movie("From Russia with Love", "Sean Connory", 1963, 115);
		bondMovies[2] = new Movie("Goldfinger", "Sean Connory", 1964, 110);
		bondMovies[3] = new Movie("Thunderball", "Sean Connory", 1965, 130);
		bondMovies[4] = new Movie("Live and Let Die", "Roger Moore", 1973, 121);
		bondMovies[5] = new Movie("Moonraker", "Roger Moore", 1979, 126);
		bondMovies[6] = new Movie("Octopussy", "Roger Moore", 1983, 131);
		bondMovies[7] = new Movie("Golden Eye", "Pierce Brosnan", 1995, 130);	
		bondMovies[8] = new Movie("Tomorrow Never Dies", "Pierce Brosnan", 1997, 119);
		bondMovies[9] = new Movie("Casino Royale", "Daniel Craig", 2006, 144);		
		bondMovies[10] = new Movie("Skyfall", "Daniel Craig", 2012, 143);
		bondMovies[11] = new Movie("Spectre", "Daniel Craig", 2015, 148);	

		bondMovies[12] = new Movie("King Kong", "Naomi Watts", 2005, 187);	
		bondMovies[13] = new Movie("King Kong", "Fay Wray", 1933, 100);
		bondMovies[14] = new Movie("King Kong", "Jeff Bridges", 1976, 134);

		bondMovies[15] = new Movie("Movie Name", "The Main Actor", 2000, 134);
		bondMovies[16] = new Movie("Movie Name", "The Main Actor", 2000, 136);

		Arrays.sort(bondMovies);

		for(int i=0; i<bondMovies.length; i++){
			temp.addItem(bondMovies[i]);
		}
	}

	private static int mainMenu() {
		boolean ok = false;
		int choice=-1;
		do {
			if (ok) {
				System.out.println();
				System.out.println("   ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
				System.out.println(">> ONLY DIGITS FROM 0 TO 4 ALLOWED <<<");
				System.out.println("   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println();
			}
			System.out.println("*******************************");
			System.out.println("1 - Present complete contents");
			System.out.println("2 - Add Movie to library");
			System.out.println("3 - Remove Movie from library");
			System.out.println("4 - Search for a Movie");
			System.out.println("5 - Store current library contents in textfile");
			System.out.println("6 - Read contents from textfile to library");
			System.out.println("0 - Exit application");
			System.out.println("*******************************");
			System.out.print("Please Enter the Number of your Choice: ");

			try {
				ok = false;
				choice = input.nextInt();
			} catch (NumberFormatException e) {
				ok = true;
			}
			System.out.println("*******************************");

			if (!(choice >= 0 && choice <= 6)) ok = true;
		}
		while (ok);

		return choice;
	}


	private static Movie creatMovieMenu() {
		int year , length;
		Movie temp = null;
		Boolean falg = false;

		try {
			do{
				System.out.print("Enter The Movie Title: ");
				String name = input.next();
				System.out.print("Enter The Movie Main Actor: ");
				String actor = input.next();
				System.out.print("Enter The Movie Production Year: ");
				try {
					year = input.nextInt();
				} catch (NumberFormatException e) {
					System.out.format("\nOnly Digits Allowed \nPLEASE TRY AGAIN\n\n");
					falg = true;
					break;
				}
				System.out.print("Enter The Movie Length: ");
				try {
					length = input.nextInt();
				} catch (NumberFormatException e) {
					System.out.format("\nOnly Digits Allowed \nPLEASE TRY AGAIN\n\n ");
					falg = true;
					break;
				}
				temp =  new Movie(name, actor, year, length);
			}
			while(falg);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("*******************************");
		}
		return  temp;

	}

	private static void removing(Library<Movie> lib) {
		int recivedID = 0;
		Boolean flag = true;
		String temp;
		do {
			System.out.println("****************************");
			System.out.print("Please Enter The Movie ID: ");
			temp = input.next();
			System.out.println("****************************");

			flag = inputDigitsFilter(temp, "ONLY DIGITS ALLOWED");

		} while (!flag);
		recivedID = Integer.parseInt(temp);

		Movie tempMovie = lib.getItem(recivedID);
		if (tempMovie!=null) {
			System.out.println(tempMovie);
			lib.removeItem(tempMovie);
			System.out.println("This Movie has been removed form your Library");
		}
		else {
			System.out.format("The Id you Entered (%d) Has not Found\nNo Change has been Happens to your Library\n", recivedID);
		}

	}

	protected static Boolean inputDigitsFilter (String Input, String errorMessage) {
		Boolean flag = true;
		try {
			@SuppressWarnings("unused")
			int recivedID = Integer.parseInt(Input);
		} catch (NumberFormatException e) {
			System.out.format("\n%s\n\n",errorMessage );
			flag = false;
		}
		return flag;
	}
}
//  g1G-%dd   Gh12nK
