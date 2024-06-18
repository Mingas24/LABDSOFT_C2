CREATE SEQUENCE ${current.schema}.dom_transplant_recipient_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_organs_in_need_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_hla_transplant_recipient_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_transplant_recipient
(
    c_pk                    bigint                NOT NULL,
    c_created               timestamp with time zone,
    c_updated               timestamp with time zone,
    c_registration_date     timestamp with time zone,
    c_registered_by         bigint                NOT NULL,
    c_full_name             character varying(100),
    c_address               character varying(200),
    c_date_of_birth         timestamp with time zone,
    c_identification        character varying(30),
    c_nationality           character varying(30) NOT NULL,
    c_imc                   character varying(10),
    c_assistent_doctor      bigint                NOT NULL,
    c_state_of_urgency      int                   NOT NULL,
    c_state_of_urgency_date timestamp with time zone,
    c_blood_type            int                   NOT NULL
);

CREATE TABLE ${current.schema}.dom_organs_in_need
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_transplant_recipient_pk bigint NOT NULL,
    c_organ_type_pk           bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_hla_transplant_recipient
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_transplant_recipient_pk bigint NOT NULL,
    c_hla_type_pk             bigint NOT NULL
);