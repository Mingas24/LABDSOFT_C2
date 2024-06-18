CREATE SEQUENCE ${current.schema}.dom_test_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;


CREATE TABLE ${current.schema}.dom_test
(
    c_pk               bigint NOT NULL,
    c_created          timestamp with time zone,
    c_updated          timestamp with time zone,
    c_test_description character varying(255)
);

-- mvn flyway:clean -P cito -f pom.xml -> no caso de dar reset na DB (tables + dados)
-- mvn flyway:migrate -P cito -f pom.xml -> no caso de haver uma nova migração

