create table public.ocorrencias (
	id serial not null,
	entrega_id integer not null,
	descricao text not null,
	data_registro timestamp not null,
	
	primary key (id)
);

alter table ocorrencias add constraint fk_ocorrencia_entrega foreign key (entrega_id) references entregas (id);
