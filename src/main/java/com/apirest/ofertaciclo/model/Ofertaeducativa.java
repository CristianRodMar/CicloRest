package com.apirest.ofertaciclo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@IdClass(OfertaeducativaPK.class)
public class Ofertaeducativa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    @Column(name = "IDIES")
    private long idies;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    @Column(name = "IDCICLO")
    private long idciclo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    @Column(name = "IDTURNO")
    private long idturno;
    @Basic
    @Column(name = "PLAZAS")
    private int plazas;
    @ManyToOne
    @JoinColumn(name = "IDIES", referencedColumnName = "IDIES", nullable = false)
    @JsonIgnore
    private Ies ies;
    @ManyToOne
    @JoinColumn(name = "IDCICLO", referencedColumnName = "IDCICLO", nullable = false)
    private Ciclo ciclo;
    @ManyToOne
    @JoinColumn(name = "IDTURNO", referencedColumnName = "IDTURNO", nullable = false)
    private Turno turno;

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

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ofertaeducativa that = (Ofertaeducativa) o;
        return idies == that.idies && idciclo == that.idciclo && idturno == that.idturno && Objects.equals(plazas, that.plazas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idies, idciclo, idturno, plazas);
    }

    public Ies getIes() {
        return ies;
    }

    public void setIes(Ies ies) {
        this.ies = ies;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
