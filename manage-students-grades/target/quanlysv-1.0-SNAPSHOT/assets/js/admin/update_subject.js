function showModalSua(elementId, idMh, tenMh, tc, idKhoa) {
    const el = document.getElementById(elementId);
    document.getElementById("ma-mh-sua").value=idMh;
    document.getElementById("ten-mh-sua").value=tenMh;
    document.getElementById("stc-mh-sua").value=tc;
    document.getElementById("ma-khoa-mh-sua").value=idKhoa;
    el.classList.add('hien-thi-modal')
}

function hideModalSua(elementId){
    const el = document.getElementById(elementId);
    el.classList.remove('hien-thi-modal')
}