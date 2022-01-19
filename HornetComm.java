package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HornetComm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" <-> ");
		boolean onlyDigits = true;
		List<String[]> privateMessages = new ArrayList<>();
		List<String[]> broadcasts = new ArrayList<>();
		while (!input[0].equals("Hornet is Green")) {
			for (int i = 0; i < input[0].length(); i++) {
				onlyDigits = Character.isDigit(input[0].charAt(i));
			}
			if (onlyDigits) {
				boolean isMessage = true;
				String message = input[1];
				for (int i = 0; i < message.length(); i++) {
					if (Character.isDigit(message.charAt(i)) || Character.isLetter(message.charAt(i))) {
					} else {
						isMessage = false;
					}
				}
				if (isMessage) {
					privateMessages.add(input);
				}
			} else if (input.length > 1) {
				broadcasts.add(input);
			}
			onlyDigits = true;
			input = scan.nextLine().split(" <-> ");
		}
		System.out.println("Broadcasts:");
		for (int i = 0; i < broadcasts.size(); i++) {
			String[] currentBroadcast = broadcasts.get(i);
			String frequency = currentBroadcast[1];
			String message = currentBroadcast[0];
			for (int j = 0; j < frequency.length(); j++) {
				if (Character.isLetter(frequency.charAt(j))) {
					if (Character.isLowerCase(frequency.charAt(j))) {
						char currentSymbol = Character.toUpperCase(frequency.charAt(j));
						System.out.print(currentSymbol);
					} else {
						char currentSymbol = Character.toLowerCase(frequency.charAt(j));
						System.out.print(currentSymbol);
					}
				} else {
					System.out.print(frequency.charAt(j));
				}

			}
			System.out.printf(" -> %s", message);
			System.out.println();
		}
		System.out.println("Messages:");
		for (int i = 0; i < privateMessages.size(); i++) {
			String[] currentMessage = privateMessages.get(i);
			String recipient = currentMessage[0];
			String message = currentMessage[1];
			for (int j = recipient.length() - 1; j >= 0; j--) {
				System.out.print(recipient.charAt(j));
			}
			System.out.print(" -> ");
			System.out.print(message);
			System.out.println();
		}
		if (privateMessages.size() == 0) {
			System.out.println("None");
		}
		}
	}