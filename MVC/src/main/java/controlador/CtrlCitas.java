package controlador;

import modelo.Citas;
import modelo.ConsultasCitas;
import org.hibernate.Session;
import vista.FrmCitas;
import vista.FrmModificarCita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.HibernateUtil.sessionFactory;

public class CtrlCitas implements ActionListener {

    public Citas cita;
    public FrmCitas frmCitas;
    public ConsultasCitas modConCitas;


    public CtrlCitas(Citas cita, FrmCitas frmCitas, ConsultasCitas modConCitas) {
        this.cita = cita;
        this.frmCitas = frmCitas;
        this.modConCitas = modConCitas;

        frmCitas.btnGenerarCita.addActionListener(this);
        frmCitas.btnEliminarCita.addActionListener(this);
        frmCitas.btnModificarCita.addActionListener(this);


    }

    public void iniciarVistaCitas() {
        frmCitas.setTitle("FORMULARIO DE CITAS");
        frmCitas.setLocation(50, 50);
        frmCitas.setVisible(true);
        frmCitas.setClosable(true);
        frmCitas.cargarDatosPacientes(modConCitas.obtenerDatosPacientes());
        frmCitas.cargarDatosMedicos(modConCitas.obtenerDatosMedicos());
        frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmCitas.btnGenerarCita) {
            int medicoSelecionado = frmCitas.tbMedicos.getSelectedRow();
            cita.setMedico_id((String) frmCitas.tbMedicos.getValueAt(medicoSelecionado, 0));
            int pacienteSelecionado = frmCitas.tbPacientes.getSelectedRow();
            cita.setPaciente_id((String) frmCitas.tbPacientes.getValueAt(pacienteSelecionado, 0));
            Date fechaOriginal = new Date();
            SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd hh::mm:ss");
            String strFechaOriginal = formato1.format(fechaOriginal);
            cita.setCreated_at(strFechaOriginal);
            Date fechaCita = new Date();
            fechaCita = frmCitas.dtFechaCita.getDate();
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaCita = formato2.format(fechaCita);

            Date horaCita = (Date) frmCitas.spinnerHora.getValue();
            SimpleDateFormat formato3 = new SimpleDateFormat("HH:mm");
            String strHoraCita = formato3.format(horaCita);
            cita.setFecha(strFechaCita + " " + strHoraCita);

            if (modConCitas.registrarCita(cita)) {
                JOptionPane.showMessageDialog(null, "Cita guardada con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cita");
            }


        }


        if (e.getSource() == frmCitas.btnEliminarCita) {
            int citaSelecionada = frmCitas.tbCitas.getSelectedRow();
            cita.setMedico_id((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 0));
            cita.setPaciente_id((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 1));
            cita.setFecha((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 2));
            cita.setCreated_at((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 3));

            if (modConCitas.eliminarCita(cita)) {
                JOptionPane.showMessageDialog(null, "Cita borrada con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar cita");
            }
        }

        if (e.getSource() == frmCitas.btnModificarCita) {
            int selectedRow = frmCitas.tbCitas.getSelectedRow();

            DefaultTableModel model = (DefaultTableModel) frmCitas.tbCitas.getModel();

            // Obtener valores actuales de la fila seleccionada
            Object[] rowData = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowData[i] = model.getValueAt(selectedRow, i);
            }

            Citas citaEditada;
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            citaEditada = (Citas) session.createQuery("from Citas c where c.created_at='" + rowData[3] + "'").getSingleResult();
            session.getTransaction().commit();

            // Crear un nuevo formulario para la edición
            FrmModificarCita frmModificarCita = new FrmModificarCita(citaEditada);
            frmModificarCita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frmModificarCita.setVisible(true);
            Citas finalCitaEditada = citaEditada;
            frmModificarCita.btnConfirmarCambios.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finalCitaEditada.setMedico_id(frmModificarCita.tfIdNedico.getText().trim());
                    finalCitaEditada.setPaciente_id(frmModificarCita.tfIdPaciente.getText().trim());
                    Date fechaCita = new Date();
                    fechaCita = frmModificarCita.jDateChooser1.getDate();
                    SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
                    String strFechaCita = formato2.format(fechaCita);

                    Date horaCita = (Date) frmModificarCita.spinnerHora.getValue();
                    SimpleDateFormat formato3 = new SimpleDateFormat("HH:mm");
                    String strHoraCita = formato3.format(horaCita);
                    finalCitaEditada.setFecha(strFechaCita + " " + strHoraCita);

                    try {
                        session.beginTransaction();
                        session.update(finalCitaEditada);
                        session.getTransaction().commit();

                    } finally {
                        session.close();
                    }

                    // Cerrar el formulario de edición y refresca el listado de citas
                    frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
                    frmModificarCita.dispose();
                }
            });

        }
    }
}




