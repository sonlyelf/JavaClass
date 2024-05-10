-- 刪除guestbook資料表
drop  table if exists guestbook;
-- 建立guestbook資料表
create table if not exists guestbook(
	id int auto_increment primary key,
    username varchar(50) not null,
    content varchar(255) not null,
    create_date timestamp default current_timestamp,
    update_date timestamp 
);