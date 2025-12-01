import java.util.Date;
public abstract class SinhVien {
    protected String maSV;
    protected String hoTen;
    protected Date ngaySinh;
    protected String chuyenNganh;

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, Date ngaySinh, String chuyenNganh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.chuyenNganh = chuyenNganh;
    }

    // Getter và setter
    public String getMaSV() { 
        return maSV; 
    }
    public void setMaSV(String maSV) { 
        this.maSV = maSV; 
    }
    public String getHoTen() {
        return hoTen; 
    }
    public void setHoTen(String hoTen) { 
        this.hoTen = hoTen; 
    }
    public Date getNgaySinh() { 
        return ngaySinh; 
    }
    public void setNgaySinh(Date ngaySinh) { 
        this.ngaySinh = ngaySinh; 
    }
    public String getChuyenNganh() { 
        return chuyenNganh; 
    }
    public void setChuyenNganh(String chuyenNganh) { 
        this.chuyenNganh = chuyenNganh; 
    }
    // Xuất thông tin
    public void xuat() {
        System.out.println("Mã sinh viên: " + maSV);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Chuyên ngành: " + chuyenNganh);
        System.out.println("Điểm trung bình: " + tinhDiemTrungBinh());
    }

    // Phương thức trừu tượng
    public abstract double tinhDiemTrungBinh();
}
