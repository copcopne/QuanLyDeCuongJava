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
        this.dsDeCuong.sort(Comparator.comparing(dc -> dc.getMon().getSoTinChi()).reversed());
    }

    public void thongKeDeCuong() {

    }

    public void xuatDanhSach() {

    }

}
