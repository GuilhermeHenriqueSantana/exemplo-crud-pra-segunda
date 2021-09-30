package com.example.demo.pessoa;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.salvar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPeloIdUrl(@PathVariable Integer id) {
        return ResponseEntity.ok(pessoaService.pegarPeloId(id));
    }

    @GetMapping
    public ResponseEntity<Pessoa> obterPeloIdParam(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(pessoaService.pegarPeloId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        pessoaService.deletar(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Pessoa>> pegarTodos(Pageable pageable) {
        return ResponseEntity.ok(pessoaService.pegarTodos(pageable));
    }    


}