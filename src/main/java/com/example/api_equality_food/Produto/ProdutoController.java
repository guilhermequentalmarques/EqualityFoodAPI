package com.example.api_equality_food.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProdutos() {
        try {
            List<Produto> produtos = produtoRepository.findAll();
            return ResponseEntity.ok(produtos);
        } catch (DataAccessException ex) {
            String errorMessage = "Erro: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/selecionarPorId/{id}")
    public ResponseEntity<Produto> getProdutoPorId(@PathVariable int id) {
        Optional<Produto> produto = produtoRepository.findById((long) id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/selecionarPorCategoria/{categoria}")
    public ResponseEntity<List<Produto>> getProdutosPorCategoria(@PathVariable String categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            List<Produto> produtos = produtoRepository.findByCategoria(categoria);
            if (!produtos.isEmpty()) {
                return ResponseEntity.ok(produtos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<Produto> produtos = produtoRepository.findAll();
            return ResponseEntity.ok(produtos);
        }
    }

    @GetMapping("/selecionarPorNome/{nome}")
    public ResponseEntity<List<Produto>> getProdutosPorNome(@PathVariable String nome) {
        if (nome != null && !nome.isEmpty()) {
            List<Produto> produtos = produtoRepository.findByNomeLike("%" + nome + "%");
            if (!produtos.isEmpty()) {
                return ResponseEntity.ok(produtos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<Produto> produtos = produtoRepository.findAll();
            return ResponseEntity.ok(produtos);
        }
    }

    @PutMapping("/atualizarQuantidade/{id}")
    public ResponseEntity<?> setQuantidade(@PathVariable int id, @RequestParam int novaQuant) {
        try {
            Optional<Produto> optionalProduto = produtoRepository.findById((long) id);

            if (optionalProduto.isPresent()) {
                Produto produto = optionalProduto.get();
                produto.setQuant(novaQuant);
                produtoRepository.save(produto);
                return ResponseEntity.ok("Quantidade do produto com ID " + id + " atualizada com sucesso para " + novaQuant);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (DataAccessException ex) {
            String errorMessage = "Erro: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}


