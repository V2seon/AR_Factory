function In_review(){

const pjnum = document.getElementById('pjnum').innerText;
const rename = document.getElementById('rename').value;
const repw = document.getElementById('repw').value;
const retext = document.getElementById('retext').value;
const starval1 = document.querySelector('input[name="starpoint"]:checked').value;
const starval = parseFloat(starval1);
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
}else if(document.querySelector('input[name="starpoint"]:checked') == null){
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
    console.log(pjnum);
    console.log(rename);
    console.log(repw);
    console.log(retext);
    console.log(typeof starval);

    let sendData = {
        "pjnum" : pjnum,
        "rename" : rename,
        "repw" : repw,
        "retext" : retext,
        "starval" : starval
    }
    $.ajax({
                url      : "/In_Af_review",
                data     : sendData,
                type     : "POST",
                success : function(result) {
                        swal({
                          title: "후기작성이 완료되었습니다.",
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