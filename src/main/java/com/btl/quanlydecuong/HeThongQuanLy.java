package com.btl.quanlydecuong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeThongQuanLy {

    private List<GiangVien> dsGiangVien = new ArrayList<>();
    protected static DanhSachDeCuong dsDeCuong;
    protected static DanhSachMonHoc dsMonHoc;
    private static boolean isCreated = false;

    public List<GiangVien> getDsGiangVien() {
        return dsGiangVien;
    }

    public void setDsGiangVien(List<GiangVien> dsGiangVien) {
        this.dsGiangVien = dsGiangVien;
    }

    static {
        dsDeCuong = new DanhSachDeCuong();
        dsMonHoc = new DanhSachMonHoc();
    }

    private HeThongQuanLy() throws Exception {
        HeThongQuanLy.isCreated = true;

        //Đọc danh sách môn
        File file = new File("monhoc.txt");
        if (!file.isFile() && !file.createNewFile()) {
            throw new Exception("Loi khi tao file moi: " + file.getAbsolutePath());
        }
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\|");
        while (sc.hasNextLine()) {
            String khoi = sc.next();
            String maMon = sc.next();
            String tenMon = sc.next();
            String moTaMon = sc.next();
            Double soTinChi = sc.nextDouble();
            switch (khoi) {
                case "CN" ->
                    HeThongQuanLy.dsMonHoc.themMonHoc(new MonChuyenNganh(maMon, tenMon, soTinChi, moTaMon));
                case "CS" ->
                    HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSo(maMon, tenMon, soTinChi, moTaMon));
                case "CSN" ->
                    HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSoNganh(maMon, tenMon, soTinChi, moTaMon));
            }
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
        }
        //Đọc danh sách giảng viên
        File folder = new File("Giangvien");
        if (!folder.mkdir() && !folder.isDirectory()) {
            throw new Exception("Loi khi tao thu muc: " + folder.getAbsolutePath());
        }
        try (Stream<Path> paths = Files.walk(Paths.get(folder.getAbsolutePath()))) {
            paths.filter(Files::isDirectory).skip(1).forEach(sub -> {
                //Doc tung subfolder trong folder GiangVien

                //Doc file ThongTinGV.txt trong subfolder
                try {
                    Scanner sc1 = new Scanner(sub.resolve("ThongTinGV.txt"));
                    sc1.useDelimiter("\\|");
                    while (sc1.hasNextLine()) {
                        String tenGiangVien = sc1.next();
                        String maGiangVien = sc1.next();
                        String email = sc1.next();
                        String trinhDo = sc1.next();
                        this.dsGiangVien.add(new GiangVien(tenGiangVien,maGiangVien,email,trinhDo));
                        this.dsGiangVien.forEach(gv->System.out.println(gv.getMaGiangVien()));
                        if (sc1.hasNextLine()) {
                            sc1.nextLine();
                        }
                    }
                } catch (IOException ex) {
                    System.err.println("Khong tim thay thong tin cua giang vien " + sub.getFileName());
                }

                
            });
        } catch (IOException e) {
            System.out.print(e);
        }

    }

    public static HeThongQuanLy taoHeThong() throws Exception {
        if (HeThongQuanLy.isCreated == false) {
            return new HeThongQuanLy();
        } else {
            throw new Exception("Da ton tai he thong quan ly");
        }
    }

    public void themGiangVien(GiangVien... g) {
        this.dsGiangVien.addAll(Arrays.asList(g));
    }

    public void themGiangVien(GiangVien g) {
        this.dsGiangVien.add(g);
    }

    public void xoaGiangVien(String kw) {
        this.dsGiangVien.removeIf(g -> g.getTenGiangVien().contains(kw)
                || g.getMaGiangVien().equals(kw));
    }

    public void xoaGiangVien(GiangVien g) {
        this.dsGiangVien.remove(g);
    }

    public GiangVien timGiangVien(String maGiangVien) {
        return this.dsGiangVien.stream().filter(g -> g.getMaGiangVien()
                .equals(maGiangVien)).findFirst().get();
    }

    public DanhSachDeCuong deCuongTheoGV(String maGiangVien) {
        DanhSachDeCuong ds = timGiangVien(maGiangVien).getDsDeCuongBienSoan();
        ds.xuatDanhSach();
        return ds;
    }
}
