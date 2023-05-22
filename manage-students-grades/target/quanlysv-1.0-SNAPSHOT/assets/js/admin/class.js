function sortTable(n, event) {
    var thead=document.querySelector('thead');
    var tbody=document.querySelector('tbody');
    var bRows=[...tbody.rows]
    var hData=[...thead.querySelectorAll('th')]
    var desc=false;

    hData.map((head) => {
        if(head!=event) {
            head.classList.remove('asc', 'desc')
        }
    })

    desc=event.classList.contains('asc') ? true : false;
    event.classList[desc ? 'remove' : 'add']('asc')
    event.classList[desc ? 'add' : 'remove']('desc')

    bRows.sort((a, b) => {
        var x=a.getElementsByTagName('td')[n].innerText;
        var y=b.getElementsByTagName('td')[n].innerText;

        //Trường hợp sort ngày sinh
        if(n==3) {
            var a=x.split('/')
            var b=y.split('/')
            x=a[2]+a[1]+a[0]
            y=b[2]+b[1]+b[0]
        }

        if(desc) {
            return x<y ? -1 : 1;
        } else {
            return x>y ? -1 : 1;
        }
    });
    bRows.map((bRow) => {
        tbody.appendChild(bRow)
    })
}

function xoa_dau(str) {
    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, 'a')
    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, 'e')
    str = str.replace(/ì|í|ị|ỉ|ĩ/g, 'i')
    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, 'o')
    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, 'u')
    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, 'y')
    str = str.replace(/đ/g, 'd')
    str = str.replace(/À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ/g, 'A')
    str = str.replace(/È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ/g, 'E')
    str = str.replace(/Ì|Í|Ị|Ỉ|Ĩ/g, 'I')
    str = str.replace(/Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ/g, 'O')
    str = str.replace(/Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ/g, 'U')
    str = str.replace(/Ỳ|Ý|Ỵ|Ỷ|Ỹ/g, 'Y')
    str = str.replace(/Đ/g, 'D')
    return str
}

function sortName(event) {
    var thead=document.querySelector('thead');
    var tbody=document.querySelector('tbody');
    var bRows=[...tbody.rows]
    var hData=[...thead.querySelectorAll('th')]
    var desc=false;

    hData.map((head) => {
        if(head!=event) {
            head.classList.remove('asc', 'desc')
        }
    })

    desc=event.classList.contains('asc') ? true : false;
    event.classList[desc ? 'remove' : 'add']('asc')
    event.classList[desc ? 'add' : 'remove']('desc')

    bRows.sort((a, b) => {
        var x=a.getElementsByTagName('td')[1].innerText.toLowerCase();
        var y=b.getElementsByTagName('td')[1].innerText.toLowerCase();
        x=xoa_dau(x)
        y=xoa_dau(y)
        var a=x.split(' ')
        var b=y.split(' ')
        x=a[a.length-1] + ' ' + x
        y=b[b.length-1] + ' ' + y

        console.log(x)
        console.log(y)

        if(desc) {
            return x<y ? -1 : 1;
        } else {
            return x>y ? -1 : 1;
        }
    });
    bRows.map((bRow) => {
        tbody.appendChild(bRow)
    })
}
//Trích xuất tham số từ URL
const urlParams = new URLSearchParams(window.location.search);
const type = urlParams.get('type');

// Hiển thị thông tin tương ứng với loại lớp
const lopTieuDeChiTiet = document.getElementById('lop-tieuDe-chiTiet');
if (type === 'cb') {
    lopTieuDeChiTiet.textContent = ' Khoa Cơ bản';
} else if (type === 'dpt') {
    lopTieuDeChiTiet.textContent = ' Khoa Đa phương tiện';
} else if (type === 'cntt') {
    lopTieuDeChiTiet.textContent = ' Khoa Công nghệ thông tin';
} else if (type === 'attt') {
    lopTieuDeChiTiet.textContent = ' Khoa An toàn thông tin';
} else if (type === 'vt') {
    lopTieuDeChiTiet.textContent = ' Khoa Viễn thông 1';
} else if (type === 'dt') {
    lopTieuDeChiTiet.textContent = ' Khoa Điện tử';
} else if (type === 'qtkd') {
    lopTieuDeChiTiet.textContent = ' Khoa Quản trị kinh doanh';
}else if (type === 'kt') {
    lopTieuDeChiTiet.textContent = ' Khoa Tài chính - Kế toán';
}