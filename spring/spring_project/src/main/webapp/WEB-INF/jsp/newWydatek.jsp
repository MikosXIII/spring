<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <h1>Dodaj wydatek</h1>

        <form:form modelAttribute="form" action="/wydatki/save">
            <form:errors path="" element="div" />
            <div>
                <form:label path="naco">Na co poszlo</form:label>
                <form:input path="naco" />
                <form:errors path="naco" />
            </div>
            <div>
                <form:label path="ilosc">Ilosc</form:label>
                <form:input path="ilosc" />
                <form:errors path="ilosc" />
            </div>
            <div>
                <form:label path="kwota">Kwota</form:label>
                <form:input path="kwota" />
                <form:errors path="kwota" />
            </div>
            <div>
                <input type="submit" />
            </div>
        </form:form>
    </body>
</html>