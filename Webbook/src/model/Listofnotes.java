package model;

public class Listofnotes {
	
	int mainnoteid;
	
	String mainnotetype;
	
	String mainnotetitle;
	
	String username;
	
	String createtime;
	
	int quotecount;
	
	int viewcount;
	
	String replynotename;
	
	String maxcreatetime;

	public int getMainnoteid() {
		return mainnoteid;
	}

	public void setMainnoteid(int mainnoteid) {
		this.mainnoteid = mainnoteid;
	}

	public String getMainnotetype() {
		return mainnotetype;
	}

	public void setMainnotetype(String mainnotetype) {
		this.mainnotetype = mainnotetype;
	}

	public String getMainnotetitle() {
		return mainnotetitle;
	}

	public void setMainnotetitle(String mainnotetitle) {
		this.mainnotetitle = mainnotetitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getQuotecount() {
		return quotecount;
	}

	public void setQuotecount(int quotecount) {
		this.quotecount = quotecount;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getReplynotename() {
		return replynotename;
	}

	public void setReplynotename(String replynotename) {
		this.replynotename = replynotename;
	}

	public String getMaxcreatetime() {
		return maxcreatetime;
	}

	public void setMaxcreatetime(String maxcreatetime) {
		this.maxcreatetime = maxcreatetime;
	}

	public Listofnotes(int mainnoteid, String mainnotetype, String mainnotetitle, String username,
			String createtime, int quotecount, int viewcount, String replynotename, String maxcreatetime) {
		super();
		this.mainnoteid = mainnoteid;
		this.mainnotetype = mainnotetype;
		this.mainnotetitle = mainnotetitle;
		this.username = username;
		this.createtime = createtime;
		this.quotecount = quotecount;
		this.viewcount = viewcount;
		this.replynotename = replynotename;
		this.maxcreatetime = maxcreatetime;
	}
	
	

}
