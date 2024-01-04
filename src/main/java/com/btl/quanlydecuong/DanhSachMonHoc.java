package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DanhSachMonHoc {

    private List<MonHoc> dsMonHoc = new ArrayList<>();

    public DanhSachMonHoc() {
    }

    public DanhSachMonHoc(MonHoc... mh) {
        this.dsMonHoc.addAll(Arrays.asList(mh));
    }

    public void themMonHoc(MonHoc mh) {
        dsMonHoc.add(mh);
    }

    //chua test
    public List<MonHoc> timKiemMon(String keyword) {
        List<MonHoc> ds = this.dsMonHoc.stream()
                .filter(m -> m.getTenMonHoc().equals(keyword) 
                        || m.getMaMonHoc().equals(keyword))
                .collect(Collectors.toList());
        return ds;
    }
}
