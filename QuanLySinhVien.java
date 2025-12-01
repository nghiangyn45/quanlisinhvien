import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien implements IQuanLy<SinhVien>, ITimKiem, IBaoCao {
    private List<SinhVien> danhSach = new ArrayList<>();

    @Override
    public void them(SinhVien sv) {
        danhSach.add(sv);
    }

    @Override
    public void capNhat(String maSV, SinhVien svMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSV().equals(maSV)) {
                danhSach.set(i, svMoi);
                return;
            }
        }
    }

    @Override
    public void xoa(String maSV) {
        danhSach.removeIf(sv -> sv.getMaSV().equals(maSV));
    }

    @Override
    public List<SinhVien> layTatCa() {
        return danhSach;
    }

    @Override
    public SinhVien timTheoMa(String maSV) {
        return danhSach.stream()
                .filter(sv -> sv.getMaSV().equals(maSV))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<SinhVien> timTheoTen(String ten) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                kq.add(sv);
            }
        }
        return kq;
    }

    @Override
    public void xuatBaoCao() {
        System.out.println("===== DANH SÁCH SINH VIÊN =====");
        for (SinhVien sv : danhSach) {
            sv.xuat();
            System.out.println("-------------------------");
        }
    }
}
