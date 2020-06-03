

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.*;

public class Token {


	public static String kthetoken(String emri) throws Exception{

		Instant now = Instant.now();

		String jwt = Jwts.builder()
				.setSubject(emri)
				.setAudience("Studentet")
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(20, ChronoUnit.MINUTES)))
				.signWith(rsa.rsaprivat(emri))
				.compact();

		return jwt;

	}

	public static void status(String jwt) {

		Jws<Claims> result = null;
		try {
			int i = jwt.lastIndexOf('.');
			String panenshkrim = jwt.substring(0, i + 1);
			@SuppressWarnings("rawtypes")
			Jwt<Header , Claims> tIpabesueshem = Jwts.parser().parseClaimsJwt(panenshkrim);
			String emri = tIpabesueshem.getBody().getSubject();

			result = Jwts.parser()
					.setSigningKey(rsa.rsapublik(emri))
					.parseClaimsJws(jwt);
			
			
			System.out.println("Shfrytezuesi: " + result.getBody().getSubject());
			System.out.println("Valid: po");
			System.out.println("Skadimi: " + result.getBody().getExpiration());


		}
		catch(Exception e) {
			System.out.println("Tokeni nuk eshte valid");
		}
	}


	public static String return_sender(String jwt) {
		Jws<Claims> result = null;
		String sender = "";
		try {
			int i = jwt.lastIndexOf('.');
			String panenshkrim = jwt.substring(0, i + 1);
			@SuppressWarnings("rawtypes")
			Jwt<Header , Claims> tIpabesueshem = Jwts.parser().parseClaimsJwt(panenshkrim);
			String emri = tIpabesueshem.getBody().getSubject(); //sherben per nenshkrim (e gjen qelsin e rsa ne baze te emrit)

			result = Jwts.parser()
					.setSigningKey(rsa.rsapublik(emri))
					.parseClaimsJws(jwt);
			sender = result.getBody().getSubject();
			
		}
		catch(Exception e) {
			
		}
		return sender;
	}






}
