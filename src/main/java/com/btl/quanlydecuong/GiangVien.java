package com.btl.quanlydecuong;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

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
            String mucTieuMonHoc, String chuanDauRa) { 
        CauHinh.DCMonHoc_temp = DeCuongMonHoc.taoDeCuong(mon, heDaoTao,
                noiDungMonHoc, mucTieuMonHoc, chuanDauRa, this);
        if (CauHinh.DCMonHoc_temp == null) {
            // lỗi đã tạo quá đề cương cho phép
        } else {
            this.setSoDeCuongBienSoan(this.getSoDeCuongBienSoan() + 1);
            this.dsDeCuongBienSoan.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
            HeThongQuanLy.dsDeCuong.getDsDeCuong().add(CauHinh.DCMonHoc_temp);
            System.out.println("Tao de cuong thanh cong");
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
                this.tenGiangVien, this.maGiangVien, this.email,
                this.trinhDo, this.dsDeCuongBienSoan);
    }

    public void luuFileDeCuong() {
        Path pathDeCuong = HeThongQuanLy.layFile("DSDeCuong.txt", this.maGiangVien);
        StringBuilder str = new StringBuilder();
        this.dsDeCuongBienSoan.getDsDeCuong().forEach(dc -> {

            try{
            str.append(dc.getMon().getMaMonHoc()).append("|")
                    .append(dc.getHeDaoTao() == He.chinhQuy ? "CQ|" : "LT|")
                    .append(dc.getNoiDungMonHoc()).append("|")
                    .append(dc.getMucTieuMonHoc()).append("|\n");

            dc.getHinhThucDanhGia().forEach(ht -> {
                str.append(ht.getPhuongPhapDanhGia()).append(",")
                        .append(ht.getNoiDungDanhGia()).append(",")
                        .append(ht.getTyTrong()).append(",\n");
            });

            str.append("|").append(dc.getChuanDauRa()).append("|")
                    .append(dc.getGiangVienBienSoan().getMaGiangVien()).append("|\n");
            dc.getMonHocTienQuyet().getDsMonHoc().forEach(monHoc -> {
                str.append(monHoc.getMaMonHoc()).append(",");
            });
            str.append("|\n");
            dc.getMonHocTruoc().getDsMonHoc().forEach(monHoc -> {
                str.append(monHoc.getMaMonHoc()).append(",");
            });
            str.append("|\n\n");
            }
            catch(Exception e){System.err.print(e);}
        });
        try (FileWriter fw = new FileWriter(pathDeCuong.toFile(), false)) {
            fw.write(str.toString());
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }

    public void luuFileThongTinGV() {
        Path pathGV = HeThongQuanLy.layFile("ThongTinGV.txt", this.maGiangVien);
        StringBuilder str = new StringBuilder();
        str.append(this.tenGiangVien).append("|")
                .append(this.maGiangVien).append("|")
                .append(this.email).append("|")
                .append(this.trinhDo == TrinhDo.thacSi ? "thacSi|" : "tienSi|");
        try (FileWriter fw = new FileWriter(pathGV.toFile(), false)) {
            fw.write(str.toString());
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }

}
