
CREATE VIEW comp_stat AS
    SELECT  count(*) as quantity, pairid
        from takepart group by pairid;


CREATE OR REPLACE FUNCTION addJudge()
  RETURNS void AS $$
DECLARE
  traineridvar varchar(40);
  pairidvar varchar(40);
  r varchar(40);
  temp varchar(40);
BEGIN
  select tdocid into traineridvar from trainer limit 1;

  SELECT pairid into pairidvar FROM comp_stat
  where quantity in (
    select max(quantity)
    from comp_stat);
  raise notice 'pairidvar: %', pairidvar;
  raise notice 'traineridvar: %', traineridvar;
  select count(competitionid) into  temp from takepart
  where pairid = pairidvar ;
  raise notice 'temp: %', temp;
  FOR r IN select competitionid from takepart
  where pairid = pairidvar
  LOOP
    raise notice 'Value: %', r;
    INSERT into judge(competitionid,trainerid) values (r, traineridvar)
    ON CONFLICT  DO NOTHING;
  END LOOP;
  RETURN;
END;
$$ LANGUAGE plpgsql;


SELECT "addjudge"();




select m.tr, m.p, count(*) as c
from (
select j.trainerid as tr, t. pairid  as p
from judge j, takepart t
where j.competitionid = t.competitionid) m
group by (m.tr, m.p)
order by c desc;


