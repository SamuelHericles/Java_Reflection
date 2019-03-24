package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//Classe métohd: Listar os tipos de execeções que pode ser lançadas, Tipos de parâmetros que recebe
//Tipo de retorno,Invocar o métodos.
//Class<T> recupera qualquer class com getMethods(),getMethod(String nome,Class<?> tipos Args),
//getDeclaredMethods(), getDeclaredMethod(String nome,Class<?> tipos Args). Somente método públicos,
//setAccesible(true),

// Method -> invoke(Object obj,Object args)


public class TesteInvocaMetodoSemParametro {
	
	public static void main(String[] args) throws Exception {
	
		Class<?> subControleClasse = 
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Constructor<?> construtorPadrao = 
				subControleClasse.getDeclaredConstructor();
		
		construtorPadrao.setAccessible(true);
	
		Object subControle = construtorPadrao.newInstance();
				
		for  ( Method m : subControleClasse.getMethods()){// Retorna todos os métodos publicos usados pela class, sub classe e outras 
			System.out.println(m);
		}
		
		System.out.println();
		
		for (Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		Method m =  subControleClasse.getDeclaredMethod("metodoSubControle1");
		m.setAccessible(true);
		Object retorno =  m.invoke(subControle);
		
		System.out.println(retorno);
		
	}
}
