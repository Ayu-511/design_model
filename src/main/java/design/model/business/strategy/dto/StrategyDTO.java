package design.model.business.strategy.dto;

import java.io.Serializable;

public class StrategyDTO implements Serializable {

    /**
     * 支付类型
     */
    private int type;

    /**
     * 路程长度
     */
    private int length;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public StrategyDTO(int type, int length) {
        this.type = type;
        this.length = length;
    }

    public StrategyDTO() {
    }

    @Override
    public String toString() {
        return "PayMethodDTO{" +
                "type=" + type +
                ", length=" + length +
                '}';
    }
}
