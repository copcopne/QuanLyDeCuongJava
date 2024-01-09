package com.btl.quanlydecuong;

/**
 *
 * @author Si Nguyen
 */
public class Run {

    public static void main(String[] args) throws Exception {
        HeThongQuanLy heThongQuanLy = HeThongQuanLy.taoHeThong();
        MonHoc c1 = new MonChuyenNganh("122", "ten", 9999, "mota");
        System.out.println(c1);
    }
}
