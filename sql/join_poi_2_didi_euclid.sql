update `didi_euclid` inner join `tb_poi_data` on didi_euclid.`start_hash` = tb_poi_data.`district_hash`
set `didi_euclid`.`poi_class` = `tb_poi_data`.`poi_class`

update `didi_euclid` inner join `tb_poi_data` on didi_euclid.`start_hash` = tb_poi_data.`district_hash`
set `didi_euclid`.`start_id` = `tb_poi_data`.`id`
