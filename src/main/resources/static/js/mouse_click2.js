/*鼠标点击出现文字*/
$(document).ready(function() {
    let a_index = 0;
    $("body").click(function (e) {
        let colors = ["#0FF", "#bfbf18", "#137ee2", "#c71d1d", "#FFD700", "#ADFF2F", "#ADFF2F", "#F5F5DC", "#f0f8ff", "#c71d1d", "#137ee2"];
        let a = ["❤不做咸鱼！❤","❤拒绝懒惰！❤","❤想做吃货❤","❤向大佬学习❤","❤扶我起来~❤","❤come on❤","❤一直在路上~❤","❤累了~❤","❤再趴一会❤","❤66666❤","❤高兴的飞起*****❤"];
        let $i = $("<span/>").text(a[a_index]);
        a_index = (a_index + 1) % a.length;
        let x = e.pageX, y = e.pageY;
        $i.css({
            "z-index": 99999,
            "top": y - 20,
            "left": x,
            "position": "absolute",
            "font-weight": "bold",
            "color": colors[a_index]
        });
        $("body").append($i);
        $i.animate({"top": y - 180, "opacity": 0}, 1500, function () {
            $i.remove();
        });
    });
});