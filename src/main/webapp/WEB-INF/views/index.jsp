<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <div class="container">
            <form action="">
                <div>
                    <input type="text" name="searchparam" />
                    <button type="submit" id="btn-search">Search</button>
                </div>
            </form>
            <div id="searchResults-block">
                Search Results:
                <table>
                    <tr>
                        <th>ID</th>
                        <th>User Name</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.userName}</td>
                            <td>${user.status}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        
<!--        <script>
            $(document).on('ready',function (){
                $("#btn-search").on('click',function (){
                    $("#searchResults-block").show();
                });
            });
        </script>-->
    </body>
</html>
