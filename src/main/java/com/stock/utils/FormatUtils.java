package com.stock.utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("formatU")
public class FormatUtils {

	public static String formatCpf(String cpf) {
		return format(MessageUtils.getLabel("cpf_mask"), cpf, false);
	}
	
	public static String formatCnpj(String cnpj) {
		return format(MessageUtils.getLabel("cnpj_mask"), cnpj, false);
	}
	
	public static String formatDate(String date) {
		return format(MessageUtils.getLabel("date_mask"), date, false);
	}
	
	
	public static String format(String pattern, Object value, boolean suppressZero) {
	    if (!suppressZero || Double.parseDouble(value.toString()) != 0) {
	        MaskFormatter mask;
	        try {
	            mask = new MaskFormatter(pattern);
	            mask.setValueContainsLiteralCharacters(false);
	            return mask.valueToString(value);
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }
	    } else {
	        return "";
	    }
	}
}
