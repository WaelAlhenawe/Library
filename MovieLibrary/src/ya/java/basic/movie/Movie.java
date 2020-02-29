package ya.java.basic.movie;


public class Movie implements Comparable<Movie>{

	private static int uniqueNo=0;
	private final String title;
	private final String mainActor;
	private final int productionYear;
	private final int length;
	private final int id;

	
	/**
	 * @param id
	 * @param name
	 * @param mainActor
	 * @param productionYear
	 * @param length
	 */
	public Movie(String title, String mainActor, int productionYear, int length) {
		id = ++uniqueNo;
		this.title = title;
		this.mainActor = mainActor;
		this.productionYear = productionYear;
		this.length = length;
	}
	
	
	/**
	 * @return the name
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the mainActor
	 */
	public String getMainActor() {
		return mainActor;
	}
	/**
	 * @return the productionYear
	 */
	public int getProductionYear() {
		return productionYear;
	}
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * @return the elementNo
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Movie [ Id: %d Title: %s, Main Actor: %s, Production Year: %d, Length: %d]",id , title,
				mainActor, productionYear, length);
	}


	@Override
	public int compareTo(Movie that) {
		return this.length - that.length;
	}
	

	

	
	
	
	


	

}
