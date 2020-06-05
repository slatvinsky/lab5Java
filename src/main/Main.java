package main;

import java.io.IOException;
import java.sql.Struct;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }

    private void run() {
        DoubleArrReader dar = new DoubleArrReader();
        ArrProcessor arp = new ArrProcessor();
        String[] strs = userFileOpenTypeChoose();
        String path;
        if (strs[0].equals("true")) {
            path = strs[1]+".txt";
        } else {
            path = "example.txt";
        }
        double[] oneD_arr = dar.readOneDimensionalArray(path);
        System.out.println("1D array length: " + oneD_arr.length);
        double[][] twoD_arr = dar.readTwoDimensionalArray(path);
        System.out.println("2D array length: " + (twoD_arr.length * twoD_arr.length));
        int arrNum = userArrayChoose();
        if (arrNum == 1) {
            System.out.println("Result of 1D arr: " + arp.calculate(oneD_arr) + "\nVisualizer:");
            arp.processArray(oneD_arr);
        } else {
            System.out.println("Result of 2D arr: " + arp.calculate(twoD_arr) + "\nVisualizer:");
            arp.processArray(twoD_arr);
        }
    }

    private String[] userFileOpenTypeChoose() {
        Scanner in = new Scanner(System.in);
        String[] strs = new String[2];
        System.out.println("Do you want to open file by name(y) or open default(n) file?");
        while (true) {
            char buff = in.nextLine().charAt(0);
            if (buff == 'y') {
                strs[0] = "true";
                System.out.println("Enter filename without .txt:");
                while (true) {
                    String[] buf = in.nextLine().split(" ");
                    if (buf[0].equals("")) {
                        System.out.println("Incorrect input! Try to type filename without .txt!");
                    } else {
                        strs[1] = buf[0];
                        break;
                    }
                }
                break;
            } else if (buff == 'n') {
                strs[0] = "false";
                break;
            } else {
                System.out.println("Incorrect input! Try to type y or n!");
            }
        }
        return strs;
    }

    private int userArrayChoose() {
        Scanner in = new Scanner(System.in);
        System.out.println("What array you choose? 1/2");
        while (true) {
            int buff = in.nextInt();
            if (buff == 1) {
                return 1;
            } else if (buff == 2) {
                return 2;
            } else {
                System.out.println("Incorrect input! Try to type 1 or 2!");
            }
        }
    }
}

