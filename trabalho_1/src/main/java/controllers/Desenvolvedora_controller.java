package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DesenvolvedoraDAO;
import models.Desenvolvedora;

@WebServlet("/desenvolvedoras")
public class Desenvolvedora_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		DesenvolvedoraDAO desenvdao = new DesenvolvedoraDAO();
				
		List<Desenvolvedora> desenvs = desenvdao.list();		
		
		
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
				+ "	        </li> \r\n"
				+ "	        <li class=\"nav-item dropdown\">\r\n"
				+ "	          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "	            Desenvolvedoras\r\n"
				+ "	          </a>\r\n"
				+ "	          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Cadastro_Desenvolvedoras.html\">Cadastrar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Alterar_Desenvolvedoras.html\">Alterar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item\" href=\"/trabalho_1/forms/Remover_Desenvolvedoras.html\">Deletar</a></li>\r\n"
				+ "	            <li><a class=\"dropdown-item active\" href=\"/trabalho_1/desenvolvedoras\">Listar</a></li>\r\n"
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
		if(desenvs.isEmpty()){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nenhum dado cadastrado!');");
			   out.println("</script>");
			   out.println("<h2 style=\"text-align: center;\">Nenhum dado encontrado!</h2>");
		}
		out.println("<table class=\"table\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">#</th>\r\n"
				+ "      <th scope=\"col\">Nome</th>\r\n"
				+ "      <th scope=\"col\">Descrição</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>");
		out.println("<tbody>");
		
		for (Desenvolvedora desenv : desenvs) {			
			out.println("<tr>");
			out.println("<td>" + desenv.getId() + "</td>");
			out.println("<td>" + desenv.getNome() + "</td>");			
			out.println("<td>" + desenv.getDescricao() + "</td>");			
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
		if ("delete".equals(req.getParameter("action"))) {						
			doDelete(req, resp);
			return;
		}else if ("put".equals(req.getParameter("action"))) {
			doPut(req, resp);
			return;
		}
		
		if (req.getParameter("nome").isBlank() || req.getParameter("descricao").isBlank()) {
			RequestDispatcher request = req.getRequestDispatcher("forms/Cadastro_Desenvolvedoras.html");
			
			request.forward(req, resp);
			return;
		}
		
		PrintWriter out = resp.getWriter();						
		
		Desenvolvedora desenv = new Desenvolvedora(0, req.getParameter("nome"), req.getParameter("descricao"));
		
		
		DesenvolvedoraDAO desenvdao = new DesenvolvedoraDAO();
		
		desenvdao.insert(desenv);
		
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('Dados salvos com sucesso!');");
	    out.println("</script>");				
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Cadastro_Desenvolvedoras.html");
		
		request.forward(req, resp);
				
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		DesenvolvedoraDAO desenvdao = new DesenvolvedoraDAO();
		
		if (req.getParameter("id").isBlank() || req.getParameter("nome").isBlank() || req.getParameter("descricao").isBlank()) {
			RequestDispatcher request = req.getRequestDispatcher("forms/Alterar_Desenvolvedoras.html");
			
			request.forward(req, resp);
			return;
		}
		
		Desenvolvedora desenv = new Desenvolvedora(Integer.parseInt(req.getParameter("id")), req.getParameter("nome"), req.getParameter("descricao"));
		
		desenvdao.update(desenv);
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Alterar_Desenvolvedoras.html");
		
		request.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		PrintWriter out = resp.getWriter();
		DesenvolvedoraDAO desenvdao = new DesenvolvedoraDAO();
		
		
		if(req.getParameter("id").isBlank()) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Um ou mais campos não foram preenchidos');");
		    out.println("</script>");
		    
		    RequestDispatcher request = req.getRequestDispatcher("forms/Remover_Desenvolvedoras.html");
			
			request.forward(req, resp);
			
			return;
		    
		}
		
		desenvdao.delete(Integer.parseInt(req.getParameter("id")));
		
		
		RequestDispatcher request = req.getRequestDispatcher("forms/Remover_Desenvolvedoras.html");
		
		request.forward(req, resp);
		
	}
}
