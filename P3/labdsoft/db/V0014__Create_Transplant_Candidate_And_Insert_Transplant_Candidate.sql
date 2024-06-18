CREATE SEQUENCE ${current.schema}.dom_transplant_candidate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_transplant_candidate
(
    c_pk           bigint NOT NULL,
    c_full_name    character varying(255),
    c_points       character varying(15),
    c_blood_type   character varying(15),
    c_organ_for_transplant character varying(15),
    c_urgency_state         character varying(15)
);

INSERT INTO ${current.schema}.dom_transplant_candidate (c_pk, c_full_name, c_points, c_blood_type, c_organ_for_transplant, c_urgency_state)
VALUES (1, 'Maria Pereira', '80', 'A+', 'Fígado', 'SU');
INSERT INTO ${current.schema}.dom_transplant_candidate (c_pk, c_full_name, c_points, c_blood_type, c_organ_for_transplant, c_urgency_state)
VALUES (2, 'Carlos Ferreira', '81', 'O-', 'Fígado', 'U');
INSERT INTO ${current.schema}.dom_transplant_candidate (c_pk, c_full_name, c_points, c_blood_type, c_organ_for_transplant, c_urgency_state)
VALUES (3, 'Luís Vígario', '79', 'AB+', 'Fígado', 'SU');
INSERT INTO ${current.schema}.dom_transplant_candidate (c_pk, c_full_name, c_points, c_blood_type, c_organ_for_transplant, c_urgency_state)
VALUES (4, 'André Sacramento', '70', 'B-', 'Rins', 'SU');
