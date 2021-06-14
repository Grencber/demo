//package com.example.demo.interfaceAdapters;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class TransactionService {
//	
//	private static final String SQL_INSERT = "INSERT INTO TRANSACTION (account_from, account_to, amount, date) values (?,?,?,?)";
//
////	private static final String SQL_UPDATE = "UPDATE transaction SET SALARY=? WHERE NAME=?";
//
//	private static final String SQL_TABLE_CREATE = "CREATE TABLE TRANSACTION" + "(" + " ID serial,"
//			+ " account_from varchar(100) NOT NULL," + " account_to varchar(100) NOT NULL," + " amount numeric(15, 2) NOT NULL,"
//			+ " date timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP)";
//
////	private static final String SQL_TABLE_DROP = "DROP TABLE transaction";
//	public void saveTransaction()
//	{
//
//	try
//	
//	{
//
//		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb://http://localhost:8080/h2-console;DB_CLOSE_DELAY=-1", "sa", "");
//		Statement statement = conn.createStatement();
//		statement.execute(SQL_TABLE_CREATE);
//		PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
//		
//		// Run list of insert commands
//		psInsert.setInt(1, 100);
//		psInsert.setInt(2, 102);
//		psInsert.setBigDecimal(3, new BigDecimal(10));
//		psInsert.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
//		psInsert.execute();
//		
//		PreparedStatement ps=conn.prepareStatement("select * from TRANSACTION");
//	    ResultSet r=ps.executeQuery();
//	    if(r.next()) {
//	        System.out.println("data?");
//	    }
//		statement.close();
//		conn.close();
//
//
//	}catch(
//	Exception e)
//	{
//		e.printStackTrace();
//	}
//	
//}
//}
