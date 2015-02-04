package balcar.shreyas.Dossier.Settings;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Settings extends JFrame {

	private JPanel contentPane;



	public Settings() {
		
		setBounds(100, 100, 333, 395);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(10, 11, 297, 22);
		contentPane.add(lblSettings);
		setVisible(true);
	}
}
