
import com.btl.quanlydecuong.DanhSachDeCuong;
import com.btl.quanlydecuong.DanhSachMonHoc;
import com.btl.quanlydecuong.GiangVien;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeThongQuanLy {

    private List<GiangVien> dsGiangVien = new ArrayList<>();
    private DanhSachDeCuong dsDeCuong;
    private DanhSachMonHoc dsMonHoc;
    public HeThongQuanLy() {
    }
        
    public void themGiangVien(GiangVien... g) {
        this.dsGiangVien.addAll(Arrays.asList(g));
    }
    public void themGiangVien(GiangVien g) {
        this.dsGiangVien.add(g);
    }
    public void xoaGiangVien(String kw) {
        this.dsGiangVien.removeIf(g -> g.getTenGiangVien().contains(kw) 
                || g.getMaGiangVien().equals(kw));
    }

    public void xoaGiangVien(GiangVien g) {
        this.dsGiangVien.remove(g);
    }
    
    public GiangVien timGiangVien(String maGiangVien) {
        return this.dsGiangVien.stream().filter(g->g.getMaGiangVien()
                .equals(maGiangVien)).findFirst().get();
    }
    public DanhSachDeCuong deCuongTheoGV(String maGiangVien){
        DanhSachDeCuong ds =  timGiangVien(maGiangVien).getDsDeCuongBienSoan();
        ds.xuatDanhSach();
        return ds;
    }
    
    
}
