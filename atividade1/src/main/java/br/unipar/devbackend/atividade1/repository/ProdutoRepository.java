package br.unipar.devbackend.atividade1.repository;


import br.unipar.devbackend.atividade1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}