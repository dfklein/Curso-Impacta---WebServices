insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('AAA-1111', curdate(), date_add(curdate(),INTERVAL 2 HOUR), 25);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('BBB-2222', curdate(), date_add(curdate(),INTERVAL 1 HOUR), 15);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('CCC-3333', curdate(), date_add(curdate(),INTERVAL 3 HOUR), 30);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('DDD-4444', curdate(), date_add(curdate(),INTERVAL 30 MINUTE), 10);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('EEE-5555', curdate(), date_add(curdate(),INTERVAL 45 MINUTE), 15);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('FFF-6666', curdate(), date_add(curdate(),INTERVAL 75 MINUTE), 20);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('GGG-7777', curdate(), date_add(curdate(),INTERVAL 5 HOUR), 80);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('HHH-8888', curdate(), date_add(curdate(),INTERVAL 4 HOUR), 70);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('JJJ-9999', curdate(), date_add(curdate(),INTERVAL 3 HOUR), 30);

insert into tb_movimentacao (placa,data_entrada,data_saida,valor)  values  ('LLL-0000', curdate(), date_add(curdate(),INTERVAL 4 HOUR), 70);

insert into tb_status_vagas(id,ocupadas) values (1,35);
