package com.spring.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    private String estado;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    // Constructores
    public Cita() {}

    public Cita(Integer id, LocalDateTime fechaHora, String estado, Usuario usuario, Servicio servicio, Profesional profesional) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.usuario = usuario;
        this.servicio = servicio;
        this.profesional = profesional;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    public Profesional getProfesional() { return profesional; }
    public void setProfesional(Profesional profesional) { this.profesional = profesional; }

    // toString
    @Override
    public String toString() {
        return "Cita [id=" + id + ", fechaHora=" + fechaHora + ", estado=" + estado + "]";
    }
}
