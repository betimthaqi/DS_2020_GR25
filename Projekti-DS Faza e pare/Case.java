
import java.util.Scanner;
public class Case {

	public Case(){
		
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
    }
}

            public static void sentence(String string) {
        
    
            	char[] chars = string.toLowerCase().toCharArray();
        
                boolean found = false;

               for (int i = 0; i < chars.length; i++) {
            
 
            	   if (!found && Character.isLetter(chars[i])) 

            	   {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;

            	   } 

            	   else if (chars[i]=='.' || chars[i]=='\'' || chars[i]=='?' || chars[i]=='!') { 
            	 
            		   found = false;
           
}
       
}
        System.out.println(String.valueOf(chars));
    			    }

	
}
