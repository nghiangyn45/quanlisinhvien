import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        QuanLySinhVien ql = new QuanLySinhVien();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("===== NHẬP THÔNG TIN SINH VIÊN ĐẦU TIÊN =====");
            
            // Nhập số lượng sinh viên ban đầu
            System.out.print("Nhập số lượng sinh viên cần thêm: ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\n----- Nhập thông tin sinh viên thứ " + (i + 1) + " -----");
                System.out.println("Chọn loại sinh viên: 1.CNTT  2.Kinh tế");
                int loai = Integer.parseInt(scanner.nextLine());

                System.out.print("Nhập mã sinh viên: ");
                String ma = scanner.nextLine();

                // Kiểm tra mã sinh viên đã tồn tại chưa
                if (ql.timTheoMa(ma) != null) {
                    System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập lại.");
                    i--; // Giảm i để nhập lại
                    continue;
                }

                System.out.print("Nhập họ tên: ");
                String ten = scanner.nextLine();

                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                Date ngaySinh = dateFormat.parse(scanner.nextLine());

                if (loai == 1) {
                    System.out.print("Điểm Java: ");
                    double java = Double.parseDouble(scanner.nextLine());

                    System.out.print("Điểm HTML: ");
                    double html = Double.parseDouble(scanner.nextLine());

                    System.out.print("Điểm CSS: ");
                    double css = Double.parseDouble(scanner.nextLine());

                    SinhVienCNTT sv = new SinhVienCNTT(ma, ten, ngaySinh, java, html, css);
                    ql.them(sv);
                    System.out.println("Đã thêm sinh viên CNTT - Điểm TB: " + sv.tinhDiemTrungBinh());
                } 
                else if (loai == 2) {
                    System.out.print("Điểm Marketing: ");
                    double mk = Double.parseDouble(scanner.nextLine());

                    System.out.print("Điểm Sales: ");
                    double sales = Double.parseDouble(scanner.nextLine());

                    SinhVienKinhTe sv = new SinhVienKinhTe(ma, ten, ngaySinh, mk, sales);
                    ql.them(sv);
                    System.out.println("Đã thêm sinh viên Kinh tế - Điểm TB: " + sv.tinhDiemTrungBinh());
                }
                else {
                    System.out.println("Loại sinh viên không hợp lệ! Vui lòng nhập lại.");
                    i--; // Giảm i để nhập lại
                }
            }

            System.out.println("\n✨ Đã hoàn thành nhập thông tin " + n + " sinh viên!");
            System.out.println("Điểm trung bình đã được tính tự động cho từng sinh viên.");

            // Hiển thị menu chính sau khi nhập xong
            hienThiMenuChinh(ql, scanner, dateFormat);
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static void hienThiMenuChinh(QuanLySinhVien ql, Scanner scanner, SimpleDateFormat dateFormat) {
        int choice;
        do {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm sinh viên theo mã");
            System.out.println("4. Tìm sinh viên theo tên");
            System.out.println("5. Cập nhật thông tin sinh viên");
            System.out.println("6. Xóa sinh viên");
            System.out.println("7. Xuất báo cáo đầy đủ");
            System.out.println("8. Tính lại điểm trung bình cho tất cả sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        themSinhVienMoi(ql, scanner, dateFormat);
                        break;
                    case 2:
                        hienThiTatCaSinhVien(ql);
                        break;
                    case 3:
                        timSinhVienTheoMa(ql, scanner);
                        break;
                    case 4:
                        timSinhVienTheoTen(ql, scanner);
                        break;
                    case 5:
                        capNhatSinhVien(ql, scanner, dateFormat);
                        break;
                    case 6:
                        xoaSinhVien(ql, scanner);
                        break;
                    case 7:
                        xuatBaoCaoDayDu(ql);
                        break;
                    case 8:
                        tinhLaiDiemTrungBinh(ql);
                        break;
                    case 0:
                        System.out.println("Cảm ơn đã sử dụng chương trình!");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ! Vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                choice = -1;
            }
        } while (choice != 0);
    }
    
    private static void themSinhVienMoi(QuanLySinhVien ql, Scanner scanner, SimpleDateFormat dateFormat) {
        try {
            System.out.println("\n===== THÊM SINH VIÊN MỚI =====");
            System.out.println("Chọn loại sinh viên: 1.CNTT  2.Kinh tế");
            int loai = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập mã sinh viên: ");
            String ma = scanner.nextLine();

            if (ql.timTheoMa(ma) != null) {
                System.out.println("Mã sinh viên đã tồn tại!");
                return;
            }

            System.out.print("Nhập họ tên: ");
            String ten = scanner.nextLine();

            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            Date ngaySinh = dateFormat.parse(scanner.nextLine());

            if (loai == 1) {
                System.out.print("Điểm Java: ");
                double java = Double.parseDouble(scanner.nextLine());

                System.out.print("Điểm HTML: ");
                double html = Double.parseDouble(scanner.nextLine());

                System.out.print("Điểm CSS: ");
                double css = Double.parseDouble(scanner.nextLine());

                SinhVienCNTT sv = new SinhVienCNTT(ma, ten, ngaySinh, java, html, css);
                ql.them(sv);
                System.out.println("Thêm sinh viên CNTT thành công! Điểm TB: " + sv.tinhDiemTrungBinh());
            } 
            else if (loai == 2) {
                System.out.print("Điểm Marketing: ");
                double mk = Double.parseDouble(scanner.nextLine());

                System.out.print("Điểm Sales: ");
                double sales = Double.parseDouble(scanner.nextLine());

                SinhVienKinhTe sv = new SinhVienKinhTe(ma, ten, ngaySinh, mk, sales);
                ql.them(sv);
                System.out.println("Thêm sinh viên Kinh tế thành công! Điểm TB: " + sv.tinhDiemTrungBinh());
            }
            else {
                System.out.println("Loại sinh viên không hợp lệ!");
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
        }
    }
    
    private static void hienThiTatCaSinhVien(QuanLySinhVien ql) {
        System.out.println("\n===== DANH SÁCH TẤT CẢ SINH VIÊN =====");
        List<SinhVien> danhSach = ql.layTatCa();
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            for (SinhVien sv : danhSach) {
                sv.xuat();
                System.out.println("Điểm trung bình: " + sv.tinhDiemTrungBinh());
                System.out.println("-------------------------");
            }
            System.out.println("Tổng số sinh viên: " + danhSach.size());
        }
    }
    
    private static void timSinhVienTheoMa(QuanLySinhVien ql, Scanner scanner) {
        System.out.print("\nNhập mã sinh viên cần tìm: ");
        String ma = scanner.nextLine();
        
        SinhVien sv = ql.timTheoMa(ma);
        if (sv != null) {
            System.out.println("=== THÔNG TIN SINH VIÊN ===");
            sv.xuat();
            System.out.println("Điểm trung bình: " + sv.tinhDiemTrungBinh());
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + ma);
        }
    }
    
    private static void timSinhVienTheoTen(QuanLySinhVien ql, Scanner scanner) {
        System.out.print("\nNhập tên sinh viên cần tìm: ");
        String ten = scanner.nextLine();
        
        List<SinhVien> ketQua = ql.timTheoTen(ten);
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên với tên: " + ten);
        } else {
            System.out.println("=== KẾT QUẢ TÌM KIẾM (" + ketQua.size() + " sinh viên) ===");
            for (SinhVien sv : ketQua) {
                sv.xuat();
                System.out.println("Điểm trung bình: " + sv.tinhDiemTrungBinh());
                System.out.println("-------------------------");
            }
        }
    }
    
    private static void capNhatSinhVien(QuanLySinhVien ql, Scanner scanner, SimpleDateFormat dateFormat) {
        try {
            System.out.print("\nNhập mã sinh viên cần cập nhật: ");
            String ma = scanner.nextLine();
            
            SinhVien svCu = ql.timTheoMa(ma);
            if (svCu == null) {
                System.out.println("Không tìm thấy sinh viên với mã: " + ma);
                return;
            }
            
            System.out.println("Thông tin hiện tại:");
            svCu.xuat();
            System.out.println("Điểm trung bình: " + svCu.tinhDiemTrungBinh());
            System.out.println("-------------------------");
            
            System.out.println("Nhập thông tin mới:");
            System.out.print("Họ tên (" + svCu.getHoTen() + "): ");
            String ten = scanner.nextLine();
            if (ten.trim().isEmpty()) {
                ten = svCu.getHoTen();
            }

            System.out.print("Ngày sinh (dd/MM/yyyy) (" + dateFormat.format(svCu.getNgaySinh()) + "): ");
            String ngaySinhStr = scanner.nextLine();
            Date ngaySinh;
            if (ngaySinhStr.trim().isEmpty()) {
                ngaySinh = svCu.getNgaySinh();
            } else {
                ngaySinh = dateFormat.parse(ngaySinhStr);
            }

            SinhVien svMoi;
            if (svCu instanceof SinhVienCNTT) {
                SinhVienCNTT svCNTT = (SinhVienCNTT) svCu;
                
                System.out.print("Điểm Java (" + svCNTT.getDiemJava() + "): ");
                String javaStr = scanner.nextLine();
                double java = javaStr.trim().isEmpty() ? svCNTT.getDiemJava() : Double.parseDouble(javaStr);

                System.out.print("Điểm HTML (" + svCNTT.getDiemHTML() + "): ");
                String htmlStr = scanner.nextLine();
                double html = htmlStr.trim().isEmpty() ? svCNTT.getDiemHTML() : Double.parseDouble(htmlStr);

                System.out.print("Điểm CSS (" + svCNTT.getDiemCSS() + "): ");
                String cssStr = scanner.nextLine();
                double css = cssStr.trim().isEmpty() ? svCNTT.getDiemCSS() : Double.parseDouble(cssStr);

                svMoi = new SinhVienCNTT(ma, ten, ngaySinh, java, html, css);
            } 
            else {
                SinhVienKinhTe svKT = (SinhVienKinhTe) svCu;
                
                System.out.print("Điểm Marketing (" + svKT.getDiemMarketing() + "): ");
                String mkStr = scanner.nextLine();
                double mk = mkStr.trim().isEmpty() ? svKT.getDiemMarketing() : Double.parseDouble(mkStr);

                System.out.print("Điểm Sales (" + svKT.getDiemSales() + "): ");
                String salesStr = scanner.nextLine();
                double sales = salesStr.trim().isEmpty() ? svKT.getDiemSales() : Double.parseDouble(salesStr);

                svMoi = new SinhVienKinhTe(ma, ten, ngaySinh, mk, sales);
            }
            
            ql.capNhat(ma, svMoi);
            System.out.println(" Cập nhật sinh viên thành công! Điểm TB mới: " + svMoi.tinhDiemTrungBinh());
            
        } catch (Exception e) {
            System.out.println(" Lỗi khi cập nhật sinh viên: " + e.getMessage());
        }
    }
    
    private static void xoaSinhVien(QuanLySinhVien ql, Scanner scanner) {
        System.out.print("\nNhập mã sinh viên cần xóa: ");
        String ma = scanner.nextLine();
        
        SinhVien sv = ql.timTheoMa(ma);
        if (sv != null) {
            System.out.println("Thông tin sinh viên sẽ bị xóa:");
            sv.xuat();
            System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("y")) {
                ql.xoa(ma);
                System.out.println("Xóa sinh viên thành công!");
            } else {
                System.out.println("Đã hủy thao tác xóa.");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + ma);
        }
    }
    
    private static void xuatBaoCaoDayDu(QuanLySinhVien ql) {
        System.out.println("\n===== BÁO CÁO ĐẦY ĐỦ SINH VIÊN =====");
        ql.xuatBaoCao();
        
        List<SinhVien> danhSach = ql.layTatCa();
        if (!danhSach.isEmpty()) {
            double tongDiem = 0;
            double maxDiem = Double.MIN_VALUE;
            double minDiem = Double.MAX_VALUE;
            SinhVien svMax = null;
            SinhVien svMin = null;
            
            for (SinhVien sv : danhSach) {
                double diemTB = sv.tinhDiemTrungBinh();
                tongDiem += diemTB;
                
                if (diemTB > maxDiem) {
                    maxDiem = diemTB;
                    svMax = sv;
                }
                if (diemTB < minDiem) {
                    minDiem = diemTB;
                    svMin = sv;
                }
            }
            
            double diemTBChung = tongDiem / danhSach.size();
            
            System.out.println("\n=== THỐNG KÊ ===");
            System.out.println("Tổng số sinh viên: " + danhSach.size());
            System.out.println("Điểm trung bình chung: " + String.format("%.2f", diemTBChung));
            System.out.println("Sinh viên có điểm cao nhất: " + svMax.getHoTen() + " - " + maxDiem);
            System.out.println("Sinh viên có điểm thấp nhất: " + svMin.getHoTen() + " - " + minDiem);
        }
    }
    
    private static void tinhLaiDiemTrungBinh(QuanLySinhVien ql) {
        System.out.println("\n===== TÍNH LẠI ĐIỂM TRUNG BÌNH =====");
        List<SinhVien> danhSach = ql.layTatCa();
        
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        
        System.out.println("Đã tính lại điểm trung bình cho " + danhSach.size() + " sinh viên:");
        for (SinhVien sv : danhSach) {
            double diemTB = sv.tinhDiemTrungBinh();
            System.out.println("- " + sv.getHoTen() + " (" + sv.getMaSV() + "): " + diemTB);
        }
    }
}