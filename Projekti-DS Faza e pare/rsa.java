import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.Base64;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class rsa {

public static void write(StringBuilder builder, String tag, BigInteger bigInt) throws UnsupportedEncodingException {
    builder.append("\t<");
    builder.append(tag);
    builder.append(">");
    builder.append(encode(bigInt));
    builder.append("</");
    builder.append(tag);
    builder.append(">\n");
}

public static String encode(BigInteger bigInt) throws UnsupportedEncodingException {
	Base64.Encoder encoder = Base64.getEncoder();
    return new String(encoder.encodeToString(bigInt.toByteArray()));
}

public static void krijocels(String emrifajllit) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = keyPairGen.genKeyPair();
    RSAPrivateCrtKey privKey = (RSAPrivateCrtKey) keyPair.getPrivate();
    //RSAPrivateCrtKey pubKey = (RSAPrivateCrtKey) keyPair.getPublic();

    BigInteger n = privKey.getModulus();
    BigInteger e = privKey.getPublicExponent();
    BigInteger d = privKey.getPrivateExponent();
    BigInteger p = privKey.getPrimeP();
    BigInteger q = privKey.getPrimeQ();
    BigInteger dp = privKey.getPrimeExponentP();
    BigInteger dq = privKey.getPrimeExponentQ();
    BigInteger inverseQ = privKey.getCrtCoefficient(); 
    
    BigInteger nP = n;
    BigInteger eP = e;

    StringBuilder builderPriv = new StringBuilder();
    builderPriv.append("<RSAKeyValue>\n");
    write(builderPriv, "Modulus", n);
    write(builderPriv, "Exponent", e);
    write(builderPriv, "P", p);
    write(builderPriv, "Q", q);
    write(builderPriv, "DP", dp);
    write(builderPriv, "DQ", dq);
    write(builderPriv, "InverseQ", inverseQ);
    write(builderPriv, "D", d);
    builderPriv.append("</RSAKeyValue>");
    
    StringBuilder builderPub = new StringBuilder();
    builderPub.append("<RSAKeyValue>\n");
    write(builderPub, "Modulus", nP);
    write(builderPub, "Exponent", eP);
    builderPub.append("</RSAKeyValue>");
	
	File f= new File(emrifajllit+".xml"); 
    File fpub = new File(emrifajllit+".pub.xml");
    try {
		if(f.createNewFile() && fpub.createNewFile()) {
			PrintWriter output = new PrintWriter(f);
			PrintWriter outputp = new PrintWriter(fpub);
			output.print(builderPriv);
			outputp.print(builderPub);
			output.close(); outputp.close();
			System.out.println("Eshte krijuar celesi privat "+emrifajllit+".xml");
			System.out.println("Eshte krijuar celesi publik "+emrifajllit+".pub.xml");
		}
		else System.out.println("Gabim. Fajlli ekziston paraprakisht.");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}
public static void shfaqpub(String emrifajllit) {
	if(new File(emrifajllit+".pub.xml").exists()) {
		
	System.out.println("Celsat:");
	 
    Scanner lexo = null;
	try {
		lexo = new Scanner(new File(emrifajllit+".pub.xml"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(lexo.hasNextLine()) {
    	String permbajtja = lexo.nextLine();
    	System.out.println(permbajtja);
    }
}
	else
		System.out.println("Gabim: Celesi publik '"+emrifajllit+"' nuk ekziston.");
	}


public static void shfaqpriv(String emrifajllit) {
	if(new File(emrifajllit+".xml").exists()) {
		
	System.out.println("Celsat:");
	 
    Scanner lexo = null;
	try {
		lexo = new Scanner(new File(emrifajllit+".xml"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(lexo.hasNextLine()) {
    	String permbajtja = lexo.nextLine();
    	System.out.println(permbajtja);
    }
}
	else
		System.out.println("Gabim: Celesi privat '"+emrifajllit+"' nuk ekziston.");
	}

public static void moveFilepriv(String sourcePath, String targetPath) {
    File fileToMove = new File(sourcePath+".xml");
    fileToMove.renameTo(new File(targetPath));
    System.out.println("Celesi privat u ruajt ne fajllin: "+targetPath);
}

public static void moveFilepub(String sourcePath, String targetPath) {
    File fileToMove = new File(sourcePath+".pub.xml");
    fileToMove.renameTo(new File(targetPath));
    System.out.print("Celesi publik u ruajt ne fajllin: "+targetPath);
}


public static void delete(String emrifajllit) {
	if(new File(emrifajllit+".xml").exists() && new File(emrifajllit+".pub.xml").exists()) {
	    
    	if(new File(emrifajllit+".xml").delete() && new File(emrifajllit+".pub.xml").delete()) {
    		System.out.println("Eshte larguar celesi privat '"+emrifajllit+".xml'");
    		System.out.println("Eshte larguar celesi publik '"+emrifajllit+".pub.xml'");
    	} else
        { 
            System.out.println("Failed to delete the file"); 
        } 
    	}
	else if(new File(emrifajllit+".xml").exists()) {
		System.out.println("Eshte larguar celesi privat '"+emrifajllit+".xml");
	}
	else if(new File(emrifajllit+".xml").exists()) {
		System.out.println("Eshte larguar celesi publik '"+emrifajllit+".pub.xml");
	}
    else {
    	System.out.println("Celesi '"+emrifajllit+"' nuk ekziston");
    }
}
	
}


