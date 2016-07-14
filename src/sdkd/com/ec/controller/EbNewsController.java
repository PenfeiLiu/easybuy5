package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsController extends HttpServlet {
          EbNewsDao newsDao = new EbNewsDao();
          EbNoticeDao noticeDao = new EbNoticeDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        String judge = request.getParameter("judge");


        if("list".equals(judge)){

        }else if("detail".equals(judge)){

            singleNew(request,response);
        }else{
            List(request,response);
        }

        //跳转

    }
    public void List(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EbNews> list = newsDao.getNews();
        List<EbNotice> list1 = noticeDao.getNotice();
        request.setAttribute("newList",list);
        request.setAttribute("noticeList",list1);
        request.getRequestDispatcher("/action1").forward(request,response);
    }
    public void singleNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramsId = request.getParameter("id");
        String parameter = request.getParameter("temp");
        int id = 0;
        int temp = 0;
        if(paramsId!=null && !"".equals(paramsId)){
            id = Integer.valueOf(paramsId);
        }
        if(parameter!=null && !"".equals(parameter)){
            temp = Integer.valueOf(parameter);
        }
        EbNews ebNews = newsDao.getNewsById(id);
        EbNotice ebNotice = noticeDao.getNoticeById(id);
        request.setAttribute("news",ebNews);
        request.setAttribute("notices",ebNotice);
        if(temp!=0){
            request.getRequestDispatcher("/notice-view.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/news-view.jsp").forward(request,response);
        }

    }
}
