package cliente.lp;
import cliente.controller.Controller;

import java.awt.EventQueue;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class PantallaInicial extends JFrame{

    private JPanel contentPane;
    private JTextField Afiliacion;
    private JTextField textField;

    private static Controller controller;

    /**
     * Create the frame.
     */
    public PantallaInicial(Controller controller) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 861, 636);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Afiliacion = new JTextField();
        Afiliacion.setBounds(315, 158, 201, 39);
        contentPane.add(Afiliacion);
        Afiliacion.setColumns(10);

        JLabel label = new JLabel("");
        label.setBounds(0, 0, 69, 20);
        contentPane.add(label);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(315, 237, 201, 39);
        contentPane.add(textField);

        JLabel lblAfiliacion = new JLabel("AFILIACION");
        lblAfiliacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAfiliacion.setBounds(105, 165, 137, 20);
        contentPane.add(lblAfiliacion);

        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPais.setBounds(105, 244, 137, 20);
        contentPane.add(lblPais);

        JButton btnAadir = new JButton("A\u00F1adir");
        btnAadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnAadir.setBounds(650, 161, 115, 29);
        contentPane.add(btnAadir);

        JButton button = new JButton("A\u00F1adir");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setBounds(650, 240, 115, 29);
        contentPane.add(button);

        JButton btnBuscar = new JButton("Descargar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //¿?creo que esto no deberia de ser un void,
                // si no un boolean con el retorno,
                // codigo--> return controller.buscar();
                String pais=lblPais.getText();
                String afiliacion=lblAfiliacion.getText();

                Boolean validacion = false;
                //pasar al controller pais y afiliacion
                try {
                    validacion= controller.buscar(pais,afiliacion);
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }

                if (validacion){
                    JOptionPane.showMessageDialog(PantallaInicial.this,
                            "Los datos se han guardado correctamente");
                }
                else if (!validacion){
                    JOptionPane.showMessageDialog(PantallaInicial.this,
                            "ERROR. La busqueda no se ha realizado correctamente");
                }

            }
        });
        btnBuscar.setBounds(359, 327, 115, 29);
        contentPane.add(btnBuscar);

        JLabel lblNewLabel = new JLabel("DESARROLLADORES");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
        lblNewLabel.setBounds(228, 16, 461, 70);
        contentPane.add(lblNewLabel);
    }
}
