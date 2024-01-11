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
            } else if (choice.equals("admin")) {
                boolean isEditing = true;
                while (isEditing) {
                    System.out.println("1.Them mon");
                    System.out.println("2.Xoa mon hien co");
                    System.out.println("3.Quay lai");
                    choice = CauHinh.SC.nextLine();
                    switch (choice) {
                        case "1" -> {
                            System.out.print("Nhap ma mon: ");
                            String mm = CauHinh.SC.nextLine();
                            if (HeThongQuanLy.dsMonHoc.isMonDaTonTai(mm)) {
                                System.out.println("Da ton tai mon hoc voi ma mon nay");
                            } else {
                                System.out.print("Nhap ten mon: ");
                                String tm = CauHinh.SC.nextLine();
                                System.out.print("Mo ta mon: ");
                                String mt = CauHinh.SC.nextLine();
                                System.out.print("So tin chi: ");
                                int tc = Integer.parseInt(CauHinh.SC.nextLine());
                                System.out.println("Khoi kien thuc:");
                                System.out.println("1.Mon co so");
                                System.out.println("2.Mon co so nganh");
                                System.out.println("3.Mon chuyen nganh");
                                System.out.print(">");
                                choice = CauHinh.SC.nextLine();
                                switch (choice) {
                                    case "1" -> {
                                        HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSo(mm, tm, tc, mt));
                                    }
                                    case "2" -> {
                                        HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSoNganh(mm, tm, tc, mt));
                                    }
                                    case "3" -> {
                                        HeThongQuanLy.dsMonHoc.themMonHoc(new MonChuyenNganh(mm, tm, tc, mt));
                                    }
                                    default -> {
                                        System.out.println("Khong hop le, vui long thao tac lai");
                                    }
                                }
                            }
                        }
                        case "2" -> {
                            System.out.print("Nhap ma mon: ");
                            String mm = CauHinh.SC.nextLine();
                            if (HeThongQuanLy.dsMonHoc.isMonDaTonTai(mm)) {
                                HeThongQuanLy.dsMonHoc.getDsMonHoc().removeIf(mh -> mh.getMaMonHoc().equals(mm));
                            } else {
                                System.out.println("Mon hoc khong ton tai");
                            }

                        }
                        case "3" -> {
                            isEditing = false;
                        }
                        default -> {
                            System.out.println("Khong hop le, vui long thuc hien lai");
                        }
                    }
                    CauHinh.pressEnterToContinue();
                }
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
                            GiangVien gv_temp = new GiangVien(name_t, ma_t, email_t, t);
                            gv_temp.luuFileThongTinGV();
                            heThongQuanLy.getDsGiangVien().add(gv_temp);

                            System.out.println("Tao giang vien moi thanh cong");
                        }
                    }
                }
            } else if (!CauHinh.CheckInteger(choice)) {
                System.out.println("Nhap khong hop le, vui long thao tac lai");
            } else if (Integer.parseInt(choice) - 1 < 0 && heThongQuanLy.getDsGiangVien().size() < Integer.parseInt(choice) - 1) {
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
                        case "1" -> { // tao de cuong
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
                                }
                            } else {
                                i = 1;
                                for (var h : EnumSet.allOf(He.class)) {
                                    System.out.printf("%d.%s\n", i++, h);
                                }
                                System.out.print("\n>");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.CheckInteger(choice)) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else if (Integer.parseInt(choice) - 1 < 0 && He.values().length < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else 
                                gv.taoMonDeCuong(He.values()[Integer.parseInt(choice) - 1], string_temp);
                            }
                        }
                        case "2" -> { // cap nhat thong tin de cuong
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
                                } else if (Integer.parseInt(choice) - 1 < 0 && gv.getDsDeCuongBienSoan().getDsDeCuong().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else {
                                    gv.getDsDeCuongBienSoan().getDsDeCuong()
                                            .get(Integer.parseInt(choice) - 1)
                                            .capNhatThongTin();
                                }
                            }
                        }
                        case "3" -> { // tim kiem mon hoc
                            System.out.print("Nhap ma mon hoc can tim: ");
                            s_temp = CauHinh.SC.nextLine();
                            if (HeThongQuanLy.dsMonHoc.isMonDaTonTai(s_temp)) {
                                System.out.println(HeThongQuanLy.dsMonHoc.timKiemMonBangMa(s_temp));
                            } else {
                                System.out.println("Mon hoc khong ton tai trong he thong");
                            }
                        }
                        case "4" -> { // xac dinh danh sach mon hoc trc va tien quyet ( can test :)) )
                            System.out.print("Nhap ma mon hoc: ");
                            final String s4_temp = CauHinh.SC.nextLine();
                            if (!HeThongQuanLy.dsMonHoc.isMonDaTonTai(s4_temp)) {
                                System.out.println("Mon hoc khong ton tai");
                            } else {
                                List<DeCuongMonHoc> mhTruoc = HeThongQuanLy.dsDeCuong.getDsDeCuong().stream()
                                        .filter(dc -> dc.getMonHocTruoc().getDsMonHoc().stream()
                                        .anyMatch(dc1 -> dc1.getMaMonHoc().equals(s4_temp)))
                                        .collect(Collectors.toList());
                                List<DeCuongMonHoc> mhTienQuyet = HeThongQuanLy.dsDeCuong.getDsDeCuong().stream()
                                        .filter(dc -> dc.getMonHocTienQuyet().getDsMonHoc().stream()
                                        .anyMatch(dc1 -> dc1.getMaMonHoc().equals(s4_temp)))
                                        .collect(Collectors.toList());
                                if (mhTruoc.isEmpty()) {
                                    System.out.println("Mon hoc nay khong phai la mon hoc truoc cua mon hoc nao");
                                } else {
                                    System.out.println("Danh sach mon hoc truoc: ");
                                    mhTruoc.forEach(mh -> System.out.printf("%s(%s), ", mh.getMon().getTenMonHoc(), mh.getMon().getMaMonHoc()));
                                    System.out.println(".");
                                }
                                if (mhTienQuyet.isEmpty()) {
                                    System.out.println("Mon hoc nay khong phai la mon hoc tien quyet cua mon hoc nao");
                                } else {
                                    System.out.println("Danh sach mon hoc tien quyet: ");
                                    mhTienQuyet.forEach(mh -> System.out.printf("%s(%s), ", mh.getMon().getTenMonHoc(), mh.getMon().getMaMonHoc()));
                                    System.out.println(".");
                                }
                            }
                        }
                        case "5" -> { // sap xep de cuong (can test)
                            HeThongQuanLy.dsDeCuong.sapXepDeCuong();
                            System.out.println("Sap xep thanh cong!");
                            HeThongQuanLy.dsDeCuong.xuatDanhSach();
                        }
                        case "6" -> { // tim de cuong do 1 giang vien bien soan
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
                        case "7" -> { // xuat dc hoan chinh
                            i = 1;
                            if (gv.getDsDeCuongBienSoan().getDsDeCuong().isEmpty()) {
                                System.out.println("Ban khong co de cuong de xuat");
                            } else {
//                                for (var x : gv.getDsDeCuongBienSoan().getDsDeCuong()) {
//                                    System.out.printf("%d\n", i++);
//                                    x.xuatDeCuong();
//                                }
                                for (var x : gv.getDsDeCuongBienSoan().getDsDeCuong()) {
                                    System.out.printf("==%2d ==\nMon: %s(%s)\nHe dao tao: %s\n======\n",
                                            i++, x.getMon().getTenMonHoc(), x.getMon().getMaMonHoc(), x.getHeDaoTao());
                                }
                                System.out.println("Chon de cuong muon xuat");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.CheckInteger(choice)) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else if (Integer.parseInt(choice) - 1 < 0 && gv.getDsDeCuongBienSoan().getDsDeCuong().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le, vui long thao tac lai");
                                } else {
                                    DeCuongMonHoc dc_temp = gv.getDsDeCuongBienSoan().getDsDeCuong().get(Integer.parseInt(choice) - 1);
                                    if (!dc_temp.isDeCuongHopLe()) {
                                        System.out.println("De cuong chua hop le, chua the xuat de cuong");
                                    } else {
                                        gv.luuFileDeCuong();
                                        dc_temp.xuatDeCuong();
                                    }
                                }
                            }
                        }
                        case "8" -> { // thong ke de cuong
                            HeThongQuanLy.dsDeCuong.thongKeDeCuong();
                        }
                        case "0" -> { // dang xuat
                            gv.luuFileDeCuong();
                            isLogon = false;
                        }
                        case "e" -> { // thoat
                            gv.luuFileDeCuong();
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
