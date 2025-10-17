package br.unipar.devbackend.atividade1.service;


import br.unipar.devbackend.atividade1.model.Produto;
import br.unipar.devbackend.atividade1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> atualizar(Long id, Produto produtoDetalhes) {
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    produtoExistente.setNome(produtoDetalhes.getNome());
                    produtoExistente.setPreco(produtoDetalhes.getPreco());
                    return produtoRepository.save(produtoExistente);
                });
    }

    public boolean deletar(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}