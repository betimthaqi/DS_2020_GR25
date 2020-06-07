
public class ds {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub


try {
		switch(args[0]) {
		
		case "numerical":
			switch(args[1]) {
			case "encode":
				switch(args[2]){
                   case "--separator":Numerical.separator(args[3],args[4]);break; 
				   default:  Numerical.encode(args[2]);break;
				}break;				
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
		case "create-user":
		    LetsEncrypt.krijocels(args[1]);break;
		case "delete-user":
			{LetsEncrypt.delete(args[1]);Login.deleteuser(args[1]);}break;
		case "login":
		    Login.login(args[1]);break;
			case "export-key":
				if(args.length==3) {
					switch(args[1]) {
					case "public":System.out.println(LetsEncrypt.shfaqpub(args[2]));break;
					case "private":System.out.println(LetsEncrypt.shfaqpriv(args[2]));break;
					default:System.out.println("Gabim. Argumenti i dyte duhet te jete <public|private> ");
					}
				}
				else if(args.length==4) {
					switch(args[1]) {
					case "public":LetsEncrypt.exportpub(args[2],args[3]);break;
					case "private":LetsEncrypt.exportpriv(args[2],args[3]);break;
					default:System.out.println("Gabim. Argumenti i dyte duhet te jete <public|private> ");
					}
				}
				else{
				     System.out.println("Formati i kerkuar: export-key <public|private> <name> [file/opsional]");
				}break;
		case "import-key":
				LetsEncrypt.importo(args[1], args[2]);break;
		case "write-message":
			if(args.length==3) {
				rsa.writemessage(args[1], args[2],null,null);
			}else if(args.length==4){
				if(args[3].equals("--sender")) {
					System.out.println("Pas opsionit '--sender' duhet te caktoni edhe tokenin ");
				}else {
					rsa.writemessage(args[1],args[2], args[3],null);
				}				
			}else if(args.length==5){
				if(args[3].equals("--sender")) {
					rsa.writemessage(args[1],args[2], null,args[4]);
					}else {
						System.out.println("Per te caktuar derguesin, komanda duhet te pranoje opsinonin '--sender <token>' ");
					}
				
			}
			else if(args.length==6) {
				if(args[4].equals("--sender")) {
				rsa.writemessage(args[1],args[2], args[3],args[5]);
				}else {
					System.out.println("Per te caktuar derguesin, komanda duhet te pranoje opsinonin '--sender <token>' ");
				}
			}
			else {
			     System.out.println("Formati i kerkuar: write-message <name> <message> [file] [--sender <token>]")
			}break;
		case "read-message":
				LetsEncrypt.readmessage(args[1]);break;

		default:{System.out.println("Argumente jovalide.Argumenti i pare duhet te bej pjese ne vargun { numerical, case, vigenere, create-user, delete-user, export-key, import-key, login, status, write-message, read-message} ");}
			
			
		}
	}
	catch (ArrayIndexOutOfBoundsException e ) { 
		System.out.println ("Mungojne argumente ");
                System.exit(1);
	}	
	}
	}	
