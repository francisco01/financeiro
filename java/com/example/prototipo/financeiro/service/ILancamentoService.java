package com.example.prototipo.financeiro.service;

import com.example.prototipo.financeiro.model.Lancamento;
import com.example.prototipo.financeiro.service.impl.RegrasNegocioException;

public interface ILancamentoService {

	public void excluir(Lancamento lancamento) throws RegrasNegocioException;
	public void salvar(Lancamento lancamento);
}
