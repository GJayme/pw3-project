<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.example.gabriel_jayme.*" %>
<%@ page import="com.example.gabriel_jayme.domain.Users" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Endereços Cadastrados</title>
    <link rel="stylesheet" type="text/css" href="../../../../../pw3/gabriel-jayme/src/main/webapp/lib/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../../../../pw3/gabriel-jayme/src/main/webapp/lib/css/bootstrap.css"/>
</head>
<body>
<h1>Usuários Cadastrados</h1>

<% ArrayList<Users> lista = (ArrayList<Users>) request.getSession().getAttribute("lista"); %>

<table>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Senha</th>
    </tr>

    <% for (int i = 0; i< lista.size(); i++) { %>

    <tr>
        <td><%= lista.get(i).getId()%></td>
        <td><%= lista.get(i).getName()%></td>
        <td><%= lista.get(i).getPassword()%></td>
    </tr>
    <% } %>
</table>

</body>
</html>
