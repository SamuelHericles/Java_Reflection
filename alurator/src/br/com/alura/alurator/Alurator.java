	package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {// Construtor para pegar uma string com o nome do pacote
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

		// /produto/lista
		// produto -> roduto
		// p -> P

		Request request = new Request(url);

		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();
		
		
		// o newInstance da deprecado porque ele lança um monte de execeção, e ainda ou
		// exeção

//		Object instanciaControle = new Reflexao()
//				.refleteClasse(pacoteBase + nomeControle)
//				.getConstrutorPadrao()
//				.invoca();

//			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);//Pega o full qualified name da classe controler
//			
//			Object instanciaControle = classeControle.getDeclaredConstructor().newInstance();//o método newInstance retorna um object
//			
//		System.out.println(instanciaControle);
		
		Object retorno =  new Reflexao()
							.refleteClasse(pacoteBase + nomeControle)
							.criaInstancia()
							.getMetodo(nomeMetodo,params)
							.invoca();
		
		
		System.out.println(retorno);
		
		return retorno;
	}
}
