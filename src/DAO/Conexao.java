package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	

	    public static Connection fabricar() throws Exception {       
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        return DriverManager.getConnection("jdbc:mysql://localhost/Carddigi" ,"Login" ,"senha");
	    }
	}


