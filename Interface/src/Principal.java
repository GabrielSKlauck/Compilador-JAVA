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
import java.awt.Font;
import javax.swing.JSeparator;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField tfArquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        } 
		
		
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
		setTitle("COMPILADOR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		TextArea tfCodigo = new TextArea();
		tfCodigo.setText("\r\n");
		tfCodigo.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfCodigo.setBounds(20, 54, 901, 349);
		contentPane.add(tfCodigo);
			
		TextArea tfMensagens = new TextArea();
		tfMensagens.setEditable(false);
		tfMensagens.setBounds(0, 401, 921, 167);
		contentPane.add(tfMensagens);
		
		tfArquivo = new JTextField();
		tfArquivo.setText("Sem arquivo aberto");
		tfArquivo.setToolTipText("");
		tfArquivo.setEditable(false);
		tfArquivo.setBackground(new Color(240, 240, 240));
		tfArquivo.setBounds(0, 569, 921, 25);
		contentPane.add(tfArquivo);
		tfArquivo.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n16");
		textArea.setBounds(0, 54, 19, 330);
		contentPane.add(textArea);
		
		
		//Funçoes dos botoes
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodigo.setText("");
				tfMensagens.setText("");
				tfArquivo.setText("");
				
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
	}
}
