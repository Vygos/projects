package br.com.ctis.mcti.controller;

import java.util.List;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ctis.mcti.model.Produto;
import br.com.ctis.mcti.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
    private ProdutosService produtosService;

	@GetMapping
	public List<Produto> pesquisar(){
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public Produto adicionarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}

	@GetMapping("/dto")
	@ResponseStatus(HttpStatus.OK)
	public Page<Produto> retornarDto(Pageable pageable){
		return produtoRepository.filtrar(pageable);
	}

	@GetMapping("/usuario")
    public ResponseEntity<Usuario> retornarUsuarioLogado(){
	    return ResponseEntity.ok(produtosService.retonarUsuarioLogado());
    }
}
