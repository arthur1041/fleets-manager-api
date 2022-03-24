package br.com.artcruz.codeminerchallenge.helper;

public class RouteHelper {

	public RouteHelper() {
	
	}
	
	public RouteHelper(int planetFrom, int planetTo, int fuelCost) {
		this.planetFrom = planetFrom;
		this.planetTo = planetTo;
		this.fuelCost = fuelCost;
	}

	private int planetFrom;
	
	private int planetTo;
	
	private int fuelCost;

	public int getPlanetFrom() {
		return planetFrom;
	}

	public void setPlanetFrom(int planetFrom) {
		this.planetFrom = planetFrom;
	}

	public int getPlanetTo() {
		return planetTo;
	}

	public void setPlanetTo(int planetTo) {
		this.planetTo = planetTo;
	}

	public int getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(int fuelCost) {
		this.fuelCost = fuelCost;
	}
	
	
	
}
