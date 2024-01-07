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

    public DanhSachMonHoc(MonHoc... mh) {
        this.dsMonHoc.addAll(Arrays.asList(mh));
    }

    public void themMonHoc(MonHoc mh) {
        dsMonHoc.add(mh);
    }
    public void xoaMonHoc(MonHoc mh) {
        dsMonHoc.remove(mh);
    }

    //chua test
    public List<MonHoc> timKiemMon(String keyword) {
        List<MonHoc> ds = this.dsMonHoc.stream()
                .filter(m -> m.getTenMonHoc().equals(keyword) 
                        || m.getMaMonHoc().equals(keyword))
                .collect(Collectors.toList());
        return ds;
    }
    public static boolean isMonDaTonTai(MonHoc m) {
        return HeThongQuanLy.dsMonHoc.getDsMonHoc().contains(m);
    }
}
