<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it" class="h-100">
<head>
    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Inserisci Nuovo Elemento</title>
</head>
<body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <jsp:include page="../navbar.jsp" />
    <!-- Begin page content -->
    <main class="flex-shrink-0">
        <div class="container">
            <div class="alert alert-danger alert-dismissible fade show ${not empty errorMessage ? '' : 'd-none'}" role="alert">
                ${errorMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <div class="card">
                <div class="card-header">
                    <h5>Inserisci nuovo elemento</h5>
                </div>
                <div class="card-body">
                    <h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
                    <form enctype="multipart/form-data" method="post" action="save" novalidate="novalidate"
                          class="row g-3">
                        <div class="col-md-6 datiMalattia">
                            <label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
                            <input type="text" class="form-control" name="nome" id="nome" placeholder="Inserire nome"
                                   required>
                        </div>
                        <div class="col-md-6 datiMalattia">
                            <label for="cognome" class="form-label">Cognome <span class="text-danger">*</span></label>
                            <input type="text" class="form-control" name="cognome" id="cognome"
                                   placeholder="Inserire cognome" required>
                        </div>
                        <div class="col-md-6 datiMalattia">
                            <label for="email" class="form-label">Email <span class="text-danger">*</span></label>
                            <input type="text" class="form-control" name="email" id="email"
                                   placeholder="Inserire email" required>
                        </div>
                        <div class="col-md-6 datiMalattia">
                            <label for="foto" class="form-label">Foto <span class="text-danger">*</span></label>
                            <input class="form-control" type="file" id="foto" name="file" accept="image/jpeg, image/png, image/gif" required>
                        </div>
                        <div class="col-12">
                            <button type="submit" name="confirmButton" id="confirmButton" class="btn btn-primary">Conferma</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <!-- Footer -->
    <jsp:include page="../footer.jsp" />
</body>
</html>
