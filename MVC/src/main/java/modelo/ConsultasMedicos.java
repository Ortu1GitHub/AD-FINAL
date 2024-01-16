package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ConsultasMedicos {

    Medicos medico = new Medicos();
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    boolean res = false;

    public boolean registrarMedico(Medicos medico) {

        this.medico = medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(medico);
            session.getTransaction().commit();
            System.out.println("Registro insertado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
        }
    }

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

    public Medicos buscarMedico(String num_colegiado) {
        this.medico = medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Medicos medico1 = (Medicos) session.createQuery("from Medicos m where m.numero_colegiado='" + num_colegiado + "'").getSingleResult();
            session.getTransaction().commit();
            res = true;
            return medico1;

        } finally {
            session.close();
        }
    }

    public boolean modificarMedico(Medicos medico) {
        this.medico = medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Medicos medicoPersistente = medico;
            session.update(medicoPersistente);
            session.getTransaction().commit();
            System.out.println("Registro modificado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
        }
    }

    public boolean eliminarMedico(Medicos medico) {
        this.medico = medico;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(medico);
            session.getTransaction().commit();
            System.out.println("Registro borrado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
        }
    }
}
