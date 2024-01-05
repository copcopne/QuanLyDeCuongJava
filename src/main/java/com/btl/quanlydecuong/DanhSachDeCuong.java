package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DanhSachDeCuong {

    private List<DeCuongMonHoc> dsDeCuong = new ArrayList<>();

    public DanhSachDeCuong() {
    }

    public void timKiem() {

    }

    public void sapXepDeCuong() {
        
    }

    public void thongKeDeCuong() {

    }

    //chua test
    public void xuatDanhSach() {
        this.dsDeCuong.forEach(dc->System.out.printf("Giang vien: %s\n%s"
                ,dc.getGiangVienBienSoan().getTenGiangVien(),dc));
    }

}
