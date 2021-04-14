package com.study.ex02;

public class PhonebookDTO {
    private String name;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // 인자가 없는 생성자
    public PhonebookDTO(){
    }

    public PhonebookDTO(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}
