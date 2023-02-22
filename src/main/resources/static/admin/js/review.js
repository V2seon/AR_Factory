// 후기 등록
function review_add(){
    var pac = $('input[name=RePackage]:checked').val(); // 패키지
    var rename = document.getElementById('Arename').value; // 글쓴이
    var repw = document.getElementById('Arepw').value; // 비밀번호
    var retext = document.getElementById('Aretext').value; // 리뷰내용
    var starval1 = $('input[name="starpoint"]:checked').val(); // 별점
    var show = $('input[name=AreshowNum]:checked').val(); // 노출여부
    var starval = parseFloat(starval1);

    if(rename == null || rename == ""){
        swal({
              text: "이름을 입력하세요.",
              icon: "info"
              });
    }else if(repw == null || repw == ""){
        swal({
              text: "비밀번호를 입력하세요.",
              icon: "info"
              });
    }else if(starval1 == null){
        swal({
              text: "별점을 선택하세요.",
              icon: "info"
              });
    }else if(retext == null || retext == ""){
        swal({
              text: "후기내용을 입력하세요.",
              icon: "info"
              });
    }else{
        $('#load').show();
        let sendData = {
            "no" : pac,
            "name" : rename,
            "pw" : repw,
            "text" : retext,
            "show" : show,
            "star" : starval
        }
        $.ajax({
            url      : "/admin/review/add",
            data     : sendData,
            type     : "POST",
            success : function(result) {
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/review/list";
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
                    location.href = "/admin/review/list";
                });
            }
        });
    }
}

// 후기 수정
function review_edit(seq){
    $('#load').show();
    location.href = "/admin/review/edit?no="+seq+"";
}
// 수정저장
function review_editSave(seq){
    var pac = $('input[name=RePackage]:checked').val(); // 패키지
    var rename = document.getElementById('Arename').value; // 글쓴이
    var repw = document.getElementById('Arepw').value; // 비밀번호
    var retext = document.getElementById('Aretext').value; // 리뷰내용
    var starval1 = $('input[name="starpoint"]:checked').val(); // 별점
    var show = $('input[name=AreshowNum]:checked').val(); // 노출여부
    var starval = parseFloat(starval1);

    if(rename == null || rename == ""){
        swal({
              text: "이름을 입력하세요.",
              icon: "info"
              });
    }else if(starval1 == null){
        swal({
              text: "별점을 선택하세요.",
              icon: "info"
              });
    }else if(retext == null || retext == ""){
        swal({
              text: "후기내용을 입력하세요.",
              icon: "info"
              });
    }else{

        $('#load').show();
        let sendData = {
            "no" : seq,
            "pac" : pac,
            "name" : rename,
            "pw" : repw,
            "text" : retext,
            "show" : show,
            "star" : starval
        }
        $.ajax({
            url      : "/admin/review/edit",
            data     : sendData,
            type     : "POST",
            success : function(result) {
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/review/list";
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
                    location.href = "/admin/review/list";
                });
            }
        });
    }
}

// 후기 삭제
function review_delete(seq){
    console.log(seq);
    swal({
        title : "삭제하시겠습니까?",
        icon : "info",
        buttons: {
            confirm: {
                text: "YES",
                value: true
            },
            cancle: {
                text: "NO",
                value: false
            }
        }
    }).then(function(result){
        if(result){
            $('#load').show();
            $.ajax({
                url : "/admin/review/delete",
                data : {"no" : seq},
                type : "GET",
                success : function(result){
                    $("#load").hide();
                    swal({
                        text: "삭제되었습니다.",
                        icon: "info"
                    }).then(function(){
                        location.href = "/admin/review/list";
                    });
                }, error:function(request, status, error){
                    $("#load").hide();
                    swal({
                        text: "통신 오류",
                        icon: "warning"
                    }).then(function(){
                        location.href = "/admin/review/list";
                    });
                }
            });
        }
    });
}
