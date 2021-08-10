package api.security;

import api.domain.KhachHang;
import api.web.rest.vm.LoginVM;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    private final long tokenValidityInMilliseconds = 604800; // 7 days
    private final String key = "nacotiki-secret";

    public JWTToken createToken(LoginVM loginVM) {

        Date validity =  new Date((new Date()).getTime() + this.tokenValidityInMilliseconds);

        String token = Jwts.builder()
                .setSubject(loginVM.getUsername())
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(validity)
                .compact();

        return new JWTToken(token);
    }

    public KhachHang getAuthentication(String authToken) {
        authToken = formatToken(authToken);

        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(authToken)
                .getBody();

        return new KhachHang(claims.getSubject());
    }

    public boolean validateToken(String authToken) {

        authToken = formatToken(authToken);

        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);

            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT signature: " + e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token: " + e);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("JWT token compact of handler are invalid: " + e);
        }

        return false;
    }

    public String formatToken(String authToken) {
        if (authToken.contains("Bearer ")) {
            return authToken.replace("Bearer ", "");
        }

        if (authToken.contains("bearer ")) {
            return authToken.replace("bearer ", "");
        }

        return authToken;
    }

}
