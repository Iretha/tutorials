package com.smdev.ui.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * IdleMonitor tracks user actions and invokes corresponding events when user
 * goes idle after a specified time and becomes active again.
 *
 * @author Ireth
 */
@ManagedBean(name = "idleMonitor")
@RequestScoped
public class MBIdleMonitor implements Serializable {
	/** */
	private static final long serialVersionUID = -7720010333413038464L;

	/** Max idle time in minutes */
	public static final Integer MAX_IDLE_TIME_IN_MINUTES = 20;

	private static final Logger LOG = LogManager.getLogger();

	/** @return max idle time */
	public Long getMaxIdleTime() {
		return (MAX_IDLE_TIME_IN_MINUTES * 60 * 1000L) - 1000;
	}

	/** On idle */
	public void onIdle() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		try {
			ec.invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "index.jsf");
		} catch (IOException ex) {
			LOG.error("Can not navigate to home page.");
		}
	}
}
