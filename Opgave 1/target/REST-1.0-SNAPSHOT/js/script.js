var first = document.getElementById("firstName");
var last = document.getElementById("lastName");
var phonenumber = document.getElementById("phonenumber");
var createPerson = document.getElementById("nameCreate");
var personListContainer = document.getElementById("table_list");

function addPerson() {

    first = firstName.value;
    last = lastName.value;
    number = phonenumber.value;

    console.log(first, last, number);

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var url = "http://localhost:8080/REST/api/persons";
    var formData = new FormData();
    //formData.append("data", first, last, number);

    fetch(url, {method: "POST", headers: myHeaders, body: JSON.stringify({"firstName": first, "lastName": last, "phonenumber": number})}).then(function (response) {
        return response.text();
    });

}

function showPerson() {

    var url = "http://localhost:8080/REST/api/persons";
    var conf = {method: "get"};
    var promise = fetch(url, conf);

    promise.then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data[0].firstName + " " + data[0].lastName + " " + data[0   ].phonenumber);
    });
}

//showPerson();

function printPersonTable() {

    personListContainer.innerHTML += "<div class='table' id='t_container'></div";
    var tableContainer = document.getElementById("t_container");

    var url = "http://localhost:8080/REST/api/persons";
    var conf = {method: "get"};
    var promise = fetch(url, conf);

    promise.then(function (response) {
        return response.json();
    }).then(function (data) {
        for (var i = 0; i < data.length; i++) {
            tableContainer.innerHTML += "<div class='table-row'><div class='table-cell'>" + data[i].id + "</div>" +
                    "<div class='table-cell'>" + data[i].firstName + "</div>" +
                    "<div class='table-cell'>" + data[i].lastName + "</div>" +
                    "<div class='table-cell'>" + data[i].phonenumber + "</div>" +
                    "<div class='table-cell'><a href='#' class='edit' data-id=" + data[i].id + " data-firstname=" + data[i].firstName + " data-lastname=" + data[i].lastName + " data-phonenumber=" + data[i].phonenumber + ">Edit</a> | <a href='#' class='delete'>Delete</a></div";
        }
        var editButton = document.getElementsByClassName("edit");
        var deleteButton = document.getElementById("delete");
        
        for (var i = 0; i < editButton.length; i++) {
            editButton[i].addEventListener("click", editPerson, false);
        }
        
        for (var i = 0; i < deleteButton.length; i++) {
            deleteButton[i].addEventListener("click", editPerson, false);
        }
    });

}

printPersonTable();

function editPerson(id, first, last, number) {
    id = this.dataset.id;
    first = this.dataset.firstname;
    last = this.dataset.lastname;
    number = this.dataset.phonenumber;
    
    console.log(id, first, last, number);
}

function deletePerson(id) {
    id = this.dataset.id;
}



createPerson.addEventListener("click", addPerson, false);
