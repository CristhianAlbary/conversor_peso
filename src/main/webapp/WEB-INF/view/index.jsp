<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Conversor de Peso">
    <jsp:body>
        <div class="px-4 py-5 my-5 text-center">
            <h1 class="display-5 fw-bold">Conversor de Peso</h1>
            <div class="col-lg-6 mx-auto">
                <p class="lead mb-4" onclick="alert()">
                    Essa ferramento possibilita que você possa converter valores em determinadas
                    unidades de medida para outras unidades de medida. Por exemplo, converter 10
                    Quilogramas em gramas.
                </p>
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                    <form class="needs-validation" action="homeController" method="post">
                        <div class="col-md-12">
                            <label for="zip" class="form-label">Identificação *</label>
                            <input type="text" class="form-control" id="zip" placeholder="Digite seu nome" name="identity" required>
                            <div class="invalid-feedback">
                                <c:if test="${not empty message}">
                                    ${message}
                                </c:if>
                                <c:if test="${!not empty message}">
                                    A identificação é obrigatória.
                                </c:if>
                            </div>
                        </div>
                        <br>
                        <button class="w-100 btn btn-primary btn-lg" type="submit">Iniciar</button>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>