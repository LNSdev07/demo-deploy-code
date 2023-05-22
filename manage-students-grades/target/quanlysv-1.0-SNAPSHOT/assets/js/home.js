
const box1 = document.querySelector('.f1');
const box2 = document.querySelector('.f2');
const box3 = document.querySelector('.f3');
const box4 = document.querySelector('.f4');

const box5 = document.querySelector('.i1');
const box6 = document.querySelector('.i2');
const box7 = document.querySelector('.i3');
const box8 = document.querySelector('.i4');

box1.addEventListener('mouseover', () => {
    box5.classList.add('move');
});

box1.addEventListener('mouseout', () => {
    box5.classList.remove('move');
});

box2.addEventListener('mouseover', () => {
    box6.classList.add('move');
});

box2.addEventListener('mouseout', () => {
    box6.classList.remove('move');
});
box3.addEventListener('mouseover', () => {
    box7.classList.add('move');
});

box3.addEventListener('mouseout', () => {
    box7.classList.remove('move');
});
box4.addEventListener('mouseover', () => {
    box8.classList.add('move');
});

box4.addEventListener('mouseout', () => {
    box8.classList.remove('move');
});
