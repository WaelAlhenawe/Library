package ya.java.basic.movie;

import java.util.Arrays;
import java.util.Scanner;

public class Lib_App {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

	//	int recivedID = 0;
		Boolean ok = true;//, flag = true;
	//	String temp;
		input.useDelimiter(System.getProperty("line.separator"));

		Library<Movie> lib = new M_Library();
		config(lib);
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
				break;
			case 0:
				ok = false;
				break;

			}
		} while (ok);


	}

	private static void config(Library<Movie> temp) {


		Movie[] bondMovies = new Movie[12];

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

		Arrays.sort(bondMovies);

		for(int i=0; i<bondMovies.length; i++){
			temp.addItem(bondMovies[i]);
		}
	}

	private static int mainMenu() {
		boolean ok = false;
		int choice=-1;
		String temp;
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
			System.out.println("0 - Exit application");
			System.out.println("*******************************");
			System.out.print("Please Enter the Number of your Choice: ");

			temp = input.next();
			System.out.println("*******************************");

			try {
				ok = false;
				choice = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				ok = true;
			}

			if (!(choice >= 0 && choice <= 4)) ok = true;
		}
		while (ok);

		return choice;
	}


	private static Movie creatMovieMenu() {
		int iPYear , iLength ;
		String name, mActor, sPYaer, slength;
		Movie temp = null;

		do{
			iPYear = 0;
			iLength = 0;
			while ((iPYear == 0 && iLength == 0)) {
				System.out.print("Enter The Movie Title: ");
				name = input.next();
				System.out.print("Enter The Movie Main Actor: ");
				mActor = input.next();
				System.out.print("Enter The Movie Production Year: ");
				sPYaer = input.next();
				try {
					iPYear = Integer.parseInt(sPYaer);
				} catch (NumberFormatException e) {
					System.out.format("\nThe Year You Have Entered Is Wrong \nPLEASE TRY AGAIN\n\n");
					break;
				}
				System.out.print("Enter The Movie Length: ");
				slength = input.next();
				try {
					iLength = Integer.parseInt(slength);
				} catch (NumberFormatException e) {
					System.out.format("\nThe Length You Have Entered Is Wrong \nPLEASE TRY AGAIN\n\n ");
					break;
				}

				temp =  new Movie(name, mActor, iPYear, iLength);
			}
		}
		while((iPYear == 0 && iLength == 0));
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

			try {
				flag = true;
				recivedID = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				System.out.format("\nONLY DIGITS ALLOWED\n\n");
				flag = false;
			}

		} while (!flag);

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
}
