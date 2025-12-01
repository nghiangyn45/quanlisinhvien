import java.util.Date;
public class SinhVienKinhTe extends SinhVien {
    private double diemMarketing;
    private double diemSales;

    public SinhVienKinhTe() {}

    public SinhVienKinhTe(String maSV, String hoTen, Date ngaySinh,
                          double diemMarketing, double diemSales) {
        super(maSV, hoTen, ngaySinh, "Kinh tế");
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
    }

    // Getter - Setter
    public double getDiemMarketing() { 
        return diemMarketing; 
    }
    public void setDiemMarketing(double diemMarketing) { 
        this.diemMarketing = diemMarketing; 
    }
    public double getDiemSales() { 
        return diemSales; 
    }
    public void setDiemSales(double diemSales) { 
        this.diemSales = diemSales; 
    }
    @Override
    public double tinhDiemTrungBinh() {
        return diemMarketing * 0.6 + diemSales * 0.4;
    }

    @Override
    public void xuat() {
        System.out.println("=== Sinh viên Kinh tế ===");
        super.xuat();
    }
}
