package br.com.alura.alurator.protocolo;

public class Request {
	String nomeCotnrole;
	String nomeMetodo;
	public Request(String url) {

		String[] partesUrl = url.replaceFirst("/", "")// tira onde tiver / por
				.split("/");// quebra a string em /

		nomeCotnrole = Character.toUpperCase(partesUrl[0].charAt(0)) + partesUrl[0].substring(1) + "Controller";
			
		nomeMetodo = partesUrl[1];
		
	}

	public String getNomeControle() {

		return nomeCotnrole;
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

}
