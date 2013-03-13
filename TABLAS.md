TABLAS
######

##XML
- PersonalExterno* ->Desde Base de datos relacional
	
##Hibernate
- Entrada
- Empleado
- Empleo


##Objeto Relacional
- Cuota
- Deduccion
- Factura
- LineaDeduccion
- LineaPago


##Base de datos relacional
- PersonalExterno
- Pista
- Socio
- Reserva
- Actividad
- ActividadSocio

#División por personas

##Aaron (5 tablas):
	- Hibernate:
		- Entrada
	- Objeto Relacional
		- Deduccion
		- LineaPago
	- Relacional
		- Socio
		- Reserva
	
##Adrian (5 tablas):
	- Hibernate
		- Empleado
	- Objeto Relacional
		- Factura
	- Relacional
		- Pista
		- PersonalExterno*
	- XML
		- PersonalExterno

##Joan (5 tablas):
	- Hibernate
		- Empleo
	- Objeto Relacional
		- Cuota
		- LineaDeduccion
	- Relacional
		- Actividad
		- ActividadSocio

