package com.apirest.ofertaciclo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Turno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTURNO")
    private long idturno;
    @Basic
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public long getIdturno() {
        return idturno;
    }

    public void setIdturno(long idturno) {
        this.idturno = idturno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turno turno = (Turno) o;
        return idturno == turno.idturno && Objects.equals(descripcion, turno.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idturno, descripcion);
    }
}
