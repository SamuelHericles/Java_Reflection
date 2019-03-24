package br.com.alura.alurator.playground.reflexao;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;
public class TestaInstanciaObjetoCorretamente {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<SubControle> subControleClasse1 = SubControle.class;
		
		Class<?> subControleClasse2 = 
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Class<?> controleClass1 = 
				Class.forName("br.com.alura.alurator.playground.controle.Controle");
//		
////		try {
////			controleClass1.getDeclaredConstructor().newInstance();
////		} catch(InvocationTargetException e) {
////			e.printStackTrace();
////			System.out.println(e.getTargetException());
////		}
		
		
		
		
		//controleClass1.newInstance();
		
		
		Constructor<SubControle> subControle =
				subControleClasse1.getDeclaredConstructor();
		//Com o getConstrutor só não é possivel saber o tipo de retorno da função
		
		subControle.setAccessible(true);
		Object subControle1 = subControle.newInstance();//newinstance da classe object
		
		System.out.println(subControle);
		System.out.println(subControle1);
		
	}
}
