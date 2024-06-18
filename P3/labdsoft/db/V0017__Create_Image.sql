CREATE SEQUENCE ${current.schema}.dom_image_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;


CREATE TABLE ${current.schema}.dom_image
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_name                    character varying(255),
    c_type                    character varying(15),
    c_picbyte                 bytea
);
