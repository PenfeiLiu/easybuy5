package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbBargainDao;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by liupengfei on 2016/7/7.
 */

public class  EbHotSaleController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EbBargainDao ebBargainDao = new EbBargainDao();

        List<EbProduct> hotProductList = ebBargainDao.getProduct();

        req.setAttribute("hotProductList",hotProductList);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
