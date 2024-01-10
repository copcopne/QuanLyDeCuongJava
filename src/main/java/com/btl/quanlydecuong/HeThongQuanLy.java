package com.btl.quanlydecuong;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
        sc.useDelimiter("\\s*\\|\\s*");
        while (sc.hasNext()) {
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
        }
        //Đọc danh sách giảng viên
        File folder = new File("Giangvien");
        if (!folder.mkdir() && !folder.isDirectory()) {
            throw new Exception("Loi khi tao thu muc: " + folder.getAbsolutePath());
        }
        try (Stream<Path> paths = Files.walk(Paths.get(folder.getAbsolutePath()))) {
            paths.filter(Files::isDirectory).skip(1).forEach(sub -> {
                //Đọc từng subfolder của folder GiangVien

                //Đọc file ThongTinGV.txt trong subfolder
                try (Scanner sc1 = new Scanner(sub.resolve("ThongTinGV.txt"))) {
                    sc1.useDelimiter("\\s*\\|\\s*");
                    while (sc1.hasNext()) {
                        String tenGiangVien = sc1.next();
                        String maGiangVien = sc1.next();
                        String email = sc1.next();
                        String t = sc1.next();
                        TrinhDo trinhDo = null;
                        switch (t) {
                            case "tienSi" ->
                                trinhDo = TrinhDo.thacSi;
                            case "thacSi" ->
                                trinhDo = TrinhDo.tienSi;
                        }
                        this.dsGiangVien.add(new GiangVien(tenGiangVien, maGiangVien, email, trinhDo));
                    }
                } catch (IOException | NoSuchElementException ex) {
                    System.err.println("Khong doc duoc thong tin cua giang vien " + sub.getFileName());
                }

                //Đọc file DSDeCuong.txt trong subfolder
                try (Scanner sc2 = new Scanner(sub.resolve("DSDeCuong.txt"))) {
                    sc2.useDelimiter("\\s*\\|\\s*");
                    while (sc2.hasNext()) {
                        String maMon = sc2.next();
                        String heStr = sc2.next();
                        String noiDungMon = sc2.next();
                        String mucTieu = sc2.next();
                        String hinhThucDanhGia = sc2.next();
                        String chuanDauRa = sc2.next();
                        String maGV = sc2.next();
                        String maMonHocTienQuyet = sc2.next();
                        String maMonHocTruoc = sc2.next();

                        //xử lý hệ
                        He he = null;
                        switch (heStr) {
                            case "CQ" ->
                                he = He.chinhQuy;
                            case "LT" ->
                                he = He.lienThong;
                        }

                        //xử lý môn học tiên quyết và môn học 
                        DanhSachMonHoc dsMonTienQuyet = stringMaMonThanhMonHoc(maMonHocTienQuyet);
                        DanhSachMonHoc dsMonHocTruoc = stringMaMonThanhMonHoc(maMonHocTruoc);

                        DeCuongMonHoc dc = DeCuongMonHoc.taoDeCuong(
                                HeThongQuanLy.dsMonHoc.timKiemMonBangMa(maMon),
                                he, noiDungMon, mucTieu, chuanDauRa, this.timGiangVien(maGV));
                        dc.setMonHocTienQuyet(dsMonTienQuyet);
                        dc.setMonHocTruoc(dsMonHocTruoc);

                        //xủ lý hình thức đánh giá
                        Scanner sc3 = new Scanner(hinhThucDanhGia);
                        sc3.useDelimiter("\\s*,\\s*");
                        while (sc3.hasNext()) {
                            String phuongPhapDanhGia = sc3.next();
                            String noiDung = sc3.next();
                            int tyTrong = sc3.nextInt();
                            HinhThuc hinhThuc = HinhThuc.taoHinhThuc(dc, phuongPhapDanhGia, noiDung, tyTrong, isCreated);
                            dc.themHinhThuc(hinhThuc);
                        }
                    }
                } catch (IOException | NoSuchElementException ex) {
                    System.err.println("Khong doc duoc thong tin decuong cua giang vien " + sub.getFileName());
                }

            });
        } catch (IOException e) {
            System.out.print(e);
        }

    }

    private DanhSachMonHoc stringMaMonThanhMonHoc(String str) {
        DanhSachMonHoc dsMon = null;
        Scanner sc = new Scanner(str);
        while (sc.hasNext()) {
            String maMH = sc.next();
            dsMon.themMonHoc(HeThongQuanLy.dsMonHoc.timKiemMonBangMa(maMH));
        }
        return dsMon;
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
    public static File layFile(String tenFile) throws Exception
    {
        Path path = Paths.get("GiangVien");
        Files.createDirectories(path);
        File file = path.resolve(tenFile).toFile();
        if(!file.isFile()&&!file.createNewFile())
            throw new Exception("Loi khi doc file: " + file.getAbsolutePath());
        return file;
    }
}
