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

            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Insertar nuevo producto</button>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="POST" action="/product/insert">
                                <div class="mb-3">
                                    <label for="product-name" class="col-form-label">Nombre Producto</label>
                                    <input type="text" class="form-control" id="product-name" name="product-name">
                                </div>
                                <label for="price" class="col-form-label">Precio Producto</label>
                                <div class="input-group mb-3">
                                    <span class="input-group-text">$</span>
                                    <input type="text" class="form-control" name="price" id="price" aria-label="Amount (to the nearest dollar)">

                                </div>
                                <div class="mb-3">
                                    <label for="stock" class="col-form-label">Stock</label>
                                    <input type="number" class="form-control" id="stock" name="stock">
                                </div>
                                <div class="mb-3">
                                    <label for="cant_alert" class="col-form-label">Cantidad Alerta</label>
                                    <input type="number" class="form-control" id="cant_alerta" name="cant_alerta">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="submit"  class="btn btn-primary">Send message</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
