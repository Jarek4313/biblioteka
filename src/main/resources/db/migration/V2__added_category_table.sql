create table if not exists category (
    id serial primary key,
    name varchar(100) not null
);

alter table book add column category_id int null;
alter table book add foreign key (category_id) references category (id);