package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
	//Classe pegar os endereços dos métodos intanciados bem como os outros referenciados
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			
		Class<?> controleClasse = 
				Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Constructor<?> construtoPadrao = controleClasse.getDeclaredConstructor();
		
		Object controle = construtoPadrao.newInstance();
		
		Method m = controleClasse.getDeclaredMethod("metodoControle2",String.class,String.class);
		
		Object retorno = m.invoke(controle,"Olá mundo","heheheh");
		
		System.out.println(retorno);
	}
}

