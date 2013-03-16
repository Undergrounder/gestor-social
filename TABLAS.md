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

##Aaron (4 tablas):
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
		- Actividad
	- XML
		- PersonalExterno

##Joan (4 tablas):
	- Hibernate
	    - Factura
		- LineaDeduccion
        - LineaPago
	- Objeto Relacional
		- Cuota
	- Relacional
        - ActividadSocio
