<%-- 
    Document   : profile
    Created on : 20 dic. 2021, 20:54:21
    Author     : nicol
--%>

<%@page import="database.ProductosDAO"%>
<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Local de
            <%=session.getAttribute("local")%>
        </title>
        <link rel="stylesheet" href="css/profile.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
        <h1>Login Correcto</h1>
        <h2>Bienvenido
            <%
                out.println(session.getAttribute("userName"));
            %>
        </h2>
        <br>
        <h3>Del local de 
            <%
                List<Producto> productsDB = new ArrayList<>();
                ProductosDAO pdao = new ProductosDAO();
                System.out.println(session.getAttribute("idLocal"));
                productsDB = pdao.getProductosByIDSucursal((int) session.getAttribute("idLocal"));

                out.println(session.getAttribute("local"));
            %>
        </h3>
        <br>
        <div class="table-responsive">

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">nombre producto</th>
                        <th scope="col">cantidad alerta</th>
                        <th scope="col">precio</th>
                        <th scope="col">Sucursal</th>
                    </tr>
                </thead>
                <% int i = 0;
                for (i = 0; i < productsDB.size(); i++) {%>
                <tbody>
                    <tr>
                        <th scope="row"><%=productsDB.get(i).getNombreProducto()%></td>
                        <td><%=productsDB.get(i).getCantidad_alerta()%></td>
                        <td><%=productsDB.get(i).getPrecio()%></td>
                        <td><%=productsDB.get(i).getSucursal().getNombre_sucursal()%></td>

                    </tr>

                </tbody>
                <% }%>
            </table>

        </div>


    </body>
</html>
