package com.btl.quanlydecuong;

public class HinhThuc {

    private String phuongPhapDanhGia;
    private String noiDungDanhGia;
    private double tyTrong;

    public String getPhuongPhapDanhGia() {
        return phuongPhapDanhGia;
    }

    public void setPhuongPhapDanhGia(String phuongPhapDanhGia) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
    }

    public String getNoiDungDanhGia() {
        return noiDungDanhGia;
    }

    public void setNoiDungDanhGia(String noiDungDanhGia) {
        this.noiDungDanhGia = noiDungDanhGia;
    }

    public double getTyTrong() {
        return tyTrong;
    }

    public void setTyTrong(double tyTrong) {
        this.tyTrong = tyTrong;
    }

    
    
    private HinhThuc(String phuongPhapDanhGia, String noiDungDanhGia, double tyTrong) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
        this.noiDungDanhGia = noiDungDanhGia;
        this.tyTrong = tyTrong;
    }

    public static HinhThuc taoHinhThuc(DeCuongMonHoc dc, String ppDanhGia,
            String ndDanhGia, double tyTrong, boolean checkIfValid) {
        
        if(dc.getHinhThucDanhGia().size() > 4 || checkIfValid == false){
            return null;
        }
        return new HinhThuc(ppDanhGia,ndDanhGia,tyTrong);
    }
}
