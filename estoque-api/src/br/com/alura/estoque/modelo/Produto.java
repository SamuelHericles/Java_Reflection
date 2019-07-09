package br.com.alura.estoque.modelo;

public class Produto {
	private String nome;
	private double valor;
	private String marca;

	//Construtor da classe para receber nome, valor e marco do produto
	public Produto(String nome, double valor, String marca) {
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
	}

	//Obter o nome do produto
	public String getNome() {
		return nome;
	}
	
	//Definir o nome do produto
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Obter o valor do produto
	public double getValor() {
		return valor;
	}
	
	//Definir o valor do produto
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	//Obter a marco do produto
	public String getMarca() {
		return marca;
	}
	
	//Definir a marca do produto
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//Alterar o toString para mostrar o nome, valor e marco do produto
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + ", marca=" + marca + "]";
	}
}
