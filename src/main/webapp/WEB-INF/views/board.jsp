<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Board</title>
	
	 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <script type="application/javascript" src="http://code.jquery.com/jquery-1.11.1.js"></script>

    <script type="application/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	
</head>
<body>

<c:forEach var="board" items="${boards}">
	<c:out value="${board.id}"/> 
	<%-- <a href="/updateBoardWithTemplate/<c:out value="${board.id}"/>"> --%>
		 	
 	<a href="/view/<c:out value="${board.id}"/>"> 
	<c:out value="${board.name}"/></a>
	<%-- <c:out value="${board.contents}"/>  --%>
	<a href="/deleteBoard?id=<c:out value="${board.id}"/>"><img src="/resources/icon_18832.png" height="20" width="20"></a><br> 
</c:forEach>
	<a href="/write/${id}"/>write</a>

<%-- <form action="insertBoard" method="get">
	id : <input type="text" name="id" value="<c:out value="${id}"/>" readonly="true"><br>
	name : <input type="text" name="name"><br>
	contents : <textarea name="contents" rows="3" cols="80" ></textarea>
	<button type="submit">submit!!</button>
</form>  --%>


<!-- free Board <br>
 <textarea rows="3" cols="50" 
			name="cmmttext" id="cmmttext2086" 
			class="box" 
			style="color: grey;"
			placeholder="Enter" > 
</textarea> 
<button type="submit" id="addButton"  > okay </button>
 
<div class="content">
        <ul class="list"></ul>
</div>
    <script type="text/javascript">

        var input = $("#cmmttext2086");
        var button = $("#addButton");

        input.on("keydown" , function(e){
           if(e.keyCode == 13){
               button.click();
           }
        });

        button.click(function(e){
            $(".list").append("<li>" + input.val() + "</li>");
            input.val("");
        });
    </script> -->

</body>
</html>

