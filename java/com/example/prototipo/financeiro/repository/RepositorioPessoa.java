package com.example.prototipo.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.prototipo.financeiro.model.Pessoa;


public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {
	
	public Pessoa findByCodigo(Long codigo);

}
