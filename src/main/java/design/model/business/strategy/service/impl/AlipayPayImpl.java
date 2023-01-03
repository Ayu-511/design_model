package design.model.business.strategy.service.impl;

import design.model.business.enums.StrategyTypeEnum;
import design.model.business.strategy.service.Strategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class AlipayPayImpl implements Strategy {
    @Override
    public String payMethod() {
        return StrategyTypeEnum.ALIPAY_PAY.getLabel();
    }

    @Override
    public boolean type(int type) {
        return Objects.equals(type, StrategyTypeEnum.ALIPAY_PAY.getType());
    }

    @Override
    public int isCurrent() {
        return StrategyTypeEnum.ALIPAY_PAY.getType();
    }

    @Override
    public BigDecimal getPrice(int length) {
        return new BigDecimal(length * 100);
    }

}
