create table role
(
	id serial not null,
	description varchar(255) not null
)
;

create unique index role_id_uindex
	on role (id)
;

CREATE TABLE public.users
(
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	authorities VARCHAR(255) NOT NULL,
	account_non_expired BOOLEAN NOT NULL,
	account_non_locked BOOLEAN NOT NULL,
	credentials_non_expired BOOLEAN NOT NULL,
	enabled BOOLEAN NOT NULL
);
CREATE UNIQUE INDEX users_id_uindex ON public.users (id);
CREATE UNIQUE INDEX users_username_uindex ON public.users (username);
