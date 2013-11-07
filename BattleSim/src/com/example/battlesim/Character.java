package com.example.battlesim;

public abstract class Character {
	
	private String name;
	private int str, agi, def, hp=20, exp=0, level=1;
	private int parseUserId;
	
	public Character(String n, int s, int a, int d, int p){
		this.name = n;
		this.str = s;
		this.agi = a;
		this.def = d;
		this.parseUserId = p;
	}

}
