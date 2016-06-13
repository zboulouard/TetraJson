package com.tetra.json.dao;

public class Link {

	private Integer source;
	private Integer target;
	private Integer value;
	
	public Link() {
		super();
	}
	
	public Integer getSource() {
		return source;
	}
	
	public void setSource(Integer source) {
		this.source = source;
	}
	
	public Integer getTarget() {
		return target;
	}
	
	public void setTarget(Integer target) {
		this.target = target;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Link [source=" + source + ", target=" + target + "]";
	}
	
}
