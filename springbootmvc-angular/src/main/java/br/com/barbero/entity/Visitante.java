package br.com.barbero.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="visitante")
public class Visitante implements Serializable{
	
	private static final long serialVersionUID = 8969465050941040656L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic
	private Long id;
	
	@NotNull
	@NotEmpty
	@Column
	private String nome;
	
	@NotNull
	@NotEmpty
	@Column
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dataVisita;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataVisita() {
		return dataVisita;
	}
	
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	
}