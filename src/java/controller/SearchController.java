/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemDAO;
import dao.ProductDAO;
import entity.Customer;
import entity.Product;
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
public class SearchController extends HttpServlet {

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
            out.println("<title>Servlet SearchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchController at " + request.getContextPath() + "</h1>");
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
        String typeSearch = request.getParameter("typeSearch");
        switch (typeSearch) {
            case "Name":
                searchName(request, response);
                break;
            case "Type":
                searchType(request, response);
                break;
            case "All":
                AllProduct(request, response);
                break;
            case "Favorite": {
                try {
                    FavoriteProduct(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            default:
                throw new AssertionError();
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
        String search = request.getParameter("search");
        try {
            List<Product> listsearch = new ProductDAO().searchProduct(search);
            request.setAttribute("listSearch", listsearch);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("search");
        String pagenumber = request.getParameter("pageSearch");
        String typeSearch = request.getParameter("typeSearch");
        ItemDAO idao = new ItemDAO();
        ProductDAO pdao = new ProductDAO();
        List<Product> products = null;
        try {
            products = pdao.getListByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int page = 1, pageSize = 6;
        int totalPage = products.size(); // get number of content in DB
        if (request.getParameter("pageSearch") != null) { // check param page
            page = Integer.parseInt(request.getParameter("pageSearch")); // get param page
        }

        if (totalPage % pageSize == 0) { // calculator total page to show information
            totalPage = totalPage / pageSize;
        } else {
            totalPage = totalPage / pageSize + 1;
        }

        if (page > totalPage) {
            request.setAttribute("noContent", "No Product here!");
        } else {
            try {
                request.setAttribute("listSearch", pdao.getProductSearchFromList(page, pageSize, name));
            } catch (Exception ex) {
                request.setAttribute("exception", ex);
            }
        }
        request.setAttribute("totalitem", products.size());
        request.setAttribute("Type", typeSearch);
        request.setAttribute("searchvalue", name);
        request.setAttribute("pageSearch", page);
        request.setAttribute("totalPageSearch", totalPage);
        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void searchType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String typeSearch = request.getParameter("typeSearch");
        String name = request.getParameter("search");
        String pagenumber = request.getParameter("pageSearch");

        ItemDAO idao = new ItemDAO();
        ProductDAO pdao = new ProductDAO();
        List<Product> products = null;
        try {
            products = pdao.getListByType(name);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int page = 1, pageSize = 6;
        int totalPage = products.size(); // get number of content in DB
        if (request.getParameter("pageSearch") != null) { // check param page
            page = Integer.parseInt(pagenumber); // get param page
        }

        if (totalPage % pageSize == 0) { // calculator total page to show information
            totalPage = totalPage / pageSize;
        } else {
            totalPage = totalPage / pageSize + 1;
        }

        if (page > totalPage) {
            request.setAttribute("noContent", "No Product here!");
        } else {
            try {
                request.setAttribute("listSearch", pdao.getListSearchByType(page, pageSize, name));
            } catch (Exception ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("totalitem", products.size());
        request.setAttribute("Type", typeSearch);
        request.setAttribute("searchvalue", name);
        request.setAttribute("pageSearch", page);
        request.setAttribute("totalPageSearch", totalPage);
        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    public void AllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String typeSearch = request.getParameter("typeSearch");
        String pagenumber = request.getParameter("pageSearch");
        try {

            ItemDAO idao = new ItemDAO();
            ProductDAO pdao = new ProductDAO();
            List<Product> products = pdao.getAll();
            int page = 1, pageSize = 6;
            int totalPage = products.size(); // get number of content in DB
            if (request.getParameter("pageSearch") != null) { // check param page
                page = Integer.parseInt(request.getParameter("pageSearch")); // get param page
            }

            if (totalPage % pageSize == 0) { // calculator total page to show information
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }

            if (page > totalPage) {
                request.setAttribute("noContent", "No Product here!");
            } else {
                request.setAttribute("listSearch", pdao.getProductFromTo(page, pageSize));
            }
            request.setAttribute("totalitem", products.size());
            request.setAttribute("Type", typeSearch);
            request.setAttribute("searchvalue", "All");
            request.setAttribute("pageSearch", page);
            request.setAttribute("totalPageSearch", totalPage);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("Error.jsp");
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FavoriteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String typeSearch = request.getParameter("typeSearch");
        String pagenumber = request.getParameter("pageFavorite");
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        ProductDAO pdao = new ProductDAO();
        if (id != null) {
            int idFavorite = Integer.parseInt(id);
            Product p = pdao.getProductByID(idFavorite);
            List<Product> list = null;
            Object o = session.getAttribute("listFavorite");
            if (o != null) {
                list = (List<Product>) o;
                int isExisted = pdao.searchFavorite(list, idFavorite);
                if (isExisted == -1) {
                    list.add(p);
                } else {
                    list.remove(isExisted);
                }
                session.setAttribute("listFavorite", list);

            } else {
                list = new ArrayList<>();
                list.add(pdao.getProductByID(idFavorite));
                session.setAttribute("listFavorite", list);
            }

        }
        try {

            Object o = session.getAttribute("listFavorite");
            List<Product> products = null;
            if (o != null) {
                products = (List<Product>) o;
            } else {
                products = new ArrayList<>();
            }
            int page = 1, pageSize = 6;
            int totalPage = products.size(); // get number of content in DB
            if (request.getParameter("pageFavorite") != null) { // check param page
                page = Integer.parseInt(request.getParameter("pageFavorite")); // get param page
            }

            if (totalPage % pageSize == 0) { // calculator total page to show information
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }

            if (page > totalPage) {
                request.setAttribute("noContent", "No Product here!");
            } else {
                if (products != null) {
                    request.setAttribute("listFavoriteFromTo", pdao.getListFavoriteFromTo(page, pageSize, products));
                } else {
                    products.add(pdao.getProductByID(Integer.parseInt(id)));
                    request.setAttribute("listFavoriteFromTo", pdao.getListFavoriteFromTo(page, pageSize, products));
                }

            }
            request.setAttribute("totalitem", products.size());
            request.setAttribute("pageFavorite", page);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("totalPageFavorite", totalPage);
            request.getRequestDispatcher("FavoriteProduct.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("exception", ex);
            response.sendRedirect("Error.jsp");
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
