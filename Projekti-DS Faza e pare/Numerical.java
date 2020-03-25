public class Numerical{
              
               public Numerical(){};            

               public static void encode(String plaintext) {

			plaintext=plaintext.toLowerCase();
			plaintext=plaintext.replaceAll(" ", "");
			
			for(int i=0;i<plaintext.length();i++) 
			{				
				int number=(int)plaintext.charAt(i)-'a'+1;
				System.out.print(number+" ");
			}

		}
		 
		public static void decode(String ciphertext) {

				String[] nr = ciphertext.split(" ");
			
			        for(String s:nr) 
	                 {
				int a=Integer.parseInt(s);
				char c=(char)(a+'a'-1);
		          	System.out.print(c);
			}

			}	
	      
        public static void separator(String sep, String string) {
		String s="";
		for(int i=0;i<string.length();i++) 
		{		
			if(Character.isLetter(string.charAt(i))) {
				int number=(int)string.charAt(i)-'a'+1;
				s = s+ String.valueOf(number)+" ";	
			}else {
				s = s + sep.charAt(0)+" ";
		}
			}
		System.out.print(s);
			
}



             

}