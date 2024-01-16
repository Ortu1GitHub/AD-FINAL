package controlador;

import modelo.ConsultasPacientes;
import modelo.Pacientes;
import vista.FrmPacientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlPacientes implements ActionListener {

    public Pacientes paciente;
    public FrmPacientes frmPacientes;
    public ConsultasPacientes modConPacientes;


    public CtrlPacientes(Pacientes paciente, FrmPacientes frmPacientes, ConsultasPacientes modConPacientes) {
        this.paciente = paciente;
        this.frmPacientes = frmPacientes;
        this.modConPacientes = modConPacientes;
        frmPacientes.btnGuardar1.addActionListener(this);
        frmPacientes.btnBuscar.addActionListener(this);
        frmPacientes.btnModificar.addActionListener(this);
        frmPacientes.btnEliminar.addActionListener(this);
        frmPacientes.btnLimpiar.addActionListener(this);
    }

    public void iniciarVistaPacientes() {
        frmPacientes.setTitle("FORMULARIO DE PACIENTES");
        frmPacientes.setLocation(50, 50);
        frmPacientes.setVisible(true);
        frmPacientes.setClosable(true);
        frmPacientes.cargarDatosPacientes(modConPacientes.obtenerDatosPacientes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPacientes.btnGuardar1) {
            paciente.setSip(frmPacientes.tfSIP.getText().trim());
            paciente.setDni(frmPacientes.tfDNI.getText().trim());
            paciente.setNombre(frmPacientes.tfNombre.getText().trim());
            paciente.setApellido1(frmPacientes.tfApellido1.getText().trim());
            paciente.setApellido2(frmPacientes.tfApellido2.getText().trim());
            paciente.setTelefono(frmPacientes.tfTelefono.getText().trim());
            paciente.setDireccion(frmPacientes.tfDireccion.getText().trim());
            paciente.setLocalidad(frmPacientes.tfLocalidad.getText().trim());
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formato1.format(frmPacientes.dtFechaNac.getDate());

            // Convertimos el String a Date usando el formato original
            Date fechaOriginal = null;
            try {
                fechaOriginal = formato1.parse(strDate);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            // Creamos un nuevo formato para la fecha deseada
            SimpleDateFormat formatoNuevo = new SimpleDateFormat("yyyy-MM-dd");

            // Formateamos la fecha al nuevo formato
            String strDateNuevo = formatoNuevo.format(fechaOriginal);

            paciente.setFecha_nacimiento(strDateNuevo);

            if (modConPacientes.registrarPaciente(paciente)) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmPacientes.cargarDatosPacientes(modConPacientes.obtenerDatosPacientes());
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }


        if (e.getSource() == frmPacientes.btnBuscar) {
            paciente.setSip(frmPacientes.tfSIP.getText().trim());

            paciente = modConPacientes.buscarPaciente(frmPacientes.tfSIP.getText().trim());

            //Result is displayed
            frmPacientes.tfSIP.setText(paciente.getSip().trim());
            frmPacientes.tfDNI.setText(paciente.getDNI().trim());
            frmPacientes.tfNombre.setText(paciente.getNombre().trim());
            frmPacientes.tfApellido1.setText(paciente.getApellido1().trim());
            frmPacientes.tfApellido2.setText(paciente.getApellido2().trim());
            frmPacientes.tfTelefono.setText(paciente.getTelefono().trim());
            frmPacientes.tfDireccion.setText(paciente.getDireccion().trim());
            frmPacientes.tfLocalidad.setText(paciente.getLocalidad().trim());
            //frmPacientes.dtFechaNac.setDate(paciente.getFecha_nacimiento());
            if (paciente == null) {
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados");
            } else {
                JOptionPane.showMessageDialog(null, "Registro buscado con éxito");
            }
        }

        if (e.getSource() == frmPacientes.btnModificar) {
            paciente.setSip(frmPacientes.tfSIP.getText().trim());
            paciente.setDni(frmPacientes.tfDNI.getText().trim());
            paciente.setNombre(frmPacientes.tfNombre.getText().trim());
            paciente.setApellido1(frmPacientes.tfApellido1.getText().trim());
            paciente.setApellido2(frmPacientes.tfApellido2.getText().trim());
            paciente.setTelefono(frmPacientes.tfTelefono.getText().trim());
            paciente.setDireccion(frmPacientes.tfDireccion.getText().trim());
            paciente.setLocalidad(frmPacientes.tfLocalidad.getText().trim());


            if (modConPacientes.modificarPaciente(paciente)) {
                JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmPacientes.cargarDatosPacientes(modConPacientes.obtenerDatosPacientes());
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }

        if (e.getSource() == frmPacientes.btnEliminar) {
            paciente.setSip(frmPacientes.tfSIP.getText().trim());
            paciente.setDni(frmPacientes.tfDNI.getText().trim());
            paciente.setNombre(frmPacientes.tfNombre.getText().trim());
            paciente.setApellido1(frmPacientes.tfApellido1.getText().trim());
            paciente.setApellido2(frmPacientes.tfApellido2.getText().trim());
            paciente.setTelefono(frmPacientes.tfTelefono.getText().trim());
            paciente.setDireccion(frmPacientes.tfDireccion.getText().trim());
            paciente.setLocalidad(frmPacientes.tfLocalidad.getText().trim());

            if (modConPacientes.eliminarPaciente(paciente)) {
                JOptionPane.showMessageDialog(null, "Registro borrado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmPacientes.cargarDatosPacientes(modConPacientes.obtenerDatosPacientes());
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        }


        if (e.getSource() == frmPacientes.btnLimpiar) {
            frmPacientes.tfSIP.setText("");
            frmPacientes.tfDNI.setText("");
            frmPacientes.tfNombre.setText("");
            frmPacientes.tfApellido1.setText("");
            frmPacientes.tfApellido1.setText("");
            frmPacientes.tfApellido2.setText("");
            frmPacientes.tfTelefono.setText("");
            frmPacientes.tfDireccion.setText("");
            frmPacientes.tfLocalidad.setText("");
            frmPacientes.dtFechaNac.setDate(null);
        }
    }
}
