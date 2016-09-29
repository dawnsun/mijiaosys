package com.mijiaokj.sys.common.constants;

public class BaseConstant {
	/**
	 * 类LcpConstant.java的实现描述：逻辑删除字段
	 *
	 * @author jinwen.zjw 2016年8月27日 上午11:49:17
	 */
	public interface isDelete {
		/**
		 * 删除 -1
		 */
		int yes = 1;

		/**
		 * 未删除，正常 -0
		 */
		int no = 0;
	}

	public static final String SYS = "SYS";
}
