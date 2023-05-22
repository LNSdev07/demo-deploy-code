const table=document.querySelector('tbody')
const rows = table.rows;
const numPerPage = 10;
let currentPage = 1;
let totalPages=Math.ceil(table.rows.length/numPerPage)

function showPage(page) {
    const start = (page - 1) * numPerPage;
    const end = start + numPerPage;
    for (let i = 0; i < rows.length; i++) {
        if (i >= start && i < end) {
            rows[i].style.display = "table-row";
        } else {
            rows[i].style.display = "none";
        }
    }
}

const element = document.querySelector(".phanTrang ul");
element.innerHTML = createPagination(totalPages, currentPage);
function createPagination(totalPages, currentPage){
    let liTag = '';
    let active;
    let beforePage = currentPage - 1;
    let afterPage = currentPage + 1;
    if(currentPage > 1){
        liTag += `<li class="nutPaginate prev" style="color: white" onclick="createPagination(totalPages, ${currentPage - 1})"><span><i class="fas fa-angle-left"></i></span></li>`;
    }
    if(currentPage > 2 && totalPages>4){
        liTag += `<li class="first numb" onclick="createPagination(totalPages, 1)"><span>1</span></li>`;
        if(currentPage > 3){
            liTag += `<li class="dots"><span>...</span></li>`;
        }
    }
    if (currentPage == totalPages) {
        beforePage = beforePage - 2;
    } else if (currentPage == totalPages - 1) {
        beforePage = beforePage - 1;
    }
    if (currentPage == 1) {
        beforePage=1;
        afterPage = afterPage + 2;
    } else if (currentPage == 2) {
        beforePage=1;
        afterPage  = afterPage + 1;
    }
    for (var plength = beforePage; plength <= afterPage; plength++) {
        if (plength > totalPages) {
            continue;
        }
        if (plength == 0) {
            plength = plength + 1;
        }
        if(currentPage == plength){
            active = "active";
        }else{
            active = "";
        }
        liTag += `<li class="numb ${active}" onclick="createPagination(totalPages, ${plength})"><span>${plength}</span></li>`;
    }
    if(currentPage < totalPages - 1 && totalPages>4){
        if(currentPage < totalPages - 2){
            liTag += `<li class="dots"><span>...</span></li>`;
        }
        liTag += `<li class="last numb" onclick="createPagination(totalPages, ${totalPages})"><span>${totalPages}</span></li>`;
    }
    if (currentPage < totalPages) {
        liTag += `<li class="nutPaginate next" style="color: white" onclick="createPagination(totalPages, ${currentPage + 1})"><span><i class="fas fa-angle-right"></i></span></li>`;
    }
    element.innerHTML = liTag;
    showPage(currentPage)
    return liTag;
}