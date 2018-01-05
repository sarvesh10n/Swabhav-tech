package com.techlabs.player;

public class Player {

	private int id;
	private String name;
	private int age;

	public Player(int id, String name) {
		this(id,name,18);
	}

	public Player(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Player whoIsElder(Player player) {
		if (this.age > player.age)
			return this;
		else
			return player;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString()
	{
		System.out.println(age);
		System.out.println(name);
		System.out.println(id);
		return "";
	}
	
	@Override
	public boolean equals(Object player)
	{
		if(this.id==((Player)player).id)
			return true;
		else 
			return false; 
	}
	
}
