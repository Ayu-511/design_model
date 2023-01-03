package design.model.business.strategy.service;

import java.math.BigDecimal;

public interface Strategy {

    /**
     * 快递公司
     *
     * @return {@link String }
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/27 16:12:63
     */
    String payMethod();

    /**
     * 类型
     *
     * @param type 类型
     * @return boolean
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:75
     */
    boolean type(int type);

    /**
     * 目前
     *
     * @return int
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:97
     */
    int isCurrent();

    /**
     * 得到价格
     *
     * @param length 长度
     * @return {@link BigDecimal }
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:62
     */
    BigDecimal getPrice(int length);
}
