insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'auto', '1', LocalDateTime.now(), '150.50','0.00','Transaccion UNO','OK','WEB');

insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'pago', '2', LocalDateTime.now(), '180.50','1.00','Transaccion DOS','OK','WEB');

insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'pago', '3', LocalDateTime.now(), '3240.50','23.00','Transaccion TRES','OK','WEB');

insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'auto', '3', LocalDateTime.now(), '87830.50','14.00','Transaccion CUATRO','OK','WEB');

insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'auto', '4', LocalDateTime.now(), '7620.50','22.00','Transaccion CINCO','OK','OFICINA');

insert into Transaction (id, reference, ibanAccount, date, amount, fee, description, status, channel )
  values (nextval('hibernate_sequence'), 'fer', '9', LocalDateTime.now(), '41520.50','5.00','Transaccion SEIS','OK','CAJERO');
