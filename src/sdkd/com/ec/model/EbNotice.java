package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/13.
 */
public class EbNotice {
    private int ec_id;
    private String ec_entitle;
    private String ec_content;
    private String ec_creat_time;

    public int getEc_id() {
        return ec_id;
    }

    public void setEc_id(int ec_id) {
        this.ec_id = ec_id;
    }

    public String getEc_entitle() {
        return ec_entitle;
    }

    public void setEc_entitle(String ec_entitle) {
        this.ec_entitle = ec_entitle;
    }

    public String getEc_content() {
        return ec_content;
    }

    public void setEc_content(String ec_content) {
        this.ec_content = ec_content;
    }

    public String getEc_creat_time() {
        return ec_creat_time;
    }

    public void setEc_creat_time(String ec_creat_time) {
        this.ec_creat_time = ec_creat_time;
    }
}
