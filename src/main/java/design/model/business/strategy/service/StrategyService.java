package design.model.business.strategy.service;

import design.model.business.strategy.dto.StrategyDTO;

import java.math.BigDecimal;

public interface StrategyService {

    /**
     * 得到支付方法
     *
     * @param type 类型
     * @return {@link String }
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:80
     */
    public String getPayMethod(int type);

    /**
     * 得到价格
     *
     * @param payMethodDTO 支付方法dto
     * @return {@link BigDecimal }
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:88
     */
    public BigDecimal getPrice(StrategyDTO payMethodDTO);
}
