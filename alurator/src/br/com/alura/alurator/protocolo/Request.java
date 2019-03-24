package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	String nomeControle;
	String nomeMetodo;
	private Map<String,Object> queryParams;
	
	public Request(String url) {
		// ? não é um caracter para expressões regulares, então se usa [?] para reconher-lo.
		
		String[] partesUrl = url.replaceFirst("/", "")// tira onde tiver / por
				.split("[?]");// quebra a string em ?
		
		String[] controleEMetodo = partesUrl[0].split("/");

		nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0)) + 
				controleEMetodo[0].substring(1) + "Controller";
		
		nomeMetodo = controleEMetodo[1];
		
		queryParams = partesUrl.length > 1
				? new QueryParamsBuilder().withParams(partesUrl[1]).build()
				: new HashMap<String, Object>();
	}

	public String getNomeControle() {

		return nomeControle;
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

}
