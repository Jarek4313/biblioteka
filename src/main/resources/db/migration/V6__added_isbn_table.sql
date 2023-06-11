create table if not exists isbn_number (
    id serial primary key,
    isbn varchar(13) not null,
    book int not null,
    foreign key (book) references book (id)
);