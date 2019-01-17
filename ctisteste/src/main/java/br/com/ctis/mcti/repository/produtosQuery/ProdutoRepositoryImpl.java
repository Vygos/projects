package br.com.ctis.mcti.repository.produtosQuery;

import br.com.ctis.mcti.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Produto> filtrar(Pageable pageable){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
        Root<Produto> produtoRoot = criteriaQuery.from(Produto.class);
        criteriaQuery.select(produtoRoot);

        TypedQuery<Produto> typedQuery = entityManager.createQuery(criteriaQuery);

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        typedQuery.setFirstResult(primeiroRegistroDaPagina);
        typedQuery.setMaxResults(totalRegistrosPorPagina);

        return new PageImpl<Produto>(typedQuery.getResultList(),pageable, totalRegistrosPorPagina );

    }
}
