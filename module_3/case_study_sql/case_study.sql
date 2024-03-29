create database furama;

use furama;

create table vi_tri (
	ma_vi_tri int primary key auto_increment,
    ten_vi_tri varchar(45)
);

create table trinh_do (
	ma_trinh_do int primary key auto_increment,
    ten_trinh_do varchar(45)
);

create table bo_phan (
	ma_bo_phan int primary key auto_increment,
    ten_bo_phan varchar(45)
);

create table nhan_vien (
	ma_nhan_vien int primary key auto_increment,
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    so_cmnd varchar(45) not null,
    luong double not null,
    so_dien_thoai varchar(45) not null,
    email varchar(45),
    dia_chi varchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table loai_khach (
	ma_loai_khach int primary key auto_increment,
    ten_loai_khach varchar(45)
);

create table khach_hang (
	ma_khach_hang int primary key auto_increment,
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    gioi_tinh bit(1) not null,
    so_cmnd varchar(45) not null,
    so_dien_thoai varchar(45) not null,
    email varchar(45),
    dia_chi varchar(45),
    ma_loai_khach int,
    foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table loai_dich_vu (
	ma_loai_dich_vu int primary key auto_increment,
    ten_loai_dich_vu varchar(45)
);

create table kieu_thue (
	ma_kieu_thue int primary key auto_increment,
    ten_kieu_thue varchar(45)
);

create table dich_vu (
	ma_dich_vu int primary key auto_increment,
    ten_dich_vu varchar(45) not null,
    dien_tich int,
    chi_phi_thue double not null,
    so_nguoi_toi_da int,
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    dich_vu_mien_phi_di_kem text,
    ma_kieu_thue int, foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
    ma_loai_dich_vu int, foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong (
	ma_hop_dong int primary key auto_increment,
    ngay_lam_hop_dong date not null,
    ngay_ket_thuc date not null,
    tien_dat_coc double not null,
    ma_nhan_vien int, foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    ma_khach_hang int, foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
    ma_dich_vu int, foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table dich_vu_di_kem (
	ma_dich_vu_di_kem int primary key auto_increment,
    ten_dich_vu_di_kem varchar(45),
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45)
);

create table hop_dong_chi_tiet (
	ma_hop_dong_chi_tiet int primary key auto_increment,
	so_luong int not null,
    ma_hop_dong int, foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
    ma_dich_vu_di_kem int, foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

insert into vi_tri value (1, "Quản Lý"), (2, "Nhân Viên");

insert into trinh_do (ten_trinh_do) value ("Trung Cấp"), ("Cao Đẳng"), ("Đại Học"), ("Sau Đại Học");

insert into bo_phan (ten_bo_phan) value ("Sale-Marketing"), ("Hành chính"), ("Phục vụ"), ("Quản lý");

insert into nhan_vien value 
(1,	"Nguyễn Văn An", "1970-11-07", "456231786", 10000000, "0901234121", "annguyen@gmail.com", "295 Nguyễn Tất Thành, Đà Nẵng", 1, 3, 1),
(2, "Lê Văn Bình", "1997-04-09", "654231234", 7000000, "0934212314", "binhlv@gmail.com", "22 Yên Bái, Đà Nẵng", 1, 2, 2),
(3, "Hồ Thị Yến", "1995-12-12", "999231723" , 14000000, "0412352315", "thiyen@gmail.com", "K234/11 Điện Biên Phủ, Gia Lai", 1, 3, 2),
(4, "Võ Công Toản", "1980-04-04", "123231365", 17000000, "0374443232", "toan0404@gmail.com", "77 Hoàng Diệu, Quảng Trị", 1, 4, 4),
(5, "Nguyễn Bỉnh Phát", "1999-12-09", "454363232", 6000000, "0902341231", "phatphat@gmail.com",	"43 Yên Bái, Đà Nẵng", 2, 1, 1),
(6, "Khúc Nguyễn An Nghi", "2000-11-08", "964542311", 7000000, "0978653213", "annghi20@gmail.com", "294 Nguyễn Tất Thành, Đà Nẵng", 2, 2, 3),
(7, "Nguyễn Hữu Hà", "1993-01-01", "534323231", 8000000, "0941234553" ,"nhh0101@gmail.com", "4 Nguyễn Chí Thanh, Huế", 2, 3, 2),
(8, "Nguyễn Hà Đông", "1989-09-03", "234414123", 9000000, "0642123111", "donghanguyen@gmail.com", "111 Hùng Vương, Hà Nội", 2, 4, 4),
(9, "Tòng Hoang", "1982-09-03", "256781231", 6000000, "0245144444", "hoangtong@gmail.com", "213 Hàm Nghi, Đà Nẵng", 2, 4, 4),
(10, "Nguyễn Công Đạo", "1994-01-08", "755434343", 8000000, "0988767111", "nguyencongdao12@gmail.com", "6 Hoà Khánh, Đồng Nai", 2, 3, 2);

select * from nhan_vien;

insert into loai_khach(ten_loai_khach) value ("Diamond"), ("Platinum"), ("Gold"), ("Silver"), ("Member");

insert into khach_hang value
(1, "Nguyễn Thị Hào", "1970-11-07", 0, "643431213", "0945423362", "thihao07@gmail.com", "23 Nguyễn Hoàng, Đà Nẵng", 5),
(2, "Phạm Xuân Diệu", "1992-08-08", 1, "865342123", "0954333333", "xuandieu92@gmail.com", "K77/22 Thái Phiên, Quảng Trị", 3),
(3, "Trương Đình Nghệ", "1990-02-27", 1, "488645199", "0373213122", "nghenhan2702@gmail.com", "K323/12 Ông Ích Khiêm, Vinh", 1),
(4, "Dương Văn Quan", "1981-07-08", 1, "543432111", "0490039241", "duongquan@gmail.com", "K453/12 Lê Lợi, Đà Nẵng", 1),
(5, "Hoàng Trần Nhi Nhi", "1995-12-09", 0, "795453345", "0312345678", "nhinhi123@gmail.com", "224 Lý Thái Tổ, Gia Lai", 4),
(6, "Tôn Nữ Mộc Châu",  "2005-12-06", 0, "732434215", "0988888844", "tonnuchau@gmail.com", "37 Yên Thế, Đà Nẵng", 4),
(7, "Nguyễn Mỹ Kim", "1984-04-08", 0, "856453123", "0912345698", "kimcuong84@gmail.com", "K123/45 Lê Lợi, Hồ Chí Minh", 1),
(8, "Nguyễn Thị Hào", "1999-04-08", 0, "965656433", "0763212345", "haohao99@gmail.com", "55 Nguyễn Văn Linh, Kon Tum", 3),
(9, "Trần Đại Danh", "1994-07-01", 1, "432341235", "0643343433", "danhhai99@gmail.com", "24 Lý Thường Kiệt, Quảng Ngãi", 1),
(10, "Nguyễn Tâm Đắc", "1989-07-01", 1, "344343432", "0987654321", "dactam@gmail.com",  "22 Ngô Quyền, Đà Nẵng", 2);

select * from khach_hang;

insert into kieu_thue(ten_kieu_thue) value ("year"), ("month"), ("day"), ("hour");

insert into loai_dich_vu(ten_loai_dich_vu) value ("Villa"), ("house"), ("Room");

insert into dich_vu value
(1, "Villa Beach Front", 25000, 1000000 ,10, "vip", "Có hồ bơi", 500, 4, null, 3, 1),
(2, "House Princess 01" , 14000, 5000000, 7, "vip", "Có thêm bếp nướng", null, 3, null, 2, 2),
(3, "Room Twin 01", 5000, 1000000, 2, "normal", "Có tivi", null, null, "1 Xe máy, 1 Xe đạp", 4, 3),
(4, "Villa No Beach Front", 22000, 9000000, 8, "normal", "Có hồ bơi", 300, 3, null, 3, 1),
(5, "House Princess 02", 10000, 4000000, 5, "normal", "Có thêm bếp nướng", null, 2, null, 3, 2),
(6, "Room Twin 02", 3000, 900000, 2, "normal", "Có tivi", null, null, "1 Xe máy", 4, 3);

select * from dich_vu;

insert into dich_vu_di_kem value
(1, "Karaoke", 10000, "giờ", "tiện nghi, hiện tại"),
(2, "Thuê xe máy", 10000, "chiếc", "hỏng 1 xe"),
(3, "Thuê xe đạp", 20000, "chiếc", "tốt"),
(4, "Buffet buổi sáng", 15000, "suất", "đầy đủ đồ ăn, tráng miệng"),
(5, "Buffet buổi trưa", 90000, "suất", "đầy đủ đồ ăn, tráng miệng"),
(6, "Buffet buổi tối", 16000, "suất", "đầy đủ đồ ăn, tráng miệng");

insert into hop_dong value
(1, "2020-12-08", "2020-12-08", 0, 3, 1, 3),
(2, "2020-07-14", "2020-07-21", 200000, 7, 3, 1),
(3, "2021-03-15", "2021-03-17", 50000, 3, 4, 2),
(4, "2021-01-14", "2021-01-18", 100000, 7, 5, 5),
(5, "2021-07-14", "2021-07-15", 0, 7, 2, 6),
(6, "2021-06-01", "2021-06-03", 0, 7, 7, 6),
(7, "2021-09-02", "2021-09-05", 100000, 7, 4, 4),
(8, "2021-06-17", "2021-06-18", 150000, 3, 4, 1),
(9, "2020-11-19", "2020-11-1", 0, 3, 4, 3),
(10, "2021-04-12", "2021-04-14", 0, 10, 3, 5),
(11, "2021-04-25", "2021-04-25", 0, 2, 2, 1),
(12, "2021-05-25", "2021-05-27", 0, 7, 10, 1);

insert into hop_dong_chi_tiet value
(1, 5, 2, 4),
(2, 8, 2, 5),
(3, 15, 2, 6),
(4, 1, 3, 1),
(5, 11, 3, 2),
(6, 1, 1, 3),
(7, 2, 1, 2),
(8, 2, 12, 2);

-- bài 2
select ma_nhan_vien, ho_ten from nhan_vien where substring_index(ho_ten, ' ', -1) regexp '^[HTK]' and char_length(ho_ten) <= 15;

-- bài 3
select ma_khach_hang, ho_ten, ngay_sinh, dia_chi 
from khach_hang 
where 
dia_chi regexp '(Đà Nẵng)|(Quảng Trị)' 
and 
((year(curdate()) - year(ngay_sinh)) - (right(curdate(), 5) < right(ngay_sinh, 5))) >= 18 
and
((year(curdate()) - year(ngay_sinh)) - (right(curdate(), 5) < right(ngay_sinh, 5))) <= 50;

-- bài 4
select hop_dong.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong
from hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where
loai_khach.ten_loai_khach = "Diamond"
group by ma_khach_hang
order by so_lan_dat_phong;

-- bài 5
set sql_mode = 0;
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, 
dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
ifnull(ifnull(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong , 0) + dich_vu.chi_phi_thue, 0) as tong_tien
from khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong, hop_dong.ma_khach_hang
order by khach_hang.ma_khach_hang;

-- bài 6
select distinct dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where hop_dong.ma_dich_vu not in 
(
select distinct hop_dong.ma_dich_vu 
from hop_dong 
where year(ngay_lam_hop_dong) = 2021 and month(ngay_lam_hop_dong) in (1, 2, 3)
)
order by ten_loai_dich_vu;

-- bài 7
select distinct dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(ngay_lam_hop_dong) = 2020 and hop_dong.ma_dich_vu not in (
select distinct hop_dong.ma_dich_vu 
from hop_dong 
where year(ngay_lam_hop_dong) = 2021);

-- bài 8
select distinct ho_ten
from khach_hang;

select ho_ten
from khach_hang
group by ho_ten;

select ho_ten
from khach_hang
group by ho_ten
having count(*) = 1;


-- bài 9
select month(hop_dong.ngay_lam_hop_dong) as thang, count(hop_dong.ma_khach_hang) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- bai 10
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, ifnull(sum(hop_dong_chi_tiet.so_luong), 0) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by ma_hop_dong
order by ma_hop_dong;

-- bai 11
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = "Diamond" and khach_hang.dia_chi regexp "(Vinh)|(Quảng Ngãi)";

-- bài 12
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, ifnull(sum(hop_dong_chi_tiet.so_luong), 0) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc
from dich_vu
left join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where hop_dong.ma_hop_dong in (
select hop_dong.ma_hop_dong 
from hop_dong 
where year(ngay_lam_hop_dong) = 2020 and month(ngay_lam_hop_dong) in (10, 11, 12))
and hop_dong.ma_hop_dong not in (
select hop_dong.ma_hop_dong 
from hop_dong 
where year(ngay_lam_hop_dong) = 2021 and month(ngay_lam_hop_dong) in (1, 2, 3, 4, 5, 6))
group by ma_hop_dong;

-- bài 13
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by ma_dich_vu_di_kem having so_luong_dich_vu_di_kem = (
select max(hop_dong_chi_tiet.so_luong) from hop_dong_chi_tiet)
order by so_luong_dich_vu_di_kem desc;

-- bài 14
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_lan_su_dung
from dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by ten_dich_vu_di_kem having so_lan_su_dung = 1
order by ma_hop_dong;

-- bài 15
select nhan_vien.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by ma_nhan_vien having count(hop_dong.ma_nhan_vien) <= 3
order by ma_nhan_vien;

-- bài 16
select nhan_vien.ma_nhan_vien, ho_ten, count(hop_dong.ma_nhan_vien) as so_lan_lam_hop_dong
from nhan_vien
left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by ma_nhan_vien having so_lan_lam_hop_dong = 0
order by so_lan_lam_hop_dong;

select *
from nhan_vien;

alter table nhan_vien
add column is_delete bit(1) not null default 0; 

set SQL_SAFE_UPDATES = 0;
update nhan_vien
set is_delete = 1
where ma_nhan_vien not in (select distinct ma_nhan_vien
from hop_dong
where ma_nhan_vien = hop_dong.ma_nhan_vien);
set SQL_SAFE_UPDATES = 1;

select *
from nhan_vien
where is_delete = 1;

-- bài 17
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong + dich_vu.chi_phi_thue) as tong_tien
from khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong) = 2021 and ten_loai_khach = "Platinum" and (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong + dich_vu.chi_phi_thue) > 1000000;

set SQL_SAFE_UPDATES = 0;
update khach_hang
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_khach_hang = (
select khach_hang.ma_khach_hang
from loai_khach
where year(ngay_lam_hop_dong) = 2021 and ten_loai_khach = "Platinum" and (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong + dich_vu.chi_phi_thue) > 1000000);
set SQL_SAFE_UPDATES = 1;

-- bài 18
select khach_hang.ma_khach_hang
from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(ngay_lam_hop_dong) = 2020;

alter table khach_hang
add column is_delete bit(1) not null default 0; 

set SQL_SAFE_UPDATES = 0;
update khach_hang
set is_delete = 1
where khach_hang.ma_khach_hang in (
select hop_dong.ma_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2020);
set SQL_SAFE_UPDATES = 1;

select *
from khach_hang
where is_delete = 1;

-- alter table hop_dong
-- drop constraint hop_dong_ibfk_2;

-- set SQL_SAFE_UPDATES = 0;
-- delete from khach_hang
-- where khach_hang.ma_khach_hang in (select hop_dong.ma_khach_hang
-- from hop_dong
-- where year(ngay_lam_hop_dong) = 2020);
-- set SQL_SAFE_UPDATES = 1;

-- set FOREIGN_KEY_CHECKS = 0;
-- alter table hop_dong
-- add constraint hop_dong_ibfk_2
-- foreign key (ma_khach_hang)
-- references khach_hang (ma_khach_hang)
-- on delete no action
-- on update no action;
-- set FOREIGN_KEY_CHECKS = 1;


-- bài 19
with so_lan_su_dung as (
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, hop_dong.ngay_lam_hop_dong, hop_dong_chi_tiet.so_luong as so_lan_su_dung
from hop_dong
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2020 and hop_dong_chi_tiet.so_luong > 10
)

update dich_vu_di_kem
set gia = gia * 2
where ma_dich_vu_di_kem = (select ma_dich_vu_di_kem from so_lan_su_dung);

-- bài 20
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;

-- bài 21

create view v_nhan_vien as
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.dia_chi
from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where dia_chi regexp 'Hà Tĩnh' and date(hop_dong.ngay_lam_hop_dong) = "2021-04-25";


drop view v_nhan_vien;

select * from v_nhan_vien;

-- bài 22
update v_nhan_vien
set dia_chi = replace(dia_chi, 'Hà Tĩnh', 'Đà Nẵng');

-- bài 23
delimiter //
create procedure sp_xoa_khach_hang (in id_cus int)
begin
update khach_hang
set is_delete = 1
where ma_khach_hang = id_cus;
end 
// delimiter ;

delimiter //
create procedure sp_backup_khach_hang (in id_cus int)
begin
update khach_hang
set is_delete = 0
where ma_khach_hang = id_cus;
end 
// delimiter ;

set SQL_SAFE_UPDATES = 0;
call sp_xoa_khach_hang(2);
call sp_backup_khach_hang(2);
set SQL_SAFE_UPDATES = 1;

-- bài 24
delimiter //
create procedure sp_them_moi_hop_dong (
in ma_hop_dong int ,
in ngay_lam_hop_dong date,
in ngay_ket_thuc date,
in tien_dat_coc double,
in ma_nhan_vien int,
in ma_khach_hang int,
in ma_dich_vu int)
begin
declare is_valid int default 1;

if exists (
select 1
from hop_dong where ma_hop_dong = ma_hop_dong)
then 
set is_valid = 0;

elseif (
select 1
from nhan_vien where ma_nhan_vien = ma_nhan_vien)
then 
set is_valid = 0;

elseif (
select 1
from khach_hang where ma_khach_hang = ma_khach_hang)
then 
set is_valid = 0;

elseif (
select 1
from dich_vu where ma_dich_vu = ma_dich_vu)
then 
set is_valid = 0;

elseif 
ngay_lam_hop_dong is null or
ngay_ket_thuc is null or
tien_dat_coc is null
then
set is_valid = 0;
end if;

if is_valid = 1 then
insert into hop_dong value (ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu);
end if;
end
// delimiter ;

call sp_them_moi_hop_dong(20, '2023-12-12', '2023-12-14', 100, 3, 1, 3);

-- bài 25
alter table hop_dong
add column is_delete bit(1) not null default 0; 

delimiter //
create trigger tr_xoa_hop_dong
after update on hop_dong
for each row
begin
declare total_rows int;
select count(*) into total_rows from hop_dong where is_delete = 0;
insert into log (message) values (concat('tổng số lượng bản ghi còn lại trong bảng hop_dong: ', total_rows));
end
// delimiter ;

create table log (
id int auto_increment primary key,
message varchar(255),
created_at timestamp default current_timestamp
);

drop trigger tr_xoa_hop_dong;

select * from log;

update hop_dong
set is_delete = 0
where ma_hop_dong = 1;

-- bài 26
delimiter //
create trigger tr_cap_nhat_hop_dong
before update on hop_dong
for each row
begin
    declare ngay_lam date;
    declare ngay_ket_thuc date;
    
    set ngay_lam = old.ngay_lam_hop_dong;
    set ngay_ket_thuc = new.ngay_ket_thuc;
    
    if datediff(ngay_ket_thuc, ngay_lam) < 2 then
        signal sqlstate '45000' set message_text = 'ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
	else
		set new.ngay_ket_thuc = ngay_ket_thuc;
    end if;
end //
delimiter ;

drop trigger tr_cap_nhat_hop_dong;

update hop_dong
set ngay_ket_thuc = "2020-12-10"
where ma_hop_dong = 1;

select * from log;

-- bài 27
-- a
delimiter //
create function func_dem_dich_vu() returns int
deterministic
reads sql data
begin
declare count_result int;
    
select count(distinct ma_dich_vu) into count_result
from hop_dong
where ma_dich_vu in (
select count(*)
from dich_vu
inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
group by dich_vu.ma_dich_vu
having sum(dich_vu.chi_phi_thue) > 2000000);

return count_result;
end //
delimiter ;

drop function func_dem_dich_vu;

select func_dem_dich_vu();

-- b
delimiter //
create function func_tinh_thoi_gian_hop_dong(ma_khach_hang int) returns int
begin
declare max_duration int;
select max(datediff(ngay_ket_thuc, ngay_lam_hop_dong)) into max_duration
from hop_dong
where hop_dong.ma_khach_hang = ma_khach_hang;
return max_duration;
end //
delimiter ;

drop function func_tinh_thoi_gian_hop_dong;

select func_tinh_thoi_gian_hop_dong(3);

-- bài 28

alter table dich_vu
add column is_delete bit(1) not null default 0; 


DELIMITER //
CREATE PROCEDURE sp_xoa_dich_vu_va_hd_room()
BEGIN
    CREATE TEMPORARY TABLE temp_ma_dich_vu
    SELECT dich_vu.ma_dich_vu
    FROM dich_vu
    join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
    WHERE YEAR(hop_dong.ngay_lam_hop_dong) >= 2015 AND YEAR(hop_dong.ngay_lam_hop_dong) <= 2019 AND dich_vu.ma_loai_dich_vu = (
        SELECT ma_loai_dich_vu FROM loai_dich_vu WHERE ten_loai_dich_vu = 'Room'
    );

    UPDATE dich_vu
    SET is_delete = 1
    WHERE ma_dich_vu IN (SELECT ma_dich_vu FROM temp_ma_dich_vu);

    UPDATE hop_dong
    SET is_delete = 1
    WHERE ma_dich_vu IN (SELECT ma_dich_vu FROM temp_ma_dich_vu);

    DROP TEMPORARY TABLE IF EXISTS temp_ma_dich_vu;
END //
DELIMITER ;

drop procedure sp_xoa_dich_vu_va_hd_room;

call sp_xoa_dich_vu_va_hd_room;

set SQL_SAFE_UPDATES = 1;























