<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Ewidencja wydatkow</h1>

<a href="/wydatki/addNew">Dodaj wydatek</a>

<table>
    <tr>
        <th>Na co poszlo</th>
        <th>ilosc</th>
        <th>Kwota</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${wydatki}" var="wydatek">
        <tr>
            <td>${wydatek.naco}</td>
            <td>${wydatek.ilosc}</td>
            <td>${wydatek.kwota}</td>
            <td><a href="/wydatki/edit/${wydatek.id}">Edit</a></td>
            <td><a href="/wydatki/delete/${wydatek.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>