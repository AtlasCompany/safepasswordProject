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
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>--%>
    <script src="js/jquery-2.1.0.js"></script>
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
            <h1>
                <p class="subscribe" id="whatIsThis" style="line-height: 16px">
                    <span id="click">
                    What is this?
                <span style="font-size: 12px;"><br>Click <span style="color: #ff6600">Here</span></span>
                    </span>
                </p>
            </h1>

            <p class="subscript" id="explain" hidden="hidden">
                ما بر اساس تزه ترین الگوریتم های هک و کرک پسورد ، رمز های شما را مورد بررسی قرار میدهیم تا میزان امن
                بودن آنها را در مقابل جدید ترین متد
                هکر ها بیازماییم.ما بر اساس تزه ترین الگوریتم های هک و کرک پسورد ، رمز های شما را مورد بررسی قرار میدهیم
                تا میزان امن
                بودن آنها را در مقابل جدید ترین متد
                هکر ها بیازماییم.
            </p>

            <!-- Begin MailChimp Signup Form -->
            <div id="mc_embed_signup">
                <!-- CHANGE THIS LINE BELOW TO YOUR OWN MAILCHIMP CODE -->
                <form action="http://www.safepassword.ir/result" method="post"
                      id="pass-form" name="pass-form" class="validate"
                      novalidate>

                    <input type="password" value="" name="pass" class="email" id="tbPassword"
                           placeholder="Your password" data-validation-allowing="not null"
                           required>

                    <!-- CHANGE THIS LINE BELOW TO YOUR OWN MAILCHIMP CODE -->

                    <div class="clear"><input type="submit" value="Is it safe?" name="subscribe"
                                              id="mc-embedded-subscribe" class="button"></div>
                </form>
            </div>
            <!-- MAIlCHIMP END -->
        </section>
        <!-- subscribe end -->

        <footer class="footer" id="footer">
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

<script src="js/plugins.js"></script>
<script src="js/init.js"></script>
<script src="js/countdown-localisation.js"></script>
<script src="js/explain.js"></script>

</body>
</html>
