package model.dto;

public class Subway extends Transportation {

	private String id;
	private int priceAB;
	private int priceBC;
	private int priceAC;
	
	public Subway() {}

	public Subway(String id, int priceAB, int priceBC, int priceAC) {
		super();
		this.id = id;
		this.priceAB = priceAB;
		this.priceBC = priceBC;
		this.priceAC = priceAC;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPriceAB() {
		return priceAB;
	}

	public void setPriceAB(int priceAB) {
		this.priceAB = priceAB;
	}

	public int getPriceBC() {
		return priceBC;
	}

	public void setPriceBC(int priceBC) {
		this.priceBC = priceBC;
	}

	public int getPriceAC() {
		return priceAC;
	}

	public void setPriceAC(int priceAC) {
		this.priceAC = priceAC;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subway [id=");
		builder.append(id);
		builder.append(", priceAB=");
		builder.append(priceAB);
		builder.append(", priceBC=");
		builder.append(priceBC);
		builder.append(", priceAC=");
		builder.append(priceAC);
		builder.append("]");
		return builder.toString();
	}

	

	
}
