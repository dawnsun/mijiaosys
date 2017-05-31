package com.mijiaokj.sys.common.util;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public class DateUtil {
    /** 空字符串。 */
    public static final String EMPTY_STRING = "";

    /**
     * 默认日期格式
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 默认日期（含时间）格式
     */
    public final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    public static final DateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_FORMAT);


    /**
     * 日期转字符串
     *
     * @param date   日期对象
     * @param format 格式字符串
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (StringUtil.isEmpty(format) || date == null) {
            return EMPTY_STRING;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String formatDateYmdHms(Date date) {
        return DateFormatUtils.format(date, DATETIME_FORMAT);
    }

    /**
     * 两个日期是否相等，精确到日
     * 例： 2015-07-21 12:00:00 = 2015-07-21 02:00:00
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqualByDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 判断是否为今天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        Date now = Calendar.getInstance().getTime();
        return DateUtil.isEqualByDay(date, now);
    }

    /**
     * 获取某一天的0点
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某一天的终点，即23点59分59秒999毫秒
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     * @Description: String类型毫秒数转换成日期
     */
    public static String stringToDate(String lo) {
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat(DATETIME_FORMAT);
        return sd.format(date);
    }

    public static Date stringConvert2Date(String strDate) {
        if (strDate == null || "".equals(strDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * String类型毫秒数 转换为日期的小时
     *
     * @param millisecond 毫秒数
     * @return
     */
    public static int stringToHourOfDay(String millisecond) {
        long time = Long.parseLong(millisecond);
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定时间的小时
     *
     * @param date
     * @return
     */
    public static int hourOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前分钟
     *
     * @param date
     * @return
     */
    public static int minuteOfHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取今天的0点
     */
    public static Date getStartTimeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得昨天（当前日期减一天）
     *
     * @return Calendar对象（加一天）
     */
    public static Date yesterday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    /**
     * 把 yyyy-MM-dd HH:mm:ss 格式转换为Date格式
     *
     * @return Date
     */
    public static Date parseYyyyMMddHHmmss(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            logger.error("parseYyyyMMddHHmmss.error", e);
            return null;
        }
        return date;
    }

    /**
     * 比较开始时间与结束时间
     * 结束时间比开始时间早返回true 否则返回false
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public static Boolean isBefore(String startTime, String endTime) throws Exception {
        if(dateTimeFormat.parse(endTime).before(dateTimeFormat.parse(startTime))){
            return true;
        }
        return false;
    }

   /* public static void main(String[] args) {
        System.out.println(isToday(new Date()));
        //    	System.out.println(DateUtil.stringToDate("1444766400000"));
        //    	System.out.println(DateUtil.stringToHourOfDay("1441713000000"));
        //
        //    	Map<Integer, Long> map = newTreeMap();
        //		map.put(123, 1L);
        //		map.put(223, 1L);
        //		map.put(23, 1L);
        //		System.out.println(map);
        //
        //		Map<Integer, Long> map2 = newTreeMap();
        //		map2.put(1123, 1L);
        //		map2.put(2223, 1L);
        //		map2.put(23, 1L);
        //		System.out.println(map);
        //
        //		Multimap<Integer, Long> multimap = TreeMultimap.create();
        //
        //		Date date = CalendarUtil.getCurrentDate();
        //		System.out.println(CalendarUtil.toString(date, "hh:mm"));
        System.out.println(DateUtil.getStartTimeOfToday());

    }*/
}
