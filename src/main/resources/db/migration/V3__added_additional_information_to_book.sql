alter table book
    add column if not exists page_number int not null,
    add column if not exists publication_year int not null;

alter table book
    alter column page_number set default 0,
    alter column publication_year set default 0;