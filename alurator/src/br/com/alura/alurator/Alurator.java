	package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	// Construtor para pegar uma string com o nome do pacote
	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

		//  /produto/lista
		//  produto -> roduto
		//  p -> P
		Request request = new Request(url);

		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();
		
		//Retornar o endereço do pacote do método da classe e reinstaciá-lo
		Object retorno =  new Reflexao()
							.refleteClasse(pacoteBase + nomeControle)
							.criaInstancia()
							.getMetodo(nomeMetodo,params)
							.invoca();
		
		
		System.out.println(retorno);
		
		return retorno;
	}
}
