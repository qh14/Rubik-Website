package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ProductDAO;
import dao.ProductDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("\n");
      out.write("        <!-- Title  -->\n");
      out.write("        <title>Essence - Fashion Ecommerce Template</title>\n");
      out.write("\n");
      out.write("        <!-- Favicon  -->\n");
      out.write("        <link rel=\"icon\" href=\"img/core-img/favicon.ico\">\n");
      out.write("\n");
      out.write("        <!-- Core Style CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/core-style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- ##### Header Area Start ##### -->\n");
      out.write("        <header class=\"header_area\">\n");
      out.write("            <div class=\"classy-nav-container breakpoint-off d-flex align-items-center justify-content-between\">\n");
      out.write("                <!-- Classy Menu -->\n");
      out.write("                <nav class=\"classy-navbar\" id=\"essenceNav\">\n");
      out.write("                    <!-- Logo -->\n");
      out.write("                    <a class=\"nav-brand\" href=\"index.jsp\"><img src=\"img/core-img/logo.png\" alt=\"\"></a>\n");
      out.write("                    <!-- Navbar Toggler -->\n");
      out.write("                    <div class=\"classy-navbar-toggler\">\n");
      out.write("                        <span class=\"navbarToggler\"><span></span><span></span><span></span></span>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Menu -->\n");
      out.write("                    <div class=\"classy-menu\">\n");
      out.write("                        <!-- close btn -->\n");
      out.write("                        <div class=\"classycloseIcon\">\n");
      out.write("                            <div class=\"cross-wrap\"><span class=\"top\"></span><span class=\"bottom\"></span></div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
      dao.ProductDAO typelist = null;
      synchronized (_jspx_page_context) {
        typelist = (dao.ProductDAO) _jspx_page_context.getAttribute("typelist", PageContext.PAGE_SCOPE);
        if (typelist == null){
          typelist = new dao.ProductDAO();
          _jspx_page_context.setAttribute("typelist", typelist, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                        <!-- Nav Start -->\n");
      out.write("                        <div class=\"classynav\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Shop</a>\n");
      out.write("\n");
      out.write("                                    <div class=\"megamenu\">\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("                                        <div class=\"single-mega cn-col-4\">\n");
      out.write("                                            <img src=\"img/bg-img/bg-2.jpg\" alt=\"\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\">Pages</a>\n");
      out.write("                                    <ul class=\"dropdown\">\n");
      out.write("                                        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                                        <li><a href=\"SearchController?typeSearch=All\">Shop</a></li>\n");
      out.write("                                        <li><a href=\"single-product-details.html\">Product Details</a></li>\n");
      out.write("                                        <li><a href=\"checkout.html\">Checkout</a></li>\n");
      out.write("                                        <li><a href=\"Blog.jsp\">Blog</a></li>\n");
      out.write("                                        <li><a href=\"single-blog.html\">Single Blog</a></li>\n");
      out.write("                                        <li><a href=\"regular-page.html\">Regular Page</a></li>\n");
      out.write("                                        <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"Blog.jsp\">Blog</a></li>\n");
      out.write("                                <li><a href=\"Contact.jsp\">Contact</a></li>\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Nav End -->\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <!-- Header Meta Data -->\n");
      out.write("                <div class=\"header-meta d-flex clearfix justify-content-end\">\n");
      out.write("                    <!-- Search Area -->\n");
      out.write("                    <div class=\"search-area\">\n");
      out.write("                        <form action=\"SearchController\" method=\"GET\">\n");
      out.write("                            <input type=\"search\" name=\"search\" id=\"headerSearch\" placeholder=\"Type for search\">\n");
      out.write("                            <button type=\"submit\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i></button>\n");
      out.write("                            <input type=\"hidden\" name=\"typeSearch\" value=\"Name\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Favourite Area -->\n");
      out.write("                    <div class=\"favourite-area\">\n");
      out.write("                        <a href=\"SearchController?typeSearch=Favorite\"><img src=\"img/core-img/heart.svg\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- User Login Info -->\n");
      out.write("                    <div class=\"user-login-info\">\n");
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Cart Area -->\n");
      out.write("                    <div class=\"cart-area\">\n");
      out.write("                        <a href=\"ListItem.jsp\" id=\"essenceCartBtn\"><img src=\"img/core-img/bag.svg\" alt=\"\"> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${size}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- ##### Header Area End ##### -->\n");
      out.write("        <!-- jQuery (Necessary for All JavaScript Plugins) -->\n");
      out.write("        <script src=\"js/jquery/jquery-2.2.4.min.js\"></script>\n");
      out.write("        <!-- Popper js -->\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <!-- Bootstrap js -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Plugins js -->\n");
      out.write("        <script src=\"js/plugins.js\"></script>\n");
      out.write("        <!-- Classy Nav js -->\n");
      out.write("        <script src=\"js/classy-nav.min.js\"></script>\n");
      out.write("        <!-- Active js -->\n");
      out.write("        <script src=\"js/active.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
      out.write("  \n");
      out.write("        <!-- ##### Welcome Area Start ##### -->\n");
      out.write("        <video class=\"video-react-video\" muted=\"\" preload=\"auto\" loop=\"\" autoplay=\"\" style=\"margin: -15px\" src=\"//videos.ctfassets.net/r3qu44etwf9a/3gsxChj55LrmFT7644E7OZ/bb4c1a85688ec697f96410f79909d888/rubiks-hero-banner.mp4\" tabindex=\"-1\"></video>\n");
      out.write("        <section class=\"welcome_area bg-img background-overlay\" style=\"background-image: url(img/bg-img/bg-1.jpg);\">\n");
      out.write("            <div class=\"container h-100\">\n");
      out.write("                <div class=\"row h-100 align-items-center\">\n");
      out.write("                    <div class=\"col-12\">\n");
      out.write("                        <div class=\"hero-content\">\n");
      out.write("                            <h6>asoss</h6>\n");
      out.write("                            <h2>New Collection</h2>\n");
      out.write("                            <a href=\"#\" class=\"btn essence-btn\">view collection</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- ##### Welcome Area End ##### -->\n");
      out.write("        <!-- ##### Top Catagory Area Start ##### -->\n");
      out.write("        <div class=\"top_catagory_area section-padding-80 clearfix\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <!-- Single Catagory -->\n");
      out.write("                    <div class=\"col-12 col-sm-6 col-md-4\">\n");
      out.write("                        <div class=\"single_catagory_area d-flex align-items-center justify-content-center bg-img\" style=\"background-image: url(img/bg-img/bg-2.jpg);\">\n");
      out.write("                            <div class=\"catagory-content\">\n");
      out.write("                                <a href=\"#\">Regular-shaped cubes </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Single Catagory -->\n");
      out.write("                    <div class=\"col-12 col-sm-6 col-md-4\">\n");
      out.write("                        <div class=\"single_catagory_area d-flex align-items-center justify-content-center bg-img\" style=\"background-image: url(img/bg-img/bg-3.jpg);\">\n");
      out.write("                            <div class=\"catagory-content\">\n");
      out.write("                                <a href=\"#\">Combo Rubik</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Single Catagory -->\n");
      out.write("                    <div class=\"col-12 col-sm-6 col-md-4\">\n");
      out.write("                        <div class=\"single_catagory_area d-flex align-items-center justify-content-center bg-img\" style=\"background-image: url(img/bg-img/bg-4.jpg);\">\n");
      out.write("                            <div class=\"catagory-content\">\n");
      out.write("                                <a href=\"#\">Rubik Accessories</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- ##### Top Catagory Area End ##### -->\n");
      out.write("        <!-- ##### New Arrivals Area Start ##### -->\n");
      out.write("        ");
      dao.ProductDAO db = null;
      synchronized (_jspx_page_context) {
        db = (dao.ProductDAO) _jspx_page_context.getAttribute("db", PageContext.PAGE_SCOPE);
        if (db == null){
          db = new dao.ProductDAO();
          _jspx_page_context.setAttribute("db", db, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        <section class=\"new_arrivals_area section-padding-80 clearfix\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-12\">\n");
      out.write("                        <div class=\"section-heading text-center\">\n");
      out.write("                            <h2>Popular Products</h2>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-12\">\n");
      out.write("                        <div class=\"popular-products-slides owl-carousel\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <!-- jQuery (Necessary for All JavaScript Plugins) -->\n");
      out.write("        <script src=\"js/jquery/jquery-2.2.4.min.js\"></script>\n");
      out.write("        <!-- Popper js -->\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <!-- Bootstrap js -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Plugins js -->\n");
      out.write("        <script src=\"js/plugins.js\"></script>\n");
      out.write("        <!-- Classy Nav js -->\n");
      out.write("        <script src=\"js/classy-nav.min.js\"></script>\n");
      out.write("        <!-- Active js -->\n");
      out.write("        <script src=\"js/active.js\"></script>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- ##### Footer Area Start ##### -->\n");
      out.write("<footer class=\"footer_area clearfix\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <!-- Single Widget Area -->\n");
      out.write("            <div class=\"col-12 col-md-6\">\n");
      out.write("                <div class=\"single_widget_area d-flex mb-30\">\n");
      out.write("                    <!-- Logo -->\n");
      out.write("                    <div class=\"footer-logo mr-50\">\n");
      out.write("                        <a href=\"#\"><img src=\"img/core-img/logo2.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Footer Menu -->\n");
      out.write("                    <div class=\"footer_menu\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"shop.html\">Shop</a></li>\n");
      out.write("                            <li><a href=\"blog.html\">Blog</a></li>\n");
      out.write("                            <li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Single Widget Area -->\n");
      out.write("            <div class=\"col-12 col-md-6\">\n");
      out.write("                <div class=\"single_widget_area mb-30\">\n");
      out.write("                    <ul class=\"footer_widget_menu\">\n");
      out.write("                        <li><a href=\"#\">Order Status</a></li>\n");
      out.write("                        <li><a href=\"#\">Payment Options</a></li>\n");
      out.write("                        <li><a href=\"#\">Shipping and Delivery</a></li>\n");
      out.write("                        <li><a href=\"#\">Guides</a></li>\n");
      out.write("                        <li><a href=\"#\">Privacy Policy</a></li>\n");
      out.write("                        <li><a href=\"#\">Terms of Use</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row align-items-end\">\n");
      out.write("            <!-- Single Widget Area -->\n");
      out.write("            <div class=\"col-12 col-md-6\">\n");
      out.write("                <div class=\"single_widget_area\">\n");
      out.write("                    <div class=\"footer_heading mb-30\">\n");
      out.write("                        <h6>Subscribe</h6>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"subscribtion_form\">\n");
      out.write("                        <form action=\"#\" method=\"post\">\n");
      out.write("                            <input type=\"email\" name=\"mail\" class=\"mail\" placeholder=\"Your email here\">\n");
      out.write("                            <button type=\"submit\" class=\"submit\"><i class=\"fa fa-long-arrow-right\" aria-hidden=\"true\"></i></button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Single Widget Area -->\n");
      out.write("            <div class=\"col-12 col-md-6\">\n");
      out.write("                <div class=\"single_widget_area\">\n");
      out.write("                    <div class=\"footer_social_area\">\n");
      out.write("                        <a href=\"https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Frubiks.com%2F\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Facebook\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\n");
      out.write("                        <a href=\"#\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Instagram\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\n");
      out.write("                        <a href=\"https://twitter.com/intent/tweet?url=https://rubiks.com/&text=Rubiks%20%7C%20Home\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Twitter\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\n");
      out.write("                        <a href=\"https://www.pinterest.com/pin/create/button/?url=https://rubiks.com/&description=Rubiks%20%7C%20Home\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Pinterest\"><i class=\"fa fa-pinterest\" aria-hidden=\"true\"></i></a>\n");
      out.write("                        <a href=\"#\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Youtube\"><i class=\"fa fa-youtube-play\" aria-hidden=\"true\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row mt-5\">\n");
      out.write("            <div class=\"col-md-12 text-center\">\n");
      out.write("                <p>\n");
      out.write("                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>, distributed by <a href=\"https://themewagon.com/\" target=\"_blank\">ThemeWagon</a>\n");
      out.write("                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<!-- ##### Footer Area End ##### -->\n");
      out.write("  \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("type");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${typelist.typeProduct}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            ");
          if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                            <ul class=\"single-mega cn-col-4\">\n");
          out.write("                                                <li class=\"title\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</li>\n");
          out.write("                                                    ");
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                            </ul>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_0.setVar("a");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setVar("sub");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${typelist.getSubTypeProduct(a)}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \n");
          out.write("                                                    <li><a href=\"SearchController?&typeSearch=Type&search=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sub}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sub}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.isRoleAdmin()}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li>\n");
        out.write("                                        <a href=\"#\">Management</a>\n");
        out.write("                                        <ul class=\"dropdown\">\n");
        out.write("                                            <li><a href=\"ProductController?type=Product\">Product Editing</a></li>\n");
        out.write("                                            <li><a href=\"#\">Account Manage</a></li>\n");
        out.write("                                            <li><a href=\"ShopInfoUpdate.jsp\">Shop Info</a></li>\n");
        out.write("                                            <li><a href=\"AddProduct.jsp\">Add New Product</a></li>\n");
        out.write("                                            <li><a href=\"AddBlog.jsp\">Add New Blog</a></li>\n");
        out.write("                                            <li><a href=\"single-blog.html\">Single Blog</a></li>\n");
        out.write("                                            <li><a href=\"regular-page.html\">Regular Page</a></li>\n");
        out.write("                                            <li><a href=\"contact.html\">Contact</a></li>\n");
        out.write("                                        </ul>\n");
        out.write("                                    </li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty account}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a href=\"CustomerInfomation.jsp\"><i class=\"fa fa-user-o\"></i> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty account}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a href=\"Login.jsp\"><i class=\"fa fa-user-o\"></i> Log in </a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("accountname");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.username}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("p");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${db.all}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <!-- Single Product -->\n");
          out.write("                                <div class=\"single-product-wrapper\">\n");
          out.write("                                    <!-- Product Image -->\n");
          out.write("                                    <div class=\"product-img\">\n");
          out.write("                                        <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                        <!-- Favourite -->\n");
          out.write("                                        ");
          if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\n");
          out.write("                                        ");
          if (_jspx_meth_c_if_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\n");
          out.write("                                    </div>\n");
          out.write("\n");
          out.write("                                    <!-- Product Description -->\n");
          out.write("                                    <div class=\"product-description\">\n");
          out.write("                                        <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.typeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                        <a href=\"ProductDetails.jsp?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                            <h6>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\n");
          out.write("                                        </a>\n");
          out.write("                                        <p class=\"product-price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\n");
          out.write("                                        <!-- Hover Content -->\n");
          out.write("                                        <div class=\"hover-content\">\n");
          out.write("                                            <!-- Add to Cart -->\n");
          out.write("                                            <div class=\"add-to-cart-btn\">\n");
          out.write("                                                <a href=\"BuyController?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn essence-btn\">Add to Cart</a>\n");
          out.write("                                            </div>\n");
          out.write("                                        </div>\n");
          out.write("                                    </div>\n");
          out.write("\n");
          out.write("                                </div>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty account}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <div class=\"product-favourite\">\n");
        out.write("                                                ");
        if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                            </div>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_set_2.setVar("list");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.listFavorite}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty list}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                    ");
        if (_jspx_meth_c_if_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_4, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                                    ");
        if (_jspx_meth_c_if_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_4, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_4);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${db.searchFavorite(list,p.productID)>=0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                        <a href=\"SearchController?typeSearch=Favorite&id=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" class=\"favme fa fa-heart\" style=\"color: red\"></a>\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_4);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${db.searchFavorite(list,p.productID)<0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                                                        <a href=\"SearchController?typeSearch=Favorite&id=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" class=\"favme fa fa-heart\"></a>\n");
        out.write("\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty list}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <div class=\"product-favourite\">\n");
        out.write("                                                <a href=\"SearchController?typeSearch=Favorite&id=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" class=\"favme fa fa-heart\"></a>\n");
        out.write("                                            </div>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }
}
