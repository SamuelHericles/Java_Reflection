package br.com.alura.estoque.controle;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.estoque.dao.ProdutoDaoMock;
import br.com.alura.estoque.modelo.Produto;

public class ProdutoController {
	
	//Variavel do tipo produtoDaoMock para acessar o banco de dados
	private ProdutoDaoMock produtoDao;

	//Construtor da classe
	public ProdutoController() {
		produtoDao = new ProdutoDaoMock();
	}
	
	//Retornar uma lista de produtos
	public List<Produto> lista() {
		return produtoDao.lista();
	}
	
	//Retornar uma lista de produtos com base no filtro especificado pelo o nome do produto
	public List<Produto> filtra(String nome) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	//Retornar uma lista de produtos com no filtor de produtos e sua marca
	public List<Produto> filtra(String nome, String marca) {
		return produtoDao.lista().stream()
							.filter(produto -> 
								produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
								&& produto.getMarca().equalsIgnoreCase(marca)
							)
							.collect(Collectors.toList());
	}
}
