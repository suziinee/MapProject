package model.dto;

public class Route {

	private Object transportation1;
	private Object transportation2;
	private Object transportation;
	private String name;
	
	public Route() {}

	public Route(String name, Object transportation1, Object transportation2) {
		this.name = name;
		this.transportation1 = transportation1;
		this.transportation2 = transportation2;
	}
	
	public Route(String name, Object transportation) {
		this.name = name;
		this.transportation = transportation;
	}

	public Object getTransportation1() {
		return transportation1;
	}

	public void setTransportation1(Object transportation1) {
		this.transportation1 = transportation1;
	}

	public Object getTransportation2() {
		return transportation2;
	}

	public void setTransportation2(Object transportation2) {
		this.transportation2 = transportation2;
	}

	public Object getTransportation() {
		return transportation;
	}

	public void setTransportation(Object transportation) {
		this.transportation = transportation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" ");
		
		if(transportation1 != null && transportation2 != null) {
			builder.append("[AB구간 - (");
			builder.append(((Transportation)transportation1).getId() + " / " + ((Transportation)transportation1).getPriceAB() + "원");
			builder.append("), BC 구간 - (");
			builder.append(((Transportation)transportation2).getId() + " / " + ((Transportation)transportation2).getPriceBC() + "원");
			builder.append(")] ");
			builder.append("[총요금 : ");
			builder.append(((Transportation)transportation1).getPriceAB() + ((Transportation)transportation2).getPriceBC() + "원]");
		}
		
		if(transportation != null) {
			builder.append("[AC 구간 - (");
			builder.append(((Transportation)transportation).getId() + " / " + ((Transportation)transportation).getPriceAB() + "원");
			builder.append(")] ");
			builder.append("[총요금 : ");
			builder.append(((Transportation)transportation).getPriceAC() + "원]");
		}
		
		return builder.toString();
	}

	
	

}
