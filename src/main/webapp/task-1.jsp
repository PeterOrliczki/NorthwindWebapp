<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task 1</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
        <a href="task1"><li>Task 1</li></a>
        <a href="task2"><li>Task 2</li></a>
        <a href="task3"><li>Task 3</li></a>
        <a href="task4"><li>Task 4</li></a>
        <a href="task5"><li>Task 5</li></a>
        <br>
        <p> Task 1 results </p>
        <br>
        <c:choose>
          <c:when test="${fn:length(task1) == 0}">
            <p> No company found </p>
          </c:when>
          <c:otherwise>
                <table>
                    <tr>
                        <td>Product</td>
                        <td>Company</td>
                    </tr>
                    <br>
                    <c:forEach var="task" items="${task1}">
                        <tr>
                            <td><c:out value="${task.product}"/></td>
                            <td><c:out value="${task.company}"/></td>
                        </tr>
                    </c:forEach>
                </table>
          </c:otherwise>
        </c:choose>
        <br>
        <p> Filter by company: </p>
        <form method="POST" action="task1">
            <input type="text" id="filter" name="filter">
            <input type="submit" value="Filter">
        </form>
    </body>
</html>
