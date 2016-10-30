package com.bolaodamega.megasena.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.bolaodamega.megasena.domain.Game;
import com.bolaodamega.megasena.roles.NumberInQuadrantRole;
import com.bolaodamega.megasena.roles.NumbersLateralRole;
import com.bolaodamega.megasena.roles.NumbersOddsAndEvenRole;
import com.bolaodamega.megasena.roles.NumbersSameColumnRole;
import com.bolaodamega.megasena.roles.NumbersSameRowRole;
import com.bolaodamega.megasena.roles.NumbersSequentialRole;
import com.bolaodamega.megasena.roles.Role;

public class Validate {

	public static void main(String[] args) {
		validate();
	}

	private static void validate() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		System.out.println("Digite Dezena 01: ");
		game.setNumber01(Integer.valueOf(scanner.nextLine()));
		System.out.println("Digite Dezena 02: ");
		game.setNumber02(Integer.valueOf(scanner.nextLine()));
		System.out.println("Digite Dezena 03: ");
		game.setNumber03(Integer.valueOf(scanner.nextLine()));
		System.out.println("Digite Dezena 04: ");
		game.setNumber04(Integer.valueOf(scanner.nextLine()));
		System.out.println("Digite Dezena 05: ");
		game.setNumber05(Integer.valueOf(scanner.nextLine()));
		System.out.println("Digite Dezena 06: ");
		game.setNumber06(Integer.valueOf(scanner.nextLine()));
		
		Set<Role> roles = new HashSet<>();
		roles.add(new NumbersSequentialRole());
		roles.add(new NumbersOddsAndEvenRole());
		roles.add(new NumbersSameRowRole());
		roles.add(new NumbersSameColumnRole());
		roles.add(new NumbersLateralRole());
		roles.add(new NumberInQuadrantRole());

		for (Role role : roles) {
			boolean isInvalid = role.validate(game);
			if (isInvalid) {
				System.out.println("INVALID (" + role.getClass() + ")" + game);
				break;
			}
		}
		validate();
	}
}
