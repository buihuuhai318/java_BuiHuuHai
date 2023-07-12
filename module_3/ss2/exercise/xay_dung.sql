create database xay_dung;

use xay_dung;



create table nha_cung_cap (
	ma_nha_cung_cap		int primary key	auto_increment,
    ten_nha_cung_cap	varchar(50) not null,
    dia_chi				varchar(50)
);

create table phone_numbers (
	phone				varchar(20) primary key,
    ma_nha_cung_cap		int,
    foreign key			(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table vat_tu (
	ma_vat_tu			int	primary key auto_increment,
    ten_vat_tu			varchar(50)	not null
);

create table phieu_nhap (
	so_phieu_nhap		int	primary key auto_increment,
    ngay_xuat			date not null
);

create table phieu_xuat	(
	so_phieu_xuat		int	primary key auto_increment,
    ngay_nhap			date not null
);

create table chi_tiet_phieu_xuat (
	so_phieu_xuat		int,
    ma_vat_tu			int,
    primary key (so_phieu_xuat, ma_vat_tu),
    don_gia_xuat		int not null,
    foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
    so_luong_xuat		int not null
);

create table chi_tiet_phieu_nhap (
	so_phieu_nhap		int,
    ma_vat_tu			int,
    primary key (so_phieu_nhap, ma_vat_tu),
    foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
    don_gia_nhap		int not null,
    so_luong_nhap		int not null
);

create table don_hang (
	so_don_hang			int primary key auto_increment,
    ngay_dat_hang		date,
    ma_nha_cung_cap		int,
    foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table chi_tiet_don_hang (
	so_don_hang			int,
    ma_vat_tu			int,
    primary key (so_don_hang, ma_vat_tu),
    foreign key (so_don_hang) references don_hang(so_don_hang),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
    so_luong			int
);
















