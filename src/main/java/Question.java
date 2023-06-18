public abstract class Question {
    private static int dem = 0;
    private int iD=++dem;
    private String content;
    public Question(String content){
        this.content= content;
    }
    public abstract void Answer();
    public abstract void KetQua();
    public abstract int getSoTT();
    public abstract String getMucDo();
    public abstract void display();

    public String getDanhMuc() {
        return null;
    }
    public String getNoiDung(){
        return null;
    }
}
