CREATE SEQUENCE EXTERNO_SEQ;
CREATE SEQUENCE EMPLEO_SEQ;
CREATE SEQUENCE EMPLEADO_SEQ;
CREATE SEQUENCE CUOTA_SEQ;
CREATE SEQUENCE LINEA_PAGO_SEQ;
CREATE SEQUENCE PAGO_SEQ;
CREATE SEQUENCE SOCIO_SEQ;
CREATE SEQUENCE PISTAS_SEQ;
CREATE SEQUENCE RESERVA_SEQ;
CREATE SEQUENCE ENTRADA_SEQ;
CREATE SEQUENCE ACTIVIDAD_SEQ;

CREATE TABLE PERSONAL_EXTERNO(
    EXTERNO_ID NUMBER(4) NOT NULL,
    EXTERNO_NOMBRE VARCHAR2(25), 
    EXTERNO_APELLIDO VARCHAR2(30) NOT NULL,
    EXTERNO_EMPLEO VARCHAR2(30) NOT NULL,
    EXTERNO_EMPRESA VARCHAR2(40),
    PRIMARY KEY (EXTERNO_ID));
  

    
CREATE TABLE EMPLEO(
    EMPLEO_ID NUMBER(4) NOT NULL,
    EMPLEO_NOMBRE VARCHAR2(30) NOT NULL,
    EMPLEO_HORARIO VARCHAR2(7),
    PRIMARY KEY (EMPLEO_ID));
    
    
CREATE TABLE EMPLEADO(
    EMPLEADO_ID NUMBER(4) NOT NULL,
    EMPLEADO_DNI NUMBER(8),
    EMPLEADO_NOMBRE VARCHAR2(25),
    EMPLEADO_APELLIDO VARCHAR2(30),
    EMPLEADO_TARJETA NUMBER(10),
    EMPLEADO_SUELDO NUMBER(10),
    EMPLEADO_FOTO BLOB,
    EMPLEO_ID NUMBER(4) NOT NULL,
    PRIMARY KEY(EMPLEADO_ID, EMPLEADO_DNI),
    FOREIGN KEY(EMPLEO_ID) REFERENCES EMPLEO (EMPLEO_ID));
    
    
CREATE TABLE CUOTA OF CUOTA(    
    PRIMARY KEY (CUOTA_ID));
    
CREATE TABLE LINEA_PAGO OF LINEA_PAGO(    
    PRIMARY KEY (LINEA_ID));
    
CREATE TABLE PAGO OF PAGO(
    PRIMARY KEY (PAGO_ID),
	NESTED TABLE LINEAS STORE AS TABLA_LINEAS);
    
CREATE TABLE SOCIO(
    SOCIO_ID NUMBER(4) NOT NULL,
    SOCIO_DNI NUMBER(8),
    SOCIO_NOMBRE VARCHAR2(25),
    SOCIO_APELLIDO VARCHAR2(30),
    SOCIO_CORREO VARCHAR2(50),
    SOCIO_SEXO VARCHAR2(10),
    SOCIO_TELEFONO VARCHAR2(9),
    SOCIO_DIRECCION VARCHAR2(60),
    SOCIO_FECHA_NAC DATE,
    SOCIO_CUENTA_BANCARIA NUMBER(20),
    SOCIO_CODIGO_BARRAS NUMBER,
    RESERVA_ID INT,
    ENTRADA_ID INT,
    ACTIVIDAD_ID INT,
    PAGO_ID INT,
    PRIMARY KEY (SOCIO_ID, SOCIO_DNI),
    FOREIGN KEY (RESERVA_ID) REFERENCES RESERVA (RESERVA_ID),
    FOREIGN KEY (ENTRADA_ID) REFERENCES ENTRADA (ENTRADA_ID),
    FOREIGN KEY (ACTIVIDAD_ID) REFERENCES ACTIVIDAD (ACTIVIDAD_ID),
    FOREIGN KEY (PAGO_ID) REFERENCES PAGO (PAGO_ID));
    
CREATE TABLE PISTAS(
    PISTAS_ID NUMBER(4) NOT NULL,
    PISTAS_TIPO VARCHAR2(30),
    PISTAS_PRECIO NUMBER,
    SOCIO_ID NUMBER(4),
    EXTERNO_ID NUMBER(4),
    PRIMARY KEY (PISTAS_ID),
    FOREIGN KEY (SOCIO_ID) REFERENCES SOCIO (SOCIO_ID),
    FOREIGN KEY (EXTERNO_ID) REFERENCES EXTERNO (EXTERNO_ID));
    
CREATE TABLE RESERVA(
    RESERVA_ID NUMBER(4) NOT NULL,
    RESERVA_DIA NUMBER,
    RESREVA_HORA NUMBER,
    RESERVA_PAGADO VARCHAR2(10),
    PISTAS_ID NUMBER(4),
    PRIMARY KEY (RESRVA_ID),
    FOREIGN KEY (PISTAS_ID) REFERENCES PISTAS (PISTAS_ID));
    
CREATE TABLE ENTRADA(
    ENTRADA_ID NUMBER(4) NOT NULL,
    ENTRADA_FECHA DATE,
    SOCIO_ID NUMBER(4),
    PRIMARY KEY (ENTRADA_ID)
    FOREIGN KEY (SOCIO_ID) REFERENCES SOCIO (SOCIO_ID));
    
CREATE TABLE ACTIVIDAD(
    ACTIVIDAD_ID NUMBER(4) NOT NULL,
    ACTIVIDAD_NOMBRE VARCHAR2(30),
    ACTIVIDAD_LUGAR VARCHAR2(30),
    ACTIVIDAD_CATEGORIA VARCHAR2(30),
    PRIMARY KEY (ACTIVIDAD_ID));
  
CREATE TABLE PARTICIPANTES(
    SOCIO_ID NUMBER(4) NOT NULL,
    ACTIVIDAD_ID NUMBER(4) NOT NULL,
    
    PRIMARY KEY (SOCIO_ID, ACTIVIDAD_ID),
    FOREIGN KEY (SOCIO_ID) REFERENCES SOCIO (SOCIO_ID),
    FOREIGN KEY (ACTIVIDAD_ID) REFERENCES ACTIVIDAD (ACTIVIDAD_ID));
	
--Test Insert externo:
INSERT INTO personal_externo(EXTERNO_ID, EXTERNO_NOMBRE,externo_apellido, externo_empleo, externo_empresa) 
VALUES(externo_seq.nextval,'PEPE','LOL', 'JANITOR', 'LOLAZO');