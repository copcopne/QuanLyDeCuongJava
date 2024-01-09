package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Si Nguyen
 */
public class Run {

    public static void main(String[] args) throws Exception {
        HeThongQuanLy heThongQuanLy = HeThongQuanLy.taoHeThong();
//        HeThongQuanLy.dsMonHoc.getDsMonHoc().forEach(c-> {
//            System.out.println(c);
//        });
//        heThongQuanLy.getDsGiangVien().forEach(gv->System.out.println(gv.getMaGiangVien()));
        heThongQuanLy.getDsGiangVien().getFirst().setSoDeCuongBienSoan(2);
        MonHoc m = new MonChuyenNganh("MonChuyenNganh", "TenMon", 10, "Mo ta mon");
        MonHoc n = new MonChuyenNganh("MonChuyenNganh", "TienQuyet 1", 10, "Mo ta mon");
        MonHoc p = new MonChuyenNganh("MonChuyenNganh", "TienQuyet 2", 10, "Mo ta mon");
        MonHoc x = new MonChuyenNganh("MonChuyenNganh", "Truoc 1", 10, "Mo ta mon");
        MonHoc u = new MonChuyenNganh("MonChuyenNganh", "Truoc 2", 10, "Mo ta mon");
        DeCuongMonHoc dc = DeCuongMonHoc.taoDeCuong(m, He.chinhQuy, "NoiDung", "Muc tieu", "Chuan dau ra", heThongQuanLy.getDsGiangVien().getFirst());
//        System.out.println(heThongQuanLy.getDsGiangVien().getFirst());
        //System.out.println(dc);
        List<MonHoc> dsmh = new ArrayList<>();
        dsmh.add(p);
        dsmh.add(n);
        List<MonHoc> dsmht = new ArrayList<>();
        dsmht.add(x);
        dsmht.add(u);
        dc.getMonHocTienQuyet().setDsMonHoc(dsmh);
//          System.out.println(dc);
        dc.getMonHocTruoc().setDsMonHoc(dsmht);
        dc.themHinhThuc("1", "noidung1", 10);
        dc.themHinhThuc("2", "noidung2", 70);
        dc.themHinhThuc("3", "noidung3", 20);
        System.out.println(dc);
        
    }
}
