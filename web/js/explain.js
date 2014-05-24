$(document).ready(function () {
    $("#click").click(function () {
        $("#whatIsThis").hide("fast", function () {
            $("#explain").slideDown("10000");
        });
    });
});