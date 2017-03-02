<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.js"/>" rel="stylesheet" >
</head>
<body>
<p>Submit a file to view its size.</p>

<form:form action="/getsize/showfilesize" method="post"
           commandName="fileSize" enctype="multipart/form-data">
    <div class="form-group">
        <label for="fileSize">Upload file</label>
        <input id="fileSize" type="file" name="file" class="form:input-large"/>
    </div>
    <input type="submit" value="submit" class="btn btn-default"/>
</form:form>

</body>
</html>
