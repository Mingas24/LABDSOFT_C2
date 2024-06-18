CREATE SEQUENCE ${current.schema}.dom_donor_blood_analysis_result_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_recipient_blood_analysis_result_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_donor_blood_analysis_result
(
    c_pk                    bigint NOT NULL,
    c_created               timestamp with time zone,
    c_updated               timestamp with time zone,
    c_donor                 bigint NOT NULL,
    c_donor_sample          bigint NOT NULL,
    c_analysis_date         timestamp with time zone,
    c_is_validated             boolean
);

CREATE TABLE ${current.schema}.dom_recipient_blood_analysis_result
(
    c_pk                    bigint NOT NULL,
    c_created               timestamp with time zone,
    c_updated               timestamp with time zone,
    c_recipient             bigint NOT NULL,
    c_recipient_sample      bigint NOT NULL,
    c_analysis_date         timestamp with time zone,
    c_is_validated             boolean
);

CREATE TABLE ${current.schema}.dom_blood_analysis_donor
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_donor_blood_analysis_result_pk  bigint NOT NULL,
    c_blood_analysis_pk bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_blood_analysis_recipient
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_recipient_blood_analysis_result_pk  bigint NOT NULL,
    c_blood_analysis_pk bigint NOT NULL
);