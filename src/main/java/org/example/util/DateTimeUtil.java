package org.example.util;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeUtil {
    // 使用预定义的格式。预定义的常量为 FormatStyle类的 SHORT、MEDIUM、LONG、FULL
    // 只能格式化日期部分
    private static DateTimeFormatter DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    // 只能格式化时间部分
    private static DateTimeFormatter TIME = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
    // 格式化日期时间部分
    private static DateTimeFormatter DATE_TIME = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.LONG);
    // 自定义格式化
    private static DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter HH_MM_SS = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter YYYY_MM_DD_HH_MM_SS_S = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private static DateTimeFormatter YYYY_MM_DD_HH_MM_SS_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");

    /**
     * 获取当前系统日期时间
     * @return 返回日期时间字符串
     */
    public static String getCurrentDateTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return YYYY_MM_DD_HH_MM_SS.format(currentDateTime);
    }

    /**
     * 获取当前系统日期时间，精确到一位毫秒
     * @return 返回日期时间字符串
     */
    public static String getCurrentDateTimeS(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return YYYY_MM_DD_HH_MM_SS_S.format(currentDateTime);
    }

    /**
     * 获取当前系统日期时间，精确到两位毫秒
     * @return 返回日期时间字符串
     */
    public static String getCurrentDateTimeSS(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return YYYY_MM_DD_HH_MM_SS_SS.format(currentDateTime);
    }

    /**
     * 获取当前系统日期
     * @return 返回日期字符串
     */
    public static String getDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return YYYY_MM_DD.format(currentDateTime);
    }

    /**
     * 获取当前系统时间
     * @return 返回时间字符串
     */
    public static String getTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return HH_MM_SS.format(currentDateTime);
    }

    /**
     * 格式化指定日期时间字符串
     * @param dateTime 待格式化的日期时间字符串
     * @param formatter 日期时间字符串的日期时间格式
     * @return 返回默认的日期时间格式字符串
     */
    public static String getDateTime(String dateTime,DateTimeFormatter formatter){
        LocalDateTime newDateTime = LocalDateTime.parse(dateTime,formatter);
        return YYYY_MM_DD_HH_MM_SS.format(newDateTime);
    }

    /**
     * 格式化指定日期字符串
     * @param date 待格式化的日期字符串
     * @param formatter 日期字符串的日期格式
     * @return 返回默认的日期格式字符串
     */
    public static String getDate(String date, DateTimeFormatter formatter){
        LocalDate newDate = LocalDate.parse(date,formatter);
        return YYYY_MM_DD.format(newDate);
    }

    /**
     * 格式化指定时间字符串
     * @param time 待格式化的时间字符串
     * @param formatter 时间字符串的时间格式
     * @return 返回默认的时间格式字符串
     */
    public static String getTime(String time, DateTimeFormatter formatter){
        LocalTime newTime = LocalTime.parse(time,formatter);
        return HH_MM_SS.format(newTime);
    }

    /**
     * 指定日期时间添加指定年、月、天、时、分、秒数
     * @param dateTime 指定日期时间
     * @param formatter 指定日期时间格式
     * @param years 修改年
     * @param months 修改月
     * @param days 修改天
     * @param hours 修改小时
     * @param minutes 修改分钟
     * @param seconds 修改秒
     * @return 返回修改后的日期时间字符串
     */
    public static String getPlusDateTime(String dateTime, DateTimeFormatter formatter, int years, int months, int days, int hours, int minutes, int seconds){
        LocalDateTime newDateTime = LocalDateTime.parse(dateTime, formatter);
        newDateTime = newDateTime.plusYears(years)
                .plusMonths(months)
                .plusDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds);
        return YYYY_MM_DD_HH_MM_SS.format(newDateTime);
    }

    /**
     * 指定日期添加指定年、月、天数
     * @param date 指定日期
     * @param formatter 指定日期格式
     * @param years 修改年
     * @param months 修改月
     * @param days 修改天
     * @return 返回修改后的日期字符串
     */
    public static String getPlusDate(String date, DateTimeFormatter formatter, int years, int months, int days){
        LocalDate newDate = LocalDate.parse(date, formatter);
        newDate = newDate.plusYears(years)
                .plusMonths(months)
                .plusDays(days);
        return YYYY_MM_DD.format(newDate);
    }
}
