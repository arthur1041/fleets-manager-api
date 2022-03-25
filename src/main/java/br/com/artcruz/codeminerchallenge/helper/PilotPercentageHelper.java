package br.com.artcruz.codeminerchallenge.helper;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: Arthur Cruz
 */
public class PilotPercentageHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	public Double total = 0.0;
	
	@JsonIgnore
	public Double food = 0.0;
	
	@JsonIgnore
	public Double water = 0.0;
	
	@JsonIgnore
	public Double minerals = 0.0;
	
	public String name;
	
	@JsonProperty("food")
	public String getFoodP() {
		 return new DecimalFormat("#.##").format((food/total)*100)+"%";
	}

	@JsonProperty("water")
	public String getWaterP() {
		return new DecimalFormat("#.##").format((water/total)*100)+"%";
	}

	@JsonProperty("minerals")
	public String getMinerals() {
		return new DecimalFormat("#.##").format((minerals/total)*100)+"%";
	}

	@Override
	public String toString() {
		return "PilotPercentageHelper [getFoodP()=" + getFoodP() + ", getWaterP()=" + getWaterP() + ", getMinerals()="
				+ getMinerals() + "]";
	}

	
}
