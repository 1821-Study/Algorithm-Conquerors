#include <stdio.h>
#include <stack>
#include <string.h>
#include <iostream>
#include <string>

using namespace std;

int main()
{
	int n,push_a;
	string command;

	scanf_s("%d", &n);

	stack<int> s;

	
	for (int i = 0; i < n; i++) {
		cin >> command;
		if (command == "push") { 
			scanf_s("%d", &push_a);
			s.push(push_a);
		}
		else if (command == "pop") {
			if (s.empty()) cout << "-1" << endl;
			else {
				cout << s.top() << endl;
				s.pop();
			}
		}
		else if (command == "size") {
			cout << s.size() << endl;
		}
		else if (command == "empty") {
			cout << (s.empty() ? 1 : 0) << endl;
		}
		else if (command == "top") {
			if (s.empty()) cout << "-1" << endl;
			else cout << s.top() << endl;
		}


	}

}