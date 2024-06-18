CREATE TABLE ${current.schema}.dom_analysis_type
(
    c_pk          int NOT NULL,
    c_description character varying(7)
);

INSERT INTO ${current.schema}.dom_analysis_type (c_pk, c_description)
VALUES (1, 'DNA');
INSERT INTO ${current.schema}.dom_analysis_type (c_pk, c_description)
VALUES (2, 'Víricas');