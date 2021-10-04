#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
 
 
void solve(){
 
  ll n ; 
  cin >> n ; 
 
  ll arr[n];
  
    for(ll i=0;i<n;i++){
        cin>>arr[i];
    }
    
    sort(arr,arr+n);

 
    ll ans=0 ; 
     ll temp=0;
 
    for(ll i=2;i<n;i++){
        temp = temp + arr[i-2];
        // set_differencesdf
        ans = ans - (arr[i]*(i-1));
        // cout << ans << endl 
        ans = ans + temp;
    }
    cout << ans ;
 
  
 
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