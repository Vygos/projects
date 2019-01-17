package br.com.ctis.mcti.repository;

import br.com.ctis.mcti.repository.produtosQuery.ProdutoRepositoryQuery;
import br.com.ctis.mcti.repository.produtosQuery.ProdutoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ctis.mcti.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
