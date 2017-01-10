package model;


public class Note {
	
	private int id;//自增主键
	
	private int mainnoteid;//主题帖id
	
	private String mainnotetype;//主题帖类型
	
	private String mainnotetitle;//帖子标题
	
	private int floorid;//楼层号
	
	private String username;//用户名
	
	private String floorcontent;//楼层内容
	
	private String createtime;//发帖时间
		
	private int quotecount;//总回帖数
	
	private int viewcount;//总浏览数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getFloorid() {
		return floorid;
	}

	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFloorcontent() {
		return floorcontent;
	}

	public void setFloorcontent(String floorcontent) {
		this.floorcontent = floorcontent;
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

	public Note(int id, int mainnoteid, String mainnotetype, String mainnotetitle, int floorid, String username,
			String floorcontent, String createtime, int quotecount,int viewcount) {
		super();
		this.id = id;
		this.mainnoteid = mainnoteid;
		this.mainnotetype = mainnotetype;
		this.mainnotetitle = mainnotetitle;
		this.floorid = floorid;
		this.username = username;
		this.floorcontent = floorcontent;
		this.createtime = createtime;
		this.quotecount = quotecount;
		this.viewcount = viewcount;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}





}
