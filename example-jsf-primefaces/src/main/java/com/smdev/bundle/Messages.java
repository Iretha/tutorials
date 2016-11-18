package com.smdev.bundle;

import com.sm4j.exception.IMessageKey;

public enum Messages implements IMessageKey {
	please_wait,
	reload,
	view_expired,
	home;

	@Override
	public String getBundleName() {
		return "bundle.messages";
	}

	@Override
	public String getMessageKey() {
		return name();
	}

}
