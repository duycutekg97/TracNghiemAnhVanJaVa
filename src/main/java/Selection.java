public class Selection {
    private String luaChon;
    private String explain;
    public Selection(String luaChon, String explain){
        this.luaChon = luaChon;
        this.explain = explain;
    }


    public Selection(String luaChon) {
        this.luaChon = luaChon;
    }
    public void hienThiLuaChon(){
        System.out.print(this.luaChon+"\t"+"      ");
    }
    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
