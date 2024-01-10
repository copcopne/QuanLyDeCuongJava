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
    }
    public void themMonHoc(DanhSachMonHoc h) {
        this.dsMonHoc.addAll(h.getDsMonHoc());
    }
    
    public void themMonHoc(MonHoc mh) {
        this.dsMonHoc.add(mh);
    }
    
    public void themMonHoc(List<MonHoc> mh) {
        this.dsMonHoc.addAll(mh);
    }
    
    public void xoaMonHoc(MonHoc mh) {
        dsMonHoc.remove(mh);
    }

    //chua test
    public DanhSachMonHoc timKiemMon(String keyword) {
        List<MonHoc> ds = this.dsMonHoc.stream()
                .filter(m -> m.getTenMonHoc().equals(keyword) 
                        || m.getMaMonHoc().equals(keyword))
                .collect(Collectors.toList());
        return (DanhSachMonHoc) ds;
    }
    public boolean isMonDaTonTai(MonHoc m) {
        return HeThongQuanLy.dsMonHoc.getDsMonHoc().contains(m);
    }

    @Override
    public String toString() {
        String s = "";
        for(var x: this.dsMonHoc) {
            s += x.toString();
        }
        return s;
    }
    public String getTenMonTrongDanhSach() {
        String s = "";
        for(var x : this.dsMonHoc) {
            s += String.format(" %s,",x.getTenMonHoc());
        }
        s+= ".";
        return s;
    }
    
}
