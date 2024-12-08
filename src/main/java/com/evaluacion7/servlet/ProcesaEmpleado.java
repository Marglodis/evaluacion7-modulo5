package com.evaluacion7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion7.dao.EmpleadoDaoImpl;
import com.evaluacion7.modelo.Empleado;

/**
 * Servlet implementation class ProcesaEmpleado
 */
@WebServlet("/ProcesaEmpleado")
public class ProcesaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		EmpleadoDaoImpl empleadoDao = new EmpleadoDaoImpl();
		listaEmpleados = empleadoDao.obtieneEmpleado();
		request.setAttribute("empleadoDao", listaEmpleados);
		request.getRequestDispatcher("resultado2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
