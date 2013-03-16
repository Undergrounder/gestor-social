--TABLA PersonalExterno
CREATE SEQUENCE PersonalExterno_Seq;

CREATE TABLE PersonalExterno(
  idPersonalExterno NUMBER(4) NOT NULL,
  nombre VARCHAR2(25) NOT NULL,
  apellidos VARCHAR2(50) NOT NULL,
  empleo VARCHAR2(25) NOT NULL,
  empresa VARCHAR2(30) NOT NULL,
  PRIMARY KEY (idPersonalExterno)
);

-- TABLA Pista
CREATE SEQUENCE Pista_Seq;

CREATE TABLE Pista(
    idPista NUMBER(4) NOT NULL,
    nombre VARCHAR2(25),
    precioNoSocios NUMBER,
    precioSocios NUMBER,
    PRIMARY KEY (idPista)
  );

-- TABLA Socio
CREATE SEQUENCE Socio_Seq;

CREATE TABLE Socio(
    idSocio NUMBER(4) NOT NULL,
    dni VARCHAR2(9) NOT NULL UNIQUE,
    nombre VARCHAR2(25) NOT NULL,
    apellidos VARCHAR2(50) NOT NULL,
    correo VARCHAR2(100) NOT NULL,
    esVaron CHAR(1) CHECK (esVaron IN ( 'S', 'N' )) NOT NULL,
    telefono VARCHAR2(9) NOT NULL,
    direccion VARCHAR2(255) NOT NULL,
    fechaNac DATE,
    cuentaBancaria NUMBER(20),
    codigoBarras NUMBER,
    descuento NUMBER(3),
    PRIMARY KEY (idSocio)
  );

-- TABLA Reserva

CREATE TABLE Reserva(
    socio_id NUMBER(4),
    pista_id NUMBER(4) NOT NULL,
    fecha DATE NOT NULL,
    precio NUMBER NOT NULL,
    estaPagado CHAR(1) CHECK (estaPagado IN ( 'S', 'N' )) NOT NULL,
    PRIMARY KEY (pista_id, fecha),
    FOREIGN KEY (socio_id) REFERENCES Socio (idSocio),
    FOREIGN KEY (pista_id) REFERENCES Pista (idPista)
  );
  
-- TABLA Entrada
CREATE SEQUENCE Entrada_Seq;

CREATE TABLE Entrada(
    idEntrada NUMBER(4) NOT NULL,
    socio_id NUMBER(4) NOT NULL,
    fecha DATE,
    PRIMARY KEY (idEntrada),
    FOREIGN KEY (socio_id) REFERENCES Socio (idSocio)
  );
    
--TABLA Actividad
CREATE SEQUENCE Actividad_Seq;
  
CREATE TABLE Actividad(
  idActividad NUMBER(4) NOT NULL,
  nombre VARCHAR2(25) NOT NULL,
  lugar VARCHAR2(255) NOT NULL,
  categoria VARCHAR(255) NOT NULL,
  PRIMARY KEY (idActividad)
);

--TABLA ActividadSocio
CREATE TABLE ActividadSocio(
  actividad_id NUMBER(4) NOT NULL,
  socio_id NUMBER(4) NOT NULL,
  PRIMARY KEY (actividad_id, socio_id),
  FOREIGN KEY (actividad_id) REFERENCES Actividad (idActividad),
  FOREIGN KEY (socio_id) REFERENCES Socio (idSocio)
);

-- Cuota
CREATE SEQUENCE Cuota_Seq;

	CREATE OR REPLACE TYPE Cuota_Type AS OBJECT(
    	idCuota NUMBER(4),
	  	nombre VARCHAR2(25),
	  	iva NUMBER(3),
	  	precio NUMBER
);

CREATE TABLE Cuota OF Cuota_Type(
  PRIMARY KEY (idCuota)
);

--TABLA LineaPago
CREATE SEQUENCE LineaPago_Seq;

  CREATE OR REPLACE TYPE LineaPago_Type AS OBJECT (
		idLineaPago NUMBER(4),
		descuento NUMBER,
		nomCuota VARCHAR2(25),
		numero NUMBER,
		precio NUMBER,
		iva NUMBER,
    total NUMBER
);

CREATE OR REPLACE TYPE Lineas_Pago AS TABLE OF LineaPago_Type;

--TABLA Factura
CREATE SEQUENCE Factura_Seq;

	CREATE OR REPLACE TYPE Factura_Type AS OBJECT(
    idFactura NUMBER(4),
    socio_id NUMBER(4),
    creada DATE,
    numMeses NUMBER(2),
    fechaPagado DATE,
    lineas Lineas_Pago,
    MEMBER FUNCTION total_factura RETURN NUMBER
     
	);
  
  CREATE OR REPLACE TYPE BODY Factura_Type AS
  MEMBER FUNCTION total_factura RETURN NUMBER IS
   TOTAL NUMBER:=0;
   LINEA   LineaPago_Type;
  BEGIN
    FOR I IN 1..LINEAS.COUNT LOOP
      LINEA:=LINEAS(I);
      TOTAL:=TOTAL + LINEA.NUMERO * LINEA.PRECIO;
    END LOOP;
    RETURN TOTAL;
  END;
END;


CREATE TABLE Factura OF Factura_Type(
  PRIMARY KEY (idFactura),
  FOREIGN KEY (socio_id) REFERENCES Socio (idSocio))
  NESTED TABLE LINEAS STORE AS TABLA_LINEAS;

-- TABLA Empleo
CREATE SEQUENCE Empleo_Seq;

CREATE TABLE Empleo(
    idEmpleo NUMBER(4) NOT NULL,
    nombre VARCHAR2(25) NOT NULL,
    horario VARCHAR2(50) NOT NULL,
    sueldo NUMBER,
    PRIMARY KEY (idEmpleo)
  );
  
    -- TABLA Empleado
CREATE SEQUENCE Empleado_Seq;

CREATE TABLE Empleado(
    idEmpleado NUMBER(4) NOT NULL,
    empleo_id NUMBER(4) NOT NULL,
    dni VARCHAR2(9) NOT NULL UNIQUE,
    nombre VARCHAR2(25) NOT NULL,
    apellidos VARCHAR2(50) NOT NULL,
    datosTarjeta NUMBER(25) NOT NULL UNIQUE,
    PRIMARY KEY (idEmpleado),
    FOREIGN KEY (empleo_id) REFERENCES Empleo (idEmpleo)
  );