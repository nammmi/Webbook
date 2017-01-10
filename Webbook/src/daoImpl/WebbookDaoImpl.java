package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.WebbookDao;
import jdbccon.MysqlCon2;
import model.Listofnotes;
import model.Note;
import model.PageBean;
import model.Replynote;

public class WebbookDaoImpl implements WebbookDao{

	@Override
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		  
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;
		String sql = "select * from webbook ORDER BY createtime DESC";
		List<Note> list = new ArrayList<Note>();
		try {
			pre = con.prepareStatement(sql);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(result.next()){
				Note note = new Note(result.getInt("id"),result.getInt("mainnoteid"),result.getString("mainnotetype"), result.getString("mainnotetitle"), result.getInt("floorid"), result.getString("username"), result.getString("floorcontent"), result.getString("createtime"), result.getInt("quotecount"), result.getInt("viewcount"));
				System.out.println(note.getCreatetime()+"++++++++++++++++");
				list.add(note);
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(result, pre, con);
	    }
		return list;
	}
	
	/**
	 * 添加主题帖
	 */

	@Override
	public void insertMainNotes(String mainNoteType, String mainNoteTitle, String mainNoteContent, String username) {  //添加主题帖
		// TODO Auto-generated method stub	
		java.sql.Connection con = MysqlCon2.getConnection(); 		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		//INSERT INTO webbook (mainnoteid, mainnotetype, mainnotetitle, floorid, username, floorcontent, createtime) VALUES (10000, '求助', '什么？', 1, 'lsx', '今天天气怎么样', '2016-8-26')
	    
	    int mainNoteId = 10000;//日后改为从从总主题帖数累计！！！
	    String mainNoteType1 = mainNoteType;//日后改为从页面获取！！！
		//String mainNoteType = request.getParameter("type");
		String mainNoteTitle1 = mainNoteTitle;
		String floorContent = mainNoteContent;//此楼层内容
		int floorId = 1;
		
		String userName = username;//日后从session获取！！
		int quoteCount = 1;           //日后写一个方法获取回复数量！！！！！！！！！！！！！！
		int viewCount = 1;            //日后写一个方法获取浏览数量！！！！！！！！！！！！！！
		//java.util.Date date=new java.util.Date();
		//java.sql.Date createTime =new java.sql.Date(date.getTime());
			
	    String sql = "insert into webbook (mainnoteid, mainnotetype, mainnotetitle, floorid, username, floorcontent, createtime, quotecount, viewcount) VALUES (?,?,?,?,?,?,now(),?,?)";//mysql获取当前时间用now()!!!
	    try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, mainNoteId);
			pre.setString(2, mainNoteType1);
			pre.setString(3, mainNoteTitle1);
			pre.setInt(4, floorId);
			pre.setString(5, userName);
			pre.setString(6, floorContent);
			pre.setInt(7, quoteCount);
			pre.setInt(8, viewCount);
			pre.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// 实例化预编译语句
	    finally{
	    	MysqlCon2.close(pre, con);
   
	    }
		
	}

	@Override
	public PageBean<Note> findByPage(int pc) {
		// TODO Auto-generated method stub
		int ps = 15;
		int all = 0;
		
		/**
		 * 初始化当前页面记录数为ps 15;
		 * 要查询内容在数据库总数据数all为0；
		 * 下面sql语句，
		 * select count(*) from webbook
		 * select * from webbook ORDER BY createtime DESC limit 1, 3
		 * 
		 * 
		 */
		
		String sql = "select count(*) from webbook";
		java.sql.Connection con = MysqlCon2.getConnection(); 	
		PreparedStatement st = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				all = Integer.parseInt(rs.getString("count(*)"));
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, con);
	    }
		
		/**
		 * 新建泛型类对象，数据类型为Note，并调用相关方法。
		 */
		
		PageBean<Note> pageBean = new PageBean<Note>();
		pageBean.setAll(all);
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		
		List<Note> list = new ArrayList<Note>();
		sql = "select * from webbook ORDER BY createtime DESC limit "+(pc-1)*ps+", "+ps;
		java.sql.Connection conn = MysqlCon2.getConnection();
		st = null;
		rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				Note note = new Note(rs.getInt("id"),rs.getInt("mainnoteid"),rs.getString("mainnotetype"), rs.getString("mainnotetitle"), rs.getInt("floorid"), rs.getString("username"), rs.getString("floorcontent"), rs.getString("createtime"), rs.getInt("quotecount"), rs.getInt("viewcount"));
				System.out.println(note.getCreatetime()+"++++++++++++++++");
				list.add(note);
			}
			System.out.println("**************************"+list);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, conn);
	    }
		
		pageBean.setBeanList(list);
		return pageBean;
		
		
	}
	
	/**
	 * UPDATE webbook SET viewcount = viewcount+1 WHERE id=? 
	 * 这句sql更新每个帖子的浏览次数。
	 */

	@Override
	public PageBean<Replynote> findReplyNoteByPage(int pc, int id) {//查找回复的帖子集合
		// TODO Auto-generated method stub
		String sql0 = "UPDATE webbook SET viewcount = viewcount+1 WHERE id=? ";
		java.sql.Connection con0 = MysqlCon2.getConnection(); 	
		PreparedStatement st0 = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		try{
			st0 = con0.prepareStatement(sql0);
			st0.setInt(1, id);
			st0.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(st0, con0);
		}
		
		int ps = 15;
		int all = 0;
		
		String sql = "select count(*) from replynote where replynote.mainnoteid = ?";//replynote表中的mainnoteid对应webbook表中的主题帖id即id
		java.sql.Connection con = MysqlCon2.getConnection(); 	
		PreparedStatement st = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				all = Integer.parseInt(rs.getString("count(*)"));
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, con);
	    }
		
		/**
		 * 新建泛型类对象，数据类型为Note，并调用相关方法。
		 */
		
		PageBean<Replynote> pageBean = new PageBean<Replynote>();
		pageBean.setAll(all);
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		
		List<Replynote> list = new ArrayList<Replynote>();
		sql = "select * from replynote where replynote.mainnoteid = ? ORDER BY floorid ASC limit "+(pc-1)*ps+", "+ps;
		java.sql.Connection conn = MysqlCon2.getConnection();
		st = null;
		rs = null;
		System.out.println("000000000000000"+id);
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				Replynote replynote = new Replynote(rs.getInt("id"),rs.getInt("mainnoteid"),rs.getInt("floorid"), rs.getString("username"), rs.getString("floorcontent"), rs.getString("createtime"), rs.getString("quotename"), rs.getString("quotecontent"), rs.getInt("quotefloor"));
				System.out.println(replynote.getCreatetime()+"++++++++++++++++");
				list.add(replynote);
			}
			System.out.println("**************************"+list);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, conn);
	    }
		
		pageBean.setBeanList(list);
		return pageBean;
	}

	@Override
	public Note getMainNote(int id) {   //获取主题帖子内容
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;
		String sql = "select * from webbook where id=?";
		Note mainNote = new Note();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(result.next()){
				mainNote = new Note(result.getInt("id"),result.getInt("mainnoteid"),result.getString("mainnotetype"), result.getString("mainnotetitle"), result.getInt("floorid"), result.getString("username"), result.getString("floorcontent"), result.getString("createtime"), result.getInt("quotecount"), result.getInt("viewcount"));
				System.out.println(mainNote.getCreatetime()+"++++++++++++++++");
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(result, pre, con);
	    }
		
		return mainNote;
	}

	@Override
	public PageBean<Listofnotes> findRecentReplyByPage(int pc) {
		// TODO Auto-generated method stub
		int ps = 15;
		int all = 0;
		
		/**
		 * 初始化当前页面记录数为ps 15;
		 * 要查询内容在数据库总数据数all为0；
		 * 下面sql语句，
		 * select count(*) from webbook
		 * select * from webbook ORDER BY createtime DESC limit 1, 3
		 * 
		 * 
		 */
		
		String sql = "select count(*) from listofnotes";
		java.sql.Connection con = MysqlCon2.getConnection(); 	
		PreparedStatement st = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				all = Integer.parseInt(rs.getString("count(*)"));
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, con);
	    }
		
		/**
		 * 新建泛型类对象，数据类型为Note，并调用相关方法。
		 */
		
		PageBean<Listofnotes> pageBean = new PageBean<Listofnotes>();
		pageBean.setAll(all);
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		
		List<Listofnotes> list = new ArrayList<Listofnotes>();
		sql = "select * from listofnotes ORDER BY maxcreatetime DESC limit "+(pc-1)*ps+", "+ps;
		java.sql.Connection conn = MysqlCon2.getConnection();
		st = null;
		rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				//Listofnotes note = new Listofnotes(rs.getInt("mainnoteid"), rs.getString("mainnotetype"), rs.getString("mainnotetitle"), rs.getString("username"), rs.getString("createtime"), rs.getInt("quotecount"), rs.getInt("viewcount"), rs.getString("replynotename"), rs.getString("maxcreatetime"));
				Listofnotes note = new Listofnotes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
				System.out.println(note.getCreatetime()+"++++++++++++++++");
				list.add(note);
			}
			System.out.println("**************************"+list);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, conn);
	    }
		
		pageBean.setBeanList(list);
		return pageBean;

	}
	
	/**
	 * 插入新的回复，不含引用的回复！！！！
	 *根据页面传来的主题帖id，计算已经回复的数量确定楼层floorid，
	 *sql1：select count(*) from replynote where mainnoteid = ?
	 *sql2: insert into replynote (mainnoteid, floorid, username, floorcontent, createtime) values (?,?,?,?,now());
	 *问题：回复主题帖子过程中，主题帖被删除怎么办？根据floorid的值==0
	 */

	@Override
	public void insertReplyNotes(int id, String floorcontent, String username) {
		// TODO Auto-generated method stub
		System.out.println(id+floorcontent);
		java.sql.Connection con = MysqlCon2.getConnection(); 		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet result = null;
		int floorid = 0;
		String sql1 = "select count(*) as cc from replynote where mainnoteid = ?";
		try {
				pre = con.prepareStatement(sql1);
				pre.setInt(1, id);
				result = pre.executeQuery();
				while(result.next()){

					floorid = result.getInt("cc")+1;
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}// 实例化预编译语句
		    finally{
		    	MysqlCon2.close(result,pre, con);
		    }
		
		if(floorid==1)
		{
			//返回提示主题帖已被删除！！！！！
			
		}
		
		 con = MysqlCon2.getConnection(); 		
		 pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		 //String username = "lsx";         //日后改为从session获取！！！！！！
		 String sql2 = "insert into replynote (mainnoteid, floorid, username, floorcontent, createtime) values (?,?,?,?,now());";
		 try{
			 pre = con.prepareStatement(sql2);
				pre.setInt(1, id);
				pre.setInt(2, floorid);
				pre.setString(3, username);
				pre.setString(4, floorcontent);
				
				pre.executeUpdate();
			 
		 }catch (SQLException e1){
			 e1.printStackTrace();
		 }finally{
			 MysqlCon2.close(pre, con);
		 }
		 
		 
		
	}
	
	/**
	 * 查询回复的详细信息，
	 * id为Replynote对象的自增主键，
	 */

	@Override
	public Replynote findReplyNote(int id) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;
		String sql = "select * from replynote where id = ?";
		Replynote replyNote = new Replynote();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()){

				replyNote = new Replynote(rs.getInt("id"), rs.getInt("mainnoteid"), rs.getInt("floorid"), rs.getString("username"), 
						rs.getString("floorcontent"), rs.getString("createtime"), rs.getString("quotename"), 
						rs.getString("quotecontent"),rs.getInt("quotefloor"));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// 实例化预编译语句
	    finally{
	    	MysqlCon2.close(rs,pre, con);
	    }
		return replyNote;
	}

	@Override
	public PageBean<Note> findByFuzzyPage(int pc, String str) {//模糊查询主题帖
		// TODO Auto-generated method stub
		//SELECT * FROM webbook WHERE floorcontent LIKE '%s%' or mainnotetitle LIKE '%s%';
		String sql = "SELECT * FROM webbook WHERE floorcontent LIKE '%"+str+"%' or mainnotetitle LIKE '%"+str+"%'";
		java.sql.Connection con = MysqlCon2.getConnection(); 
		PreparedStatement st = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;
		List<Note> list = new ArrayList<Note>();
		try {
			st = con.prepareStatement(sql);
//			st.setString(1, str);
//			st.setString(2, str);
			rs = st.executeQuery();// 执行查询，注意括号中不需要再加参数
			
			while(rs.next()){
				Note note = new Note(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
				list.add(note);
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
		finally
	    {
	        MysqlCon2.close(rs, st, con);
	    }
		int ps = 15;
		int all = list.size();
		PageBean<Note> pageBean = new PageBean<Note>();
		pageBean.setAll(all);
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setBeanList(list);
		return pageBean;
	}

	@Override
	public void deleteMainNote(int id) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		String sql = "delete from webbook where id = ?";
		try{
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(pre, con);
			
		}
		
		
	}

	@Override
	public void deleteReplyNote(int id) {
		// TODO Auto-generated method stub
		java.sql.Connection con = MysqlCon2.getConnection(); 		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		String sql = "update replynote set floorcontent = '***已被管理员删除***'  where id = ?";
		try{
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			MysqlCon2.close(pre, con);
			
		}
		
	}

}


















