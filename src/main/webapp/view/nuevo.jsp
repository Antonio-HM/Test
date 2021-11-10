<%-- 
    Document   : nuevo
    Created on : 12-02-2019, 10:24:50 AM
    Author     : eddie.hernandezusam
--%>

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
            <form method="post" action="control">
                <div class="row">
                    <div class="col m12">
                        <div class="card-title light-blue  white-text center z-depth-2">
                            <h3>Registro de ventas </h3>
                        </div>                       
                    </div>
                </div>  
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione Region</div>
                    <div class="col m3">
                        <select name="cmbrgion">
                           <c:forEach items="${tienda}" var="ti">
                                <option value="${ti.id_tienda}"> ${ti.region}</option>
                            </c:forEach>>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione Tienda</div>
                    <div class="col m3">
                        <select name="cmbtienda">
                            <c:forEach items="${tienda}" var="ti"  >
                                <option value="${ti.id_tienda}"> tienda :${ti.nombre_tienda}  </option>
                            </c:forEach>>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
               
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione Turno</div>
                    <div class="col m3">
                        <select name="cmbturno">
                            <c:forEach items="${tienda}" var="ti">
                                <option value="${ti.id_tienda}"> ${ti.turno}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione Vendedor</div>
                    <div class="col m3">
                        <select name="cmbvendedor">
                            <c:forEach items="${encargado}" var="en">
                                <option value="${en.id_encargado}"> ${en.nombre_empleado}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione producto</div>
                    <div class="col m3">
                        <select name="cmbproducto">
                        <c:forEach items="${venta}" var="ven">
                                <option value="${ven.id_venta}"> ${ven.producto}</option>
                        </c:forEach>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccione precio</div>
                    <div class="col m3">
                        <select name="cmbprecio">
                           <c:forEach items="${venta}" var="ven">
                                <option value="${ven.id_venta}"> ${ven.monto_venta}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col m3"></div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">
                        <input type="submit" name="btnGu" value="Guardar" class="btn black white-text z-depth-2"/>
                    </div>
                    <div class="col m3"></div>
                    <div class="col m3"></div>
                </div>
            </form>
        </div>
        <script src="resourses/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="resourses/js/materialize.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('select').formSelect();
            });
        </script>
    </body>
</html>