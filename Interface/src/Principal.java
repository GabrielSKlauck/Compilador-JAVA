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
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		TextArea tfCodigo = new TextArea();
		
		tfCodigo.setText("\r\n");
		tfCodigo.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfCodigo.setBounds(20, 54, 1068, 338);
		contentPane.add(tfCodigo);
			
		TextArea tfMensagens = new TextArea();
		tfMensagens.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfMensagens.setEditable(false);
		tfMensagens.setBounds(0, 401, 1088, 205);
		contentPane.add(tfMensagens);
		
		tfArquivo = new JTextField();
		tfArquivo.setText("Sem arquivo aberto");
		tfArquivo.setToolTipText("");
		tfArquivo.setEditable(false);
		tfArquivo.setBackground(new Color(240, 240, 240));
		tfArquivo.setBounds(0, 612, 322, 25);
		contentPane.add(tfArquivo);
		tfArquivo.setColumns(10);
		
		JTextArea tfLinhas = new JTextArea();
		tfLinhas.setLineWrap(true);
		tfLinhas.setEditable(false);
		tfLinhas.setEnabled(false);
		tfLinhas.setWrapStyleWord(true);
		tfLinhas.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfLinhas.setBackground(new Color(240, 240, 240));
		tfLinhas.setText("1");
		tfLinhas.setBounds(0, 54, 19, 330);
		contentPane.add(tfLinhas);
		
		//Metodo que adicioan ou remove a quantidade de linhas
		tfCodigo.addKeyListener(new KeyAdapter() {
			int qtdLinha = 2;
			String linhaLista = tfLinhas.getText() + "\r\n";
			@Override
			public void keyPressed(KeyEvent e) {
				
				//Incrementa linha
				if(e.getKeyCode() == 10) {
					linhaLista += (qtdLinha++) + "\r\n";
					tfLinhas.setText(linhaLista);
				}
				
				//Deleta linha ainda nao funcional
				/*if(e.getKeyCode() == 8) {
					if(tfCodigo.getCaretPosition() == 0) {
						linhaLista = "" + qtdLinha--; 
						tfLinhas.setText(linhaLista);
					}
				}*/
			}
		});
		
		
		//###### Funçoes dos botoes ########
		
		
		JButton btnNovo = new JButton("Novo\r\n[crtl + n]");
		btnNovo.setIcon(new ImageIcon(Principal.class.getResource("/icones/novo-documento.png")));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodigo.setText("");
				tfMensagens.setText("");
				tfArquivo.setText("");
				
			}
		});
		
		btnNovo.setBounds(0, 0, 120, 45);
		contentPane.add(btnNovo);
		
		JButton btnAbrir = new JButton("Abrir[ctrl + o]");
		btnAbrir.setIcon(new ImageIcon(Principal.class.getResource("/icones/pasta-aberta.png")));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbrir.setBounds(125, 0, 120, 45);
		contentPane.add(btnAbrir);
		
		JButton btnSalvar = new JButton("Salvar[ctrl + s]");
		btnSalvar.setIcon(new ImageIcon(Principal.class.getResource("/icones/opcao-de-salvar-arquivo.png")));
		btnSalvar.setBounds(252, 0, 125, 45);
		contentPane.add(btnSalvar);
		
		//##########  Ja vem por padrao  #################
		
		JButton btnCopiar = new JButton("Copiar[ctrl + c]");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCopiar.setIcon(new ImageIcon(Principal.class.getResource("/icones/copia-de.png")));
		btnCopiar.setBounds(382, 0, 125, 45);
		contentPane.add(btnCopiar);
		
		JButton btnColar = new JButton("Colar[ctrl + v]");
		btnColar.setIcon(new ImageIcon(Principal.class.getResource("/icones/cola.png")));
		btnColar.setBounds(512, 0, 122, 45);
		contentPane.add(btnColar);
		
		JButton btnRecortar = new JButton("Recortar[ctrl + x]");
		btnRecortar.setIcon(new ImageIcon(Principal.class.getResource("/icones/tesouras-e-linhas-de-recorte.png")));
		btnRecortar.setBounds(641, 0, 140, 45);
		contentPane.add(btnRecortar);
		
		//####################
		
		JButton btnCompilar = new JButton("Compilar[F7]");
		btnCompilar.setIcon(new ImageIcon(Principal.class.getResource("/icones/engrenagem.png")));
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMensagens.setText("Compilação de programas ainda não implementada");
			}
		});
		btnCompilar.setBounds(790, 0, 120, 45);
		contentPane.add(btnCompilar);
		
		JButton btnEquipe = new JButton("Equipe[F1]");
		btnEquipe.setIcon(new ImageIcon(Principal.class.getResource("/icones/equipe.png")));
		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMensagens.setText("Gabriel de Souza Klauck, Nycolly Miranda");
			}
		});
		btnEquipe.setBounds(915, 0, 105, 45);
		contentPane.add(btnEquipe);
	}
}
