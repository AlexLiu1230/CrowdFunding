<%--
  Created by IntelliJ IDEA.
  User: yuhsin
  Date: 2023/7/19
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <script
            src="https://code.jquery.com/jquery-3.7.0.js"
            integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
            crossorigin="anonymous"></script>
    <script type="text/javascript">

        $(function () {
            $("#btn1").click(function () {
                $.ajax({
                    "url": "send/array/one.html",
                    "type": "post",
                    "data": {
                        "array": [5, 8, 12]
                    },
                    "dataType": "text",
                    "success": function (response) {
                        alert(response);
                    },
                    "error": function (response) {
                        alert(response);
                    }
                });
            });

            var array = [5, 8, 12];
            var requestBody = JSON.stringify(array);
            $("#btn2").click(function () {
                $.ajax({
                    "url": "send/array/two.html",
                    "type": "post",
                    "data": requestBody,
                    "contentType": "application/json;charset=UTF-8",
                    "dataType": "text",
                    "success": function (response) {
                        alert(response);
                    },
                    "error": function (response) {
                        alert(response);
                    }
                });
            });

            $("#btn3").click(function () {
                var student = {
                    "studentId": 5,
                    "studentName": "Alex",
                    "studentAddress": {
                        "province": "測試",
                        "city": "城市Ａ",
                        "street": "StreetA"
                    },
                    "subjectList": [
                        {
                            "subjectName": "subjectA",
                            "subjectScore": 99
                        },
                        {
                            "subjectName": "subjectB",
                            "subjectScore": 87
                        }
                    ],
                    "map": {
                        "k1": "v1",
                        "k2": "v2"
                    }
                };
                var requestBody = JSON.stringify(student);

                $.ajax({
                    "url": "send/array/complex/object.html",
                    "type": "post",
                    "data": requestBody,
                    "contentType": "application/json;charset=UTF-8",
                    "dataType": "text",
                    "success": function (response) {
                        alert(response);
                    },
                    "error": function (response) {
                        alert(response);
                    }
                })
            });
        });

    </script>
</head>
<body>

<a href="test/ssm.html">測試SSM整合環境</a>
<br/>
<button id="btn1">Send [5, 8, 12] One</button>
<br/>
<button id="btn2">Send [5, 8, 12] Two</button>
<br/>
<button id="btn3">Send Complex Object</button>

</body>
</html>
