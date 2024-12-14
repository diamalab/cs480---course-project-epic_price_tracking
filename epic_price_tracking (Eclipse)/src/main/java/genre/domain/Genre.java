package genre.domain;

/**
 * Genre object
 * 
 */
public class Genre {
	/*
	 * Correspond to the game table
	 */
	
	private String id;
	private String name;
	private String parentGenre; 
	
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentGenre() {
		return parentGenre;
	}

	public void setParentGenre(String parentGenre) {
		this.parentGenre = parentGenre;
	}

	
	@Override
	public String toString() {
		return "Genre [ name=" + name + ", parentGenre="
				+ parentGenre + "]";
	}
}
