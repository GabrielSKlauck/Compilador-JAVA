package Utilitarios;

public class Token
{
    private int id;
    private String lexeme;
    private int position;

    public Token(int id, String lexeme, int position)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        switch(this.id) {
        	case 2:
        		return "palavra reservada";
        	
        	case 3:
        		return "id";
        	
        	case 4:
        		return "cte_int";
        	
        	case 5:
        		return "cte_float";
        		
        	case 6:
        		return "cte_string";        	       	
        }
        
        if(this.id >= 7 && this.id <= 17) {
        	return "palavra reservada";
        }
        
        if(this.id >= 18 && this.id <= 36) {
        	return "caracter especial";
        }
        return "?";
    }

    public String getItem() {
    	String lexo = this.toString();
    	int pos1 = lexo.indexOf("(");
		int pos2 = lexo.indexOf(")");
		lexo = lexo.substring(pos1+2, pos2 - 1);
		return lexo;
    }
    
    public final int getPosition()
    {
        return position;
    }

    public String toString()
    {
        return id+" ( "+lexeme+" ) @ "+position;
    };
}
