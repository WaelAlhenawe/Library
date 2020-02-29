package ya.java.basic.movie;

import java.io.Console;
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
		
		return result;
	}

	@Override
	public Movie getItem(int movieId) {
		for(Movie m: movieList) {
			int x = m.getId();
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
				choice = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				ok = false;
			}

			if (!(choice > 0 && choice < 5 )) ok = false;
		}
		while (!(choice > 0 && choice < 5 ));

		return choice;
	}



}
