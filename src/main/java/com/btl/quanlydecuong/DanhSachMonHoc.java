package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DanhSachMonHoc {

    private List<MonHoc> dsMonHoc = new ArrayList<>();

    public List<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(List<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public DanhSachMonHoc() {
    }

    public void themMonHoc(MonHoc... mh) {
        this.dsMonHoc.addAll(Arrays.asList(mh));
        HeThongQuanLy.luuFileMonHoc();
    }

    public void themMonHoc(DanhSachMonHoc h) {
        this.dsMonHoc.addAll(h.getDsMonHoc());
        HeThongQuanLy.luuFileMonHoc();
    }

    public void themMonHoc(MonHoc mh) {
        this.dsMonHoc.add(mh);
        HeThongQuanLy.luuFileMonHoc();
    }

    public void themMonHoc(List<MonHoc> mh) {
        this.dsMonHoc.addAll(mh);
        HeThongQuanLy.luuFileMonHoc();
    }

    public void xoaMonHoc(MonHoc mh) {
        dsMonHoc.remove(mh);
        HeThongQuanLy.luuFileMonHoc();
    }

    public DanhSachMonHoc timKiemMonBangTen(String keyword) {
        List<MonHoc> ds = this.dsMonHoc.stream()
                .filter(m -> m.getTenMonHoc().contains(keyword))
                .collect(Collectors.toList());
        return (DanhSachMonHoc) ds;
    }

    public MonHoc timKiemMonBangMa(String keyword) {
        return this.dsMonHoc.stream().filter(m -> m.getMaMonHoc().equals(keyword)).findFirst().get();
    }

    public boolean isMonDaTonTai(MonHoc m) {
        return HeThongQuanLy.dsMonHoc.getDsMonHoc().contains(m);
    }

    public boolean isMonDaTonTai(String maMon) {
        return HeThongQuanLy.dsMonHoc.getDsMonHoc().stream().filter(m -> m.getMaMonHoc().equals(maMon)).findFirst().isPresent();
    }

    public String getTenMonTrongDanhSach() {
        String s = "";
        for (var x : this.dsMonHoc) {
            s += String.format(" %s,", x.getTenMonHoc());
        }
        s += ".";
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (var x : this.dsMonHoc) {
            s += x.toString();
        }
        return s;
    }

}
