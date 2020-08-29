Leetcode 639:
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
1)The length of the input string will fit in range [1, 105].
2)The input string will only contain the character '*' and digits '0' - '9'.


Base Case
   if length is zero   ---->return 0
   if length is one
               a)if character is '*' ---> return 9    (1,2,3,4,5,6,7,8,9)
               b)if character is '0' ----> return 0
               c)if character is less than 7----> return 1
choice i.e subproblems
   '1*'---->return 9*(s,n-1)
   '1#'---->return (s,n-1)    # is any number between 1 and 9
   
   handle these four cases--> 12  1* *2 **
   let's first handle *2 and **   [in "*2" , '*' is n-2 character of string s whereas '2' is n-1 character of string s ]
         if(s.charAt(n-2)=='*')
              if(s.charAt(n-1)=='*')
                  then "**" means 11 12 13 14 15 16 17 18 19 21 22 23 24 25 26 i.e 15 cobinations are possible
                    return  15*(s,n-2)
              else if(s.charAt(n-1)>'0')
                    then * can be either 1 or 2 i.e 2 combinations
                    return 2*(s,n-2)
              else
                   return (s,n-2)
                   
    let's first handle 12 and 1*    
             if(s.charAt(n-2)=='1' || s.charAt(n-2)=='2')
                      if(s.charAt(n-1)=='*')
                           if(s.charAt(n-2)=='1')
                           then 11 12 13 14 15 16 17 18 19 i.e 9 combinations
                           return 9*(s,n-2)
                           else if(s.charAt(n-2)=='1')
                           then 21 22 23 24 25 26 i.e 6 combinations
                           return 6*(s,n-2)
                       else if(s.charAt(n-2)=='1' ||(s.charAt(n-2)=='2'&& s.charAt(n-1)<'7' ))    [for cases like 12 23 or type]
                          return (s,n-2); 
         
         
         
solution


class decodeways2{
    public int numDecodings(String s) {
        return fun(s,s.length());
    }
    public int fun(String s,int n)
    {
        if(n==0)
            return 1;
        if(n==1)
        {
        if(s.charAt(0)=='0')
            return 0;
       else  if(s.charAt(0)=='*')
            return 9;
        else
            return 1;
        }
          //12   1*
        int c=0;
         if(s.charAt(n-1)=='*')
             c=9*fun(s,n-1)%1000000007;
        else if(s.charAt(n-1)>'0')
            c=fun(s,n-1)%1000000007;
        /*  12
            1*
            *2
            **   handle these four cases
        */
        if(s.charAt(n-2)=='*')   //** or *1
        {
           if(s.charAt(n-1)=='*') 
               c=c%1000000007+15*fun(s,n-2)%1000000007;//11 12 13 14 15 16 17 18 19 21 22 23 24 25 26 i.e 15 cases possible in **
           else if(s.charAt(n-1)<'7') //11 12 13 14 15 16 21 22 23 24 25 26
                c=c%1000000007+2*fun(s,n-2)%1000000007;
            else
                c=c%1000000007+fun(s,n-2)%1000000007;
        }
      else if(s.charAt(n-2)=='1' ||s.charAt(n-2)=='2') //1* 2* 23
        {
            if(s.charAt(n-1)=='*')
            {
                if(s.charAt(n-2)=='1') //1*   11 12 13 14 15 16 17 18 19
                    c=c%1000000007+9*fun(s,n-2)%1000000007;
                else if(s.charAt(n-2)=='2')//2* 21 22 23 24 25 26
                     c=c%1000000007+6*fun(s,n-2)%1000000007;
            }
               else if(s.charAt(n-2)=='1' ||(s.charAt(n-2)=='2'&& s.charAt(n-1)<'7' )) 
               c=c%1000000007+fun(s,n-2)%1000000007; 
           
            
        }
        return c;
        
    }
}
