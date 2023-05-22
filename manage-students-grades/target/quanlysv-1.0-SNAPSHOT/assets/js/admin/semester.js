// set mặc định các biến
var pageSize=10;
var pageIndex=0;
var sortField='';
var sortOrder='';
var totalPages;

// request body của phương thức get và find
var formData = {
    "sortField": sortField,
    "sortOrder": sortOrder,
    "pageIndex": pageIndex,
    "pageSize": pageSize,
}
// lấy element để phân trang
const paginationElement = document.querySelector(".soTrang");
var pageNumbers;

// cái này sẽ được thực thi ngay khi mới vào trang -> Lấy tất cả giảng viên
document.addEventListener("DOMContentLoaded", getAllHK());

// đọc (R)
function getAllHK() {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/semester', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            const res = JSON.parse(xhr.responseText);
            const myTable = document.getElementById('myTable');
            const tbody = myTable.querySelector('tbody');
            totalPages=res.totalPages;
            while (tbody.firstChild) {
                tbody.removeChild(tbody.firstChild);
            }

            // cái này để render lại cái UI phân trang
            paginationElement.innerHTML = createPaginationUI(totalPages, pageIndex+1);

            // hàm này để add data đc trả về vào bảng
            res.data.forEach(function(item) {
                var row = `
                            <tr>
                              <td>`+item.idHk+`</td>
                              <td>`+item.tenHocKy+`</td>
                              <td>`+item.ngayTao+`</td>
                              <td>`+item.ngaySua+`</td>
                              <td class="chucNang">
                                <div class="hop-hanh-dong">
                                  <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_hoc_ky_sua', '`+ item.idHk +`', '`+ item.tenHocKy +`')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                  </button>
                                </div>
                              </td>
                            </tr>`;
                tbody.innerHTML+=row;
            });
        } else {
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify(formData));
}

// thêm (C)
function addHK() {
    const maHkInput = document.getElementById("ma-hk").value;
    const tenHkInput = document.getElementById("ten-hk").value;
    console.log(maHkInput + ": " + tenHkInput);
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/semester/create-or-edit', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            const res = JSON.parse(xhr.responseText);
            if(res.status===200) {
                alert("Thêm thông tin học kì " + maHkInput + " : " + tenHkInput + " thành công");
                getAllHK();
            } else {
                alert("Mã học kì " + maHkInput + " đã tồn tại");
            }
            hideModal('modal_hoc_ky');
        } else {
            console.log("Lấy thông tin học kỳ bị lỗi");
            jsonValue = jQuery.parseJSON(error.responseText);
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify({
        "status": 0,
        "idHk": maHkInput,
        "tenHocKy": tenHkInput
    }));
}

// sửa (U)
function updateHK() {
    const maHkInput = document.getElementById("ma-hk-sua").value;
    const tenHkInput = document.getElementById("ten-hk-sua").value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/semester/create-or-edit', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert("Sửa thông tin học kì " + maHkInput + " : " + tenHkInput + " thành công");
            hideModalSua('modal_hoc_ky_sua');
            getAllHK();
        } else {
            console.log("Sửa thông tin học kỳ bị lỗi");
            jsonValue = jQuery.parseJSON(error.responseText);
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify({
        "status": 1,
        "idHk": maHkInput,
        "tenHocKy": tenHkInput
    }));
}
// sort
function sortTable(field, event) {
    var thead=document.querySelector('thead');
    var hData=[...thead.querySelectorAll('th')]

    hData.map((head) => {
        if(head!==event) {
            head.classList.remove('asc', 'desc')
        }
    })

    var desc=event.classList.contains('asc');
    event.classList[desc ? 'remove' : 'add']('asc')
    event.classList[desc ? 'add' : 'remove']('desc')
    sortField = field;
    sortOrder = desc ? 'desc' : 'asc';
    formData = {
        "sortField": sortField,
        "sortOrder": sortOrder,
        "pageIndex": pageIndex,
        "pageSize": pageSize,
    }
    getAllHK();
}

// phân trang
function createPaginationUI(totalPages, currentPage) {
    let liTag = '';
    let active;
    let beforePage = currentPage - 1;
    let afterPage = currentPage + 1;
    if(currentPage > 2 && totalPages > 4){
        liTag += `<li class="first numb" onclick="getDataAtPageNum(totalPages, 1)"><span>1</span></li>`;
        if(currentPage > 3 && totalPages!=5){
            liTag += `<li class="dots"><span>...</span></li>`;
        }
    }
    if (currentPage === totalPages) {
        beforePage = beforePage - 2;
    } else if (currentPage === totalPages - 1) {
        beforePage = beforePage - 1;
    }
    if (currentPage === 1) {
        beforePage=1;
        afterPage = afterPage + 2;
    } else if (currentPage === 2) {
        beforePage = 1;
        afterPage = afterPage + 1;
    }
    for (var plength = beforePage; plength <= afterPage; plength++) {
        if (plength > totalPages) {
            continue;
        }
        if (plength === 0) {
            plength = plength + 1;
        }
        if(currentPage === plength){
            active = "active";
        }else{
            active = "";
        }
        liTag += `<li class="numb ${active}" onclick="getDataAtPageNum(totalPages, ${plength})"><span>${plength}</span></li>`;
    }
    if(currentPage < totalPages - 1 && totalPages>4){
        if(currentPage < totalPages - 2){
            liTag += `<li class="dots"><span>...</span></li>`;
        }
        liTag += `<li class="last numb" onclick="getDataAtPageNum(totalPages, ${totalPages})"><span>${totalPages}</span></li>`;
    }
    paginationElement.innerHTML = liTag;
    return liTag;
}

// lấy data ở trang mà mình bấm vào
function getDataAtPageNum(totalPages, currentPage) {
    createPaginationUI(totalPages, currentPage);
    formData = {
        "sortField": sortField,
        "sortOrder": sortOrder,
        "pageIndex": currentPage-1,
        "pageSize": pageSize,
    }
    getAllHK();
}

// thêm sự kiện click vào nút trang trước (>) trang sau (<) ở phần phân trang
const prevBtn=document.querySelector(".nutPaginate.prev");
const nextBtn=document.querySelector(".nutPaginate.next");
prevBtn.addEventListener("click", () => {
    if (pageIndex > 0) {
        pageIndex--;
        formData = {
            "sortField": sortField,
            "sortOrder": sortOrder,
            "pageIndex": pageIndex,
            "pageSize": pageSize,
        }
        createPaginationUI(totalPages, pageIndex+1)
        getAllHK();
    }
});

nextBtn.addEventListener("click", () => {
    if(pageIndex<totalPages-1) {
        pageIndex++;
        formData = {
            "sortField": sortField,
            "sortOrder": sortOrder,
            "pageIndex": pageIndex,
            "pageSize": pageSize,
        }
        createPaginationUI(totalPages, pageIndex+1)
        getAllHK();
    }
});