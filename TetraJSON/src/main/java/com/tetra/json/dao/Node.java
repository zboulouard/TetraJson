package com.tetra.json.dao;

import java.util.Random;

public class Node {

	private String name;
	private Integer group;
	private Integer x;
	private Integer y;
	private Integer z;

	public Node() {
		super();
		genX();
		genY();
		genZ();
	}
	
	private void genX() {
		Integer randomNum = 0;
		Random rand = new Random();
		randomNum = 100 + rand.nextInt((999 - 100) + 1);
		this.x = randomNum;
	}
	
	private void genY() {
		Integer randomNum = 0;
		Random rand = new Random();
		randomNum = 100 + rand.nextInt((999 - 100) + 1);
		this.y = randomNum;
	}
	
	private void genZ() {
		Integer randomNum = 0;
		Random rand = new Random();
		randomNum = 100 + rand.nextInt((999 - 100) + 1);
		this.z = randomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getZ() {
		return z;
	}

	public void setZ(Integer z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
