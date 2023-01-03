package design.model.business.strategy.service.impl;

import design.model.business.enums.StrategyTypeEnum;
import design.model.business.strategy.dto.StrategyDTO;
import design.model.business.strategy.service.Strategy;
import design.model.business.strategy.service.StrategyService;
import design.model.business.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private List<Strategy> strategies;

    HashMap<Integer, Strategy> strategyHashMap = new HashMap<>();

    public StrategyServiceImpl(List<Strategy> strategyList) {
        strategyList.forEach(item ->{
            strategyHashMap.put(item.isCurrent(), item);
        });
    }



    @Override
    public String getPayMethod(int type) {
        for (StrategyTypeEnum enums : StrategyTypeEnum.values()) {
            if (!enums.getType().equals(type)) {
                continue;
            }
            throw new CustomException("参数错误");
        }
        Strategy strategy = this.strategies.stream().filter(k -> k.type(type)).findFirst().orElse(null);
        if (null != strategy) {
            return strategy.payMethod();
        }
        return "该支付方式不存在";
    }

    @Override
    public BigDecimal getPrice(StrategyDTO payMethodDTO) {
        Strategy strategy = strategyHashMap.get(payMethodDTO.getType());
        return strategy.getPrice(payMethodDTO.getLength());
    }

}
