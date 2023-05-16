use christian;

insert into member(email, password, name) values ('admin', '1234', 'test');
insert into member_roles(member_id, roles) values (1, 'ADMIN');

insert into class_type(name, teacher) values ('test1', 1);
insert into class_type(name, teacher) values ('test2', 1);

insert into student(name, age, memo, photo, sex, class_id) values ('test1', '12', 'etst', 'none', 'male', 1);
insert into student(name, age, memo, photo, sex, class_id) values ('test2', '12', '22etst', 'none', 'male', 1);
insert into student(name, age, memo, photo, sex, class_id) values ('test3', '12', 'etst', 'none', 'male', 2);
insert into student(name, age, memo, photo, sex, class_id) values ('test4', '12', 'etst', 'none', 'male', 2);