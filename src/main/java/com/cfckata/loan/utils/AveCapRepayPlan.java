package com.cfckata.loan.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @category 等额本金
 * @author zyb
 *
 */
public class AveCapRepayPlan implements RepayPlanBase {

	/**  
     * 计算获取还款方式为等额本金的每期偿还本金和利息  
     *   
     * 公式：每期偿还本金=(贷款本金÷还款期数)+(贷款本金-已归还本金累计额)×期利率  
     *   
     * @param invest  
     *            总借款额（贷款本金）  
     * @param periodRate  
     *            年利率  
     * @param periodNum  
     *            还款总期数  
     * @return 每期偿还本金和利息,四舍五入
     */  
    public static Map<Integer, BigDecimal> getPerPeriodPrincipalInterest(BigDecimal invest, BigDecimal periodRate, int periodNum) {  
        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();  
        // 每期本金  
        BigDecimal period = getPerPeriodPrincipal(invest, periodNum);  
        // 获取期利率  
        periodRate = periodRate.setScale(6, BigDecimal.ROUND_HALF_UP);  
        for (int i = 1; i <= periodNum; i++) { 
        	BigDecimal loanBal = period.multiply(new BigDecimal(i - 1));
        	BigDecimal intAmt = invest.subtract(loanBal).multiply(periodRate);
        	BigDecimal monthRes = period.add(intAmt);  
            monthRes = monthRes.setScale(4, BigDecimal.ROUND_HALF_UP);  
            map.put(i, monthRes);  
        }  
        return map;  
    }  

    /**
	 * 等额本金计算获取还款方式为等额本金的每期偿还本金
	 * 
	 * 公式：每期应还本金=贷款本金÷还款期数
	 * 
	 * @param invest    总借款额（贷款本金）
	 * @param periodNum 还款总期数
	 * @return 每期偿还本金
	 */
	public static BigDecimal getPerPeriodPrincipal(BigDecimal invest, int periodNum) {
		BigDecimal monthIncome = invest.divide(new BigDecimal(periodNum), 4, BigDecimal.ROUND_HALF_UP);
		return monthIncome;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的总利息
	 * 
	 * @param invest     总借款额（贷款本金）
	 * @param periodRate 年利率
	 * @param periodNum  还款总期数
	 * @return 总利息
	 */
	public static BigDecimal getInterestCount(BigDecimal invest, BigDecimal periodRate, int periodNum) {
		BigDecimal count = new BigDecimal(0);
		Map<Integer, BigDecimal> mapInterest = getPerPeriodInterest(invest, periodRate, periodNum);

		for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
			count = count.add(entry.getValue());
		}
		return count;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每期偿还利息
	 * 
	 * 公式：每期应还利息=剩余本金×期利率=(贷款本金-已归还本金累计额)×期利率
	 * 
	 * @param invest     总借款额（贷款本金）
	 * @param periodRate 年利率
	 * @param periodNum  还款总期数
	 * @return 每期偿还利息
	 */
	public static Map<Integer, BigDecimal> getPerPeriodInterest(BigDecimal invest, BigDecimal periodRate, int periodNum) {
		Map<Integer, BigDecimal> inMap = new HashMap<Integer, BigDecimal>();
		BigDecimal principal = getPerPeriodPrincipal(invest, periodNum);
		Map<Integer, BigDecimal> map = getPerPeriodPrincipalInterest(invest, periodRate, periodNum);
		for (Map.Entry<Integer, BigDecimal> entry : map.entrySet()) {
			BigDecimal principalBigDecimal = principal;
			BigDecimal principalInterestBigDecimal = entry.getValue();
			BigDecimal interestBigDecimal = principalInterestBigDecimal.subtract(principalBigDecimal);
			interestBigDecimal = interestBigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			inMap.put(entry.getKey(), interestBigDecimal);
		}
		return inMap;
	}

	/**
	 * 本息总和
	 * 
	 * @param invest     本金
	 * @param periodRate 期利率
	 * @param periodNum  期数
	 * @return
	 */
	public static BigDecimal getPrincipalInterestCount(BigDecimal invest, BigDecimal periodRate, int periodNum) {
		BigDecimal perMonthInterest = invest;
		Map<Integer, BigDecimal> mapInterest = getPerPeriodInterest(invest, periodRate, periodNum);
		for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
			perMonthInterest = perMonthInterest.add(entry.getValue());
		}
		return perMonthInterest;
	}

	/**
	 * 每期还款日期
	 * 
	 * @param start_date        起租日
	 * @param perPeriodMonthNum 每期月数
	 * @param periodNum         期数
	 * @return
	 */
	public static Map<Integer, String> getRepaymentDate(String start_date, int perPeriodMonthNum, int periodNum) {
		Map<Integer, String> periodRepaymentDate = new HashMap<Integer, String>();
		String nextRepaymentDate = start_date;
		periodRepaymentDate.put(1, nextRepaymentDate);
		for (int i = 2; i < periodNum + 1; i++) {
			nextRepaymentDate = getMonthAdd(perPeriodMonthNum, nextRepaymentDate, "yyyyMMdd");
			periodRepaymentDate.put(i, nextRepaymentDate);
		}
		return periodRepaymentDate;
	}

	/**
	 * 功能描述：返回指定日期加上多少月之后的时间<BR>
	 * 
	 * @param from      yyyyMMdd
	 * @param day
	 * @param formatStr
	 * @return
	 */
	public static String getMonthAdd(int day, String from, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(from));
		} catch (Exception e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.MONTH, day);
		String date = sdf.format(calendar.getTime());
		return date;
	}
	

	@Override
	public Map<Integer, BigDecimal> doRepayPlan(BigDecimal loanAmt, BigDecimal intRate ,Integer loanTerm) {
		Map<Integer, BigDecimal> getPerMonthPrincipalInterest = getPerPeriodPrincipalInterest(loanAmt, intRate,
				loanTerm);
		return getPerMonthPrincipalInterest;
	}


//	public static void main(String[] args) {
//		BigDecimal invest = new BigDecimal("10000"); // 本金
//		int periodNum = 4;
//		BigDecimal periodRate = new BigDecimal("0.01");
////		double periodRate = 0.12 / 3; 
//		RepayPlanBase repayPlan = new AveCapRepayPlan();
//		Map<Integer, BigDecimal> getPerMonthPrincipalInterest = repayPlan.doRepayPlan(invest, periodRate,
//				periodNum);
//		System.out.println("等额本金---每期本息：" + getPerMonthPrincipalInterest);
//		BigDecimal benjin = getPerPeriodPrincipal(invest, periodNum);
//		System.out.println("等额本金---每期本金:" + benjin);
//		Map<Integer, BigDecimal> mapInterest = getPerPeriodInterest(invest, periodRate, periodNum);
//		System.out.println("等额本金---每期利息:" + mapInterest);
//		BigDecimal count = getInterestCount(invest, periodRate, periodNum);
//		System.out.println("等额本金---总利息：" + count);
//		BigDecimal principalInterestCount = getPrincipalInterestCount(invest, periodRate, periodNum);
//		System.out.println("等额本金---本息：" + principalInterestCount);
//	}

}
