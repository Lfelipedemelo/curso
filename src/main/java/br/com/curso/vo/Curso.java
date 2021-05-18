package br.com.curso.vo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sigla;
	@Column(nullable = false)
	private int totalHora;
	
	@ManyToOne
	@JoinColumn(name = "id_eixo", nullable = false)
	private Eixo eixo;
	@ManyToOne
	@JoinColumn(name = "id_Tipocurso", nullable = false)
	private TipoCurso tipoCurso;
	
	public Curso() {
		
	}

	public Curso(String nome, String sigla, int totalHora, Eixo eixo, TipoCurso tipoCurso) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.totalHora = totalHora;
		this.eixo = eixo;
		this.tipoCurso = tipoCurso;
	}

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getTotalHora() {
		return totalHora;
	}

	public void setTotalHora(int totalHora) {
		this.totalHora = totalHora;
	}

	public Eixo getEixo() {
		return eixo;
	}

	public void setEixo(Eixo eixo) {
		this.eixo = eixo;
	}

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
