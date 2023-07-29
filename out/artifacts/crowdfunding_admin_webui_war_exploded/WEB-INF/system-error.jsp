<%--
  Created by IntelliJ IDEA.
  User: yuhsin
  Date: 2023/7/26
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script
            src="https://code.jquery.com/jquery-3.7.0.js"
            integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function (){
                //等於瀏覽器的"上一頁"按鈕
                window.history.back();
            })
        })
    </script>

    <style>
    </style>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <h2 class="form-signin-heading" style="text-align: center">
        <i class="glyphicon glyphicon-log-in"></i>系統消息
    </h2>
    <!--
        requestScope對應的是存放request域資料的Map
        requestScope.exception等於request.getAttribute("exception")
        requestScope.exception.message等於再去做getMessage()
    -->
    <h3 style="text-align: center">${requestScope.exception.message}</h3>
    <button style="width: 150px; margin: auto" class="btn btn-lg btn-success btn-block">返回上一頁</button>
</div>

</body>
</html>

