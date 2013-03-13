SET TRANSACTION NAME 'delete_all';

--Borramos las tablas
DROP TABLE Cuota PURGE;
DROP TABLE Deduccion PURGE;
DROP TABLE Empleado PURGE;
DROP TABLE Empleo PURGE;
DROP TABLE Entrada PURGE;
DROP TABLE LineaDeduccion PURGE;
DROP TABLE LineaPago PURGE;
DROP TABLE Factura PURGE;
DROP TABLE PersonalExterno PURGE;
DROP TABLE Reserva PURGE;
DROP TABLE Pista PURGE;
DROP TABLE ActividadSocio PURGE;
DROP TABLE Actividad PURGE;
DROP TABLE Socio PURGE;

--Borramos objetos
DROP TYPE Cuota_tipo;
DROP TYPE Deduccion_tipo;
DROP TYPE Factura_tipo;

-- Borramos las secuencias
DROP SEQUENCE idActividad;
DROP SEQUENCE idCuota;
DROP SEQUENCE idDeduccion;
DROP SEQUENCE idEmpleado;
DROP SEQUENCE idEmpleo;
DROP SEQUENCE idEntrada;
DROP SEQUENCE idFactura;
DROP SEQUENCE idLineaDeduccion;
DROP SEQUENCE idLineaPago;
DROP SEQUENCE idPersonalExterno;
DROP SEQUENCE idPista;
DROP SEQUENCE idReserva;
DROP SEQUENCE idSocio;

COMMIT;