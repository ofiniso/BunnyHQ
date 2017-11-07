// Level 1 Bunny HQ
// ofiniso 2016

public class Answer1 {    
    public static String answer(int n) {  
      String primes = "2"; 
      int primesLength = primes.length(); 
      int i = 3; 
      while (primesLength <= (n + 5)) { 
          if (isPrime(i)) { 
              primes = primes + i; 
              primesLength = primes.length(); 
          } 
          i++; 
      } 
      return primes.substring(n, n + 5); 
    } 
     
    static boolean isPrime(int n) { 
        if (n%2 == 0) return false; 
        for(int i=3; (i*i) <= n; i += 2) { 
            if(n%i == 0) 
            return false; 
        } 
         return true; 
    }
    
    public static void main(String[] args){
      
      System.out.println(answer(0));
      System.out.println(answer(1));
      System.out.println(answer(2));
      System.out.println(answer(3));
      System.out.println(answer(4));
      System.out.println(answer(10000));
    }
     
}