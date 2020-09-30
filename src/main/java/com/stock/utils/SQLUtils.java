package com.stock.utils;

import lombok.Builder;

@Builder
public class SQLUtils {
	
	public StringBuilder query;

	public StringBuilder select() {
		return query.append(" select ");
	}
	
	public StringBuilder from() {
		return query.append(" from ");
	}
	
	public StringBuilder where() {
		return query.append(" where ");
	}
	
	public StringBuilder and() {
		return query.append(" and ");
	}
	
}
