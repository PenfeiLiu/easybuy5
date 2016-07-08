package sdkd.com.ec.model;

/**
 * Created by liupengfei on 2016/7/7.
 */
public class EbDirectory {
    private String epcName;
    private Integer epcId;
    private Integer epcParentId;

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public Integer getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(Integer epcParentId) {
        this.epcParentId = epcParentId;
    }
}
