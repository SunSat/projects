
$(document).ready(function () {
    var userLike = document.getElementById("userLike").value;
    if(!userLike && userLike == 'true') {

    }
})

window.onscroll = function() {performAllRequiredAction()};
// Get the leftSection
var sectionMovableDiv = document.getElementById("section-movable");
var tempContent = document.getElementById("content-temp-visible");

// Get the top offset position of the left-section.
var secMovableTopOffset = sectionMovableDiv.offsetTop;

function performAllRequiredAction() {
    performStickyOperations()

}

function performStickyOperations() {
    performMainLeftSticky();
}

// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
function performMainLeftSticky() {

    if (window.pageYOffset >= (secMovableTopOffset+180)) {
        sectionMovableDiv.classList.add("section-movable-sticky");
        tempContent.classList.add("content-temp-visible-sticky");
    } else {
        sectionMovableDiv.classList.remove("section-movable-sticky");
        tempContent.classList.remove("content-temp-visible-sticky");
    }
}

function performLikeClicked(that) {
    if(!isUserLogged()) {
        loginMouseHover();
        return;
    }

    var like = document.getElementById('userLike').value
    var data = {
        userLike : like,
        formAction : "loginPage",
        formSubAction : "signUp"
    };

    var userLikeResponseCallBack = function (xhttp) {
        if(xhttp.readyState != 4 || xhttp.status != 200) {
            return;
        }
        var formModel = JSON.parse( xhttp.responseText );
        document.getElementById("total-no-likes").innerText = formModel.userLikeCount;
        document.getElementById("userLike").value = formModel.userLike;
        //change the color to green.
    };
    performAjaxJsonRequest("post","userLike.do",data,userLikeResponseCallBack);
}

function isUserLogged() {
    var userId = document.getElementById('loggedUserId').value;
    if(userId > 0) {
        return true;
    }
    return false;
}
