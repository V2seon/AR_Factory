function In_review(){

const pjnum = document.getElementById('pjnum').innerText;
const rename = document.getElementById('rename').value;
const repw = document.getElementById('repw').value;
const retext = document.getElementById('retext').value;

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
}
}