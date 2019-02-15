<%@page import="br.com.intranet.cenopservicoscwb.entity.Funcionario"%>
<%@page import="br.com.intranet.cenopservicoscwb.dao.FuncionarioDAO"%>

<%
boolean precisaAutenticar=false;
if(session.getAttribute("usuarioLogado")==null) {
	if(request.getParameter("cd-idgl-usu")!=null) {
	
		//precisaAutenticar=true;
                 precisaAutenticar=false;
                
	} else {
		//session.setAttribute("usuarioLogado",new FuncionarioDAO().getFuncionario(request.getParameter("cd-idgl-usu")));
		//session.setAttribute("funci",new Funcionario());
                session.setAttribute("usuarioLogado",new FuncionarioDAO().getFuncionario("f5078775","545877"));
	}
}
//if (precisaAutenticar) {
	//String uri = request.getScheme() + "://" +
				 //request.getServerName() + 
				 //("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort() ) +
				// request.getRequestURI() +
				//(request.getQueryString() != null ? "?" + request.getQueryString() : "");
	//response.sendRedirect("http://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri + "home.jsf");
        
//}
 
 //retirar instruçoes abaixo quando executar no BB
String uri = request.getScheme() + "://" +
				 request.getServerName() + 
				 ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort() ) +
				 request.getRequestURI() +
				(request.getQueryString() != null ? "?" + request.getQueryString() : "");
response.sendRedirect(uri + "home.jsf");
%>
