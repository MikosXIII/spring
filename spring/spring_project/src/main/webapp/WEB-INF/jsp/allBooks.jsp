<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>All Books</h1>

<a href="/books/addNew">Add new book</a>


<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td><a href="/books/edit/${book.id}">Edit</a></td>
            <td><a href="/books/delete/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>