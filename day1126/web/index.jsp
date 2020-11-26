<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>CKEditor示例</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script>
      onload=function(){
        imgCode.onclick=function(){
          // console.log('imgcode click');
          this.src="code.jpg?t="+new Date().getTime();
        }
      }
    </script>
    <style>
      .container{
        width: 480px;
        margin: 20px auto;
      }
    </style>
  </head>
  <body>
  <form action="cke.jsp" method="post">
    <div class="container">
      <input type="text" name="code">
      <img src="code.jpg" id="imgCode" title="看不清楚，点击换一张">
      <br>
      <textarea name="cke" class="ckeditor"></textarea>
      <button>提交</button>
    </div>
  </form>


  </body>
</html>
