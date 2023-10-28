package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement ps= null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_reto24","postgres","POLIkevin1");
		System.out.println("conexion correcta");
		
		//ejemplo 1
		
		ps=connection.prepareStatement("INSERT INTO empleados (codigo_empleado, nombre, fecha, hora) "
	
				+ " VALUES (?,?,?,?)");
		
		ps.setInt(1,20 );
		ps.setString(2,"Juan" );
	
		
		
		
		
		// cuando sea money colocar 
		//ps.setBigDecima1(7, new BigDecimal(1200.45));
		
		
		/// para fechas 
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String fechaStr="2020/03/22 10:05:04";
		try {
			Date fecha=sdf.parse(fechaStr);
			System.out.println(fecha);
			long fechaMilis=fecha.getTime();
			System.out.println(fechaMilis);
			// para sql date
			java. sql.Date fechaSQL = new java.sql.Date(fechaMilis);
			System.out.println(fechaSQL);
			
			// hora sql
			Time timeSQL=new Time(fechaMilis);
			System.out.println(timeSQL);
			
			ps.setDate(3,fechaSQL );
			ps.setTime(4,timeSQL );
			ps.executeUpdate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
