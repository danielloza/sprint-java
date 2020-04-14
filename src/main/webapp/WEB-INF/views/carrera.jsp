<%-- 
    Document   : usuario
    Author     : DANIEL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="index.jsp" %>
<br />
<br />
<br />
<div class="container">   
    <div class="panel-group">
        <div class="panel panel-primary">
            <div class="panel-heading">Listado de Usuarios</div>
            <div id="contenidoPantalla" class="panel-body">        
                <div class="row">
                    <div class="form-group">
                        <div class="btn btn-group">
                            <button id="agregarU" class="btn btn-info" onclick="btnCarrera();" data-toggle="modal" data-target="#myModal"> 
                                <span class="glyphicon glyphicon-plus"></span>Agregar Carrera</button>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                        <input type="text" class="form-control pull-right" style="width:20%" 
                               id="search" onkeyup="busquedaTbl('tableCarrera');" placeholder="Busqueda">
                    </div>
                    <!-- Listado de usuarios -->
                    <div  class="col-md-12">
                        <div class="table-responsive">
                            <table id="tableCarrera" class="table table-striped">
                                <thead>
                                    <tr>                            
                                        <th>No</th>
                                        <th>Nombre Carrera</th>
                                        <th>Actualizar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody id="bodytabla">
                                    <c:forEach items="${lcarrera}" var="carrera" varStatus="count"> 
                                        <tr>                               
                                            <td id="nocarrera">${count.count}</td>
                                            <td id="carrera">${carrera.nombre}</td>
                                            <td><button id="mostrarC" onclick="mostrarCarrera();" data-toggle="modal" data-target="#myModal" class="btn btn-warning">
                                                    <span class="glyphicon glyphicon-pencil"></span> </button></td>
                                            <!-- Eliminar -->
                                            <td><button id="mostrarC" onclick="eliminarUsuario1();"  class="btn btn-danger">
                                                    <span class="glyphicon glyphicon-remove"></span> </button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>           
                    </div>
                </div><!-- row-->
            </div><!--class body -->
        </div><!-- panel-primary-->
    </div>  <!-- panel-group-->  
</div><!--class container -->


<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog" data-backdrop="static" 
         data-keyboard="false">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Fomulario para administrar las carreras</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal"  modelAttribute="user" id="frmCarrera">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carrera">Nombre Carrera<b style="color: red" title="Campo Requerido">*</b></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nick" placeholder="Ingrese alias" onchange="verificarUsuario();"required>
                            </div>
                        </div>
                       
                        <div class="form-group">                                
                            <div class="col-sm-10">
                                <input type="text"  style="display:none" class="form-control" id="idCarrera" >
                            </div>
                        </div>
                    </form> 
                </div><!--modal body-->
                <div class="modal-footer">
                    <div class="form-group">
                        <button id="guardarU" type="button" class="btn btn-success" onclick="agregarCarrera1();">Guardar</button>
                        <button id="actualizarU" onclick="actualizarUsuario();" class="btn btn-primary" >Actualizar</button>
                        <a id="user" href="<c:url value='/usuario'/>"><button type="button" class="btn btn-default" onclick="limpiarForm('frmUsuario');">Cerrar</button></a>

                    </div>
                </div><!--modal footer-->
            </div><!--modal6-container-->
        </div><!--modal dialog-->
    </div><!--modalfade-->
</div><!--container-->
</body>
</html>
