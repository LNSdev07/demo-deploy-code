--drop database quanlysinhvien
-- create database quanlysinhvien

-- use quanlysinhvien

create table THANHPHAN
(
    id_tp varchar(25) not null,
    id_diem varchar(25),
    chuyen_can int,
    bai_tap int,
    thi int,
    kiem_tra int,
    ngay_tao bigint,
    ngay_sua bigint
);

alter table THANHPHAN add  primary key(id_tp);

create table MONHOC
(
    id_mh varchar(25) not null,
    ten_mon_hoc varchar(100),
    tin_chi int,
    id_khoa varchar(25),
    trang_thai int,
    ngay_tao bigint,
    ngay_sua bigint
);

alter table MONHOC add primary key(id_mh);

create table HOCKY
(
    id_hk varchar(25) not null,
    ten_hoc_ky varchar(100),
    ngay_tao bigint,
    ngay_sua bigint
);
alter table HOCKY add primary key(id_hk);

create table DIEM
(
    id_diem varchar(25) not null,
    diem_cc float,
    diem_bt float,
    diem_thi float,
    diem_kt float,
    id_gv varchar(25),
    id_mh varchar(25),
    id_sv varchar(25) not null,
    id_hk varchar(25),
    ngay_tao bigint,
    ngay_sua bigint,
    PRIMARY KEY(id_diem,id_sv)
);
-- alter table DIEM add primary key(id_sv);

create table SINHVIEN
(
    id_sv varchar(25) not null,
    ten_sv varchar(50),
    email_sv varchar(80),
    dob_sv varchar(20),
    gender_sv varchar(20),
    phone_sv varchar(14),
    lop_hanh_chinh_sv varchar(50),
    trang_thai int,
    ngay_tao bigint,
    ngay_sua bigint
);
alter table SINHVIEN add primary key(id_sv);

create table LOP
(
    id_lop varchar(25) not null,
    ten_lop varchar(20),
    id_khoa varchar(25),
    ngay_tao bigint,
    ngay_sua bigint
);
alter table LOP add primary key(id_lop);

create table HOC
(
    id_sv varchar(25),
    id_lop varchar(25),
    ngay_tao bigint,
    ngay_sua bigint
);

create table KHOA
(
    id_khoa varchar(25) not null,
    ten_khoa varchar(26),
    ngay_tao bigint,
    ngay_sua bigint
);
alter table KHOA add primary key(id_khoa);

create table GIANGVIEN
(
    id_gv varchar(25) not null,
    ten_gv varchar(50),
    sdt_gv varchar(14),
    email_gv varchar(50),
    gender_gv varchar(20),
    id_khoa varchar(25),
    trang_thai int,
    ngay_tao bigint,
    ngay_sua bigint
);
alter table GIANGVIEN add primary key(id_gv);

create table DAYHOC
(
    id_gv varchar(25),
    id_mh varchar(25),
    ngay_tao bigint,
    ngay_sua bigint
);

create table taikhoan
(
    id bigint primary key,
    username varchar(50),
    password varchar(200),
    email varchar(100),
    status_password_default int not null ,
    role_id bigint
);

create table roles
(
    id bigint primary key ,
    role_name varchar(30)
);

alter table taikhoan add foreign key(role_id) references roles(id);

alter table DAYHOC add foreign key(id_gv) references GIANGVIEN(id_gv);
alter table DAYHOC add foreign key(id_mh) references MONHOC(id_mh);
alter table GIANGVIEN add foreign key(id_khoa) references KHOA(id_khoa);
alter table MONHOC add foreign key(id_khoa) references KHOA(id_khoa);
alter table DIEM add foreign key(id_gv) references GIANGVIEN(id_gv);
alter table DIEM add foreign key(id_mh) references MONHOC(id_mh);
alter table DIEM add foreign key(id_sv) references SINHVIEN(id_sv);
alter table DIEM add foreign key(id_hk) references HOCKY(id_hk);
alter table HOC add foreign key(id_sv) references SINHVIEN(id_sv);
alter table HOC add foreign key(id_lop) references LOP(id_lop);
alter table LOP add foreign key(id_khoa) references KHOA(id_khoa);
-- alter table THANHPHAN add foreign key(id_diem) references DIEM(id_diem)