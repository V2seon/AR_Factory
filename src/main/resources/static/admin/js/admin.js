function login(){
    $('#load').show();
    const userId = document.getElementById("inid");
    const userPw = document.getElementById("inpw");
    if(userId.value == null || userId.value == ""){
        $("#load").hide();
        swal({
            text : "아이디를 입력해주세요.",
            icon : "info"
        });
    }else if(userPw.value == null || userPw.value == ""){
        $("#load").hide();
        swal({
            text : "비밀번호를 입력해주세요.",
            icon : "info"
        });
    }else{
        let sendData = {
            "id" : userId.value,
            "pw" : userPw.value
        }
        $.ajax({
            url : "/admin/userlogin",
            data : sendData,
            type : "GET",
            success : function(result){
                $("#load").hide();
                if(result.loginResult == "1"){
                    console.log("asd")
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