create schema if not exists auth;

create table auth.auth_user (
                                id uuid primary key,
                                email varchar(255) not null unique,
                                password_hash varchar(255) not null,
                                enabled boolean not null default true,
                                created_at timestamptz not null default now(),
                                updated_at timestamptz not null default now()
);