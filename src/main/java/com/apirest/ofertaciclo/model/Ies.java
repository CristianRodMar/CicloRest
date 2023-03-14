package com.apirest.ofertaciclo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//import com.apirest.ofertaciclo.model.Ofertaeducativa;

@Entity
public class Ies {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDIES")
    private long idies;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "ies")
    private List<Ofertaeducativa> ofertaeducativa;

    public long getIdies() {
        return idies;
    }

    public void setIdies(long idies) {
        this.idies = idies;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ies ies = (Ies) o;
        return idies == ies.idies && Objects.equals(nombre, ies.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idies, nombre);
    }

    public List<Ofertaeducativa> getOfertaeducativa() {
        return ofertaeducativa;
    }

    public void setOfertaeducativa(List<Ofertaeducativa> ofertaeducativa) {
        this.ofertaeducativa = ofertaeducativa;
    }
}
