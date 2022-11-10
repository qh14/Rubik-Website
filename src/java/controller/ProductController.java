/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import entity.Customer;
import entity.Item;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author admin
 */
@MultipartConfig
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Object ob = session.getAttribute("account");
        Customer cus = new Customer();
        if (ob == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            cus = (Customer) ob;
        }
        if (cus.isRoleAdmin()) {
            switch (type) {
                case "Product":
                    try {
                        productList(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case "ProductUpdate":
                    int id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("id", id);
                    request.getRequestDispatcher("ProductUpdate.jsp").forward(request, response);
                    break;
                case "ProductRemove":
                    int idremove = Integer.parseInt(request.getParameter("id"));
                    boolean b = false;
                    try {

                        Customer c = (Customer) session.getAttribute("account");
                        List<Product> list = (List<Product>) session.getAttribute("listFavorite");
                        if (list != null) {
                            int isExisted = new ProductDAO().searchFavorite(list, idremove);
                            if (isExisted != -1) {
                                list.remove(isExisted);
                            }
                            session.setAttribute("listFavorite", list);
                        }

                        b = new ProductDAO().removeProduct(idremove);

                    } catch (SQLException ex) {
                        Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (b) {
                        request.getRequestDispatcher("ProductController?&type=Product").forward(request, response);
                    } else {

                        request.setAttribute("exception", "Error");
                        request.getRequestDispatcher("Error.jsp").forward(request, response);
                    }

                    break;

                default:
                    throw new AssertionError();
            }
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));

        String info = request.getParameter("info");

        try {
            ProductDAO pdao = new ProductDAO();
            Product p = pdao.getProductByID(id);

            p.setPrice(price);
            p.setProductName(name);
            p.setInfo(info);
            p.setTypeName(type);
            boolean b = pdao.updateProduct(p);
            if (!b) {
                request.setAttribute("exception", "Error");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
            response.sendRedirect("ProductController?type=Product");
            //request.getRequestDispatcher("ProductController?type=Product").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void productList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String type = request.getParameter("type");
        String pagenumber = request.getParameter("page");
        ProductDAO pdao = new ProductDAO();
        List<Product> products = null;
        products = pdao.getAll();
        int page = 1, pageSize = 6;
        int totalPage = products.size();
        if (request.getParameter("page") != null) { // check param page
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
                request.setAttribute("ListProduct", pdao.getProductFromTo(page, pageSize));
            } catch (Exception ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("type", type);
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("ProductManage.jsp").forward(request, response);
    }

    private void AddList(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO pdao = new ProductDAO();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void AddProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        ProductDAO pdao = new ProductDAO();
        try {
            String name = request.getParameter("name");
            String type = pdao.getTypeID(request.getParameter("type"));
            String price = request.getParameter("price");
            Part filePart = request.getPart("image");
            String realPath = request.getServletContext().getRealPath("/product-img");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }
            filePart.write(realPath + "/" + fileName);
            String image = "product-img/" + fileName;
            String info = request.getParameter("info");
            int num = Integer.parseInt(request.getParameter("numberofproduct"));
            Product p = new Product(name, type, Double.parseDouble(price), info, 0, image);
            boolean added = pdao.addProduct(p, num);
            if (added) {
                request.getRequestDispatcher("ProductController?type=Product").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errMessage", "You must fill all the fields");
            request.getRequestDispatcher("AddBlogContent.jsp").forward(request, response);
        }

    }

}
/*
            session.removeAttribute("items");
            session.removeAttribute("size");*/
 /*  List<Item> listbuy = null;
                List<Product> listfavorite = null;
                listbuy = new ProductDAO().getListBuyItem(u);
                listfavorite = new ProductDAO().getListFavoriteItem(u);
                session.setAttribute("listFavorite", listfavorite);
                session.setAttribute("items", listbuy);*/
