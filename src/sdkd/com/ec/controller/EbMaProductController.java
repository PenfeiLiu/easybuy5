package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10929 on 2016/7/12.
 */

public class EbMaProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String action=request.getParameter("action");

        if("showProducts".equalsIgnoreCase(action)) {
            showProducts(request, response);
        }else if("showProduct".equalsIgnoreCase(action)){
            showProduct(request,response);
        }else if("updata".equalsIgnoreCase(action)){
            updataProduct(request,response);
        }else if("delete".equalsIgnoreCase(action)){
            deleteProduct(request,response);
        }else if("insert".equalsIgnoreCase(action)){
            insertProduct(request,response);
        }
    }

    public void showProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        EbProductDao productDao=new EbProductDao();
        List<EbProduct> productList=new ArrayList<EbProduct>();
        productList=productDao.getProductList();
        request.getSession().setAttribute("products",productList);
        request.getRequestDispatcher("/manage/product.jsp").forward(request,response);
    }

    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String productId=request.getParameter("productId");
       EbProductDao productDao=new EbProductDao();
        EbProduct product=new EbProduct();
        product=productDao.getProductById(Integer.valueOf(productId));
        request.setAttribute("product",product);
        request.getRequestDispatcher("/manage/product-modify.jsp").forward(request,response);
    }

    public void updataProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");
        String epcId=request.getParameter("epcId");
        String epcChildId=request.getParameter("epcChildId");
        String epDescription=request.getParameter("epDescription");
        String photo=request.getParameter("photo");
        String productPrice=request.getParameter("productPrice");
        String productStock=request.getParameter("productStock");
        String discount=request.getParameter("discount");
        String scan=request.getParameter("productScan");


        EbProduct product=new EbProduct();
        product.setEp_id(Integer.parseInt(productId));
        product.setEp_name(productName);
        product.setEp_description(epDescription);
        product.setEpc_id(Integer.parseInt(epcId));
        product.setEpc_child_id(Integer.parseInt(epcChildId));
        product.setEp_price(Double.parseDouble(productPrice));
        product.setEp_stock(Integer.parseInt(productStock));
        product.setEp_discount(Integer.parseInt(discount));
        product.setEp_views(Integer.parseInt(scan));
        product.setEp_file_name(photo);

      //  EbProductDao.updataProudct(product);

        request.getRequestDispatcher("/manageProduct?action=showProducts").forward(request,response);

    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String id=request.getParameter("productId");
        System.out.print(id);
      //  EbProductDao.deleteProduct(Integer.parseInt(id));

        request.getRequestDispatcher("/manageProduct?action=showProducts").forward(request,response);
    }

    public void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");
        String epcId=request.getParameter("epcId");
        String epcChildId=request.getParameter("epcChildId");
        String epDescription=request.getParameter("epDescription");
        String photo=request.getParameter("photo");
        String productPrice=request.getParameter("productPrice");
        String productStock=request.getParameter("productStock");
        String discount=request.getParameter("discount");
        String scan=request.getParameter("productScan");



        EbProduct product=new EbProduct();
        product.setEp_id(Integer.parseInt(productId));
        product.setEp_name(productName);
        product.setEp_description(epDescription);
        product.setEpc_id(Integer.parseInt(epcId));
        product.setEpc_child_id(Integer.parseInt(epcChildId));
        product.setEp_price(Double.parseDouble(productPrice));
        product.setEp_stock(Integer.parseInt(productStock));
        product.setEp_discount(Integer.parseInt(discount));
        product.setEp_views(Integer.parseInt(scan));
        product.setEp_file_name(photo);



     //   EbProductDao.insertProduct(product);

        request.getRequestDispatcher("/manageProduct?action=showProducts").forward(request,response);
    }

}



