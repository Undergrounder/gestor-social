--Inserts DE MUESTRA
/*
INSERT INTO personalexterno VALUES (PersonalExterno_Seq.nextval, ' ', ' ', ' ', ' ');

INSERT INTO pista VALUES (Pista_Seq.nextval, ' ', , );

INSERT INTO socio VALUES (Socio_Seq.nextval, ' ', ' ', ' ', ' ', ' ', ' ', ' ',  ,  ,  ,  );

INSERT INTO reserva VALUES ( ,  , ' ',  , ' ');

INSERT INTO entrada VALUES (Entrada_Seq.nextval,  , ' ');

INSERT INTO actividad VALUES (Actividad_Seq.nextval, ' ', ' ', ' ');

INSERT INTO actividadsocio VALUES (  ,  );

INSERT INTO cuota VALUES (Cuota_Seq.nextval, ' ',  ,  );

INSERT INTO FACTURA VALUES (Factura_Seq.nextval,  ,   ,  ,   ,LINEAS_PAGO());

INSERT INTO empleo VALUES (Empleo_Seq.nextval, ' ', ' ',  );

INSERT INTO empleado VALUES (Empleado_Seq.nextval,  , ' ', ' ', ' ',  ,  );

*/

--Inserts Personalexterno
INSERT INTO personalexterno VALUES (PersonalExterno_Seq.nextval, 'Luis', 'Perez', 'Vigilante', 'GuardaSec');
INSERT INTO personalexterno VALUES (PersonalExterno_Seq.nextval, 'Jose', 'Galdos', 'Vigilante', 'GuardaSec');
INSERT INTO personalexterno VALUES (PersonalExterno_Seq.nextval, 'Maria', 'Bertrand', 'Jardinera', 'SweetGardens');
INSERT INTO personalexterno VALUES (PersonalExterno_Seq.nextval, 'Samanta', 'Carvajal', 'Vigilante', 'SweetGardens');

--INSERTS Pistas
INSERT INTO pista VALUES (Pista_Seq.nextval, 'Tenis', 50, 40);
INSERT INTO pista VALUES (Pista_Seq.nextval, 'Piscina', 20, 15);
INSERT INTO pista VALUES (Pista_Seq.nextval, 'Basquetball', 50, 40);
INSERT INTO pista VALUES (Pista_Seq.nextval, 'Golf', 180, 120);

--INSERTS Socios
INSERT INTO socio VALUES (Socio_Seq.nextval, '125984677', 'Jose', 'Lopez', 'algo@algo.com', 'S', '976118965', 'C/Falsa 23 4 A', '30-May-98', 12345678901234567890, 123456, 20);
INSERT INTO socio VALUES (Socio_Seq.nextval, '769132594', 'Mariano', 'Lopez', 'Mariano@algo.com', 'S', '976128965', 'C/Falsa 28 191 A', '10-Apr-59', 12344444901234567890, 123457, 10);
INSERT INTO socio VALUES (Socio_Seq.nextval, '397861545', 'Sandra', 'Kugele', 'Sandra@algo.com', 'N', '976898988', 'C/Aldebaran 28 191 A', '10-Oct-90', 12346664901234567890, 123458, 10);
INSERT INTO socio VALUES (Socio_Seq.nextval, '397961545', 'Nerea', 'Martin', 'Nereaa@algo.com', 'N', '976898323', 'C/Alfresca 99 1-Z', '29-Dec-79', 12377864901234567890, 125458, 10);

--INSERTS Reserva
INSERT INTO reserva VALUES (2, 1, '10-Oct-12', 60, 'S');
INSERT INTO reserva VALUES (1, 4, '20-Apr-13', 120, 'N');
INSERT INTO reserva VALUES (2, 2, '18-Feb-13', 20, 'S');
INSERT INTO reserva VALUES (3, 1, '30-Jul-14', 80, 'N');


--INSERTS Entrada
INSERT INTO entrada VALUES (Entrada_Seq.nextval, 1, '18-Mar-98');
INSERT INTO entrada VALUES (Entrada_Seq.nextval, 2, '23-Sep-06');
INSERT INTO entrada VALUES (Entrada_Seq.nextval, 3, sysdate);
INSERT INTO entrada VALUES (Entrada_Seq.nextval, 4, '01-Jan-00');


--INSERTS Actividad
INSERT INTO actividad VALUES (Actividad_Seq.nextval, 'Futbol', 'pista Futbol', 'Deporte');
INSERT INTO actividad VALUES (Actividad_Seq.nextval, 'Basquetball', 'pista Basquetball', 'Deporte');
INSERT INTO actividad VALUES (Actividad_Seq.nextval, 'Ajedrez', '2 Planta, edificio principal', 'Juego Mental');

--INSERTS ActividadSocio
INSERT INTO actividadsocio VALUES (  2, 2 );
INSERT INTO actividadsocio VALUES (  1, 3 );
INSERT INTO actividadsocio VALUES (  3, 1 );

--INSERTS Cuota
INSERT INTO cuota VALUES (Cuota_Seq.nextval, 'Niños', 21, 190);
INSERT INTO cuota VALUES (Cuota_Seq.nextval, 'Adultos', 21, 300);
INSERT INTO cuota VALUES (Cuota_Seq.nextval, 'Ancianos', 21, 170);

--INSERTS Factura
INSERT INTO FACTURA VALUES (Factura_Seq.nextval, 1, SYSDATE, 01, sysdate+1, LINEAS_PAGO());
INSERT INTO FACTURA VALUES (Factura_Seq.nextval, 2, '19-Nov-12', 12, null, LINEAS_PAGO());
INSERT INTO FACTURA VALUES (Factura_Seq.nextval, 3, SYSDATE, 01, '16-Mar-13', LINEAS_PAGO());

--INSERTS Empleo
INSERT INTO empleo VALUES (Empleo_Seq.nextval, 'Camarero', 'Mañanas', 900);
INSERT INTO empleo VALUES (Empleo_Seq.nextval, 'Camarero', 'Tardes', 1100);
INSERT INTO empleo VALUES (Empleo_Seq.nextval, 'Recepcionista', 'Mañanas y Tardes', 1000);
INSERT INTO empleo VALUES (Empleo_Seq.nextval, 'Entrenador Futbol', 'Tardes', 1200);
INSERT INTO empleo VALUES (Empleo_Seq.nextval, 'Limpieza', 'Mañanas', 1150);


--INSERTS Empleado
INSERT INTO empleado VALUES (Empleado_Seq.nextval, 3, '598745632', 'Laura', 'Millan', 0008976594);
INSERT INTO empleado VALUES (Empleado_Seq.nextval, 2, '348135964', 'Ana', 'Hernandez', 0008976584);
INSERT INTO empleado VALUES (Empleado_Seq.nextval, 4, '778985459', 'Marcos', 'Puy', 0008976884);
INSERT INTO empleado VALUES (Empleado_Seq.nextval, 1, '262689594', 'Hector', 'Pilot', 0008911594);
INSERT INTO empleado VALUES (Empleado_Seq.nextval, 5, '325499562', 'Laura', 'Fernandez', 0008976554);


/*
--INSERTS LINEA PAGO IS LIKE LOL
rem HAY UN ERROR QUE NO SE CUAL ES.
INSERT INTO TABLE (SELECT F.LINEAS FROM FACTURA F WHERE F.IDFACTURA=1)
VALUES (LineaPago_Seq.nextvalue, 20,CutoaLoca, 3, 205, 21, 155);



*/