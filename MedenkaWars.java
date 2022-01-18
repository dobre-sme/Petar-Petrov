package com.company;

import java.util.Scanner;

public class MedenkaWars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		double naskorDmg = 0.0;
		double vitkorDmg = 0.0;
		double vitkorCurrentAttackDmg = 0;
		double naskorCurrentAttackDmg = 0;
		int naskorAttackCounter = 0;
		int vitcorAttackCounter = 0;
		while (!input[0].equals("end")) {
			double dmg = Double.parseDouble(input[0]) * 60;
			if (input[1].equals("white")) {
				if (vitkorCurrentAttackDmg == dmg) {
					vitcorAttackCounter++;
					if (vitcorAttackCounter == 2) {
						dmg = dmg * 2.75;
						vitcorAttackCounter = 0;
					}
				}
				vitkorCurrentAttackDmg = dmg;
				vitkorDmg += dmg;
			} else {
				if (naskorCurrentAttackDmg == dmg) {
					naskorAttackCounter++;
					if (naskorAttackCounter == 4) {
						dmg = dmg * 4.5;
						naskorAttackCounter = 0;
					}
				}
				naskorCurrentAttackDmg = dmg;
				naskorDmg += dmg;
			}
			input = scan.nextLine().split(" ");
		}
		if (naskorDmg > vitkorDmg) {
			System.out.printf("Winner - Naskor %nDamage - %.0f", naskorDmg);
		} else {
			System.out.printf("Winner - Vitcor %nDamage - %.0f", vitkorDmg);
		}
	}
}
