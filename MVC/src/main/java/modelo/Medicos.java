package modelo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medicos")
public class Medicos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "numero_colegiado")
    public String numero_colegiado;
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
    @Column(name = "especialidad_id")
    public int especialidad_id;

    public Medicos() {
    }

    public Medicos(String numero_colegiado, String dni, String nombre, String apellido1, String apellido2, String telefono, int especialidad_id) {
        this.numero_colegiado = numero_colegiado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.especialidad_id = especialidad_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero_colegiado(String numero_colegiado) {
        this.numero_colegiado = numero_colegiado;
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

    public void setEspecialidad_id(int especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNumero_colegiado() {
        return this.numero_colegiado;
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

    public int getEspecialidad() {
        return this.especialidad_id;
    }

    public String getDNI() {
        return this.dni;
    }
}
