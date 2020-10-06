package com.stock.model.type;

public enum TransactionType implements AbstractType {
	
	INSERT("I", "Insert", "edit.xhtml"),
	DELETE("D", "Delete", "list.xhtml"),
	UPDATE("U", "Update", "edit.xhtml"),
	SEARCH("S", "Search", "list.xhtml");
	
	private String id;
	private String name;
	private String screen;
	
	TransactionType(String id, String name, String screen) {
		setId(id);
		setName(name);
		setScreen(screen);
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
	
	public String getScreen() {
		return screen;
	}
	
	public void setScreen(String screen) {
		this.screen = screen;
	}
}