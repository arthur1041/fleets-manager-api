insert into pilot(id, age, credits, location_planet, name, pilot_certification) values (1, '2002-06-29', 1000, 'Demeter', 'John', '0000000');
insert into pilot(id, age, credits, location_planet, name, pilot_certification) values (2, '2002-05-27', 1000, 'Demeter', 'Linda', '0000000');
insert into pilot(id, age, credits, location_planet, name, pilot_certification) values (3, '2002-04-26', 1000, 'Aqua', 'Mary', '0000000');


insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (1, 100, 70, 100, 1);
insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (2, 150, 50, 100, 2);
insert into ship(id, fuel_capacity, fuel_level, weight_capacity, pilot_id) values (3, 200, 80, 100, 3);

insert into resource(id, name, weight, contract_id) values (1, 'MINERALS', 10, null);
insert into resource(id, name, weight, contract_id) values (2, 'FOOD', 10, null);
insert into resource(id, name, weight, contract_id) values (3, 'WATER', 10, null);

insert into contract(id, description, destination_planet, origin_planet, value, pilot_id, ship_id) values (1, 'Test', 'Aqua', 'Demeter', 100000, 1, 1);