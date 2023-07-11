create database quan_ly_diem_thi;

use quan_ly_diem_thi;

create table hoc_sinh (
	id_hs varchar(20) primary key,
    ten_hs varchar(60),
    ngay_sinh_hs date,
    lop varchar(20),
    gioi_tinh varchar(20)
);

create table mon_hoc (
	id_mh varchar(20) primary key,
    ten_mh varchar(50)
);

create table bang_diem (
	id_hs varchar(20), foreign key(id_hs) references hoc_sinh(id_hs),
    id_mh varchar(20), foreign key(id_mh) references mon_hoc(id_mh),
    diem_thi int,
    ngay_kt date,
    primary key (id_hs, id_mh)
);

create table giao_vien (
	id_gv varchar(20) primary key,
    ten_gv varchar(50),
    sdt varchar(10)
);

alter table mon_hoc add id_gv varchar(20);
alter table mon_hoc add constraint pk_id_gv foreign key (id_gv) references giao_vien(id_gv);