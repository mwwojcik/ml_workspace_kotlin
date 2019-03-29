CREATE TABLE IF NOT EXISTS reguly (
   id INTEGER IDENTITY PRIMARY KEY,
   kod VARCHAR (45),
   tresc VARCHAR(500)

)

create TABLE IF NOT EXISTS parametry_reguly(
	id INTEGER IDENTITY PRIMARY KEY,
	regula_id int not null ,
	nazwa VARCHAR (45),
	typ VARCHAR (45),
	wartosc_domyslna VARCHAR (150),
	 FOREIGN KEY (regula_id)  REFERENCES reguly(id)
	)
