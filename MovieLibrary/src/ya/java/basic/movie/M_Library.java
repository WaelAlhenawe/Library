package ya.java.basic.movie;


import java.util.ArrayList;
import java.util.List;



public class M_Library implements Library<Movie>{

	enum SearchType {ID, TITLE, ACTOR, YEAR, LENGHT, GO_BACK}


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
		List<Movie> result = new ArrayList<Movie>();
		SearchType choice = SearchHelper.searchCLI();

		switch (choice) {
		case ID:
			return searchID(SearchHelper.userSearchInput("Please Enter the ID: "));

		case TITLE :
			return searchTitle(SearchHelper.userSearchInput("Please Enter the Movie Title: "));

		case ACTOR :
			return searchActor(SearchHelper.userSearchInput("Please Enter Actor Name: "));

		case YEAR:
			return searchYear(SearchHelper.userSearchInput("Please Enter the Production Year: "));

		case LENGHT:
			return searchLength(SearchHelper.userSearchInput("Please Enter the Movie Lenght: "));

		default:
			return result;
		}
	}

	/**
	 * @param searchedLength
	 */
	public List<Movie> searchLength(String searchedLength) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedLength.isBlank())) {
			try {
				int temp = Integer.parseInt(searchedLength);

				if (temp >= Movie.Min_Length) {
					for (Movie m : movieList) {
						if (m.getLength() == temp) {
							result.add(m);
							resultflag = true;
						}
					}
				} else {
					System.out.format("Only Lenght %d and More are Available", Movie.Min_Length);
					resultflag = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("ONLY POSITIVE NUMBER ALLOWED");
			} 
		}
		else {
			System.out.println("You Entered NOTHING");
			resultflag= true;
		}
		if (!resultflag) {
			System.out.format("Sorry the Movie Length you Had Entered (%s) did Not Found\n", searchedLength);
		}
		return result;

	}


	/**
	 * @param searchedYear
	 */
	public List<Movie>   searchYear(String searchedYear) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedYear.isBlank())) {
			try {
				int temp = Integer.parseInt(searchedYear);

				if (temp >= Movie.Min_Year && temp <= Movie.Max_Year) {
					for (Movie m : movieList) {
						if (m.getProductionYear() == temp) {
							result.add(m);
							resultflag = true;
						}
					}
				} else {
					System.out.format("Only Years from %d to %d are Available", Movie.Min_Year, Movie.Max_Year);
					resultflag = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("ONLY POSITIVE NUMBER ALLOWED");
			} 
		}
		else {
			System.out.println("You Entered NOTHING");
			resultflag= true;
		}
		if (!resultflag) {
			System.out.format("Sorry the Production Year you Had Entered (%s) did Not Found\n", searchedYear);
		}

		return result;
	}
	/**
	 * @param searchedActor
	 */
	public List<Movie> searchActor(String searchedActor) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedActor.isBlank())) {			
			for(Movie m: movieList) {
				if (m.getMainActor().equalsIgnoreCase(searchedActor)){
					result.add(m);
					resultflag= true;
				}
			}
		}
		else {
			System.out.println("You Entered NOTHING");
			resultflag= true;
		}
		if (!resultflag) {
			System.out.format("Sorry the Actor you Had Entered (%s) did Not Found\n", searchedActor);
		}
		return result;
	}

	/**
	 * @param searchedTitle
	 */
	public List<Movie> searchTitle(String searchedTitle) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedTitle.isBlank())) {	
			for(Movie m: movieList) {				
				if (m.getTitle().equalsIgnoreCase(searchedTitle)) {
					result.add(m);
					resultflag= true;
				}
			}
		}
		else {
			System.out.println("You Entered NOTHING");
			resultflag= true;
		}
		if (!resultflag) {
			System.out.format("Sorry the Title you Had Entered (%s) did Not Found\n", searchedTitle);
		}
		return result;
	}

	/**
	 * @param searchedID
	 */
	public List<Movie> searchID(String searchedID ){
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;

		if (!(searchedID.isBlank())) {
			try {
				int temp = Integer.parseInt(searchedID);
				if (temp > 0) {
					result.add(this.getItem(temp));
					resultflag = true;
				} else {
					System.out.println("ONLY POSITIVE DIGITS ALLOWED");
				}
			} catch (NumberFormatException e) {
				System.out.println("ONLY POSITIVE DIGITS ALLOWED");
				resultflag = true;
			} 
		}
		else {
			System.out.println("You Entered NOTHING");
			resultflag= true;
		}
		if (!resultflag) {
			System.out.format("Sorry the ID you Had Entered (%s) did Not Found\n", searchedID);
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




}
