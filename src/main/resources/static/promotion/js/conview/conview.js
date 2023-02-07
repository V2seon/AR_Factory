function inCon(){
const Contype = document.getElementsByName('typechoice');
const Usertype = document.getElementsByName('typechoice1');
const Username = document.getElementById('username').value;
const Userphone = document.getElementById('userphone').value;
const Useremail = document.getElementById('useremail').value;
const Company = document.getElementById('company').value;
const Department = document.getElementById('department').value;
const Rank = document.getElementById('rank').value;
const Conname = document.getElementById('conname').value;
const Context = document.getElementById('context').value;
for(var i=0; i<Contype.length; i++){
    if(Contype[i].checked){
    var Conchoice = Contype[i].value;
    }
}
for(var i=0; i<Usertype.length; i++){
    if(Usertype[i].checked){
    var Userchoice = Usertype[i].value;
    }
}
if(Conchoice == null || Conchoice == ""){
    swal({
          text: "문의유형을 선택하세요.",
          icon: "info"
          });
}else if(Username == null || Username == ""){
    swal({
          text: "고객명을 입력하세요.",
          icon: "info"
          });
}else if(Userphone == null || Userphone == ""){
    swal({
          text: "연락처를 입력하세요.",
          icon: "info"
          });
}else if(Useremail == null || Useremail == ""){
    swal({
          text: "이메일을 입력하세요.",
          icon: "info"
          });
}else if(Company == null || Company == ""){
    swal({
          text: "기업/기관명을 입력하세요.",
          icon: "info"
          });
}else if(Userchoice == null || Userchoice == ""){
    swal({
          text: "산업군별을 선택하세요.",
          icon: "info"
          });
}else if(Conname == null || Conname == ""){
    swal({
          text: "제목을 입력하세요.",
          icon: "info"
          });
}else if(Context == null || Context == ""){
    swal({
          text: "문의내용을 입력하세요.",
          icon: "info"
          });
}else if(document.getElementById('chk10').checked == false){
     swal({
           text: "개인정보 처리 방침에 동의해주세요.",
           icon: "info"
           });
}else{
let sendData = {
            "conchoice" : Conchoice,
            "userchice" : Userchoice,
            "username" : Username,
            "userphone" : Userphone,
            "useremail" : Useremail,
            "company" : Company,
            "conname" : Conname,
            "context" : Context
}
$.ajax({
            url      : "/In_Af_inq",
            data     : sendData,
            type     : "POST",
            success : function(result) {
                    swal({
                      title: "문의가 완료되었습니다.",
                      icon: "success",
                      closeOnClickOutside : false
                    }).then((result) =>{
                        location.href = "/";
                    });
            },
            error:function(request,status,error){
            }
        });
}
}

function delCon(){
window.close();
}