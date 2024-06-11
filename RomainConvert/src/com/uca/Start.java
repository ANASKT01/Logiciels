package com.uca;

public class Start{
	
	//Start class
	public static void main(String[] args){
		
		RomanNumber roman = new RomanNumber("IV");
		System.out.println(roman.getValue());
		System.out.println(roman.getRoman());
		

		System.out.println(RomanConverter.getRomanFromNumber(4));
		System.out.println(RomanConverter.getNumberFromRoman("DC"));
		//System.out.println(RomanConverter.getRomanFromNumber(-2));
		//System.out.println(RomanConverter.getRomanFromNumber(0));
		//System.out.println(RomanConverter.getNumberFromRoman("-3"));
		//System.out.println(RomanConverter.getRomanFromNumber(-400));
		

		//TODO
		//Aide pour démarrer : https://git.artheriom.fr/l3-informatique-2020-2021/site-l3/-/tree/master/Genie_Logiciel/HelperTP3
		//Aussi : https://www.youtube.com/watch?v=567_hWQJYak
	}
	
}