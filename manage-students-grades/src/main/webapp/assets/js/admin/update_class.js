function showModalSua(elementId, idlop, tenlop, hocky) {
    const el = document.getElementById(elementId);
    document.getElementById("ma-lop-sua").value=idlop;
    document.getElementById("ten-lop-sua").value=tenlop;
    document.getElementById("hoc-ky-sua").value=hocky;
    el.classList.add('hien-thi-modal')
}

function hideModalSua(elementId){
    const el = document.getElementById(elementId);
    el.classList.remove('hien-thi-modal')
}