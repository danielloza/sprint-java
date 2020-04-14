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
            <div class="panel-heading">Listado de Carreras</div>
            <div id="contenidoPantalla" class="panel-body">        
                <div class="row">
                    <div class="form-group">
                        <div class="btn btn-group">
                            <button id="agregarM" class="btn btn-info" onclick="btnMateria();" data-toggle="modal" data-target="#myModal"> 
                                <span class="glyphicon glyphicon-plus"></span>Agregar Materia</button>
                        </div>
                       <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                        <input type="text" class="form-control pull-right" style="width:20%" 
                               id="search" onkeyup="busquedaTbl('tableMateria');" placeholder="Busqueda">
                    </div>
                    <!-- Listado de usuarios -->
                    <div  class="col-md-12">
                        <div class="table-responsive">
                            <table id="tableMateria" class="table table-striped">
                                <thead>
                                    <tr>                            
                                        <th>No</th>
                                        <th>Nombre Materia</th>
                                        <th>Cuatrimestre</th>
                                        <th>Carrera</th>
                                        <th>Actualizar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody id="bodytabla">
                                    <c:forEach items="${lmateria}" var="materia" varStatus="count"> 
                                        <tr>                               
                                            <td id="idMateria" style="display:none">${materia.materiaid}</td>
                                            <td id="noMateria">${count.count}</td>
                                            <td>${materia.materianame}</td>
                                            <td>${materia.cuatrimestre}</td>
                                            <td id="idMateria" style="display:none">${materia.carrera.carreraid}</td>
                                            <td>${materia.carrera.nombre}</td>
                                            <td><button id="mostrarM" onclick="mostrarMateria1();" data-toggle="modal" data-target="#myModal" class="btn btn-warning">
                                                    <span class="glyphicon glyphicon-pencil"></span> </button></td>
                                            <!-- Eliminar -->
                                            <td><button id="mostrarM" onclick="eliminarMateria();"  class="btn btn-danger">
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
                    <h3>Fomulario para administrar usuarios del sistema</h3>
                </div>
                <div class="modal-body">
                    <!--Formilario para agregar usuario -->
                    <form class="form-horizontal"  modelAttribute="materia" id="frmMateria">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="materia">Materia<b style="color: red" title="Campo Requerido">*</b></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mate" placeholder="Ingrese alias" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="cuatrimestre">Cuatrimestre<b style="color: red" title="Campo Requerido">*</b></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="cuatrimestre" placeholder="Ingrese password" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="control-label col-sm-2">Carreras<b style="color: red" title="Campo Requerido">*</b></label>
                            <div class="col-sm-4">
                                <!-- consulta catalogo -->
                                <select id="carrera" class="form-control">
                                    <option value="0">Seleccione una carrera</option>
                                    <c:forEach items="${lcarrera}" var="carreras">
                                        <option value="${carreras.carreraid}">${carreras.nombre} </option>
                                    </c:forEach>
                                </select>                                            
                            </div>                                       
                            <div class="col-sm-10">
                                <input type="text"  style="display:none" class="form-control" id="idMateria" >
                            </div>
                        </div>
                    </form> 
                </div><!--modal body-->
                <div class="modal-footer">
                    <div class="form-group">
                        <button id="guardarU" type="button" class="btn btn-success" onclick="agregarMateria();">Guardar</button>
                        <button id="actualizarU" onclick="actualizarMateria();" class="btn btn-primary" >Actualizar</button>
                        <a id="materia" href="<c:url value='/materia'/>"><button type="button" class="btn btn-default" onclick="limpiarForm('frmMateria');">Cerrar</button></a>

                    </div>
                </div><!--modal footer-->
            </div><!--modal6-container-->
        </div><!--modal dialog-->
    </div><!--modalfade-->
</div><!--container-->
</body>
</html>
