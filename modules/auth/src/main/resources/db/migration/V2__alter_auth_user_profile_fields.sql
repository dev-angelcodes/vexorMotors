alter table auth.auth_user
    add column if not exists first_name varchar(100) not null default '',
    add column if not exists last_name  varchar(200) not null default '',
    add column if not exists role       varchar(20)  not null default 'CUSTOMER';
