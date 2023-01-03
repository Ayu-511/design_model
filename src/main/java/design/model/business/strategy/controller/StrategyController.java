package design.model.business.strategy.controller;

import design.model.business.strategy.dto.StrategyDTO;
import design.model.business.strategy.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


/**
 * 策略控制器
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2022/12/29 15:12:37
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;


    /**
     * 得到支付方法
     *
     * @param type 类型
     * @throws Exception 异常
     * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
     * creation time: 2022/12/29 15:12:72
     * @see int
     * @see String
     */
    @GetMapping("/getPayMethod")
    public String getPayMethod(@RequestParam("type") int type) {
        return strategyService.getPayMethod(type);
    }

    /**
     * 得到价格
     *
     * @param payMethodDTO 支付方法dto
     * @return {@link String }
     * @author: Yuqirui 玉启锐
     * @email: 1464025388@qq.com
     * @date: 2022/12/28 15:12:35
     */
    @PostMapping("/getPrice")
    public BigDecimal getPrice(@RequestBody StrategyDTO payMethodDTO) {
        return strategyService.getPrice(payMethodDTO);
    }

}
