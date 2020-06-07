
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import java.util.HashMap;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Login {
    public static final int iterations = 20*1000;
    public static final int saltLen = 32;
    public static final int desiredKeyLen = 256;



public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        return Base64.getEncoder().encodeToString(salt) + "$" + hash(password, salt);
    }

    
    public static boolean check(String password, String stored) throws Exception{
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "Fjalekalimi i ruajtur duhet te kete formen: 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.getDecoder().decode(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.getEncoder().encodeToString(key.getEncoded());

    }

	 public static void login(String emri) throws Exception {
    	
    			Scanner input = new Scanner(System.in);
    			HashMap<String, String> db = new HashMap<String, String>();

    			
    	        System.out.println("Passwordi:");
    	        String pass = input.nextLine();
    	        input.close();
    	        Scanner lexo = new Scanner(new File("login.txt"));
    	        while(lexo.hasNextLine()) {
    	        	String[] str = lexo.nextLine().split(" ");
    	        	String key = str[0];
    	        	String value = str[1];
    	        	db.put(key, value);
    	             }
    	        lexo.close();
    	        if(db.containsKey(emri)) {
    	        	 boolean verify = check(pass,db.get(emri));
    	             if(verify == true){
    	                 System.out.println(Token.kthetoken(emri));
    	             }else {
    	                 System.out.println("Fjalekalimi i gabuar");
    	             }
    	        }
    	        else {
    	        	System.out.println("Shfrytezuesi me emrin '" + emri + "' nuk ekziston");
    	        }
    }
    
    public static void deleteuser(String emri) throws IOException {
        Scanner input = new Scanner(System.in);
        
		File fajll = new File("login.txt");
        File temp = new File("temp.txt");
        temp.delete();
        temp.createNewFile();
        Scanner lexo = new Scanner(fajll);
        String fillimi = emri + " ";
    	FileWriter p = new FileWriter(temp, true);
        BufferedWriter bw = new BufferedWriter(p);
        PrintWriter pw = new PrintWriter(bw);
        while(lexo.hasNextLine()) {
        	String str = lexo.nextLine();
        	if(str.startsWith(fillimi)) {
        		continue;
        	}
            pw.write(str + "\n");
        }

        lexo.close();
        pw.flush();
        pw.close();
        input.close();
        
        fajll.delete();
        	
        File f2 = new File("login.txt");
        boolean sakt = temp.renameTo(f2);
        if (sakt) {
        	System.out.println("Shfrytezuesi u hoq nga baza e te dhenave");
        }
        else {
        	System.out.println("Shfrytezuesi nuk u hoq nga baza e te dhenave");
        }
    }
    
    
		
    public static String krijouser(String emri) throws Exception {
    	String str = "";
    	Scanner input = new Scanner(System.in);
        System.out.println("Jep passwordin");
        String pass = input.nextLine();
        if(pass.length()<6) {
        	str = "Fjalekalimi duhet te permbaje se paku 6 karaktere";
        }
        else if(!pass.matches("[\\w]+[\\d|\\W]+")) {
			str = "Fjalekalimi duhet te permbaje se paku nje numer ose simbol";
		}else {
					
		System.out.println("Perserit passwordin");
        String pass2 = input.nextLine();
		if(!pass.equals(pass2)){
		    str = "Fjalekalimet nuk perputhen";
		}		
		else {
        String hashi = getSaltedHash(pass);
        
		FileWriter p = new FileWriter(new File("login.txt"), true);
        p.write(emri+" "+hashi+"\n");        
		str = "Eshte krijuar shfrytezuesi '"+emri+"'";
		p.close();
        input.close();
        }
		}
		return str;
    }

}
