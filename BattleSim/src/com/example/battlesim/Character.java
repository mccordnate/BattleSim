package com.example.battlesim;

import java.util.Date;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class Character {
	
	private String name;
	private int str, agi, def, subStr = 0, subAgi = 0, subDef = 0, hp=20, exp=0, level=1, wins = 0, losses = 0, energy = 3;
	private Date lastEnergyUse = new Date(0);
	private String classy;
	
	public Character(String n, int s, int a, int d, String c){
		this.name = n;
		this.str = s;
		this.agi = a;
		this.def = d;
		this.classy = c;
		
		ParseObject parseChar = new ParseObject("Character");
		
		parseChar.put("user",ParseUser.getCurrentUser());
		parseChar.put("name",n);
		parseChar.put("str",s);
		parseChar.put("agi",a);
		parseChar.put("def",d);
		parseChar.put("subStr",subStr);
		parseChar.put("subAgi", subAgi);
		parseChar.put("subDef", subDef);
		parseChar.put("hp",hp);
		parseChar.put("exp",exp);
		parseChar.put("level",level);
		parseChar.put("class",classy);
		parseChar.put("username",ParseUser.getCurrentUser().getUsername());
		parseChar.put("energy",energy);
		parseChar.put("lastEnergyUse",lastEnergyUse);
		try {
			parseChar.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
