CREATE SEQUENCE ${current.schema}.dom_health_activity_tracker_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE SEQUENCE ${current.schema}.dom_health_activity_tracker_association_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE ${current.schema}.dom_health_activity_tracker
(
    c_pk                         bigint NOT NULL,
    c_created                    timestamp with time zone,
    c_updated                    timestamp with time zone,
    c_health_activity_tracker_id bigint NOT NULL
);

CREATE TABLE ${current.schema}.dom_health_activity_tracker_association
(
    c_pk                         bigint NOT NULL,
    c_created                    timestamp with time zone,
    c_updated                    timestamp with time zone,
    c_health_activity_tracker_pk bigint NOT NULL,
    c_transplant_recipient_pk    bigint NOT NULL,
    c_protocol                   character varying(10)
);