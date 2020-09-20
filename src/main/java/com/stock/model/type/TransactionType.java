package com.stock.model.type;

public enum TransactionType implements AbstractType {
	
	INSERT("I", "Insert"),
	DELETE("D", "Delete"),
	UPDATE("U", "Update");
	
	private String id;
	private String name;
	
	TransactionType(String id, String name) {
		setId(id);
		setName(name);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}