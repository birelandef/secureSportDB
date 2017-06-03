/*
insert objects
*/
insert into objects 
    select docid , 2  from sportsmen;
insert into objects 
    select  pairid, 1  from Pair;
insert into objects 
    select tdocid , 3  from Trainer;
insert into objects 
    select competitionid, 4  from Competition;
insert into objects 
    select  competitionresultid, 5  from TakePart;
insert into objects 
    select competitionsettingsid  , 6  from Judge;
insert into objects 
    select trainsid , 7  from Trains;
/*
insert sportsmen params
*/
insert into params 
    select 3, docid, firstname from sportsmen;
insert into params 
    select 5, docid, secondname from sportsmen;
insert into params 
    select 2, docid,  NULL, birthdate from sportsmen;


insert into params 
    select 6, docid, 2 from sportsmen
    where sextype = 0;
insert into params 
    select 6, docid, 3 from sportsmen
    where sextype = 1;

insert into params 
    select 4, docid, NULL, NULL, NULL ,4 from sportsmen
    where latinclass = 6;
insert into params 
    select 4, docid, NULL, NULL, NULL, 5 from sportsmen
    where latinclass = 4;
insert into params 
    select 4, docid,NULL, NULL, NULL, 6 from sportsmen
    where latinclass = 5;
insert into params 
    select 4, docid, NULL, NULL, NULL, 7 from sportsmen
    where latinclass = 2;
insert into params 
    select 4, docid, NULL, NULL, NULL,8 from sportsmen
    where latinclass = 1;
insert into params 
    select 4, docid, NULL, NULL, NULL,9 from sportsmen
    where latinclass = 0;
insert into params 
    select 4, docid, NULL, NULL, NULL,10 from sportsmen
    where latinclass = 3;

insert into params 
    select 7, docid,  NULL, NULL, NULL,4 from sportsmen
    where standardclass = 6;
insert into params 
    select 7, docid,  NULL, NULL, NULL,5 from sportsmen
    where standardclass = 4;
insert into params 
    select 7, docid, NULL, NULL, NULL, 6 from sportsmen
    where standardclass = 5;
insert into params 
    select 7, docid,  NULL, NULL, NULL,7 from sportsmen
    where standardclass = 2;
insert into params 
    select 7, docid,  NULL, NULL, NULL,8 from sportsmen
    where standardclass = 1;
insert into params 
    select 7, docid,  NULL, NULL, NULL,9 from sportsmen
    where standardclass = 0;
insert into params 
    select 7, docid,  NULL, NULL, NULL,10 from sportsmen
    where standardclass = 3;

insert into params 
    select 3, tdocid, firstname from trainer;
insert into params 
    select 5, tdocid, lastName from trainer;


insert into attributes values (2, 'birthdate');
insert into attributes values (3, 'firstname');
insert into attributes values (4, 'latinclass');
insert into attributes values (5, 'secondname');
insert into attributes values (6, 'sextype');
insert into attributes values (7, 'standardclass');

insert into attributes values (8, 'club');
insert into attributes values (9, 'isLatin');
insert into attributes values (10, 'isStandard');

insert into attributes values (11, 'score');
insert into attributes values (12, 'averageScore');
    --club
insert into attributes values (13, 'malePartnerId');
insert into attributes values (14, 'femalePartnerId');

/*
insert trainer params
*/
insert into params 
    select 3, tdocid, firstname from trainer;
insert into params 
    select 5, tdocid, secondname from trainer;
insert into params 
    select 8, tdocid, club from trainer;

insert into params 
    select 9, tdocid, isLatin from trainer;
insert into params 
    select 10, tdocid, isStandard from trainer;

/*
insert pair params
*/
insert into params 
    select 11, pairId, NULL,  NULL, score from Pair;
insert into params 
    select 12, pairId, NULL, NULL, NULL, NULL, averageScore from Pair;
insert into params 
    select 8, pairId, club from Pair;
insert into NREFERENCES
    select 13, pairId, malePartnerId from Pair;
insert into NREFERENCES
    select 14, pairId, femalePartnerId from Pair;
/*
insert competition params
*/

insert into params 
    select 16, competitionId, name from Competition;
insert into params 
    select 17, competitionId, NULL,  NULL, rate from Competition;
insert into params 
    select 19, competitionId, NULL,  date from Competition;
insert into params 
    select 20, competitionId, location from Competition;
insert into params 
    select 28, competitionId, NULL,  NULL, scorePerPair from Competition;
 -- todo ignore competitionType;

/*
insert TakePart params
*/
insert into params 
    select 22, competitionresultid, NULL,  NULL, point from TakePart;
insert into params 
    select 11, competitionresultid,  NULL,  NULL, score from TakePart;
insert into NREFERENCES
    select 27, competitionresultid, pairid from TakePart;
insert into NREFERENCES
    select 23, competitionresultid, competitionid from TakePart;
/*
insert Judge params
*/
--
-- insert into params
--     select 24, competitionsettingsid,   NULL, NULL, NULL,16  from Judge
--     where program =0;
-- insert into params
--     select 24, competitionsettingsid,   NULL, NULL, NULL,17  from Judge
--     where program =1;

--
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL ,4 from Judge
--     where classtype = 6;
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL, 5 from Judge
--     where classtype = 4;
-- insert into params
--     select 26, competitionsettingsid,NULL, NULL, NULL, 6 from Judge
--     where classtype = 5;
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL, 7 from Judge
--     where classtype = 2;
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL,8 from Judge
--     where classtype = 1;
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL,9 from Judge
--     where classtype = 0;
-- insert into params
--     select 26, competitionsettingsid, NULL, NULL, NULL,10 from Judge
--     where classtype = 3;

insert into NREFERENCES
    select 25, competitionsettingsid, trainerid from Judge;
insert into NREFERENCES
    select 23, competitionsettingsid, competitionid from Judge;


/*
insert Trains params
*/
insert into NREFERENCES
    select 27, trainsid, pairid from Trains;
insert into NREFERENCES
    select 25, trainsid, trainerid from Trains;








