function progress(percent, $element) {
    var progressBarWidth = percent * $element.width() / 100;
    if (percent <= 30) {
        $("#percentVariable").css("background-color", "#FF0000");
    } else if (percent > 30 && percent <= 80) {
        $("#percentVariable").css("background-color", "#FFFF00");
        $("#percentVariable").css("color", "#000000");
    } else if (percent > 80 && percent <= 95) {
        $("#percentVariable").css("background-color", "#0099ff");
    } else if (percent > 90 && percent <= 100) {
        $("#percentVariable").css("color", "#000000");
        $("#percentVariable").css("background-color", "#00FF00");
    }
    $element.find('div').animate({ width: progressBarWidth }, 2000).html(percent + "%&nbsp;");
}