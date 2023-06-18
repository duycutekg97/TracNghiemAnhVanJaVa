import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NguoiHoc {

    private int maHv;
    private static int dem = 0;
    {
        dem++;
        this.maHv = dem;
    }
    private String hoTen;
    private String queQuan;
    private String gioiTinh;
    private Date ngaySinh;
    private Date ngayGiaNhap;
    private int thang;
    private int soLanThi;
    private double diem;
    private List<Integer> dsMu = new ArrayList<>();


    private static final SimpleDateFormat fb = new SimpleDateFormat("MM");
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");


    public NguoiHoc(int thang , int mahv,String ten,double diem){
        this.setThang(thang);
        this.maHv =mahv;
        this.hoTen = ten;
        this.diem = diem;
    }



    public void KetQuaHocTap(){
        System.out.printf("Họ và tên : %s\n",this.hoTen);
        System.out.printf("Số lần thi : %s\n",this.soLanThi);
        System.out.printf("Số điểm trung bình trong tháng : %.1f",this.diem);
    }




    public NguoiHoc(String hoTen, String queQuan, String gioiTinh, String ngaySinh, String ngayGiaNhap) throws ParseException {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = F.parse(ngaySinh);
        this.ngayGiaNhap = F.parse(ngayGiaNhap);
    }
    public void display(){
        System.out.printf("Mã Hv : %s\n",this.maHv);
        System.out.printf("Họ và tên : %s\n",this.hoTen);
        System.out.printf("Quê quán : %s\n",this.queQuan);
        System.out.printf("Gioi Tinh : %s\n",this.gioiTinh);
        System.out.printf("Ngày sinh : %s\n",F.format(this.ngaySinh));
        System.out.printf("Ngày vào lớp :%s\n",F.format(this.ngayGiaNhap));
    }
    public void MutiplechoiceDalam1 () throws FileNotFoundException {
        File f = new File("src/main/resources/mutiplechoiceDalam.txt");
        ArrayList<Integer> dsCauHoi = new ArrayList<>();
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                int i = 0;

                int mahocvien = sc.nextInt();
                while(sc.hasNextInt()) {
                    if(i==14){
                        break;
                    }
                    int cauhoi = sc.nextInt();
                    if(mahocvien==this.maHv&&cauhoi!=0){
                        dsCauHoi.add(cauhoi);
                    }

                    i++;
                }

            }
        }
       setDsMu(dsCauHoi);
    }


    public static int getDem() {
        return dem;
    }

    public static void setDem() {
        dem=0;
    }
    public int getMaHv() {
        return maHv;
    }

    public void setMaHv(int maHv) {
        this.maHv = maHv;
    }



    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayGiaNhap() {
        return ngayGiaNhap;
    }

    public void setNgayGiaNhap(Date ngayGiaNhap) {
        this.ngayGiaNhap = ngayGiaNhap;
    }
    public int getSoLanThi() {
        return soLanThi;
    }

    public void setSoLanThi(int soLanThi) {
        this.soLanThi = soLanThi;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public List<Integer> getDsMu() {
        return dsMu;
    }

    public void setDsMu(List<Integer> dsMu) {
        this.dsMu = dsMu;
    }
}
