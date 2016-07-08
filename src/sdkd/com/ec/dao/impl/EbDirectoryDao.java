package sdkd.com.ec.dao.impl;

/**
 * Created by liupengfei on 2016/7/7.
 */

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbDirectory;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbDirectoryDao extends BaseDao {
    public List<EbDirectory> getDirectory(){
        List<EbDirectory> directoryList = new ArrayList<EbDirectory>();
        String sql = "select * from easybuy_product_category ";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbDirectory directory = new EbDirectory();
                directory.setEpcId(rs.getInt("epc_id"));
                directory.setEpcName(rs.getString("epc_name"));
                directory.setEpcParentId(rs.getInt("epc_parent_id"));

                //添加到集合中
                directoryList.add(directory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directoryList;
    }
}


