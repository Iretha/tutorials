package com.smdev.ui.mb;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Ireth
 */
@ManagedBean(name = "locale")
@SessionScoped
public class MBLocale implements Serializable {

	/** */
	private static final long serialVersionUID = -5275296411898927564L;

	/** @return Locale */
	public Locale getLocale() {
		return new Locale("en_US");
	}
}
