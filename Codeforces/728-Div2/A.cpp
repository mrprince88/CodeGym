#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;


void solve(){

  ll n ; 
  cin >> n ; 

   if(n%2!=0){
      vector<ll> vec;
       for(ll i=1 ;i<=n;i++){
         vec.push_back(i);
         }
        for(ll i = 0; i < n - 1; i += 2) {
        swap(vec[i], vec[i + 1]);
        }

        // cout << vec[n-1] << " "  ; 
        swap(vec[n - 1], vec[n - 2]);
        
        for(auto &val : vec) {
        cout << val <<" ";
        }

        
   }

   else{
     for(ll i=1 ;i<=n ;i+=2){
       cout << i+1 << " " << i << " " ;
     }
   }

  

}

int  main()
{
  
  ll t; 
  cin >> t;

  while (t--){   
   
   solve();
   cout << endl ;
  }
}