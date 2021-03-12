package com.amaker.servlet;

import com.amaker.bean.Addp;
import com.amaker.dao.AddDao;
import com.amaker.dao.impl.AddpDaoImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class AddpServlet extends HttpServlet {
    private static final long serialversionUID = 1L;

    public AddpServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            save(request, response);
        } else if (action != null && action.equals("list")) {
            list(request, response);
        } else if (action != null && action.equals("get")) {
            get(request, response);
        } else if (action != null && action.equals("update")) {
            update(request, response);
        } else if (action != null && action.equals("delete")) {
            delete(request, response);
        } else if (action != null && action.equals("get1")) {
            get1(request, response);  }else {

        }

    }

    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int id = new Integer(request.getParameter("id"));
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String sex = request.getParameter("sex");
        String QQ = request.getParameter("QQ");
        String sort = request.getParameter("sort");

        //String Wechat = request.getParameter("Wechat");
        AddDao dao = new AddpDaoImpl();
        Addp a = new Addp();
        a.setName(name);
        a.setPhoneNum(phoneNumber);
        a.setSex(sex);
        a.setQQ(phoneNumber);
        a.setSort(sort);
        //a.setWechat(Wechat);
        dao.save(a);
        list(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String sex = request.getParameter("sex");
        String QQ = request.getParameter("QQ");
        String sort = request.getParameter("sort");
        //String Wechat = request.getParameter("Wechat");
        AddDao dao = new AddpDaoImpl();
        Addp a = new Addp();
        a.setName(name);
        a.setPhoneNum(phoneNumber);
        a.setSex(sex);
        a.setQQ(QQ);
        a.setSort(sort);
        System.out.println("===================");
        System.out.println(id);
        a.setId(new Integer(id));

        dao.update(a);
        list(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddDao dao = new AddpDaoImpl();
        String[] ids = request.getParameterValues("ids");
        dao.delete(ids);
        //System.out.println(ids);
        list(request, response);

    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        AddDao dao = new AddpDaoImpl();
        Addp a = dao.get(new Integer(id).intValue());
        //a.setId(new Integer(id));
        System.out.println("--------------------");
        System.out.println(id);
        System.out.println(a.getId());
        request.setAttribute("Addp", a);
        request.getRequestDispatcher("/AddpEdit.jsp").forward(request, response);
    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddDao dao = new AddpDaoImpl();
        List list = dao.list();
        request.setAttribute("AD", list);
        request.getRequestDispatcher("/Addp1.jsp").forward(request, response);
    }
    protected void get1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       // String id = request.getParameter("id");
        AddDao dao = new AddpDaoImpl();
        //Addp a = dao.get(new Integer(id).intValue());
        List list = dao.seek();
        request.setAttribute("AD", list);
        request.getRequestDispatcher("/Sort.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    }
}
