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
        let pwd = $("#password").val();
        if (pwd === "" || pwd.length < 8) {
            $("#forPassword").text("密码长度不足8位").css("color", "red");
        } else {
            $("#forPassword").text("密码可用").css("color", "greenyellow");
        }
    })
})

$(function () {
    $("#checkPassword").blur(function () {
        let pwd2 = $("#checkPassword").val();
        let pwd = $("#password").val();
        if (pwd === "" || pwd.length < 8) {
            $("#forCheckPassword").text("请先填写前面的密码").css("color", "red");
        } else if (pwd2 !== pwd) {
            $("#forCheckPassword").text("密码不一致").css("color", "red");
        }else {
            $("#forCheckPassword").text("验证通过").css("color", "greenyellow");
        }
    })
})