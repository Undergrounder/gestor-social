TABLAS
######

##XML
- PersonalExterno* ->Desde Base de objeto relacional
	
##Hibernate
- Socio
- Factura
- LineaDeduccion
- LineaPago
- Empleado
- Empleo


##Objeto Relacional
- Cuota
- Deduccion
- PersonalExterno

##Base de datos relacional
- Pista
- Reserva
- Actividad
- ActividadSocio
- Entrada


#División por personas

##Aaron (5 tablas):
	- Hibernate:
		- Empleado
        - Empleo
	- Objeto Relacional
		- Deduccion
	- Relacional
		- Entrada
	
##Adrian (5 tablas):
	- Hibernate
		- Socio
	- Objeto Relacional
		- PersonalExterno*
	- Relacional
		- Pista
		- Reserva
	- XML
		- PersonalExterno

##Joan (5 tablas):
	- Hibernate
		- LineaDeduccion
        - LineaPago
	- Objeto Relacional
		- Cuota
	- Relacional
		- Actividad

