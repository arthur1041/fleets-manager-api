insert into pilot(id, birth_date, credits, location_planet, name, pilot_certification) values (1, '2008-06-29', 1000, 'demeter', 'John', '0000000');
insert into pilot(id, birth_date, credits, location_planet, name, pilot_certification) values (2, '2002-05-27', 1000, 'demeter', 'Linda', '0000000');
insert into pilot(id, birth_date, credits, location_planet, name, pilot_certification) values (3, '2002-04-26', 1000, 'aqua', 'Mary', '0000000');
insert into pilot(id, birth_date, credits, location_planet, name, pilot_certification) values (4, '2002-04-26', 1000, 'andvari', 'Michael', '0000000');
insert into pilot(id, birth_date, credits, location_planet, name, pilot_certification) values (5, '2002-04-26', 1000, 'aqua', 'Richard', '0000000');


insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (1, 100, 70, 100, 1);
insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (2, 17000, 15000, 1000, 2);
insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (3, 200, 80, 100, 3);

insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (4, 150, 5, 100, 5);
insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (5, 200, 5, 100, 5);

insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (1, 'Regular travel', 'aqua', 'demeter', 100000, 2, false, false);
insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (2, 'A very important travel', 'andvari', 'calas', 100000, 1, false, false);

insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (3, 'A very important travel', 'demeter', 'aqua', 100000, 1, false, false);

insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (4, 'A very important travel', 'aqua', 'demeter', 100000, 2, true, true);
insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (5, 'A very important travel', 'demeter', 'calas', 100000, 2, true, true);
insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (6, 'A very important travel', 'calas', 'aqua', 100000, 2, true, true);
insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (7, 'A very important travel', 'andvari', 'calas', 100000, 2, true, true);
insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, accepted, accomplished) values (8, 'A very important travel', 'calas', 'andvari', 100000, 2, true, true);

insert into resource(id, name, weight, contract_id) values (1, 'MINERALS', 10, 1);
insert into resource(id, name, weight, contract_id) values (2, 'FOOD', 100, 1);
insert into resource(id, name, weight, contract_id) values (3, 'WATER', 50, 2);
insert into resource(id, name, weight, contract_id) values (4, 'MINERALS', 5, 1);
insert into resource(id, name, weight, contract_id) values (5, 'FOOD', 9, 1);
insert into resource(id, name, weight, contract_id) values (6, 'WATER', 15, 2);
insert into resource(id, name, weight, contract_id) values (7, 'MINERALS', 25, 1);
insert into resource(id, name, weight, contract_id) values (8, 'FOOD', 30, 1);
insert into resource(id, name, weight, contract_id) values (9, 'WATER', 42, 2);


insert into resource(id, name, weight, contract_id) values (10, 'FOOD', 9, 4);
insert into resource(id, name, weight, contract_id) values (11, 'WATER', 15, 5);
insert into resource(id, name, weight, contract_id) values (12, 'MINERALS', 25, 6);
insert into resource(id, name, weight, contract_id) values (13, 'FOOD', 30, 7);
insert into resource(id, name, weight, contract_id) values (14, 'WATER', 42, 8);
insert into resource(id, name, weight, contract_id) values (15, 'MINERALS', 25, 7);
insert into resource(id, name, weight, contract_id) values (16, 'FOOD', 30, 8);
insert into resource(id, name, weight, contract_id) values (17, 'WATER', 42, 7);


INSERT INTO transaction (id, transaction_description,value) VALUES (1, 'John bought fuel',560);
INSERT INTO transaction (id, transaction_description,value) VALUES (2, 'John bought fuel',350);
INSERT INTO transaction (id, transaction_description,value) VALUES (3, 'Linda bought fuel',350);
INSERT INTO transaction (id, transaction_description,value) VALUES (4, 'Linda bought fuel',350);
INSERT INTO transaction (id, transaction_description,value) VALUES (5, 'Linda bought fuel',210);
	