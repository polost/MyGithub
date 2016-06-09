package headhole.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection con = null;  
    private static final String DRIVER = "com.mysql.jdbc.Driver";  
    private static final String USER = "root";  
    private static final String URL = "jdbc:mysql://localhost:3306/headholedb";  
    private static final String PASS = "zengjiasheng";  
    public DatabaseConnection()throws Exception{  
        Class.forName(DRIVER);  
        con = DriverManager.getConnection(URL,USER,PASS);  
    }  
    public Connection getConnection()throws Exception{  
        return con;  
    }  
    public void close()throws Exception{  
        if(con!=null){  
            con.close();  
        }  
    }  
}
