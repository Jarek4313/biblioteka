create table if not exists author (
    id serial primary key,
    name varchar(100) not null,
    last_name varchar(100) not null

);

alter table book add column author_id int null;
alter table book add foreign key (author_id) references author (id);