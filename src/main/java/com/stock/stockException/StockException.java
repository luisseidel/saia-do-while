package com.stock.stockException;

import com.stock.utils.MessageUtils;

public class StockException extends Exception {

	private static final long serialVersionUID = -7546243734262026135L;

	public StockException(String msg) {
		super(getExceptionMessage(msg));
	}
	
	private static String getExceptionMessage(String msg) {
		MessageUtils.errorMessage(msg);
		return MessageUtils.getMessage(msg);
	}
}
