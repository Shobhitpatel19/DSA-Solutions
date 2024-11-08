//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minRepeats(string& s1, string& s2) {
        int repeatCount = (s2.length() + s1.length() - 1) / s1.length(); 
        string repeatedS1 = "";
        for (int i = 0; i < repeatCount; ++i) {
            repeatedS1 += s1;
        }
        if (repeatedS1.find(s2) != string::npos) {
            return repeatCount;
        }
        repeatedS1 += s1;
        if (repeatedS1.find(s2) != string::npos) {
            return repeatCount + 1;
        }
        return -1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {
        string A, B;
        getline(cin, A);
        getline(cin, B);

        Solution ob;
        cout << ob.minRepeats(A, B) << endl;
    }
    return 0;
}
// } Driver Code Ends