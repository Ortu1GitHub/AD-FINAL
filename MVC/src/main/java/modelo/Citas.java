package modelo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "citas")
public class Citas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "medico_id")
    public String medico_id;

    @Column(name = "paciente_id")
    public String paciente_id;

    @Column(name = "fecha")
    public String fecha;

    @Column(name = "created_at")
    public String created_at;

    public Citas() {
    }

    public Citas(String medico_id, String paciente_id, String fecha, String created_at) {
        this.medico_id = medico_id;
        this.paciente_id = paciente_id;
        this.fecha = fecha;
        this.created_at = created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedico_id(String medico_id) {
        this.medico_id = medico_id;
    }

    public void setPaciente_id(String paciente_id) {
        this.paciente_id = paciente_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return this.id;
    }

    public String getMedico_id() {
        return this.medico_id;
    }

    public String getPaciente_id() {
        return this.paciente_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getFecha() {
        return this.fecha;
    }

}
