import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class QuanLyNguoiHoc {
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private List<NguoiHoc> ds = new ArrayList<>();
    private List<NguoiHoc> dsKetQua = new ArrayList<>();

    public void capNhatThongKe(int n) throws IOException {
        int dem = 0;

        List<Integer> thang = new ArrayList<>();
        List<Integer> mahv = new ArrayList<>();
        List<String> ten = new ArrayList<>();
        List<Double> diem = new ArrayList<>();
        File f = new File("src/main/resources/thongkeketquahoctap.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                int thang1 = parseInt(s.nextLine());
                int mahv1 = parseInt(s.nextLine());
                String ten1 = s.nextLine();
                double diem1 = parseDouble(s.nextLine());
                if (mahv1 != n) {
                    thang.add(thang1);
                    mahv.add(mahv1);
                    ten.add(ten1);
                    diem.add(diem1);
                    dem++;
                }
            }
        }

        FileWriter w = new FileWriter(f);

        try (PrintWriter w2 = new PrintWriter(w)) {
            for (int i = 0; i < dem; i++)
                if (mahv.get(i) > n) {
                    w2.printf("%d\n%d\n%s\n%.1f\n", thang.get(i), mahv.get(i) - 1, ten.get(i), diem.get(i));
                } else if (mahv.get(i) < n) {
                    w2.printf("%d\n%d\n%s\n%.1f\n", thang.get(i), mahv.get(i), ten.get(i), diem.get(i));
                } else {
                    w2.printf("%d\n%d\n%s\n%.1f\n", thang.get(i), mahv.get(i) - 1, ten.get(i), diem.get(i));
                }
        }
    }

    public void ThongKeHocTap(int n, int m) throws FileNotFoundException, ParseException {
        List<Double> diemmm = new ArrayList<>();
        File f = new File("src/main/resources/thongkeketquahoctap.txt");
        int dem = 1;
        double diemtb = 0;
        int soLanThi = 0;
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNext()) {
                int thang = parseInt(scanner.nextLine());
                int maHv = parseInt(scanner.nextLine());
                String hoten = scanner.nextLine();
                double diem = parseDouble(scanner.nextLine());
                if (thang == n && maHv == m) {
                    diemtb += diem;
                    soLanThi++;
                    diemmm.add(diem);
                }

            }
        }
        for (NguoiHoc b : this.ds) {
            if (b.getMaHv() == m) {
                b.setSoLanThi(soLanThi);
                b.setDiem(diemtb / (double) (soLanThi));
                b.KetQuaHocTap();
            }
        }
        System.out.println();
        for (Double d : diemmm) {
            System.out.printf("Thi lần %d : %.1f   \t\n", dem++, d);
        }




    }

    public void display() {
        for (NguoiHoc a : this.ds)
            a.display();
    }

    public void docDsNguoiHoc(String path) throws FileNotFoundException {
        File f = new File(path);
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNext()) {
                String hoTen = scanner.nextLine();
                String queQuan = scanner.nextLine();
                String gioiTinh = scanner.nextLine();
                String ngaySinh = scanner.nextLine();
                String ngayvao = scanner.nextLine();
                NguoiHoc Hv = new NguoiHoc(hoTen, queQuan, gioiTinh, ngaySinh, ngayvao);
                this.ds.add(Hv);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (NguoiHoc a : ds) {
            a.MutiplechoiceDalam1();
        }
    }

    public List<NguoiHoc> docThongTinNguoiHoc() {
        return this.ds.stream().collect(Collectors.toList());
    }

    public void capNhatThongTin(int maHv) throws ParseException {
        int choose;
        String update;
        for (NguoiHoc a : this.ds) {
            if (a.getMaHv() == maHv) {
                do {
                    System.out.print("====MENU cập nhật====\n1.Họ tên\n2.Giới tính\n3.Quê Quán\n4.Ngày sinh\n5.Ngày tham gia\n0.Ket Thuc\n");
                    System.out.println("=>Bạn chọn : ");
                    choose = sc.nextInt();

                    sc.nextLine();
                    switch (choose) {
                        case 1:
                            System.out.print("Nhập tên muốn đổi: ");
                            String tmp = a.getHoTen();
                            update = sc.nextLine();
                            a.setHoTen(update);
                            break;
                        case 2:
                            System.out.print("Nhập giới tính muốn đổi : ");
                            String upDateGioiTinh = sc.nextLine();
                            a.setGioiTinh(upDateGioiTinh);
                            break;
                        case 3:
                            System.out.print("Nhập quê quán muốn đổi : ");
                            String updateQueQuan = sc.nextLine();
                            a.setQueQuan(updateQueQuan);
                            break;
                        case 4:
                            System.out.print("Nhập ngày sinh muốn đổi : ");
                            String upNgaySinh = sc.nextLine();
                            Date ns = F.parse(upNgaySinh);
                            a.setNgaySinh(ns);
                            break;
                        case 5:
                            System.out.print("Nhập ngày tham gia muốn đổi : ");
                            String upNgayThamGia = sc.nextLine();
                            Date ntg = F.parse(upNgayThamGia);
                            a.setNgayGiaNhap(ntg);
                            break;
                    }
                } while (choose != 0);
            }
        }
    }

    public void capNhatNguoiHocKhiXoa(String path) throws IOException {
        File f = new File(path);
        FileWriter w = new FileWriter(f);
        try (PrintWriter w2 = new PrintWriter(w)) {
            for (NguoiHoc h : this.ds) {
                w2.printf("%s\n%s\n%s\n%s\n%s\n", h.getHoTen(), h.getQueQuan(), h.getGioiTinh(), new SimpleDateFormat("dd/MM/yyyy").format(h.getNgaySinh()), new SimpleDateFormat("dd/MM/yyyy").format(h.getNgayGiaNhap()));
            }
        }
        NguoiHoc.setDem();
    }

    public void capnhatNguoiHoc(String path) throws IOException {
        File f = new File(path);
        FileWriter w = new FileWriter(f);
        try (PrintWriter w2 = new PrintWriter(w)) {
            for (NguoiHoc h : this.ds) {
                w2.printf("%s\n%s\n%s\n%s\n%s\n", h.getHoTen(), h.getQueQuan(), h.getGioiTinh(), new SimpleDateFormat("dd/MM/yyyy").format(h.getNgaySinh()), new SimpleDateFormat("dd/MM/yyyy").format(h.getNgayGiaNhap()));
            }
        }

    }

//    public void capNhatFileMutiplechoiceDalam(int mahv){
//        for(NguoiHoc a: ds){
//            try()
//            if(a.getMaHv() ==mahv){
//
//            }
//        }
//    }
    public void xoaNguoiHoc(int n){
        ds.remove(n);
        NguoiHoc.setDem();
    }
    public void themNguoiHoc() throws ParseException {
        System.out.println("Nhập vào tên người học : ");String name = sc.nextLine();
        System.out.println("Nhập vào quê quán : ");String queQuan=sc.nextLine();
        System.out.println("Nhập vào giới tính : ");String gioiTinh=sc.nextLine();
        System.out.println("Nhập vào ngày sinh :");String ngaySinh=sc.nextLine();
        System.out.println("Nhập vào ngày vào học : ");String ngayVao=sc.nextLine();
        NguoiHoc a = new NguoiHoc(name,queQuan,gioiTinh,ngaySinh,ngayVao);
        ds.add(a);
    }

    public List<NguoiHoc> getDs() {
        return ds;
    }

    public void setDs(List<NguoiHoc> ds) {
        this.ds = ds;
    }
    public void setDsKhongHocVien(){
        List<NguoiHoc> a = new ArrayList<>();
        this.ds = a;
    }

    public List<NguoiHoc> getDsKetQua() {
        return dsKetQua;
    }

    public void setDsKetQua(List<NguoiHoc> dsKetQua) {
        this.dsKetQua = dsKetQua;
    }
}
