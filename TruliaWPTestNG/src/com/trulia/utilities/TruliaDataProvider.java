package com.trulia.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;

import org.testng.annotations.DataProvider;

public class TruliaDataProvider {
	
	@DataProvider(name = "homePage")
	public static Object[][] data(){
		Object[][] hpdata = new Object[][]{
				{"Fremont, CA", "1,160"},
				{"Dublin,CA", "442"},
				{"Pleasanton,CA", "819"}
		};
		return hpdata;
		
	}
	
	@SuppressWarnings("null")
	@DataProvider(name = "dbcitydata") 
	public static String[][] dbdata() throws Exception
	{
		//ArrayList<String><String> strList;
		String[][] hpdata =null;
		 ResultSet rset;
		 OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
		    Connection conn = ods.getConnection();
		    
	   try {
	     Statement stmt = conn.createStatement();
	     try {
	    	 
	       rset = stmt.executeQuery("select City_Name,AgentResult from AgentResult");
	       int i =0;
	       try {
	         while (rset.next())
	         {
	             hpdata[i][0]= rset.getString(1);
	             hpdata[i][1]= rset.getString(2);
	        	 System.out.println (rset.getString(1) + " " + rset.getString(2));   // Print col 1'
	        	 i++;
	         }
	       } 
	       finally {
	          try { rset.close(); } catch (Exception ignore) {}
	       }
	     } 
	     finally {
	       try { stmt.close(); } catch (Exception ignore) {}
	     }
	   } 
	   finally {
	     try { conn.close();
	    
	     } catch (Exception ignore) {}
	   }
	return hpdata;
	  }
		
	}
	
		
	
	




