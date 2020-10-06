package com.stock.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("validationU")
public class ValidationUtils {

	public static boolean validateCNPJ(String cnpj) {
		cnpj = removeSpecialChars(cnpj);
		
		if(StringUtils.isBlank(cnpj)) 
			return true;
		
		if (cnpj.length() != 14) 
			return false;
			
		if (cnpj.contentEquals("00000000000000") || 
	        cnpj.contentEquals("11111111111111") || 
	        cnpj.contentEquals("22222222222222") || 
	        cnpj.contentEquals("33333333333333") || 
	        cnpj.contentEquals("44444444444444") || 
	        cnpj.contentEquals("55555555555555") || 
	        cnpj.contentEquals("66666666666666") || 
	        cnpj.contentEquals("77777777777777") || 
	        cnpj.contentEquals("88888888888888") || 
	        cnpj.contentEquals("99999999999999"))
	        return false;

		int tamanho = cnpj.length() - 2;
	    String numeros = cnpj.substring(0,tamanho);
	    String digitos = cnpj.substring(tamanho);
	    int soma = 0;
	    int pos = tamanho - 7;
	    for (int i = tamanho; i >= 1; i--) {
	      soma += numeros.charAt(tamanho - i) * pos--;
	      if (pos < 2)
	            pos = 9;
	    }
	    int resultado = (soma % 11 < 2) ? 0 : (11 - soma % 11);
	    
	    if (resultado != digitos.charAt(0))
	        return false;
	         
	    tamanho = tamanho + 1;
	    numeros = cnpj.substring(0,tamanho);
	    soma = 0;
	    pos = tamanho - 7;
	    
	    for (int i = tamanho; i >= 1; i--) {
	      soma += numeros.charAt(tamanho - i) * pos--;
	      if (pos < 2)
	            pos = 9;
	    }
	    
	    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	    
	    if (resultado != digitos.charAt(1))
	          return false;
	           
	    return true;
	}
	
	private static String removeSpecialChars(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		return doc;
	}
	
}
