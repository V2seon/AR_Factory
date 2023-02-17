// 페이지 이동
// 등록 이동
function detail_add(no,lang,details){ // 콘텐츠
    $('#load').show();
//    location.href = "/admin/detail/"+details+"/add?no="+no+"&lang="+lang+"";
    location.href = "/admin/detail/add?no="+no+"&lang="+lang+"&details="+details+"";
}

// 수정 이동
function detail_edit(seq,lang,details){ // 콘텐츠
    var title0 = "";
    if(details == "contents"){
        title0 = "콘텐츠를 수정하시겠습니까?";
    }else if(details == "detail"){
        title0 = "상세정보를 수정하시겠습니까?";
    }else if(details == "case"){
        title0 = "활용사례를 수정하시겠습니까?";
    }else if(details == "purchase"){
        title0 = "구입방식을 수정하시겠습니까?";
    }else if(details == "option"){
        title0 = "옵션을 수정하시겠습니까?";
    }
    swal({
        title : title0,
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
            location.href = "/admin/detail/edit?no="+seq+"&lang="+lang+"&details="+details+"";
        }
    });
}






// 데이터 저장
// 콘텐츠
function contents_Save(){ // 콘텐츠
}

// 상세정보 저장
function detail_Save(ae){
    var no = "";
    if(ae=='add'){
        no = document.getElementById('pac_detail').value; // 패키지
    }else if(ae=='edit'){
        no = document.getElementById('seq_detail').value; // seq번호
    }
    var lang = document.getElementById('lang_detail').value; // 언어
    var d1 = document.getElementById('peopleCnt').value;
    var d2 = document.getElementById('playRule').value;

    if(d1==null||d1==""){
        swal({
            text: "권장 인원을 입력해주세요.",
            icon: "info"
        });
    }else if(d2==null||d2==""){
        swal({
            text: "플레이 방법을 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "no" : no,
            "lang" : lang,
            "d1" : d1,
            "d2" : d2
        };
        $.ajax({
            url : "/admin/detail/detail/"+ae+"",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/detail/list";
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "통신 오류",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/detail/list";
                });
            }
        });
    }
}

// 활용사례 저장
function case_Save(ae){
    var no = "";
    if(ae=='add'){
        no = document.getElementById('pac_case').value; // 패키지
    }else if(ae=='edit'){
        no = document.getElementById('seq_case').value; // seq번호
    }
    var lang = document.getElementById('lang_case').value; // 언어
    var c1 = document.getElementById('case1').value;
    var c2 = document.getElementById('case2').value;
    var c3 = document.getElementById('case3').value;
    var c4 = document.getElementById('case4').value;

    if(c1==null||c1==""||c2==null||c2==""||c3==null||c3==""||c4==null||c4==""){
        swal({
            text: "모든 사례를 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "no" : no,
            "lang" : lang,
            "c1" : c1,
            "c2" : c2,
            "c3" : c3,
            "c4" : c4
        };
        $.ajax({
            url : "/admin/detail/case/"+ae+"",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/detail/list";
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "통신 오류",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/detail/list";
                });
            }
        });
    }
}

// 구입방식 저장
function purchase_Save(ae){
    var no = "";
    if(ae=='add'){
        no = document.getElementById('pac_purchase').value; // 패키지
    }else if(ae=='edit'){
        no = document.getElementById('seq_purchase').value; // seq번호
    }
    var lang = document.getElementById('lang_purchase').value; // 언어
    var p1 = document.getElementById('term_lease').value;
    var p2 = document.getElementById('num_uses').value;
    var p3 = document.getElementById('acc_ass').value;

    if(p1==null||p1==""){
        swal({
            text: "기간 임대를 입력해주세요.",
            icon: "info"
        });
    }else if(p2==null||p2==""){
        swal({
            text: "이용 횟수를 입력해주세요.",
            icon: "info"
        });
    }else if(p3==null||p3==""){
        swal({
            text: "계정 할당을 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "no" : no,
            "lang" : lang,
            "p1" : p1,
            "p2" : p2,
            "p3" : p3
        };
        $.ajax({
            url : "/admin/detail/purchase/"+ae+"",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/detail/list";
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "통신 오류",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/detail/list";
                });
            }
        });
    }
}

// 옵션 저장
function option_Save(ae){
    var no = "";
    if(ae=='add'){
        no = document.getElementById('pac_option').value; // 패키지
    }else if(ae=='edit'){
        no = document.getElementById('seq_option').value; // seq번호
    }
    var lang = document.getElementById('lang_option').value; // 언어
    var o1 = document.getElementById('addOption1').value;
    var o2 = document.getElementById('addOption2').value;
    var o3 = document.getElementById('addOption3').value;
    var o4 = document.getElementById('addOption4').value;
    var o5 = document.getElementById('addOption5').value;
    var o6 = document.getElementById('addOption6').value;
    var o7 = document.getElementById('addOption7').value;

    if(o1==null||o1==""||o2==null||o2==""||o3==null||o3==""||o4==null||o4==""||o5==null||o5==""||o6==null||o6==""||o7==null||o7==""){
        swal({
            text: "모든 옵션을 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "no" : no,
            "lang" : lang,
            "o1" : o1,
            "o2" : o2,
            "o3" : o3,
            "o4" : o4,
            "o5" : o5,
            "o6" : o6,
            "o7" : o7
        };
        $.ajax({
            url : "/admin/detail/option/"+ae+"",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/detail/list";
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "통신 오류",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/detail/list";
                });
            }
        });
    }
}

