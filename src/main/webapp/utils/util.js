/**
 * 定时改变字体颜色
 **/
function timerFontColor(id){
    var jqueryObject = $(id);
    var str = new Array();
    $.each(jqueryObject,function(index,element){
        element.style.backgroundColor = str[Math.floor(Math.random()*3)];
    })
}