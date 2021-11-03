#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;


void solve(){

  ll n ; 
  cin >> n ; 

    ll id = 4*n ; 
    ll a[id + 17] = {0};
    ll tmp[id + 17] = {0};
    ll val = 0 ; 
//    if(n%2!=0){
//       vector<ll> vec;
//        for(ll i=1 ;i<=n;i++){
//          vec.push_back(i);
//          }
//         for(ll i = 0; i < n - 1; i += 2) {
//         swap(vec[i], vec[i + 1]);
//         }

//         // cout << vec[n-1] << " "  ; 
//         swap(vec[n - 1], vec[n - 2]);
        
//         for(auto &val : vec) {
//         cout << val <<" ";
//         }      
//    }

//    else{
//      for(ll i=1 ;i<=n ;i+=2){
//        cout << i+1 << " " << i << " " ;
//      }
//    }


  
     for(int mm=1 ;mm<=n ;mm++){
           cin >> a[mm]  ;
          tmp[a[mm]] = mm;
    }

 
    for(int i=1 ;i<=id ;i++){
       for(int k=1 ;k<=((id)/i) ;k++ ){
            if(i != k && i * k == tmp[i] + tmp[k] && tmp[k]!=0 && tmp[i]!=0  ){
                // cout << val << endl ;  
                   val++;
            }
            
        }
    }

    ll ans = val /2 ; 
    cout << ans  ; 




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