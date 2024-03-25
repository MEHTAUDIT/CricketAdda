package com.ddu.ce.tournament.security.jwt;

import com.ddu.ce.tournament.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.util.Date;

@Component
@CrossOrigin(origins = "http://localhost:5173")
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("=================krisisboss====================")
  private String jwtSecret;

  @Value("86400000")
  private int jwtExpirationMs;

  @Value("jwtCookie")
  private String jwtCookie;

  public String getJwtFromCookies(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
//    Cookie[] cookies = request.getCookies();
//    if (cookies != null) {
//      for (Cookie c : cookies) {
//        System.out.println("cookie: " + c.getName() + " : " + c.getValue());
//      }
//    }
//    else {
//        System.out.println("No cookies");
//    }
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }

  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal , HttpServletResponse response) {
    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
    System.out.println("jwt: " + jwt);
    ResponseCookie responseCookiecookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();

    Cookie cookie = new Cookie(jwtCookie, jwt);
//    cookie.setPath("/api");
    cookie.setMaxAge(24 * 60 * 60);
    cookie.setHttpOnly(true);

    response.addCookie(cookie);
    return responseCookiecookie;
  }

  public ResponseCookie getCleanJwtCookie() {
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
    return cookie;
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
        .parseClaimsJws(token).getBody().getSubject();
  }
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
  
  public String generateTokenFromUsername(String username) {

    return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
              .signWith(key(), SignatureAlgorithm.HS256)
              .compact();
  }
}
