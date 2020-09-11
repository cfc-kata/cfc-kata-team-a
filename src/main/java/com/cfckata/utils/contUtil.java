package com.cfckata.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class contUtil {

	private static int AGE_18 = 18;
	private static int AGE_20 = 20;
	private static int AGE_30 = 30;
	private static int AGE_50 = 50;
	private static int AGE_60 = 60;
	private static int AGE_70 = 70;
	/**
	 * 18岁以下
	 */
	private static int CUSTLEVEL_0 = 0;

	/**
	 * 18岁到20岁
	 */
	private static int CUSTLEVEL_1 = 1;

	/**
	 * 20岁到30岁
	 */
	private static int CUSTLEVEL_2 = 2;

	/**
	 * 30岁到50岁
	 */
	private static int CUSTLEVEL_3 = 3;

	/**
	 * 50岁到60岁
	 */
	private static int CUSTLEVEL_4 = 4;

	/**
	 * 60岁到70岁
	 */
	private static int CUSTLEVEL_5 = 5;

	/**
	 * 70岁以上
	 */
	private static int CUSTLEVEL_6 = 6;

	private static BigDecimal QUOTA_1 = new BigDecimal("10000");
	private static BigDecimal QUOTA_2 = new BigDecimal("50000");
	private static BigDecimal QUOTA_3 = new BigDecimal("200000");
	private static BigDecimal QUOTA_4 = new BigDecimal("30000");
	private static BigDecimal QUOTA_5 = new BigDecimal("10000");
	private static BigDecimal QUOTA_6 = new BigDecimal("0");

	private static BigDecimal QUOTA_RATE = new BigDecimal("0.36");
	private static int QUOTA_MATUDATE = 2;

	/**
	 * 
	 * @param idnumber
	 * @param interestRate
	 * @param maturityDate
	 * @param commitMent
	 */
	public static void checkCont(String idNumber, BigDecimal interestRate, String maturityDate, BigDecimal commitMent) {
		// 1.校验年利率
		if (interestRate != null) {
			checkRate(interestRate);
		}
		// 2.检查期限
		if (!StringUtils.isEmpty(maturityDate)) {
			checkMatuDate(maturityDate);
		}
		// 3.根据idNumber获取客户年龄
		if (!StringUtils.isEmpty(idNumber)) {

			int age = idNoToAge(idNumber);
			// 4.根据客户年龄获取客户级别
			int custLevel = getCustLevel(age);
			// 5.进行校验总额度
			if (commitMent != null) {
				checkCommitMent(custLevel, commitMent);
			}
		}
	}

	/**
	 * 检查期限
	 * 
	 * @param interestRate
	 */
	public static void checkMatuDate(String maturityDate) {
		int interval = getInterval(maturityDate);
		if (QUOTA_MATUDATE < interval) {
			log.error("年化利率超限,请检查!到期日:{},期限限额{}", maturityDate, QUOTA_MATUDATE);
			// TODO 抛出异常
		}
	}

	public static void checkRate(BigDecimal interestRate) {
		if (QUOTA_RATE.compareTo(interestRate) == -1) {
			log.error("年化利率超限,请检查!年利率:{},年利率限额{}", interestRate, QUOTA_RATE);
			// TODO 抛出异常
		}
	}

	/**
	 * 校验额度
	 * 
	 * @param custLevel
	 * @param commitMent
	 */
	public static void checkCommitMent(int custLevel, BigDecimal commitMent) {
		switch (custLevel) {
		case 1:
			checkQuota(commitMent, QUOTA_1);
			break;
		case 2:
			checkQuota(commitMent, QUOTA_2);
			break;
		case 3:
			checkQuota(commitMent, QUOTA_3);
			break;
		case 4:
			checkQuota(commitMent, QUOTA_4);
		case 5:
			checkQuota(commitMent, QUOTA_5);
		case 6:
			checkQuota(commitMent, QUOTA_6);
			break;
		default:
			// 18岁以下
			break;
		}
	}

	/**
	 * 限额校验
	 * 
	 * @param custLevel
	 * @param commitMent
	 */
	public static void checkQuota(BigDecimal commitMent, BigDecimal quota) {
		if (quota.compareTo(commitMent) == -1) {
			log.error("额度超限,请检查!额度为:{},限额为:{}", commitMent, quota);
			// TODO 抛出异常
		}
	}

	/**
	 * 根据客户年龄分级别
	 * 
	 * @param age
	 * @return
	 */
	public static int getCustLevel(int age) {
		if (AGE_18 <= age && age < AGE_20) {
			return CUSTLEVEL_1;
		} else if (AGE_20 <= age && age < AGE_30) {
			return CUSTLEVEL_2;
		} else if (AGE_30 <= age && age < AGE_50) {
			return CUSTLEVEL_3;
		} else if (AGE_50 <= age && age < AGE_60) {
			return CUSTLEVEL_4;
		} else if (AGE_60 <= age && age < AGE_70) {
			return CUSTLEVEL_5;
		} else if (AGE_70 <= age) {
			return CUSTLEVEL_6;
		}
		return CUSTLEVEL_0;
	}

	/**
	 * 根据证件号码获取客户年龄
	 * 
	 * @param idNO
	 * @return
	 */
	public static int idNoToAge(String idNo) {
		int leh = idNo.length();
		int age = 0;
		String dates = "";
		if (leh == 18) {
			dates = idNo.substring(6, 10);
			age = getInterval(dates);
			return age;
		}
		return age;
	}

	/**
	 * 根据时间获取与当前时间的间隔
	 * 
	 * @param date
	 * @return
	 */
	public static int getInterval(String date) {
		SimpleDateFormat df = null;
		if (date.contains("-")) {
			df = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			df = new SimpleDateFormat("yyyyMMdd");
		}
		String year = df.format(new Date());
		int interval = Integer.parseInt(year) - Integer.parseInt(date);
		return interval;
	}

}
