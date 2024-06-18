CREATE SEQUENCE ${current.schema}.dom_donor_sample_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_recipient_sample_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_donor_sample
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_donor                   bigint NOT NULL,
    c_registration_date       timestamp with time zone,
    c_sample_identification   character varying(30)
);

CREATE TABLE ${current.schema}.dom_recipient_sample
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_recipient               bigint NOT NULL,
    c_registration_date       timestamp with time zone,
    c_sample_identification   character varying(30)
);