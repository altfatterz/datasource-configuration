create table page (id bigint not null auto_increment, name varchar(255), portal_id bigint, primary key (id));
create table portal (id bigint not null auto_increment, name varchar(255), primary key (id));
alter table page add constraint FK_portal foreign key (portal_id) references portal (id);

insert into portal (id, name) values (1, 'ABN AMRO Retail Banking');
insert into page (id, name, portal_id) values (1, 'login', 1);
insert into page (id, name, portal_id) values (2, 'accounts', 1);
insert into page (id, name, portal_id) values (3, 'profile', 1);

