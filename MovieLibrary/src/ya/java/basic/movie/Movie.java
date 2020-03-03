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
		result = prime * result + length;
		result = prime * result + ((mainActor == null) ? 0 : mainActor.hashCode());
		result = prime * result + productionYear;
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
		if ((mainActor.equals(other.mainActor))&&
				(title.equals(other.title))&&
				(productionYear == other.productionYear)&&
				(length == other.length)) {
			return true;
		}
		else {
				return false;
		} 
	}


	@Override
	public String toString() {
		return String.format("Movie [ Id: %d, Title: %s, Main Actor: %s, Production Year: %d, Length: %d]",id , title,
				mainActor, productionYear, length);
	}


	@Override
	public int compareTo(Movie that) {
		if ((this.title.compareTo(that.title)) != 0) {
			return this.title.compareTo(that.title);
		}
		else {	
			if ((this.productionYear - that.productionYear) != 0) {
				return this.productionYear - that.productionYear;
			}
			else {	
				if ((this.length - that.length) != 0) {
					return this.length - that.length;
				}
			}
		}
		return 0;
	}
}
