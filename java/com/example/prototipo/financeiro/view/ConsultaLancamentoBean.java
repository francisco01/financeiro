package com.example.prototipo.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.prototipo.financeiro.model.Lancamento;
import com.example.prototipo.financeiro.repository.RepositorioLancamento;
import com.example.prototipo.financeiro.service.ILancamentoService;
import com.example.prototipo.financeiro.service.impl.RegrasNegocioException;
import com.example.prototipo.financeiro.util.FacesUtil;

@Component
@Scope("view")
public class ConsultaLancamentoBean implements Serializable {

	@Autowired
	private RepositorioLancamento repositorioLancamento;

	@Autowired
	private ILancamentoService lancamentoService;

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;

	@PostConstruct
	public void init() {
		this.lancamentos = repositorioLancamento.findAll();
	}

	public void excluir() {

		try {
			this.lancamentoService.excluir(lancamentoSelecionado);
			this.init();
			FacesUtil.adcionarMensagem(FacesMessage.SEVERITY_INFO, "Lancamento excluido com sucesso!");
		} catch (RegrasNegocioException e) {
			FacesUtil.adcionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;

	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}
