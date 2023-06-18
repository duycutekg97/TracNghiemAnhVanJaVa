import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class test {
    public static void main(String args[]) throws IOException, ParseException {
        SimpleDateFormat f = new SimpleDateFormat("dd/MMMM/yyyy");
        Scanner sc = new Scanner(System.in);
//        QuestionList a = new QuestionList();
//        System.out.println("===========Danh Sach Cau Hoi MutipleChoice==============");
//        a.docfileMC("src/main/resources/mutiplechoice.txt");
//        a.display();
//        System.out.println("Nhap so luong cau hoi : ");
//        int n = sc.nextInt();
//        a.RandomMutiplechoie(n);

//        QuestionList b = new QuestionList();
//        System.out.println("===========Danh Sach Cau Hoi Incomplete==============");
//        b.docfileIncomplete("src/main/resources/incomplete.txt");
////        b.displayincomplete();
//        System.out.println("Nhap vao tu khoa : ");
//        String tukhoa = sc.nextLine();
//        b.RandomIncompleteOrConversation(tukhoa);
//        b.docfileConversation("src/main/resources/conversation.txt");
//        b.displayincomplete();
//        QuanLyNguoiHoc ds = new QuanLyNguoiHoc();
////        ds.themNguoiHoc();
////        ds.themNguoiHoc();
////        ds.themNguoiHoc();
//        ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
//        ds.display();
////        ds.xoaNguoiHoc(0);
////        ds.capNhatNguoiHocKhiXoa("src/main/resources/nguoihoc.txt");
////        ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
//        ds.capNhatThongTin(1);
//        ds.display();
//        ds.capNhatNguoiHocKhiXoa("src/main/resources/nguoihoc.txt");
//        ds.display();
//        ds.capnhatNguoiHoc("src/main/resources/nguoihoc.txt");
//        int Stt;
//        QuestionList dsCauHoi = new QuestionList();
//        QuanLyNguoiHoc ds = new QuanLyNguoiHoc();
////        NguoiHoc.setDem();
////        Mutiplechoice.SOCAUDUNG=0;
////        ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
//        Mutiplechoice.SOCAUDUNG=0;
////       dsCauHoi.luyentapConversation(1);
//        ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
////        ds.display();
//       ds.ThongKeHocTap(04,1);
        int choose,choose2;
    do{
        int mahv;
        QuestionList thi = new QuestionList();
        QuanLyNguoiHoc ds = new QuanLyNguoiHoc();
        System.out.println("=============================MENU=============================");
        System.out.println("1.Hiển Thị danh sách câu hỏi Mutiplechoice\n2.Hiển thi danh sách câu Incomplete\n3." +
                "Hiển thị danh sách câu hỏi Conversation\n4.Tìm kiếm câu hỏi theo từ khóa Nội dung-Độ khó-Danh mục\n" +
                "========================MENU người học========================\n" +
                        "5.Hiển Thị danh sách Người Học\n6.Thêm 1 người học\n7.Xóa 1 người học\n8.Cập nhật thông tin 1 người học\n" +
                        "========================MENU Luyện tập========================\n" +
                        "9.Luyện tập làm bài anh Văn\n"+

                "10.Thống kê kết quả theo tháng của một học viên\n==============================================================\n" +"0.Thoát\n" +
                "Bạn Chọn : ");
        choose = sc.nextInt();
//        sc.nextLine();
        switch(choose){
            case 1 :
                thi.docfileMC("src/main/resources/mutiplechoice.txt");
                System.out.println("===========Danh Sách Câu Hỏi Mutiplechoice===========");
                thi.displayQuestion();
                break;
            case 2 :
                thi.docfileIncomplete("src/main/resources/incomplete.txt");
                System.out.println("===========Danh Sách Câu Hỏi Incomplete==========");
                thi.displayQuestion();
                break;
            case 3 :
                thi.docfileConversation("src/main/resources/conversation.txt");
                System.out.println("===============Danh Sách Câu Hỏi Conversation===========");
                thi.displayQuestion();
                break;
            case 4 :
                System.out.print("Chọn câu hỏi bạn muốn tìm\n1.MutipleChoice\n2.InComple\n3.Conservation\n=>Bạn chọn: ");
                choose2 = sc.nextInt();
                sc.nextLine();
                if(choose2 ==1) {
                    Mutiplechoice.setDem();
                    thi.docfileMC("src/main/resources/mutiplechoice.txt");
                    System.out.println("Nhập từ khóa muốn tìm kiếm trong danh sách câu hỏi Mutiple choice: ");
                    String tuKhoa = sc.nextLine();
                    thi.timKiemTheoNoiDungDanhMucMucDo(tuKhoa).forEach(h->h.display());
                }else if(choose2 ==2) {
                    Mutiplechoice.setDem();
                    thi.docfileIncomplete("src/main/resources/incomplete.txt");
                    System.out.println("Nhập Mức độ muốn tìm kiếm trong danh sách câu hỏi Incomplete: ");
                    String tuKhoa = sc.nextLine();
                    thi.timKiemIncomplete(tuKhoa).forEach(h->h.display());

                }else if(choose2 ==3) {
                    Mutiplechoice.setDem();
                    thi.docfileConversation("src/main/resources/conversation.txt");
                    System.out.println("Nhập Mức độ muốn tìm kiếm trong danh sách câu hỏi Conversation: ");
                    String tuKhoa = sc.nextLine();
                    thi.timKiemConversation(tuKhoa).forEach(h->h.display());
                }

                break;
            case 5 :
                NguoiHoc.setDem();
                ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
                System.out.println("====================Danh Sách Học Viên========================");
                ds.display();
                break;
            case 6 :
                NguoiHoc.setDem();
                ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
                System.out.println("======Thêm một học viên====");
                ds.themNguoiHoc();
                ds.capnhatNguoiHoc("src/main/resources/nguoihoc.txt");
                break;
            case 7:
                NguoiHoc.setDem();
                System.out.println("========Xóa một học viên========");
                ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
                ds.display();
                System.out.println("Nhập số học viên muốn xóa : ");
                mahv =sc.nextInt();
                ds.xoaNguoiHoc(mahv-1);
                ds.capNhatNguoiHocKhiXoa("src/main/resources/nguoihoc.txt");
                ds.capNhatThongKe(mahv);
                thi.resetMutipleChoice(mahv);
                NguoiHoc.setDem();
                ds.display();
                break;
            case 8:
                NguoiHoc.setDem();
                System.out.println("===Cập nhật một học viên====");
                ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
                ds.display();
                System.out.print("Nhập mã học viên muốn cập nhật thông tin: ");
                mahv= sc.nextInt();
                ds.capNhatThongTin(mahv);
                ds.capNhatNguoiHocKhiXoa("src/main/resources/nguoihoc.txt");
                NguoiHoc.setDem();
                ds.display();
                break;
            case 9:
                System.out.print("Bạn đăng ký chưa\n1.Chưa\n2.Đã đăng ký\n=>Bạn chọn: ");
                choose2 = sc.nextInt();
                if (choose2 == 1){
                    System.out.println("Chọn mục 6 để đăng ký");
                    break;
                }
                else if(choose2 == 2) {
                    System.out.print("Chọn mục muốn luyện tập\n1.MutipleChoice\n2.InComple\n3.Conservation\n=>Bạn chọn: ");
                }
                choose2 = sc.nextInt();
//                sc.nextLine();
                if(choose2==1){
                    NguoiHoc.setDem();
                    Mutiplechoice.setSOCAUDUNG();
                    Mutiplechoice.setDem();
                    System.out.println("Nhập vào mã hv để luyện : ");
                    mahv = sc.nextInt();
                    thi.luyentapMutipleChoice(mahv);
                }else if(choose2==2){
                    NguoiHoc.setDem();
                    Mutiplechoice.setDem();
                    Mutiplechoice.setSOCAUDUNG();
                    System.out.println("Nhập vào mã hv để luyện : ");
                    mahv = sc.nextInt();
//                    sc.nextLine();
                    thi.luyentapIncomplete(mahv);
                }else if(choose2==3){
                    NguoiHoc.setDem();
                    Mutiplechoice.setSOCAUDUNG();
                    Mutiplechoice.setDem();
                    System.out.println("Nhập vào mã hv để luyện : ");
                    mahv =sc.nextInt();
//                    sc.nextLine();
                    thi.luyentapConversation(mahv);
                }
                break;
            case 10:
                NguoiHoc.setDem();
                ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
                ds.display();
                System.out.println("Nhập vào tháng bạn muốn xem thống kê : ");
                int thang = sc.nextInt();
                System.out.println("Nhập vào mã học viên bạn muốn xem : ");
                mahv = sc.nextInt();
                ds.ThongKeHocTap(thang,mahv);
                break;
            case 0:
                System.out.println("====Tạm biệt ====^_^ Chúc bạn thành công");
                break;
            default:
                System.out.println("Nhập sai nhập lại");
        }
    }while(choose!=0);
//        NguoiHoc.setDem();
//        Mutiplechoice.SOCAUDUNG=0;
//        QuanLyNguoiHoc ds = new QuanLyNguoiHoc();
//        QuestionList thi = new QuestionList();
//        thi.docfileConversation("src/main/resources/conversation.txt");
//        thi.docfileMC("sr/main/resources/mutiplechoice.txt");
//        thi.display();
//        ds.docDsNguoiHoc("src/main/resources/nguoihoc.txt");
//        thi.luyentapMutipleChoice(1);

    }
}
