// 문의 수정
function inq_edit(seq){
    $('#load').show();
    location.href = "/admin/inq/edit?no="+seq+"";
}

// 문의 수정 저장
function inq_editSave(seq){

    var pac = $('input[name=RePackage]:checked').val(); // 패키지
    var name = $('#Ainame').val(); // 문의고객
    var phon = $("#Aiphon").val(); // 전화번호
    var state = $('input[name=aistate]:checked').val(); // 문의상태
    var state2 = $('input[name=aistate2]:checked').val(); // 구매상태
    var opt = $('input[name=opt]:checked').val(); // 옵션

    var patt = new RegExp("[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}");
    var res = patt.test(phon);

    if(name == null || name == ""){
        swal({
              text: "이름을 입력하세요.",
              icon: "info"
              });
    }else if(phon == null || phon == ""){
        swal({
              text: "전화번호를 입력하세요.",
              icon: "info"
              });
    }else if(!res){
        swal({
              text: "전화번호 정확히 입력해주세요.",
              icon: "info"
              });
    }else{
        $('#load').show();
        let sendData = {
            "no" : seq,
            "pac" : pac,
            "name" : name,
            "phon" : phon,
            "state" : state,
            "state2" : state2,
            "opt" : opt
        }
        $.ajax({
            url      : "/admin/inq/edit",
            data     : sendData,
            type     : "POST",
            success : function(result) {
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/inq/list";
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            },error:function(request,status,error){
                $("#load").hide();
                swal({
                    title: "통신오류.",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/inq/list";
                });
            }
        });
    }
}