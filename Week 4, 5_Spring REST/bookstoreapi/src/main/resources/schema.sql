create table if not exists book (
	id     bigint primary key,
	title  varchar(255),
	author varchar(255),
	price  double,
	isbn   varchar(255)
);

create table if not exists customer (
	id    bigint primary key,
	name  varchar(255),
	email varchar(255)
);