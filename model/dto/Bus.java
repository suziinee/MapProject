package model.dto;

public class Bus extends Transportation {

	private String id;
	private int priceAB;
	private int priceBC;
	private int priceAC;

	public Bus(String id, int priceAB, int priceBC, int priceAC) {
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
		return "Bus [id=" + id + ", priceAB=" + priceAB + ", priceBC=" + priceBC + ", priceAC=" + priceAC + "]";
	}

}
