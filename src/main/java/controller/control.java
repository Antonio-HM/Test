/*
 * @author eddie.hernandezusam
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import model.*;

@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {
registroDAO rDAO;
tiendaDAO tDAO;
encargadoDAO eDAO;
ventaDAO vDAO;

    public control(){
    super();
    rDAO = new registroDAO();
    tDAO = new tiendaDAO();
    eDAO = new encargadoDAO();
    vDAO = new ventaDAO();
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
       String ruta="";
       if(action.equalsIgnoreCase("inicio")){
           ruta ="view/home.jsp";  
           
           try {
               request.setAttribute("datos", rDAO.llenarData());
         
           } catch (Exception e) {
               e.printStackTrace();
             }
         }else if(action.equalsIgnoreCase("nuevo")){
          ruta = "view/nuevo.jsp";
          try {
              
               request.setAttribute("tienda", tDAO.llenarTienda());
               request.setAttribute("encargado", eDAO.llenarEncargado());
               request.setAttribute("venta", vDAO.llenarVenta());
           } catch (Exception e) {
               e.printStackTrace();
             }
         }else if(action.equalsIgnoreCase("nuevo")){
          ruta = "view/nuevo.jsp";
          
         }else if(action.equalsIgnoreCase("eliminar")){
             ruta ="view/home.jsp";
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                try {
               rDAO.eliminar(idEliminar);
               request.setAttribute("datos", rDAO.llenarData());
           } catch (Exception e) {
               e.printStackTrace();
           }
 
        }     
            RequestDispatcher dis= request.getRequestDispatcher(ruta);
            dis.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
              encargado e = new encargado();
              registro r = new registro();
              tienda t = new tienda();
              venta v = new venta();
              
            
              t.setId_tienda(Integer.parseInt(request.getParameter("cmbtienda")));
              //t.setId_tienda(Integer.parseInt(request.getParameter("cmbrgion")));
              //t.setId_tienda(Integer.parseInt(request.getParameter("cmbturno")));
              e.setId_encargado(Integer.parseInt(request.getParameter("cmbvendedor")));
              v.setId_venta(Integer.parseInt(request.getParameter("cmbproducto")));
              v.setId_venta(Integer.parseInt(request.getParameter("cmbprecio")));
              
              r.setDatatienda(t);
        
              
              try {
                  rDAO.Insertar(r);
                  
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }


}
