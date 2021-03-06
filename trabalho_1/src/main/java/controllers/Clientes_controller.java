package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import models.Cliente;
import models.Jogo;

@WebServlet("/clientes")
public class Clientes_controller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ClienteDAO clientedao = new ClienteDAO();
		
		List<Cliente> clientes = clientedao.list();		
		
		
		//System.out.println(jogos.length);			
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Trabalho 1 - Cadastro de Jogos</title>\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">\r\n"
				+ "</head>");
		out.println("<body>");
		out.println("<header>\r\n"
				+ " 	<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
				+ "	  <div class=\"container-fluid\">\r\n"
				+ "	    <a class=\"navbar-brand\" href=\"/trabalho_1\">Trabalho 1</a>\r\n"
				+ "	    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "	      <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "	    </button>\r\n"
				+ "	    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "	      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
				+ "	        <li class=\"nav-item dropdown\">\r\n"
				+ "	          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "	            Jogos\r\n"
				+ "	          </a>\r\n"
				+ "	          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Cadastro_Jogos.html\">Cadastrar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Alterar_Jogos.html\">Alterar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Remover_Jogos.html\">Deletar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/jogos\">Listar</a></li>	            \r\n"
				+ "	          </ul>\r\n"
				+ "	        </li>	        \r\n"
				+ "	        <li class=\"nav-item dropdown\">\r\n"
				+ "	          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "	            Clientes\r\n"
				+ "	          </a>\r\n"
				+ "	          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Cadastro_Clientes.html\">Cadastrar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Alterar_Clientes.html\">Alterar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Remover_Clientes.html\">Deletar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/clientes\">Listar</a></li>\r\n"
				+ "	          </ul>\r\n"
				+ "	        </li>	        \r\n"
				+ "         <li class=\"nav-item dropdown\">\r\n"
				+ "	          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "	            Desenvolvedoras\r\n"
				+ "	          </a>\r\n"
				+ "	          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Cadastro_Desenvolvedoras.html\">Cadastrar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Alterar_Desenvolvedoras.html\">Alterar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Remover_Desenvolvedoras.html\">Deletar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/desenvolvedoras\">Listar</a></li>\r\n"
				+ "	          </ul>\r\n"
				+ "	        </li>	\r\n"
				+ "	      </ul>	      \r\n"
				+ "	    </div>\r\n"
				+ "	  </div>\r\n"
				+ "	</nav>\r\n"
				+ " </header>");
		
		out.println("<main>");
		out.println("<div class=\"container\" style=\"margin-top: 15px;\">");
		out.println("<div class=\"row\">");
		if(clientes.isEmpty()){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nenhum dado encontrado!');");
			   out.println("</script>");
			   out.println("<h2 style=\"text-align: center;\">Nenhum dado encontrado!</h2>");
		}
		out.println("<table class=\"table\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">#</th>\r\n"
				+ "      <th scope=\"col\">Nome</th>\r\n"
				+ "      <th scope=\"col\">E-mail</th>\r\n"
				+ "      <th scope=\"col\">Data de Nascimento</th>\r\n"
				+ "      <th scope=\"col\">Pa?s</th>\r\n"
				+ "      <th scope=\"col\">Estado</th>\r\n"
				+ "      <th scope=\"col\">Cidade</th>\r\n"
				+ "      <th scope=\"col\">Endere?o</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>");
		out.println("<tbody>");
		
		for (Cliente cliente : clientes) {			
			out.println("<tr>");
			out.println("<td>" + cliente.getId() + "</td>");
			out.println("<td>" + cliente.getNome() + "</td>");
			out.println("<td>" + cliente.getEmail() + "</td>");
			out.println("<td>" + cliente.getData_nasc() + "</td>");
			out.println("<td>" + cliente.getPais() + "</td>");
			out.println("<td>" + cliente.getEstado() + "</td>");
			out.println("<td>" + cliente.getCidade() + "</td>");
			out.println("<td>" + cliente.getEndereco() + "</td>");						
			out.println("</tr>");
		}				
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</main>");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf\" crossorigin=\"anonymous\"></script>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if("delete".equals(req.getParameter("action"))) {
			doDelete(req, resp);
			return;
		}else if ("put".equals(req.getParameter("action"))) {
			doPut(req, resp);
			return;
		}
		
		if(req.getParameter("nome").isBlank() || req.getParameter("data_nasc").isBlank() || req.getParameter("pais").isBlank() || req.getParameter("estado").isBlank() || req.getParameter("cidade").isBlank() || req.getParameter("endereco").isBlank() || req.getParameter("email").isBlank()) {
			RequestDispatcher request = req.getRequestDispatcher("forms/Cadastro_Clientes.html");
			
			request.forward(req, resp);
			return;
		}
		
		PrintWriter out = resp.getWriter();		
		ClienteDAO clientedao = new ClienteDAO();				
		
		Cliente cliente = new Cliente(0, req.getParameter("nome"), req.getParameter("data_nasc"), req.getParameter("pais"), req.getParameter("estado"), req.getParameter("cidade"), req.getParameter("endereco"), req.getParameter("email"));
		
		clientedao.insert(cliente);
		
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('Dados salvos com sucesso!');");
	    out.println("</script>");				
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Cadastro_Clientes.html");
		
		request.forward(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ClienteDAO clientedao = new ClienteDAO();
		int aux = 0;
		
		if(req.getParameter("id").isBlank() || req.getParameter("nome").isBlank() || req.getParameter("data_nasc").isBlank() || req.getParameter("pais").isBlank() || req.getParameter("estado").isBlank() || req.getParameter("cidade").isBlank() || req.getParameter("endereco").isBlank() || req.getParameter("email").isBlank()) {
			RequestDispatcher request = req.getRequestDispatcher("forms/Alterar_Clientes.html");
			
			request.forward(req, resp);
			return;
		}
		
		Cliente cliente = new Cliente(Integer.parseInt(req.getParameter("id")), req.getParameter("nome"), req.getParameter("data_nasc"), req.getParameter("pais"), req.getParameter("estado"), req.getParameter("cidade"), req.getParameter("endereco"), req.getParameter("email"));
		
		clientedao.update(cliente);
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Alterar_Clientes.html");
		
		request.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ClienteDAO clientedao = new ClienteDAO();		
		
		if (req.getParameter("id").isBlank()) {
			RequestDispatcher request = req.getRequestDispatcher("forms/Remover_Clientes.html");
			
			request.forward(req, resp);
			return;
		}			
		
		clientedao.delete(Integer.parseInt(req.getParameter("id")));					
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Remover_Clientes.html");
		
		request.forward(req, resp);
	}		

}
