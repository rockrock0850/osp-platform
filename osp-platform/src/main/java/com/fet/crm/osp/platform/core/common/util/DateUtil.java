/**
 * Copyright (c) 2017 Far Eastone Telecommunications Co., Ltd.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of 
 * Far Eastone Telecommunications Co., Ltd. ("Confidential Information"). 
 * 
 * You shall not disclose such Confidential Information and shall use it 
 * only in accordance with the terms of license agreement you entered
 * into with Far Eastone Telecommunications Co., Ltd.
 */

package com.fet.crm.osp.platform.core.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期處理 工具類別
 * 
 * @author PaulChen, Adam Yeh
 */
public class DateUtil {
	
	public static final String DATE_SLASH_PATTERN = "yyyy/MM/dd";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_OF_MONTH_DAYS_SLASH_PATTERN = "MM/dd";
	public static final String DATE_TIME_PATTERN_FOR_FILE_NAME = "yyyyMMddHHmmss";
	
	public static final Map<String, String> FULL_MONTHLY_MP = new LinkedHashMap<String, String>();
	static {
		// 初使化月份
        for (int i = 1; i < 13; i++) {
        	String key = String.format("%02d", i);
        	String value = key;
        	
        	FULL_MONTHLY_MP.put(key, value);
        }
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param dt
	 * @return String
	 */
	public static String fromDate(Date dt) {
		return fromDate(dt, DATE_PATTERN);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param dt
	 * @param pattern
	 * @return String
	 */
	public static String fromDate(Date dt, String pattern) {
		if(dt == null) {
			return StringUtils.EMPTY;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dt); 
	}
	
	/**
     * 將日期字串「yyyy-MM-dd HH:mm:ss」轉為Date物件
     * 
     * @param dateTime
     * @return Date
     */
    public static Date toDateTime(String dateTime) {
        return toDate(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Transform date string to Date object
     * 
     * @param date
     * @param date_format
     * @return Date
     */
    public static Date toDate(String date, String date_format) {
		if (StringUtils.isBlank(date)) {
			return null;
		}

        try {
        	SimpleDateFormat format = new SimpleDateFormat(date_format);
            Date s_date = format.parse(date);
            
            return s_date;
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        
        return new Date();
    }
    
    /**
     * 取得當下系統時間毫秒
     * 
     * @author Adam
     * @create date: Apr 21, 2017
     *
     * @return String
     */
    public static String getMillisTime() {
    	return String.valueOf(System.currentTimeMillis());
    }
  
}
