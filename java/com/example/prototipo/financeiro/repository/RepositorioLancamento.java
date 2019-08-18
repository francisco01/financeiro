package com.example.prototipo.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prototipo.financeiro.model.Lancamento;

public interface RepositorioLancamento extends JpaRepository<Lancamento, Long>{

}
