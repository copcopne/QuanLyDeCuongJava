package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Si Nguyen
 */
public class Run {

    public static void main(String[] args) throws Exception {
        HeThongQuanLy heThongQuanLy = HeThongQuanLy.taoHeThong();
        He he;
        int int_temp;
        String choice;
        boolean isLogon;
        boolean isExists;
        String s_temp;
        while (true) {
            int i = 1;
            System.out.println("Ban la? (Nhap 0 de tao giang vien moi, e de thoat)");
            for (var t : heThongQuanLy.getDsGiangVien()) {
                System.out.printf("%d. %s\n", i++, t.getTenGiangVien());
            }
            System.out.print(">");
            choice = CauHinh.SC.nextLine();
            if (choice.equals("e")) {
                return;
            } else if (choice.equals("0")) {
                System.out.print("Nhap ten giang vien: ");
                String name_t = CauHinh.SC.nextLine();
                System.out.print("Nhap ma giang vien: ");
                String ma_t = CauHinh.SC.nextLine();
                isExists = heThongQuanLy.getDsGiangVien().stream()
                        .anyMatch(g -> g.getMaGiangVien().equals(ma_t));
                if (isExists) {
                    System.out.println("Ma giang vien da ton tai, vui long thao tac lai");
                } else {
                    System.out.print("Nhap email: ");
                    String email_t = CauHinh.SC.nextLine();
                    isExists = heThongQuanLy.getDsGiangVien().stream()
                            .anyMatch(g -> g.getEmail().equals(email_t));
                    if (isExists) {
                        System.out.println("Email da ton tai, vui long thao tac lai");
                    } else {
                        System.out.print("Chon trinh do: \n1.Thac si\n2.Tien si\n");
                        System.out.print(">");
                        int_temp = Integer.parseInt(CauHinh.SC.nextLine());
                        TrinhDo t = null;
                        switch (int_temp) {

                            case 1 ->
                                t = TrinhDo.thacSi;
                            case 2 ->
                                t = TrinhDo.tienSi;
                        }
                        if (t == null) {
                            System.out.println("Thao tac sai, vui long thao tac lai");
                        } else {
                            heThongQuanLy.getDsGiangVien().add(new GiangVien(name_t, ma_t, email_t, t));
                            System.out.println("Tao giang vien moi thanh cong");
                        }
                    }
                }
            } else if (!CauHinh.CheckInteger(choice)) {
                System.out.println("Nhap khong hop le, vui long thao tac lai");
            } else if (heThongQuanLy.getDsGiangVien().size() < Integer.parseInt(choice) - 1) {
                System.out.println("Nhap khong hop le, vui long thao tac lai");
            } else {
                GiangVien gv = heThongQuanLy.getDsGiangVien().get(Integer.parseInt(choice) - 1);
                isLogon = true;
                while (isLogon) {
                    System.out.println("\n\nChao mung, " + gv.getTenGiangVien());
                    System.out.println("\n1.Tao de cuong");
                    System.out.println("2.Cap nhat thong tin de cuong da tao");
                    System.out.println("3.Tim kiem mon hoc");
                    System.out.println("4.Xac dinh danh sach mon hoc truoc va tien quyet cua mot mon");
                    System.out.println("5.Sap xep de cuong");
                    System.out.println("6.Xac dinh de cuong cua giang vien chiu trach nhiem theo ma giang vien");
                    System.out.println("7.Xuat de cuong hoan chinh");
                    System.out.println("8.Thong ke de cuong theo tin chi");
                    System.out.println("0.Dang xuat");
                    System.out.println("e.Thoat\n");

                    System.out.print(">");
                    choice = CauHinh.SC.nextLine();
                    switch (choice) {
                        case "1" -> {
                            System.out.print("\nNhap ma mon ban muon tao de cuong: ");
                            final String string_temp = CauHinh.SC.nextLine();
                            isExists = HeThongQuanLy.dsDeCuong.getDsDeCuong().stream()
                                    .anyMatch(dc -> dc.getMon().getMaMonHoc().equals(string_temp));
                            if (!HeThongQuanLy.dsMonHoc.isMonDaTonTai(string_temp)) {
                                System.out.println("Khong ton tai mon voi ma mon: " + string_temp);
                            } else if (isExists) {
                                int check = 0;
                                for (var x : HeThongQuanLy.dsDeCuong.getDsDeCuong()) {
                                    if (x.getMon().getMaMonHoc().equals(string_temp)) {
                                        check += 1;
                                    }
                                }
                                if (check == 2) {
                                    System.out.println("Mon nay da co de cuong, vui long thao tac lai");
                                } else {
                                    He a = HeThongQuanLy.dsDeCuong.getDsDeCuong().stream().filter(dc -> dc.getMon().getMaMonHoc().equals(string_temp)).findFirst().get().getHeDaoTao();
                                    System.out.println("Mon nay da co de cuong o he dao tao " + a);
                                    He b = He.chinhQuy;
                                    if (b.equals(a)) {
                                        b = He.lienThong;
                                    }
                                    System.out.println("Tien hanh tao mon voi he dao tao con lai");
                                    gv.taoMonDeCuong(b, string_temp);
                                    i = 1;
                                    int y = 0;
                                    for (var h : EnumSet.allOf(He.class)) {
                                        if (h.equals(a)) {
                                            y = i;
                                            break;
                                        }
                                        System.out.printf("%d. %s\n", i, h);
                                    }
                                    System.out.print("\n>");
                                    int_temp = Integer.parseInt(CauHinh.SC.nextLine());
                                    if (y == int_temp) {
                                        System.out.println("Loi");
                                    } else {
                                        gv.taoMonDeCuong(He.values()[int_temp - 1], string_temp);
                                    }
                                }
                            } else {
                                i = 1;
                                for (var h : EnumSet.allOf(He.class)) {
                                    System.out.printf("%d. %s\n", i++, h);
                                }
                                System.out.print("\n>");
                                int_temp = Integer.parseInt(CauHinh.SC.nextLine());
                                gv.taoMonDeCuong(He.values()[int_temp - 1], string_temp);
                            }
                        }
                        case "2" -> {
                            if (gv.getDsDeCuongBienSoan().getDsDeCuong().isEmpty()) {
                                System.out.println("Ban chua tao de cuong nao");
                            } else {
                                i = 1;
                                System.out.println("Chon mon can sua:");
                                for (var x : gv.getDsDeCuongBienSoan().getDsDeCuong()) {
                                    System.out.printf("==%2d==\nMon: %s(%s)\nHe dao tao: %s\n======\n",
                                            i++, x.getMon().getTenMonHoc(), x.getMon().getMaMonHoc(), x.getHeDaoTao());
                                }
                                System.out.print(">");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.CheckInteger(choice)) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else if (gv.getDsDeCuongBienSoan().getDsDeCuong().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else {
                                    gv.getDsDeCuongBienSoan().getDsDeCuong()
                                            .get(Integer.parseInt(choice) - 1)
                                            .capNhatThongTin();
                                }
                            }
                        }
                        case "3" -> {
                            System.out.println("3");
                        }
                        case "4" -> {
                            System.out.println("4");
                        }
                        case "5" -> {
                            System.out.println("5");
                        }
                        case "6" -> {
                            System.out.print("Nhap ma giang vien: ");
                            final String s1_temp = CauHinh.SC.nextLine();
                            if (!heThongQuanLy.getDsGiangVien().stream().anyMatch(g -> g.getMaGiangVien().equals(s1_temp))) {
                                System.out.println("Giang vien khong ton tai!!!");
                            } else {
                                GiangVien g_temp = heThongQuanLy.getDsGiangVien().stream().filter(g -> g.getMaGiangVien().equals(s1_temp)).findFirst().get();
                                List<DeCuongMonHoc> l_temp = HeThongQuanLy.dsDeCuong.getDsDeCuong().stream().filter(dc -> dc.getGiangVienBienSoan().getMaGiangVien().equals(s1_temp)).collect(Collectors.toList());
                                if (l_temp.isEmpty()) {
                                    System.out.println("Giang vien nay khong tao de cuong nao");
                                } else {
                                    System.out.printf("Danh sach giang vien %s bien soan: \n", g_temp.getTenGiangVien());
                                    l_temp.forEach(c -> {
                                        System.out.printf("=====\nMon: %s(%s)\nHe dao tao: %s\n=====\n",
                                                c.getMon().getTenMonHoc(), c.getMon().getMaMonHoc(),
                                                c.getHeDaoTao());
                                    });
                                }
                            }
                        }
                        case "7" -> {
                            System.out.println("7");
                        }
                        case "8" -> {
                            HeThongQuanLy.dsDeCuong.thongKeDeCuong();
                        }
                        case "0" -> {
                            isLogon = false;
                        }
                        case "e" -> {
                            return;
                        }
                        default -> {
                            System.out.println("Khong hop le, vui long nhap lai");
                        }
                    }
                    CauHinh.pressEnterToContinue();
                }
            }
            CauHinh.pressEnterToContinue();
        }

    }
}
