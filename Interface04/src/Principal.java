import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Color;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import javax.swing.JSplitPane;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Utilitarios.LexicalError;
import Utilitarios.Lexico;
import Utilitarios.Token;

import java.awt.Dimension;

import javax.swing.JToolBar;
import java.awt.Rectangle;



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
		setMinimumSize(new Dimension(1115, 700));
			
		setTitle("COMPILADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(10, 66, 1079, 535);
		
		
		JTextArea tfCodigo = new JTextArea();	
		tfCodigo.setBorder(new NumberedBorder());
		tfCodigo.setText("\r\n");
		tfCodigo.setFont(new Font("Courier New", Font.PLAIN, 13));
		
		
		//tfCodigo.setBounds(29, 57, 1031, 364);	
		
		JFileChooser EscolheArquivo = new JFileChooser();
		EscolheArquivo.setEnabled(false);
		EscolheArquivo.setBackground(new Color(128, 128, 128));
		EscolheArquivo.setBorder(new LineBorder(new Color(0, 0, 0)));
		EscolheArquivo.setForeground(new Color(128, 128, 128));
		EscolheArquivo.setVisible(false);
		EscolheArquivo.setBounds(423, 66, 567, 304);
		contentPane.add(EscolheArquivo);
		//contentPane.add(scrollPane);
		
		JScrollPane scrollPane = new JScrollPane(tfCodigo);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 56, 1078, 361);
		
		
		tfArquivo = new JTextField();
		tfArquivo.setBorder(null);
		tfArquivo.setCaretColor(Color.WHITE);
		tfArquivo.setToolTipText("");
		tfArquivo.setEditable(false);
		tfArquivo.setBackground(new Color(240, 240, 240));
		tfArquivo.setBounds(10, 625, 322, 25);
		contentPane.add(tfArquivo, BorderLayout.SOUTH);
		tfArquivo.setColumns(10);
		
		TextArea tfMensagens = new TextArea();
		tfMensagens.setMinimumSize(new Dimension(0, 110));
		tfMensagens.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfMensagens.setEditable(false);
		tfMensagens.setBounds(0, 441, 1088, 162);
		//contentPane.add(tfMensagens);
		
		//Adiciona o tfCodigo ao splitPane como sendo a parte superior e adiciona o tfMensagens como 
		//sendo a parte inferior
		splitPane.setTopComponent(scrollPane);
		splitPane.setDividerLocation(300);
		splitPane.setBottomComponent(tfMensagens);
		contentPane.add(splitPane);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setPreferredSize(new Dimension(120, 45));
		toolBar.setMinimumSize(new Dimension(120, 45));
		toolBar.setMaximumSize(new Dimension(120, 45));
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 120, 45);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		//###### Funçoes dos botoes ########
		
		//Botao novo
		JButton btnNovo = new JButton("Novo\r\n[crtl + n]");
		btnNovo.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNovo.setMinimumSize(new Dimension(120, 45));
		btnNovo.setMaximumSize(new Dimension(120, 45));
		btnNovo.setSize(new Dimension(120, 45));
		btnNovo.setBounds(new Rectangle(0, 0, 120, 45));
		toolBar.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(Principal.class.getResource("/icones/novo-documento.png")));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnNovo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control N"), "Novo");
		btnNovo.getActionMap().put("Novo", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				tfCodigo.setText("");
				tfMensagens.setText("");
				tfArquivo.setText("");
		     }

		  });
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodigo.setText("");
				tfMensagens.setText("");
				tfArquivo.setText("");
				
			}
		});
		
		btnNovo.setBounds(0, 0, 120, 45);
		
		
		
		
		
		//---------
		
		//botao abrir
		
		JButton btnAbrir = new JButton("Abrir[ctrl + o]");
		btnAbrir.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAbrir.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnAbrir);
		btnAbrir.setIcon(new ImageIcon(Principal.class.getResource("/icones/pasta-aberta.png")));
		
		
		btnAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control O"), "Abrir");
		btnAbrir.getActionMap().put("Abrir", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
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
		        tfMensagens.setText("");
		        tfArquivo.setText(arquivo);
		        }catch(NullPointerException et) {
		        	
		        }			    	    			    				
		     }

		  });
		
		
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
		        tfMensagens.setText("");
		        tfArquivo.setText(arquivo);
		        }catch(NullPointerException et) {
		        	
		        }			    	    			    	
			}
		});
		btnAbrir.setBounds(125, 0, 120, 45);
		
		//--------------
		//botao salvar
		
		JButton btnSalvar = new JButton("Salvar[ctrl + s]");
		btnSalvar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSalvar.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnSalvar);
		
		btnSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control S"), "Salvar");
		btnSalvar.getActionMap().put("Salvar", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				
				if(tfArquivo.getText().equals("Sem arquivo aberto")) {
					return;
				}
				
				if(tfArquivo.getText().isEmpty()) {					
					EscolheArquivo.setEnabled(true);
					EscolheArquivo.setVisible(true);
					
					String arquivo = getArquivo(EscolheArquivo);					
					
					try {
						//Limpa arquivo
						BufferedWriter bf = Files.newBufferedWriter(Path.of(arquivo), StandardOpenOption.TRUNCATE_EXISTING);
						//Reescreve arqivo
						BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arquivo, true));						
						buffWrite.write(tfCodigo.getText());
						buffWrite.close();
						
					} catch (IOException e1) {						
						e1.printStackTrace();
					}catch(NullPointerException e2) {
						
					}
					tfMensagens.setText("");
					tfArquivo.setText(arquivo);
				}else {
					String arquivo = "" + tfArquivo.getText();								
					try {
						//Limpa arquivo
						BufferedWriter bf = Files.newBufferedWriter(Path.of(arquivo), StandardOpenOption.TRUNCATE_EXISTING);
						//Reescreve arqivo
						BufferedWriter buffWrite = new BufferedWriter(new FileWriter(tfArquivo.getText(), true));						
						buffWrite.write(tfCodigo.getText());
						buffWrite.close();
						tfMensagens.setText("");
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}						        
				}
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if(tfArquivo.getText().equals("Sem arquivo aberto")) {
					return;
				}
				
				if(tfArquivo.getText().isEmpty()) {					
					EscolheArquivo.setEnabled(true);
					EscolheArquivo.setVisible(true);
					
					String arquivo = getArquivo(EscolheArquivo);					
					
					try {
						//Limpa arquivo
						BufferedWriter bf = Files.newBufferedWriter(Path.of(arquivo), StandardOpenOption.TRUNCATE_EXISTING);
						//Reescreve arqivo
						BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arquivo, true));						
						buffWrite.write(tfCodigo.getText());
						buffWrite.close();
						
					} catch (IOException e1) {						
						e1.printStackTrace();
					}catch(NullPointerException e2) {
						
					}
					tfArquivo.setText(arquivo);
					tfMensagens.setText("");
				}else {
					String arquivo = "" + tfArquivo.getText();								
					try {
						//Limpa arquivo
						BufferedWriter bf = Files.newBufferedWriter(Path.of(arquivo), StandardOpenOption.TRUNCATE_EXISTING);
						//Reescreve arqivo
						BufferedWriter buffWrite = new BufferedWriter(new FileWriter(tfArquivo.getText(), true));						
						buffWrite.write(tfCodigo.getText());
						buffWrite.close();
						tfMensagens.setText("");
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}						        
				}
			}
					
		});
		btnSalvar.setIcon(new ImageIcon(Principal.class.getResource("/icones/opcao-de-salvar-arquivo.png")));
		btnSalvar.setBounds(252, 0, 125, 45);
		
		//--------------------------
		
		//##########  Ja vem por padrao  #################
		
		JButton btnCopiar = new JButton("Copiar[ctrl + c]");		
		btnCopiar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCopiar.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnCopiar);
		btnCopiar.setIcon(new ImageIcon(Principal.class.getResource("/icones/copia-de.png")));
		btnCopiar.setBounds(382, 0, 125, 45);
		
		JButton btnColar = new JButton("Colar[ctrl + v]");
		btnColar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnColar.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnColar);
		btnColar.setIcon(new ImageIcon(Principal.class.getResource("/icones/cola.png")));
		btnColar.setBounds(512, 0, 122, 45);
		
		JButton btnRecortar = new JButton("Recortar[ctrl + x]");
		btnRecortar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRecortar.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnRecortar);
		btnRecortar.setIcon(new ImageIcon(Principal.class.getResource("/icones/tesouras-e-linhas-de-recorte.png")));
		btnRecortar.setBounds(641, 0, 140, 45);
		
		//####################
		
		//Compilacao
		JButton btnCompilar = new JButton("Compilar[F7]");
		btnCompilar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCompilar.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnCompilar);
		btnCompilar.setIcon(new ImageIcon(Principal.class.getResource("/icones/engrenagem.png")));
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mostra = ""; //acumula a linha o lexema e a classe
				ArrayList<String> listaLexos = new ArrayList<>(); //lista de lexemas, guia para apresentaçao
				
				HashMap<Integer, String> listaLexos2 = new HashMap<>();
				int oriLinha = 1;
				String mostraH = "";
				Lexico lexicoApre = new Lexico();	
				lexicoApre.setInput(tfCodigo.getText());
				
				Lexico lexico = new Lexico();				
				String erroLex = "";
				String per = tfCodigo.getText(); //pega o texto do tfCodigo, serve como guia para saber oque alterar e excluir
				
				per = per.replaceFirst("\r", "");
				per = per.replaceAll("\t", "");
				int linha = 0;

				lexico.setInput(tfCodigo.getText());							
				erroLex = tfCodigo.getText();
				try {

					Token t = null;
					
					while ((t = lexico.nextToken()) != null) {
						
						
						if(per.charAt(0) == '\n') { //##Remove quebras de linhas##
							
							 do {
							       per = per.replaceFirst("\n", "");
							       listaLexos.add("");
							       oriLinha++;
							       listaLexos2.put(oriLinha, "");
							 }while(per.charAt(0) == '\n');
							 
							 listaLexos.remove(listaLexos.size() - 1);
							 listaLexos.add(t.getLexeme());
							 oriLinha--;
							 listaLexos2.put(oriLinha, t.getLexeme());
							 oriLinha++;
						     per = per.replaceFirst(t.getLexeme(), "");
						}else {
							if(per.charAt(0) == ' ') { //##Remove espacos em branco##
								do {
								       per = per.replaceFirst(" ", "");
								       
								 }while(per.charAt(0) == ' ');
								 								 								 
							}
							
							listaLexos.add(t.getLexeme());
							listaLexos2.put(oriLinha, t.getLexeme());
							oriLinha++;
					        per = per.replaceFirst(t.getLexeme(), "");
						}
					
						
						//Segunda versao do contador
						/*//ELSE ANTIGO
						else {
							for(int i = 0; i < per.length() - 1; i++) {
								if(per.charAt(i) == '\n' && per.charAt(i + 1) == '\n') {
									
									listaLexos.add("");
									
								}else if(per.charAt(i) != '\n') {
									
									listaLexos.add(t.getLexeme());
									per = per.replaceFirst(t.getLexeme(), "");
									per = per.replaceFirst("\n", "");
									per = per.replaceFirst("\n", "");
									
									break;
								}else {
									per = per.replaceFirst("\n", "");
								}
							}
						}*/ 
											
							linha = listaLexos.lastIndexOf(t.getLexeme()) + 1;
							mostra += linha + "    " + t.getId() + "    " + t.getLexeme() + "\n";
							
						}
					
					
					for (Map.Entry<Integer, String> entrada : listaLexos2.entrySet()) { 
						t = lexicoApre.nextToken();
						if(t != null) {
							mostraH += entrada.getKey() + "   " + t.getId() + "   " + entrada.getValue() + "\n";
							continue;
						}
						
						
					}
					
					//Primeira versao do contador
					/*for(int i = 0; i < per.length() - 1; i++) {
						if(per.charAt(i) == '\n' && per.charAt(i + 1) == '\n') {
							linhas.add("");
							System.out.println("certo"); 
						}
					}*/
					
					mostra += "Programa compilado com sucesso";
					tfMensagens.setText(mostra);
					tfMensagens.setText(mostra + "\n" + mostraH);
					
				} catch (LexicalError e1) { // tratamento de erros
					
					if(e1.getMessage().equals("Simbolo invalido")) {
						tfMensagens.setText("Linha " + (linha + 1) + ": " + erroLex.charAt(e1.getPosition()) + " " + e1.getMessage());
					}else {
						tfMensagens.setText("Linha " + (linha + 1) + ": " + e1.getMessage());
					}
					
					

					// e.getMessage() - retorna a mensagem de erro de SCANNER_ERRO (olhar
					// ScannerConstants.java
					// e adaptar conforme o enunciado da parte 2)
					// e.getPosition() - retorna a posição inicial do erro, tem que adaptar para
					// mostrar a
					// linha
				}
			}
		});
		
		btnCompilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F7"), "Compilar");
		btnCompilar.getActionMap().put("Compilar", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				String mostra = ""; //acumula a linha o lexema e a classe
				ArrayList<String> listaLexos = new ArrayList<>(); //lista de lexemas, guia para apresentaçao
				
				HashMap<Integer, String> listaLexos2 = new HashMap<>();
				int oriLinha = 1;
				String mostraH = "";
				
				Lexico lexico = new Lexico();				
				String erroLex = "";
				String per = tfCodigo.getText(); //pega o texto do tfCodigo, serve como guia para saber oque alterar e excluir
				per = per.replaceFirst("\r", "");
				per = per.replaceAll("\t", "");
				int linha = 0;

				lexico.setInput(tfCodigo.getText());							
				erroLex = tfCodigo.getText();
				try {

					Token t = null;
					
					while ((t = lexico.nextToken()) != null) {
						
						
						if(per.charAt(0) == '\n') { //##Remove quebras de linhas##
							
							 do {
							       per = per.replaceFirst("\n", "");
							       listaLexos.add("");
							       listaLexos2.put(oriLinha, "");
							 }while(per.charAt(0) == '\n');
							 
							 listaLexos.remove(listaLexos.size() - 1);
							 listaLexos.add(t.getLexeme());
							 listaLexos2.put(oriLinha, t.getLexeme());
							 oriLinha++;
						     per = per.replaceFirst(t.getLexeme(), "");
						}else {
							if(per.charAt(0) == ' ') { //##Remove espacos em branco##
								do {
								       per = per.replaceFirst(" ", "");
								       
								 }while(per.charAt(0) == ' ');
								 								 								 
							}
							listaLexos.add(t.getLexeme());
					        per = per.replaceFirst(t.getLexeme(), "");
						}
					
						
						//Segunda versao do contador
						/*//ELSE ANTIGO
						else {
							for(int i = 0; i < per.length() - 1; i++) {
								if(per.charAt(i) == '\n' && per.charAt(i + 1) == '\n') {
									
									listaLexos.add("");
									
								}else if(per.charAt(i) != '\n') {
									
									listaLexos.add(t.getLexeme());
									per = per.replaceFirst(t.getLexeme(), "");
									per = per.replaceFirst("\n", "");
									per = per.replaceFirst("\n", "");
									
									break;
								}else {
									per = per.replaceFirst("\n", "");
								}
							}
						}*/ 
											
							linha = listaLexos.lastIndexOf(t.getLexeme()) + 1;
							mostra += linha + "    " + t.getId() + "    " + t.getLexeme() + "\n";
						}
					
					
					for (Map.Entry<Integer, String> entrada : listaLexos2.entrySet()) { 
						mostraH = entrada.getValue();
					
					}
					
					//Primeira versao do contador
					/*for(int i = 0; i < per.length() - 1; i++) {
						if(per.charAt(i) == '\n' && per.charAt(i + 1) == '\n') {
							linhas.add("");
							System.out.println("certo"); 
						}
					}*/
					
					mostra += "Programa compilado com sucesso";
					tfMensagens.setText(mostra);
					tfMensagens.setText(mostra + "\n" + mostraH);
					
				} catch (LexicalError e1) { // tratamento de erros
					
					if(e1.getMessage().equals("Simbolo invalido")) {
						tfMensagens.setText("Linha " + (linha + 1) + ": " + erroLex.charAt(e1.getPosition()) + " " + e1.getMessage());
					}else {
						tfMensagens.setText("Linha " + (linha + 1) + ": " + e1.getMessage());
					}
					
					

					// e.getMessage() - retorna a mensagem de erro de SCANNER_ERRO (olhar
					// ScannerConstants.java
					// e adaptar conforme o enunciado da parte 2)
					// e.getPosition() - retorna a posição inicial do erro, tem que adaptar para
					// mostrar a
					// linha
				}
			}

		  });
		
		
		
		btnCompilar.setBounds(790, 0, 120, 45);
		
		//---------------
		//Equipe
		JButton btnEquipe = new JButton("Equipe[F1]");
		btnEquipe.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEquipe.setMaximumSize(new Dimension(120, 45));
		toolBar.add(btnEquipe);
		btnEquipe.setIcon(new ImageIcon(Principal.class.getResource("/icones/equipe.png")));
		
		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMensagens.setText("Gabriel de Souza Klauck, Nycolly Miranda");
			}
		});
		
		btnEquipe.setBounds(915, 0, 105, 45);
		
		btnEquipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Equipe");
		btnEquipe.getActionMap().put("Equipe", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
		        tfMensagens.setText("Gabriel de Souza Klauck, Nycolly Miranda");
		     }

		  });		
	}
	
	//Metodo seleciona um arquivo para abrir e retorna o caminho desse arquivo
	private static String getArquivo(JFileChooser escolha) {
		escolha.setFileFilter(new FileNameExtensionFilter("Arquivos *.txt", "txt"));
		int returnVal = escolha.showOpenDialog(escolha);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        String file = "" + escolha.getSelectedFile();
	        return file;
	    }
	    return null;
	}
	
	/*public static String setArquivo(JFileChooser escolha) {
		escolha.setFileFilter(new FileNameExtensionFilter("Arquivos *.txt", "txt"));
		escolha.setCurrentDirectory(new File(System.getProperty("user.home")));
		int returnVal = escolha.showOpenDialog(escolha);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        String file = "" + escolha.getSelectedFile();
	        return file;
	    }
	    return null;
	}*/
	
}
