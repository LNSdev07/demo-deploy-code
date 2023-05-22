const errorMessage = document.querySelectorAll(".tb-loi-nhap")
const closeButton = document.getElementById("dong-form-btn")

closeButton.addEventListener("click", function() {
    for(var i=0; i<errorMessage.length; i++) {
        errorMessage[i].style.display="none"
    }
})

function validateForm() {
    let success = true;

    const maSvInput = document.getElementById("ma-sv")
    const maSvError = document.getElementById("ma-sv-error")
    const tenSvInput = document.getElementById("ten-sv")
    const tenSvError = document.getElementById("ten-sv-error")
    const emailSvInput = document.getElementById("email-sv")
    const emailSvError = document.getElementById("email-sv-error")
    const dobSvInput = document.getElementById("dob-sv")
    const dobSvError = document.getElementById("dob-sv-error")
    const gioiTinhSvInput = document.getElementById("gioi-tinh-sv")
    const gioiTinhSvError = document.getElementById("gioi-tinh-sv-error")
    const sdtSvInput = document.getElementById("sdt-sv")
    const sdtSvError = document.getElementById("sdt-sv-error")
    const lopSvInput = document.getElementById("ma-lop-sv")
    const lopSvError = document.getElementById("ma-lop-sv-error")

    if (maSvInput.value === "") {
        maSvError.style.display = "block";
        success = false;
    } else {
        maSvError.style.display = "none";
    }

    if (tenSvInput.value === "") {
        tenSvError.style.display = "block";
        success = false;
    } else {
        tenSvError.style.display = "none";
    }

    if (emailSvInput.value === "") {
        emailSvError.style.display = "block";
        success = false;
    } else {
        emailSvError.style.display = "none";
    }

    if (gioiTinhSvInput.value === "") {
        gioiTinhSvError.style.display = "block";
        success = false;
    } else {
        gioiTinhSvError.style.display = "none";
    }

    if (sdtSvInput.value === "") {
        sdtSvError.style.display = "block";
        success = false;
    } else {
        sdtSvError.style.display = "none";
    }

    if (lopSvInput.value === "") {
        lopSvError.style.display = "block";
        success = false;
    } else {
        lopSvError.style.display = "none";
    }

    if (dobSvInput.value === "") {
        dobSvError.style.display = "block";
        success = false;
    } else {
        dobSvError.style.display = "none";
    }

    maSvInput.addEventListener("input", function() {
        maSvError.style.display = "none"
    })

    tenSvInput.addEventListener("input", function() {
        tenSvError.style.display = "none"
    })


    emailSvInput.addEventListener("input", function() {
        emailSvError.style.display = "none"
    })

    dobSvInput.addEventListener("input", function() {
        dobSvError.style.display = "none"
    })

    sdtSvInput.addEventListener("input", function() {
        sdtSvError.style.display = "none"
    })

    gioiTinhSvInput.addEventListener("input", function() {
        gioiTinhSvError.style.display = "none"
    })

    lopSvInput.addEventListener("input", function() {
        lopSvError.style.display = "none"
    })

    return success;
}

const errorMessageSua = document.querySelectorAll(".tb-loi-nhap-sua")
const closeButtonSua = document.getElementById("dong-form-btn-sua")

closeButtonSua.addEventListener("click", function() {
    for(var i=0; i<errorMessageSua.length; i++) {
        errorMessageSua[i].style.display="none"
    }
})

function validateFormSua() {
    let success = true;

    const maSvInput = document.getElementById("ma-sv-sua")
    const maSvError = document.getElementById("ma-sv-error-sua")
    const tenSvInput = document.getElementById("ten-sv-sua")
    const tenSvError = document.getElementById("ten-sv-error-sua")
    const emailSvInput = document.getElementById("email-sv-sua")
    const emailSvError = document.getElementById("email-sv-error-sua")
    const dobSvInput = document.getElementById("dob-sv-sua")
    const dobSvError = document.getElementById("dob-sv-error-sua")
    const gioiTinhSvInput = document.getElementById("gioi-tinh-sv-sua")
    const gioiTinhSvError = document.getElementById("gioi-tinh-sv-error-sua")
    const sdtSvInput = document.getElementById("sdt-sv-sua")
    const sdtSvError = document.getElementById("sdt-sv-error-sua")
    const lopSvInput = document.getElementById("ma-lop-sv-sua")
    const lopSvError = document.getElementById("ma-lop-sv-error-sua")

    if (maSvInput.value === "") {
        maSvError.style.display = "block";
        success = false;
    } else {
        maSvError.style.display = "none";
    }

    if (tenSvInput.value === "") {
        tenSvError.style.display = "block";
        success = false;
    } else {
        tenSvError.style.display = "none";
    }

    if (emailSvInput.value === "") {
        emailSvError.style.display = "block";
        success = false;
    } else {
        emailSvError.style.display = "none";
    }

    if (gioiTinhSvInput.value === "") {
        gioiTinhSvError.style.display = "block";
        success = false;
    } else {
        gioiTinhSvError.style.display = "none";
    }

    if (sdtSvInput.value === "") {
        sdtSvError.style.display = "block";
        success = false;
    } else {
        sdtSvError.style.display = "none";
    }

    if (lopSvInput.value === "") {
        lopSvError.style.display = "block";
        success = false;
    } else {
        lopSvError.style.display = "none";
    }

    if (dobSvInput.value === "") {
        dobSvError.style.display = "block";
        success = false;
    } else {
        dobSvError.style.display = "none";
    }

    maSvInput.addEventListener("input", function() {
        maSvError.style.display = "none"
    })

    tenSvInput.addEventListener("input", function() {
        tenSvError.style.display = "none"
    })


    emailSvInput.addEventListener("input", function() {
        emailSvError.style.display = "none"
    })

    dobSvInput.addEventListener("input", function() {
        dobSvError.style.display = "none"
    })

    sdtSvInput.addEventListener("input", function() {
        sdtSvError.style.display = "none"
    })

    gioiTinhSvInput.addEventListener("input", function() {
        gioiTinhSvError.style.display = "none"
    })

    lopSvInput.addEventListener("input", function() {
        lopSvError.style.display = "none"
    })

    return success;
}