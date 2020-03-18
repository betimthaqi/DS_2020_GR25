
import java.util.Scanner;

public class ds{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		switch(args[0]) {
		
		case "numerical":
			switch(args[1]) {
			case "encode":encode(args[2]);break;
			case "decode":decode(args[2]);break;		
		}
		case "case":
			switch(args[1]) {
			case "lower":lowercase(args[2]);break;
			case "upper":uppercase(args[2]);break;
			case "capitalize":capitalize(args[2]);break;
			case "inverse":inverse(args[2]);break;
			case "alternating":alternating(args[2]);break;
			case "sentence":sentence(args[2]);break;
			}
		case "vigenere":
			switch(args[1]) {
			case "encrypt":{
				String key= generateKey(args[3],args[2]);
				System.out.println(cipherText(key,args[3]));
			}
			case "decrypt":{
				String key= generateKey(args[3],args[2]);
				System.out.println(originalText(key,args[3]));
			}
			}
			
		}
			
	}
		
	public static void encode(String plaintext) {

			plaintext=plaintext.toLowerCase();
			plaintext=plaintext.replaceAll(" ", "");
			
		for(int i=0;i<plaintext.length();i++) 
		{	
			int number=(int)plaintext.charAt(i)-'a'+1;
			System.out.print(number+" ");
		}
	}
	
	public static void decode(String ciphertext) 
	{
			String[] nr = ciphertext.split(" ");
		        for(String s:nr){
			int a=Integer.parseInt(s);
			char c=(char)(a+'a'-1);
	          	System.out.print(c);
		}
}
			
			
		
		 public static void lowercase(String sL) {
		        String sLL = sL.toLowerCase();
		        System.out.println(sLL);
		    }
		 
		 public static void uppercase(String sU) {
		        String sUU = sU.toUpperCase();
		        System.out.println(sUU);
		    }
		    
		 
		 public static void capitalize(String sC) {
		        String upper_case_line = "";
		        Scanner lineScan = new Scanner(sC);
		        while(lineScan.hasNext()) {
		            String word = lineScan.next();
		            upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
		        }
		        System.out.println(upper_case_line.trim());
		        lineScan.close();
		    }
		    
		   public static void inverse(String str) {
			
			  char[] charArray = str.toCharArray();
		        
			  for(int i=0; i < charArray.length; i++){
		            
		            if( Character.isUpperCase(charArray[i]) ){
		                
		                charArray[i] = Character.toLowerCase( charArray[i] );
		                
		            }else if(Character.isLowerCase(charArray[i]) ){
		                
		                charArray[i] = Character.toUpperCase( charArray[i] );
		            }    
		            
			  }
		        str = new String(charArray);
		        System.out.println(str);
		 }
		    
		    public static void alternating(String sA) {
		        String sL = sA.toLowerCase();
		        String sU = sA.toUpperCase();
		        for(int i = 0 ; i < sA.length() ; i++){
		            if(i % 2 == 0)
		            System.out.print(sL.charAt(i));
		        else
		        System.out.print(sU.charAt(i));
		    }}
		        
		    public static void sentence(String string) {
		        char[] chars = string.toLowerCase().toCharArray();
		        boolean found = false;
		        for (int i = 0; i < chars.length; i++) {
		            if (!found && Character.isLetter(chars[i])) {
		                chars[i] = Character.toUpperCase(chars[i]);
		                found = true;
		            } else if (chars[i]=='.'|| chars[i]==',' || chars[i]=='\'' || chars[i]=='?' || chars[i]=='!') { 
		            	// You can add other chars here
		                found = false;
		            }
		        }
		        System.out.println(String.valueOf(chars));
		    }

		    
		    
		    public static String cipherText(String key, String str) 
			{ 
			    String cipher_text=""; 
			  
			    for (int i = 0, j=0; i < str.length(); i++) 
			    { 
			    	 if(str.charAt(i)==' ') {
			    		
			    		 cipher_text+=" ";
			    		 continue;
			    		//cipher_text+=str.charAt(i);
			    	} 	    	
			    	else if(str.charAt(i)>='a' && str.charAt(i)<='z') {

			    		
			    		int x = (Character.toUpperCase(str.charAt(i)) + Character.toUpperCase(key.charAt(j))) %26; 
			    		  
				        // convert into alphabets(ASCII) 
				        x += 'A'; 
				        cipher_text+=Character.toLowerCase((char)(x));
				        j++;
			    	}
			    	else if(str.charAt(i)>='A' && str.charAt(i)<='Z') 
			    	{
			    	
			        // converting in range 0-25 
			        int x = (str.charAt(i) + Character.toUpperCase(key.charAt(j))) %26; 
			  
			        // convert into alphabets(ASCII) 
			        x += 'A'; 
			        cipher_text+=(char)(x); 
			        j++;
			    
			    	}
			    }
			    return cipher_text; 
			} 
		    
		    public static String originalText(String key, String cipher_text) 
			{ 
			    String orig_text=""; 
			  
			    for (int i = 0,j=0 ; i < cipher_text.length(); i++) 
			    { 
			    	if(cipher_text.charAt(i)==' ') {
			    		orig_text+=" ";
			    		continue;
			    	}
			    	else if(cipher_text.charAt(i)>='A' && cipher_text.charAt(i)<='Z') {
			        // converting in range 0-25 
			        int x = (cipher_text.charAt(i) -  
			        		Character.toUpperCase(key.charAt(j)) + 26) %26; 
			  
			        // convert into alphabets(ASCII) 
			        x += 'A'; 
			        orig_text+=(char)(x); 
			        j++;
			    }
			    	else if(cipher_text.charAt(i)>='a' && cipher_text.charAt(i)<='z') {
			    		 
			    		int x = (Character.toUpperCase(cipher_text.charAt(i)) -  
			 	        		Character.toUpperCase(key.charAt(j)) + 26) %26; 
			        
			    		// convert into alphabets(ASCII) 
			    		x += 'A'; 
			    		orig_text+=Character.toLowerCase((char)(x)); 
			    		j++;	
			    	
			    	}
			    	
			    }
			    return orig_text; 
			}
		    
		    public static String generateKey(String str, String key) 
			{ 	  
			    for (int i = 0; ; i++) 
			    { 
			    	 if (key.length() == str.length()) 
			            break; 
			        key+=(key.charAt(i)); 
			    } 
			    return key; 
			}

}


