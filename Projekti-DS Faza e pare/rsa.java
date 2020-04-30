import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class rsa {

public static void importo(String kuimportohet,String ngaimportohet) throws SAXException, IOException, ParserConfigurationException {
		
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
		
		
	if(new File("keys/"+kuimportohet+".xml").exists() && new File("keys/"+kuimportohet+".pub.xml").exists()){
            System.out.println("Gabim: Celesi "+kuimportohet+" ekziston paraprakisht.");			
	}
		
	else if(ngaimportohet.startsWith("http://")||ngaimportohet.startsWith("https://")) {
		URL url; //referenca https://mkyong.com/java/how-to-get-url-content-in-java/

		try {
			// get URL content
			url = new URL(ngaimportohet);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;

				
			File file = new File("keys/"+kuimportohet+".pub.xml");

			if (!file.exists()) {
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Celesi publik u ruajt ne fajllin 'keys/"+kuimportohet+".pub.xml'.");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	else if(!ngaimportohet.endsWith(".xml")) {
			System.out.println("Gabim: Fajlli i dhene nuk eshte celes valid.");
	}
		
	else {
		File from = new File (ngaimportohet);
		Document document = builder.parse(from);
		Element rootElement = document.getDocumentElement();
		if (rootElement.getChildNodes().getLength()>5) {
				
				
			NodeList modulus = document.getElementsByTagName("Modulus");
			NodeList exponent = document.getElementsByTagName("Exponent");
			String permbajtjam = modulus.item(0).getTextContent();
			String permbajtjae = exponent.item(0).getTextContent();
			try {
			    
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement1 = doc.createElement("RSAKeyValue");
			doc.appendChild(rootElement1);

			// child elements
			Element firstname = doc.createElement("Modulus");
			firstname.appendChild(doc.createTextNode(permbajtjam));
			rootElement1.appendChild(firstname);

				
			Element lastname = doc.createElement("Exponent");
			lastname.appendChild(doc.createTextNode(permbajtjae));
			rootElement1.appendChild(lastname);
				
			// Transform XML Document to String and write the content into xml file 
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("keys/"+kuimportohet+".pub.xml"));

			transformer.transform(source, result);
			   
			}
			catch (ParserConfigurationException pce) {
				pce.printStackTrace();
				} catch (TransformerException tfe) {
				tfe.printStackTrace();
				}
				
				
			from.renameTo(new File("keys/"+kuimportohet+".xml"));
			System.out.println("Celesi publik u ruajt ne fajllin 'keys/"+kuimportohet+".xml'.");
			System.out.println("Celesi publik u ruajt ne fajllin 'keys/"+kuimportohet+".pub.xml'.");
				
		}
		else  {
			from.renameTo(new File("keys/"+kuimportohet+".pub.xml"));
			System.out.println("Celesi publik u ruajt ne fajllin 'keys/"+kuimportohet+".pub.xml'.");
		}
	}
		
		
}

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
	
    File f= new File("keys/"+emrifajllit+".xml"); 
    File fpub = new File("keys/"+emrifajllit+".pub.xml");
    try {
		if(f.createNewFile() && fpub.createNewFile()) {
			PrintWriter output = new PrintWriter(f);
			PrintWriter outputp = new PrintWriter(fpub);
			output.print(builderPriv);
			outputp.print(builderPub);
			output.close(); outputp.close();
			System.out.println("Eshte krijuar celesi privat keys/"+emrifajllit+".xml");
			System.out.println("Eshte krijuar celesi publik keys/"+emrifajllit+".pub.xml");
		}
		else System.out.println("Gabim. Fajlli ekziston paraprakisht.");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}
public static String shfaqpub(String emrifajllit) {
	String permbajtja="";
	if(new File("keys/"+emrifajllit+".pub.xml").exists()) {
		
	System.out.println("Celsat:");
	 
    Scanner lexo = null;
	try {
		lexo = new Scanner(new File("keys/"+emrifajllit+".pub.xml"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(lexo.hasNextLine()) {
    	permbajtja += lexo.nextLine();
    	permbajtja += "\n";
    	//return permbajtja;
    }
}
	else
		permbajtja = "Gabim: Celesi publik '"+emrifajllit+"' nuk ekziston.";
	return permbajtja;
	}


public static String shfaqpriv(String emrifajllit) {
    String permbajtja="";
	if(new File("keys/"+emrifajllit+".xml").exists()) {
		
	System.out.println("Celsat:");
	 
    Scanner lexo = null;
	try {
		lexo = new Scanner(new File("keys/"+emrifajllit+".xml"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(lexo.hasNextLine()) {
    	permbajtja += lexo.nextLine();
    	permbajtja += "\n";
    }
}
	else
		permbajtja = "Gabim: Celesi privat '"+emrifajllit+"' nuk ekziston.";
	return permbajtja;

	}

public static void exportpriv(String sourcePath, String targetPath) {
	if (new File("keys/"+sourcePath+".xml").exists()) {
		File fileToMove = new File("keys/"+sourcePath+".xml");
	    fileToMove.renameTo(new File(targetPath));
	    System.out.println("Celesi privat u ruajt ne fajllin: "+targetPath);
	}
	else 
		System.out.println("Gabim: Celesi privat '"+sourcePath+"' nuk ekziston.");
}

public static void exportpub(String sourcePath, String targetPath) {
	if (new File("keys/"+sourcePath+".pub.xml").exists()) {
		File fileToMove = new File("keys/"+sourcePath+".pub.xml");
	    fileToMove.renameTo(new File(targetPath));
	    System.out.print("Celesi publik u ruajt ne fajllin: "+targetPath);
	}
	else 
		System.out.println("Gabim: Celesi publik '"+sourcePath+"' nuk ekziston.");
}


public static void delete(String emrifajllit) {
	if(new File("keys/"+emrifajllit+".xml").exists() && new File("keys/"+emrifajllit+".pub.xml").exists()) {
	    
    	if(new File("keys/"+emrifajllit+".xml").delete() && new File("keys/"+emrifajllit+".pub.xml").delete()) {
    		System.out.println("Eshte larguar celesi privat 'keys/"+emrifajllit+".xml'");
    		System.out.println("Eshte larguar celesi publik 'keys/"+emrifajllit+".pub.xml'");
    	} else
        { 
            System.out.println("Failed to delete the file"); 
        } 	
	}
	else if(new File("keys/"+emrifajllit+".xml").exists()) {
		if(new File("keys/"+emrifajllit+".xml").delete()) {
			System.out.println("Eshte larguar celesi privat 'keys/"+emrifajllit+".xml");
			}
		else System.out.println("Deshtuam ta largojme celsin '"+emrifajllit+"'");
	}
	else if(new File("keys/"+emrifajllit+".pub.xml").exists()) {
		if(new File("keys/"+emrifajllit+".pub.xml").delete()) {
		System.out.println("Eshte larguar celesi publik 'keys/"+emrifajllit+".pub.xml");
		}
		else System.out.println("Deshtuam ta largojme celsin '"+emrifajllit+"'");
	}
    else {
    	System.out.println("Celesi '"+emrifajllit+"' nuk ekziston");
    }
}

public static void writemessage(String emri,String teksti,String fajlli) throws Exception  {
	// --> /https://www.codota.com/code/java/classes/java.security.spec.RSAPublicKeySpec
	if (!new File("keys/"+emri+".pub.xml").exists()) {
		System.out.println("Gabim: Celesi publik '"+emri+"' nuk ekziston.");
	}
	else {
		Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
		
		KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
				
		SecretKey key = keygenerator.generateKey();
		
		byte[] a = new byte[8];
		new Random().nextBytes(a);
		IvParameterSpec iv = new IvParameterSpec(a);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
	    File xmlProductFile = new File("keys/" + emri + ".pub.xml");
		
		Document document = builder.parse(xmlProductFile);
		
		NodeList modulus = document.getElementsByTagName("Modulus");
	    NodeList exponent = document.getElementsByTagName("Exponent");
	    
	    String permbajtjam = modulus.item(0).getTextContent();
	    String permbajtjae = exponent.item(0).getTextContent();

	    byte[] modBytes = Base64.getDecoder().decode(permbajtjam.getBytes());
	    byte[] expBytes = Base64.getDecoder().decode(permbajtjae.getBytes());
        
	    BigInteger modules1 = new BigInteger(1,modBytes);
	    BigInteger exponent1 = new BigInteger(1,expBytes);

	    KeyFactory factory1 = KeyFactory.getInstance("RSA");
	    Cipher cipher1 = Cipher.getInstance("RSA");
	    
	    RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(modules1, exponent1);
	    PublicKey pubKey = factory1.generatePublic(pubSpec);
	    cipher1.init(Cipher.ENCRYPT_MODE, pubKey);
	    
	    byte[] encrypted = cipher1.doFinal(key.getEncoded());
	    
		String part1 = Base64.getEncoder().encodeToString(emri.getBytes("UTF-8"));
		String part2 = Base64.getEncoder().encodeToString(a);
	    String part3 = Base64.getEncoder().encodeToString(encrypted);
		String part4 = desEncryption(teksti,key,iv,c);
		
	    String ciphertext = (part1+"."+part2+"."+part3+"."+part4);
	    
	    if (fajlli==null) {
	    	System.out.println(ciphertext);
		    }
	    else {
	    	File f = new File(fajlli);
	    	PrintWriter shkruaj = new PrintWriter(f);
	    	shkruaj.print(ciphertext);
	    	shkruaj.close();
	    	System.out.println("Mesazhi i enkriptuar u ruajt ne fajllin '"+fajlli+"'.");
	    }		    
	}	    
}

public static void readmessage(String ciphert_fajll) throws Exception {
	
	String permbajtja = "";
	String part1 = "";
	String part2 = "";
	String part3 = "";
	String part4 = "";
	
	Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
	Scanner lexo = null;
	if(ciphert_fajll.endsWith(".txt")) {
		
		File fajll = new File(ciphert_fajll);
		lexo = new Scanner(fajll);
		while(lexo.hasNext()) {
	    	permbajtja += lexo.nextLine();
	    	
	    }
		part1 = permbajtja.split("\\.")[0];
		part2 = permbajtja.split("\\.")[1];
		part3 = permbajtja.split("\\.")[2];
		part4 = permbajtja.split("\\.")[3];
	}
	else {
		part1 = ciphert_fajll.split("\\.")[0];
		part2 = ciphert_fajll.split("\\.")[1];
		part3 = ciphert_fajll.split("\\.")[2];
		part4 = ciphert_fajll.split("\\.")[3];
	}
	
	String emri = new String(Base64.getDecoder().decode(part1));
	
	if (!new File("keys/"+emri+".xml").exists()) {
		System.out.println("Celesi privat 'keys/"+emri+".xml' nuk ekziston");
	}
	else {
		byte[] i = Base64.getDecoder().decode(part2);
		IvParameterSpec iv = new IvParameterSpec(i);
				
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
	    File xmlProductFile = new File("keys/" + emri + ".xml");
		
		Document document = builder.parse(xmlProductFile);
			   
		NodeList modulus = document.getElementsByTagName("Modulus");
	    NodeList D = document.getElementsByTagName("D");
	    String permbajtjam = modulus.item(0).getTextContent();
	    String permbajtjad = D.item(0).getTextContent();
	    
	    byte[] modBytes = Base64.getDecoder().decode(permbajtjam);
	    byte[] dBytes = Base64.getDecoder().decode(permbajtjad);
	    
	    BigInteger modules1 = new BigInteger(1, modBytes);
	    BigInteger d = new BigInteger(1, dBytes);
	   
	    
	    KeyFactory factory1 = KeyFactory.getInstance("RSA");
	    Cipher cipher1 = Cipher.getInstance("RSA");
   
	    RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(modules1,d);
	    PrivateKey privKey = factory1.generatePrivate(privSpec);
	    cipher1.init(Cipher.DECRYPT_MODE, privKey);
	    byte[] decryptedkey = cipher1.doFinal(Base64.getDecoder().decode(part3));
	    SecretKey key = new SecretKeySpec(decryptedkey,"DES");
	    String plaintext = desDecryption(part4,key,iv,c);
	    
	    System.out.println("Marresi: "+emri);
		System.out.println("Mesazhi: "+plaintext);
	}		
	
    
}

public static String desEncryption(String teksti,SecretKey key,IvParameterSpec iv,Cipher c) throws Exception
{	     
     c.init(Cipher.ENCRYPT_MODE, key,iv);
     byte[] text = teksti.getBytes();
     byte[] textEncrypted = c.doFinal(text);
     return Base64.getEncoder().encodeToString(textEncrypted);
}

public static String desDecryption(String ciphertext,SecretKey key,IvParameterSpec iv,Cipher c)throws Exception
{
     c.init(Cipher.DECRYPT_MODE, key,iv);
     byte[] textDecrypted = c.doFinal(Base64.getDecoder().decode(ciphertext));
     return(new String(textDecrypted));
}
	
}


