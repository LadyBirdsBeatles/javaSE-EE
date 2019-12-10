package com.xiaochen.goodsmanager.common;

/**
 * 规则匹配
 */
public class Verification {
    /**
     * 手机号验证
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        if (cellphone.matches(regex)) {
            return true;
        }
        return false;
    }
}
