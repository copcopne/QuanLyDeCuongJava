package com.btl.quanlydecuong;

public class MonCoSoNganh extends MonHoc {

    public MonCoSoNganh(String maMonHoc, String tenMonHoc, double soTinChi, String moTaMonHoc) {
        super(maMonHoc, tenMonHoc, soTinChi, moTaMonHoc);
    }

    @Override
    public String toString() {
        return "Khối kiến thức: Cơ Sở Ngành\n" + super.toString(); 
    }
    
}
