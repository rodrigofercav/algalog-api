DROP TABLE public.clientes;

CREATE TABLE public.clientes
(
    id serial NOT NULL,
    nome character varying(255),
    email character varying(255),
    telefone character varying(20),
    PRIMARY KEY (id)
);
