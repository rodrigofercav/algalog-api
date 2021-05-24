create table public.clientes
(
    id serial not null,
    nome varchar(120),
    email varchar(255),
    telefone varchar(20),
    
    primary key (id)
);
