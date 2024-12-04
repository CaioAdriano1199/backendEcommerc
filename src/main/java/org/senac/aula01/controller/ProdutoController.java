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
    public List<Produto> get(@RequestParam(required = false, defaultValue = "nome")String orderBy, @RequestParam(required = false, defaultValue = "asc")String direction,
      @RequestParam(required = false)String filter){  

        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;  
        Sort sort = Sort.by(sortDirection, orderBy);
        if(filter == null){
        return repository.findAll(sort);
      }
      return repository.findByNomeContains(filter, sort);
    }
 
 
    @PostMapping
    public void save(@RequestBody Produto produto){
      repository.save(produto);  
    }
 
 
}
