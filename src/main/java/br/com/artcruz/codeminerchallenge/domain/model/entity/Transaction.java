package br.com.artcruz.codeminerchallenge.domain.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author: Arthur Cruz
 */
@Entity
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@Column(name = "transaction_description")
	private String description;
	
	private Integer value;

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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getTransactionDescription() {
		return this.description + ": " + (value<0 ? "-" : "+") + "₭"+this.value;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", value=" + value + "]";
	}
}
