package controlador;

import modelo.ConsultasMedicos;
import modelo.Medicos;
import vista.FrmMedicos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMedicos implements ActionListener {

    public Medicos medico;
    public FrmMedicos frmMedicos;
    public ConsultasMedicos modConMedicos;


    public CtrlMedicos(Medicos medico, FrmMedicos frmMedicos, ConsultasMedicos modConMedicos) {
        this.medico = medico;
        this.frmMedicos = frmMedicos;
        this.modConMedicos = modConMedicos;
        frmMedicos.btnGuardar1.addActionListener(this);
        frmMedicos.btnBuscar.addActionListener(this);
        frmMedicos.btnModificar.addActionListener(this);
        frmMedicos.btnEliminar.addActionListener(this);
        frmMedicos.btnLimpiar.addActionListener(this);
    }

    public void iniciarVistaMedicos() {
        frmMedicos.setTitle("FORMULARIO DE MEDICOS");
        frmMedicos.setLocation(50, 50);
        frmMedicos.setVisible(true);
        frmMedicos.setClosable(true);
        frmMedicos.cargarDatosMedicos(modConMedicos.obtenerDatosMedicos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMedicos.btnGuardar1) {
            medico.setNumero_colegiado(frmMedicos.tfNumColegiado1.getText().trim());
            medico.setDni(frmMedicos.tfDNI.getText().trim());
            medico.setNombre(frmMedicos.tfNombre.getText().trim());
            medico.setApellido1(frmMedicos.tfApellido1.getText().trim());
            medico.setApellido2(frmMedicos.tfApellido2.getText().trim());
            medico.setTelefono(frmMedicos.tfTelefono.getText().trim());
            medico.setEspecialidad_id(Integer.parseInt(frmMedicos.tfEspecialidad.getText().trim()));

            if (modConMedicos.registrarMedico(medico)) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmMedicos.cargarDatosMedicos(modConMedicos.obtenerDatosMedicos());
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }

        if (e.getSource() == frmMedicos.btnBuscar) {
            medico.setNumero_colegiado(frmMedicos.tfNumColegiado1.getText().trim());

            medico = modConMedicos.buscarMedico(frmMedicos.tfNumColegiado1.getText().trim());

            //Result is displayed
            frmMedicos.tfNumColegiado1.setText(medico.getNumero_colegiado().trim());
            frmMedicos.tfDNI.setText(medico.getDNI().trim());
            frmMedicos.tfNombre.setText(medico.getNombre().trim());
            frmMedicos.tfApellido1.setText(medico.getApellido1().trim());
            frmMedicos.tfApellido2.setText(medico.getApellido2().trim());
            frmMedicos.tfTelefono.setText(medico.getTelefono().trim());
            frmMedicos.tfEspecialidad.setText(String.valueOf(medico.getEspecialidad()).trim());
            if (medico == null) {
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados");
            } else {
                JOptionPane.showMessageDialog(null, "Registro buscado con éxito");
            }
        }


        if (e.getSource() == frmMedicos.btnModificar) {
            medico.setNumero_colegiado(frmMedicos.tfNumColegiado1.getText().trim());
            medico.setDni(frmMedicos.tfDNI.getText().trim());
            medico.setNombre(frmMedicos.tfNombre.getText().trim());
            medico.setApellido1(frmMedicos.tfApellido1.getText().trim());
            medico.setApellido2(frmMedicos.tfApellido2.getText().trim());
            medico.setTelefono(frmMedicos.tfTelefono.getText().trim());
            medico.setEspecialidad_id(Integer.parseInt(frmMedicos.tfEspecialidad.getText().trim()));

            if (modConMedicos.modificarMedico(medico)) {
                JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmMedicos.cargarDatosMedicos(modConMedicos.obtenerDatosMedicos());
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }

        if (e.getSource() == frmMedicos.btnEliminar) {
            medico.setNumero_colegiado(frmMedicos.tfNumColegiado1.getText().trim());
            medico.setDni(frmMedicos.tfDNI.getText().trim());
            medico.setNombre(frmMedicos.tfNombre.getText().trim());
            medico.setApellido1(frmMedicos.tfApellido1.getText().trim());
            medico.setApellido2(frmMedicos.tfApellido2.getText().trim());
            medico.setTelefono(frmMedicos.tfTelefono.getText().trim());
            medico.setEspecialidad_id(Integer.parseInt(frmMedicos.tfEspecialidad.getText().trim()));

            if (modConMedicos.eliminarMedico(medico)) {
                JOptionPane.showMessageDialog(null, "Registro borrado con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmMedicos.cargarDatosMedicos(modConMedicos.obtenerDatosMedicos());
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar");
            }
        }

        if (e.getSource() == frmMedicos.btnLimpiar) {
            frmMedicos.tfNumColegiado1.setText("");
            frmMedicos.tfDNI.setText("");
            frmMedicos.tfNombre.setText("");
            frmMedicos.tfApellido1.setText("");
            frmMedicos.tfApellido1.setText("");
            frmMedicos.tfApellido2.setText("");
            frmMedicos.tfTelefono.setText("");
            frmMedicos.tfEspecialidad.setText("");
        }
    }
}
