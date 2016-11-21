package com.smdev.ui.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.smdev.hib.domain.Subject;
import com.smdev.hib.entity.SubjectEntity;

/**
 * @author Ireth
 */
@ManagedBean(name = "subjects")
@SessionScoped
public class MBSubjects extends MBBase<SubjectEntity, Subject> {

	/** */
	private static final long serialVersionUID = 3454812755527702913L;

}
