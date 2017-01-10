package model;

import java.util.List;

public class PageBean<T> { //泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
	
	private int pc;//当前页面的页码数；页面传来；
	
	private int ps;//当前页面的记录数，自己定义；
	
	private int all;//数据库查询得到的总记录数；
	
	private String url;//页面的路径，数据库查询；
	
	private List<T> beanList;//以上数据的集合；
	
	/**
	 * 创建方法，获取最大页数
	 * 总记录数all除以当前页面记录数ps取整数tp；
	 * 如果有余数，页码数加一 tp+=1；
	 * @return
	 */
	
	public int getTp(){         
		int tp = all/ps;
		return all%ps == 0 ? tp:tp+1;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
