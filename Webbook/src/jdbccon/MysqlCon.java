package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public abstract class MysqlCon {
	public static String url = "jdbc:mysql://localhost:3306/webbooktest2";
    public static String username = "root";
    public static String password = "root";
    public static Connection con =null;
    public static PreparedStatement stmt =null;
    public static ResultSet rs =null;

    
    
    public static void Test() throws SQLException {
        connect();
        operation();
        rs.close();
        stmt.close();
        con.close();
    }


	public static void operation() {
		// TODO Auto-generated method stub
		String sql_select = "select * from webbook";
		try {
			stmt = con.prepareStatement(sql_select);
			rs = stmt.executeQuery();// 执行查询，注意括号中不需要再加参数
	        
	        //TestInt aa = new TestInt();
	        //aa.aaa();
	        
	        while (rs.next())
	        {
	        	//list.add(employee);
	        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 实例化预编译语句
	}


	private static void connect() {
		// TODO Auto-generated method stub
		// 定位驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功!"); 
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败!");
            e.printStackTrace();
        }
        // 建立连接
        try {
            con = DriverManager.getConnection(url, username, password);
            
            System.out.println("数据库连接成功!"); 
        } catch(SQLException e) {
            System.out.println("数据库连接失败!"); 
        }
		
	}

}
