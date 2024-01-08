package com.btl.quanlydecuong;

public class GiangVien {

    private String tenGiangVien;
    private String maGiangVien;
    private String email;
    private String trinhDo;
    private DanhSachDeCuong dsDeCuongBienSoan;
    private int soDeCuongBienSoan;

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public DanhSachDeCuong getDsDeCuongBienSoan() {
        return dsDeCuongBienSoan;
    }

    public void setDsDeCuongBienSoan(DanhSachDeCuong dsDeCuongBienSoan) {
        this.dsDeCuongBienSoan = dsDeCuongBienSoan;
    }

    public int getSoDeCuongBienSoan() {
        return soDeCuongBienSoan;
    }

    public void setSoDeCuongBienSoan(int soDeCuongBienSoan) {
        this.soDeCuongBienSoan = soDeCuongBienSoan;
    }

    public GiangVien(String tenGiangVien, String maGiangVien, String email, String trinhDo, DanhSachDeCuong dsDeCuongBienSoan, int soDeCuongBienSoan) {
        this.tenGiangVien = tenGiangVien;
        this.maGiangVien = maGiangVien;
        this.email = email;
        this.trinhDo = trinhDo;
        this.dsDeCuongBienSoan = dsDeCuongBienSoan;
        this.soDeCuongBienSoan = soDeCuongBienSoan;
    }
    
    public void taoMonDeCuong(MonHoc mon, He heDaoTao, String noiDungMonHoc,
            String mucTieuMonHoc, String chuanDauRa, DanhSachMonHoc monHocTienQuyet, 
            DanhSachMonHoc monHocTruoc) { // cần test 
        
        if((HeThongQuanLy.dsDeCuong.timKiem(mon) == null)
                || ((HeThongQuanLy.dsMonHoc.isMonDaTonTai(mon) == true)
                && (HeThongQuanLy.dsDeCuong.timKiem(mon).getHeDaoTao().equals(heDaoTao) == false))) {
            
            CauHinh.DCMonHoc_temp = DeCuongMonHoc.taoDeCuong(mon, heDaoTao, 
                    noiDungMonHoc, mucTieuMonHoc, chuanDauRa, this, 
                    monHocTienQuyet, monHocTruoc);
            if(CauHinh.DCMonHoc_temp == null) {
                // lỗi đã tạo quá đề cương cho phép
            } else {
                this.setSoDeCuongBienSoan(this.getSoDeCuongBienSoan() + 1);
                this.dsDeCuongBienSoan.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
                HeThongQuanLy.dsDeCuong.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
            }
        }
    }

}
