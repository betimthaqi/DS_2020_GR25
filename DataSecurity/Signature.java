

import java.security.InvalidKeyException;
import java.security.Signature;

public class signature {

	
	public static byte[] nenshkrimi(String part4,String sender) throws InvalidKeyException, Exception {
	     
		Signature sign = Signature.getInstance("SHA256withRSA");
		sign.initSign(rsa.rsaprivat(sender));		
		byte[] bytes = part4.getBytes();

		//Adding data to the signature
		sign.update(bytes);
		byte[] signature = sign.sign();

		return signature;

	}
	
	public static boolean verifikimi(byte[] signature,String sender,String part4) throws Exception {
		
		Signature sign = Signature.getInstance("SHA256withRSA");
		byte[] bytes = part4.getBytes();

		sign.initVerify(rsa.rsapublik(sender));
		sign.update(bytes);
		boolean bool = sign.verify(signature);


		return bool;

	}

	

}
