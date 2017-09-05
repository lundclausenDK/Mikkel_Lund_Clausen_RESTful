function addPerson() {

    var newname = nameField.value;
    console.log(newname);

    var url = "http://localhost/ajax/";
    var formData = new FormData();
    formData.append("data", newname);

    fetch(url, {method: "POST", body: formData}).then(function (response) {
        return response.text();
    });

}

function showPerson() {

    var url = "http://localhost:8080/REST/api/generic";
    var conf = { method: "get" };
    var promise = fetch(url, conf);

    promise.then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data.firstname);
    });
}

showPerson();