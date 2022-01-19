package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HornetAssault {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputBeehives = scan.nextLine().split(" ");
        String[] inputHornets = scan.nextLine().split(" ");
        List<Integer> beehives = new ArrayList<>();
        List<Integer> hornets = new ArrayList<>();
        int hornetsPower = 0;
        int liveBeehives = beehives.size();
        for (int i = 0; i < inputBeehives.length; i++) {
            int currentBeehive = Integer.parseInt(inputBeehives[i]);
            beehives.add(currentBeehive);
        }
        for (int i = 0; i < inputHornets.length; i++) {
            int currentHornetPower = Integer.parseInt(inputHornets[i]);
            hornets.add(currentHornetPower);
            hornetsPower += currentHornetPower;
        }
        // END INPUT

        for (int i = 0; i < beehives.size(); i++) {
            if (hornetsPower > beehives.get(i)) {
                beehives.set(i, 0);
                liveBeehives--;
            } else {
                beehives.set(i, beehives.get(i) - hornetsPower);
                hornetsPower -= hornets.get(0);
                hornets.remove(0);
            }
        }

        // END HORNETS ATTACK

        if (liveBeehives > 0) {
            for (int i = 0; i < beehives.size(); i++) {
                if (beehives.get(i) > 0) {
                    System.out.println(beehives.get(i) + " ");
                }
            }
        } else {
            for (int i = 0; i < hornets.size(); i++) {
                System.out.print(hornets.get(i) + " ");
            }
        }
    }
}