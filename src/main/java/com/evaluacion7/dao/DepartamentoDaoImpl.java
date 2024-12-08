package com.evaluacion7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion7.modelo.Departamento;
import com.evaluacion7.procesarConexion.AdministradorConexion;

public class DepartamentoDaoImpl implements DepartamentoDAO{
	private Connection conn;
	 
	public DepartamentoDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();	
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}
		 
	}

	
	@Override
	public List<Departamento> obtieneDepartamento() {
		String sql = "SELECT * FROM  DEPARTAMENTO";
		List<Departamento> deptos = new ArrayList<Departamento>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Departamento depto = new Departamento(rs.getInt("numdepto"),rs.getString("nomdepto"),rs.getString("ubicaciondpto"));
				deptos.add(depto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deptos;
	}

}
