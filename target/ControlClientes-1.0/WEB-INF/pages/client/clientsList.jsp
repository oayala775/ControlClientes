<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clients">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Clients balance</h4>
                    </div>
                    <table class="table table-striped ">
                        <thead class="table-primary">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Balance</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clients}">
                                <tr>
                                    <td>${client.idClient}</td>
                                    <td>${client.name} ${client.lastName}</td>
                                    <td> <fmt:formatNumber value="${client.balance}" type="currency"/> </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ControllerServlet?accion=edit&idClient=${client.idClient}"
                                           class="btn btn-secondary">
                                            <i class="fa-solid fa-pen"></i> Edit
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total balance</h3>
                        <h4 class="display-4"> <fmt:formatNumber value="${totalBalance}" type="currency"/> </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total clients</h3>
                        <h4 class="display-4"> 
                            <i class="fa-solid fa-users"></i> ${totalClients}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>