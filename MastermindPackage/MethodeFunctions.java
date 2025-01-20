package MastermindPackage;

public class MethodeFunctions
{
    // Maakt een Public String aan met de naam Instructies
    public static String Instructies(String text)
    {
	// Zet de text naar niks
	text = "";
	// Zet de text van de String "Resultaat" naar de instructies
	String Resultaat = "De computer heeft 6 verschillende kleuren gegenereerd, Probeer ze te raden door 5 kleuren te schrijven!\nJe krijgt zwarte pinnen als je het goed hebt geraden!\nJe krijgt Witte pinnen als je de kleur goed hebt geraden maar niet op de goede plek!\nJe kan kiezen uit, Rood, Geel, Paars, Bruin, Blauw en Groen!";
	// Resultaat wordt returned zodat we die kunnen gebruiken in het mastermind
	// bestand
	return Resultaat;
    }

    // Maakt nog een public String van de PinInstructies
    public String PinInstructies(String text)
    {
	// Zet de text naar niks
	text = "";
	// Zet de text van "Resultaat" naar de Instructies van de Pin
	String Resultaat = "Je krijgt zwarte pinnen als je het goed hebt geraden. Je krijgt 5 punten als je een zwarte pin hebt!\nJe krijgt Witte pinnen als je de kleur goed hebt geraden maar niet op de goede plek!";
	// Resultaat wordt returned zodat we die kunnen gebruiken in het mastermind
	// bestand
	return Resultaat;
    }

    public String KleurGenerator(String text)
    {
	// Zet de text naar niks
	text = "";
	// Zet de text van "Resultaat" naar de Instructies van de Pin
	String Resultaat = "Je krijgt zwarte pinnen als je het goed hebt geraden. Je krijgt 5 punten als je een zwarte pin hebt!\nJe krijgt Witte pinnen als je de kleur goed hebt geraden maar niet op de goede plek!";
	// Resultaat wordt returned zodat we die kunnen gebruiken in het mastermind
	// bestand
	return Resultaat;
    }
    
    public String RuimteMaker(String text)
    {
	text = "";
	String Resultaat = "\n";
	for(int i=0; i < 10; i++) {
	   Resultaat += "\n";
	}
	// Resultaat wordt returned zodat we die kunnen gebruiken in het mastermind
	// bestand
	return Resultaat;
    }

}
