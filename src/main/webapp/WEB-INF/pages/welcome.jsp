<%--
  Created by IntelliJ IDEA.
  User: alexandr
  Date: 16.7.15
  Time: 12.48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/registration.js"></script>
  <title></title>
</head>
<body>
<table>
  <tr>
    <td colspan="2"><spring:message code="messages.welcome"/>  ${cookie.firstName.value}  +   ${cookie.lastName.value}</td>
  </tr>
  <tr>
    <td>
      <spring:message code="messages.yourLanguage"/><br>
      <spring:message code="messages.language"/>
    </td>
    <td>

    </td>
  </tr>
  <tr>
    <td colspan="2"><a href="/logout"><spring:message code="messages.logout"/> </a> </td>
  </tr>
</table>



</body>
</html>
