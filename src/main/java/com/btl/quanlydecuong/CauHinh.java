package com.btl.quanlydecuong;

import java.io.IOException;
import java.util.Scanner;

public class CauHinh {

    protected static DeCuongMonHoc DCMonHoc_temp;
    protected static HinhThuc hinhThuc_temp;
    protected static final Scanner SC = new Scanner(System.in);

    public CauHinh() {
    }

    public static boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }
}
