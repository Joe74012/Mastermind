package MastermindPackage.Mastermind;

//ArrayList Import
import java.util.ArrayList;

import java.util.Scanner;

public class Mastermind2
{
    public static void main(String[] args)
    {
	// Deze worden gebreukt om het spel te laten herhalen als de speler opnieuw
	// speelt
	boolean RepeatFullGame = true, RepeatGame = true;
	// De scanner is voor input
	Scanner sc = new Scanner(System.in);
	int Punten = 0;
	// Het spel herhaalt als repeatgame true is
	while (RepeatFullGame == true)
	{
	    // De functies
	    MethodeFunctions mf = new MethodeFunctions();
	    String Instructie = mf.Instructies("w");
	    String PinInstructies = mf.PinInstructies("w");
	    String test;
	    String RuimteMaker = mf.RuimteMaker("w");
	    // Als de speler verliest kunnen ze niet opdezelfe ronde winnen
	    boolean verlorenSlot = false;
	    ArrayList<Byte> ComputerNummers = new ArrayList<>(5);
	    ArrayList<String> ComputerKleuren = new ArrayList<>();
	    ArrayList<String> SpelerKleuren = new ArrayList<>();
	    boolean PinSlot[] = new boolean[5];
	    byte HintGenerator[] = new byte[1];
	    String WilHint;
	    String WilspelHerhalen;
	    byte ZwartePinnen = 0;
	    byte WittePinnen = 0;
	    byte Rondes = 10;
	    // Repeatfullgame wordt naar false gezet zodat hij niet blijft herhalen
	    RepeatFullGame = false;
	    // 5 random getallen gegenereerd
	    for (int i = 0; i < 5; i++)
	    {
		ComputerNummers.add((byte) ((Math.random() * 6) + 1));
	    }

	    for (int i = 0; i < ComputerNummers.size(); i++)
	    {
		switch (ComputerNummers.get(i))
		{
		    // Getal naar kleur
		    case 1:
			ComputerKleuren.add("Groen");
			break;
		    case 2:
			ComputerKleuren.add("Rood");
			break;
		    case 3:
			ComputerKleuren.add("Paars");
			break;
		    case 4:
			ComputerKleuren.add("Geel");
			break;
		    case 5:
			ComputerKleuren.add("Bruin");
			break;
		    case 6:
			ComputerKleuren.add("Blauw");
			break;
		}
	    }
	    RepeatGame = true;
	    // Spel herhaalt
	    while (RepeatGame == true)
	    {
		RepeatGame = false;
		// De spel regels worden uitgelegt aan de speler
		System.out.println(Instructie);
		if (Rondes < 10)
		{
		    // Uitleg na de eerste ronde
		    System.out.println(PinInstructies);
		    System.out.println("Aantal Witte pinnen: " + WittePinnen + "!");
		    System.out.println("Aantal Zwarte pinnen: " + ZwartePinnen + "!");
		    System.out.println("Vorige Ronde: " + SpelerKleuren + "!");
		    System.out.println("Heb je een hint nodig? Ja/Nee.");
		    System.out.println("Een hint kost 50 punten!");
		    System.out.println("Jij hebt " + Punten + " punten!");
		    // Wilhint is gelijk aan de invoer van de speler
		    WilHint = sc.next();
		    if (WilHint.equalsIgnoreCase("ja"))
		    {
			// Kijkt of de speler meer dan 50 punten heeft om de hint te krijgen
			if (Punten >= 50)
			{
			    Punten -= 50;
			    // De aantal punten die de speler nog heeft
			    System.out.println("Jij hebt nu nog " + Punten + " punten!");
			    // Hier wordt een hint gegenereerd van 1 tot 6
			    HintGenerator[0] = (byte) ((Math.random() * 6) + 1);
			    if (HintGenerator[0] == 1)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    if (HintGenerator[0] == 2)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    if (HintGenerator[0] == 3)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    if (HintGenerator[0] == 4)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    if (HintGenerator[0] == 5)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    if (HintGenerator[0] == 6)
			    {
				System.out.println("de eerste kleur is: " + ComputerKleuren.get(0));
			    }
			    System.out.println(Instructie);
			}
			else
			{
			    // Meer ruimte
			    System.out.println(RuimteMaker);
			    // Speler heeft niet genoeg punten
			    System.out.println("Je hebt niet genoeg punten!");
			    System.out.println("Vorige Ronde: " + SpelerKleuren + "!");
			    System.out.println(Instructie);
			}
		    }
		    else
		    {
			// Ruimte maken
			System.out.println(RuimteMaker);
			System.out.println("Je wil geen hint!");
			System.out.println("Vorige Ronde: " + SpelerKleuren + "!");
			SpelerKleuren.removeAll(SpelerKleuren);
			System.out.println(Instructie);
		    }
		}
		// Laat de speler de kleuren 5 keer typen
		for (int i = 0; i < 5; i++)
		{
		    SpelerKleuren.add(sc.next());
		}	
		// Naar 0 gezet zodat elke ronde nieuwe zwarte pinnen
		ZwartePinnen = 0;
		for (int i = 0; i < 5; i++)
		{
		    // Als de eerste speler keuze gelijk is aan de eerste kleur van de computer
		    if (SpelerKleuren.get(i).equalsIgnoreCase(ComputerKleuren.get(i)))
		    {
			// Dan krijgt de speler 1 zwarte pin en 5 punten
			ZwartePinnen++;
			Punten += 5;
			PinSlot[i] = true;
		    }
		}
		// Als pinslot false is
		if (PinSlot[0] == false)
		{
		    // De kleuren vergelijken met de goede kleuren op de verkeerde plek
		    if (SpelerKleuren.get(0).equalsIgnoreCase(ComputerKleuren.get(1)) || SpelerKleuren.get(0).equalsIgnoreCase(ComputerKleuren.get(2)) || SpelerKleuren.get(0).equalsIgnoreCase(ComputerKleuren.get(3)) || SpelerKleuren.get(0).equalsIgnoreCase(ComputerKleuren.get(4)))
		    {
			WittePinnen++;
		    }
		}
		if (PinSlot[1] == false)
		{
		    if (SpelerKleuren.get(1).equalsIgnoreCase(ComputerKleuren.get(0)) || SpelerKleuren.get(1).equalsIgnoreCase(ComputerKleuren.get(2)) || SpelerKleuren.get(1).equalsIgnoreCase(ComputerKleuren.get(3)) || SpelerKleuren.get(1).equalsIgnoreCase(ComputerKleuren.get(4)))
		    {
			WittePinnen++;
		    }
		}
		if (PinSlot[2] == false)
		{
		    if (SpelerKleuren.get(2).equalsIgnoreCase(ComputerKleuren.get(0)) || SpelerKleuren.get(2).equalsIgnoreCase(ComputerKleuren.get(1)) || SpelerKleuren.get(2).equalsIgnoreCase(ComputerKleuren.get(3)) || SpelerKleuren.get(2).equalsIgnoreCase(ComputerKleuren.get(4)))
		    {
			WittePinnen++;
		    }
		}
		if (PinSlot[3] == false)
		{
		    if (SpelerKleuren.get(3).equalsIgnoreCase(ComputerKleuren.get(0)) || SpelerKleuren.get(3).equalsIgnoreCase(ComputerKleuren.get(1)) || SpelerKleuren.get(3).equalsIgnoreCase(ComputerKleuren.get(2)) || SpelerKleuren.get(3).equalsIgnoreCase(ComputerKleuren.get(4)))
		    {
			WittePinnen++;
		    }
		}
		if (PinSlot[4] == false)
		{
		    if (SpelerKleuren.get(4).equalsIgnoreCase(ComputerKleuren.get(0)) || SpelerKleuren.get(4).equalsIgnoreCase(ComputerKleuren.get(1)) || SpelerKleuren.get(4).equalsIgnoreCase(ComputerKleuren.get(2)) || SpelerKleuren.get(4).equalsIgnoreCase(ComputerKleuren.get(3)))
		    {
			WittePinnen++;
		    }
		}
		Rondes--;
		// Als de rondes minder of gelijk zijn aan 0
		if (Rondes <= 0)
		{
		    // Speler kan niet meer winnen
		    verlorenSlot = true;
		    System.out.println("Je hebt het spel verloren omdat er geen rondes meer over zijn!");
		    System.out.println("Je hebt 100 punten verloren!");
		    Punten -= 100;
		    System.out.println("Wil je het spel opnieuw spelen? Ja/nee.");
		    WilspelHerhalen = sc.next();
		    // Als de speler ja zegt
		    if (WilspelHerhalen.equalsIgnoreCase("Ja"))
		    {
			// Zet rondes naar 10 zodat de speler het spel opnieuw kan spelen
			Rondes = 10;
			// Ruimte maken
			System.out.println(RuimteMaker);
			// Repeatfullgame naar true zodat het spel herhaalt
			RepeatFullGame = true;
		    }
		    else
		    {
			RepeatFullGame = false;
			// De console wordt gesloten
			sc.close();
		    }
		}
		// Als alle speler kleuren en computer kleuren gelijk zijn dan wint de speler
		if (ComputerKleuren.get(0).equalsIgnoreCase(SpelerKleuren.get(0)) && ComputerKleuren.get(1).equalsIgnoreCase(SpelerKleuren.get(1)) && ComputerKleuren.get(2).equalsIgnoreCase(SpelerKleuren.get(2)) && ComputerKleuren.get(3).equalsIgnoreCase(SpelerKleuren.get(3))
			&& ComputerKleuren.get(4).equalsIgnoreCase(SpelerKleuren.get(4)) && verlorenSlot == false)
		{
		    // Je hebt gewonnen uitleg
		    System.out.println("Je hebt het spel gewonnnen door alle kleuren goed te raden!");
		    System.out.println("Je hebt 100 punten verdient!");
		    SpelerKleuren = null;
		    Punten += 100;
		    System.out.println("Wil je het spel opnieuw spelen? Ja/nee.");
		    WilspelHerhalen = sc.next();
		    // Als de speler ja zegt dan
		    if (WilspelHerhalen.equalsIgnoreCase("Ja"))
		    {
			// Zet rondes naar 10 zodat de speler het spel opnieuw kan spelen
			Rondes = 10;
			// Ruimte maken
			System.out.println(RuimteMaker);
			RepeatFullGame = true;
		    }
		    else
		    {
			RepeatFullGame = false;
			sc.close();
		    }
		}
		else
		{
		    RepeatFullGame = false;
		    RepeatGame = true;
		    // Ruimte maken
		    System.out.println(RuimteMaker);
		    System.out.println("Je hebt nog " + Rondes + " rondes!");
		}
	    }
	}
    }
}
