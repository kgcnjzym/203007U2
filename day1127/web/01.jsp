<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>栅格布局</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
      .bgblue{background-color: skyblue}
      .bgcyan{background-color: cyan}
    </style>
  </head>
  <body>
    <div class="container bgblue">
      <div class="row">
        <section class="col-xs-4 col-sm-3 bgcyan">col1</section>
        <section class="col-xs-4 col-sm-3">col2</section>
        <section class="col-xs-4 col-sm-3">col3</section>
        <section class="col-xs-4 col-sm-3">col4</section>
      </div>
    </div>
  </body>
</html>
