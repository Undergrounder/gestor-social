--TABLA PersonalExterno
CREATE SEQUENCE idPersonalExterno;

CREATE TABLE PersonalExterno(
  idPersonalExterno NUMBER(4) NOT NULL,
  nombre VARCHAR2(25) NOT NULL,
  apellidos VARCHAR2(50) NOT NULL,
  empleo VARCHAR2(25) NOT NULL,
  empresa VARCHAR2(30) NOT NULL,
  PRIMARY KEY (idPersonalExterno)
);

-- TABLA Pista
CREATE SEQUENCE idPista;

CREATE TABLE Pista(
    idPista NUMBER(4) NOT NULL,
    nombre VARCHAR2(25),
    precioNoSocios NUMBER,
    precioSocios NUMBER,
    PRIMARY KEY (idPista)
  );

-- Cuota
CREATE SEQUENCE idCuota;

	CREATE OR REPLACE TYPE Cuota_Type AS OBJECT(
    	idCuota NUMBER(4),
	  	nombre VARCHAR2(25),
	  	iva NUMBER(3),
	  	precio NUMBER,
	);


CREATE TABLE Cuota OF Cuota_Type(
  PRIMARY KEY (idCuota)
);
  
-- Deduccion
CREATE SEQUENCE idDeduccion;

	CREATE OR REPLACE TYPE Deduccion_Type AS OBJECT(
	  nombre VARCHAR2(25),
	  cantidad NUMBER
	);

CREATE TABLE Deduccion(
  idDeduccion NUMBER(4) NOT NULL,
  deduccion Deduccion_Type NOT NULL,
  PRIMARY KEY (idDeduccion)
);

-- TABLA Socio
CREATE SEQUENCE idSocio;

CREATE TABLE Socio(
    idSocio NUMBER(4) NOT NULL,
    dni VARCHAR2(9) NOT NULL,
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
CREATE SEQUENCE idReserva;

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
CREATE SEQUENCE idEntrada;

CREATE TABLE Entrada(
    idEntrada NUMBER(4) NOT NULL,
    socio_id NUMBER(4) NOT NULL,
    fecha DATE,
    PRIMARY KEY (idEntrada),
    FOREIGN KEY (socio_id) REFERENCES Socio (idSocio)
  );
    
--TABLA Actividad
CREATE SEQUENCE idActividad;
  
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

--TABLA Factura
CREATE SEQUENCE idFactura;

	CREATE OR REPLACE TYPE Factura_tipo AS OBJECT(
	  idFactura NUMBER(4),
	  socio_id REF socio,
	  creada DATE,
	  numMeses NUMBER(2),
	  fechaPagado DATE,
	  idLineaPago Lineas_Pago,
	  idLineaDeduccion Lineas_Deduccion,
	  total NUMBER   
	);


CREATE TABLE Factura OF Factura_tipo(
  PRIMARY KEY (idFactura),
  NESTED TABLE idLineaPago STORE AS Tabla_LineasPago,
  NESTED TABLE idLineaDeduccion STORE AS Tabla_LineasDeduccion

);

--TABLA LineaDeduccion
CREATE SEQUENCE idLineaDeduccion;

	CREATE OR REPLACE TYPE LineaDeduccion_Type AS OBJECT (
		idLineaDeduccion NUMBER(4) NOT NULL,
		factura_id REF Factura,
		nomDeduccion VARCHAR2(25) NOT NULL,
		numero NUMBER NOT NULL,
		cantidad NUMBER NOT NULL,
		total NUMBER NOT NULL,	
	);
	
CREATE OR REPLACE TYPE Lineas_Deduccion AS TABLE OF LineaDeduccion_Type;
	
CREATE TABLE LineaDeduccion OF LineaDeduccion_Type( 
  PRIMARY KEY (idLineaDeduccion)
);

--TABLA LineaPago
CREATE SEQUENCE idLineaPago;

	CREATE OR REPLACE TYPE LineaPago_Type AS OBJECT (
		idLineaPago NUMBER(4) NOT NULL,
		factura_id REF Factura,
		descuento NUMBER NOT NULL,
		nomCuota VARCHAR2(25) NOT NULL,
		numero NUMBER NOT NULL,
		precio NUMBER NOT NULL,
		iva NUMBER NOT NULL,
		total NUMBER NOT NULL,
	);

CREATE OR REPLACE TYPE Lineas_Pago AS TABLE OF LineaPago_Type;

CREATE TABLE LineaPago OF LineaPago_Type(
  PRIMARY KEY (idLineaPago)
);

-- TABLA Empleo
CREATE SEQUENCE idEmpleo;

CREATE TABLE Empleo(
    idEmpleo NUMBER(4) NOT NULL,
    nombre VARCHAR2(25) NOT NULL,
    horario VARCHAR2(50) NOT NULL,
    sueldo NUMBER,
    PRIMARY KEY (idEmpleo)
  );
  
    -- TABLA Empleado
CREATE SEQUENCE idEmpleado;

CREATE TABLE Empleado(
    idEmpleado NUMBER(4) NOT NULL,
    empleo_id NUMBER(4) NOT NULL,
    dni VARCHAR2(9) NOT NULL,
    nombre VARCHAR2(25) NOT NULL,
    apellidos VARCHAR2(50) NOT NULL,
    datosTarjeta NUMBER(25) NOT NULL,
    foto BLOB NOT NULL,
    PRIMARY KEY (idEmpleado),
    FOREIGN KEY (empleo_id) REFERENCES Empleo (idEmpleo)
  );