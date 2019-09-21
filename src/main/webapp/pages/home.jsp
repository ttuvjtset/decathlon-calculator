<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Decathlon Calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="mt-3"><a class="text-dark" href="/">Decathlon Calculator<a></h2>
    <div class="card mt-4">
        <div class="card-body">
            <spring:hasBindErrors name="eventAndRawPerformance">
                <div class="alert alert-danger" role="alert">
                    <h4>Errors:</h4>
                    <ul>
                        <c:forEach var="error" items="${errors.allErrors}">
                            <li><spring:message message="${error}"/></li>
                        </c:forEach>
                    </ul>
                </div>
            </spring:hasBindErrors>

            <form action="calculate">
                <div class="form-group">
                    <label for="eventSelect">Decathlon event:</label>
                    <select class="form-control" name="event" id="eventSelect">
                        <c:forEach var="event" items="${events}">
                            <option value="${event.getSeqNumber()}">${event.getEventName()} (${event.getEventUnits()})
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rawPerformanceInput">Raw performance:</label>
                    <input name="rawPerformance" class="form-control" id="rawPerformanceInput">
                </div>
                <button type="submit" class="btn btn-secondary mt-3">Calculate points</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>