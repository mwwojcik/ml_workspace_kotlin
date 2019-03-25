CREATE TABLE reguly (
   id INT  NOT NULL,
   nazwa VARCHAR (45),
   PRIMARY KEY (ID)
)

create TABLE parametry_reguly(
id INT  NOT NULL,
regula_id int not null,
nazwa VARCHAR (45),
typ VARCHAR (45),
wartosc_domyslna VARCHAR (150),
PRIMARY KEY (ID)
)

ALTER TABLE parametry_reguly
  ADD FOREIGN KEY (regula_id) REFERENCES reguly(id)
