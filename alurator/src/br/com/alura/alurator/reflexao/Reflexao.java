package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorDeClasse refleteClasse(String fqn) throws ClassNotFoundException {
		
		try {
			Class<?> classe = Class.forName(fqn);
			
			return new ManipuladorDeClasse(classe);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}

}
