CREATE SEQUENCE ${current.schema}.dom_organ_wastage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_organ_wastage
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_organ_type              bigint NOT NULL,
    c_donor                   bigint NOT NULL
);