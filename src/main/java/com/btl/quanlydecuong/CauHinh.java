package com.btl.quanlydecuong;

import java.util.Scanner;

public class CauHinh {
    protected static DeCuongMonHoc DCMonHoc_temp;
    protected static HinhThuc hinhThuc_temp;
    protected static final Scanner SC = new Scanner(System.in);

    public CauHinh() {
    }
    public static boolean CheckInteger(String input) { 
        try { 
            Integer.valueOf(input); 
            return true;
        } catch (NumberFormatException e) { 
            return false;
        } 
    } 
}
