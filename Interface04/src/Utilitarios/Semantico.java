package Utilitarios;

import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants
{
	String operador_relacional;
	public static ArrayList<String> codigo_objeto = new ArrayList<>();
	Stack pilha = new Stack();
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
        switch(action) {
        case 100:
        	codigo_objeto.add(".assembly extern mscorlib {}\n"
        			+ ".assembly _exemplo{}\n"
        			+ ".module _exemplo.exe\n"     
        			+ ".class public _exemplo{\n"
        			+ "  .method static public void _principal(){\n"
        			+ "     .entrypoint\n");
        					  
        break;    
        	
        case 101:
        	codigo_objeto.add("ret\r\n"
        			+ "  }\n"
        			+ "}");
        break;
        
        case 102:
        
        	String tipo = (String) pilha.pop();
        	if(tipo.equals("int64")) {
        		codigo_objeto.add("conv.i8\n");
        	}
        	codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(<" + tipo + ">)\n");
        
        break;
        
        case 114:
        	pilha.add("int64");
        	codigo_objeto.add("ldc.i8 " + token.getLexeme() + "\n" + "conv.r8\n");
        break;
        
        case 115:
        	pilha.add("float64");
        	codigo_objeto.add("ldc.r8 " + token.getLexeme() + "\n");
        break;
        
        case 105:
        	pilha.add("bool");
        	codigo_objeto.add("ldc.r4.1" + "\n");
        break;
        
        case 106:
        	pilha.add("bool");
        	codigo_objeto.add("ldc.r4.0" + "\n");
        break;
        
        case 116:
        	pilha.add("string");
        	codigo_objeto.add("ldstr." + token.getLexeme() +  "\n");
        break;          
        
        case 117:
        	System.out.println("Nao feito");
        break;
        
        case 110:
        	int valor1 = (int) pilha.pop();
        	int valor2 = (int) pilha.pop();
        	pilha.push(valor1 + valor2);       	       	
        break;
        
        case 111:
        	valor1 = (int) pilha.pop();
        	valor2 = (int) pilha.pop();
        	pilha.push(valor2 - valor1);       	       	
        break;

        case 112:
        	valor1 = (int) pilha.pop();
        	valor2 = (int) pilha.pop();
        	pilha.push(valor1 * valor2);       	       	
        break;
        
        case 113:
        	valor1 = (int) pilha.pop();
        	valor2 = (int) pilha.pop();
        	if(valor1 != 0) {
        		pilha.push(valor2 / valor1);
        	}else {
        		      		
        	}
        	       	       	
        break;


    }	      
}
    
    public static String getCodigo() {    	
    	String codigoCerto = "";
    	for(int i = 0; i < codigo_objeto.size(); i++) {
    		codigoCerto += codigo_objeto.get(i);    		
    	}    	
    	return codigoCerto;
    	
    }
}
