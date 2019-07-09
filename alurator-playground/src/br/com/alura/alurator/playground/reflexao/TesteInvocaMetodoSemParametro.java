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
	
	//Classe principal
	public static void main(String[] args) throws Exception {
	
		//Recebe o endereço da classe
		Class<?> subControleClasse = 
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		//Recebe o endenreço do construtor
		Constructor<?> construtorPadrao = 
				subControleClasse.getDeclaredConstructor();
		
		//Habilita para visualizar
		construtorPadrao.setAccessible(true);
	
		//Abre uma instância da classe
		Object subControle = construtorPadrao.newInstance();
				
		// Retorna todos os métodos publicos usados pela class, sub classe e outras 
		for  ( Method m : subControleClasse.getMethods()){
			System.out.println(m);
		}
		
		System.out.println();
		
		// Retorna todos os métodos não publicos usados pela class, sub classe e outras 
		for (Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		//Retorna os métodos das classes declarados
		Method m =  subControleClasse.getDeclaredMethod("metodoSubControle1");
		m.setAccessible(true);
		//Instacia esses métodos
		Object retorno =  m.invoke(subControle);
		
		//Mostra o endereço de todos eles
		System.out.println(retorno);
		
	}
}
