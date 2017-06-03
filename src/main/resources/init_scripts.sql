DROP TABLE object_types CASCADE;
DROP TABLE attributes CASCADE;
DROP TABLE params CASCADE;
DROP TABLE list_values CASCADE;
DROP TABLE attr_object_types CASCADE;
DROP TABLE NREFERENCES CASCADE;
DROP TABLE objects CASCADE ;

create table object_types (
object_type_id bigint PRIMARY KEY,
Name    VARCHAR(250)
);
create table objects (
object_id varchar(40) PRIMARY KEY,
object_type_id bigint REFERENCES object_types,
Name    VARCHAR(250)
);

create table attributes (
attr_id bigint PRIMARY KEY,
Name    VARCHAR(250)
);

create table params (
attr_id bigint REFERENCES attributes,
object_id varchar(40)  REFERENCES objects,
text_value VARCHAR(2000),
date_value DATE,
number_value int,
list_value bigint, 
number_double_value double precision
);
--  need?
create table attr_object_types(
    attr_id bigint REFERENCES attributes,
    object_type_id bigint REFERENCES object_types
);

create table list_values(
    LIST_VALUE_ID bigint PRIMARY KEY,
    VALUE VARCHAR(200)
);

create table NREFERENCES (
    attr_id bigint REFERENCES attributes,
    object_id varchar(40) REFERENCES objects,
    REFERENCE varchar(40) REFERENCES objects
);
/*
  For vertical scheme
*/
CREATE SEQUENCE train_sequence
  start 1
  increment 1;

ALTER TABLE Trains ADD COLUMN trainsID character varying(50);
update  Trains
  set trainsID = nextval('train_sequence');

ALTER TABLE Trains ALTER COLUMN trainsID SET default nextval('train_sequence');


ALTER TABLE Judge ADD COLUMN competitionsettingsid character varying(50);
update  Judge
  set competitionsettingsid = nextval('train_sequence');

ALTER TABLE Judge ALTER COLUMN competitionsettingsid SET default nextval('train_sequence');


