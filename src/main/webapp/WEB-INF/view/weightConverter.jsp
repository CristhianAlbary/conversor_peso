<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Conversor de Peso">
    <jsp:body>
        <div class="container-fluid">
            <div class="row form-row">
                <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10 col-xl-8 col-xxl-6 form-container">
                    <main>
                        <div class="py-5 text-center">
                            <h2>Conversor de peso</h2>
                        </div>
                        <div class="row g-5">
                            <div class="col-md-5 col-lg-4 order-md-last">
                                <h4 class="d-flex justify-content-between align-items-center mb-3">
                                    <span class="text-primary">Ultimas 5 conversões</span>
                                </h4>
                                <c:if test="${not empty convertions}">
                                <ul class="list-group mb-3">
                                    <c:forEach var="convertion" items="${convertions}" varStatus="loop">
                                    <li class="list-group-item d-flex justify-content-between lh-sm">
                                        <div>
                                            <h6 class="my-0">Conversão ${loop.index + 1}</h6>
                                            <span class="text-muted">${convertion}</span>
                                        </div>
                                    </li>
                                    </c:forEach>
                                </ul>
                                </c:if>
                            </div>

                            <div class="col-md-7 col-lg-8">
                                <h4 class="mb-3">Conversor</h4>
                                <form class="needs-validation" action="converter" method="post">
                                    <div class="row g-3">
                                        <div class="col-md-3">
                                            <label class="form-label">De *</label>
                                            <select class="form-select" name="for" required>
                                                <option value="kg" selected>KG</option>
                                                <option value="g">G</option>
                                            </select>
                                            <div class="invalid-feedback">
                                                Selecione uma unidade.
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <label class="form-label">Para *</label>
                                            <select class="form-select" name="to" required>
                                                <option value="g" selected>G</option>
                                                <option value="kg">KG</option>
                                            </select>
                                            <div class="invalid-feedback">
                                                Selecione uma unidade.
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <label for="zip" class="form-label">Valor *</label>
                                            <input type="text" class="form-control" id="zip" placeholder="" name="convertValue" required>
                                            <div class="invalid-feedback">
                                                O valor é obrigatório.
                                            </div>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <button class="w-100 btn btn-primary btn-lg" type="submit">Converter</button>
                                </form>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>