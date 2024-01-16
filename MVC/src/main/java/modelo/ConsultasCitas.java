package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ConsultasCitas {

    Citas cita = new Citas();
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    boolean res = false;

    public List<Medicos> obtenerDatosMedicos() {
        //this.medico=medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Medicos> listaMedicos = session.createQuery("from Medicos ").getResultList();
            session.getTransaction().commit();

            return listaMedicos;

        } finally {
            session.close();
        }
    }

    public List<Pacientes> obtenerDatosPacientes() {
        //this.medico=medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Pacientes> listaPacientes = session.createQuery("from Pacientes ").getResultList();
            session.getTransaction().commit();
            return listaPacientes;

        } finally {
            session.close();
        }
    }

    public List<Citas> obtenerDatosCitas() {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Citas> listaCitas = session.createQuery("from Citas").getResultList();
            session.getTransaction().commit();
            return listaCitas;

        } finally {
            session.close();
        }
    }

    public boolean registrarCita(Citas cita) {

        this.cita = cita;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(cita);
            session.getTransaction().commit();
            System.out.println("Registro insertado en BBDD");
            res = true;
            return res;
        } finally {
            session.close();
        }
    }

    public boolean eliminarCita(Citas cita) {

        this.cita = cita;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Citas cita_eliminar = (Citas) session.createQuery("from Citas c where c.created_at='" + cita.getCreated_at() + "'").getSingleResult();
            session.delete(cita_eliminar);
            session.getTransaction().commit();
            //System.out.println("Aqui");
            res = true;
            return res;

        } finally {
            session.close();
        }
    }
}
