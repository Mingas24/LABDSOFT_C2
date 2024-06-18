CREATE SEQUENCE ${current.schema}.dom_appointment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_appointment
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_appt_description        character varying(255),
    c_medic_pk                bigint NOT NULL,
    c_patient_pk              bigint NOT NULL
);