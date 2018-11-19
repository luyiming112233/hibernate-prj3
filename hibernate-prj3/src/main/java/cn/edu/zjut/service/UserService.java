package cn.edu.zjut.service;

import cn.edu.zjut.dao.CustomerDAO;
import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserService {
    private Map<String, Object> request, session;

    public boolean login(Customer loginUser) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        String account = loginUser.getAccount();
        String password = loginUser.getPassword();
        String hql = "from Customer as user where account='" + account + "' and password='" + password + "'";
        CustomerDAO dao = new CustomerDAO();
        List list = dao.findByHql(hql);
        dao.getSession().close();
        if (list.isEmpty()) {
            return false;
        } else {
            session.put("user", account);
            session.put("tip", "登录成功！");
            loginUser = (Customer) list.get(0);
            request.put("loginUser", loginUser);
            return true;
        }

    }

    public boolean addAddr(Customer loginUser, Address address) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        CustomerDAO c_dao = new CustomerDAO();
        loginUser = (Customer) c_dao.findById(loginUser.getCustomerId());
        address.setCustomer(loginUser);
        loginUser.getAddresses().add(address);
        Transaction tran = null;
        try {
            tran = c_dao.getSession().beginTransaction();
            c_dao.update(loginUser);
            tran.commit();
            request.put("loginUser", loginUser);
            request.put("tip", "添加地址成功");
            return true;
        } catch (Exception e) {
            if (tran != null)
                tran.rollback();
            return false;
        } finally {
            c_dao.getSession().close();
        }
    }

    public boolean deleteAddress(Customer loginUser,Address address) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        CustomerDAO c_dao = new CustomerDAO();
        loginUser = (Customer) c_dao.findById(loginUser.getCustomerId());
        //address.setCustomer(loginUser);
        //System.out.println("remove:"+loginUser.getAddresses().remove(address));
        Set set = loginUser.getAddresses();
        System.out.println("set size = "+set.size());
        for(Object addr:set){
            if(address.getAddressId()== ((Address)addr).getAddressId()) {
                set.remove(addr);
                break;
            }
        }
        loginUser.setAddresses(set);
        Transaction tran = null;
        try {
            tran = c_dao.getSession().beginTransaction();
            c_dao.update(loginUser);
            tran.commit();
            request.put("loginUser", loginUser);
            request.put("tip", "删除地址成功");
            return true;
        } catch (Exception e) {
            if (tran != null)
                tran.rollback();
            return false;
        } finally {
            c_dao.getSession().close();
        }
    }
}
