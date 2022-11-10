/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class UserInfoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserInfoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserInfoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("UserInfo")) {
            request.getRequestDispatcher("CustomerInfomation.jsp").forward(request, response);
        } else if (action.equals("LogOut")) {
            request.getRequestDispatcher("LogOutServlet").forward(request, response);
        } else if (action.equals("ChangePass")) {
            changePass(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        Customer customer = null;
        Object o = session.getAttribute("account");
        if (o != null) {
            customer = (Customer) o;
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
        customer.setCustomerPhone(phone);
        CustomerDAO dao = new CustomerDAO();
        try {
            boolean updated = dao.updateUser(customer);
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("account", customer);
        request.getRequestDispatcher("CustomerInfomation.jsp").forward(request, response);
    }

    public void changePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer a = (Customer) session.getAttribute("account");
        if (a != null) {
            String currentPass = request.getParameter("current");
            String newPass = request.getParameter("new");
            String confirmPass = request.getParameter("confirm");
            if (!(currentPass.equals("") || newPass.equals("") || confirmPass.equals(""))) {
                if (a.getPassword().equals(currentPass)) {
                    if (newPass.equals(confirmPass)) {
                        try {
                            boolean b = new CustomerDAO().updatePass(a.getCustomerID(), newPass);
                            if (b) {
                                a.setPassword(newPass);
                                session.setAttribute("account", a);
                                request.setAttribute("errMessage", "Password is updated");
                                request.getRequestDispatcher("changePass.jsp").forward(request, response);
                            } else {
                                request.setAttribute("errMessage", "Password update failed");
                                request.getRequestDispatcher("changePass.jsp").forward(request, response);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        request.setAttribute("errMessage", "Password and confirm password don't match");
                        request.getRequestDispatcher("changePass.jsp").forward(request, response);

                    }
                } else {
                    request.setAttribute("errMessage", "Current Password is not correct");
                    request.getRequestDispatcher("changePass.jsp").forward(request, response);

                }
            } else {
                request.setAttribute("errMessage", "Please fill all required fields");
                request.getRequestDispatcher("changePass.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
