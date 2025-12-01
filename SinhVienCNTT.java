import java.util.Date;
public class SinhVienCNTT extends SinhVien {
    private double diemJava;
    private double diemHTML;
    private double diemCSS;

    public SinhVienCNTT() {}

    public SinhVienCNTT(String maSV, String hoTen, Date ngaySinh, double diemJava, double diemHTML, double diemCSS) {
        super(maSV, hoTen, ngaySinh, "Công nghệ thông tin");
        this.diemJava = diemJava;
        this.diemHTML = diemHTML;
        this.diemCSS = diemCSS;
    }

    // Getter - Setter
    public double getDiemJava() { 
        return diemJava; 
    }
    public void setDiemJava(double diemJava) { 
        this.diemJava = diemJava; 
    }
    public double getDiemHTML() { 
        return diemHTML; 
    }
    public void setDiemHTML(double diemHTML) { 
        this.diemHTML = diemHTML; 
    }
    public double getDiemCSS() { 
        return diemCSS; 
    }
    public void setDiemCSS(double diemCSS) { 
        this.diemCSS = diemCSS; 
    }
    @Override
    public double tinhDiemTrungBinh() {
        return diemJava * 0.5 + diemHTML * 0.3 + diemCSS * 0.2;
    }

    @Override
    public void xuat() {
        System.out.println("=== Sinh viên CNTT ===");
        super.xuat();
    }
}
