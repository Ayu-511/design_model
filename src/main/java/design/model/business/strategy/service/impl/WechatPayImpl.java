package design.model.business.strategy.service.impl;

import design.model.business.enums.StrategyTypeEnum;
import design.model.business.strategy.service.Strategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class WechatPayImpl implements Strategy {
    @Override
    public String payMethod() {
        return "使用微信支付";
    }

    @Override
    public boolean type(int type) {
        return Objects.equals(type, StrategyTypeEnum.WECHAT_PAY.getType());
    }

    @Override
    public int isCurrent() {
        return StrategyTypeEnum.WECHAT_PAY.getType();
    }

    @Override
    public BigDecimal getPrice(int length) {
        return new BigDecimal(10 * length);
    }

}
