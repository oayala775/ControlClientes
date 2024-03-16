<div class="modal fade" id="addModalClient">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Add client</h5>
                <button class="btn-close" data-bs-dismiss="modal"> </button>
            </div>
            <form action="${pageContext.request.contextPath}/ControllerServlet?accion=insert" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" name="lastName" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="tel" class="form-control" name="phoneNumber" required>
                    </div>
                    <div class="form-group">
                        <label for="balance">Balance</label>
                        <input type="number" class="form-control" name="balance" required step="any">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
