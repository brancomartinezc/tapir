package tapir;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidad.jugador.Jugador;
import entidad.Entidad;

public class TestingSetup {
	public static void setup() {
		HashMap<Integer, String> mapObjectsToCallSequence = null; 
		HashMap<String, String> mapMethodsToSymbols = null; 
		Pattern regularExpression = null; 
		Matcher matcher = null;
		
		//Specification of the test class\
		TestingCore.mapClassToTestingInformation = new HashMap<>();
			
		
		// Testing setup for Account class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("entidad.EntidadGrafica.<init>", "c");
		mapMethodsToSymbols.put("entidad.EntidadGrafica.iniciar", "i");
		mapMethodsToSymbols.put("entidad.EntidadGrafica.disparo", "a");
		mapMethodsToSymbols.put("entidad.EntidadGrafica.moverEtiqueta", "m");
		mapMethodsToSymbols.put("entidad.EntidadGrafica.daniar", "d");
		mapMethodsToSymbols.put("entidad.EntidadGrafica.desaparecer", "x");
		//Definition of the regular expression
		regularExpression = Pattern.compile("ci(d|a|m)*x");
		//Initializing the regular expressions controller
		matcher = regularExpression.matcher("");	
		// All information related to how the Account class is testing is store in a TestingInformation instance
		TestingInformation ti = new TestingInformation(Jugador.class.toString(), mapObjectsToCallSequence, mapMethodsToSymbols, regularExpression, matcher, true);
		TestingCore.mapClassToTestingInformation.put(Jugador.class.toString(), ti);
	
}
	
}
