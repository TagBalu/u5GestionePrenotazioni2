package vacislavbaluyev.u5GestionePrenotazioni.tools;

import io.jsonwebtoken.security.Keys;
import lombok.Value;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;

import java.util.Date;

@Component
public class JWWTools {
    @Value("${jwt.secret}")
    private String secret;

    public String createToken (dipendente dipendente ){return Jwts.builder()
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
            .subject(String.valueOf(dipendente.getId())) //
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .compact();
    }
    public void verifyToken(String accesToken){
    }
}
