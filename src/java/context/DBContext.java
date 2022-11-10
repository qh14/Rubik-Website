/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBContext {
    private static  final String username = "sa";
    private static final String pass = "123456";
    private static final String servername = "localhost";
    private static final String dbName ="ShopRubikDB";
    private static final String portNumber = "1433";
    private static final String instance = "";
    public static Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+servername+":"+portNumber+"\\"+instance+";databaseName="+dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://"+servername+":"+portNumber+";databaseName="+dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, pass);
    }
}
