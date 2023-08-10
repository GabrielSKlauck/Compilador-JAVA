import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Teste de botao");
			}
		});
		
		btnNovo.setBounds(0, 0, 89, 45);
		contentPane.add(btnNovo);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbrir.setBounds(90, 0, 89, 45);
		contentPane.add(btnAbrir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(180, 0, 89, 45);
		contentPane.add(btnSalvar);
		
		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(270, 0, 89, 45);
		contentPane.add(btnCopiar);
		
		JButton btnColar = new JButton("Colar");
		btnColar.setBounds(360, 0, 89, 45);
		contentPane.add(btnColar);
		
		JButton btnRecortar = new JButton("Recortar");
		btnRecortar.setBounds(450, 0, 89, 45);
		contentPane.add(btnRecortar);
		
		JButton btnCompilar = new JButton("Compilar");
		btnCompilar.setBounds(540, 0, 89, 45);
		contentPane.add(btnCompilar);
		
		JButton btnEquipe = new JButton("Equipe");
		btnEquipe.setBounds(630, 0, 89, 45);
		contentPane.add(btnEquipe);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 54, 921, 349);
		contentPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(0, 401, 921, 167);
		contentPane.add(textArea_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(240, 240, 240));
		textField.setBounds(0, 569, 921, 25);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
