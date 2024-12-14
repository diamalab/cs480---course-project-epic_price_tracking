package game.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Game {
	/*
	 * Correspond to the game table
	 */
	
	private String id;
	private String name;
	private String thumbnail; 
	private String price;
	
		
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Game [ name=" + name + ", thumbnail="
				+ thumbnail + ", price=" + price +"]";
	}
}
