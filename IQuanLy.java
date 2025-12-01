import java.util.List;
public interface IQuanLy<T> {
    void them(T item);
    void capNhat(String maSV, T item);
    void xoa(String maSV);
    List<T> layTatCa();
}
