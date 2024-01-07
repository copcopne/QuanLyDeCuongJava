
import com.btl.quanlydecuong.DanhSachDeCuong;
import com.btl.quanlydecuong.DanhSachMonHoc;
import com.btl.quanlydecuong.GiangVien;
import com.btl.quanlydecuong.He;
import com.btl.quanlydecuong.MonHoc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeThongQuanLy {

    private List<GiangVien> dsGiangVien = new ArrayList<>();
    private DanhSachDeCuong dsDeCuong;
    private DanhSachMonHoc dsMonHoc;

    public List<GiangVien> getDsGiangVien() {
        return dsGiangVien;
    }

    public void setDsGiangVien(List<GiangVien> dsGiangVien) {
        this.dsGiangVien = dsGiangVien;
    }

    public DanhSachDeCuong getDsDeCuong() {
        return dsDeCuong;
    }

    public void setDsDeCuong(DanhSachDeCuong dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

    public DanhSachMonHoc getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(DanhSachMonHoc dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }
    
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

    public void taoDeCuong(MonHoc mon, He heDaoTao, String noiDungMonHoc, 
            String mucTieuMonHoc, String chuanDauRa, GiangVien giangVienBienSoan, 
            DanhSachMonHoc monHocTienQuyet, DanhSachMonHoc monHocTruoc, GiangVien g) {
        if (g.getSoDeCuongBienSoan() > 5 && ((dsMonHoc.isMonDaTonTai(mon) == true  && dsDeCuong.timKiem(mon.getMaMonHoc()).getHeDaoTao().equals(heDaoTao) == false) || (dsMonHoc.isMonDaTonTai(mon) == false))) {
            
        }
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
