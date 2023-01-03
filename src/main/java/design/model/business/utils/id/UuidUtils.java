package design.model.business.utils.id;

import java.io.Serializable;
import java.util.UUID;

public class UuidUtils implements Serializable {

    /**
     * 得到uu id
     *
     * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
     * creation time: 2022/12/30 11:12:90
     * @see String
     */
    public static String getUuId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
