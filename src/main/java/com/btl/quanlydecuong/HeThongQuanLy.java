package com.btl.quanlydecuong;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    private HeThongQuanLy() throws IOException {
        HeThongQuanLy.isCreated = true;
        
        File file = new File("monhoc.txt");
        if (!file.isFile() && !file.createNewFile()) {
            throw new IOException("Loi khi tao file moi: " + file.getAbsolutePath());
        } else {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\|");
            while(sc.hasNextLine())
            {
                String khoi = sc.next();
                String maMon = sc.next();
                String tenMon = sc.next();
                String moTaMon = sc.next();
                Double soTinChi = sc.nextDouble();
                switch(khoi)
                {
                    case "CN" -> HeThongQuanLy.dsMonHoc.themMonHoc(new MonChuyenNganh(maMon,tenMon,soTinChi,moTaMon));
                    case "CS" -> HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSo(maMon,tenMon,soTinChi,moTaMon));
                    case "CSN" -> HeThongQuanLy.dsMonHoc.themMonHoc(new MonCoSoNganh(maMon,tenMon,soTinChi,moTaMon));
                }
                
                sc.nextLine();
            }
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
