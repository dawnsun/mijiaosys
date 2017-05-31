package com.mijiaokj.sys.common.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 * 金融数字相关工具类
 * Created by sunchenguang on 2017/5/31.
 */
public class NumberUtils {
    private static Pattern pattern = Pattern.compile("^[\\d]*$");
    /*
     * 四舍五入，不显示小数点
     */
    public static String parseDouble(Double data) {
        NumberFormat nf = new DecimalFormat("#,###");
        return nf.format(Math.round(data));
    }

    // 将元转换为亿，保留两个小数点,0返回0.00
    public static Double parseYuanToYi(Double data) {
        // Double temp=data/100000000;
        if (data != null) {
            NumberFormat nf = new DecimalFormat("0.00");
            String tmp = nf.format(data / 100000000);
            return Double.valueOf(tmp);
        }
        return data;

    }

    // 将元转换为万，保留两个小数点,0返回0.00
    public static String parseYuanToWan(Double data) {
        // Double temp=data/10000;
        if (data != null) {
            NumberFormat nf = new DecimalFormat("0.00");
            String moneyValue = nf.format(data / 10000);
            return moneyFormat(moneyValue);
        }
        return "";
    }

    /***
     * 将分统一转换成元
     *
     * @param data
     * @return
     */
    public static String parseFenToYuan(Long data) {
        return parseFenToYuan(data, "--");
    }

    public static String parseFenToYuan(Long data, String defaultValue) {
        if (data != null) {
            NumberFormat nf = new DecimalFormat("0.00");
            String moneyValue = nf.format(data / 100.0);
            return moneyFormat(moneyValue);
        }
        return defaultValue;
    }

    /**
     * 将0.08 -> 8%
     *
     * @param rateInt
     * @return
     */
    public static String formatIntRate(double rateInt) {
        try {
            NumberFormat nf = new DecimalFormat("0.00");
            String moneyValue = nf.format(rateInt * 100);
            return moneyValue + "%";
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 格式化金额数字 规则：数字每隔3位加逗号小数点保留两位.单元（/万）
     *
     * @param moneyValue
     */
    public static String moneyFormat(String moneyValue) {
        try {
            moneyValue = StringUtils.trim(moneyValue);
            final String pointFormat = ".";
            final String commaFormat = ",";
            if (StringUtils.isBlank(moneyValue)) {
                return moneyValue;
            }
            String prefixString = "";
            if (StringUtils.startsWith(moneyValue, "-")) {
                prefixString = "-";
                moneyValue = StringUtils.substring(moneyValue, 1); // 将负号去掉
            }

            String prefixBefore = moneyValue;
            String suffixAfter = "";

            if (StringUtils.contains(moneyValue, pointFormat)) {
                int position = StringUtils.indexOf(moneyValue, pointFormat);
                prefixBefore = StringUtils.left(moneyValue, position);
                suffixAfter = StringUtils.substring(moneyValue, position + 1);
            }
            String reverseStr = StringUtils.reverse(prefixBefore);

            String tempBufferString = "";

            for (int i = 0; i < reverseStr.length(); i++) {
                if (i * 3 + 3 > reverseStr.length()) {
                    tempBufferString += reverseStr.substring(i * 3, reverseStr.length());
                    break;
                }
                tempBufferString += reverseStr.substring(i * 3, i * 3 + 3) + commaFormat;
            }
            if (tempBufferString.endsWith(commaFormat)) {
                tempBufferString = tempBufferString.substring(0, tempBufferString.length() - 1);
            }

            String resultStr = StringUtils.reverse(tempBufferString);

            if (StringUtils.isBlank(suffixAfter)) {
                return resultStr;
            }
            StringBuffer resultString = new StringBuffer();
            if (StringUtils.isNotBlank(prefixString)) {
                resultString.append(prefixString);
            }
            resultString.append(resultStr);
            resultString.append(pointFormat);
            resultString.append(suffixAfter);
            return resultString.toString();
        } catch (Exception ex) {
            return moneyValue;
        }
    }

    public static boolean isInteger(String str) {
        return pattern.matcher(str).matches();
    }

    /**
     * 金额除以100，并千位分隔
     *
     * @param amt
     * @return
     */
    public static String dividedHundred(String amt) {

        if (StringUtils.isEmpty(amt) || "-".equals(amt)) {
            return amt;
        }

        BigDecimal amtTemp = new BigDecimal(amt);
        amtTemp = amtTemp.setScale(2);
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        return decimalFormat.format(amtTemp.divide(new BigDecimal("100")));
    }

    /*public static void main(String[] args) {
        Long current = 560000L;

        System.out.println(parseFenToYuan(current*100));

//
//        BigDecimal bg = BigDecimal.valueOf(10000000.12);
//        System.out.println(bg.doubleValue());
//        System.out.println(bg.toString());
//        System.out.println(moneyFormat(bg.toString()));
//
//        System.out.println(isInteger("abc"));
//        System.out.println(isInteger("112233.4455"));
//        System.out.println(isInteger("-123"));
//        System.out.println(isInteger("12345"));
//        System.out.println(isInteger("ab123"));
//        System.out.println(isInteger("1234a"));
//
//        String a = "-123832.96";
//        System.out.println(StringUtils.substring(a, 1));
//
//        System.out.println((parseFenToYuan(10000000L)));
//
//        System.out.println(dividedHundred("100000"));
//
//        System.out.println(parseFenToYuan(6122144L));
    }*/

}
