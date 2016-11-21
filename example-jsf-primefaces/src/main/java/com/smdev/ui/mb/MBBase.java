package com.smdev.ui.mb;

import java.io.Serializable;

import com.smdev.hib.core.DBEntry;
import com.smdev.hib.core.DomainObject;

/**
 * @author Ireth
 */
public abstract class MBBase<E extends DBEntry, D extends DomainObject<E>> implements Serializable {

	/** */
	private static final long serialVersionUID = -4006851921661994570L;

}
