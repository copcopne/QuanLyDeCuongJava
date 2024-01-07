package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanhSachDeCuong {

    private List<DeCuongMonHoc> dsDeCuong = new ArrayList<>();

    public List<DeCuongMonHoc> getDsDeCuong() {
        return dsDeCuong;
    }

    public void setDsDeCuong(List<DeCuongMonHoc> dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

    public DanhSachDeCuong() {
    }

    public void themDeCuong(DeCuongMonHoc d) {
        this.dsDeCuong.add(d);
    }

    public void themDecuong(DeCuongMonHoc... d) {
        this.dsDeCuong.addAll(Arrays.asList(d));
    }

    public DeCuongMonHoc timKiem(String kw) {
        return this.dsDeCuong.stream().filter(d -> d.getMon().getMaMonHoc()
                .equals(kw)).findFirst().get();
    }

    public void taoDeCuong(MonHoc mon, He heDaoTao, String noiDungMonHoc,
            String mucTieuMonHoc, String chuanDauRa, GiangVien giangVienBienSoan,
            DanhSachMonHoc monHocTienQuyet, DanhSachMonHoc monHocTruoc, GiangVien g) {
        if (g.getSoDeCuongBienSoan() > 5 && ((DanhSachMonHoc.isMonDaTonTai(mon) == true 
                && this.timKiem(mon.getMaMonHoc()).getHeDaoTao().equals(heDaoTao) == false) 
                || (DanhSachMonHoc.isMonDaTonTai(mon) == false))) {

        }
    }

    public void xoaDeCuong(DeCuongMonHoc d) {
        this.dsDeCuong.remove(d);
    }

    public void sapXepDeCuong() {

    }

    public void thongKeDeCuong() {

    }

    //chua test
    public void xuatDanhSach() {
        this.dsDeCuong.forEach(dc -> System.out.printf("Giang vien: %s\n%s",
                 dc.getGiangVienBienSoan().getTenGiangVien(), dc));
    }

}
