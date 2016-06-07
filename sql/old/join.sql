insert into didi_join
( didi_join.order_id, didi_join.driver_id, didi_join.passenger_id, didi_join.start_district_hash, didi_join.dest_district_hash,
  didi_join.price, didi_join.order_time_str, didi_join.order_time, didi_join.start_poi_class,didi_join.dest_poi_class,
  didi_join.start_tj_level,didi_join.dest_tj_level, 
  didi_join.tj_time_str, didi_join.traffic_time, didi_join.weather, didi_join.temperature, didi_join.PM)

select 
o.order_id, o.driver_id, o.passenger_id, o.start_district_hash, o.dest_district_hash,
	o.price, o.order_time, o.time, poi_1.poi_class, poi_2.poi_class, 
	traffic_1.tj_level, traffic_2.tj_level,
	traffic_1.tj_time, 	o.order_time, weather.weather, weather.temperature, weather.PM
	from tb_order_data o 
	left join tb_poi_data poi_1 on o.start_district_hash = poi_1.district_hash
	left join tb_poi_data poi_2 on o.dest_district_hash = poi_2.district_hash
	left join tb_traffic_data traffic_1 on o.start_district_hash = traffic_1.district_hash
	left join tb_traffic_data traffic_2 on o.dest_district_hash = traffic_2.district_hash
	left join tb_weather_data weather on o.time = weather.time

