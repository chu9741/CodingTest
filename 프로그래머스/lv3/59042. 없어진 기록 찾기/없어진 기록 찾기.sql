-- 코드를 입력하세요
# SELECT ao.animal_id from animal_ins ai right join animal_outs ao on ai.animal_id = ao.animal_id where ao.animal_id not in (select animal_id from animal_ins);

select ao.animal_id, ao.name from animal_outs ao where ao.animal_id not in (select animal_id from animal_ins);

