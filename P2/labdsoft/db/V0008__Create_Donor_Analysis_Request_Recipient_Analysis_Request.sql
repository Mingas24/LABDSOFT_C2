CREATE SEQUENCE ${current.schema}.dom_donor_analysis_request_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_recipient_analysis_request_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_donor_analysis_request
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_requested_by             bigint NOT NULL,
    c_donor                    bigint NOT NULL,
    c_donor_sample             bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_recipient_analysis_request
(
    c_pk                      bigint NOT NULL,
    c_created                 timestamp with time zone,
    c_updated                 timestamp with time zone,
    c_requested_by             bigint NOT NULL,
    c_recipient                bigint NOT NULL,
    c_recipient_sample         bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_analysis_type_donor
(
    c_pk                            bigint NOT NULL,
    c_created                       timestamp with time zone,
    c_updated                       timestamp with time zone,
    c_donor_analysis_request_pk bigint NOT NULL,
    c_analysis_type_pk              bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_analysis_type_recipient
(
    c_pk                            bigint NOT NULL,
    c_created                       timestamp with time zone,
    c_updated                       timestamp with time zone,
    c_recipient_analysis_request_pk bigint NOT NULL,
    c_analysis_type_pk              bigint NOT NULL
);