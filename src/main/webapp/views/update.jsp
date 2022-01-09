
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>


            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Inserte datos del nuevo producto</h5>
                    </div>
                    <div class="modal-body">
                        <form method="GET" action="/product/applyUpdate">
                            <div class="mb-3">
                                <label for="product-name" class="col-form-label">Nombre Producto</label>
                                <input type="text" class="form-control" id="product-name" value="<%=session.getAttribute("UpdName")%>" name="upd_product-name">
                            </div>
                            <label for="price" class="col-form-label">Precio Producto</label>
                            <div class="input-group mb-3">
                                <span class="input-group-text">$</span>
                                <input type="text" class="form-control" name="upd_price" id="price" value="<%=session.getAttribute("UpdPrecio")%>" aria-label="Amount (to the nearest dollar)">

                            </div>
                            <div class="mb-3">
                                <label for="stock" class="col-form-label">Stock</label>
                                <input type="number" class="form-control" id="stock" value="<%=session.getAttribute("UpdCantStock")%>" name="upd_stock">
                            </div>
                            <div class="mb-3">
                                <label for="cant_alert" class="col-form-label">Cantidad Alerta</label>
                                <input type="number" class="form-control" id="cant_alerta" value="<%=session.getAttribute("UpdCantAlerta")%>" name="upd_cant_alerta">
                            </div>
                            <div class="modal-footer">
                                <a  class="btn btn-secondary" data-bs-dismiss="modal" href="./profile.jsp">Cerrar</a>
                                <button type="submit"  class="btn btn-primary">Insertar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/3d7f604ae9.js" crossorigin="anonymous"></script>
    </body>
</html>
