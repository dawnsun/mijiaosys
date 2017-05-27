package com.mijiaokj.sys.common.util;

/**
 * Created by sunchenguang on 2017/5/27.
 */
public class StringUtil {
    public StringUtil() {
    }

    public static String clearXmlDestroy(String string) {
        if(null != string && string.length() > 0) {
            string = string.toString().replace("\"", "&quot;").replace("\'", "&apos;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&(?!(amp;|apos;|quot;|gt;|lt;))", "&amp;");
        }

        return string;
    }

    public static String clearXSS(String string) {
        if(null != string && string.length() > 0) {
            string = string.toString().replaceAll("\\<\\s*script", "&lt;script");
        }

        return string;
    }

    public static String clearScriptDestroy(String string) {
        if(null != string && string.length() > 0) {
            string = string.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }

        return string;
    }

    public static String getFileSeparator() {
        return System.getProperties().getProperty("file.separator");
    }

    public static String filterQuote(String str) {
        if("\"".equals(str)) {
            return "";
        } else {
            int len = str.length();
            return len <= 2 || !str.startsWith("\"") && !str.startsWith("\'")?str:str.substring(1, len - 2);
        }
    }
}
