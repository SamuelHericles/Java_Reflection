package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params)
			throws NoSuchMethodException, SecurityException {

		Stream<Method> metodos = Stream.of(instancia.getClass().getDeclaredMethods());
		Method metodoSelecionado = metodos.filter(metodo -> 
													metodo.getName().equals(nomeMetodo) 
													&& metodo.getParameterCount() == params.values().size()
													&& Stream.of(metodo.getParameters())
													.allMatch(arg -> 
															params.keySet().contains(arg.getName())
															&& params.get(arg.getName()).getClass().equals(arg.getType())
															)
													).findFirst()
													 .orElseThrow(() -> new RuntimeException("Método não encontrado"));
		return new ManipuladorMetodo(instancia, metodoSelecionado,params);

	}
}
