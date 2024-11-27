package org.senac.aula01.controller;

import java.util.List;

import org.senac.aula01.model.Produto;
import org.senac.aula01.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
   
    @Autowired
    private ProdutoRepository repository;
 
    @GetMapping
    public List<Produto> get(@RequestParam(required = false, defaultValue = "nome")String order){      
        Sort s = Sort.by(order);  
        return repository.findAll(s);
    }
 
 
    @PostMapping
    public void save(@RequestBody Produto produto){
      repository.save(produto);  
    }
 
 
}
