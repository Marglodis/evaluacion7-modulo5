package com.evaluacion7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion7.modelo.Empleado;
import com.evaluacion7.procesarConexion.AdministradorConexion;

public class EmpleadoDaoImpl implements EmpleadoDAO {

	private Connection conn;

	public EmpleadoDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}
	}

	@Override
	public List<Empleado> obtieneEmpleado() {
		String sql = "SELECT * FROM EMPLEADO";
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Empleado empleado = new Empleado(rs.getInt("numempleado"), rs.getString("nombre"),rs.getInt("numdepto"));
				listaEmpleados.add(empleado);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaEmpleados;
	}
}
