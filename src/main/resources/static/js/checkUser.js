let usernameCheck = false;
let passwordCheck = false;
let passwordCheckAgain = false;

$(function () {
    $("#username").blur(function () {
        let username = $("#username").val();
        if (username.length > 3) {
            $.ajax({
                url: "/checkUsername",
                data: {username: username},
                async: true,
                cache: false,
                type: "post",
                dataType: "json",
                success: function (result) {
                    if (result) {
                        $("#forUsername").text("√用户名可用").css("color", "greenyellow");
                        usernameCheck = true;
                    } else {
                        $("#forUsername").text("×用户名已被使用").css("color", "red");
                        usernameCheck = false;
                    }
                }
            })
        } else {
            $("#forUsername").text("×用户名长度不足4位").css("color", "red");
            usernameCheck = false;
        }
    })
})
$(function () {
    $("#password").blur(function () {
        let pwd = $("#password").val();
        if (pwd === "" || pwd.length < 8) {
            $("#forPassword").text("×密码长度不足8位").css("color", "red");
            passwordCheck = false;
        } else {
            $("#forPassword").text("√密码可用").css("color", "greenyellow");
            passwordCheck = true;
        }
    })
})

$(function () {
    $("#checkPassword").blur(function () {
        let pwd2 = $("#checkPassword").val();
        let pwd = $("#password").val();
        if (pwd === "" || pwd.length < 8) {
            $("#forCheckPassword").text("×请先正确填写前面的密码").css("color", "red");
            passwordCheckAgain = false;
        } else if (pwd2 !== pwd) {
            $("#forCheckPassword").text("×密码不一致").css("color", "red");
            passwordCheckAgain = false;
        }else {
            $("#forCheckPassword").text("√验证通过").css("color", "greenyellow");
            passwordCheckAgain = true;
        }
    })
})

function check() {
    return passwordCheckAgain && passwordCheck && usernameCheck;
}

let plist = document.querySelectorAll(".plist");
let len = plist.length;
$(function () {
    let arr = [
        "纵有千古，横有八荒。前途似海，来日方长。",
        "一生温暖纯良，不舍爱与自由。",
        "执着于理想，纯粹于当下。",
        "愿你的生命有够多的云翳，造成一个美丽的黄昏。",
        "未来不足惧，过往不须泣。",
        "你一定要走，走到灯火通明。",
        "凡心所向，素履所往，生如逆旅，一苇以航。",
        "一愿识尽天下好人，二愿读尽世间好书，三愿看尽世间好山水。",
        "愿你如愿遇到生命中的缘分，不早也不晚，不急也不缓。",
        "祝你所求皆如愿，所行化坦途，多喜乐，长安宁。"
    ];
    for(let i = 0;i < len;i++) {
        (function (i) {
            let j = 0;
            let m = 0;
            let done = setInterval(show, 200);
            function show() {
                plist[i].innerHTML = arr[m].substr(0, j);
                j++;
                if (j > arr[m].length) {
                    clearInterval(done);
                    done = setInterval(hide, 200);
                }
            }
            function hide() {
                j--;
                plist[i].innerHTML = arr[m].substr(0, j);
                if (!j) {
                    clearInterval(done);
                    done = setInterval(show, 200);
                    m = (m + 1) % arr.length;
                }
            }
        })(i);
    }
})