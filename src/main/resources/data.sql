-- users
INSERT INTO "users"("id","username", "password", "enabled") VALUES (1, 'david', '$2a$10$.ysnHr4PeaEgfljWaHexYO41hvcqmxLFOG69179iOLkHUKXRFpXKu', 1);
INSERT INTO "users"("id","username", "password", "enabled") VALUES (2, 'mark', '$2a$10$QIWJYadawFt4QQut5MRgdeSMQKFPROQELPWphpGgHYQl3VwLsqcgS', 1);
INSERT INTO "users"("id","username", "password", "enabled") VALUES (3, 'john', '$2a$10$LUVfN36xEPS4kqD7NNUuUemaI30J6wzYpkYN6X7UzYhpDun6vaLFC', 1);
INSERT INTO "users"("id","username", "password", "enabled") VALUES (4, 'ryan', '$2a$10$RwAaoqOzsS9J1RSivRozUeOj1Bs/uExeP1TMa6wG21zwll3Yp9DUC', 1);
INSERT INTO "users"("id","username", "password", "enabled") VALUES (5, 'martin', '$2a$10$ACRP9z0Ya//Nbym3oQj9Keq4NNXwoq.oyCnUlx1819RvlzLcqDTJq/uExeP1TMa6wG21zwll3Yp9DUC', 1);

-- role
INSERT INTO "role"("id", "rolename", "user_id") VALUES (1, 'ROLE_ADMIN', 1);
INSERT INTO "role"("id", "rolename", "user_id") VALUES (2, 'ROLE_USER', 1);
INSERT INTO "role"("id", "rolename", "user_id") VALUES (3, 'ROLE_USER', 2);

-- product
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (1, 'Lamy 2000 (fine nib)', 'Precision German pen-gineering.', 15000, 2, 27500, 'http://i.imgur.com/Kx5Y0gL.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (2, 'Lil Wayne''s Guitar', 'Has most strings.', 260000, 5, 1200000, 'http://i.imgur.com/JFIRXNn.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (3, 'Yacht', 'Apparently haunted.', 3500000, 0, 0, 'http://i.imgur.com/s826JBI.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (4, '500 Tongue Depressors', 'Slightly used.', 1200, 5, 5500, 'http://i.imgur.com/UhrZz6u.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (5, 'Decoder Ring', 'One size fits all.', 002, 300, 599, 'http://i.imgur.com/2gMyuz0.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (6, 'Burned Quarter', 'Found near the road.', 025, 0, 0, 'http://i.imgur.com/57gp77Y.jpg');
INSERT INTO "products" ("id", "name", "snippet", "price", "deal_count", "deal_price", "imgsrc") VALUES (7, 'Wool Hat', 'Found near the quarter.', 100, 10, 900, 'http://i.imgur.com/uv7URjD.jpg');