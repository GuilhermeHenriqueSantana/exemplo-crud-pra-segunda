package com.example.demo.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {
    
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletar(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa pegarPeloId(Integer id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Page<Pessoa> pegarTodos(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

}
