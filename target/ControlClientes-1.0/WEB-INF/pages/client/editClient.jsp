<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit client</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="icon" type="image/x-icon" href="WEB-INF/assets/images/favicon.ico">
        <script src="https://kit.fontawesome.com/4c03c984ba.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="/WEB-INF/pages/common/header.jsp"/>
        <form action="${pageContext.request.contextPath}/ControllerServlet?accion=modify&idClient=${client.idClient}" method="post" class="was-validated">
            <jsp:include page="/WEB-INF/pages/common/navigationButtonsEdition.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Edit client</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" name="name" required value="${client.name}">
                                </div>
                                <div class="form-group">
                                    <label for="lastName">Last Name</label>
                                    <input type="text" class="form-control" name="lastName" required value="${client.lastName}">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" required value="${client.email}">
                                </div>
                                <div class="form-group">
                                    <label for="phoneNumber">Phone Number</label>
                                    <input type="tel" class="form-control" name="phoneNumber" required value="${client.phoneNumber}">
                                </div>
                                <div class="form-group">
                                    <label for="balance">Balance</label>
                                    <input type="number" class="form-control" name="balance" required value="${client.balance}" step="any">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <jsp:include page="/WEB-INF/pages/common/footer.jsp"/>


        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
