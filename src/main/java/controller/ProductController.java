/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import database.ProductosDAO;
import database.SucursalDAO;
import database.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Producto;
import model.Sucursal;
import model.User;

/**
 *
 * @author nicol
 */
@WebServlet(name = "ProducController", urlPatterns = {"/product/*"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getPathInfo();
            HttpSession session = request.getSession();
            SucursalDAO sdao = new SucursalDAO();
            UserDAO userDB = new UserDAO();
            ProductosDAO pdao = new ProductosDAO();
            Producto productoUpdate = null;
            int idprod = -1;

            switch (action) {

                case "/insert":
                    Producto producto;
                    String nombreProducto;
                    float precio;
                    int cantidad_stock,
                     cantidad_alerta;
                    nombreProducto = request.getParameter("product-name");
                    precio = Float.valueOf(request.getParameter("price"));
                    cantidad_stock = Integer.valueOf(request.getParameter("stock"));
                    cantidad_alerta = Integer.valueOf(request.getParameter("cant_alerta"));
                    producto = new Producto(100, nombreProducto, precio, cantidad_stock, cantidad_alerta, (int) session.getAttribute("idLocal"));
                    pdao.insertarProducto(producto);
                    response.sendRedirect("/views/profile.jsp");
                    break;
                case "/update":
                    idprod = Integer.valueOf(request.getParameter("iddddd"));
                    productoUpdate = pdao.getProductoByID(idprod);
                    nombreProducto = productoUpdate.getNombreProducto();
                    precio = productoUpdate.getPrecio();
                    cantidad_stock = productoUpdate.getCantidad_stock();
                    cantidad_alerta = productoUpdate.getCantidad_alerta();
                    session.setAttribute("UpdName", nombreProducto);
                    session.setAttribute("UpdPrecio", precio);
                    session.setAttribute("UpdCantStock", cantidad_stock);
                    session.setAttribute("UpdCantAlerta", cantidad_alerta);
                    session.setAttribute("idProdUpd", idprod);
                    // response.sendRedirect("/views/profile.jsp");

                    response.sendRedirect("/views/update.jsp");
                    break;

                case "/applyUpdate":
                    idprod = (int) session.getAttribute("idProdUpd");
                    productoUpdate = pdao.getProductoByID(idprod);

                    nombreProducto = request.getParameter("upd_product-name");
                    precio = Float.valueOf(request.getParameter("upd_price"));
                    cantidad_stock = Integer.valueOf(request.getParameter("upd_stock"));
                    cantidad_alerta = Integer.valueOf(request.getParameter("upd_cant_alerta"));
                    productoUpdate.setIdProducto(idprod);
                    productoUpdate.setCantidad_stock(cantidad_stock);
                    productoUpdate.setNombreProducto(nombreProducto);
                    productoUpdate.setPrecio(precio);
                    productoUpdate.setCantidad_alerta(cantidad_alerta);
                    session.setAttribute("UpdName", nombreProducto);
                    session.setAttribute("UpdPrecio", precio);
                    session.setAttribute("UpdCantStock", cantidad_stock);
                    session.setAttribute("UpdCantAlerta", cantidad_alerta);
                    session.setAttribute("idProdUpd", idprod);

                    pdao.updateProducto(productoUpdate);
                    response.sendRedirect("/views/profile.jsp");

                    break;

                case "/delete":
                    idprod = Integer.valueOf(request.getParameter("iddddd"));


                    pdao.deleteProduct(idprod);
                    response.sendRedirect("/views/profile.jsp");

                    break;
                default:

                    break;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
