-- create sequence for clients.id
create sequence clientgenerator
START WITH 11;

-- create sequence for ticket.id
create sequence ticketgenerator
START WITH 6;

-- create table clients
create table clients (
                         id bigint not null default nextval('clientgenerator'),
                         name VARCHAR(200) not null,
                         primary key (id)
);

-- create table planet
create table planet (
                        id varchar(255) not null,
                        name VARCHAR(500) not null,
                        primary key (id)
);

-- create table ticket
create table ticket (
                        id bigint not null default nextval('ticketgenerator'),
                        created_at timestamp(6) not null,
                        client_id bigint not null,
                        from_planet_id varchar(255),
                        to_planet_id varchar(255)
);

-- add foreign key constraints
alter table ticket
    add constraint FKp9bw2snm3kea0aonl780n4jkj
        foreign key (client_id) references clients;

alter table ticket
    add constraint FKqb9pa0i6sgniuiowpxlhdm7bs
        foreign key (from_planet_id) references planet;

alter table ticket
    add constraint FKi29bydothdv5lli22etnqx8vh
        foreign key (to_planet_id) references planet;