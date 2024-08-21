package com.castcast.crm.generic.databaseutlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

//--------------------------------------------
public class DataBaseUtility {

	Connection con;

	public void getDBconnection() throws SQLException {

		try {
			Driver driver = new Driver();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%", "root");
		} catch (Exception e) {

		}

	}
//------------------------------------------------------
	public void closeDBconnection() throws SQLException {
		try {
			con.close();
		} catch (Exception e) {

		}

	}
//-------------------------------------------------------

	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {

			Statement statement = con.createStatement();

			result = statement.executeQuery(query);
		} catch (Exception e) {

		}

		return result;
	}
//---------------------------------------------------------
	
	public int executeNoSelectQuery(String query) {
	int result=0;
	try {

		Statement statement = con.createStatement();

		result = statement.executeUpdate(query);
	} catch (Exception e) {

	}
	return result;
	}
}














