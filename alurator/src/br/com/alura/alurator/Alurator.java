package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

public class Alurator {
	
	private String pacoteBase;
	
	public Alurator(String pacoteBase) {//Construtor para pegar uma string com o nome do pacote
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) throws ClassNotFoundException {

		// /produto/lista
		// produto -> roduto
		// p -> P
		
		String[] partesUrl = url.replaceFirst("/","")//tira onde tiver / por 
			.split("/");//quebra a string em /
		
		String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0))
								+ partesUrl[0].substring(1) + "Controller";
		
		//o newInstance da deprecado porque ele lança um monte de execeção, e ainda ou exeção
		try {
			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);//Pega o full qualified name da classe controler
			
			Object instanciaControle = classeControle.getDeclaredConstructor().newInstance();//o método newInstance retorna um object
			
			System.out.println(instanciaControle);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException 
				| NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		
		} catch( InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("houve um erro no construtor",e.getTargetException());
		}
		
		return null;
	}
}
