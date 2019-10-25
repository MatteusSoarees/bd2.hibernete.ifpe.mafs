package modelo;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Aposta")
public class Aposta  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int Codigo;
	@Column(name = "Nome", nullable = false, length = 45)
	private String Nome;
	@Column
	private String Data;
	@Column
	private double ValorTotal;
	@Column
	private String Hora;
	@ManyToMany
	@JoinTable(name = "Tem",
	joinColumns = @JoinColumn(name = "Codigo"),
	inverseJoinColumns = @JoinColumn (name = "Id"))
	private List<Time> Times;
	
	
	public Aposta() {

	}


	public Aposta(int Codigo, String Nome, String Data, double ValorTotal, String Hora) {
		this.Codigo = Codigo;
		this.Nome = Nome;
		this.Data = Data;
		this.ValorTotal = ValorTotal;
		this.Hora = Hora;
		
	}


	public int getCodigo() {
		return Codigo;
	}


	public void setCodigo(int codigo) {
		Codigo = codigo;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getData() {
		return Data;
	}


	public void setData(String data) {
		Data = data;
	}


	public double getValorTotal() {
		return ValorTotal;
	}


	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}


	public String getHora() {
		return Hora;
	}


	public void setHora(String hora) {
		Hora = hora;
	}


	public List<Time> getTimes() {
		return Times;
	}


	public void setTimes(List<Time> times) {
		Times = times;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}