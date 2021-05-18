package br.com.curso.vo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int totalHora;
	@ManyToOne
	@JoinColumn(name = "id_professor", nullable = false)
	private Professor professor;
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;
	
	public Disciplina() {
		
	}

	public Disciplina(String nome, int totalHora, Professor professor, Curso curso) {
		super();
		this.nome = nome;
		this.totalHora = totalHora;
		this.professor = professor;
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalHora() {
		return totalHora;
	}

	public void setTotalHora(int totalHora) {
		this.totalHora = totalHora;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Disciplina other = (Disciplina) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
