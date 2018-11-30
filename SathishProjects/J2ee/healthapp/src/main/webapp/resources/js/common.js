function performAjaxRequest(httpMethod,url,data,responsecallback) {
    var xhttp = new XMLHttpRequest();
    xhttp.open(httpMethod,url,true);
    xhttp.setRequestHeader('Content-type','application/json');
    xhttp.setRequestHeader('Accept','application/json');
    xhttp.onreadystatechange = function () {
        responsecallback(xhttp);
    };
    var jsonObj = JSON.stringify(data);
    xhttp.send(jsonObj);
}