package com.example.prototipo.financeiro.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

import com.example.prototipo.financeiro.model.Lancamento;
import com.example.prototipo.financeiro.model.Pessoa;
import com.example.prototipo.financeiro.model.TipoLancamento;
import com.example.prototipo.financeiro.repository.RepositorioLancamento;
import com.example.prototipo.financeiro.repository.RepositorioPessoa;
import com.example.prototipo.financeiro.service.ILancamentoService;
import com.example.prototipo.financeiro.util.FacesUtil;

@Component
@Scope("view")
public class CadastroLancamentoBean implements Serializable {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento =new Lancamento();
	private Lancamento lancamentoSelecionado = new Lancamento();

	@Autowired
	private RepositorioPessoa repositorioPessoa;
	
	@Autowired
	private RepositorioLancamento repositorioLancamento;

	@Autowired
	private ILancamentoService lancamentoService;

	@PostConstruct
	public void init() {
		if (lancamentoSelecionado != null) {
			this.lancamento = lancamentoSelecionado;
		} else {
			this.pessoas = repositorioPessoa.findAll();
		}

	}
	
	public void updateLancamento() {
		this.repositorioLancamento.save(lancamentoSelecionado);
		FacesUtil.adcionarMensagem(FacesMessage.SEVERITY_INFO, "Lancamento alterado com sucesso!");
	}

	public void lancamentoPago(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void lancamentoSelecionadoPago(ValueChangeEvent event) {
		this.lancamentoSelecionado.setPago((Boolean) event.getNewValue());
		//this.lancamentoSelecionado.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public TipoLancamento[] getTiposLancamento() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public void cadastrar() {
		this.lancamentoService.salvar(lancamento);
		this.lancamento = new Lancamento();
		String msg = "Cadastro efetutado com sucesso";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public void alterar() throws IOException {
		// FacesContext.getCurrentInstance().getExternalContext().redirect("/CadastroLancamento.xhtml");
		
		System.out.println("Teste");

		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("formEditarLancamento");
		RequestContext context;
		
		//return "/CadastroLancamento.faces?faces-redirect=true";
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}
