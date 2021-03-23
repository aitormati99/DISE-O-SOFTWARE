import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prototipo extends JFrame {

	private JPanel contentPane;
	private JTextField Afiliacion;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblTema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prototipo frame = new prototipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prototipo() {
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(315, 312, 201, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(315, 397, 201, 39);
		contentPane.add(textField_2);
		
		JLabel lblAfiliacion = new JLabel("AFILIACION");
		lblAfiliacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAfiliacion.setBounds(105, 165, 137, 20);
		contentPane.add(lblAfiliacion);
		
		JLabel lblPais = new JLabel("PAIS");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPais.setBounds(105, 244, 137, 20);
		contentPane.add(lblPais);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(105, 319, 137, 20);
		contentPane.add(lblEdad);
		
		lblTema = new JLabel("TEMA");
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTema.setBounds(105, 404, 137, 20);
		contentPane.add(lblTema);
		
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
		
		JButton button_1 = new JButton("A\u00F1adir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(650, 315, 115, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("A\u00F1adir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(650, 400, 115, 29);
		contentPane.add(button_2);
		
		JButton btnDescargar = new JButton("Descargar");
		btnDescargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDescargar.setBounds(415, 497, 115, 29);
		contentPane.add(btnDescargar);
		
		JLabel lblNewLabel = new JLabel("DESARROLLADORES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(228, 16, 461, 70);
		contentPane.add(lblNewLabel);
	}
}
