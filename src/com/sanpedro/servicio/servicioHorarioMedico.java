package com.sanpedro.servicio;

import java.util.List;

import com.sanpedro.dao.horarioMedicoDAO;
import com.sanpedro.model.horarioMedico;


public class servicioHorarioMedico {
//
//	public String insertar (String nombre ,String descripcion) {
//		roles rol = new roles();
//		rol.setNombre(nombre);
//		rol.setDescripcion(descripcion);
//		
//		rolesDAO dao = new rolesDAO();
//		return dao.registro(rol);
//		
//		
//	}
	
	public List<horarioMedico> listado(String dni){
		horarioMedicoDAO dao = new horarioMedicoDAO();
		return dao.listarHorarioMedico(dni);
	}
	
//	public static void main(String[] args) {
////		System.out.println(new servicioCrearRol().insertar("dsa", "xd"));
//		System.out.println(new servicioCrearRol().listado("12345678").size());
//	}
	
}
