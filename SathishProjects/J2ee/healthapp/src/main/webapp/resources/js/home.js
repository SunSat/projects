

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