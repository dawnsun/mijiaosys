package com.mijiaokj.sys.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * 处理Map的工具类
 * Created by sunchenguang on 2017/5/31.
 */
public class MapUtil {

    /**
     * map是否为空
     * @param map
     * @return boolean
     */
    public static boolean isEmpty(Map<? extends Object, ? extends Object> map){
        return map == null || map.isEmpty();
    }

    /**
     * @param sourceMap
     * @param valueKeyProperty
     * @return long[]
     */
    public static long[] map2longArray(Map<? extends Object, ? extends Object> sourceMap, String valueKeyProperty, boolean filterDuplicate)
    {
        long[] array = null;
        try{
            if (!isEmpty(sourceMap)){
                List<Object> oList = new ArrayList<Object>();
                for (Map.Entry<? extends Object, ? extends Object> entry : sourceMap.entrySet()){
                    oList.add(entry.getValue());
                }

                Collection<Object> c = CollectionUtil.getObjectCollection(oList, valueKeyProperty, filterDuplicate);
                if (c != null){
                    array = CollectionUtil.collection2longArray(c);
                }
            }
        }
        catch (Exception e){

        }
        return array;
    }

    /**
     * 将params中的key和value组装成url参数形式
     * @param params Map<String, String> 先要用Collections.sort(keys);
     * @param charset 默认Constants.DEFAULT_CHARSET
     * @param needEncode 是否对value使用URLEncoder.encode()
     * @param keepBlankValue 是否保留空白value到queryString中
     * @return String "key1=value1&key2=value2&key3=value3....", 默认""
     */
    @SuppressWarnings("deprecation")
    public final static String changeMapToQueryString(Map<String, String> params, String charset, boolean needEncode, boolean keepBlankValue) {
        if (null == params || params.isEmpty()) {
            return "";
        }
        if (StringUtil.isBlank(charset)) {
            charset = Constants.DEFAULT_CHARSET;
        }

        StringBuilder sb = new StringBuilder("");
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        int count = keys.size();

        for (int i = 0; i < count; i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (needEncode) {
                try {
                    if (StringUtil.isNotBlank(value)) {
                        value = URLEncoder.encode(value, charset);
                    }
                } catch (UnsupportedEncodingException ex) {
                    if (StringUtil.isNotBlank(value)) {
                        value = URLEncoder.encode(value);
                    }
                }
            }
            if (StringUtil.isNotBlank(key) && (StringUtil.isNotBlank(value) || keepBlankValue)) {
                //防止null对象变成"null"
                if (StringUtil.isBlank(value)) {
                    value = "";
                }
                sb.append(key).append(Constants.DELIMITER_EQUAL).append(value).append(Constants.DELIMITER_AMP);
            }
        }

        String query = sb.toString();
        return StringUtil.chomp(query, Constants.DELIMITER_AMP);
    }

    /**
     * 将params中的key和value组装成url参数形式(去掉空白的value)
     * @param params Map<String, String>
     * @param charset URLEncoder.encode()使用, 默认Constants.DEFAULT_CHARSET
     * @return String "key1=value1&key2=value2&key3=value3....", 默认""
     */
    @SuppressWarnings("deprecation")
    public final static String changeMapToQueryString(Map<String, String> params, String charset) {
        return changeMapToQueryString(params, charset, true, false);
    }

    /**
     * 将url参数字符串转换成map
     * @param query String "key1=value1&key2=(空白value)&key3=value3...."; key的名字不能相同, 否则覆盖
     * @param charset 默认Constants.DEFAULT_CHARSET
     * @param needDecode 是否对value使用URLDecoder.decode()
     * @param keepBlankValue 是否保留空白value到map中
     * @return Map<String, String>, 默认null
     */
    @SuppressWarnings("deprecation")
    public final static Map<String, String> changeQueryStringToMap(String query, String charset, boolean needDecode, boolean keepBlankValue) {
        if (StringUtil.isBlank(query)) {
            return null;
        }
        if (StringUtil.isBlank(charset)) {
            charset = Constants.DEFAULT_CHARSET;
        }

        String[] entrys = StringUtil.split(query, Constants.DELIMITER_AMP);
        if (null == entrys || 0 == entrys.length) {
            return null;
        }

        Map<String, String> params = new HashMap<String, String>();
        for (String entry : entrys) {
            String[] keyValue = StringUtil.split(entry, Constants.DELIMITER_EQUAL,2);
            if (null == keyValue || 0 == keyValue.length) {
                continue;
            }

            String key = keyValue[0];
            if(1 == keyValue.length) {
                if (keepBlankValue) {
                    params.put(key, null);
                }
                continue;
            }

            String value = keyValue[1];
            if (2 == keyValue.length) {
                if (needDecode) {
                    try {
                        if (StringUtil.isNotBlank(value)) {
                            value = URLDecoder.decode(value, charset);
                        }
                    } catch (UnsupportedEncodingException ex) {
                        if (StringUtil.isNotBlank(value)) {
                            value = URLDecoder.decode(value);
                        }
                    }
                }
                params.put(key, value);
            }
        }

        return params;
    }

    /**
     * 将url参数字符串转换成map(保留空白的value)
     * @param query String "key1=value1&key2=value2&key3=value3...."; key的名字不能相同, 否则覆盖
     * @param charset 默认Constants.DEFAULT_CHARSET
     * @param needDecode 是否对value使用URLDecoder.decode()
     * @return Map<String, String>, 默认null
     */
    @SuppressWarnings("deprecation")
    public final static Map<String, String> changeQueryStringToMap(String query, String charset, boolean needDecode) {
        return changeQueryStringToMap(query, charset, needDecode, true);
    }

    /**
     * 将url参数字符串转换成map
     * @param query String "key1=value1&key2=value2&key3=value3...."; key的名字不能相同, 否则覆盖
     * @param charset URLDecoder.decode()使用, 默认Constants.DEFAULT_CHARSET
     * @return Map<String, String>, 默认null
     */
    @SuppressWarnings("deprecation")
    public final static Map<String, String> changeQueryStringToMap(String query, String charset) {
        return changeQueryStringToMap(query, charset, true);
    }
}
