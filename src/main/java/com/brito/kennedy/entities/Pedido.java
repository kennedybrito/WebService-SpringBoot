package com.brito.kennedy.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Instant moment;
	
	// relacionamento muitos pra um
	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Usuario client;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant moment, Usuario client) {
		super();
		Id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getClient() {
		return client;
	}

	public void setClient(Usuario client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(Id, other.Id);
	}
	
	

}