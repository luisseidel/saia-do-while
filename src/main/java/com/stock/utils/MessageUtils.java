package com.stock.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtils {
	
	private static final ResourceBundle messages = ResourceBundle.getBundle("com.stock.resources.messages_pt_BR");
	private static final ResourceBundle labels = ResourceBundle.getBundle("com.stock.resources.labels_pt_BR");
	
	public static String getMessage(String key) {
	    if (messages.containsKey(key)) {
	        return messages.getString(key);
	    } else {
		throw new MissingResourceException(messages.getString("error_Message_Not_Found"), messages.getClass().getName(), key);
	    }
	}
	
	public static String getLabel(String key) {
		if (labels.containsKey(key)) {
	        return labels.getString(key);
	    } else {
		throw new MissingResourceException(messages.getString("error_Message_Not_Found"), messages.getClass().getName(), key);
	    }
	}
	
	public static void insertMessage() {
	    FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageUtils.getMessage("msg_insert")));
	}
	
	public static void updateMessage() {
	    FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageUtils.getMessage("msg_update")));
	}
	
	public static void deleteMessage() {
	    FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageUtils.getMessage("msg_delete")));
	}
	
	public static void infoMessage(String key) {	
		String message = getMessage(key);
		FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", message));
	}
	
	public static void warnMessage(String key) {	
		String message = getMessage(key);
		FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", message));
	}
	
	public static void errorMessage(String key) {	
		String message = getMessage(key);
		FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", message));
	}
	
	public static void fatalMessage(String key) {	
		String message = getMessage(key);
		FacesContext context = FacesContext.getCurrentInstance();        
	    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "", message));
	}
	
}
