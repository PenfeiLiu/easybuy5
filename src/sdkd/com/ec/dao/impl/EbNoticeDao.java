package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNotice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupengfei on 2016/7/14.
 */
public class EbNoticeDao extends BaseDao {
    public List<EbNotice> getNotice(){
        List<EbNotice> NoticeList = new ArrayList<EbNotice>();
        String sql = "select * from easybuy_notice  limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNotice Notice = new EbNotice();
                Notice.setEc_id(rs.getInt("ec_id"));
                Notice.setEc_entitle(rs.getString("ec_entitle"));
                Notice.setEc_content(rs.getString("ec_content"));
                //添加到集合中
                NoticeList.add(Notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return NoticeList;
    }
    public EbNotice getNoticeById(int id){  //获得单个新闻
        EbNotice Notice = new EbNotice();
        String sql = "select * from easybuy_notice where ec_id = ?";
        List<String> paramList = new ArrayList<String>() ;
        paramList.add(id+"");
        try {
            ResultSet rs = this.executeSearch(sql,paramList);
            while (rs.next()){

                Notice.setEc_id(rs.getInt("ec_id"));
                Notice.setEc_entitle(rs.getString("ec_entitle"));
                Notice.setEc_content(rs.getString("ec_content"));
                //添加到集合中

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  Notice;
    }
}
