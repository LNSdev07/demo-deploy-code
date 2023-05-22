function showModalSua(elementId, idGv, tenGv, sdtGv, emailGv, genderGv, khoaGv) {
    const el = document.getElementById(elementId);
    document.getElementById("ma-gv-sua").value=idGv;
    document.getElementById("ten-gv-sua").value=tenGv;
    document.getElementById("email-gv-sua").value=emailGv;
    document.getElementById("gioi-tinh-gv-sua").value=genderGv;
    document.getElementById("sdt-gv-sua").value=sdtGv;
    document.getElementById("ma-khoa-gv-sua").value=khoaGv;
    el.classList.add('hien-thi-modal')
}

function hideModalSua(elementId){
    const el = document.getElementById(elementId);
    el.classList.remove('hien-thi-modal')
}