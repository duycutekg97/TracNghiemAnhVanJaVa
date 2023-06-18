import java.util.List;
import java.util.Scanner;

public class Mutiplechoice extends Question {
    public static Scanner sc = new Scanner(System.in);
    public static int SO_CAU=14;
    private static int SOCAUDUNG=0;
    private static int dem = 0;
    private int soTT = ++dem;
    private String noiDung;
    private List<Selection> dsDapAn;
    private String dapAnDung;
    private String danhMuc;
    private String mucDo;
    private String giaiThich;
    private boolean check;



    public void Answer(){
        System.out.printf("Câu hỏi thứ %d: %s\n",this.soTT,this.noiDung);
        for(Selection a :this.dsDapAn){
            a.hienThiLuaChon();
        }
        System.out.println();
        System.out.println("Mời bạn chọn đáp án : ");
        String dapAnChon =sc.nextLine();
        if(dapAnChon.equalsIgnoreCase(dapAnDung)){
                SOCAUDUNG++;
                this.check = true;
        }else
            this.check = false;
    }
    public void Ketquasimilar(){
        if(!this.check){
            System.out.printf("\n%d,%s Bạn chon sai |==>Đáp án đúng là %s",this.soTT,this.noiDung,this.dapAnDung);
        }else
            System.out.printf("\n%d,%s|=> Bạn đã trả lời đúng \n",this.soTT,this.noiDung);
    }
    public void KetQua(){
        if(!this.check){
            System.out.printf("\n%d,%sBạn chọn sai|=>Đáp án đúng là %s\n%s\n",this.soTT,this.noiDung,this.dapAnDung,this.giaiThich);
        }
        else
            System.out.printf("\n%d,%s|=> Bạn đã trả lời đúng \n",this.soTT,this.noiDung);

    }
    public void display(){
        System.out.printf("\n%d.%s\n",this.soTT,this.noiDung);
        for(Selection a :this.dsDapAn){
            a.hienThiLuaChon();
        }
        System.out.println();
//        System.out.println(this.dapAnDung);
        System.out.printf("Danh mục: %s\n",this.danhMuc);
        System.out.printf("Cấp độ: %s\n",this.mucDo);
        System.out.printf("%s\n" ,this.giaiThich);
    }
    public void displayIncompleteOrConversation(){
        System.out.printf("\n%d.%s\n",this.soTT,this.noiDung);
        System.out.println();
        for(Selection a : this.dsDapAn){
            a.hienThiLuaChon();
        }
        System.out.println();
//        System.out.printf("Danh mục: %s\n",this.danhMuc);

//    System.out.printf("Cấp độ: %s\n",this.mucDo);
    }
    public Mutiplechoice(String noiDung, List<Selection> dsPhuongAn, String dapAnDung, String danhMuc, String mucDo,String giaiThich) {
        super(noiDung);
        this.noiDung = noiDung;
        this.setDsDapAn(dsPhuongAn);
        this.dapAnDung = dapAnDung;
        this.danhMuc = danhMuc;
        this.mucDo = mucDo;
        this.giaiThich=giaiThich;
    }


    public Mutiplechoice(String noiDung, List<Selection> dsPhuongAn, String dapAnDung) {
        super(noiDung);
        this.noiDung =noiDung;
        this.setDsDapAn(dsPhuongAn);
        this.dapAnDung = dapAnDung;
    }
    public int getSoTT() {
        return soTT;
    }
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setSoTT(int soTT) {
        this.soTT = soTT;
    }
    public String getGiaiThich() {
        return giaiThich;
    }

    public void setGiaiThich(String giaiThich) {
        this.giaiThich = giaiThich;
    }
    public static void setDem(){
        dem = 0;
    }
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }



    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }
    public static void setSOCAUDUNG(){SOCAUDUNG = 0;}
    public static int getSOCAUDUNG(){return  SOCAUDUNG;}

    public List<Selection> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(List<Selection> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }
}
