/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InvoiceDAO;
import entity.Customer;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class CheckOutController extends HttpServlet {

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
            out.println("<title>Servlet CheckOutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutController at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession();
        Object o = session.getAttribute("account");
        InvoiceDAO dao = new InvoiceDAO();
        if (o != null) {
            Customer c = (Customer) o;
            try {
                Object ob = session.getAttribute("items");
                List<Item> list = new ArrayList<>();
                if (ob != null) {
                    list = (List<Item>) ob;
                    
                } else {
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
                double total =0;
                for (Item item : list) {
                    total+=item.getTotalPrice();
                }
                boolean b = dao.addInvoice(c.getCustomerID(), total);
                if (b) {
                    for (Item i : list) {

                        boolean added = dao.addInvoiceDetail(dao.MaxMaHD(), i);

                    }
                    session.removeAttribute("items");
                    session.removeAttribute("size");
                    request.setAttribute("idBuy", dao.MaxMaHD());
                    request.setAttribute("total", total);
                    request.setAttribute("mes", "Buy Successful");
                    request.getRequestDispatcher("receipt.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CheckOutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
