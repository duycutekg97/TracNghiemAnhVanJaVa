import java.util.ArrayList;
import java.util.List;

public class Conversation extends Question{
    private String doanVan;
    private List<Mutiplechoice> dsCauHoi = new ArrayList<>();
    private String mucDo;
    private static int dem = 0;
    private int soTT = ++dem;

    public Conversation(String doanvan, List<Mutiplechoice> dsDapAn,String mucDo) {
        super(doanvan);
        this.doanVan = doanvan;
        this.dsCauHoi = dsDapAn;
        this.mucDo = mucDo;
    }
    public void display(){
        System.out.println("Exam :"+this.doanVan);
        for(Mutiplechoice m :this.dsCauHoi)
            m.displayIncompleteOrConversation();
    }


    public void Answer(){
        System.out.println(this.doanVan);
        for(Mutiplechoice a : this.dsCauHoi)
            a.Answer();
    }
    public void KetQua(){
        System.out.println("==========Danh sách kết quả=======");
        for(Mutiplechoice a:this.dsCauHoi)
            a.Ketquasimilar();
    }


    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public String getDoanVan() {
        return doanVan;
    }

    public void setDoanVan(String doanVan) {
        this.doanVan = doanVan;
    }

    @Override
    public int getSoTT() {
        return soTT;
    }

    public void setSoTT(int soTT) {
        this.soTT = soTT;
    }
}
