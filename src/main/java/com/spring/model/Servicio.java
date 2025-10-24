package com.spring.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private String duracion;
    private Double precio;

    // Relación con citas
    @OneToMany(mappedBy = "servicio")
    private List<Cita> citas;

    // Constructores
    public Servicio() {}

    public Servicio(Integer id, String nombre, String descripcion, String duracion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    // toString
    @Override
    public String toString() {
        return "Servicio [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
    }
}
