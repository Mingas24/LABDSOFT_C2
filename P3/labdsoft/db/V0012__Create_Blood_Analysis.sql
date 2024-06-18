CREATE SEQUENCE ${current.schema}.dom_blood_analysis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_blood_analysis
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_blood_analysis_method   character varying(15),
    c_analysis_result_value   character varying(5),
    c_analysis_result         character varying(15)
);