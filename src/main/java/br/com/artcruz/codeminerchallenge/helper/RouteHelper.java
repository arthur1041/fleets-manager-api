package br.com.artcruz.codeminerchallenge.helper;

public class RouteHelper {

	public RouteHelper() {
	
	}
	
	public RouteHelper(int planetFrom, int planetTo) {
		this.planetFrom = planetFrom;
		this.planetTo = planetTo;
	}
	
	public RouteHelper(int planetFrom, int planetTo, int fuelCost, boolean blocked) {
		this.planetFrom = planetFrom;
		this.planetTo = planetTo;
		this.fuelCost = fuelCost;
		this.blocked = blocked;
	}

	private int planetFrom;
	
	private int planetTo;
	
	private int fuelCost;
	
	private boolean blocked;

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

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + planetFrom;
		result = prime * result + planetTo;
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
		RouteHelper other = (RouteHelper) obj;
		if (planetFrom != other.planetFrom)
			return false;
		if (planetTo != other.planetTo)
			return false;
		return true;
	}
	
	
	
}
