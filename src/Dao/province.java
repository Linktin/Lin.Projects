package Dao;

public class province {
    private int id;
    private String pcode;
    private String code;
    private String name;

    public province(){}

    public province(int id,String pcode,String code,String name){
        this.id=id;
        this.pcode=pcode;
        this.code=code;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
