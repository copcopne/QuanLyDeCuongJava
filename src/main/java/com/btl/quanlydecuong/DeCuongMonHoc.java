package com.btl.quanlydecuong;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
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

    public int getTyTrongHienTai() {
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
        if (giangVienBienSoan.getSoDeCuongBienSoan() > 5) {
            return null;
        }
        return new DeCuongMonHoc(mon, heDaoTao, noiDungMonHoc, mucTieuMonHoc,
                chuanDauRa, giangVienBienSoan);
    }

    public void capNhatThongTin() {
        boolean isEditing = true;
        String choice, s_temp;
        while (isEditing) {
            System.out.println(this);
            System.out.println("\n\n1.Sua noi dung trong de cuong");
            System.out.println("2.Them/Xoa/Sua hinh thuc");
            System.out.println("3.Them/Xoa mon tien quyet");
            System.out.println("4.Them/Xoa mon hoc truoc");
            System.out.println("0.Quay lai");
            System.out.print(">");
            choice = CauHinh.SC.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Ban muon thay doi gi?");
                    System.out.println("1.He dao tao");
                    System.out.println("2.Noi dung mon hoc");
                    System.out.println("3.Muc tieu mon hoc");
                    System.out.println("4.chuan dau ra");
                    System.out.print(">");
                    choice = CauHinh.SC.nextLine();
                    switch (choice) {
                        case "1" -> {
                            He h_temp = He.chinhQuy;
                            if (h_temp.equals(this.getHeDaoTao())) {
                                h_temp = He.lienThong;
                            }
                            this.setHeDaoTao(h_temp);
                            System.out.println("Da chuyen de cuong sang he " + h_temp);
                        }
                        case "2" -> {
                            System.out.print("Nhap noi dung mon hoc moi:\n>");
                            s_temp = CauHinh.SC.nextLine();
                            this.setNoiDungMonHoc(s_temp);
                            System.out.println("Cap nhat thanh cong");

                        }
                        case "3" -> {
                            System.out.print("Nhap muc tieu mon hoc moi:\n>");
                            s_temp = CauHinh.SC.nextLine();
                            this.setMucTieuMonHoc(s_temp);
                            System.out.println("Cap nhat thanh cong");
                        }
                        case "4" -> {
                            System.out.print("Nhap chuan dau ra moi:\n>");
                            s_temp = CauHinh.SC.nextLine();
                            this.setChuanDauRa(s_temp);
                            System.out.println("Cap nhat thanh cong");
                        }
                        default -> {
                            System.out.println("Khong hop le, vui long thuc hien lai");
                        }
                    }
                }
                case "2" -> {
                    if (this.hinhThucDanhGia.isEmpty()) {
                        System.out.println("De cuong chua co hinh thuc, thuc tien them hinh thuc:");
                        System.out.print("Nhap phuong phap danh gia: ");
                        String pp = CauHinh.SC.nextLine();
                        System.out.print("Nhap noi dung danh gia: ");
                        String nd = CauHinh.SC.nextLine();
                        System.out.print("Nhap ty trong: ");
                        int tt = Integer.parseInt(CauHinh.SC.nextLine());
                        if (tt >= 100) {
                            System.out.println("Loi ty trong");
                        } else {
                            this.themHinhThuc(HinhThuc.taoHinhThuc(this, pp, nd, tt));
                            System.out.println("Them hinh thuc moi thanh cong");
                        }
                    } else {
                        System.out.println("\n1.Them hinh thuc moi\n2.Chinh sua hinh thuc hien co\n3.Xoa hinh thuc hien co");
                        choice = CauHinh.SC.nextLine();
                        switch (choice) {
                            case "1" -> {
                                if (this.getTyTrongHienTai() <= 100) {
                                    System.out.print("Nhap phuong phap danh gia: ");
                                    String pp = CauHinh.SC.nextLine();
                                    System.out.print("Nhap noi dung danh gia: ");
                                    String nd = CauHinh.SC.nextLine();
                                    System.out.print("Nhap ty trong: ");
                                    int tt = Integer.parseInt(CauHinh.SC.nextLine());
                                    if (tt + this.getTyTrongHienTai() > 100) {
                                        System.out.println("Loi ty trong");
                                    } else {
                                        this.themHinhThuc(HinhThuc.taoHinhThuc(this, pp, nd, tt));
                                        System.out.println("Them hinh thuc moi thanh cong");
                                    }
                                } else {
                                    System.out.println("Ty trong da day, khong the them hinh thuc moi");
                                }
                            }
                            case "2" -> {
                                this.lietKeHinhThuc();
                                System.out.print("Nhap thu tu hinh thuc muon chinh sua: ");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.isInteger(choice)) {
                                    System.out.println("Nhap khong hop le");
                                } else if (Integer.parseInt(choice) - 1 < 0 && this.getHinhThucDanhGia().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le");
                                } else {
                                    System.out.print("Nhap phuong phap danh gia: ");
                                    String pp = CauHinh.SC.nextLine();
                                    System.out.print("Nhap noi dung danh gia: ");
                                    String nd = CauHinh.SC.nextLine();
                                    System.out.print("Nhap ty trong: ");
                                    int tt = Integer.parseInt(CauHinh.SC.nextLine());
                                    if (tt + this.tyTrongHienTai - this.hinhThucDanhGia.get(Integer.parseInt(choice) - 1).getTyTrong() > 100) {
                                        System.out.println("Ty trong khop hop le");
                                    } else {
                                        this.getHinhThucDanhGia().get(Integer.parseInt(choice) - 1).setNoiDungDanhGia(nd);
                                        this.getHinhThucDanhGia().get(Integer.parseInt(choice) - 1).setPhuongPhapDanhGia(pp);
                                        this.getHinhThucDanhGia().get(Integer.parseInt(choice) - 1).setTyTrong(tt);
                                        this.tyTrongHienTai += tt;
                                    }
                                }
                            }
                            case "3" -> {
                                this.lietKeHinhThuc();
                                System.out.print("Nhap thu tu hinh thuc muon xoa: ");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.isInteger(choice)) {
                                    System.out.println("Nhap khong hop le");
                                } else if (Integer.parseInt(choice) - 1 < 0 && this.getHinhThucDanhGia().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le");
                                } else {
                                    this.tyTrongHienTai -= this.hinhThucDanhGia.get(Integer.parseInt(choice) - 1).getTyTrong();
                                    this.hinhThucDanhGia.remove(this.hinhThucDanhGia.get(Integer.parseInt(choice) - 1));
                                }
                            }
                            default -> {
                                System.out.println("Khong hop le");
                            }
                        }
                    }
                }
                case "3" -> {
                    System.out.println("1.Them mon tien quyet vao de cuong");
                    System.out.println("2.Xoa mon tien quyet khoi de cuong");
                    choice = CauHinh.SC.nextLine();
                    switch (choice) {
                        case "1" -> {
                            System.out.print("Nhap ma mon hoc can them: ");
                            s_temp = CauHinh.SC.nextLine();
                            if (HeThongQuanLy.dsMonHoc.isMonDaTonTai(s_temp) && this.monHocTienQuyet.isMonDaTonTai(s_temp)) {
                                this.monHocTienQuyet
                                        .themMonHoc(HeThongQuanLy.dsMonHoc
                                                .timKiemMonBangMa(s_temp));
                                System.out.println("Them thanh cong");
                            } else {
                                System.out.println("Mon hoc khong ton tai");
                            }
                        }
                        case "2" -> {
                            if (this.getMonHocTienQuyet().getDsMonHoc().isEmpty()) {
                                System.out.println("De cuong khong co mon tien quyet");
                            } else {
                                System.out.println(this.getMonHocTienQuyet());
                                System.out.println("Nhap so thu tu mon can xoa: ");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.isInteger(choice)) {
                                    System.out.println("Nhap khong hop le");
                                } else if (Integer.parseInt(choice) - 1 < 0 && this.getMonHocTienQuyet().getDsMonHoc().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le");
                                } else {
                                    this.monHocTienQuyet.getDsMonHoc().remove(this.monHocTienQuyet.getDsMonHoc().get(Integer.parseInt(choice) - 1));
                                    System.out.println("Xoa thanh cong");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Khong hop le");
                        }
                    }
                }
                case "4" -> {
                    System.out.println("1.Them mon hoc truoc vao de cuong");
                    System.out.println("2.Xoa mon hoc truoc khoi de cuong");
                    choice = CauHinh.SC.nextLine();
                    switch (choice) {
                        case "1" -> {
                            System.out.print("Nhap ma mon hoc can them: ");
                            s_temp = CauHinh.SC.nextLine();
                            if (HeThongQuanLy.dsMonHoc.isMonDaTonTai(s_temp) && this.monHocTruoc.isMonDaTonTai(s_temp)) {
                                this.monHocTruoc
                                        .themMonHoc(HeThongQuanLy.dsMonHoc
                                                .timKiemMonBangMa(s_temp));
                                System.out.println("Them thanh cong");
                            } else {
                                System.out.println("Mon hoc khong ton tai");
                            }
                        }
                        case "2" -> {
                            if (this.getMonHocTruoc().getDsMonHoc().isEmpty()) {
                                System.out.println("De cuong khong co mon tien quyet");
                            } else {
                                System.out.println(this.getMonHocTruoc());
                                System.out.println("Nhap so thu tu mon can xoa: ");
                                choice = CauHinh.SC.nextLine();
                                if (!CauHinh.isInteger(choice)) {
                                    System.out.println("Nhap khong hop le");
                                } else if (Integer.parseInt(choice) - 1 < 0 && this.getMonHocTruoc().getDsMonHoc().size() < Integer.parseInt(choice) - 1) {
                                    System.out.println("Nhap khong hop le");
                                } else {
                                    this.monHocTruoc.getDsMonHoc().remove(this.monHocTruoc.getDsMonHoc().get(Integer.parseInt(choice) - 1));
                                    System.out.println("Xoa thanh cong");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Khong hop le");
                        }
                    }
                }
                case "0" -> {
                    isEditing = false;
                }
                default -> {
                    System.out.println("Thao tac khong hop le!");
                }
            }
            CauHinh.pressEnterToContinue();
        }
    }

    public void themMonHocTruoc(MonHoc m) {
        if (this.monHocTruoc.getDsMonHoc().size() > 3 || this.monHocTruoc.getDsMonHoc().contains(m) == true) {
            System.out.println("Vuot qua mon hoc truoc co the them");
            return;
        }
        this.monHocTruoc.getDsMonHoc().add(m);
    }

    public void themMonHocTienQuyet(MonHoc m) {
        if (this.monHocTienQuyet.getDsMonHoc().size() > 3 || this.monHocTienQuyet.getDsMonHoc().contains(m) == true) {
            System.err.println("Vuot qua mon hoc co the them");
            return;
        }
        this.monHocTienQuyet.getDsMonHoc().add(m);
    }

    public void themHinhThuc(String phuongPhapDanhGia, String noiDungDanhGia, int tyTrong) {
        if (tyTrongHienTai == 100); // báo lỗi do tổng tỷ trọng đã đủ 100 và quay về
        if (tyTrongHienTai < 100 && tyTrongHienTai >= 0
                && tyTrongHienTai + tyTrong <= 100) {
            System.out.println("loi ty trong");
        } else {
            CauHinh.hinhThuc_temp = HinhThuc.taoHinhThuc(this, phuongPhapDanhGia, noiDungDanhGia, tyTrong);
            if (CauHinh.hinhThuc_temp == null) {
                System.err.println("Qua so luong hinh thuc co the them");
                if (!this.isDeCuongHopLe()) {
                    System.err.println("De cuong khong hop le, vui long thuc hien chinh sua hinh thuc");
                }
            } // báo lỗi do vượt quá thành viên hình thức có thể có trong đề cương môn học
            else {
                this.hinhThucDanhGia.add(CauHinh.hinhThuc_temp);
                this.tyTrongHienTai += CauHinh.hinhThuc_temp.getTyTrong();
            }
        }
    }

    public void themHinhThuc(HinhThuc h) {
        if (tyTrongHienTai == 100 || tyTrongHienTai + h.getTyTrong() > 100) {
        } else {
            this.tyTrongHienTai += h.getTyTrong();
            this.hinhThucDanhGia.add(h);
        } // check dieu kien
    }

    public boolean isDeCuongHopLe() {
        return this.tyTrongHienTai == 100;
    }

    public void xoaHinhThuc(HinhThuc h) {
        this.hinhThucDanhGia.remove(h);
    }

    public String lietKeHinhThuc() {
        String s = "";
        for (var x : this.hinhThucDanhGia) {
            s += x;
        }
        return s;
    }

    public void xuatDeCuong() throws Exception {
        if (!this.isDeCuongHopLe()) {
            System.err.println("De cuong khong hop le, vui long thuc hien chinh sua hinh thuc");
        } else {
            File file = new File(String.format("%s%s%s.txt", this.giangVienBienSoan.getMaGiangVien(), this.mon.getMaMonHoc(), this.heDaoTao));
            if (!file.isFile() && !file.createNewFile()) {
                throw new Exception("Loi khi tao file moi: " + file.getAbsolutePath());
            }
            try (FileWriter fw = new FileWriter(file, false)) {
                String str = String.format("%s\nHe dao tao: %s\nNoi dung: %s\nMuc tieu: %s\nHinh thuc danh gia:\n==========\n%s\n==========\nChuan dau ra: %s\nGiang vien bien soan: %s\nDanh sach mon tien quyet:%s\nDanh sach mon truoc:%s\n",
                        this.mon, this.heDaoTao, this.noiDungMonHoc, this.mucTieuMonHoc,
                        this.lietKeHinhThuc(), this.chuanDauRa, this.giangVienBienSoan.getTenGiangVien(),
                        this.monHocTienQuyet.getTenMonTrongDanhSach(),
                        this.monHocTruoc.getTenMonTrongDanhSach());
                fw.write(str);
                System.out.println("Xuat thanh cong");
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s\nHe dao tao: %s\nNoi dung: %s\nMuc tieu: %s\nHinh thuc danh gia:\n==========\n%s\n==========\nChuan dau ra: %s\nGiang vien bien soan: %s\nDanh sach mon tien quyet:%s\nDanh sach mon truoc:%s\n",
                this.mon, this.heDaoTao, this.noiDungMonHoc, this.mucTieuMonHoc,
                this.lietKeHinhThuc(), this.chuanDauRa, this.giangVienBienSoan.getTenGiangVien(),
                this.monHocTienQuyet.getTenMonTrongDanhSach(),
                this.monHocTruoc.getTenMonTrongDanhSach());
    }
}
