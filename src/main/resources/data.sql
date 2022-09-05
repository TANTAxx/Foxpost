create TABLE if not exists CLIENTS (
   ID INT auto_increment ,
   CLIENT_NAME VARCHAR(100) NOT NULL,
   ADDRESS VARCHAR(100) NOT NULL,
   ZIPCODE VARCHAR(100) NOT NULL,
   PHONE VARCHAR(100) NOT NULL,
   EMAIL VARCHAR(100) NOT NULL,
   PRIMARY KEY (ID)
);
create TABLE if not exists PARCELS (
    id int auto_increment  PRIMARY KEY,
   SENDER_ID INT NOT NULL,
   RECEIVER_ID INT NOT NULL,
   PARCEL_NO VARCHAR(100) NOT NULL


);
create TABLE if not exists TRACKINGS (
   ID INT auto_increment ,
   PARCEL_ID INT NOT NULL,
   EVENT_DATE TIMESTAMP NOT NULL,
   EVENT_ID SMALLINT NOT NULL,
   PRIMARY KEY (ID)
);

create TABLE if not exists EVENTS (
   ID INT auto_increment ,
   EVENT_NAME VARCHAR(100) NOT NULL,
   PRIMARY KEY (ID)
);

insert into clients (CLIENT_NAME,ADDRESS,ZIPCODE,CITY,PHONE,EMAIL)
values ('Kiss Pál','Petőfi Sándor utca 11','9700','Szombathely','06203456234','kisspalvagynagy@gmail.com');

insert into clients (CLIENT_NAME,ADDRESS,ZIPCODE,CITY,PHONE,EMAIL)
values ('József Attila','Övezet utca 25','1051','Budapest','06707656234','attila.jozsef@gmail.com');

insert into clients (CLIENT_NAME,ADDRESS,ZIPCODE,CITY,PHONE,EMAIL)
values ('Bende Pál','Péterfy Sándor utca 11','1071','Budapest','06303456234','bendepal12y@gmail.com');

insert into clients (CLIENT_NAME,ADDRESS,ZIPCODE,CITY,PHONE,EMAIL)
values ('Nagy Árpád','Petőfi Sándor utca 111','1131','Budapest','06203489834','nagyarpigyar@gyar.com');

insert into clients (CLIENT_NAME,ADDRESS,ZIPCODE,CITY,PHONE,EMAIL)
values ('Füst Elek','Váci utca 201','1141','Budapest','06302239834','fustolok22@citromail.com');

--CREATE SEQUENCE client_id_seq_gen
--  START WITH 6
--  INCREMENT BY 1
--  MINVALUE 6;

insert into parcels(SENDER_ID_ID,RECEIVER_ID_ID,PARCEL_NO)
values (1,1,'XPUN111231321321');

insert into parcels(SENDER_ID_ID,RECEIVER_ID_ID,PARCEL_NO)
values (2,2,'XPUN111437921321');

insert into parcels(SENDER_ID_ID,RECEIVER_ID_ID,PARCEL_NO)
values (3,3,'XPUN111276521321');

insert into parcels(SENDER_ID_ID,RECEIVER_ID_ID,PARCEL_NO)
values (4,4,'XPUN111238921321');

insert into parcels(SENDER_ID_ID,RECEIVER_ID_ID,PARCEL_NO)
values (5,5,'XPUN116785421321');

--CREATE SEQUENCE parcel_id_seq_gen
--  START WITH 6
--  INCREMENT BY 1
--  MINVALUE 6;

--CREATE SEQUENCE event_id_seq_gen
--  START WITH 6
--  INCREMENT BY 1
--  MINVALUE 6;


insert into events(EVENT_NAME)
values ('Az ajtó nem nyilik');

insert into events(EVENT_NAME)
values ('Az automata nem űzemel');

insert into events(EVENT_NAME)
values ('Csomag eltünt');

insert into events(EVENT_NAME)
values ('Automata tele van');

insert into events(EVENT_NAME)
values ('Sikeres Fizetés!');

--alter sequence event_id_seq_gen
--  restart with 1
--  increment by 1
--  minvalue 6;


insert into trackings(PARCEL_ID_ID,EVENT_DATE,EVENT_ID_ID)
values (1,current_timestamp() ,1 );

insert into trackings(PARCEL_ID_ID,EVENT_DATE,EVENT_ID_ID)
values (1,current_timestamp(),2 );

insert into trackings(PARCEL_ID_ID,EVENT_DATE,EVENT_ID_ID)
values (3,current_timestamp(),3 );

insert into trackings(PARCEL_ID_ID,EVENT_DATE,EVENT_ID_ID)
values (4,current_timestamp(),4 );

insert into trackings(PARCEL_ID_ID,EVENT_DATE,EVENT_ID_ID)
values (5,current_timestamp(),5 );

--alter sequence tracking_id_seq_gen
--  restart with 6
--  increment by 1
--  minvalue 6;