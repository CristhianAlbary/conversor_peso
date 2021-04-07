<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Erro">
    <jsp:body>
        <base href="${pageContext.request.contextPath}/">
        <div class="col-md-12 error-page" style="width: 100%; text-align: center;">
            <img src="${pageContext.request.contextPath}/assets/resources/img/error/500.jpg" />
        </div>
    </jsp:body>
</t:template>