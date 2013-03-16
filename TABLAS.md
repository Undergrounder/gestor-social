TABLAS
######

##XML
- PersonalExterno* ->Desde Base de objeto relacional
	
##Hibernate
- Empleado
- Empleo
- Entrada

##Objeto Relacional
- Cuota
- Linea Pago
- Factura

##Base de datos relacional
- Pista
- Reserva
- Actividad
- ActividadSocio
- Socio


#División por personas

##Aaron (4 tablas):
	- Hibernate:
		- Entrada
	- Objeto Relacional
		- Linea Pago
	- Relacional
		- Reserva
		- ActividadSocio
	
##Adrian (5 tablas):
	- Hibernate
		- Empleado
	- Objeto Relacional		
		- Factura
	- Relacional
		- PersonalExterno*
		- Pista
	- XML
		- PersonalExterno

##Joan (4 tablas):
	- Hibernate
	    - Empleo
	- Objeto Relacional
		- Cuota
	- Relacional
		- Actividad
        - Socio
