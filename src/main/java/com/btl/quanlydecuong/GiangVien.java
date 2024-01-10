package com.btl.quanlydecuong;

public class GiangVien {

    private String tenGiangVien;
    private String maGiangVien;
    private String email;
    private TrinhDo trinhDo;
    private DanhSachDeCuong dsDeCuongBienSoan = new DanhSachDeCuong();
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

    public TrinhDo getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(TrinhDo trinhDo) {
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

    public GiangVien(String tenGiangVien, String maGiangVien, String email, TrinhDo trinhDo) {
        this.tenGiangVien = tenGiangVien;
        this.maGiangVien = maGiangVien;
        this.email = email;
        this.trinhDo = trinhDo;
    }
    
    public void taoMonDeCuong(MonHoc mon, He heDaoTao, String noiDungMonHoc,
            String mucTieuMonHoc, String chuanDauRa) { // cần test 
        
        if((HeThongQuanLy.dsDeCuong.timKiem(mon) == null)
                || ((HeThongQuanLy.dsMonHoc.isMonDaTonTai(mon) == true)
                && (HeThongQuanLy.dsDeCuong.timKiem(mon).getHeDaoTao().equals(heDaoTao) == false))) {
            
            CauHinh.DCMonHoc_temp = DeCuongMonHoc.taoDeCuong(mon, heDaoTao, 
                    noiDungMonHoc, mucTieuMonHoc, chuanDauRa, this);
            if(CauHinh.DCMonHoc_temp == null) {
                // lỗi đã tạo quá đề cương cho phép
            } else {
                this.setSoDeCuongBienSoan(this.getSoDeCuongBienSoan() + 1);
                this.dsDeCuongBienSoan.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
                HeThongQuanLy.dsDeCuong.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
            }
        }
    }
    public void taoMonDeCuong(He he, String maMon) {
        System.out.print("Nhap noi dung mon hoc: ");
        String nd = CauHinh.SC.nextLine();
        System.out.print("Nhap muc tieu mon hoc: ");
        String mt = CauHinh.SC.nextLine();
        System.out.print("Nhap chuan dau ra mon hoc: ");
        String cdr = CauHinh.SC.nextLine();
        this.taoMonDeCuong(HeThongQuanLy.dsMonHoc.timKiemMonBangMa(maMon), he, nd, mt, cdr);
        
    }

    @Override
    public String toString() {
        return String.format("Ten giang vien: %s\nMa giang vien: %s\nEmail: %s\nTrinh do: %s\nDanh sach de cuong da bien soan:\n==========%s\n==========\n", 
                this.tenGiangVien,this.maGiangVien,this.email,
                this.trinhDo,this.dsDeCuongBienSoan);
    }
    
    

}
