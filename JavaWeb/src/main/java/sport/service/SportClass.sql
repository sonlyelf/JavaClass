--  運動課程新增報名系統


drop table if exists booking_course;
drop table if exists sportclass;

-- 建立 sportclass
create table if not exists sportclass(
	sportclass_id int primary key,
    sportclass_name varchar(50) not null ,
    start_date DATE,
    end_date DATE
);

-- 建立 booking_course
create table if not exists booking_course(
	bookingcourse_id int auto_increment primary key,
    sportclass_id  int not null,
    sportclass_name varchar(50) not null ,
    user_name varchar(50) not null,
    create_time timestamp default current_timestamp,
    foreign key (sportclass_id ) references  sportclass (sportclass_id )

);


-- 建立預設資料
insert into sportclass (sportclass_id,   sportclass_name ,  start_date, end_date ) values (101, 'YogaClass','2024-06-01','2024-07-31');
insert into sportclass (sportclass_id,   sportclass_name ,  start_date, end_date ) values (202, 'ZumbaClass','2024-06-01','2024-07-31');
insert into sportclass (sportclass_id,   sportclass_name ,  start_date, end_date ) values (303, 'BoxingClass','2024-06-01','2024-07-31');
insert into sportclass (sportclass_id,   sportclass_name ,  start_date, end_date ) values (404, 'TRXClass','2024-06-01','2024-07-31');


insert into booking_course (sportclass_id,sportclass_name, user_name ) values (101,'YogaClass','Amy' );
insert into booking_course (sportclass_id, sportclass_name,user_name ) values (202,'ZumbaClass','Ban' );
insert into booking_course (sportclass_id,sportclass_name, user_name ) values (404,'TRXClass','Carrie');
insert into booking_course (sportclass_id,sportclass_name, user_name) values (202,'ZumbaClass','David' );
