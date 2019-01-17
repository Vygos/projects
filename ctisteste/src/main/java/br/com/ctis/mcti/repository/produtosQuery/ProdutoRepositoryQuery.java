package br.com.ctis.mcti.repository.produtosQuery;

import br.com.ctis.mcti.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryQuery {

     Page<Produto> filtrar(Pageable pageable);
}
