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

    public final String getId()
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
        	
        	case 7:
        		return "do";
        }
        return "?";
    }

    public final String getLexeme()
    {
        return lexeme;
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
