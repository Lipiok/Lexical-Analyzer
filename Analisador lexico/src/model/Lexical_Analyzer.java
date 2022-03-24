package model;

import java.util.HashMap;
import java.util.Map;

public class Lexical_Analyzer {
	
	private Map<String, Token> palavrasChavesEOperadores;
	
	public Lexical_Analyzer() {
		this.palavrasChavesEOperadores = new HashMap<>();
		palavrasChavesEOperadores.put("0", Token.DIGITO);
		palavrasChavesEOperadores.put("1", Token.DIGITO);
		palavrasChavesEOperadores.put("2", Token.DIGITO);
		palavrasChavesEOperadores.put("3", Token.DIGITO);
		palavrasChavesEOperadores.put("4", Token.DIGITO);
		palavrasChavesEOperadores.put("5", Token.DIGITO);
		palavrasChavesEOperadores.put("6", Token.DIGITO);
		palavrasChavesEOperadores.put("7", Token.DIGITO);
		palavrasChavesEOperadores.put("8", Token.DIGITO);
		palavrasChavesEOperadores.put("9", Token.DIGITO);		
	}

}
