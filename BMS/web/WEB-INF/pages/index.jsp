<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
    <%@include file="/WEB-INF/pages/inc.jsp"%>
    <script>
      $(function(){
        $("#carousel-example-generic").carousel({
          interval:2000,
        });
      });
    </script>
  </head>
  <body>
  <%@ include file="/WEB-INF/pages/menu.jsp"%>
  <h2 style="color: red">${msg}</h2>
  <div class="container">
    <div class="row">
      <div class="col-xs-6 col-xs-offset-3">
        <div class="col-xs-12">
          <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <c:forEach var="i" items="${ids}" varStatus="sta">
              <li data-target="#carousel-example-generic" data-slide-to="${sta.index}"
                  class="${sta.index eq 0?'active':''}"></li>
              </c:forEach>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
              <c:forEach var="i" items="${ids}" varStatus="sta">
              <div class="item ${sta.index eq 0?'active':''}">
                <img src="imgs/book/${i}.jpg" >
              </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
