function login(){
    $('#load').show();
    const userId = document.getElementById("inid").value;
    const userPw = document.getElementById("inpw").value;

    if(userId == null || userId == ""){
        $("#load").hide();
        swal({
            text : "아이디를 입력해주세요.",
            icon : "info"
        });
    }else if(userPw == null || userPw == ""){
        $("#load").hide();
        swal({
            text : "비밀번호를 입력해주세요.",
            icon : "info"
        });
    }else{
        let sendData = {
            "id" : userId,
            "pw" : userPw
        }
        $.ajax({
            url : "/admin/userlogin",
            data : sendData,
            type : "GET",
            datatype:'json',
            success : function(result){
                $("#load").hide();
                if(result.loginResult == "1"){
                    location.href = "/admin/main";
                }else if(result.loginResult == "0"){
                    swal({
                        text : "계정 정보가 일치하지 않습니다.",
                        icon : "error"
                    });
                }
            }, error : function(request, status, error){
                $("#load").hide();
                swal({
                    text : "로그인 도중 서버에 문제가 발생했습니다.",
                    icon : "error"
                });
            }
        });
    }
}

function logout(){
    $('#load').show();
    $.ajax({
        url : "/admin/logout",
        type : "GET",
        success : function(result){
            $("#load").hide();
            if(result.logoutResult == "1"){
                location.href = "/admin";
            }else if(result.logoutResult == "0"){
                swal({
                    text : "로그아웃에 실패했습니다.",
                    icon : "error"
                });
            }
        }, error : function(request, status, error){
            $("#load").hide();
            swal({
                text : "로그아웃 도중 문제가 발생했습니다.",
                icon : "error"
            });
        }
    });
}