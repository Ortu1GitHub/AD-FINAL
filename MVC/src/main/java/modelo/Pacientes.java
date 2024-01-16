package modelo;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "pacientes")
public class Pacientes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "sip")
    public String sip;
    @Column(name = "dni")
    public String dni;
    @Column(name = "nombre")
    public String nombre;
    @Column(name = "apellido1")
    public String apellido1;
    @Column(name = "apellido2")
    public String apellido2;
    @Column(name = "telefono")
    public String telefono;
    @Column(name = "calle")
    public String direccion;
    @Column(name = "localidad")
    public String localidad;
    @Column(name = "fecha_nacimiento")
    public String fecha_nacimiento;

    public Pacientes() {
    }

    public Pacientes(String dni, String nombre, String apellido1, String apellido2, String telefono, String direccion, String localidad, String fecha_nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getDNI() {
        return this.dni;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public String getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public String getSip() {
        return this.sip;
    }
}
