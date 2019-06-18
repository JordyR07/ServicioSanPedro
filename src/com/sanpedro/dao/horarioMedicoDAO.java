package com.sanpedro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sanpedro.model.horarioMedico;
import com.sanpedro.util.conexion;

public class horarioMedicoDAO {

	
	String estado = "";				
	horarioMedico hm = new horarioMedico();	
	
	public ArrayList<horarioMedico> listarHorarioMedico(String dni){
		CallableStatement cs = null;  
		Connection conn = conexion.getConexion();
		final ArrayList<horarioMedico> temporal = new ArrayList<>();		
		try {
			
			cs = conn.prepareCall(hm.listarHorarioMedico());
			cs.setString(1, dni);
			final ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {			hm = new horarioMedico();
				
				hm.setDescripcion(rs.getString("descripcion"));
				hm.setHora_ini(rs.getString("horario_inicio"));
				hm.setHora_fin(rs.getString("horario_fin"));
				hm.setFecha_ini(rs.getString("fecha_inicio"));
				hm.setFecha_fin(rs.getString("fecha_fin"));
				hm.setTurno(rs.getString("turno"));
				
				
				temporal.add(hm);
			}
		}
		catch(SQLException e) {	estado = "ERROR EN LISTAR";	
		e.printStackTrace();}
		finally {
			try {	if(cs!=null) cs.close(); }
			catch(Exception ex) { estado="ERROR EN LISTAR"; }
			try {	if(conn!=null) conn.close(); }
			catch(Exception ex) { estado="ERROR DE CONEXION"; }
		}
		return temporal;
	}
}
