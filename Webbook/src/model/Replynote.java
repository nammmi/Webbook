package model;

public class Replynote {
	
	private int id;
	
	private int mainnoteid;
	
	private int floorid;
	
	private String username;
	
	private String floorcontent;
	
	private String createtime;
	
	private String quotename;
	
	private String quotecontent;
	
	private int quotefloor;

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

	public String getQuotename() {
		return quotename;
	}

	public void setQuotename(String quotename) {
		this.quotename = quotename;
	}

	public String getQuotecontent() {
		return quotecontent;
	}

	public void setQuotecontent(String quotecontent) {
		this.quotecontent = quotecontent;
	}

	
	
	public Replynote(int id, int mainnoteid, int floorid, String username, String floorcontent, String createtime,
			String quotename, String quotecontent, int quotefloor) {
		super();
		this.id = id;
		this.mainnoteid = mainnoteid;
		this.floorid = floorid;
		this.username = username;
		this.floorcontent = floorcontent;
		this.createtime = createtime;
		this.quotename = quotename;
		this.quotecontent = quotecontent;
		this.quotefloor = quotefloor;
	}

	public int getQuotefloor() {
		return quotefloor;
	}

	public void setQuotefloor(int quotefloor) {
		this.quotefloor = quotefloor;
	}

	public Replynote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
