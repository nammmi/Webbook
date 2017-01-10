package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MysqlCon2 {
	
	private static Connection con;//Declare a Connection object  
    private static String driver="com.mysql.jdbc.Driver";// the MySQL driver  
    private static String url="jdbc:mysql://localhost:3306/webbooktest2";// URL points to destination database to manipulate  
    private static String user="root";//user name for the specified database  
    private static String pwd="root";//the corresponding password  
    
    public static Connection getConnection(){  
        try {  
            Class.forName(driver);// add MySQL driver  
            System.out.println("Database driver is successfully added");  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        try {  
            con=DriverManager.getConnection(url,user,pwd);//create a connection object  
            System.out.println("Database connection is successful");  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return con;  
    }  
    
    public static void close(ResultSet result, PreparedStatement pre, java.sql.Connection con){
    	
    	try
        {
            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
            // 注意关闭的顺序，最后使用的最先关闭
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();
            if (con != null)
                con.close();
            System.out.println("数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement pre, java.sql.Connection con){
    	close(null, pre, con);
    }

}
