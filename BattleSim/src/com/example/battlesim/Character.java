package com.example.battlesim;

public class Character {
	
	private String name;
	private int str, agi, def, hp=20, exp=0, level=1;
	
	public Character(String n, int s, int a, int d){
		this.name = n;
		this.str = s;
		this.agi = a;
		this.def = d;
	}

	public String getName() {
		return name;
	}

	public int getStr() {
		return str;
	}

	public int getAgi() {
		return agi;
	}

	public int getDef() {
		return def;
	}

	public int getHp() {
		return hp;
	}

	public int getExp() {
		return exp;
	}

	public int getLevel() {
		return level;
	}

}
