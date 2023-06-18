import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class QuestionList {
    private static final SimpleDateFormat format = new SimpleDateFormat("MM");
    private static Scanner sc = new Scanner(System.in);
    private List<Mutiplechoice> dsMC = new ArrayList<>();
//    private List<SimilarQuestion> dsIncompleteOrConversation = new ArrayList<>();
//    private List<Incomplete> dsInc = new ArrayList<>();
//    private List<Conversation> dsCon=new ArrayList<>();
//    private List<SimilarQuestion> dsConversation = new ArrayList<>();
    private QuanLyNguoiHoc dsa = new QuanLyNguoiHoc();
//    private List<NguoiHoc> ds = new ArrayList<>();
    private List<Question> ds = new ArrayList<>();
public void luyentapMutipleChoice(int n) throws IOException {
    dsa.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
//        docfileMC("src/main/resources/mutiplechoice.txt");
    for(NguoiHoc a :dsa.getDs()) {
        if (n == a.getMaHv()) {
            System.out.print("Nhập số câu : ");
            int m = sc.nextInt();
            RandomMutiplechoie(m, n,a.getDsMu());
            System.out.println();
            if (Mutiplechoice.getSOCAUDUNG() == 0) {
//                    System.out.println("Bạn Đã làm hết câu hỏi");
            } else {
                System.out.printf("%s === Số câu đúng %d\n", a.getHoTen(), Mutiplechoice.getSOCAUDUNG());
                File f = new File("src/main/resources/thongkeketquahoctap.txt");
                FileWriter w = new FileWriter(f, true);
                try (PrintWriter w2 = new PrintWriter(w)) {
                    w2.printf("%s\n%d\n%s\n%.1f\n", format.format(new Date()), a.getMaHv(), a.getHoTen(), (double) (Mutiplechoice.getSOCAUDUNG()) * 10 / m);
                    }
                }
            }
        }

    sc.nextLine();
    }
    public void luyentapIncomplete(int n) throws IOException {
        dsa.docDsNguoiHoc("src/main/resources/nguoihoc.txt");

        docfileIncomplete("src/main/resources/incomplete.txt");
        for(NguoiHoc a :dsa.getDs()){
            if(n==a.getMaHv()){
                System.out.println("Nhập số mức độ : ");
                String incomplete = sc.nextLine();
                RandomIncomplete(incomplete);
                System.out.println();
                System.out.printf("%s === Số câu đúng %d\n",a.getHoTen(),Mutiplechoice.getSOCAUDUNG());
                File f = new File("src/main/resources/thongkeketquahoctap.txt");
                FileWriter w = new FileWriter(f,true);
                try(PrintWriter w2 = new PrintWriter(w)){
                    w2.printf("%s\n%d\n%s\n%d\n",format.format(new Date()),a.getMaHv(),a.getHoTen(),(Mutiplechoice.getSOCAUDUNG()));
                }
            }
        }
    }
    public void luyentapConversation(int n) throws IOException {
        dsa.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
        docfileConversation("src/main/resources/conversation.txt");
        for(NguoiHoc a :dsa.getDs()){
            if(n==a.getMaHv()){
                System.out.println("Nhập số mức độ : ");
                String conversation = sc.nextLine();
                RandomConversation(conversation);
                System.out.println();
                System.out.printf("%s === Số câu đúng %d\n",a.getHoTen(),Mutiplechoice.getSOCAUDUNG());
                File f = new File("src/main/resources/thongkeketquahoctap.txt");
                FileWriter w = new FileWriter(f,true);
                try(PrintWriter w2 = new PrintWriter(w)){
                    w2.printf("%s\n%d\n%s\n%d\n",format.format(new Date()),a.getMaHv(),a.getHoTen(),(Mutiplechoice.getSOCAUDUNG()*2));
                }
            }
        }


    }




    public void RandomMutiplechoie(int n,int mahv,List<Integer> Kiemtra) throws IOException {
        Mutiplechoice.setDem();
        docfileMC("src/main/resources/mutiplechoice.txt");
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> dsCauHoiVuaLam = new ArrayList<>();
        ArrayList<Integer> dsCauHoiDaLam = new ArrayList<>();


        // Doc File tu mutiplechoice de kiem tra cau hoi da lam het chua
        File f = new File("src/main/resources/mutiplechoiceDalam.txt");
        for(int i = 0 ;i< Kiemtra.size();i++){
            if(Kiemtra.get(i)==0){
                Kiemtra.remove(i);
            }
        }

        if (Kiemtra.size() > Mutiplechoice.SO_CAU-n ) {
            System.out.println("Bạn đã làm gần hết câu hỏi => reset để làm lại");
            resetMutipleChoice(mahv);
        }
//        doc file de luu vao ds cau hoi da lam roi
        else {
            for(Integer a : Kiemtra){
                dsCauHoiDaLam.add(a);
            }
//        Random cau hoi Mutiplechoice
            for (int i = 0; i < dsCauHoiDaLam.size(); i++) {
                xoaCauHoiTheoSoTT(dsCauHoiDaLam.get(i));
            }
            for (int i = 0; i < this.ds.size(); i++) {
                list.add(i);
            }
            Collections.shuffle(list);
            for (int i = 0; i < n; i++) {
                Question randomElemen = ds.get(list.get(i));
                randomElemen.Answer();
            }
            for (int i = 0; i < n; i++) {
                Question randomElemen = ds.get(list.get(i));
                randomElemen.KetQua();
                dsCauHoiVuaLam.add(randomElemen.getSoTT());
            }
            Mutiplechoice.setDem();
            int tam = dsCauHoiVuaLam.size();
            int tam2 = 0;
//            System.out.println(tam);
            while(tam<=14){
                dsCauHoiVuaLam.add(tam2);
                tam++;
            }
//Ghi vao file Mutiplechoice da lam
            FileWriter w = new FileWriter(f, true);
            try (PrintWriter w2 = new PrintWriter(w)) {
                w2.println(mahv);
                for (int i = 0; i < 14; i++) {
                    w2.print(dsCauHoiVuaLam.get(i)+" ");
                }
                w2.println();
            }

        }
    }
// Random cau hoi Incomplete
    public void RandomIncomplete(String tukhoa){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i< this.ds.size();i++){
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0 ; i < this.ds.size();i++)
        {
            Question randomElemen = ds.get(list.get(i));
            if(randomElemen.getMucDo().equalsIgnoreCase(tukhoa)){
                randomElemen.Answer();
                randomElemen.KetQua();
                return;
            }
        }
        Mutiplechoice.setDem();
    }
    // Random cau hoi Conversation
    public void RandomConversation(String tukhoa){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i< this.ds.size();i++){
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0 ; i < this.ds.size();i++)
        {
            Question randomElemen = ds.get(list.get(i));
            if(randomElemen.getMucDo().equalsIgnoreCase(tukhoa)){
                randomElemen.Answer();
                randomElemen.KetQua();
                return;
            }
        }
        Mutiplechoice.setDem();
    }
    // doc cau hoi tu file
    public void docfileMC(String path) throws FileNotFoundException {
        ds.clear();
        Mutiplechoice.setDem();
        File f = new File(path);
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()) {
                List<Selection> dsPhuongAn = new ArrayList<>();
                String noiDung = sc.nextLine();
                while(sc.hasNext()){
                    String PhuongAn = sc.nextLine();
                    if(Objects.equals(PhuongAn, "Phương Án")){
                        break;
                    }
                    Selection tam = new Selection(PhuongAn);
                    dsPhuongAn.add(tam);
                }
                String dapAnDung = sc.nextLine();
                String danhMuc =sc.nextLine();
                String mucDo = sc.nextLine();
                String giaiThich = sc.nextLine();

                Question test  = new Mutiplechoice(noiDung,dsPhuongAn,dapAnDung,danhMuc,mucDo,giaiThich);
                ds.add(test);
            }
        }
    }
    public void docfileIncomplete(String path) throws FileNotFoundException {

        ds.clear();
        File f = new File(path);

        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                List<Mutiplechoice> dsM = new ArrayList<>();
                String doanvan= sc.nextLine();
                for(int i = 0 ;i < 10 ;i++){
                    List<Selection> dsPhuongAn = new ArrayList<>();
                    String noiDung = "Điền vào chỗ trống: _____";
                    for(int j = 0 ; j<4 ;j++){
                        String PhuongAn = sc.nextLine();
                        Selection tam = new Selection(PhuongAn);
                        dsPhuongAn.add(tam);
                    }
                    String dapAnDung = sc.nextLine();
                    Mutiplechoice test = new Mutiplechoice(noiDung,dsPhuongAn,dapAnDung);
                    dsM.add(test);
                }
                Mutiplechoice.setDem();
                String mucDo = sc.nextLine();
                Question test2 =new Incomplete(doanvan,dsM,mucDo);
                ds.add(test2);

            }

        }
    }
    public void docfileConversation(String path) throws FileNotFoundException {
        ds.clear();
        File f = new File(path);

        try(Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                List<Mutiplechoice> dsM = new ArrayList<>();
                String doanvan= sc.nextLine();
                for(int i = 0 ;i < 5 ;i++){
                    List <Selection> dsPhuongAn = new ArrayList<>();
                    String noiDung = sc.nextLine();
                    for(int j = 0 ; j < 4;j++){
                        String PhuongAn = sc.nextLine();
                        Selection tam = new Selection(PhuongAn);
                        dsPhuongAn.add(tam);
                    }
                    String dapAnDung = sc.nextLine();
                    Mutiplechoice test = new Mutiplechoice(noiDung,dsPhuongAn,dapAnDung);
                    dsM.add(test);
                }
                Mutiplechoice.setDem();
                String mucDo = sc.nextLine();
                Question test2 =new Conversation(doanvan,dsM,mucDo);
                ds.add(test2);

            }

        }
    }
    public void xoaCauHoiTheoSoTT(int stt){
        this.ds.removeIf(a -> a.getSoTT() == stt);
    }
    // Xoa hoc vien va cac cau da la trong file mutiplechoiceDalam
    public void resetMutipleChoice(int mahv) throws IOException {
        File f = new File("src/main/resources/mutiplechoiceDalam.txt");

        List <MutiplechoiceDalam> ds = new ArrayList<>();
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                int i = 0;
                ArrayList<Integer> dsCauHoi = new ArrayList<>();
                int mahocvien = sc.nextInt();
                while(sc.hasNextInt()) {
                    if(i==14){
                        break;
                    }
                    int cauhoi = sc.nextInt();
                    dsCauHoi.add(cauhoi);
                    i++;
                }
                if(mahocvien!=mahv){
                    MutiplechoiceDalam a = new MutiplechoiceDalam(mahocvien,dsCauHoi);
                    ds.add(a);
                }
            }
        }

        FileWriter  w = new FileWriter(f);
        try(PrintWriter w2 = new PrintWriter(w)){
            for(MutiplechoiceDalam a : ds){
                w2.println(a.getMahv());
                List <Integer> dstam = a.getDs();
                for(int i = 0 ; i<dstam.size();i++) {
                    w2.print(dstam.get(i) + " ");
                }
                w2.println();
//                System.out.println(a.getMahv());
                for(int i = 0 ; i<dstam.size();i++) {
//                    System.out.print(dstam.get(i) + " ");
                }
//                System.out.println();
            }
        }
    }
    public List<Question> timKiemTheoNoiDungDanhMucMucDo(String tuKhoa) {
        return this.ds.stream().filter(h -> h.getNoiDung().contains(tuKhoa) == true || h.getDanhMuc().contains(tuKhoa) == true || h.getMucDo().contains(tuKhoa) == true).collect(Collectors.toList());
    }
    public List<Question> timKiemIncomplete(String tuKhoa){
        return this.ds.stream().filter(h ->h.getMucDo().contains(tuKhoa)==true).collect(Collectors.toList());
    }
    public List<Question> timKiemConversation(String tuKhoa){
        return this.ds.stream().filter(h ->h.getMucDo().contains(tuKhoa)==true).collect(Collectors.toList());
    }
    // in cau hoi
    public void displayQuestion(){
        for(Question a : ds)
            a.display();
    }

//    public List<Incomplete> getDsInc() {
//        return dsInc;
//    }
//
//    public void setDsInc(List<Incomplete> dsInc) {
//        this.dsInc = dsInc;
//    }
//
//    public List<Conversation> getDsCon() {
//        return dsCon;
//    }
//
//    public void setDsCon(List<Conversation> dsCon) {
//        this.dsCon = dsCon;
//    }

    public List<Question> getDs() {
        return ds;
    }

    public void setDs(List<Question> ds) {
        this.ds = ds;
    }
}
