package com.btl.quanlydecuong;

/**
 *
 * @author Si Nguyen
 */
public class Run {

    public static void main(String[] args) throws Exception {
        HeThongQuanLy heThongQuanLy = HeThongQuanLy.taoHeThong();
        HeThongQuanLy.dsMonHoc.getDsMonHoc().forEach(c-> {
            System.out.println(c);
        });
    }
}
