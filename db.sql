create database  if not exists nkonoha;
use nkonoha;

create table if not exists bdventa(
id_venta int not null auto_increment primary key,
producto varchar (100),
monto_venta decimal (18,2)
 )engine InnoDB;
 
 create table if not exists bdencargado(
 id_encargado int not null auto_increment primary key,
 nombre_empleado varchar (50),
 id_venta int not null,
 constraint fk_bdventa foreign key (id_venta) references bdventa (id_venta) on delete cascade on update cascade
)engine InnoDB;

create table if not exists bdtienda(
id_tienda int not null primary key auto_increment,
nombre_tienda varchar(100),
region varchar(50),
giro_comercial varchar (100),
turno varchar(50),
id_encargado int not null,
constraint fk_bdencargado foreign key (id_encargado) references bdencargado (id_encargado) on delete cascade on update cascade
)engine InnoDB;

create table if not exists registro(
id_registro int not null primary key auto_increment,
id_tienda int not null,
constraint fk_bdtienda foreign key (id_tienda) references bdtienda (id_tienda) on delete cascade on update cascade
)engine InnoDB;

insert into bdventa (producto,monto_venta) value ('shuriken','200.45'),('kunai','100.00'),('kunai_hiraishin','500.00'),('mascara','100.00'),('katana','550.00');
insert into bdencargado (nombre_empleado,id_venta) value ('Hinata',5),('Kamus',2),('Sasha',1),('Kurenai',3),('Atem',4);
insert into bdtienda (nombre_tienda,region,giro_comercial,turno,id_encargado) value ('kumogakure','centro','ventas','vespertino',2),('hirigakure','orienete','servicios','matutino',3),('sunagakure','occidente','call center','nocturno',1),('konoha','centeo','otros','nocturno',5),('iwagakure','oriente','ventas','matutino',4);
insert into registro (id_tienda) value (1),(3),(5),(4),(2);

select  r.id_registro,t.nombre_tienda,t.region,t.giro_comercial,t.turno,e.nombre_empleado,v.producto,v.monto_venta from registro r 
inner join bdtienda t on r.id_tienda = t.id_tienda
inner join bdencargado e on e.id_encargado = t.id_encargado
inner join bdventa v on v.id_venta = e.id_venta;

delete from registro  where id_registro ='1'
