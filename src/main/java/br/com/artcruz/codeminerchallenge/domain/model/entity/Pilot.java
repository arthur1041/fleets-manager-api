package br.com.artcruz.codeminerchallenge.domain.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author: Arthur Cruz
 */
@Entity
public class Pilot implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * entity's primary key
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * the identification document permission to fly a ship
	 * */
	@Column(name = "pilot_certification", length = 7, nullable = false)
	private String pilotCertification;
	
	/**
	 * pilot name
	 * */
	@Column(nullable = false)
	private String name;
	
	/**
	 * pilot age
	 * */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	/**
	 * amount of money owned by the pilot
	 * */
	private Integer credits;

	/**
	 * name the current planet where the fly is
	 * */
	@Column(name = "location_planet")
	private String locationPlanet;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL)
	private List<Ship> ships = new ArrayList<Ship>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL)
	private List<Contract> contracts = new ArrayList<Contract>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPilotCertification() {
		return pilotCertification;
	}

	public void setPilotCertification(String pilotCertification) {
		this.pilotCertification = pilotCertification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthdate) {
		this.birthDate = birthdate;
	}
	
	public int getAge() {
		LocalDate currentDate = LocalDate.now();
		
		if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public void addCredits(Integer credits) {
		this.credits += credits;
	}
	
	public String getLocationPlanet() {
		return locationPlanet;
	}

	public void setLocationPlanet(String locationPlanet) {
		this.locationPlanet = locationPlanet;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
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
		Pilot other = (Pilot) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", pilotCertification=" + pilotCertification + ", name=" + name + ", age=" + birthDate
				+ ", credits=" + credits + ", locationPlanet=" + locationPlanet + "]";
	}
	
}
