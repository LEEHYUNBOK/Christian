use christian;

insert into member(member_id, password, name, class_name) values ('admin', '1234','test', 'test');
insert into member_roles(member_member_id, roles) values ('admin', 'ADMIN');