create table if not exists book {
    id serial primary key,
    title varchar(100) not null,
    quantity int
}