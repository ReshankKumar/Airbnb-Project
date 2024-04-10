//package com.jwt;
//
////import io.jsonwebtoken.ExpiredJwtException;
////import io.jsonwebtoken.MalformedJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//@AllArgsConstructor
//@Component
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//    private UserDetailsService userDetailsService;
//    private JwtTokenHelper jwtTokenHelper;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        //1.get Token
//        String requestToken = request.getHeader("Authorization");
//
//        //Token start with bearer
//        //print the token in the console
//        System.out.println(requestToken);
//        //get 2 thing from token
//         String username=null;
//        //---actual token
//         String token=null;
//if(requestToken!=null && requestToken.startsWith("Bearer")){
//     token = requestToken.substring(7);
//     try {
//         username = jwtTokenHelper.getUsernameFromToken(token);
//     }catch(IllegalArgumentException e){
//         System.out.println("unable to get JWt Token");
//     }
//     catch(ExpiredJwtException e){
//         System.out.println("jwt token has Expired");
//     }
//     catch(MalformedJwtException e){
//         System.out.println("invalid Jwt");
//
//     }
//     }else {
//    System.out.println("JWT doesnot start with Bearer");
//     }
////once we get the token ,now validate
//if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
//    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//   if(jwtTokenHelper.validateToken(token,userDetails)){
//       //sahi chal raha hai
//       //authentication karna hai
//       UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//       usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//   }
//   else{
//       System.out.println("invalid jwt Token");
//   }
//}else {
//    System.out.println("username is null or context is not null");
//}
//filterChain.doFilter(request,response);
//    }
//}
