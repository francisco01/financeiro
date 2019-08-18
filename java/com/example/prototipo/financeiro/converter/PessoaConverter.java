package com.example.prototipo.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.prototipo.financeiro.model.Pessoa;
import com.example.prototipo.financeiro.repository.RepositorioPessoa;

@Component("pessoaConverter")
public class PessoaConverter implements Converter<Pessoa> {

	@Autowired
	private RepositorioPessoa repositorioPessoa;
	
	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {

		Pessoa retorno = null;
		if (value != null) {
			retorno = repositorioPessoa.findByCodigo(Long.valueOf(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Pessoa value) {
		if (value != null) {
			return value.getCodigo().toString();
		}
		return null;
	}

}
