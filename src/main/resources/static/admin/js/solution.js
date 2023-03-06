// 검색필터
function searching(){

    var titleText = $('#titleText').val();
    var selectKey = $('#selectKey').val();

    console.log(titleText);
    const params = {
        page: 0,
        selectKey: selectKey,
        titleText: titleText
    }

    const queryString = new URLSearchParams(params).toString();

    const replaceUri = location.pathname + '?' + queryString;

    history.pushState(null, '', replaceUri);

    //값 가져오기 (페이지네이션)
    const myPageQuery = new URLSearchParams(location.search);

    var querydata = { "page" : myPageQuery.get('page'), "selectKey":myPageQuery.get('selectKey'),"titleText":myPageQuery.get('titleText')};

    $.ajax({
        url: "/admin/solution/solution_search",
        data: querydata,
        type:"POST",
    }).done(function (fragment) {
        $("#intable").replaceWith(fragment);
    });

}

// 페이징
function paging(pageValue){
    const myPageQuery = new URLSearchParams(location.search);

    console.log(pageValue);

    var titleText = myPageQuery.get('titleText');
    var selectKey = myPageQuery.get('selectKey');

    $("#load").show();

    //문자열 "null" 이 들어가는것 방지하기 위해 값이 null 이라면 공백 문자열 대입
    if(titleText == null){
        titleText = "";
    }

    // 대입 끝

    //url 주소 바꾸기
    const params = {
        page: pageValue,
        selectKey: selectKey,
        titleText: titleText
    }
    const queryString = new URLSearchParams(params).toString();
    const replaceUri = location.pathname + '?' + queryString;
    history.pushState(null, '', replaceUri);
    //url 주소 바꾸기 끝


    var querydata = { "page" : pageValue, "selectKey":selectKey, "titleText":titleText};


    $.ajax({
        url: "/admin/solution/solution_search",
        data: querydata,
        type:"POST",
    }).done(function (fragment) {
        $("#intable").replaceWith(fragment);
        $("#load").hide();

    });

}




// 솔루션 추가
function solution_add(){
    var name = document.getElementById('SNameKor').value; // 패키지명
    var type = document.getElementById('STypeKor').value; // 패키지타입
    var name_e = document.getElementById('SNameEng').value; // 패키지명_영어
    var type_e = document.getElementById('STypeEng').value; // 패키지타입_영어
    var googleLink = document.getElementById('SGoogleLink').value; // 구글스토어 링크
    var appleLink = document.getElementById('SAppleLink').value; // 애플스토어 링크
    var mainNum = document.getElementById('SMainNum').value; // 메인페이지 순서
    var show = $('input[name=SShowNum]:checked').val(); // 노출여부

    if(name==null||name==""){
        swal({
            text: "패키지 이름을 입력해주세요.",
            icon: "info"
        });
    }else if(type==null||type==""){
        swal({
            text: "패키지 타입을 입력해주세요.",
            icon: "info"
        });
    }else if(name_e==null||name_e==""){
        swal({
            text: "영문 패키지 이름을 입력해주세요.",
            icon: "info"
        });
    }else if(type_e==null||type_e==""){
        swal({
            text: "영문 패키지 타입을 입력해주세요.",
            icon: "info"
        });
    }else if(googleLink==null||googleLink==""){
        swal({
            text: "구글 스토어 링크를 입력해주세요.",
            icon: "info"
        });
    }else if(appleLink==null||appleLink==""){
        swal({
            text: "애플 앱스토어 링크를 입력해주세요.",
            icon: "info"
        });
    }else if(mainNum==null||mainNum==""){
        swal({
            text: "메인 페이지 솔루션 순서를 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "name" : name,
            "type" : type,
            "name_e" : name_e,
            "type_e" : type_e,
            "googleLink" : googleLink,
            "appleLink" : appleLink,
            "mainNum" : mainNum,
            "show" : show
        };
        $.ajax({
            url : "/admin/solution/add",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/solution/list";
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
                    location.href = "/admin/solution/list";
                });
            }
        });
    }
}

// 솔루션 수정
function solution_edit(api1_seq){
//    swal({
//        title : "수정하시겠습니까?",
//        icon : "info",
//        buttons: {
//            confirm: {
//                text: "YES",
//                value: true
//            },
//            cancle: {
//                text: "NO",
//                value: false
//            }
//        }
//    }).then(function(result){
//        if(result){
            $('#load').show();
            location.href = "/admin/solution/edit?no="+api1_seq+"";
//        }
//    });
}
// 수정저장
function solution_editSave(seq){
    var name = document.getElementById('SNameKorEdit').value; // 패키지명
    var type = document.getElementById('STypeKorEdit').value; // 패키지타입
    var name_e = document.getElementById('SNameEngEdit').value; // 패키지명_영어
    var type_e = document.getElementById('STypeEngEdit').value; // 패키지타입_영어
    var googleLink = document.getElementById('SGoogleLinkEdit').value; // 구글스토어 링크
    var appleLink = document.getElementById('SAppleLinkEdit').value; // 애플스토어 링크
    var mainNum = document.getElementById('SMainNumEdit').value; // 메인페이지 순서
    var show = $('input[name=SShowNum]:checked').val(); // 노출여부

    if(name==null||name==""){
        swal({
            text: "패키지 이름을 입력해주세요.",
            icon: "info"
        });
    }else if(type==null||type==""){
        swal({
            text: "패키지 타입을 입력해주세요.",
            icon: "info"
        });
    }else if(name_e==null||name_e==""){
        swal({
            text: "영문 패키지 이름을 입력해주세요.",
            icon: "info"
        });
    }else if(type_e==null||type_e==""){
        swal({
            text: "영문 패키지 타입을 입력해주세요.",
            icon: "info"
        });
    }else if(googleLink==null||googleLink==""){
        swal({
            text: "구글 스토어 링크를 입력해주세요.",
            icon: "info"
        });
    }else if(appleLink==null||appleLink==""){
        swal({
            text: "애플 앱스토어 링크를 입력해주세요.",
            icon: "info"
        });
    }else if(mainNum==null||mainNum==""){
        swal({
            text: "메인 페이지 솔루션 순서를 입력해주세요.",
            icon: "info"
        });
    }else{
        $('#load').show();
        let sendData = {
            "no" : seq,
            "name" : name,
            "type" : type,
            "name_e" : name_e,
            "type_e" : type_e,
            "googleLink" : googleLink,
            "appleLink" : appleLink,
            "mainNum" : mainNum,
            "show" : show
        };
        $.ajax({
            url : "/admin/solution/edit",
            data : sendData,
            type : "POST",
            success : function(result){
                $("#load").hide();
                if(result.save == "1"){
                    location.href = "/admin/solution/list";
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
                    location.href = "/admin/solution/list";
                });
            }
        });
    }
}

// 솔루션 삭제
function solution_delete(api1_seq){
    console.log(api1_seq);
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
        $('#load').show();
        $.ajax({
            url : "/admin/solution/delete",
            data : {"no" : api1_seq},
            type : "GET",
            success : function(result){
                $("#load").hide();
                swal({
                    text: "삭제되었습니다.",
                    icon: "info"
                }).then(function(){
                    location.href = "/admin/solution/list";
                });
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "통신 오류",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/solution/list";
                });
            }
        });
    });
}