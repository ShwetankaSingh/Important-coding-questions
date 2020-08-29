A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
🙄 🤔 ❓ 🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓🙄 🤔 ❓


Recursive based approach solution ✍👇💁
 "12"
              12                      2 is checked
          /      \
    1(n==1) (2)    emptystring(n==0)(12)
   return 1   +   return 1
   
   
   
   
 "226"
                226
              /      \
           22 (6)     +   2(n==1)return 1  (26)
         /        \
       2(n==1)(2)   empty(n==0)(22)
       return 1 +  return 1
       
       
  "10"
         10  ======> 0 return 0
        /   
      empty(10)    
 return 1 +  0  
 
 
  😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍 😍😍😍😍😍😍😍😍
  
class decodeways {
    public int numDecodings(String s) {
       return fun(s,s.length());
        
    }
    public int fun(String s,int n)
    {
        if(n==0)
            return 1;
        if(n==1)
        {
            if(s.charAt(0)>'0')
                return 1;
            else
                return 0;
        }
        
        int c=0;
        if(s.charAt(n-1)>'0')
            c=fun(s,n-1);
        if(s.charAt(n-2)=='1'||(s.charAt(n-2)=='2' && s.charAt(n-1)<'7'))
            c=c+fun(s,n-2);
        return c;
    }
}

