package com.qianxx.qztaxi.common;

import java.math.BigDecimal;

public abstract class CommonUtils {

    /**
     * 将数据四舍五入
     *
     * @param mathDate
     * @return
     */
    public static <T extends Object> double roundingData(T mathDate) {
        return new BigDecimal(mathDate.toString()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double setDoubleScale(double inputValue, int newScale) {
        return (new BigDecimal(inputValue)).setScale(newScale, 4).doubleValue();
    }

    public static double setDoubleScale(BigDecimal inputValue, int newScale) {
        return inputValue.setScale(newScale, 4).doubleValue();
    }
}
