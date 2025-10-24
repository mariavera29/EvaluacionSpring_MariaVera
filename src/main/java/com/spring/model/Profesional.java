package com.spring.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "profesional")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String especialidad;

    @Column(name = "horario_disponible")
    private LocalDateTime horarioDisponible;

    // Relación con usuario (cada profesional tiene un usuario base)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Relación con citas
    @OneToMany(mappedBy = "profesional")
    private List<Cita> citas;

    // Constructores
    public Profesional() {}

    public Profesional(Integer id, String especialidad, LocalDateTime horarioDisponible, Usuario usuario) {
        this.id = id;
        this.especialidad = especialidad;
        this.horarioDisponible = horarioDisponible;
        this.usuario = usuario;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public LocalDateTime getHorarioDisponible() { return horarioDisponible; }
    public void setHorarioDisponible(LocalDateTime horarioDisponible) { this.horarioDisponible = horarioDisponible; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    // toString
    @Override
    public String toString() {
        return "Profesional [id=" + id + ", especialidad=" + especialidad + ", usuario=" + usuario.getNombre() + "]";
    }
}
