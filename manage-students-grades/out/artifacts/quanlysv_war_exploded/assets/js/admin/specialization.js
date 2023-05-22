
const buyBtns = document.querySelectorAll('.js-xemthem')
const phanlop =document.querySelector('.js-phanlop')
const phanlopContainer = document.querySelector('.js-phanlop-container')
const phanlopClose = document.querySelector('.js-phanlop-close')
//hàm hiển thị phanlop mua vé
function showlop(){
    phanlop.classList.add('open')
}
//hàm ẩn phanlop mua vé(gỡ bỏ class)
function hidelop(){
    phanlop.classList.remove('open')
}
//lặp qua từng thẻ button và nghe hành vi click
for(const buyBtn of buyBtns){
    buyBtn.addEventListener('click', showlop)
}
//nghe hành vi click vào button
phanlopClose.addEventListener('click', hidelop)

phanlop.addEventListener('click',hidelop)
phanlopContainer.addEventListener('click', function (event) {
    event.stopPropagation();
})