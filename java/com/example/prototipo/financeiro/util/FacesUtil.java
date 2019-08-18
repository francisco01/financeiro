package com.example.prototipo.financeiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesUtil {

	
	public static void adcionarMensagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(tipo, msg, msg));
	}
}
