CREATE FUNCTION UPDATE_SCORE () RETURNS trigger AS $$
BEGIN 
UPDATE PAIR
    SET SCORE = PAIR.SCORE + NEW.SCORE
    WHERE PAIR.pairid  = NEW.pairid;
RETURN NEW;
END;  
$$
LANGUAGE  plpgsql;

CREATE TRIGGER INSERT_SCORE
AFTER  INSERT ON TAKEPART  
FOR EACH  ROW 
EXECUTE PROCEDURE UPDATE_SCORE ();


CREATE TRIGGER objectsLog
BEFORE INSERT OR UPDATE OR DELETE ON params FOR EACH ROW EXECUTE PROCEDURE ADD_TO_HISTORY ();


CREATE TABLE HISTORY(
    history_id serial,
    CHANGE_DATE timestamp  default now(),
    type varchar(40), 
    attr_id bigint REFERENCES attributes,
    object_id varchar(40)  REFERENCES objects,    
    new_text_value VARCHAR(2000),
    old_text_value VARCHAR(2000),
    new_date_value DATE,
    old_date_value DATE,
    new_number_value int,
    old_number_value int,
    new_list_value bigint, 
    old_list_value bigint, 
    new_number_double_value double precision,
    old_number_double_value double precision
);

CREATE TABLE HISTORY_REF(
    history_id serial,
    CHANGE_DATE timestamp  default now(),
    type varchar(40),
    attr_id bigint REFERENCES attributes,
    object_id varchar(40)  REFERENCES objects,
    new_ref VARCHAR(40),
    old_ref VARCHAR(40)
);



CREATE OR REPLACE FUNCTION ADD_TO_HISTORY () RETURNS trigger AS $$
DECLARE
    typeo varchar(40);
    attr_id_var bigint ;
    object_id_var varchar(40);
    new_text_value_var VARCHAR(2000);
    old_text_value_var VARCHAR(2000);
    new_date_value_var DATE;
    old_date_value_var DATE;
    new_number_value_var int;
    old_number_value_var int;
    new_list_value_var bigint;
    old_list_value_var bigint;
    new_number_double_value_var double precision;
    old_number_double_value_var double precision;
BEGIN
 IF    TG_OP = 'INSERT' THEN
        typeo:='INSERT';
        object_id_var:=NEW.object_id;
        attr_id_var:=NEW.attr_id;
        new_text_value_var:=NEW.text_value;
        new_date_value_var:=NEW.date_value;
        new_number_value_var:=NEW.number_value;
        new_list_value_var:=NEW.list_value;
        new_number_double_value_var:=NEW.number_double_value;
        INSERT INTO HISTORY(CHANGE_DATE,type,attr_id,object_id,new_text_value,new_date_value,new_number_value,new_list_value , new_number_double_value)
        values (NOW(), typeo, attr_id_var,object_id_var,new_text_value_var,new_date_value_var,new_number_value_var ,new_list_value_var ,new_number_double_value_var);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        typeo:='UPDATE';
        object_id_var:=OLD.object_id;
        attr_id_var:=OLD.attr_id;
        new_text_value_var:=NEW.text_value;
        old_text_value_var:=OLD.text_value;
        new_date_value_var:=NEW.date_value;
        old_date_value_var:=OLD.date_value;
        new_number_value_var:=NEW.number_value;
        old_number_value_var:=OLD.number_value;
        new_list_value_var:=NEW.list_value;
        old_list_value_var:=OLD.list_value;
        new_number_double_value_var:=NEW.number_double_value;
        old_number_double_value_var:=OLD.number_double_value;
        INSERT INTO HISTORY(CHANGE_DATE,type,attr_id,object_id,new_text_value,old_text_value,new_date_value,old_date_value,new_number_value,old_number_value,new_list_value ,old_list_value, new_number_double_value,old_number_double_value)
        values (NOW(), typeo, attr_id_var,object_id_var,new_text_value_var,old_text_value_var,new_date_value_var,old_date_value_var,new_number_value_var,old_number_value_var,new_list_value_var,old_list_value_var,new_number_double_value_var,old_number_double_value_var);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        typeo:='DELETE';
        object_id_var:=OLD.object_id;
        attr_id_var:=OLD.attr_id;
        old_text_value_var:=OLD.text_value;
        old_date_value_var:=OLD.date_value;
        old_number_value_var:=OLD.number_value;
        old_list_value_var :=OLD.list_value;
        old_number_double_value_var:=OLD.number_double_value;
        INSERT INTO HISTORY(CHANGE_DATE,type,attr_id,object_id,old_text_value,old_date_value,old_number_value ,old_list_value,old_number_double_value)
        values (NOW(), typeo, attr_id_var,object_id_var,old_text_value_var,old_date_value_var,old_number_value_var ,old_list_value_var,old_number_double_value_var);
        RETURN OLD;
    END IF;
END;  
$$
LANGUAGE  plpgsql;



CREATE OR REPLACE FUNCTION ADD_TO_HISTORY_REF () RETURNS trigger AS $$
DECLARE
    typeo varchar(40);
    attr_id_var bigint ;
    object_id_var varchar(40);
    new_ref_var VARCHAR(40);
    old_ref_var VARCHAR(40);
BEGIN
 IF    TG_OP = 'INSERT' THEN
        typeo:='INSERT';
        object_id_var:=NEW.object_id;
        attr_id_var:=NEW.attr_id;
        new_ref_var:=NEW.REFERENCE;
        INSERT INTO HISTORY_REF(CHANGE_DATE,type,attr_id,object_id,new_ref)
        values (NOW(), typeo, attr_id_var,object_id_var,new_ref_var);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        typeo:='UPDATE';
        object_id_var:=OLD.object_id;
        attr_id_var:=OLD.attr_id;
        new_ref_var:=NEW.REFERENCE;
        old_ref_var:=OLD.REFERENCE;
        INSERT INTO HISTORY_REF(CHANGE_DATE,type,attr_id,object_id,new_ref,old_ref)
        values (NOW(), typeo, attr_id_var,object_id_var,new_ref_var,old_ref_var);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        typeo:='DELETE';
        object_id_var:=OLD.object_id;
        attr_id_var:=OLD.attr_id;
        old_ref_var:=OLD.REFERENCE;
        INSERT INTO HISTORY_REF(CHANGE_DATE,type,attr_id,object_id,old_ref)
        values (NOW(), typeo, attr_id_var,object_id_var,old_ref_var);
        RETURN OLD;
    END IF;
END;
$$
LANGUAGE  plpgsql;

CREATE TRIGGER objectsLog
BEFORE INSERT OR UPDATE OR DELETE ON NReferences FOR EACH ROW EXECUTE PROCEDURE ADD_TO_HISTORY_REF ();



