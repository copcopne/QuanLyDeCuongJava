package com.btl.quanlydecuong;

public abstract class MonHoc {

    private String maMonHoc;
    private String tenMonHoc;
    private double soTinChi;
    private String moTaMonHoc;

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public double getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(double soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getMoTaMonHoc() {
        return moTaMonHoc;
    }

    public void setMoTaMonHoc(String moTaMonHoc) {
        this.moTaMonHoc = moTaMonHoc;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, double soTinChi, String moTaMonHoc) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
        this.moTaMonHoc = moTaMonHoc;
    }
    
    @Override
    public String toString() {
        return String.format("Tên môn học: %s\nMã môn học: %s\n Số tín chỉ: %.1f\nMô tả môn học: %s\n"
                ,tenMonHoc,maMonHoc,soTinChi,moTaMonHoc);
    }

}
