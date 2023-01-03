package design.model.business.enums;

import com.mysql.cj.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 策略类型支付方式枚举
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2023/01/02 23:01:02
 */
public enum StrategyTypeEnum {
    /**
     * 支付宝支付
     */
    ALIPAY_PAY(1, "支付宝支付"),

    /**
     * 微信支付
     */
    WECHAT_PAY(2, "微信支付"),

    /**
     * 银行卡支付
     */
    BANK_CARD_PAY(3, "银行卡支付");
    /**
     * 关键
     */
    private final Integer type;

    /**
     * 标签
     */
    private final String label;

    public Integer getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    StrategyTypeEnum(Integer type, String label) {
        this.type = type;
        this.label = label;
    }

    /**
     * 使用流通过类型匹配枚举
     *
     * @param type 类型
     * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
     * creation time: 2023/01/02 23:01:12
     * @see String
     * @see StrategyTypeEnum
     */
    public static StrategyTypeEnum getType(Integer type) {
        if (Objects.isNull(type)) {
            return null;
        }
        return Arrays.stream(StrategyTypeEnum.values()).filter(k -> k.getType().equals(type)).findFirst().orElse(null);
    }

    /**
     * 使用流通过标签名匹配枚举
     *
     * @param label 标签
     * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
     * creation time: 2023/01/02 23:01:28
     * @see String
     * @see StrategyTypeEnum
     */
    public static StrategyTypeEnum getLabel(String label) {
        if (StringUtils.isNullOrEmpty(label)) {
            return null;
        }
        return Arrays.stream(StrategyTypeEnum.values()).filter(k ->k.getLabel().equals(label)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(getType(1).label); //支付宝支付
    }
}
