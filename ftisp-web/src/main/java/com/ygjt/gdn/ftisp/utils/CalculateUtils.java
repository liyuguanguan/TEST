package com.ygjt.gdn.ftisp.utils;

import java.math.BigDecimal;

/**
 * 
 * 数值计算工具类
 * 
 * @author </a href="mailto:jinwx@yintong.com.cn">jinwx</a>
 * @version $Id: CalculateUtils.java, v 0.1 Jun 27, 2014 11:14:55 AM jinwx Exp $
 * @since 1.0
 */
public class CalculateUtils {
	
	/**标记四舍五入*/
	public static final int ROUND_HALF_UP = 4;
	/**标记直接舍弃*/
	public static final int ROUND_DOWN = 1;
	/**直接入*/
	public static final int ROUND_UP = 0;
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @param roundingMode 5:四舍五入 1:舍弃
	 * @return
	 * @author jinwx
	 */
	public static String multiply(String multiplier, String multiplicand,
			int scale, int roundingMode) {
		return new BigDecimal(multiplier)
				.multiply(new BigDecimal(multiplicand))
				.setScale(scale, roundingMode).toString();
	}
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @param roundingMode 5:四舍五入 1:舍弃
	 * @return
	 * @author jinwx
	 */
	public static String multiply(Object multiplier, Object multiplicand,
			int scale, int roundingMode) {
		return multiply(String.valueOf(multiplier), String.valueOf(multiplicand), scale);

	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String divide(String dividend,String divisor,int scale,int roundingMode){
		return new BigDecimal(dividend).divide(new BigDecimal(divisor),scale,roundingMode).toString();
	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String divide(Object dividend,Object divisor,int scale,int roundingMode){
		return divide(String.valueOf(dividend), String.valueOf(divisor), scale,roundingMode);	
		}
	
	public static void main(String[] args) {
//		System.out.println(CalculateUtils.divide(new BigDecimal("0.1"), 10, 4, 1));
//		System.out.println(CalculateUtils.divide(new BigDecimal("0.1"), 3, 4, 1));
//		System.out.println(CalculateUtils.divide(new BigDecimal("0.1"), 2, 4, 1));
//		System.out.println(CalculateUtils.divide(new BigDecimal("0.1"), 6, 4, 1));
//		System.out.println(CalculateUtils.divide(new BigDecimal("0.1"), 7, 4, 1));
		
//		System.out.println(Integer.parseInt(CalculateUtils.subtract(0, 1L, 0))>0);
//		System.out.println(Integer.parseInt(CalculateUtils.subtract(0, -1L, 0))>0);
		
//		long subtract = Long.parseLong(CalculateUtils.subtract(0, 27198242165100000L, 0));
//		if(subtract>0L){
//			System.out.println("1234");
//		}


		System.out.println(subtract(1,null,0));
	}
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String add(String augend,String addend,int scale,int roundingMode){
		return new BigDecimal(augend).add(new BigDecimal(addend)).setScale(scale, roundingMode).toString();

	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String add(Object augend,Object addend,int scale,int roundingMode){
		return add(String.valueOf(augend), String.valueOf(addend), scale,roundingMode);
	}
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String subtract(String minuend,String subtrahend,int scale,int roundingMode){
		return new BigDecimal(minuend).subtract(new BigDecimal(subtrahend)).setScale(scale, roundingMode).toString();

	}
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static String subtract(Object minuend,Object subtrahend,int scale,int roundingMode){
		return subtract(String.valueOf(minuend), String.valueOf(subtrahend), scale,roundingMode);
	}	
	
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @return
	 * @author jinwx
	 */
	public static String multiply(String multiplier, String multiplicand,
			int scale) {
		return new BigDecimal(multiplier)
				.multiply(new BigDecimal(multiplicand))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @return
	 * @author jinwx
	 */
	public static String multiply(Object multiplier, Object multiplicand,
			int scale) {
		return multiply(String.valueOf(multiplier), String.valueOf(multiplicand), scale);
	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String divide(String dividend,String divisor,int scale){
		return new BigDecimal(dividend).divide(new BigDecimal(divisor),scale,BigDecimal.ROUND_HALF_UP).toString();
	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String divide(Object dividend,Object divisor,int scale){
		return divide(String.valueOf(dividend), String.valueOf(divisor), scale);
	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String add(String augend,String addend,int scale){
		return new BigDecimal(augend).add(new BigDecimal(addend)).setScale(scale,  BigDecimal.ROUND_HALF_UP).toString();

	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String add(Double augend,Double addend,int scale){
		return add(String.format("%.0f", augend), String.format("%.0f", addend), scale);
	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String add(Number augend,Number addend,int scale){
		if(augend==null){
			augend=0;
		}
		if(addend==null){
			addend=0;
		}
		return add(String.valueOf(augend), String.valueOf(addend), scale);
	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String add(Object augend,Object addend,int scale){

		return add(String.valueOf(augend), String.valueOf(addend), scale);
	}
	
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String subtract(String minuend,String subtrahend,int scale){

		return new BigDecimal(minuend).subtract(new BigDecimal(subtrahend)).setScale(scale,  BigDecimal.ROUND_HALF_UP).toString();

	}
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static String subtract(Object minuend,Object subtrahend,int scale){
		if(minuend==null){
			minuend="0.0";
		}
		if(subtrahend==null){
			subtrahend="0.0";
		}
		return subtract(String.valueOf(minuend), String.valueOf(subtrahend), scale);
	}
	
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @param roundingMode 5:四舍五入 1:舍弃
	 * @return
	 * @author jinwx
	 */
	public static Double multiply_d(String multiplier, String multiplicand,
			int scale, int roundingMode) {
		return new BigDecimal(multiplier)
				.multiply(new BigDecimal(multiplicand))
				.setScale(scale, roundingMode).doubleValue();
	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static Double divide_d(String dividend,String divisor,int scale,int roundingMode){
		return new BigDecimal(dividend).divide(new BigDecimal(divisor)).setScale(scale, roundingMode).doubleValue();
	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static Double add_d(String augend,String addend,int scale,int roundingMode){
		return new BigDecimal(augend).add(new BigDecimal(addend)).setScale(scale, roundingMode).doubleValue();

	}
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @param roundingMode
	 * @return
	 * @author jinwx
	 */
	public static Double subtract_d(String minuend,String subtrahend,int scale,int roundingMode){
		return new BigDecimal(minuend).subtract(new BigDecimal(subtrahend)).setScale(scale, roundingMode).doubleValue();

	}
	
	
	/**
	 * 
	 * @param multiplier 乘数
	 * @param multiplicand 被乘数
	 * @param scale   结果小数保留位数
	 * @return
	 * @author jinwx
	 */
	public static Double multiply_d(String multiplier, String multiplicand,
			int scale) {
		return new BigDecimal(multiplier)
				.multiply(new BigDecimal(multiplicand))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static Double divide_d(String dividend,String divisor,int scale){
		return new BigDecimal(dividend).divide(new BigDecimal(divisor),scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * @param augend 被加数
	 * @param addend 加数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static Double add_d(String augend,String addend,int scale){
		return new BigDecimal(augend).add(new BigDecimal(addend)).setScale(scale,  BigDecimal.ROUND_HALF_UP).doubleValue();

	}
	
	/**
	 * 
	 * @param minuend 被减数
	 * @param subtrahend  减数
	 * @param scale
	 * @return
	 * @author jinwx
	 */
	public static Double subtract_d(String minuend,String subtrahend,int scale){
		return new BigDecimal(minuend).subtract(new BigDecimal(subtrahend)).setScale(scale,  BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public static Double calculateSingleVolumn(Double regLength,Double regWidth ,Double regHeight){
		return Double.valueOf(CalculateUtils.multiply(CalculateUtils.multiply(regLength,regWidth,4),regHeight,4));
	}
	
}
