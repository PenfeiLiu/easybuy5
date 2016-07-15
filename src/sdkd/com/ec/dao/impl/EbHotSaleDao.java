package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liupengfei on 2016/7/7.
 */
public class EbHotSaleDao extends BaseDao{
    public List<EbProduct> getProduct(){
        List<EbProduct> hotProductsList = new ArrayList<EbProduct>();
        String sql = " select * from easybuy_product  limit 1,12";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while (rs.next())
            {
                EbProduct ebProduct = new EbProduct();
                ebProduct.setEp_description(rs.getString("ep_description"));
                ebProduct.setEp_id(rs.getInt("ep_id"));
                ebProduct.setEp_file_name(rs.getString("ep_file_name"));
                ebProduct.setEp_name(rs.getString("ep_name"));
                ebProduct.setEp_price(rs.getDouble("ep_price"));
                ebProduct.setEp_stock(rs.getInt("ep_stock"));
                ebProduct.setEpc_child_id(rs.getInt("epc_child_id"));
                ebProduct.setEpc_id(rs.getInt("epc_id"));

                hotProductsList.add(ebProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return hotProductsList;

    }
}
