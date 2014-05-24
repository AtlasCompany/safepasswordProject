<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Is it safe?</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, user-scalable=no, minimal-ui">

    <link rel="icon" type="image/png" href="/background/img/favicon.png">

    <link href='http://fonts.googleapis.com/css?family=Lato:300,700,300italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/modernizr.js"></script>

</head>
<body>

<div id="preloader">
    <img src="img/loader.gif" alt="Loading" id="loading-img">
</div>
<!-- preloader -->

<div class="page">
    <div class="content">

        <%--<header class="logo">--%>
        <%-- <img src="img/logo.svg" alt="Brand Logo">

         <h1>Decryption feature COMING SOON</h1>--%>
        <%--</header>--%>
        <!-- logo end -->

        <section class="timer">
            <div id="ticker"></div>
            <!-- ticker end -->
            <p>UNTIL DECRYPTION FEATURE LAUNCH</p>
        </section>
        <!-- timer end -->

        <section class="subscribe">
            <%
                Object mark = session.getAttribute("mark");
                String suggestionPass = (String) session.getAttribute("suggestion");
                String crackTime = (String) session.getAttribute("crackTime");
            %>
            <input id="mark" type="text" hidden="hidden" value="<%=mark%>">

            <p class="timer">

            <div class="timer" style="line-height: 16px">
                <div id="progressBar">
                    <div id="percentVariable"></div>
                </div>
            <%--<span style="color: #ff6600" id="moreInformation">More Information</span>--%>
        </div>
            </p>
            <div style="line-height: 19px">
                <p>
                        <%
                        if (suggestionPass != "") {
                    %>

                    Our suggestion password for maximum security:
                    <br>

                <p>
                    <%=suggestionPass%>
                </p>
                <%
                } else {
                %>
                <h1>
                    Your password is secure.
                </h1>
                <br>
                No suggestion for you.
                <%
                    }
                %>
                </p>
            </div>
            <p>

            <form action="http://www.safepassword.ir/" class="validate" novalidate>
                <input class="button" id="tryAgain" value="Try again" type="submit">
            </form>
            </p>
        </section>
        <!-- subscribe end -->
        <footer class="footer">
            </hr>
            <%--<a href="https://www.facebook.com/"><span class="fa fa-facebook"></span></a>--%>
            <%--<a href="https://twitter.com/"><span class="fa fa-twitter"></span></a>--%>
            <%--<a href="https://plus.google.com/ý"><span class="fa fa-google-plus"></span></a>--%>
            <%--<a href="https://dribbble.com/"><span class="fa fa-dribbble"></span></a>--%>
            <%--<a href="https://uk.linkedin.com/"><span class="fa fa-linkedin"></span></a>--%>
            Alireza Vahedi production
            <br>
            <br>
            Copyright &#169; 2014-2020,All right reserved.
        </footer>
        <!-- social end -->

    </div>
    <!-- content end -->
</div>
<!-- page end -->

<script src="js/jquery-2.1.0.js"></script>
<script src="js/plugins.js"></script>
<script src="js/init.js"></script>
<script src="js/countdown-localisation.js"></script>
<script src="js/explain.js"></script>
<script src="js/showPercent.js"></script>
<script>
    $(document).ready(function () {
        var mark = $("#mark").val();
        setTimeout(function () {
            progress(mark, $('#progressBar'))
        }, 1000);
    });
</script>
</body>
</html>
