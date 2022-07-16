create table if not exists accounts
(
    id
    serial
    primary
    key,
    name
    text,
    surname
    text,
    email
    text,
    password
    text,
    amount_of_money
    int,
    amount_of_bitcoin
    numeric
(
    7,
    5
)
    );

create table if not exists role
(
    id
    serial
    primary
    key,
    name
    text
);

create table if not exists accounts_roles
(
    id
    serial
    primary
    key,
    account_id
    int
    references
    accounts
(
    id
),
    role_id int references role
(
    id
)
    );


