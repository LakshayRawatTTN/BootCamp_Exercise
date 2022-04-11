package com.bootcamp.project.ecommerceapplication.utils;

import com.bootcamp.project.ecommerceapplication.constants.JwtConstants;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JwtUtils {
    public static String create(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(JwtConstants.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, JwtConstants.SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JwtConstants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .compact();
    }

    public static Boolean validate(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isExpired(token));
    }


    private static boolean isExpired(String token) {
        final Date expiration = getExpirationDate(token);
        return expiration.before(new Date());
    }

    private static Date getExpirationDate(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    public static <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private static Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(JwtConstants.SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    public static String getUsername(String token) {
        return getClaims(token, Claims::getSubject);
    }


    public static UsernamePasswordAuthenticationToken getAuthentication(final String token, final UserDetails userDetails) {
        final JwtParser jwtParser = Jwts.parser().setSigningKey(JwtConstants.SIGNING_KEY);
        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        final Claims claims = claimsJws.getBody();
        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(JwtConstants.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}
