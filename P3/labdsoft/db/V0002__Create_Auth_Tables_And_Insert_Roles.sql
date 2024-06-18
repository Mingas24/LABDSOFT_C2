CREATE SEQUENCE ${current.schema}.auth_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.auth_role
(
    c_pk          bigint NOT NULL,
    c_description character varying(40)
);

CREATE TABLE ${current.schema}.auth_user
(
    c_pk           bigint NOT NULL,
    c_created      timestamp with time zone,
    c_updated      timestamp with time zone,
    c_username     character varying(40),
    c_password     character varying(60),
    c_email        character varying(60),
    c_full_name    character varying(255),
    c_phone_number character varying(15),
    c_role         bigint NOT NULL
);

INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (1, 'ADMIN');
INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (2, 'MEDICO');
INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (3, 'ENFERMEIRO');
INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (4, 'TLABORATORIO');
INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (5, 'DLABORATORIO');
INSERT INTO ${current.schema}.auth_role (c_pk, c_description) VALUES (6, 'TCOLHEITA');

-- PARA CRIAR SUPER USER:
-- http://localhost:8080/user
--
-- {
--     "username": "admin",
--     "password": "admin",
--     "fullName": "admin",
--     "phoneNumber": "admin",
--     "role": 1
-- }

