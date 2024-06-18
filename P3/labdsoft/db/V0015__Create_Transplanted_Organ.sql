CREATE SEQUENCE ${current.schema}.dom_transplanted_organ_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_transplanted_organ
(
    c_pk           bigint NOT NULL,
    c_created      timestamp with time zone,
    c_updated      timestamp with time zone,
    c_full_name    character varying(255),
    c_transplanted_organ character varying(15),
    c_transplantation_date timestamp with time zone
);
