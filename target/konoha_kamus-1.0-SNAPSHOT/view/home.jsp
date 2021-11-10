
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="resourses/css/materialize.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form>
                <div class="row">
                    <div class="col m12"></div>  
                    <div class=" card-title orange white-text center z-depth-1">
                        <h3>KONOHA SHOP</h3>
                        <div class="col m12"></div>  
                        <div class=" card-title blue white-text center z-depth-1">
                            <h5>Control de Ventas Black Friday</h5>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col m12">
                        <table class="black center white-text">
                            <tr>
                                <th>Id</th>
                                <th>Region</th>
                                <th>Tienda</th>
                                <th>Giro comercal</th>
                                <th>Turno</th>
                                <th>Vendedor</th>
                                <th>Producto</th>
                                <th>precion $</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${datos}" var='d'>
                                <tr>
                                    <td>${d.id_registro}</td>
                                    <td>${d.datatienda.region}</td>
                                    <td>${d.datatienda.nombre_tienda}</td>
                                    <td>${d.datatienda.giro_comercial}</td>
                                    <td>${d.datatienda.turno}</td>
                                    <td>${d.datatienda.dataencargado.nombre_empleado}</td>
                                    <td>${d.datatienda.dataencargado.dataventa.producto}</td>
                                    <td>${d.datatienda.dataencargado.dataventa.monto_venta}</td>
                                    <td>
                                        <a href="control?action=eliminar&id=${d.id_registro}" class="btn red white-text">ELIMINAR</a>
                                    </td>
                                    <td>
                                      
                                    </td>
                                </tr>
                            </c:forEach>
                          </table>
                        <br>
                        <a href="control?action=nuevo" class="btn light-blue z-depth-3">nuevo registro</a>
                    </div>
                </div>
            </form>         
        </div>
    </body>
</html>

