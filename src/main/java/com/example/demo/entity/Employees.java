package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "TBL_EMPLOYEES")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employees {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	@NotNull
	private String nombre;
	@Column(name = "a_paterno")
	@NotNull
	private String apellidoPaterno;
	@Column(name = "a_materno")
	@NotNull
	private String apellidoMaterno;
	@Column(name = "puesto")
	@NotNull
	private String puesto;
	
	
	public Employees() {
		super();
	}
	
	public Employees(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
			String puesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.puesto = puesto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonProperty("apaterno")
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	@JsonProperty("amaterno")
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	@JsonProperty("puesto")
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}
