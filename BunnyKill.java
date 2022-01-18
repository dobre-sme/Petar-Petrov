package com.company;

import java.util.Scanner;

public class BunnyKill {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int matrixSize = input.length;
		int[][] positions = new int[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				positions[i][j] = Integer.parseInt(input[j]);
			}
			input = scan.nextLine().split(" ");
		}
		int damageCounter = 0;
		int killsCounter = 0;
		String[] coordinates = input;
		for (int i = 0; i < coordinates.length; i++) {
			String[] currentCoordinates = coordinates[i].split(",");
			int row = Integer.parseInt(currentCoordinates[0]);
			int column = Integer.parseInt(currentCoordinates[1]);
			int bombDamage = positions[row][column];
			damageCounter += positions[row][column];
			killsCounter += 1;
			positions[row][column] = 0;
			if (row > 0) {
				positions[row - 1][column] -= bombDamage;
			}
			if (column > 0) {
				positions[row][column - 1] -= bombDamage;
			}
			if (row > 0 && column > 0) {
				positions[row - 1][column - 1] -= bombDamage;
			}
			if (row < matrixSize - 1) {
				positions[row + 1][column] -= bombDamage;
			}
			if (column < matrixSize - 1) {
				positions[row][column + 1] -= bombDamage;
			}
			if (row < matrixSize - 1 && column < matrixSize - 1) {
				positions[row + 1][column + 1] -= bombDamage;
			}
			if (row < matrixSize - 1 && column > 0) {
				positions[row + 1][column - 1] -= bombDamage;
			}
			if (row > 0 && column < matrixSize - 1) {
				positions[row - 1][column + 1] -= bombDamage;
			}
		}
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (positions[i][j] > 0) {
					damageCounter += positions[i][j];
					killsCounter += 1;
				}
			}
		}
		System.out.println(damageCounter);
		System.out.println(killsCounter);
		}
	}