const errorMessage = document.querySelectorAll(".tb-loi-nhap")
const closeButton = document.getElementById("dong-form-btn")

closeButton.addEventListener("click", function() {
    for(var i=0; i<errorMessage.length; i++) {
        errorMessage[i].style.display="none"
    }
})

function validateForm() {
    let error = false;
    const maMhInput = document.getElementById("ma-mh")
    const maMhError = document.getElementById("ma-mh-error")
    const tenMhInput = document.getElementById("ten-mh")
    const tenMhError = document.getElementById("ten-mh-error")
    const soTinChiMhInput = document.getElementById("stc-mh")
    const soTinChiMhError = document.getElementById("stc-mh-error")
    const khoaMhInput = document.getElementById("ma-khoa-mh")
    const khoaMhError = document.getElementById("ma-khoa-mh-error")

    if (maMhInput.value === "") {
        maMhError.style.display = "block";
        error = true;
    } else {
        maMhError.style.display = "none";
    }

    if (tenMhInput.value === "") {
        tenMhError.style.display = "block";
        error = true;
    } else {
        tenMhError.style.display = "none";
    }

    if (soTinChiMhInput.value === "") {
        soTinChiMhError.style.display = "block";
        error = true;
    } else {
        soTinChiMhError.style.display = "none";
    }


    if (khoaMhInput.value === "") {
        khoaMhError.style.display = "block";
        error = true;
    } else {
        khoaMhError.style.display = "none";
    }


    maMhInput.addEventListener("input", function() {
        maMhError.style.display = "none"
    })

    tenMhInput.addEventListener("input", function() {
        tenMhError.style.display = "none"
    })

    soTinChiMhInput.addEventListener("input", function() {
        soTinChiMhError.style.display = "none"
    })

    khoaMhInput.addEventListener("input", function() {
        khoaMhError.style.display = "none"
    })

    return !error;
}


function validateFormSua() {
    let error = false;
    const maMhInput = document.getElementById("ma-mh-sua")
    const maMhError = document.getElementById("ma-mh-error-sua")
    const tenMhInput = document.getElementById("ten-mh-sua")
    const tenMhError = document.getElementById("ten-mh-error-sua")
    const soTinChiMhInput = document.getElementById("stc-mh-sua")
    const soTinChiMhError = document.getElementById("stc-mh-error-sua")
    const khoaMhInput = document.getElementById("ma-khoa-mh-sua")
    const khoaMhError = document.getElementById("ma-khoa-mh-error-sua")

    if (maMhInput.value === "") {
        maMhError.style.display = "block";
        error = true;
    } else {
        maMhError.style.display = "none";
    }

    if (tenMhInput.value === "") {
        tenMhError.style.display = "block";
        error = true;
    } else {
        tenMhError.style.display = "none";
    }

    if (soTinChiMhInput.value === "") {
        soTinChiMhError.style.display = "block";
        error = true;
    } else {
        soTinChiMhError.style.display = "none";
    }


    if (khoaMhInput.value === "") {
        khoaMhError.style.display = "block";
        error = true;
    } else {
        khoaMhError.style.display = "none";
    }


    maMhInput.addEventListener("input", function() {
        maMhError.style.display = "none"
    })

    tenMhInput.addEventListener("input", function() {
        tenMhError.style.display = "none"
    })

    soTinChiMhInput.addEventListener("input", function() {
        soTinChiMhError.style.display = "none"
    })


    khoaMhInput.addEventListener("input", function() {
        khoaMhError.style.display = "none"
    })

    return !error;
}


