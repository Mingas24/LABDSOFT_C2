CREATE SEQUENCE ${current.schema}.dom_transplant_donor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_organs_to_donate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_hla_transplant_donor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_transplant_donor
(
    c_pk                    bigint                NOT NULL,
    c_created               timestamp with time zone,
    c_updated               timestamp with time zone,
    c_full_name             character varying(100),
    c_death_date            timestamp with time zone,
    c_harvest_date          timestamp with time zone,
    c_category              character varying(200),
    c_blood_type            int                   NOT NULL
);

CREATE TABLE ${current.schema}.dom_organs_to_donate
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_transplant_donor_pk     bigint NOT NULL,
    c_organ_type_pk           bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_hla_transplant_donor
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_transplant_donor_pk     bigint NOT NULL,
    c_hla_type_pk             bigint NOT NULL
);