create table if not exists accounts(
	id serial primary key,
    name text,
    email text,
    passport int,
    password text,
	amount_of_money int,
	amount_of_bitcoin numeric(7, 5)
);