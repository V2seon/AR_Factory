// 페이지 이동
// 등록 이동
function detail_add(no,lang,details){ // 콘텐츠
    $('#load').show();
    location.href = "/admin/detail/add?no="+no+"&lang="+lang+"&details="+details+"";
}

// 수정 이동
function detail_edit(seq,lang,details){ // 콘텐츠
    $('#load').show();
    location.href = "/admin/detail/edit?no="+seq+"&lang="+lang+"&details="+details+"";
}






// 데이터 저장
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

// 콘텐츠
function contents_Save(ae){
    var no = "";
    var seq = "";
    var dcheck1 = "";
    var dcheck2 = "";
    var dcheck3 = "";
    var dcheck4 = "";
    var dcheck5 = "";
    var dcheck6 = "";
    no = document.getElementById('pac_contents').value; // 패키지
    seq = document.getElementById('seq_contents').value; // seq번호
    if(ae=='edit'){
        dcheck1 = document.getElementById('cttdelcheck1').value;
        dcheck2 = document.getElementById('cttdelcheck2').value;
        dcheck3 = document.getElementById('cttdelcheck3').value;
        dcheck4 = document.getElementById('cttdelcheck4').value;
        dcheck5 = document.getElementById('cttdelcheck5').value;
        dcheck6 = document.getElementById('cttdelcheck6').value;
    }
    var lang = document.getElementById('lang_contents').value; // 언어
    var ctttext = document.getElementById('contentMessage').value;
    var img1="";
    var img2="";
    var img3="";
    var img4="";
    var img5="";
    var img6="";
    if(cttImg1.files[0]==null&&cttImg2.files[0]==null&&cttImg3.files[0]==null&&cttImg4.files[0]==null&&cttImg5.files[0]==null&&cttImg6.files[0]==null){
        swal({
            text: "이미지를 넣어주세요.",
            icon: "info"
        })
    }else if(ctttext==null||ctttext==""){
        swal({
            text: "콘텐츠 설명을 입력해주세요.",
            icon: "info"
        })
    }else{
        $('#load').show();

        var name = "";
        var ext = "";
        let newFile1 = null;
        let newFile2 = null;
        let newFile3 = null;
        let newFile4 = null;
        let newFile5 = null;
        let newFile6 = null;
        if(cttImg1.files[0]!=null){
            ext = cttImg1.files[0].name.split('.')
            name = no+"_"+lang+"_img1."+ext[ext.length-1];
            newFile1 = new File([cttImg1.files[0]], name, {type:cttImg1.type}); // 다른이름 같은파일 생성
            img1=name;
        }else if(ae=='edit'){
            if(dcheck1 =="check"){
                newFile1 = new File([null], "check,"+document.getElementById('cttimgname1').value); // 다른이름 같은파일 생성
            }else{
                img1 = document.getElementById('cttimgname1').value;
            }
        }
        if(cttImg2.files[0]!=null){
            ext = cttImg2.files[0].name.split('.')
            name = no+"_"+lang+"_img2."+ext[ext.length-1];
            newFile2 = new File([cttImg2.files[0]], name, {type:cttImg2.type});
            img2=name;
        }else if(ae=='edit'){
            if(dcheck2 =="check"){
                newFile2 = new File([null], "check,"+document.getElementById('cttimgname2').value); // 다른이름 같은파일 생성
            }else{
                img2 = document.getElementById('cttimgname2').value;
            }
        }
        if(cttImg3.files[0]!=null){
            ext = cttImg3.files[0].name.split('.')
            name = no+"_"+lang+"_img3."+ext[ext.length-1];
            newFile3 = new File([cttImg3.files[0]], name, {type:cttImg3.type});
            img3=name;
        }else if(ae=='edit'){
            img3 = document.getElementById('cttimgname3').value;
            if(dcheck3 =="check"){
                newFile3 = new File([null], "check,"+document.getElementById('cttimgname3').value); // 다른이름 같은파일 생성
            }else{
                img3 = document.getElementById('cttimgname3').value;
            }
        }
        if(cttImg4.files[0]!=null){
            ext = cttImg4.files[0].name.split('.')
            name = no+"_"+lang+"_img4."+ext[ext.length-1];
            newFile4 = new File([cttImg4.files[0]], name, {type:cttImg4.type});
            img4=name;
        }else if(ae=='edit'){
            img4 = document.getElementById('cttimgname4').value;
            if(dcheck4 =="check"){
                newFile4 = new File([null], "check,"+document.getElementById('cttimgname4').value); // 다른이름 같은파일 생성
            }else{
                img4 = document.getElementById('cttimgname4').value;
            }
        }
        if(cttImg5.files[0]!=null){
            ext = cttImg5.files[0].name.split('.')
            name = no+"_"+lang+"_img5."+ext[ext.length-1];
            newFile5 = new File([cttImg5.files[0]], name, {type:cttImg5.type});
            img5=name;
        }else if(ae=='edit'){
            img5 = document.getElementById('cttimgname5').value;
            if(dcheck5 =="check"){
                newFile5 = new File([null], "check,"+document.getElementById('cttimgname5').value); // 다른이름 같은파일 생성
            }else{
                img5 = document.getElementById('cttimgname5').value;
            }
        }
        if(cttImg6.files[0]!=null){
            ext = cttImg6.files[0].name.split('.')
            name = no+"_"+lang+"_img6."+ext[ext.length-1];
            newFile6 = new File([cttImg6.files[0]], name, {type:cttImg6.type});
            img6=name;
        }else if(ae=='edit'){
            if(dcheck6 =="check"){
                newFile6 = new File([null], "check"+document.getElementById('cttimgname6').value); // 다른이름 같은파일 생성
            }else{
                img6 = document.getElementById('cttimgname6').value;
            }
        }
        let sendData = {
            "no" : no,
            "seq" : seq,
            "lang" : lang,
            "img1" : img1,
            "img2" : img2,
            "img3" : img3,
            "img4" : img4,
            "img5" : img5,
            "img6" : img6,
            "text" : ctttext
        };
        $.ajax({
            url : "/admin/detail/contents/"+ae+"",
            data : sendData,
            type : "POST",
            success : function(result){
                if(result.save == "1"){
                    var formData = new FormData();
                    formData.append("file1",newFile1);
                    formData.append("file2",newFile2);
                    formData.append("file3",newFile3);
                    formData.append("file4",newFile4);
                    formData.append("file5",newFile5);
                    formData.append("file6",newFile6);
                    $.ajax({
                        type:"POST",
                        enctype: 'multipart/form-data',
                        url: "/admin/detail/cttUpload",
                        data: formData,
                        processData: false,
                        contentType: false,
                        cache: false,
                        success: function (result) {
                            $("#load").hide();
                            if(result == "1"){
                                location.href = "/admin/detail/list";
                            }else if(result == "0"){
                                swal({
                                    text : "저장에 실패하였습니다.",
                                    icon : "error"
                                });
                            }
                        },error: function (e) {
                            swal({
                                text: "통신오류",
                                icon: "warning"
                            });
                        }
                    });
                }else if(result.save == "0"){
                    swal({
                        text : "저장에 실패하였습니다.",
                        icon : "error"
                    });
                }
            }, error:function(request, status, error){
                $("#load").hide();
                swal({
                    text: "업로드 실패",
                    icon: "warning"
                }).then(function(){
                    location.href = "/admin/detail/list";
                });
            }
        });
    }
}



// 파일
const cttImg1 = document.getElementById('cttImg1');
const cttImg2 = document.getElementById('cttImg2');
const cttImg3 = document.getElementById('cttImg3');
const cttImg4 = document.getElementById('cttImg4');
const cttImg5 = document.getElementById('cttImg5');
const cttImg6 = document.getElementById('cttImg6');

function setCttimg(ae){ // 업로드상자 클릭
    if(ae=='add'){
        if(cttImg1.files[0] == null){
            cttImg1.click();
        }else if(cttImg2.files[0] == null){
            cttImg2.click();
        }else if(cttImg3.files[0] == null){
            cttImg3.click();
        }else if(cttImg4.files[0] == null){
            cttImg4.click();
        }else if(cttImg5.files[0] == null){
            cttImg5.click();
        }else if(cttImg6.files[0] == null){
            cttImg6.click();
        }
    }else if(ae=='edit'){
        if(cttImg1.files[0] == null && (document.getElementById("cttimgname1").value == null || document.getElementById("cttimgname1").value == "")){
            cttImg1.click();
        }else if(cttImg2.files[0] == null && (document.getElementById("cttimgname2").value == null || document.getElementById("cttimgname2").value == "")){
            cttImg2.click();
        }else if(cttImg3.files[0] == null && (document.getElementById("cttimgname3").value == null || document.getElementById("cttimgname3").value == "")){
            cttImg3.click();
        }else if(cttImg4.files[0] == null && (document.getElementById("cttimgname4").value == null || document.getElementById("cttimgname4").value == "")){
            cttImg4.click();
        }else if(cttImg5.files[0] == null && (document.getElementById("cttimgname5").value == null || document.getElementById("cttimgname5").value == "")){
            cttImg5.click();
        }else if(cttImg6.files[0] == null && (document.getElementById("cttimgname6").value == null || document.getElementById("cttimgname6").value == "")){
            cttImg6.click();
        }

    }
}
function readURL(input,num) { // 미리보기 이미지

    var idsVbox = "cttVimgs"+num;
    var idsV = "cttimgV"+num;
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
          document.getElementById(idsV).src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
        document.getElementById(idsVbox).style.display='flex';
    } else {
        document.getElementById(idsV).src = "";
    }
}
function cttVdel(num,ae){ // 업로드지우기
    var idsIn = "cttImg"+num;
    var idsVbox = "cttVimgs"+num;
    var dcheck = "cttdelcheck"+num;
    var dname = "cttimgname"+num;
    document.getElementById(idsIn).value ="";
    document.getElementById(idsVbox).style.display='none';
    document.getElementById(dcheck).value ="check";
    if(ae=='edit'){
        document.getElementById(dname).value ="";
    }
}