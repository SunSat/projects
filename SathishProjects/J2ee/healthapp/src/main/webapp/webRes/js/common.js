function performAjaxRequest(httpMethod,url,data,responsecallback) {
    var xhttp = new XMLHttpRequest();
    xhttp.open(httpMethod,url,true);
    xhttp.setRequestHeader('X-CSRF-TOKEN',data._csrf);
    xhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhttp.setRequestHeader('Accept','application/x-www-form-urlencoded');
    xhttp.onreadystatechange = function () {
        responsecallback(xhttp);
    };
    var strObj = "";
    for(var arg in data) {
        strObj += arg + "=" + data[arg] + "&";
    }
    xhttp.send(strObj);
}

function performAjaxJsonRequest(httpMethod,url,data,responsecallback) {
    var xhttp = new XMLHttpRequest();
    xhttp.open(httpMethod,url,true);
    xhttp.setRequestHeader('Content-type','application/json');
    xhttp.setRequestHeader('Accept','application/json');
    xhttp.setRequestHeader("X-CSRF-TOKEN",data._csrf);
    xhttp.onreadystatechange = function () {
        responsecallback(xhttp);
    };
    var jsonObj = JSON.stringify(data);
    xhttp.send(jsonObj);
}