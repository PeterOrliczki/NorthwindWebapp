<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task 4</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
        <a href="task1"><li>Task 1</li></a>
        <a href="task2"><li>Task 2</li></a>
        <a href="task3"><li>Task 3</li></a>
        <a href="task4"><li>Task 4</li></a>
        <a href="task5"><li>Task 5</li></a>
        <br>
        <p> Task 4 results </p>
        <br>
        <c:choose>
          <c:when test="${fn:length(task4) == 0}">
            <p> No company found </p>
          </c:when>
          <c:otherwise>
                <table>
                    <tr>
                        <td>Company</td>
                        <td>Order ID</td>
                    </tr>
                    <br>
                    <c:forEach var="task" items="${task4}">
                        <tr>
                        <td><c:out value="${task.company}"/></td>
                        <td>
                         <c:forEach var="orderId" items="${task.orderIds}">
                                <c:out value="${orderId}"/>
                        </c:forEach>
                        </td>
                        </tr>
                    </c:forEach>
                </table>
          </c:otherwise>
        </c:choose>
        <br>
        <p> Filter by company: </p>
        <form method="POST" action="task4">
            <input type="text" id="filter" name="filter">
            <input type="submit" value="Filter">
        <form>
    </body>
</html>
