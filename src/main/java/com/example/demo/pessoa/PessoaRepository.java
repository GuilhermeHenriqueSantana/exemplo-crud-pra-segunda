package com.example.demo.pessoa;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
    List<Pessoa> findByEmail(String email);
    
    @Query(value = "SELECT p FROM pessoa p WHERE p.email = :email", nativeQuery = true)
    List<Pessoa> buscarPeloEmail(@Param("email") String email);
}
