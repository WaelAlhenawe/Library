package ya.java.basic.movie;

import java.util.ArrayList;
import java.util.List;



public class M_Library implements Library<Movie>{

	private List <Movie> movieList;

	/**
	 * @param movieList
	 */
	public M_Library() {
		this.movieList = new ArrayList<>();
	}

	@Override
	public boolean addItem(Movie item) {
		return movieList.add(item);
	}

	@Override
	public boolean removeItem(Movie item) {
		return movieList.remove(item);
	}

	@Override
	public int getNoOfItems() {
		return this.movieList.size();

	}

	@Override
	public void showLibraryContents() {
		for(Movie m: movieList) {
			System.out.println(m);
		}

	}

	@Override
	public void storeItemsToTextfile(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readItemsFromTextfile(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> searchItem() {
		var result = new ArrayList<Movie>();
		int choice = searchMenu();
		Boolean errorInputflag = true;
		Boolean resultflag = false;

		int temp =0;
		switch (choice) {
		case 1:

			do {
				System.out.print("Please Enter the ID: ");
				String searchedId = Lib_App.input.next();
				System.out.println("***********************");
				errorInputflag = Lib_App.inputDigitsFilter(searchedId, "ONLY DIGITS ALLOWED");
				temp = Integer.parseInt(searchedId);

			} while (!errorInputflag);

			for(Movie m: movieList) {
				if (m.getId()==temp) {
					result.add(m);
					resultflag= true;
				}

			}
			if (!resultflag) {
				System.out.format("Sorry the ID you Had Entered (%d) did Not Found\n", temp);
			}
			break;

		case 2 :
			System.out.print("Please Enter the Movie Title: ");
			String searchedTitle = Lib_App.input.next();
			System.out.println("***********************");

			for(Movie m: movieList) {				
				if (m.getTitle().equalsIgnoreCase(searchedTitle)) {
					result.add(m);
					resultflag= true;
				}
			}
			if (!resultflag) {
				System.out.format("Sorry the Title you Had Entered (%s) did Not Found\n", searchedTitle);
			}
			break;

		case 3 :
			System.out.print("Please Enter Actor Name: ");
			String searchedActor = Lib_App.input.next();
			System.out.println("***********************");

			for(Movie m: movieList) {
				if (m.getMainActor().equalsIgnoreCase(searchedActor)){
					result.add(m);
					resultflag= true;

				}
			}
			if (!resultflag) {
				System.out.format("Sorry the Actor you Had Entered (%s) did Not Found\n", searchedActor);
			}
			break;
		case 4:
			do {
				System.out.print("Please Enter the Production Year: ");
				String searchedYear = Lib_App.input.next();
				System.out.println("***********************");
				errorInputflag = Lib_App.inputDigitsFilter(searchedYear, "ONLY DIGITS ALLOWED");
				temp = Integer.parseInt(searchedYear);

			} while (!errorInputflag);

			for(Movie m: movieList) {
				if (m.getProductionYear()==temp) {
					result.add(m);
					resultflag= true;
				}

			}
			if (!resultflag) {
				System.out.format("Sorry the Production Year you Had Entered (%d) did Not Found\n", temp);
			}
			break;
		case 5:
			do {
				System.out.print("Please Enter the Movie Lenght: ");
				String searchedLenght = Lib_App.input.next();
				System.out.println("***********************");
				errorInputflag = Lib_App.inputDigitsFilter(searchedLenght, "ONLY DIGITS ALLOWED");
				temp = Integer.parseInt(searchedLenght);

			} while (!errorInputflag);

			for(Movie m: movieList) {
				if (m.getLength()==temp) {
					result.add(m);
					resultflag= true;
				}

			}
			if (!resultflag) {
				System.out.format("Sorry the Movie Length you Had Entered (%d) did Not Found\n", temp);
			}
			break;
		case 0:
			break;

		}
		return result;
	}

	@Override
	public Movie getItem(int movieId) {
		for(Movie m: movieList) {
			if (m.getId()==movieId) {
				return m;
			}
		}
		return null;
	}

	private static int searchMenu() {
		boolean ok = true;
		int choice=-1;
		String temp;
		do {
			if (!ok) {
				System.out.println();
				System.out.println("   ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
				System.out.println(">> ONLY DIGITS FROM 0 TO 5 ALLOWED <<<");
				System.out.println("   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println();
			}
			System.out.println("***********************");
			System.out.println("_______Search By_______");
			System.out.println("1 - ID");
			System.out.println("2 - Title");
			System.out.println("3 - Main Actor");
			System.out.println("4 - Production Year");
			System.out.println("5 - Movie Length");
			System.out.println("0-  Go Back");
			System.out.println("***********************");

			System.out.print("Please Enter the Number of your Choice: ");

			temp = Lib_App.input.next();
			System.out.println("***********************");

			try {
				ok = false;
				choice = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				ok = true;
			}

			if (!(choice >= 0 && choice <= 5)) ok = true;
		}
		while (ok);

		return choice;
	}



}
