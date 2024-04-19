function strikeOutRow(checkbox) {
    var row = checkbox.parentNode.parentNode;
    if (checkbox.checked) {
        row.classList.add('completed');
    } else {
        row.classList.remove('completed');
    }
}

function confirmation(){
    return confirm("Are you sure to delete");
}

var model = document.getElementById("myModel")
var btn = document.querySelector("button")
var span = document.getElementsByClassName("close")[0];

function  OpenModel(){
    model.style.display = "block";
}

function  closeModel(){
    model.style.display = "none";
}

window.onclick = function (event){
    if(event.target === model){
        model.style.display = "none";
    }
}
