package br.com.artcruz.codeminerchallenge.domain.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.util.Utils;

/**
 * @author: Arthur Cruz
 */
@Entity
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * entity's primary key
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * a description of what that contract is for. (e.g water and food to calas)
	 * */
	@Column(nullable = false)
	private String description;	
	
	/**
	 * the actual cargo to be transported
	 * */
	@OneToMany(mappedBy = "contract", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Resource> payload = new ArrayList<Resource>();
	
	/**
	 * planet where the container should be taken
	 * */
	@Column(name = "origin_planet", nullable = false)
	private String originPlanet;
	
	/**
	 * planet where the pilot should take the container
	 * */
	@Column( name = "destination_planet", nullable = false)
	private String destinationPlanet;
	
	/**
	 * represents if a contract is accepted or not
	 * */
	@JsonIgnore
	private Boolean accepted;
	
	/**
	 * represents if a contract is accepted or not
	 * */
	@JsonIgnore
	private Boolean accomplished;
	
	/**
	 * quantity of credits offered as payment for the contract
	 * */
	@Column(nullable = false)
	private Integer value;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private Pilot pilot;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Resource> getPayload() {
		return payload;
	}

	public void setPayload(List<Resource> payload) {
		this.payload = payload;
	}

	public String getOriginPlanet() {
		return originPlanet;
	}

	public void setOriginPlanet(String originPlanet) {
		if(!Utils.validatePlanetName(originPlanet)) {
			this.originPlanet = PlanetEnum.ANDVARI.label;
		} else {
			this.originPlanet = originPlanet != null ? originPlanet.toLowerCase() : originPlanet;
		}
	}

	public String getDestinationPlanet() {
		return destinationPlanet;
	}

	public void setDestinationPlanet(String destinationPlanet) {
		if(!Utils.validatePlanetName(destinationPlanet)) {
			this.destinationPlanet = PlanetEnum.ANDVARI.label;
		} else {
			this.destinationPlanet = destinationPlanet != null ? destinationPlanet.toLowerCase() : destinationPlanet;
		}
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}
	
	public Boolean getAccomplished() {
		return accomplished;
	}

	public void setAccomplished(Boolean accomplished) {
		this.accomplished = accomplished;
	}
	
	public int getResourcesTotalWeight() {
		int totalWeight = 0;
		for (Resource resource : payload) {
			totalWeight += resource.getWeight();
		}
		
		return totalWeight;
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
		Contract other = (Contract) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", description=" + description + ", payload=" + payload + ", originPlanet="
				+ originPlanet + ", destinationPlanet=" + destinationPlanet + ", value=" + value + "]";
	}
}
