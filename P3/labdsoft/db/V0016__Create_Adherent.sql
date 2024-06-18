CREATE SEQUENCE ${current.schema}.dom_Adherent_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;


CREATE TABLE ${current.schema}.dom_adherent
(
    c_pk           bigint NOT NULL,
    c_created      timestamp with time zone,
    c_updated      timestamp with time zone,
    c_full_name    character varying(255),
    c_age          character varying(15),
    c_nationality   character varying(255),
    c_job           character varying(255),
    c_celebrity     character varying(15)
);

