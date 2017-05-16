package br.univel.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.univel.dao.AlunoDao;
import br.univel.model.Aluno;

@WebServlet("/TesteInsert")
public class TesteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AlunoDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (PrintWriter writer = response.getWriter()) {

			writer.println("Inserindo 1000 registros");

			for (int i = 0; i < 1000; i++) {
				Aluno a = new Aluno();
				a.setNome("Aluno " + i);
				a.setTelefone("45-6548-987" + i);
				
				//writer.println(a.toString());
		
				Aluno aRet = dao.salvar(a);
				writer.println("Inserido: " + aRet.getId());
			}

			writer.flush();
		}

	}

}
