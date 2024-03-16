<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 my-1">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Back to index
                </a>
            </div>
            <div class="col-md-3 my-1">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Confirm edition
                </button>
            </div>
            <div class="col-md-3 my-1">
                <a href="${pageContext.request.contextPath}/ControllerServlet?accion=delete&idClient=${client.idClient}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Delete client
                </a>
            </div>
            
        </div>
    </div>
</section>
