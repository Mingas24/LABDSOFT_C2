CREATE TABLE ${current.schema}.dom_hla_type
(
    c_pk          int NOT NULL,
    c_description character varying(2)
);

CREATE TABLE ${current.schema}.dom_organ_type
(
    c_pk          int NOT NULL,
    c_description character varying(30)
);

CREATE TABLE ${current.schema}.dom_state_of_urgency
(
    c_pk          int NOT NULL,
    c_description character varying(30)
);

CREATE TABLE ${current.schema}.dom_blood_type
(
    c_pk          int NOT NULL,
    c_description character varying(3)
);

INSERT INTO ${current.schema}.dom_hla_type (c_pk, c_description)
VALUES (1, 'A');
INSERT INTO ${current.schema}.dom_hla_type (c_pk, c_description)
VALUES (2, 'B');
INSERT INTO ${current.schema}.dom_hla_type (c_pk, c_description)
VALUES (3, 'C');
INSERT INTO ${current.schema}.dom_hla_type (c_pk, c_description)
VALUES (4, 'DR');
INSERT INTO ${current.schema}.dom_hla_type (c_pk, c_description)
VALUES (5, 'DQ');

INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (1, 'Rins');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (2, 'Coração');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (3, 'Córnea');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (4, 'Fígado');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (5, 'Intestino');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (6, 'Pâncreas');
INSERT INTO ${current.schema}.dom_organ_type (c_pk, c_description)
VALUES (7, 'Pulmão');

INSERT INTO ${current.schema}.dom_state_of_urgency (c_pk, c_description)
VALUES (1, 'U');
INSERT INTO ${current.schema}.dom_state_of_urgency (c_pk, c_description)
VALUES (2, 'SU');

INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (1, 'A-');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (2, 'A+');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (3, 'B-');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (4, 'B+');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (5, 'O-');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (6, 'O+');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (7, 'AB-');
INSERT INTO ${current.schema}.dom_blood_type (c_pk, c_description)
VALUES (8, 'AB+');