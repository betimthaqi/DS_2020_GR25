
import java.util.Scanner;

public class ds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

try {
		switch(args[0]) {
		
		case "numerical":
			switch(args[1]) {
			case "encode":
				switch(args[2]){
                                   case "--separator":Numerical.separator(args[3],args[4]);break; 
				   default:  Numerical.encode(args[2]);break;
				}
							break;				
			case "decode":Numerical.decode(args[2]);break;
                        default:{
                                 System.out.println("Argumenti i dyte duhet te bej pjese ne vargun {encode,decode}");
                                 System.exit(1);
                                 }
		};break;
		case "case":
			switch(args[1]) {
			case "lower":Case.lowercase(args[2]);break;
			case "upper":Case.uppercase(args[2]);break;
			case "capitalize":Case.capitalize(args[2]);break;
			case "inverse":Case.inverse(args[2]);break;
			case "alternating":Case.alternating(args[2]);break;
                        case "sentence":Case.sentence(args[2]);break;
                        default:System.out.println("Argumenti i dyte duhet te bej pjese ne vargun {lower,upper,capitalize,inverse,alternating,sentence}");
			};break;
		case "vigenere":
			switch(args[1]) {
			case "encrypt":{
				String key= Vigenere.generateKey(args[3],args[2]);
				System.out.println(Vigenere.cipherText(key,args[3]));
			};break;
			case "decrypt":{
				String key= Vigenere.generateKey(args[3],args[2]);
				System.out.println(Vigenere.originalText(key,args[3]));
			};break; 
                        default:System.out.println("Argumenti i dyte duhet te bej pjese ne vargun {encrypt,decrypt}");
			};break;
		default:{System.out.println("Argumente jovalide.Argumenti i pare duhet te bej pjese ne vargun {numerical,case,vigenere} ");}
			
			
		}
	}
	catch (ArrayIndexOutOfBoundsException e ) { 
		System.out.println ("Mungojne argumente ");
                System.exit(1);
	}	
	}
	}	
