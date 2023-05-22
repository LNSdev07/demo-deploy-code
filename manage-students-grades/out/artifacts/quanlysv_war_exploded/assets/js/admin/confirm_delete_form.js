function hienXacNhanXoa(elementId, id, hiddenInput){
    const el = document.getElementById(elementId);
    el.classList.add('hien-thi-xac-nhan-xoa');
    const xoaBtn = document.querySelector('.xoa-btn');
    xoaBtn.setAttribute('data-id', id);
    document.querySelector('#textMa').innerHTML = id;
    document.getElementById(hiddenInput).value = id;
}

function anXacNhanXoa(elementId){
    const el = document.getElementById(elementId);
    el.classList.remove('hien-thi-xac-nhan-xoa');
}
