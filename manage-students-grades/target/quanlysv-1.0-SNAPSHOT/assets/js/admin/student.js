// set mặc định các biến
var pageSize = 10;
var pageIndex = 1;
var sortField = '';
var sortOrder = '';
var idSv = '';
var tenSv = '';
var totalPages;

// request body của phương thức get và find
var formData = {
    "idSv": idSv,
    "tenSv": tenSv,
    "baseRequest": {
        "sortField": sortField,
        "sortOrder": sortOrder,
        "pageIndex": pageIndex,
        "pageSize": pageSize,
    }
}

// lấy element để phân trang
const paginationElement = document.querySelector(".soTrang");
var pageNumbers;

// cái này sẽ được thực thi ngay khi mới vào trang -> Lấy tất cả sinh viên
document.addEventListener("DOMContentLoaded", readDataInit());

// đọc (R)
// đọc data lúc mới vào trang
function readDataInit() {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/student', true);
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
            paginationElement.innerHTML = createPaginationUI(totalPages, pageIndex);

            // hàm này để add data đc trả về vào bảng
            res.data.forEach(function(item) {
                var row = `
                            <tr>
                              <td>`+item.idSv+`</td>
                              <td>`+item.tenSv+`</td>
                              <td>`+item.emailSv+`</td>
                              <td>`+item.dobSv+`</td>
                              <td>`+item.genderSv+`</td>
                              <td>`+item.phoneSv+`</td>
                              <td>`+item.lopHanhChinhSv+`</td>
                              <td>`+item.ngayTao+`</td>
                              <td>`+item.ngaySua+`</td>
                              <td class="chucNang">
                                <div class="hop-hanh-dong">
                                  <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_sinh_vien_sua', '`+ item.idSv +`', '`+ item.tenSv +`', '`+ item.emailSv +`', '`+ item.dobSv +`', '`+ item.genderSv +`', '`+ item.phoneSv +`', '`+ item.lopHanhChinhSv +`')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                  </button>
                                  <button onclick="hienXacNhanXoa('modal_xac_nhan_xoa', '`+ item.idSv +`')" class="xoa hop-hanh-dong-nut" type="button">
                                    <span class="xoa_tieuDe">Xóa</span>
                                    <i class="fa-solid fa-trash xoa_icon"></i>
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

function getAllSV() {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/student', true);
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

            // hàm này để add data đc trả về vào bảng
            res.data.forEach(function(item) {
                var row = `
                            <tr>
                              <td>`+item.idSv+`</td>
                              <td>`+item.tenSv+`</td>
                              <td>`+item.emailSv+`</td>
                              <td>`+item.dobSv+`</td>
                              <td>`+item.genderSv+`</td>
                              <td>`+item.phoneSv+`</td>
                              <td>`+item.lopHanhChinhSv+`</td>
                              <td>`+item.ngayTao+`</td>
                              <td>`+item.ngaySua+`</td>
                              <td class="chucNang">
                                <div class="hop-hanh-dong">
                                  <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_sinh_vien_sua', '`+ item.idSv +`', '`+ item.tenSv +`', '`+ item.emailSv +`', '`+ item.dobSv +`', '`+ item.genderSv +`', '`+ item.phoneSv +`', '`+ item.lopHanhChinhSv +`')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                  </button>
                                  <button onclick="hienXacNhanXoa('modal_xac_nhan_xoa', '`+ item.idSv +`')" class="xoa hop-hanh-dong-nut" type="button">
                                    <span class="xoa_tieuDe">Xóa</span>
                                    <i class="fa-solid fa-trash xoa_icon"></i>
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
function addSV() {
    const maSVInput = document.getElementById("ma-SV").value;
    const tenSVInput = document.getElementById("ten-SV").value;
    const emailSVInput = document.getElementById("email-SV").value;
    const gioiTinhSVInput = document.getElementById("gioi-tinh-SV").value;
    const sdtSVInput = document.getElementById("sdt-SV").value;
    const khoaSVInput = document.getElementById("ma-khoa-SV").value;
    console.log(maSVInput + ": " + tenSVInput);
    console.log(gioiTinhSVInput + " : " + khoaSVInput);
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/teacher/create-or-edit', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert("Thêm sinh viên " + maSVInput + " : " + tenSVInput + " thành công");
            hideModal('modal_sinh_vien');
            getAllSV();
        } else {
            console.log("Lấy thông tin sinh viên bị lỗi");
            jsonValue = jQuery.parseJSON(error.responseText);
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify({
        "idSV": maSVInput,
        "tenSV": tenSVInput,
        "sdtSV": sdtSVInput,
        "emailSV": emailSVInput,
        "genderSV": gioiTinhSVInput,
        "idKhoa": khoaSVInput,
    }));
}

// sửa (U)
function updateSV() {
    const maSVInput = document.getElementById("ma-SV-sua").value;
    const tenSVInput = document.getElementById("ten-SV-sua").value;
    const emailSVInput = document.getElementById("email-SV-sua").value;
    const gioiTinhSVInput = document.getElementById("gioi-tinh-SV-sua").value;
    const sdtSVInput = document.getElementById("sdt-SV-sua").value;
    const khoaSVInput = document.getElementById("ma-khoa-SV-sua").value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/api/admin/home/teacher/create-or-edit', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert("Sửa sinh viên " + maSVInput + " : " + tenSVInput + " thành công");
            hideModalSua('modal_sinh_vien_sua');
            getAllSV();
        } else {
            console.log("Lấy thông tin sinh viên bị lỗi");
            jsonValue = jQuery.parseJSON(error.responseText);
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify({
        "idSV": maSVInput,
        "tenSV": tenSVInput,
        "sdtSV": sdtSVInput,
        "emailSV": emailSVInput,
        "genderSV": gioiTinhSVInput,
        "idKhoa": khoaSVInput,
    }));
}

// xóa (D)
function deleteSV(el) {
    anXacNhanXoa('modal_xac_nhan_xoa');
    const id = el.getAttribute('data-id');
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'http://localhost:8080/api/home/teacher?id=' + id, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert("Xoá sinh viên " + id + " thành công");
            getAllSV();
        } else {
            alert("Không thể xóa sinh viên");
            console.log("Không thể xóa sinh viên");
        }
    };
    xhr.send();
}

// tìm kiếm
function timKiemSV() {
    tenSV = document.querySelector('.nhapTimKiem').value;
    pageIndex=0;
    formData = {
        "idSv": idSv,
        "tenSv": tenSv,
        "baseRequest": {
            "sortField": sortField,
            "sortOrder": sortOrder,
            "pageIndex": pageIndex,
            "pageSize": pageSize,
        }
    }
    readDataInit();
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
        "idSv": idSv,
        "tenSv": tenSv,
        "baseRequest": {
            "sortField": sortField,
            "sortOrder": sortOrder,
            "pageIndex": pageIndex,
            "pageSize": pageSize,
        }
    }
    getAllSV();
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
        "idSv": idSv,
        "tenSv": tenSv,
        "baseRequest": {
            "sortField": sortField,
            "sortOrder": sortOrder,
            "pageIndex": currentPage,
            "pageSize": pageSize,
        }
    }
    getAllSV();
}

// thêm sự kiện click vào nút trang trước (>) trang sau (<) ở phần phân trang
const prevBtn=document.querySelector(".nutPaginate.prev");
const nextBtn=document.querySelector(".nutPaginate.next");
prevBtn.addEventListener("click", () => {
    if (pageIndex > 1) {
        pageIndex--;
        formData = {
            "idSv": idSv,
            "tenSv": tenSv,
            "baseRequest": {
                "sortField": sortField,
                "sortOrder": sortOrder,
                "pageIndex": pageIndex,
                "pageSize": pageSize,
            }
        }
        createPaginationUI(totalPages, pageIndex)
        getAllSV();
    }
});

nextBtn.addEventListener("click", () => {
    if(pageIndex<totalPages) {
        pageIndex++;
        formData = {
            "idSv": idSv,
            "tenSv": tenSv,
            "baseRequest": {
                "sortField": sortField,
                "sortOrder": sortOrder,
                "pageIndex": pageIndex,
                "pageSize": pageSize,
            }
        }
        createPaginationUI(totalPages, pageIndex)
        getAllSV();
    }
});