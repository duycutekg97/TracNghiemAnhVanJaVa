import java.util.ArrayList;
import java.util.List;

public class MutiplechoiceDalam {


    private List <Integer> ds = new ArrayList<>();
    private int mahv;
    public MutiplechoiceDalam(int mahv, List<Integer> ds){
        this.mahv = mahv;
        this.ds = ds;
    }
    public void display(){
        System.out.println(this.mahv);
        for(int i = 0 ; i < ds.size();i++){
            System.out.print(this.ds.get(i)+" ");
        }
        System.out.println();
    }



    public List<Integer> getDs() {
        return ds;
    }

    public void setDs(List<Integer> ds) {
        this.ds = ds;
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }
}
