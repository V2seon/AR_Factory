function af_inq(){
window.open("/Af_inq");
}


function viewcon(num){

// value 는 인풋 속성이므로 div의 value는 어트리뷰트로 가져오셔야 합니다.
const pjnum = $("#pjnum").attr("value");
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
                        $("#api2_con").text(result.data1.api2_CONTENTS);
                        $('#databox1').css('display', 'block');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "2"){
                        $("#api3_con1").text(result.data1.api3_CONTENT1);
                        $("#api3_con2").text(result.data1.api3_CONTENT2);
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'block');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "3"){
                        $("#api4_con1").text(result.data1.api4_CONTENT1);
                        $("#api4_con2").text(result.data1.api4_CONTENT2);
                        $("#api4_con3").text(result.data1.api4_CONTENT3);
                        $("#api4_con4").text(result.data1.api4_CONTENT4);
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'block');
                        $('#databox4').css('display', 'none');
                    }else if(result.datanum == "4"){
                        $("#api5_con1").text(result.data1.api5_CONTENT1);
                        $("#api5_con2").text(result.data1.api5_CONTENT2);
                        $("#api5_con3").text(result.data1.api5_CONTENT3);
                        $('#databox1').css('display', 'none');
                        $('#databox2').css('display', 'none');
                        $('#databox3').css('display', 'none');
                        $('#databox4').css('display', 'block');
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
