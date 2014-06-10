package com.trulia.utilities;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.pool.OracleDataSource;

import org.testng.annotations.DataProvider;



public class TruliaDataProWithSQl {
	
	/*
	@DataProvider(name="myJdbcNotUsed")
	public static Object[][] data() throws SQLException
	{
		
		//	 
		 Object[][] multD = new Object[7][2];
			 ResultSet rset;
			 OracleDataSource ods = new OracleDataSource();
			    ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
			    Connection conn = ods.getConnection();
			    
		   try {
		     Statement stmt = conn.createStatement();
		     try {
		    	 
		       rset = stmt.executeQuery("select City_Name,AgentResult from AgentResult");
		       int numcols = rset.getMetaData().getColumnCount();
		       List <List <String> > result = new ArrayList<>();
		       int j=0;
		      
		       try {  
		    	 //strList = (ArrayList<String>) rset.getArray(1);  
		         while (rset.next())
		         {
		        	 List <String> row = new ArrayList<>(numcols); // new list per row
		        	 
		        	 Object[] myObj = new Object[2];
		             for (int i=1; i<= numcols; i++) {  // don't skip the last column, use <=
		                 row.add(rset.getString(i));
		                 System.out.print(rset.getString(i) + "\t");
		                 myObj[i-1] = rset.getString(i);
		        
		                 //ZipAgentCount [j][i]=rset.getString(i);
		                }
		             multD[j] =   myObj;
		             result.add(row); // add it to the result
		             System.out.print("\n");
		            
		             j++;
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
		   return multD;
			
		}
	*/
/*@DataProvider(name = "homePage")
public static Object[][] FileData(){
	Object[][] hpdata = new Object[][]{
			{"Fremont, CA", "1,160"},
			{"Dublin,CA", "442"},
			{"Pleasanton,CA", "819"}
	};
	return hpdata;
	
}*/

	
@DataProvider(name="myJdbc")
public static Object[][] data1() throws SQLException
{
	
		 Object[][] multD1 = null;
		 int columncount = 0;
		 ResultSet rset;
		 OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
		    Connection conn = ods.getConnection();
		    
	   try {
	     Statement stmt = conn.createStatement();
	     try {
	       
	    	rset = stmt.executeQuery("select count(*) from AgentResult");
	    	while (rset.next())
	    	{
	    		 columncount = rset.getInt(1);
	    	}
	       rset = stmt.executeQuery("select City_Name,AgentResult from AgentResult");
	       int numcols = rset.getMetaData().getColumnCount();
	       List <List <String> > result = new ArrayList<>();
	 
	       
	       // define based on the number of row in the query.
	       Object[][] multD = new Object[columncount][numcols];
	     
	       int j=0; 
	       try {  
	    	 //strList = (ArrayList<String>) rset.getArray(1);  
	    	   while (rset.next())
	         {
	        	 List <String> row = new ArrayList<>(numcols); // new list per row
	        	 // define based on the number columns in the query
	        	 Object[] myObj = new Object[numcols];
	             for (int i=1; i<= numcols; i++) {  // don't skip the last column, use <=
	                 row.add(rset.getString(i));
	                 System.out.print(rset.getString(i) + "\t");
	                 myObj[i-1] = rset.getString(i);
	        
	                 //ZipAgentCount [j][i]=rset.getString(i);
	                }
	             multD[j] =   myObj;
	             result.add(row); // add it to the result
	             System.out.print("\n");
	            
	             j++;
	         }
	         
	       } 
	       finally {
	    
	          try { rset.close(); multD1 = multD;} catch (Exception ignore) {}
	       }
	     } 
	     finally {
	       try { stmt.close(); } catch (Exception ignore) {}
	     }
	   } 
	   finally {
	     try { 
	    	 conn.close();
	    
	     } catch (Exception ignore) {}
	   } 
	  return  multD1;
	}
}