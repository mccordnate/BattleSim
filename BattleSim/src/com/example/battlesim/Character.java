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

}
