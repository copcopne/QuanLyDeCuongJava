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
    private DanhSachMonHoc monHocTienQuyet = new DanhSachMonHoc();
    private DanhSachMonHoc monHocTruoc = new DanhSachMonHoc();
    private int tyTrongHienTai; // khong hien thi

    public double getTyTrongHienTai() {
        return tyTrongHienTai;
    }

    public void setTyTrongHienTai(int tyTrongHienTai) {
        this.tyTrongHienTai = tyTrongHienTai;
    }

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
            String mucTieuMonHoc, String chuanDauRa, GiangVien giangVienBienSoan) {
        this.mon = mon;
        this.heDaoTao = heDaoTao;
        this.noiDungMonHoc = noiDungMonHoc;
        this.mucTieuMonHoc = mucTieuMonHoc;
        this.chuanDauRa = chuanDauRa;
        this.giangVienBienSoan = giangVienBienSoan;
    }

    public static DeCuongMonHoc taoDeCuong(MonHoc mon, He heDaoTao,
            String noiDungMonHoc, String mucTieuMonHoc, String chuanDauRa,
            GiangVien giangVienBienSoan) {
        if(giangVienBienSoan.getSoDeCuongBienSoan() > 5) {
            return null;
        }
        return new DeCuongMonHoc(mon, heDaoTao, noiDungMonHoc, mucTieuMonHoc,
                chuanDauRa, giangVienBienSoan);
    }
    
    public void capNhatThongTin() {
        
    }

    public void themMonHocTruoc(MonHoc m) {
        if(this.monHocTruoc.getDsMonHoc().size() > 3 || this.monHocTruoc.getDsMonHoc().contains(m) == true) {
            // khong the them mon
            return;
        }
        this.monHocTruoc.getDsMonHoc().add(m);
    }
    public void themMonHocTienQuyet(MonHoc m) {
        if(this.monHocTienQuyet.getDsMonHoc().size() > 3 || this.monHocTienQuyet.getDsMonHoc().contains(m) == true) {
            System.err.println("Khong the them mon");
            return;
        }
        this.monHocTienQuyet.getDsMonHoc().add(m);
    }
    public void themHinhThuc(String phuongPhapDanhGia, String noiDungDanhGia, int tyTrong) { // chưa xong/chưa đảm bảo chạy đúng :))
        if(tyTrongHienTai == 100); // báo lỗi do tổng tỷ trọng đã đủ 100 và quay về
        boolean check = tyTrongHienTai < 100 && tyTrongHienTai >= 0 
                && tyTrongHienTai + tyTrong <= 100;
        CauHinh.hinhThuc_temp = HinhThuc.taoHinhThuc(this, phuongPhapDanhGia, noiDungDanhGia, tyTrong, check);
        if(CauHinh.hinhThuc_temp == null){
            System.err.println("Qua so luong hinh thuc co the them");
            if(!this.isDeCuongHopLe()) System.err.println("De cuong khong hop le, vui long thuc hien chinh sua hinh thuc");
        } // báo lỗi do vượt quá thành viên hình thức có thể có trong đề cương môn học
        else {
            this.hinhThucDanhGia.add(CauHinh.hinhThuc_temp);
            this.tyTrongHienTai+= CauHinh.hinhThuc_temp.getTyTrong();
        }
        
    }
    public void themHinhThuc(HinhThuc h) {
        if(tyTrongHienTai == 100 || tyTrongHienTai + h.getTyTrong() > 100) {}
        else {
            this.tyTrongHienTai += h.getTyTrong();
            this.hinhThucDanhGia.add(h);
        } // check dieu kien
    }

    public boolean isDeCuongHopLe() {
        return this.tyTrongHienTai == 10;
    }
    
    public void xoaHinhThuc(HinhThuc h) {
        this.hinhThucDanhGia.remove(h);
    }

    public void xuatDeCuong() {
        if(!this.isDeCuongHopLe()) {
            System.err.println("De cuong khong hop le, vui long thuc hien chinh sua hinh thuc");
        }
        else {
            // xuất đề cương
        }

    }
    public String lietKeHinhThuc() {
        String s = "";
        for(var x : this.hinhThucDanhGia) {
            s+= x;
        }
        return s;
    }
    @Override
    public String toString() {
        return String.format("%s\nHe dao tao: %s\nNoi dung: %s\nMuc tieu: %s\nHinh thuc danh gia:\n==========\n%s\n==========\nChuan dau ra: %s\nGiang vien bien soan: %s\nDanh sach mon tien quyet:%s\nDanh sach mon truoc:%s\n",
                this.mon,this.heDaoTao,this.noiDungMonHoc,this.mucTieuMonHoc,
                this.lietKeHinhThuc(),this.chuanDauRa,this.giangVienBienSoan.getTenGiangVien(),
                this.monHocTienQuyet.getTenMonTrongDanhSach(),
                this.monHocTruoc.getTenMonTrongDanhSach());
    }
}
