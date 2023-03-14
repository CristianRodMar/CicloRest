package com.apirest.ofertaciclo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OfertaeducativaPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "IDIES", insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idies;
    @Column(name = "IDCICLO", insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idciclo;
    @Column(name = "IDTURNO", insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idturno;

    public long getIdies() {
        return idies;
    }

    public void setIdies(long idies) {
        this.idies = idies;
    }

    public long getIdciclo() {
        return idciclo;
    }

    public void setIdciclo(long idciclo) {
        this.idciclo = idciclo;
    }

    public long getIdturno() {
        return idturno;
    }

    public void setIdturno(long idturno) {
        this.idturno = idturno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfertaeducativaPK that = (OfertaeducativaPK) o;
        return idies == that.idies && idciclo == that.idciclo && idturno == that.idturno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idies, idciclo, idturno);
    }
}
