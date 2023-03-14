package com.apirest.ofertaciclo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ciclo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCICLO")
    private long idciclo;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "GRADO")
    private String grado;

    public long getIdciclo() {
        return idciclo;
    }

    public void setIdciclo(long idciclo) {
        this.idciclo = idciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciclo ciclo = (Ciclo) o;
        return idciclo == ciclo.idciclo && Objects.equals(nombre, ciclo.nombre) && Objects.equals(grado, ciclo.grado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idciclo, nombre, grado);
    }
}
