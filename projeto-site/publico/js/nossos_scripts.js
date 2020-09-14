
popupbg.style.display = "none";
login.style.display = "none";
register.style.display = "none";
funcionario2.style.display = "none";
funcionario3.style.display = "none";
funcionario4.style.display = "none";
funcionario5.style.display = "none";
funcionario6.style.display = "none";

function showLogin() {
    document.getElementById("popupbg").style.display = "";
    document.getElementById("login").style.display = "";
}

function showRegister() {
    document.getElementById("login").style.display = "none";
    document.getElementById("popupbg").style.display = "";
    document.getElementById("register").style.display = "";
}

function closePopupContent(){
    document.getElementById("popupbg").style.display = "none";
    document.getElementById("login").style.display = "none";
}

let funcionarioNumber = 1;

function rollRigth() {

    if (funcionarioNumber < 6) {

        document.getElementById(`funcionario${funcionarioNumber}`).style.display = "none"
        document.getElementById(`funcionario${funcionarioNumber + 1}`).style.display = ""
    

        funcionarioNumber++;
    }
    else {
        document.getElementById(`funcionario${funcionarioNumber}`).style.display = "none"
        funcionarioNumber = 1;
        document.getElementById(`funcionario${funcionarioNumber}`).style.display = ""
    }


}

function rollLeft() {

    if (funcionarioNumber > 1) {

        document.getElementById(`funcionario${funcionarioNumber}`).style.display = "none"
        document.getElementById(`funcionario${funcionarioNumber - 1}`).style.display = ""

        funcionarioNumber--;
    }
    else {
        document.getElementById(`funcionario${funcionarioNumber}`).style.display = "none"
        funcionarioNumber = 6;
        document.getElementById(`funcionario${funcionarioNumber}`).style.display = ""
    }

}