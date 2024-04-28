#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

char stack[51];
int top = 0;

void push(char data) {
	stack[top++] = data;
}

char pop() {
	return stack[--top];
}

int empty() {
	return top == 0;
}

int isVPS(char* data) {
	int result = 1;
	int i;

	for (i = 0; data[i]; i++) {
		if (data[i] == '(') {
			push(data[i]);
		}
		else {
			if (empty()) { //처음부터 스택비어잇으면 여는 괄호 없음 
				result = 0;
				break;
			}
			else {
				pop();
			}
		}
	}
	if (!empty()) { //스택이 안비워져잇음 vps아니니까
		result = 0;
	}

	while (!empty()) { //다음차례위해 스택 비워줌 
		pop();
	}

	return result; //1이면 vps이고 0이면 아님 
}

int main() {

	int n;
	scanf("%d", &n); 
	char data[51];

	for (int i = 0; i < n; i++) {
		scanf("%s", data);
		
		if (isVPS(data)) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}

	}

	return 0;
}
