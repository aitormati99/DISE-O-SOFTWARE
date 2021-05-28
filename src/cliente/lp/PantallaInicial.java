package cliente.lp;
import cliente.controller.Controller;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class PantallaInicial extends JFrame {

    private JPanel contentPane;
    private JTextField txtAfiliacion;
    private JTextField txtPais;

    private Controller controller;
    /**
     * Create the frame.
     */


    public PantallaInicial(Controller controller) {

        this.controller = controller;
        iniciar();
        this.setVisible(true);

    }
    public void iniciar() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 631, 523);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblAfiliacion = new JLabel("AFILIACION");
        lblAfiliacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAfiliacion.setBounds(105, 165, 137, 20);
        contentPane.add(lblAfiliacion);
        
        JLabel lblPais = new JLabel("PAIS");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPais.setBounds(105, 244, 137, 20);
        contentPane.add(lblPais);
        
        JButton btnDescargar = new JButton("Descargar");
        btnDescargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String pais=txtPais.getText();
                String afiliacion=txtAfiliacion.getText();

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
        btnDescargar.setBounds(359, 327, 115, 29);
        contentPane.add(btnDescargar);


        
        JLabel lblNewLabel = new JLabel("DESARROLLADORES");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
        lblNewLabel.setBounds(228, 16, 461, 70);
        contentPane.add(lblNewLabel);
        
        txtAfiliacion = new JTextField();
        txtAfiliacion.setBounds(273, 164, 243, 29);
        contentPane.add(txtAfiliacion);
        txtAfiliacion.setColumns(10);
        
        txtPais = new JTextField();
        txtPais.setBounds(271, 243, 245, 29);
        contentPane.add(txtPais);
        txtPais.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(PantallaInicial.class.getResource("/icono.png")));

        lblNewLabel_1.setBounds(-55, -56, 1384, 1159);
        contentPane.add(lblNewLabel_1);
    }
}
