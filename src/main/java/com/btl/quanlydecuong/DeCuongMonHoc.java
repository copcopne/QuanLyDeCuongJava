package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.List;

public class DeCuongMonHoc {

    private MonHoc mon;
    private He heDaoTao;
    private String noiDungMonHoc;
    private String mucTieuMonHoc;
    private List<HinhThuc> hinhThucDanhGia = new ArrayList<>();
    private String chuanDauRa;
    private GiangVien giangVienBienSoan;
    private DanhSachMonHoc monHocTienQuyet;
    private DanhSachMonHoc monHocTruoc;
    private static double temp;

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public He getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(He heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public String getNoiDungMonHoc() {
        return noiDungMonHoc;
    }

    public void setNoiDungMonHoc(String noiDungMonHoc) {
        this.noiDungMonHoc = noiDungMonHoc;
    }

    public String getMucTieuMonHoc() {
        return mucTieuMonHoc;
    }

    public void setMucTieuMonHoc(String mucTieuMonHoc) {
        this.mucTieuMonHoc = mucTieuMonHoc;
    }

    public List<HinhThuc> getHinhThucDanhGia() {
        return hinhThucDanhGia;
    }

    public void setHinhThucDanhGia(List<HinhThuc> hinhThucDanhGia) {
        this.hinhThucDanhGia = hinhThucDanhGia;
    }

    public String getChuanDauRa() {
        return chuanDauRa;
    }

    public void setChuanDauRa(String chuanDauRa) {
        this.chuanDauRa = chuanDauRa;
    }

    public GiangVien getGiangVienBienSoan() {
        return giangVienBienSoan;
    }

    public void setGiangVienBienSoan(GiangVien giangVienBienSoan) {
        this.giangVienBienSoan = giangVienBienSoan;
    }

    public DanhSachMonHoc getMonHocTienQuyet() {
        return monHocTienQuyet;
    }

    public void setMonHocTienQuyet(DanhSachMonHoc monHocTienQuyet) {
        this.monHocTienQuyet = monHocTienQuyet;
    }

    public DanhSachMonHoc getMonHocTruoc() {
        return monHocTruoc;
    }

    public void setMonHocTruoc(DanhSachMonHoc monHocTruoc) {
        this.monHocTruoc = monHocTruoc;
    }

    private DeCuongMonHoc(MonHoc mon, He heDaoTao, String noiDungMonHoc,
            String mucTieuMonHoc, String chuanDauRa, GiangVien giangVienBienSoan,
            DanhSachMonHoc monHocTienQuyet, DanhSachMonHoc monHocTruoc) {
        this.mon = mon;
        this.heDaoTao = heDaoTao;
        this.noiDungMonHoc = noiDungMonHoc;
        this.mucTieuMonHoc = mucTieuMonHoc;
        this.chuanDauRa = chuanDauRa;
        this.giangVienBienSoan = giangVienBienSoan;
        this.monHocTienQuyet = monHocTienQuyet;
        this.monHocTruoc = monHocTruoc;
    }

    public static DeCuongMonHoc getInsance(MonHoc mon, He heDaoTao,
            String noiDungMonHoc, String mucTieuMonHoc, String chuanDauRa,
            GiangVien giangVienBienSoan, DanhSachMonHoc monHocTienQuyet,
            DanhSachMonHoc monHocTruoc, GiangVien g) {
        return new DeCuongMonHoc(mon, heDaoTao, noiDungMonHoc, mucTieuMonHoc,
                chuanDauRa, giangVienBienSoan, monHocTienQuyet, monHocTruoc);
    }
    
    public void capNhatThongTin() {

    }

    public void themHinhThuc(String phuongPhapDanhGia, String noiDungDanhGia, double tyTrong) { // chưa xong/chưa đảm bảo chạy đúng :))
        this.getHinhThucDanhGia().forEach(t -> {
            temp += t.getTyTrong();
        });
        if(temp == 10); // báo lỗi do tổng tỷ trọng đã đủ 100 và quay về
        boolean check = temp < 10 && temp >= 0 
                && temp + tyTrong <= 10;
        temp = 0; // reset lại thành viên temp
        HinhThuc x = HinhThuc.getInstance(this, phuongPhapDanhGia, noiDungDanhGia, tyTrong, check);
        if(x == null){} // báo lỗi do vượt quá  thành viên hình thức có thể có trong đề cương môn học
        else this.hinhThucDanhGia.add(x);
        
    }

    public boolean isDeCuongHopLe() { // chưa xong
        return true;
    }
    
    public void xoaHinhThuc() {
        
    }

    public void xuatDeCuong() {

    }

    @Override
    public String toString() {
        return "Ten mon: " + this.mon.getTenMonHoc()
                + "\nHe dao tao: " + this.heDaoTao
                + "\nNoi dung mon hoc: " + this.noiDungMonHoc
                + "\nMuc tieu mon hoc: " + this.mucTieuMonHoc
                + "\nChuan dau ra: " + this.chuanDauRa;
    }
}
