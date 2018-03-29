/**
 * Created by sathishkumar_su on 3/21/2018.
 */

function loginMouseHover() {
   //document.getElementById('main-login-container').style.display = 'block';
    var classList = document.getElementById('main-login-container').classList
    if(classList.length <= 1) {
        classList.toggle('show-login');
        showSignInForm();
    }
}
function loginCloseBut() {
    //var loginPageDiv = document.getElementById('main-login-container');
    //loginPageDiv.style.display = 'none';
    document.getElementById('main-login-container').classList.remove('show-login');
}

function doLogin() {
    var userName = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST","/userLogin.do",true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    var jsonUserLogReq = JSON.stringify({userName:userName,password:password});
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var message = JSON.parse(this.responseText).responseResult;
            if(message == 'success') {
                document.getElementById('login-navigation').style.display  = 'none'
                document.getElementById('logout-navigation').style.display  = 'block'
                //document.getElementById('main-login-container').style.display = 'none';
                document.getElementById('main-login-container').classList.remove('show-login');
                document.getElementById('responseResult').innerHTML = '';
            } else {
                document.getElementById('responseResult').innerHTML = message;
            }
        } else {
            var message = this.responseText;
            if(message == '') {
                message = "Invalid UserName and Password."
            } else {
                message = JSON.parse(this.responseText);
            }
            document.getElementById('responseResult').innerHTML = message;
        }
    };
    xhttp.send(jsonUserLogReq);
}

function showSignInForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "block";
    document.getElementById("forgot-password-container").style.display = "none";
}

function showSignUpForm() {
    document.getElementById("signUp-container").style.display = "block";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "none";
}

function showForgotPasswordForm() {
    document.getElementById("signUp-container").style.display = "none";
    document.getElementById("login-container").style.display = "none";
    document.getElementById("forgot-password-container").style.display = "block";
}
/**
 var xhttp = new XMLHttpRequest();
 xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
 xhttp.open("GET", "ajax_info.txt", true);
 xhttp.send();

 **/

function showSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-hover') ) {
        clsList.toggle('general-search-container-hover');
    }
}

function showExpandSearchBar() {
    var clsList = document.getElementById('general-search-container').classList;
    if ( !clsList.contains('general-search-container-expand') ) {
        clsList.toggle('general-search-container-expand');
    }
}