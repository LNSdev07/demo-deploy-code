function showModalSua(elementId, idHk, tenHk) {
    const el = document.getElementById(elementId);
    document.getElementById("ma-hk-sua").value=idHk;
    document.getElementById("ten-hk-sua").value=tenHk;
    el.classList.add('hien-thi-modal')
}

function hideModalSua(elementId){
    const el = document.getElementById(elementId);
    el.classList.remove('hien-thi-modal')
}
