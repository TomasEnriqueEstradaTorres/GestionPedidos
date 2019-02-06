package uF6.ejercicios.practica2.GestionPedidos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MainPrincipal {

	public static void main(String[] args) {

		

		
		
		//sirve para poner la fecha con hora definida por el sistema
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		String datoFecha = localDateTime.format(fecha);
		
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("hh:mm:ss");
		String datoHora = localDateTime.format(hora);
		
		System.out.println("formato standar: " + localDateTime);
		System.out.println("\n----------------------------------");
		System.out.println("formato fecha: " + datoFecha);
		System.out.println("\n----------------------------------");
		System.out.println("formato hora: " + datoHora);

		

	}

}


/*
//sirve para poner la fecha con hora definida por el sistema
LocalDateTime localDateTime = LocalDateTime.now();
DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
String datoFecha = localDateTime.format(fecha);
	
DateTimeFormatter hora = DateTimeFormatter.ofPattern("hh:mm:ss");
String datoHora = localDateTime.format(hora);
	
System.out.println("formato standar: " + localDateTime);
System.out.println("\n----------------------------------");
System.out.println("formato fecha: " + datoFecha);
System.out.println("\n----------------------------------");
System.out.println("formato hora: " + datoHora);
 
 
 
//pasar de LocalDate a String
LocalDate localDate = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
String formattedString = localDate.format(formatter);
System.out.println(formattedString);
*/

/*
//pasa de String a LocalDate
LocalDate fechaCaducidad;
String ddmmAA = "13/11/2018";
fechaCaducidad = LocalDate.parse(ddmmAA, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
System.out.println(fechaCaducidad);
*/

/* 
//Contar dias de caducidad
LocalDate fechaActual = LocalDate.now();
System.out.println("Fecha actual: " + fechaActual);
LocalDate fechaCaducidad;
String ddmmAA = "13/11/2018";
fechaCaducidad = LocalDate.parse(ddmmAA, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaCaducidad);
System.out.println("Fecha caducidad: " + fechaCaducidad);
System.out.println(diasRestantes);
*/


