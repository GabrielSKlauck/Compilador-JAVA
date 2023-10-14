package Utilitarios;

public interface ParserConstants
{
    int START_SYMBOL = 38;

    int FIRST_NON_TERMINAL    = 38;
    int FIRST_SEMANTIC_ACTION = 71;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  1, -1, -1, -1, -1, -1, -1, -1,  1,  1, -1,  1,  1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  3, -1, -1, -1, -1, -1, -1, -1,  3,  3, -1,  3,  3, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  4, -1, -1, -1, -1, -1, -1, -1,  7,  5, -1,  6,  8, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, 23, 21, -1, 22, 24, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, 15, 16, 17, -1, -1, 19, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, 13, 13, 13, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 27, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 31, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 33, 33, 33, 33, -1, -1, 33, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, 33, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, 33, 33, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, 11, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, 39, 39, -1, 39, 39, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, 41, 41, -1, 41, 41, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 44, 44, 44, 44, -1, -1, 44, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, 44, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, 44, 44, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, 47, -1, 45, 45, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 48, 48, 48, 48, -1, -1, 50, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, 51, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, -1 },
        { -1, -1, 52, 52, 52, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, 52, 52, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, 53, -1, 53, 53, -1, -1, -1, 53, -1, -1, 54, 54, 54, 54, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, 56, 57, 58, -1, -1, -1, -1 },
        { -1, -1, 59, 59, 59, 59, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59, -1, -1, -1, -1, -1, -1, -1, 59, 59, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60, 60, -1, 60, 60, -1, -1, -1, 60, -1, -1, 60, 60, 60, 60, 61, 62, -1, -1 },
        { -1, -1, 63, 63, 63, 63, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, -1, -1, -1, -1, -1, 63, 63, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, 64, -1, 64, 64, -1, -1, -1, 64, -1, -1, 64, 64, 64, 64, 64, 64, 65, 66 },
        { -1, -1, 67, 68, 69, 70, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 71, -1, -1, -1, -1, -1, -1, -1, 72, 73, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 10, 13, 28, 39, 29 },
        { 41, 23, 40 },
        {  0 },
        { 39 },
        { 43, 54 },
        { 47 },
        { 51 },
        { 55 },
        { 60 },
        {  0 },
        { 25, 44 },
        { 24, 59 },
        {  3, 45 },
        {  0 },
        { 22, 43 },
        {  4 },
        {  5 },
        {  6 },
        { 16 },
        {  9 },
        { 46 },
        { 47 },
        { 51 },
        { 55 },
        { 60 },
        { 43, 24, 59 },
        { 12, 26, 48, 27 },
        { 49, 43, 53 },
        {  0 },
        { 23, 48 },
        {  6, 22 },
        {  0 },
        { 14, 26, 52, 27 },
        { 59, 50 },
        {  0 },
        { 22, 52 },
        { 11, 26, 59, 27, 28, 57, 29, 56 },
        {  0 },
        {  8, 28, 57, 29 },
        { 42, 23, 58 },
        {  0 },
        { 57 },
        { 17, 26, 59, 27,  7, 28, 57, 29 },
        { 15, 28, 57, 29, 17, 26, 59, 27 },
        { 62, 61 },
        {  0 },
        { 19, 62, 61 },
        { 20, 62, 61 },
        { 63 },
        { 16 },
        {  9 },
        { 21, 62 },
        { 66, 64 },
        {  0 },
        { 65, 66 },
        { 30 },
        { 31 },
        { 32 },
        { 33 },
        { 68, 67 },
        {  0 },
        { 34, 68, 67 },
        { 35, 68, 67 },
        { 70, 69 },
        {  0 },
        { 36, 70, 69 },
        { 37, 70, 69 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 26, 59, 27 },
        { 34, 70 },
        { 35, 70 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "esperado EOF",
        "esperado palavra_reservada",
        "esperado identificador",
        "esperado cte_int",
        "esperado cte_float",
        "esperado cte_string",
        "esperado do",
        "esperado else",
        "esperado false",
        "esperado fun",
        "esperado if",
        "esperado in",
        "esperado main",
        "esperado out",
        "esperado repeat",
        "esperado true",
        "esperado while",
        "esperado end",
        "esperado &",
        "esperado |",
        "esperado !",
        "esperado ,",
        "esperado ;",
        "esperado =",
        "esperado :",
        "esperado (",
        "esperado )",
        "esperado {",
        "esperado }",
        "esperado ==",
        "esperado !=",
        "esperado <",
        "esperado >",
        "esperado +",
        "esperado -",
        "esperado *",
        "esperado /",
        "esperado fun", //"<programa> inv�lido",
        "esperado identificador if in out repeat while", //"<lista_instru> inv�lido",
        "esperado identificador if in out repeat while }", //"<lista_instru1> inv�lido",
        "esperado identificador if in out repeat while", //"<instrucao> inv�lido",
        "esperado identificador if in out repeat while", //"<comando> inv�lido",
        "esperado identificador ", //"<lista_ide> inv�lido",
        "esperado cte_int cte_float cte_string false true", //"<valor> inv�lido",
        "esperado , ; = : ) ", //"<lista_ide1> inv�lido",
        "esperado identificador",  //"<atribuicao> inv�lido",
        "esperado in", //"<input> inv�lido",
        "esperado identificador cte_string ", //"<lista_ent> inv�lido",
        "esperado identificador cte_string ",//"<cte_string_op> inv�lido",
        "esperado , )", //"<lista_expre1> inv�lido",
        "esperado out ", //"<output> inv�lido",
        "esperado identificador cte_int cte_float cte_string false true ! ( + -", //"<lista_expre> inv�lido",
        "esperado ; )", //"<lista_ent1> inv�lido",
        "esperado ; = :", //"<instrucao1> inv�lido",
        "esperado if  ", //"<cmd_sel> inv�lido",
        "esperado else ; ", //"<cmd_sel1> inv�lido",
        "esperado identificador if in out repeat while  ", //"<lista_cmd> inv�lido",
        "esperado identificador if in out repeat while } ", //<lista_cmd1> inv�lido",
        "esperado identificador cte_int cte_float cte_string false true ! ( + - ", //"<expressao> inv�lido",
        "esperado repeat while ", //"<cmd_rep> inv�lido",
        "esperado & | , ; ) ", //"<expressao_> inv�lido",
        "esperado identificador cte_int cte_float cte_string false true ! ( + - ", //"<elemento> inv�lido",
        "esperado identificador cte_int cte_float cte_string  ! ( + - ", //"<relacional> inv�lido",
        "esperado & | , ; ) == != < > ",  //"<relacional_> inv�lido",
        "esperado & | , ; ) == != < > ",  //"<operador_relacional> inv�lido",
        "esperado identificador cte_int cte_float cte_string : + -  ", //"<aritmetica> inv�lido",
        "esperado & | , ; ) == !=  < > + - ", //"<aritmetica_> inv�lido",
        "esperado identificador cte_int cte_float cte_string ( + - ", //"<termo> inv�lido",
        "esperado & | , ; ) == != < > + - * / ", //"<termo_> inv�lido",
        "esperado identificador cte_int cte_float cte_string ( + - ", //"<fator> inv�lido"
    };
}