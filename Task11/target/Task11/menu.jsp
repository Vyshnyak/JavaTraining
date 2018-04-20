<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<html>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Login</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="note" items="${requestScope.notes}">
            <tr>
                <td>${note.id}</td>
                <td>${note.firstName}</td>
                <td>${note.login}</td>
                <td>
                    <button class="btn btn-info" data-toggle="modal" data-target="#updateModal${note.id}">Update</button>

                    <!-- LOGIN MODAL -->
                    <div class="modal" id="updateModal${note.id}">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Update</h5>
                                    <button class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <form method="POST" action="${pageContext.request.contextPath}/app/update">
                                        <input type="number" hidden name="id" value="${note.id}">
                                        <div class="form-group">
                                            <input type="text" name="firstName" placeholder="First Name" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="login" placeholder="Login" class="form-control">
                                        </div>
                                        <div class="modal-footer">
                                            <button class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary">Update</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>
                    <form method="POST" action="${pageContext.request.contextPath}/app/delete">
                        <input type="number" hidden name="id" value="${note.id}">
                        <input class="btn btn-info" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <button class="btn btn-info" data-toggle="modal" data-target="#createModal">Create</button>

                <!-- LOGIN MODAL -->
                <div class="modal" id="createModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Create</h5>
                                <button class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form method="POST" action="${pageContext.request.contextPath}/app/create">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" name="firstName" placeholder="First Name" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="text" name="login" placeholder="Login" class="form-control">
                                    </div>
                                    <div class="modal-footer">
                                        <button class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%--<form method="POST" action="${pageContext.request.contextPath}/app/create">
                    <input type="number" hidden name="id" value="${note.id}">
                    <input type="submit" value="Create">
                </form>--%>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
