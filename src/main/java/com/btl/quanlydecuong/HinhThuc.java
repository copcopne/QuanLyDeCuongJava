package com.btl.quanlydecuong;

public class HinhThuc {

    private String phuongPhapDanhGia;
    private String noiDungDanhGia;
    private int tyTrong;

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

    public void setTyTrong(int tyTrong) {
        this.tyTrong = tyTrong;
    }

    
    
    private HinhThuc(String phuongPhapDanhGia, String noiDungDanhGia, int tyTrong) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
        this.noiDungDanhGia = noiDungDanhGia;
        this.tyTrong = tyTrong;
    }

    public static HinhThuc taoHinhThuc(DeCuongMonHoc dc, String ppDanhGia,
            String ndDanhGia, int tyTrong, boolean checkIfValid) {
        
        if(dc.getHinhThucDanhGia().size() > 4 || checkIfValid == false){
            return null;
        }
        return new HinhThuc(ppDanhGia,ndDanhGia,tyTrong);
    }

    @Override
    public String toString() {
        return String.format("\nP.P danh gia: %s\nN.D danh gia: %s\nTy trong: %d%%\n",
                this.phuongPhapDanhGia,this.noiDungDanhGia,this.tyTrong);
    }
    
}
