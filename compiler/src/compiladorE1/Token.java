package compiladorE1;

public class Token {

	public static int TIPO_FLOAT = 0;
	public static int TIPO_CHAR = 1;
	public static int TIPO_IDENTIFICADOR = 2;
	public static int TIPO_OPERADOR_RELACIONAL = 3;
	public static int TIPO_OPERADOR_ARITIMETICO = 4;
	public static int TIPO_OPERADOR_ATRIBUICAO = 5;
	public static int TIPO_CARACTERE_ESPECIAL = 6;
	public static int TIPO_PALAVRA_RESERVADA = 7;
	public static int TIPO_FINAL_CODIGO = 99;
	
	
	private int tipo; // tipo do token
	private String lexema; // conteudo do token
	
	public Token(String lexema, int tipo) {
		this.lexema = lexema;
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public String getLexema() {
		return lexema;
	}
	
	public String toString() {
		switch(this.tipo) {
		case 0:
			return this.lexema + " - FLOAT";
		case 1:
			return this.lexema + " - CHAR";
		case 2:
			return this.lexema + " - IDENTIFICADOR";
		case 3:
			return this.lexema + " - OPERADOR RELACIONAL";
		case 4:
			return this.lexema + " - OPERADOR ARITIMETICO";
		case 5:
			return this.lexema + " - OPERADOR DE ATRIBUI��O";
		case 6:
			return this.lexema + " - CARACTERE ESPECIAL";
		case 7:
			return this.lexema + " - PALAVRA RESERVADA";
		case 99:
			return this.lexema + " - FIM DO CODIGO";
		}
		return "";
		
	}
}
