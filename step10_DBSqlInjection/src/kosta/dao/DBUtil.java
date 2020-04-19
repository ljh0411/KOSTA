package kosta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds ;
	//로드
	static{
		try{
		 Context initContext = new InitialContext();//context.xml문서
		  ds = 
		 (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
		
		}catch(NamingException e){
			e.printStackTrace();
		}
		
	}
	
	//연결
	public static Connection  getConnection(){
		try{
			return ds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	//닫기
	public static void dbClose(Connection con, Statement st, ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			  }
			if(st!=null){
				st.close();
				st=null;
			}
			if(con!=null){
				con.close();
				con=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}








