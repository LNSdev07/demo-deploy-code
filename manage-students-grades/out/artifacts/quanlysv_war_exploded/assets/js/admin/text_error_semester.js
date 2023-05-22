const errorMessage = document.querySelectorAll(".tb-loi-nhap")
const closeButton = document.getElementById("dong-form-btn")

closeButton.addEventListener("click", function() {
    for(var i=0; i<errorMessage.length; i++) {
        errorMessage[i].style.display="none"
    }
})

function validateForm() {
    let error = false;
    const maHkInput = document.getElementById("ma-hk")
    const maHkError = document.getElementById("ma-hk-error")
    const tenHkInput = document.getElementById("ten-hk")
    const tenHkError = document.getElementById("ten-hk-error")
    if (maHkInput.value === "") {
        maHkError.style.display = "block";
        error = true;
    } else {
        maHkError.style.display = "none";
    }

    if (tenHkInput.value === "") {
        tenHkError.style.display = "block";
        error = true;
    } else {
        tenHkError.style.display = "none";
    }
    maHkInput.addEventListener("input", function() {
        maHkError.style.display = "none"
    })

    tenHkInput.addEventListener("input", function() {
        tenHkError.style.display = "none"
    })

    return !error;
}

function validateFormSua() {
    let error = false;
    const maHkInput = document.getElementById("ma-hk-sua")
    const maHkError = document.getElementById("ma-hk-error-sua")
    const tenHkInput = document.getElementById("ten-hk-sua")
    const tenHkError = document.getElementById("ten-hk-error-sua")
    if (maHkInput.value === "") {
        maHkError.style.display = "block";
        error = true;
    } else {
        maHkError.style.display = "none";
    }

    if (tenHkInput.value === "") {
        tenHkError.style.display = "block";
        error = true;
    } else {
        tenHkError.style.display = "none";
    }
    maHkInput.addEventListener("input", function() {
        maHkError.style.display = "none"
    })

    tenHkInput.addEventListener("input", function() {
        tenHkError.style.display = "none"
    })

    return !error;
}



