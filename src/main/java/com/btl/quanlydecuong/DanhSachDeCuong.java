package com.btl.quanlydecuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhSachDeCuong {

    private List<DeCuongMonHoc> dsDeCuong = new ArrayList<>();

    public List<DeCuongMonHoc> getDsDeCuong() {
        return dsDeCuong;
    }

    public void setDsDeCuong(List<DeCuongMonHoc> dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

    public DanhSachDeCuong() {
    }

    public void themDeCuong(DeCuongMonHoc d) {
        this.dsDeCuong.add(d);
    }

    public void themDecuong(DeCuongMonHoc... d) {
        this.dsDeCuong.addAll(Arrays.asList(d));
    }

    public void xoaDeCuong(DeCuongMonHoc d) {
        this.dsDeCuong.remove(d);
    }

    public DeCuongMonHoc timKiem(String maMH,He he) {
        return this.dsDeCuong.stream().filter(d -> d.getMon().getMaMonHoc()
                .equals(maMH)).filter(d->d.getHeDaoTao().equals(he)).findFirst().get();
    }
    public DeCuongMonHoc timKiem(MonHoc h) {
        return this.dsDeCuong.stream().filter(d-> d.getMon() == h).findFirst().get();
    }
    //chua test
    public void sapXepDeCuong() {
        this.dsDeCuong.sort((dc1, dc2) -> {
            int kiemTraTinChi = Double.compare(dc2.getMon().getSoTinChi(), dc1.getMon().getSoTinChi());
            if (kiemTraTinChi != 0) {
                return kiemTraTinChi;
            }
            return dc1.getMon().getMaMonHoc().compareTo(dc2.getMon().getMaMonHoc());
        });
    }

    //chua test / chua chac
    public void thongKeDeCuong() {
        Map<Double,Integer> deCuongTheoTinChi = new HashMap<>();
        //them key va value
        for(var dc:dsDeCuong)
        {
            double soTinChi = dc.getMon().getSoTinChi(); //Dat dc.getMon().getSoTinChi() thanh sotinchi de viet cho gon
            deCuongTheoTinChi.put(soTinChi,deCuongTheoTinChi.getOrDefault(soTinChi, 0)+1); //them key, value = value cua key hien tai + 1
        }
        
        //xuat ra man hinh
        System.out.println("Thong ke de cuong theo so tin chi:");
        //copy code tren google cho khuc nay ;;
        for (Map.Entry<Double, Integer> entry : deCuongTheoTinChi.entrySet()) {
            System.out.printf("%.1f tin chi: %d de cuong", entry.getKey(),entry.getValue());
            
        }
    }

    //chua test
    public void xuatDanhSach() {
        this.dsDeCuong.forEach(dc -> System.out.printf("%s",
                dc.getGiangVienBienSoan().getTenGiangVien(), dc));
    }

    @Override
    public String toString() {
        String s = "";
        for(var d : this.dsDeCuong) {
            s += d;
        }
        return s;
    }
    
    

}
