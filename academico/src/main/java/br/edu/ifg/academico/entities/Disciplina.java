package br.edu.ifg.academico.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Disciplina implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddisciplina;

    @Column(name = "nomedisciplina", nullable = false)
    private String nomedisciplina;

    @Column(name = "cargahoraria", nullable = false)
    private Integer cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(Integer iddisciplina, String nomedisciplina, Integer cargaHoraria) {
        this.iddisciplina = iddisciplina;
        this.nomedisciplina = nomedisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getNomedisciplina() {
        return nomedisciplina;
    }

    public void setNomedisciplina(String nomedisciplina) {
        this.nomedisciplina = nomedisciplina;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddisciplina, nomedisciplina, cargaHoraria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disciplina that = (Disciplina) obj;
        return Objects.equals(iddisciplina, that.iddisciplina)
                && Objects.equals(nomedisciplina, that.nomedisciplina)
                && Objects.equals(cargaHoraria, that.cargaHoraria);
    }

    @Override
    public String toString() {
        return "Disciplina [iddisciplina=" + iddisciplina + ", nomedisciplina=" + nomedisciplina +
                ", cargaHoraria=" + cargaHoraria + "]";
    }
}
