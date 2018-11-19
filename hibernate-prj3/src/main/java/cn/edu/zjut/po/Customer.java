package cn.edu.zjut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    private int customerId;
    private String account;
    private String password;
    private String repassword;
    private String name;
    private Integer sex;
    private String sexStr;
    private Date birthday;
    private String email;
    private Set addresses = new HashSet(0);

    public Customer() {}

    public Customer(int customerId, String account, String password, String repassword, String name, Integer sex, String sexStr, Date birthday, String email, Set addresses) {
        this.customerId = customerId;
        this.account = account;
        this.password = password;
        this.repassword = repassword;
        this.name = name;
        this.sex = sex;
        this.sexStr = sexStr;
        this.birthday = birthday;
        this.email = email;
        this.addresses = addresses;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set getAddresses() {
        return addresses;
    }

    public void setAddresses(Set addresses) {
        this.addresses = addresses;
    }
}
