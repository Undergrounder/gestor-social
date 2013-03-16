SET TRANSACTION NAME 'delete_all';

--Borramos las tablas
DROP TABLE Cuota PURGE;
DROP TABLE Empleado PURGE;
DROP TABLE Empleo PURGE;
DROP TABLE Entrada PURGE;
DROP TABLE Factura PURGE;
DROP TABLE PersonalExterno PURGE;
DROP TABLE Reserva PURGE;
DROP TABLE Pista PURGE;
DROP TABLE ActividadSocio PURGE;
DROP TABLE Actividad PURGE;
DROP TABLE Socio PURGE;

--Borramos objetos
DROP TYPE Cuota_Type FORCE;
DROP TYPE Factura_Type FORCE;
DROP TYPE LineaPago_Type FORCE;
DROP TYPE Lineas_Pago FORCE;

-- Borramos las secuencias
DROP SEQUENCE Actividad_Seq;
DROP SEQUENCE Cuota_Seq;
DROP SEQUENCE Empleado_Seq;
DROP SEQUENCE Empleo_Seq;
DROP SEQUENCE Entrada_Seq;
DROP SEQUENCE Factura_Seq;
DROP SEQUENCE LineaPago_Seq;
DROP SEQUENCE PersonalExterno_Seq;
DROP SEQUENCE Pista_Seq;
DROP SEQUENCE Socio_Seq;

COMMIT;