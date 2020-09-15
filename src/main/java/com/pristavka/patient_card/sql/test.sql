create database Patient_cards;
drop database Patient_cards;

use Patient_cards;

select allergy.id,
       allergy.name,
       allergy.`group`
from allergy
where `group` = 'food' and id < 100;

select * from role;



