<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pl-PL">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <title>Cat curiosities</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cat curiosities</h1>
                    <form:form modelAttribute="catInfo">
                        <div class="form-group-lg">
                            <form:label path="fact">Fact:</form:label>
                            <form:input path="fact" class="form-control"/>
                        </div>
                        <div class="form-group-lg">
                            <form:label path="length">Length</form:label>
                            <form:input path="length" class="form-control"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </section>
    </body>
</html>