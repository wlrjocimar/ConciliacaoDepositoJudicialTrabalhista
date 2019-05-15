<%@page import="br.com.intranet.cenopservicoscwb.dao.AtividadeFunciDAO"%>
<%@page import="br.com.intranet.cenopservicoscwb.dao.FuncionarioDAO"%>

<%
    boolean precisaAutenticar = false;
    if (session.getAttribute("usuarioLogado") == null) {
        if (request.getParameter("ibm-nativeid") == null) {
            precisaAutenticar = true;
        } else {
            session.setAttribute("usuarioLogado", new FuncionarioDAO().getFuncionario(request.getParameter("ibm-nativeid"),request.getParameter("cd-eqp"),request.getParameter("nm-idgl")));
            //session.setAttribute("usuarioLogado", new FuncionarioDAO().getFuncionario("F45335","283268","JONAS USUSARIO TESTE"));
            session.setAttribute("funciAtividade", new AtividadeFunciDAO().getAtividadeFunci(request.getParameter("ibm-nativeid")));
                
            if (session.getAttribute("usuarioLogado") != null) {
                String uri = request.getScheme() + "://"
                        + request.getServerName()
                        + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                        + request.getRequestURI()
                        + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
                response.sendRedirect("https://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri + "home.jsf");

            }
        }
    } else {
        String uri = request.getScheme() + "://"
                + request.getServerName()
                + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                + request.getRequestURI()
                + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
        response.sendRedirect("https://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri + "home.jsf");

    }

    if (precisaAutenticar) {
        String uri = request.getScheme() + "://"
                + request.getServerName()
                + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                + request.getRequestURI()
                + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
        response.sendRedirect("https://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri);
    }


%>



<html>

    <p>Carregando pagina.....</p>   
</html>





