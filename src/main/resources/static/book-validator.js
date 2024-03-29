function validate() {
    alert("odpalam validacje book");
    var title = document.getElementById("title");
    var author = document.getElementById("author");
    var isbn = document.getElementById("isbn");
    var price = document.getElementById("price");
    var quantity = document.getElementById("quantity");
    var info = document.getElementById("info");

    price.value = price.value.replace(',','.');

    var titleRegex = /^.+$/;
    var authorRegex = /^[A-Z][a-z]+\ [A-Z][a-z]+([-\ ][A-Z][a-z]+)?(,(\ )?[A-Z][a-z]+\ [A-Z][a-z]+([-\ ][A-Z][a-z]+)?)*$/;
    var isbnRegex = /^.+$/;
    var priceRegex = /^.+$/;
    var quantityRegex = /^[0-9]+$/

    var result = true;
    var infoText = "";

    if(!titleRegex.test(title.value)) {
        title.style.background = "#a8beff";
        infoText = infoText + "Niepoprawny tytuł <br>";
        result = false;
    } else {
        title.style.background = null;
    }

    if(!authorRegex.test(author.value)) {
        author.style.background = "#a8beff";
        infoText = infoText + "Niepoprawne author <br>";
        result = false;
    } else {
        author.style.background = null;
    }

     if(!isbnRegex.test(isbn.value)) {
         isbn.style.background = "#a8beff";
         infoText = infoText + "Niepoprawne isbn <br>";
         result = false;
     } else {
         isbn.style.background = null;
     }


     if(!priceRegex.test(price.value)) {
         price.style.background = "#a8beff";
         infoText = infoText + "Niepoprawne isbn <br>";
         result = false;
     } else {
         price.style.background = null;
     }


     if(!quantityRegex.test(quantity.value)) {
         quantity.style.background = "#a8beff";
         infoText = infoText + "Niepoprawne isbn <br>";
         result = false;
     } else {
         quantity.style.background = null;
     }

    info.innerHTML = infoText;

    return result;
}
