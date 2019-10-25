package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Time")
public class Time implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int Id;
	@Column(name = "Nome", nullable = false, length = 45)
	private String Nome;
	@Column
	private double Valor;
	@ManyToMany (mappedBy = "Times")
	private List<Aposta> apostas;
	
	
	public Time() {
	}

	
	
	public Time(int Id, String Nome, double Valor) {
		this.Id = Id;
		this.Nome = Nome;
		this.Valor = Valor;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public double getValor() {
		return Valor;
	}



	public void setValor(double valor) {
		Valor = valor;
	}



	public List<Aposta> getApostas() {
		return apostas;
	}



	public void setApostas(List<Aposta> apostas) {
		this.apostas = apostas;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}