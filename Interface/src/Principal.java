import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

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
		
		JFileChooser EscolheArquivo = new JFileChooser();
		EscolheArquivo.setBackground(new Color(128, 128, 128));
		EscolheArquivo.setBorder(new LineBorder(new Color(0, 0, 0)));
		EscolheArquivo.setForeground(new Color(128, 128, 128));
		EscolheArquivo.setEnabled(false);
		EscolheArquivo.setVisible(false);
		EscolheArquivo.setBounds(423, 66, 567, 304);
		contentPane.add(EscolheArquivo);
		
		JTextArea tfCodigo = new JTextArea();	
		tfCodigo.setBorder(new NumberedBorder());
		tfCodigo.setText("\r\n");
		tfCodigo.setFont(new Font("Courier New", Font.PLAIN, 13));
		
		
		//tfCodigo.setBounds(29, 57, 1031, 364);	
		
		JScrollPane scrollPane = new JScrollPane(tfCodigo);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 56, 1078, 361);
		contentPane.add(scrollPane);
		
		
		tfArquivo = new JTextField();
		tfArquivo.setBorder(null);
		tfArquivo.setCaretColor(Color.WHITE);
		tfArquivo.setText("Sem arquivo aberto");
		tfArquivo.setToolTipText("");
		tfArquivo.setEditable(false);
		tfArquivo.setBackground(new Color(240, 240, 240));
		tfArquivo.setBounds(0, 612, 322, 25);
		contentPane.add(tfArquivo);
		tfArquivo.setColumns(10);
		
		TextArea tfMensagens = new TextArea();
		tfMensagens.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfMensagens.setEditable(true);
		tfMensagens.setBounds(0, 441, 1088, 162);
		contentPane.add(tfMensagens);
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
				
				
				EscolheArquivo.setEnabled(true);
				EscolheArquivo.setVisible(true);
				try {
				String arquivo = getArquivo(EscolheArquivo);
				File file = new File(arquivo);
				FileInputStream fis = null;
		        String texto = "";
		        
		        try {
		            fis = new FileInputStream(file);
		            int content;
		            while ((content = fis.read()) != -1) {
		                texto += (char) content;
		            }
		        } catch (IOException el) {
		            el.printStackTrace();
		        } finally {
		            try {
		                if (fis != null) {
		                    fis.close();
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		        tfCodigo.setText(texto);
		        tfArquivo.setText(arquivo);
		        }catch(NullPointerException et) {
		        	
		        }
		        
		        
				
				
				
				
			    	    			    	
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
	
	public static String getArquivo(JFileChooser escolha) {
		int returnVal = escolha.showOpenDialog(escolha);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        String file = "" + escolha.getSelectedFile();
	        return file;
	    }
	    return null;
	}
}
