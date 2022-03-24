package br.com.artcruz.codeminerchallenge.domain.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author: Arthur Cruz
 */
@Entity
public class Ship implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * entity's primary key
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * ships have a maximum capacity of fuel
	 * */
	@Column(name = "fuel_capacity", nullable = false)
	private Integer fuelCapacity;
	
	/**
	 * current fuel level of the ship
	 * */
	@Column(name="fuel_level")
	private Integer fuelLevel;
	
	/**
	 * maximum of tons a ship can handle (considering just the cargo)
	 * */
	@Column(name = "weight_capacity")
	private Integer weightCapacity;

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Pilot pilot;
	
	@OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL)
	private List<Contract> contracts = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Integer fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public Integer getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Integer fuelLevel) {
		if(fuelLevel > this.fuelCapacity)
			this.fuelLevel = fuelCapacity;
		else
			this.fuelLevel = fuelLevel;
	}

	public Integer getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(Integer weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Ship other = (Ship) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ship [id=" + id + ", fuelCapacity=" + fuelCapacity + ", fuelLevel=" + fuelLevel + ", weightCapacity="
				+ weightCapacity + "]";
	}
		
}
