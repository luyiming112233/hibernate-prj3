package cn.edu.zjut.action;

import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.service.UserService;

public class UserAction {
    private Customer loginUser;
    private Address address;

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String login(){
        UserService userService = new UserService();
        if(userService.login(loginUser))
            return "loginsuccess";
        else
            return "loginfail";
    }

    public String addAddr(){
        UserService userService = new UserService();
        if(userService.addAddr(loginUser,address))
            return "success";
        else
            return "fail";
    }

    public String delAddr(){
        UserService userService = new UserService();
        if(loginUser==null){
            System.out.println("loginUser is null");
        }
        if(address==null){
            System.out.println("address is null");
        }
        if(userService.deleteAddress(loginUser,address))
            return "delAddrSuccess";
        else
            return "delAddrFail";
    }
}
