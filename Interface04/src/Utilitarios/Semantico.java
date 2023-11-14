package Utilitarios;

import java.util.ArrayList;
import java.util.Stack;

public class Semantico implements Constants
{
	String operador_relacional;
	public static ArrayList<String> codigo_objeto = new ArrayList<>();
	Stack pilha = new Stack();
	Stack pilha_rotulos = new Stack();
	String op;
	
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
        	codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(" + tipo + ")\n");
        
        break;
        case 103:
        	pilha.pop();
        	pilha.pop();
        	codigo_objeto.add("and");
        break;
        	
        case 104:
        	pilha.pop();
        	pilha.pop();
        	codigo_objeto.add("or");
        break;
        
        case 114:
        	pilha.add("int64");
        	codigo_objeto.add("ldc.i8 " + token.getItem() + "\n" + "conv.r8\n");
        break;
        
        case 115:
        	pilha.add("float64");
        	codigo_objeto.add("ldc.r8 " + token.getItem() + "\n");
        break;
        
        case 105:
        	pilha.add("bool");
        	codigo_objeto.add("ldc.i4.1" + "\n");
        break;
        
        case 106:
        	pilha.add("bool");
        	codigo_objeto.add("ldc.i4.0" + "\n");
        break;
        
        case 116:
        	pilha.add("string");
        	codigo_objeto.add("ldstr " + token.getItem() +  "\n");
        break;          
        
        case 117:
        	codigo_objeto.add("ldc.i8." + token.getItem());
        	codigo_objeto.add("conv.r8");
        	codigo_objeto.add("mul");
        break;
        
        case 110:
        	String opTipo = (String) pilha.pop();
        	String opTipo2 = (String) pilha.pop();
        	if(opTipo.equals("int64") && opTipo2.equals("int64")){
        		codigo_objeto.add("add\n");
            	pilha.push("int64");
        	}else{
        		codigo_objeto.add("add\n");
            	pilha.push("float64");
        	}
        	       	       	
        break;
        
        case 111:
        	opTipo = (String) pilha.pop();
        	opTipo2 = (String) pilha.pop();
        	if(opTipo.equals("int64") && opTipo2.equals("int64")){
        		codigo_objeto.add("sub\n");
            	pilha.push("int64");
        	}else{
        		codigo_objeto.add("sub\n");
            	pilha.push("float64");
        	}   	       	
        break;

        case 112:
        	opTipo = (String) pilha.pop();
        	opTipo2 = (String) pilha.pop();
        	if(opTipo.equals("int64") && opTipo2.equals("int64")){
        		codigo_objeto.add("mul\n");
            	pilha.push("int64");
        	}else{
        		codigo_objeto.add("mul\n");
            	pilha.push("float64");
        	}    	       	
        break;
        
        case 113:
        	opTipo = (String) pilha.pop();
            opTipo2 = (String) pilha.pop();
        	if(opTipo.equals("int64") && opTipo2.equals("int64")){
        		codigo_objeto.add("div\n");
            	pilha.push("int64");
        	}else{
        		codigo_objeto.add("div\n");
            	pilha.push("float64");
        	}
        	       	       	
        break;
        
        case 107:
        	codigo_objeto.add("ldc.i4.1\nxor \n");
        
        case 108:
        	op = token.getLexeme();       	        	              	
        break;

        case 109:
        	int item = (Integer) pilha.pop();
        	int item2 = (Integer) pilha.pop();
        	
        	switch(op) {
        		case "==":
        			codigo_objeto.add("ceq");
        			pilha.push("bool");
        		case ">":
        			codigo_objeto.add("cgt");
        			pilha.push("bool");
        		break;
        		case "<":
        			codigo_objeto.add("clt");
        			pilha.push("bool");
        		case "!=":
        		break;
        	}
        break;
        
        case 118:
        	tipo = (String) pilha.pop();
        	if(!tipo.equals("bool")) {
        		throw new SemanticError(tipo);
        	}
        	codigo_objeto.add("brfalse");
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
    
    public static void limpaCodigoObjeto() {
    	codigo_objeto.clear();
    }
}
