<%@tag description="Yemplate principal" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="title"%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" type="image/png" href="favicon.png" />

    <!-- CSS -->

    <link rel="stylesheet" type="text/css" href="assets/resources/css/template.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css">
</head>
<body>
<header>
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li>
                        <a href="/" class="nav-link px-2 text-light">
                            <span class="utfpr">UTFPR</span> - Desenvolvimento para web 4
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
</header>
<jsp:doBody></jsp:doBody>

<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy;2021 Desenvolvimento para web 4 - Avaliação 1</p>
    <ul class="list-inline">
        <li class="list-inline-item">
            <a href="#">Cristhian Albary da Silva</a>
        </li>
    </ul>
</footer>

<!-- JS Scripts -->
<script src="assets/resources/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
        integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
        crossorigin="anonymous"></script>
</body>
</html>