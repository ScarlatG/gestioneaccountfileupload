<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Visualizza Account</title>
</head>
<body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <jsp:include page="../navbar.jsp" />

    <!-- Begin page content -->
    <main class="flex-shrink-0">
        <div class="container">
            <div class="card">
                <div class="card-header">Dettaglio Account</div>
                <div class="card-body">
                    <img src="${photo}" class="rounded-circle img-thumbnail mx-auto d-block" style="width: 200px; height: 200px; object-fit: cover;">
                    <dl class="row">
                        <dt class="col-sm-3 text-sm-end">Nome:</dt>
                        <dd class="col-sm-9">${show_account_attr.nome}</dd>
                    </dl>
                    <dl class="row">
                        <dt class="col-sm-3 text-sm-end">Cognome:</dt>
                        <dd class="col-sm-9">${show_account_attr.cognome}</dd>
                    </dl>
                    <dl class="row">
                        <dt class="col-sm-3 text-sm-end">Email:</dt>
                        <dd class="col-sm-9">${show_account_attr.email}</dd>
                    </dl>
                    <dl class="row">
                        <dt class="col-sm-3 text-sm-end">Data creazione:</dt>
                        <dd class="col-sm-9">${show_account_attr.dataCreazione}</dd>
                    </dl>
                </div>
                <div class="card-footer">
                    <a href="${pageContext.request.contextPath}/account/" class="btn btn-outline-warning" style="width: 100px">
                        <i class="fa fa-chevron-left"></i> Indietro
                    </a>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="../footer.jsp" />
</body>
</html>
