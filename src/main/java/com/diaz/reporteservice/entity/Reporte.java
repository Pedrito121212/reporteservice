package com.diaz.reporteservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(length = 255)
    private String referencia;

    @Column(nullable = false)
    private Integer estado = 1;

    public Reporte() {}

    public Reporte(Integer id, String dni, String fecha, String tipo, String direccion, String referencia, Integer estado) {
        this.id = id;
        this.dni = dni;
        this.fecha = fecha;
        this.tipo = tipo;
        this.direccion = direccion;
        this.referencia = referencia;
        this.estado = estado != null ? estado : 1;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}
