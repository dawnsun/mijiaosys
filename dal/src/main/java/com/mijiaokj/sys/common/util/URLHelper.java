package com.mijiaokj.sys.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 提供URL内容整理的工具
 * Created by sunchenguang on 2017/5/31.
 */
public class URLHelper {
    /**
     * 将一个URL中的参数转换成一个Map
     * @param url
     * @param decode
     * @return
     */
    public static Map getParams(String url, String decode) {
        Map params = new HashMap();

        if (StringUtil.isNotEmpty(url)) {
            int indexOfQuery = url.indexOf("?");

            if (indexOfQuery > 0) {
                String   query = url.substring(indexOfQuery + 1);
                String[] exprs = StringUtil.split(query, '&');

                for (int i = 0; i < exprs.length; i++) {
                    String[] keyValue = StringUtil.split(exprs[i], '=');

                    if (keyValue.length == 2) {
                        try {
                            String value = URLDecoder.decode(keyValue[1], decode);

                            params.put(keyValue[0], value);
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                }
            }
        }

        return params;
    }

    /**
     * 将一个map转成一个URL参数的字符串
     * @param params
     * @param encode
     * @return
     */
    public static String getQuery(Map params, String encode) {
        StringBuffer query = new StringBuffer();

        for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
            String name  = (String) iter.next();
            String value = (String) params.get(name);

            try {
                value = URLEncoder.encode(value, encode);
            } catch (UnsupportedEncodingException e) {
            }

            query.append(name);
            query.append("=");
            query.append(value);
            query.append("&");
        }

        return query.toString();
    }
}
