--TABLA PersonalExterno
CREATE SEQUENCE idPersonalExterno;

CREATE OR REPLACE TYPE PersonalExterno_Type AS OBJECT(
  idPersonalExterno NUMBER(4),
  nombre VARCHAR2(25),
  apellidos VARCHAR2(50),
  empleo VARCHAR2(25),
  empresa VARCHAR2(30)
);

CREATE TABLE PersonalExterno OF PersonalExterno_Type(
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
    precio NUMBER
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
    dni VARCHAR2(25) NOT NULL,
    nombre VARCHAR2(25) NOT NULL,
    apellidos VARCHAR2(50) NOT NULL,
    datosTarjeta VARCHAR2(25),
    foto BLOB NOT NULL,
    PRIMARY KEY (idEmpleado)
  );
  
-- TABLA Factura
CREATE SEQUENCE idFactura;

CREATE TABLE Factura(
    idFactura NUMBER(4) NOT NULL,
    nuMeses NUMBER(2) NOT NULL,
    fechaPagado DATE,
    total NUMBER NOT NULL,
    creada DATE NOT NULL,
    PRIMARY KEY (idFactura)
  );
 
-- TABLA LineaDeduccion
CREATE SEQUENCE idLineaDeduccion; 
 
CREATE TABLE LineaDeduccion(
    idLineaDeduccion NUMBER(4) NOT NULL,
    nomDeduccion VARCHAR2(25) NOT NULL,
    numero NUMBER NOT NULL,
    cantidad NUMBER NOT NULL,
    total NUMBER NOT NULL,
    PRIMARY KEY (idLineaDeduccion)
  );
  
-- TABLA LineaPago
CREATE SEQUENCE idLineaPago; 
 
CREATE TABLE LineaPago(
    idLineaPago NUMBER(4) NOT NULL,
    descuento NUMBER NOT NULL,
    numero NUMBER NOT NULL,
    total NUMBER NOT NULL,
    iva NUMBER NOT NULL,
    nomCuota VARCHAR2(25) NOT NULL,
    precio NUMBER NOT NULL,
    PRIMARY KEY (idLineaPago)
  );