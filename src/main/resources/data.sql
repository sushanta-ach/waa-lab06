INSERT INTO user (id, name, password)
VALUES (1, 'sushanta', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user (id, name, password)
VALUES (2, 'debo', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user (id, name, password)
VALUES (3, 'purabi', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');


INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO user_roles (user_id, roles_id)
VALUES (3, 2);

