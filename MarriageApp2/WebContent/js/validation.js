
function validate(frm) {
frm.pflag.value="yes";
document.getElementById("nameErr").innerHTML="";
document.getElementById("ageErr").innerHTML="";

document.getElementById("nameErr").style="color:red";
document.getElementById("ageErr").style="color:red";
var name=frm.name.value;
var age=frm.age.value;
if(name==""){
document.getElementById("nameErr").innerHTML="Name is mandetory";
frm.name.focus();
return false;
}
if(isNaN(age)){
document.getElementById("ageErr").innerHTML="age is mandetory";
frm.age.focus();
return false;
}
else if(age<1 || age>125){
document.getElementById("ageErr").innerHTML="age must be 1 through 10";
frm.age.focus();
return false;
}
return true;
}

