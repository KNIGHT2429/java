/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;

//this file only use for inheritence
public class Person {
    protected String name;
    protected String icNo;
    protected String hpNo;
    
    public Person(String name, String icNo, String hpNo) {
        this.name = name;
        this.icNo = icNo;
        this.hpNo = hpNo;
    }

    public String getName() {
        return name;
    }

    public String getIcNo() {
        return icNo;
    }

    public String getHpNo() {
        return hpNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public void setHpNo(String hpNo) {
        this.hpNo = hpNo;
    }
}