CREATE SEQUENCE ${current.schema}.dom_vital_signs_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_protocol
(
    c_pk                bigint NOT NULL,
    c_protocol          character varying(10),
    c_blood_pressure    character varying(10),
    c_body_temperature  character varying(10),
    c_heart_rate        character varying(10)
);

CREATE TABLE ${current.schema}.dom_vital_signs
(
    c_pk                    bigint NOT NULL,
    c_created               timestamp with time zone,
    c_updated               timestamp with time zone,
    c_health_tracker_identifier          character varying(10),
    c_blood_pressure    character varying(10),
    c_body_temperature  character varying(10),
    c_heart_rate        character varying(10),
    c_stability         character varying(50)
);

INSERT INTO ${current.schema}.dom_protocol (c_pk, c_protocol, c_blood_pressure, c_body_temperature, c_heart_rate) VALUES (1, 'A1', '130', '38', '100');
INSERT INTO ${current.schema}.dom_protocol (c_pk, c_protocol, c_blood_pressure, c_body_temperature, c_heart_rate) VALUES (2, 'A2', '35', '25', '15');
INSERT INTO ${current.schema}.dom_protocol (c_pk, c_protocol, c_blood_pressure, c_body_temperature, c_heart_rate) VALUES (3, 'B1', '30', '10', '40');
INSERT INTO ${current.schema}.dom_protocol (c_pk, c_protocol, c_blood_pressure, c_body_temperature, c_heart_rate) VALUES (4, 'B2', '15', '50', '35');
INSERT INTO ${current.schema}.dom_protocol (c_pk, c_protocol, c_blood_pressure, c_body_temperature, c_heart_rate) VALUES (5, 'C1', '10', '20', '30');