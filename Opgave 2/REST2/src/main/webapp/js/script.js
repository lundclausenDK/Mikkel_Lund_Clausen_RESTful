var quotesContainer = document.getElementById("quotes_container");

function printQuote() {

    var url = "http://localhost:8080/REST2/api/quote/random";
    var conf = {method: "get"};
    var promise = fetch(url, conf);

    promise.then(function (response) {
        return response.json();
    }).then(function (data) {

        quotesContainer.innerHTML += "Random quote: " + data.myQuote;

    });

}



printQuote();



