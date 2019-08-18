package com.example.prototipo.financeiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prototipo.financeiro.model.Lancamento;
import com.example.prototipo.financeiro.repository.RepositorioLancamento;
import com.example.prototipo.financeiro.service.ILancamentoService;


@Service
public class LancamentoService implements ILancamentoService {

	@Autowired
	private RepositorioLancamento repositorioLancamento;
	
	@Override
	public void excluir(Lancamento lancamento) throws RegrasNegocioException {
		if(lancamento.isPago()) {
			throw new RegrasNegocioException("Lançamento não pode ser excluido");
		}
		repositorioLancamento.delete(lancamento);
	}

	@Override
	public void salvar(Lancamento lancamento) {
		this.repositorioLancamento.save(lancamento);
		
	}

	
}
