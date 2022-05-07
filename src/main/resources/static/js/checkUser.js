$(function () {
    $("#username").blur(function () {
        let username = $("#username").val();
        $.ajax({
            url: "/checkUsername",
            data: {username: username},
            async: true,
            cache: false,
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result) {
                    $("#forUsername").text("用户名可用").css("color", "greenyellow");
                } else {
                    $("#forUsername").text("用户名已被使用或为空").css("color", "red");
                }
            }
        })
    })
})
$(function () {
    $("#password").blur(function () {
        let value = $("#password").val();
        if (value === "" || value.length < 8) {
            $("#forPassword").text("密码长度不足8位").css("color", "red");
        } else {
            $("#forPassword").text("密码可用").css("color", "greenyellow");
        }
    })
})