package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbPages;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品Controller
 * Created by SDUST-132 on 2016/7/8.
 */
@MultipartConfig(location = "F:\\Users\\liupengfei\\easybuy\\web\\images\\product")
public class EbProductController extends HttpServlet {
    EbProductDao productDao = new EbProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String action = request.getParameter("action");
        if(action != null && !"".equals(action)){
            if("list".equals(action)){
                list(request, response);
            }else if("detail".equals(action)){
                detail(request, response);
            }else if("mgrAdd".equals(action)){
                upload(request,response);
            }
        }

    }

    /**
     * 商品详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");
        EbPages pages = new EbPages();
        int pageIndex = 1;
        int pageSize =2;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EbProduct> productList = productDao.getProductPager(pageIndex,pageSize);

        int count = productDao.getProductCount();
        int totalPage = ((count%pageSize==0)?(count/pageSize):(count/pageSize+1));

        pages.setTotalPage(totalPage);
        pages.setPageSize(pageSize);
        pages.setPageIndex(pageIndex);
        request.setAttribute("productList",productList);
        request.setAttribute("pageIndex",pageIndex);  //总记录数
        request.setAttribute("pages",pages);
        List<Integer> countList = new ArrayList<Integer>();

        request.setAttribute("totalPage",totalPage);


        //跳转页面
        request.getRequestDispatcher("/product-list.jsp").forward(request,response);
    }

    /**
     * 商品详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = 0;
        String paramsId = request.getParameter("id");
        if(paramsId != null && !"".equals(paramsId)){
            id = Integer.parseInt(paramsId);
        }
        EbProduct product = productDao.getProductById(id);
        request.setAttribute("product",product);
        //跳转页面
        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
    }


    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Part part = request.getPart("photo");
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        part.write(fileName);
    }
}
