function af_inq(){
let sendData = {
    "pjnum" : pjnum
}
$.ajax({
            url      : "/Af_inq_go",
            data     : sendData,
            type     : "GET",
            success : function(result) {
                window.open("/Af_inq");
            },
            error:function(request,status,error){
            }
        });
}

function viewcon(num, pjnum){

const lagse = document.getElementById('lagse');
let sendData = {
            "pjnum" : pjnum,
            "datanum" : num,
            "lagse" : lagse.options[lagse.selectedIndex].text
}
$.ajax({
            url      : "/view_con",
            data     : sendData,
            type     : "POST",
            success : function(result) {
                if(result.lagse == "KOR"){
                    if(result.datanum == "1"){
                        $("#api2_con"+pjnum).text(result.data1.api2_CONTENTS);
                        $('#databox1'+pjnum).css('display', 'block');
                        $('#databox2'+pjnum).css('display', 'none');
                        $('#databox3'+pjnum).css('display', 'none');
                        $('#databox4'+pjnum).css('display', 'none');
                    }else if(result.datanum == "2"){
                        $("#api3_con1"+pjnum).text(result.data1.api3_CONTENT1);
                        $("#api3_con2"+pjnum).text(result.data1.api3_CONTENT2);
                        $('#databox1'+pjnum).css('display', 'none');
                        $('#databox2'+pjnum).css('display', 'block');
                        $('#databox3'+pjnum).css('display', 'none');
                        $('#databox4'+pjnum).css('display', 'none');
                    }else if(result.datanum == "3"){
                        $("#api4_con1"+pjnum).text(result.data1.api4_CONTENT1);
                        $("#api4_con2"+pjnum).text(result.data1.api4_CONTENT2);
                        $("#api4_con3"+pjnum).text(result.data1.api4_CONTENT3);
                        $("#api4_con4"+pjnum).text(result.data1.api4_CONTENT4);
                        $('#databox1'+pjnum).css('display', 'none');
                        $('#databox2'+pjnum).css('display', 'none');
                        $('#databox3'+pjnum).css('display', 'block');
                        $('#databox4'+pjnum).css('display', 'none');
                    }else if(result.datanum == "4"){
                        $("#api5_con1"+pjnum).text(result.data1.api5_CONTENT1);
                        $("#api5_con2"+pjnum).text(result.data1.api5_CONTENT2);
                        $("#api5_con3"+pjnum).text(result.data1.api5_CONTENT3);
                        $('#databox1'+pjnum).css('display', 'none');
                        $('#databox2'+pjnum).css('display', 'none');
                        $('#databox3'+pjnum).css('display', 'none');
                        $('#databox4'+pjnum).css('display', 'block');
                    }
                }else if(result.lagse == "ENG"){
                    if(result.datanum == "1"){
                        $('#databox1').css('display', 'block');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "2"){
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'block');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "3"){
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'block');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "4"){
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'block');
                    }
                }
            },
            error:function(request,status,error){
            }
        });


}

function af_review(){
document.getElementById('re1').style.display = "none";
document.getElementById('re2').style.display = "block";

//const pjnum = document.getElementById('pjnum').innerText;
//console.log(pjnum)
//let sendData = {
//    "pjnum" : pjnum
//}
//$.ajax({
//            url      : "/Af_review_go",
//            data     : sendData,
//            type     : "GET",
//            success : function(result) {
//                window.open("/Af_review");
//            },
//            error:function(request,status,error){
//            }
//        });
}

function fff(){
document.getElementById('re1').style.display = "block";
document.getElementById('re2').style.display = "none";
}

