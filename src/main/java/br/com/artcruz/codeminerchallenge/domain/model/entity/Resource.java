package br.com.artcruz.codeminerchallenge.domain.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author: Arthur Cruz
 */
@Entity
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * entity's primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * how many tons of that resource
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * the name of the resource
	 */
	@Column(nullable = false)
	private Integer weight;

	
//	@JsonBackReference(value = "resource-contract")
	@ManyToOne
	@JoinColumn
	private Contract contract;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
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
		Resource other = (Resource) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", weight=" + weight + ", contract=" + contract + "]";
	}
	
}
