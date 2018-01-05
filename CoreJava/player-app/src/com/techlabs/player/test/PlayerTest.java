package com.techlabs.player.test;

import com.techlabs.player.Player;

public class PlayerTest {

	public static void main(String args[]) {
		caseStudy1();
		
		Player p1=new Player(101,"A",20);
		Player p2=new Player(101,"A",20);
		
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		
	}

	private static void caseStudy1() {
		Player sachin = new Player(101, "Sachin", 45);

		Player virat = new Player(102, "Virat");

		System.out.println(sachin.getId());
		System.out.println(virat.getId());

		sachin.setAge(45);
		virat.setAge(18);

		Player elder = sachin.whoIsElder(virat);
		
		System.out.println(elder.getName());
		
		System.out.println(sachin);
		System.out.println(sachin.toString());
	}

	
}
