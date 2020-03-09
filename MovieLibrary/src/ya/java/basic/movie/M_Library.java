package ya.java.basic.movie;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ya.java.basic.movie.SearchHelper.SearchType;



public class M_Library implements Library<Movie>{



	private Map<String, List<Movie>> movieMapTree;

	/**
	 * @param movieList
	 */
	public M_Library() {
		this.movieMapTree = new TreeMap<>();
	}

	@Override
	public boolean addItem(Movie item) {
		boolean flag = false;
		if (movieMapTree.containsKey(item.getTitle())) {
			flag = true;
			List<Movie> temp = movieMapTree.get(item.getTitle());
			temp.add(item);
		}else {
			flag = true;
			List<Movie> temp = new ArrayList<>();
			temp.add(item);
			movieMapTree.putIfAbsent(item.getTitle(), temp);	
		}
		return flag;
	}
	@Override
	public boolean removeItem(Movie item) {
		return movieMapTree.get(item.getTitle()).remove(item);
	}

	@Override
	public int getNoOfItems() {
		return this.movieMapTree.size();

	}

	@Override
	public void showLibraryContents() {
		movieMapTree.forEach((k,v)-> v.forEach((s)->System.out.println(s)));
	}


	@Override
	public void storeItemsToTextfile(String filename)  {
		try (PrintWriter pW = new PrintWriter (new FileWriter(filename))){
			movieMapTree.forEach((k,v)-> v.forEach((s)-> pW.println(s)));
			}	
		
		catch (IOException ioe) {
			System.out.println("Exception occurred: "+ ioe);
		}

	}

	@Override
	public void readItemsFromTextfile(String filename)  {
		try(BufferedReader re = new BufferedReader(new FileReader(filename))){
			while(re.ready()) {
				this.addItem(parcing(re.readLine()));
			}
			
		} catch (IOException ioe) {
			System.out.println("Exception occurred: "+ ioe);
		} 
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
	List<Movie> searchLength(String searchedLength) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedLength.isBlank())) {
			try {
				int temp = Integer.parseInt(searchedLength);

				if (temp >= Movie.Min_Length) {
					Set<String> keys = movieMapTree.keySet();
					List <Movie> temps = new ArrayList<>();
					for(String k: keys) {
						temps = movieMapTree.get(k);
						for(Movie m: temps) {
							if (m.getLength()==temp) {
								result.add(m);
								resultflag = true;
							}
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
	List<Movie>   searchYear(String searchedYear) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedYear.isBlank())) {
			try {
				int temp = Integer.parseInt(searchedYear);

				if (temp >= Movie.Min_Year && temp <= Movie.Max_Year) {
					Set<String> keys = movieMapTree.keySet();
					List <Movie> temps = new ArrayList<>();
					for(String k: keys) {
						temps = movieMapTree.get(k);
						for(Movie m: temps) {
							if (m.getProductionYear()==temp) {
								result.add(m);
								resultflag = true;
							}
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
	List<Movie> searchActor(String searchedActor) {
		var result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedActor.isBlank())) {	
			Set<String> keys = movieMapTree.keySet();
			List <Movie> temps = new ArrayList<>();
			for(String k: keys) {
				temps = movieMapTree.get(k);
				for(Movie m: temps) {
					if (m.getMainActor().equalsIgnoreCase(searchedActor)) {
						result.add(m);
						resultflag = true;
					}
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
	List<Movie> searchTitle(String searchedTitle) {
		List<Movie> result = new ArrayList<Movie>();
		Boolean resultflag = false;
		if (!(searchedTitle.isBlank())) {	
			result = movieMapTree.get(Movie.fixMapKeyFormat(searchedTitle));
			if(result != null) {
				resultflag = true;
			}
		}

		else {
			System.out.println("You Entered NOTHING");
			result = Collections.emptyList();
			resultflag= true;
		}
		if (!resultflag) {
			result = Collections.emptyList();
			System.out.format("Sorry the Title you Had Entered (%s) did Not Found\n", searchedTitle);
		}
		return result;
	}

	/**
	 * @param searchedID
	 */
	List<Movie> searchID(String searchedID ){
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
		Set<String> keys = movieMapTree.keySet();
		for(String k: keys) {
			List <Movie> temps = new ArrayList<>();
			temps = movieMapTree.get(k);
			for(Movie m: temps) {
				if (m.getId()==movieId) {
					return m;
				}
			}
		}
		return null;
	}

	Movie parcing (String oneLine) {
		Movie temp =null;
		String [] parts = oneLine.split(":");
		for (int x = 2; x < parts.length; x++ ) {
			if (parts[x].contains(",")) {
				String []supParts = parts[x].split(",");
				parts[x] = supParts[0].substring(1, supParts[0].length());
			}else {
				parts[x] = parts[x].substring(0, parts[x].length()-1).strip();
			}
		}
		temp = new Movie(parts[2], parts[3],Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
		return temp;
	}
}


