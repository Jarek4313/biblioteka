create table if not exists publishing_house (
    id serial primary key,
    name varchar(100) not null
);

alter table book add column publishing_house_id int null;
alter table book add foreign key (publishing_house_id) references publishing_house (id);