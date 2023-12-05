package Utilitarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Semantico implements Constants
{
	
	public static ArrayList<String> codigo_objeto = new ArrayList<>(); // Array contetndo todo o codigo objeto
	Stack pilha = new Stack(); // pilha contendo tipos
	Stack pilha_rotulos = new Stack(); //Pilha contendo "funçoes"
	HashMap<String, Object> tabela_simbolos = new HashMap<>(); //Tabela de simbolos, chave o identificador
	ArrayList<String> lista_id = new ArrayList<>(); //Lista de identificadores
	int contadorRotIf = 1;
	int contadorRotRep = 1;
	String op;
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
    	//INICIO DO CODIGO ILASM
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
        		codigo_objeto.add("conv.i8 \n");
        	}
        	codigo_objeto.add("call void [mscorlib]System.Console::WriteLine(" + tipo + ") \n");
        
        break;
        //OPERACOES DO IF
        case 103:
        	pilha.pop();
        	pilha.pop();
        	pilha.push("bool");
        	codigo_objeto.add("and \n");
        break;
        	
        case 104:
        	pilha.pop();
        	pilha.pop();
        	pilha.push("bool");
        	codigo_objeto.add("or \n");
        break;
        //COLOCANDO VALORES NA PILHA
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
        //OPERACOES
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
        //OU EXCLUSIVO
        case 107:
        	codigo_objeto.add("ldc.i4.1\nxor \n");
        break;
        //GUARDA OPERDAOR RELACIONAL
        case 108:
        	op = token.getItem();       	        	              	
        break;

        //OPERACOES DE MAIOR MENOR IGUAL
        case 109:
        	String item =  (String) pilha.pop();
            String item2 =  (String) pilha.pop();
        	
        	switch(op) {
        		case "==":
        			codigo_objeto.add("ceq \n");
        			pilha.push("bool");
        		break;
        		case ">":
        			codigo_objeto.add("cgt \n");
        			pilha.push("bool");
        		break;
        		case "<":
        			codigo_objeto.add("clt \n");
        			pilha.push("bool");
        		case "!=":
        			codigo_objeto.add("ceq\n" + "ldc.i4 0\n" + "ceq\n");
        			pilha.push("bool");
        		break;
        	}
        break;
        
        //IF ELSE
        case 118:
        	tipo = (String) pilha.pop();
        	if(!tipo.equals("bool")) {
        		throw new SemanticError("expressão incompatível em comando de seleção");
        	}
        	codigo_objeto.add("brfalse rotuloCond" + contadorRotIf + "\n");
        	pilha_rotulos.push("rotuloCond" + contadorRotIf);      	
        	contadorRotIf++;
        break;
        
        case 119:
        	String rotulo = (String) pilha_rotulos.pop();
        	codigo_objeto.add(rotulo + ": \n");
        	
        break;
        
        case 120:
        	
        	codigo_objeto.add("br rotuloCond" + contadorRotIf + "\n");
        	rotulo = (String) pilha_rotulos.pop();
        	codigo_objeto.add(rotulo + ": \n");
        	pilha_rotulos.push("rotuloCond" + contadorRotIf);
        	contadorRotIf++;
        	
        break;
        
        //REPETIÇAO
        
        case 121:
        	pilha_rotulos.push("rotuloRep" + contadorRotRep);
        	codigo_objeto.add("rotuloRep" + contadorRotRep +": \n");
        	contadorRotRep++;
        break;
        
        case 122:
        	if(!pilha.pop().equals("bool")) {
        		throw new SemanticError("expressão incompatível em comando de repetição");
        	}
        	codigo_objeto.add("brfalse rotuloRep" + contadorRotRep + "\n");
        	pilha_rotulos.push("rotuloRep" + contadorRotRep);
        	contadorRotRep++;
        break;
        
        case 123:
        	String rotulo2 = (String) pilha_rotulos.pop();
        	rotulo = (String) pilha_rotulos.pop();
        	
        	codigo_objeto.add("br " + rotulo + " \n");
        	codigo_objeto.add(rotulo2 + ": \n");
        break;
        
        case 124:
        	if(!pilha.pop().equals("bool")) {
        		throw new SemanticError("expressão incompatível em comando de repetição");
        	}
        	rotulo = (String) pilha_rotulos.pop();
        	codigo_objeto.add("brtrue " + rotulo + " \n");
        break;
        //VARIAVEIS
        case 125: //VERIFICAR COM A PROF
        	lista_id.add(token.getItem());        	
        break;
        
        case 126:
        	for(String id : lista_id) {
        		if(tabela_simbolos.containsKey(id)) {
        			throw new SemanticError(id + " ja foi declarado");
        		}    		
        	}
        	String id = token.getItem();
        	tabela_simbolos.put(id, retornaTipo(id));
        	lista_id.clear();
        	
        break;
        
        case 127:
        	
        	for(String ide : lista_id) {
        		if(tabela_simbolos.containsKey(ide)) {
        			throw new SemanticError(ide + " ja foi declarado");
        		}       		
        	}
        	
        	for(String ide : lista_id) {       		
            	tabela_simbolos.put(ide, retornaTipo(ide));
            	codigo_objeto.add(".locals(" + retornaTipo(ide)+ " " + ide + ") \n");      		
        	}
        	
        	lista_id.clear();
        	
        break;
        
        case 128:
        	tipo = (String) pilha.pop();
        	for(int i = 0; i < lista_id.size() - 1; i++ ) {
        		codigo_objeto.add("dup \n");
        	}
        	for(String ide : lista_id) {
        		if(!tabela_simbolos.containsKey(ide)) {
        			throw new SemanticError(ide + " ja foi declarado");
        		}       		
        	}
        	id = token.getItem();
        	if(retornaTipo(lista_id.get(0)).equals("int64")) {
        		codigo_objeto.add("conv.i8\n");
        	}
        	codigo_objeto.add("stloc " + lista_id.get(0) + "\n");
        	lista_id.clear();
        	
        break;
        
        case 129:
        	boolean idAchado = false;
        	for(String ide : lista_id) {
        		if(tabela_simbolos.containsKey(ide)) {
        			idAchado = true;
        		}
        	}
        	id = token.getItem();
        	if(!idAchado) {
        		throw new SemanticError(id + " nao declarado");
        	}
        	
        	
        	if(retornaTipo(id).equals("int64")) {
        		codigo_objeto.add("call string [mscorlib]System.Console::ReadLine() \n");
            	codigo_objeto.add("call int64 [mscorlib]System.Int64::Parse(string) \n");
            	codigo_objeto.add("stloc " + id + " \n");
        	}else if(retornaTipo(id).equals("float64")) {
        		codigo_objeto.add("call string [mscorlib]System.Console::ReadLine() \n");
            	codigo_objeto.add("call float64 [mscorlib]System.Double::Parse(string) \n");
            	codigo_objeto.add("stloc " + id + " \n");
        	}else if(retornaTipo(id).equals("bool")) {
        		codigo_objeto.add("call string [mscorlib]System.Console::ReadLine() \n");
            	codigo_objeto.add("call bool [mscorlib]System.Boolean::Parse(string) \n");
            	codigo_objeto.add("stloc " + id + " \n");
        	}else {
        		codigo_objeto.add("call string [mscorlib]System.Console::ReadLine() \n");
        		codigo_objeto.add("stloc " + id + " \n");
        	}
        	
        	lista_id.clear();
        break;
        
        case 130:
        	codigo_objeto.add("ldstr " + token.getItem() + "\n");
        	codigo_objeto.add("call void [mscorlib]System.Console::Write(string) \n");
        break;
        
        case 131:
        	id = token.getItem();
        	if(!tabela_simbolos.containsKey(id)) {
        		throw new SemanticError(id + " nao declarado");
        	}
        	Object tipoVar = tabela_simbolos.get(id);
        	
        	if(tipoVar.equals("string")) {
        		pilha.add("string");
            	codigo_objeto.add("ldloc " + id +  "\n");
            	
        	}else if(tipoVar.equals("int64")) {
        		pilha.add("int64");
            	codigo_objeto.add("ldloc " + id + "\n" + "conv.r8\n");
            	
        	}else if(tipoVar.equals("float64")) {
        		pilha.add("float64");
            	codigo_objeto.add("ldloc " + id + "\n");
            	
        	}else if(tipoVar.equals("bool")){
        		if(tipoVar.equals("true")) {
        			pilha.add("bool");
                	codigo_objeto.add("ldc.i4.1" + "\n");
        		}else {
        			pilha.add("bool");
                	codigo_objeto.add("ldc.i4.0" + "\n");
        		}
        	}else {
        		codigo_objeto.add("ldloc " + id + "\n");
        		        		              	
            	if(tipoVar.getClass().equals("Integer")) {
            		pilha.add("int64");
                	codigo_objeto.add("ldc.i8 " + tipoVar + "\n" + "conv.r8\n");              	
            	}
            	
        	}
        break;
    }	      
}
    
    public static String retornaTipo(String id) {
    	id = id.substring(0, 2);
    	if(id.equals("_i")) {
    		return "int64";
    	}else if(id.equals("_f")) {
    		return "float64";
    	}else if(id.equals("_s")) {
    		return "string";
    	}else if(id.equals("_b")) {
    		return "bool";
    	}
    	return null;
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
