package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {
	
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public Controle () {}
	
	public List<String> getLista() {
		return lista;
	}
	
	public void metodoControle1(String p1) {
		System.out.println("Conrtole.metodoControle2(String 1)");
		System.out.println("Parâmetro obtido: "+p1);	
	}
	
	public void metodoControle2(String p1,String p2){
		System.out.println("Controle.metodoControle(String p1,String p2)");
		System.out.println("Parêmetro obtido: "+p1);
		System.out.println("Parêmetro obtido: "+p2);
	}
	
	public void metodoControle3(String p1, Integer p2) {
		System.out.println("Controle.metodoControle(String p1, Integer p2");
		System.out.println("Parâmetro obtido: "+p1);
		System.out.println("Parâmetro obtido: "+p2);
	}
	
	
}
