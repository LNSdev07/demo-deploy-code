const errorMessage = document.querySelectorAll(".tb-loi-nhap");
const closeButton = document.getElementById("dong-form-btn");

closeButton.addEventListener("click", function() {
    for(var i=0; i<errorMessage.length; i++) {
        errorMessage[i].style.display="none";
    }
})

function validateForm() {
    let error = false;
    const malopInput = document.getElementById("ma")
    const malopError = document.getElementById("ma-error")
    const tenlopInput = document.getElementById("ten")
    const tenlopError = document.getElementById("ten-error")
    const tenHkInput = document.getElementById("ten-hk")
    const tenHkError = document.getElementById("ten-hk-error");

    if (malopInput.value === "") {
        malopError.style.display = "block";
        error = true;
    } else {
        malopError.style.display = "none";
    }

    if (tenlopInput.value === "") {
        tenlopError.style.display = "block";
        error = true;
    } else {
        tenlopError.style.display = "none";
    }

    if (tenHkInput.value === "") {
        tenHkError.style.display = "block";
        error = true;
    } else {
        tenHkError.style.display = "none";
    }

    malopInput.addEventListener("input", function() {
        malopError.style.display = "none"
    })

    tenlopInput.addEventListener("input", function() {
        tenlopError.style.display = "none"
    })

    tenHkInput.addEventListener("input", function() {
        tenHkError.style.display = "none"
    })

    return !error;
}

const errorMessageSua = document.querySelectorAll(".tb-loi-nhap-sua");
const closeButtonSua = document.getElementById("dong-form-btn-sua");

closeButtonSua.addEventListener("click", function() {
    for(var i=0; i<errorMessageSua.length; i++) {
        errorMessageSua[i].style.display="none"
    }
})

function validateFormSua() {
    let error=false;
    const malopInput = document.getElementById("ma-lop-sua")
    const malopError = document.getElementById("ma-lop-error-sua")
    const tenlopInput = document.getElementById("ten-lop-sua")
    const tenlopError = document.getElementById("ten-lop-error-sua")
    const tenHkInput = document.getElementById("hoc-ky-sua")
    const tenHkError = document.getElementById("hoc-ky-error-sua")

    if (malopInput.value === "") {
        malopError.style.display = "block";
        error = true;
    } else {
        malopError.style.display = "none";
    }

    if (tenlopInput.value === "") {
        tenlopError.style.display = "block";
        error = true;
    } else {
        tenlopError.style.display = "none";
    }

    if (tenHkInput.value === "") {
        tenHkError.style.display = "block";
        error = true;
    } else {
        tenHkError.style.display = "none";
    }

    malopInput.addEventListener("input", function() {
        malopError.style.display = "none"
    })

    tenlopInput.addEventListener("input", function() {
        tenlopError.style.display = "none"
    })


    tenHkInput.addEventListener("input", function() {
        tenHkError.style.display = "none"
    })

    return !error;
}