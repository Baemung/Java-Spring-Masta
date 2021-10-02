## 🎯 목표
### 자바가 제공하는 다양한 연산자와 제어문을 익히기.

### 📌 학습할 것
- [산술 연산자](#-산술-연산자)
- [비트 연산자](#-비트-연산자)
- [관계 연산자](#-관계-연산자)
- [논리 연산자](#-논리-연산자)
- [instanceof](#-instanceof)
- [Assignment Operator](#-assignment-operator)
- [화살표 연산자](#-화살표-연산자)
- [3항 연산자](#-3항-연산자)
- [선택문](#-선택문)
- [반복문](#-반복문)

--- 

### 💡 산술 연산자

산술 연산자는 +, -, *, / 이렇게 사칙연산와 모듈라 연산 %로 이루어져 있다.

```java
int A = 10;
int B = 3;

System.out.println(A + B); // 13
System.out.println(A - B); // 7
System.out.println(A * B); // 30
System.out.println(A / B); // 3
System.out.println(A % B); // 1

```

---

### 💡 비트 연산자

비트 연산자는 `비트 논리 연산자`와 `비트 시프트 연산자`로 구분할 수 있다.

**`비트 논리 연산자`**

비트 논리 연산자는 피연산자를 비트단위로 논리 연산을한다.

피연산자로 실수는 허용하지 않고, 정수(문자 포함)만 허용한다.

<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131247156-ddfe684b-2abd-4000-ba45-b978d22d99cd.png"></p>

**`비트 시프트 연산자`**

피연산자의 각 비트 자리를 '오른쪽(>>)' 또는 '왼쪽(<<)'으로 이동(shift) 한다고 해서 `비트 시프트 연산자`라고 한다.
  
<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131247160-73eedc06-8955-4f10-8d2c-9fee78ed7ef0.png"></p>

---

### 💡 관계 연산자

관계 연산자는 조건식에 자주 쓰이는 연산자로 

두 비교 가능한 값이나 객체의 관계를 비교하는 연산자이다.

관계 연산자는 <, >, <=, >=, ==, != 으로 구성되어 있고 boolean type을 리턴한다.

```java
a < b // a가 b보다 작은가?
a > b // a가 b보다 큰가?
a <= b // a가 b보다 작거나 같은가?
a >= b // a가 b보다 크거나 같은가?
a == b // a와 b가 같은가?
a != b // a와 b가 다른가?
```

==, != 는 객체를 비교할 땐 레퍼런스를 비교하기 때문에 겉으로 보이는 값은 같더라도 참조하는 레퍼런스가 다르면 의도하지 않은 결과를 얻을 수도 있다.

---

### 💡 논리 연산자

논리 연산자는 논리의 결합이나, 논리를 뒤집을때 사용하는 연산자로 boolean type을 리턴한다.

```java
A && B // A와 B 모두 true이면 연산결과는 true (and)
A || B // A와 B 둘 중 하나라도 true이면 연산결과는 true (or)
!A // 연산결과는 A가 true이면 false, A가 false이면 true (not)
```

여기서 and 연산은 첫번째 논리가 false면, 뒤의 논리를 체크하지 않고 false를 리턴한다.
그리고 or 연산은 첫번째 논리가 true면, 뒤의 논리를 체크하지 않고 true를 리턴한다.

그렇기 때문에 논리 연산자를 사용할 때 시간, 메모리의 낭비도 있을 수 있고, 경우에 따라 런타임에러가 발생할 수도 있기 때문에 논리의 순서가 상당히 중요하다.

---

### 💡 instanceof

참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아볼 때 instanceof 연산자를 사용하는데 이 연산자는 boolean type을 리턴한다.

"객체 instanceof 클래스" 형식으로 사용하며, 주로 상속관계를 확인할 때 사용한다.

```java
class A { }

class B extends A { }

public class main {
    public static void main(String[] args){
        A a = new A();
        A ab = new B();
        B b = new B();
        
        System.out.println(a instanceof A);   //true
        System.out.println(ab instanceof A);  //true
        System.out.println(b instanceof A);   //true
        
        System.out.println(a instanceof B);   //false
        System.out.println(ab instanceof B);  //true
        System.out.println(b instanceof B);   //true
    }
}
```

자식 객체는 부모 클래스의 instance지만, 부모 객체는 자식 클래스의 instance가 아니다.

---

### 💡 Assignment Operator

우변의 값을 좌변의 변수에 대입하는 연산자이다.

```java
A = B
```

대입 연산자는 다양한 연산자와 결합하여 아래와 같은 복합 대입 연산자로 활용가능하다.

```java
A += B
A -= B
A *= B
A /= B
A %= B
A &= B
A |= B
A ^= B
A >>= B
A <<<= B
```

---

### 💡 화살표 연산자

(매개변수) -> {실행코드}와 같은 람다식에서 화살표 연산자를 사용한다.

여기서 람다식이란 "식별자없이 실행가능한 함수"로, 함수를 따로 선언하지 않고 코드한줄에 함수를 써서 그것을 호출하는 방식이다.

보통 특정 기준으로 정렬할 때 자주 사용하게 된다.

```java
Arrays.sort(list, (l1, l2) -> l1[0]) - l2[0]));
```

위 코드는 2차원 배열을 정렬할 때, 배열의 첫번째 값을 기준으로 정렬하라는 람다식이다. 

내부적으로는 Comparator 인터페이스의 compare(T o1, T o2)메소드를 오버라이딩한 것이다. 

---

### 💡 3항 연산자

```java
// 변수 = 조건문 ? 참 : 거짓;
min = A < B ? A : B;

// return 조건문? 참 : 거짓;
return A < B ? A : B;
```
변수에 값을 할당할 때만 삼항연산자를 쓸 수 있는것이 아니라, 값을 넘겨주거나 출력하는 등 값을 받아 처리를 해줄 수 있으면 사용 가능하다. 

---

### 💡 연산자 우선 순위

<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131240291-29ad255c-2e62-4df1-b962-c4e8ae1b27de.png"></p>

만약 동일한 우선순위인 경우는 해당 연산자의 연산방향에서 먼저 등장하는 연산자가 우선적으로 연산된다.

---

### 💡 선택문

- **if - else if - else**

``` java
if(조건식){ }
else if( 위 조건이 거짓일 경우 조건){ }
else if( 위 조건이 거짓일 경우 조건){ }
else { // 모든 조건들이 거짓일 경우 }
```

if만 단독으로 올 수 있고, else if와 else는 if문이 선행되어야지 뒤 따라 나올 수 있다.

else if는 if{} - else{ if{} } 의 약식 개념이다.

- **switch - case - default**

```java
switch(변수) {
    case A : // 변수의 값이 A일 때
        // 진입
        break;
    case B : // 변수의 값이 B일 때
        // 진입
        break;
    default :
        // A와 B가 아닌 경우
}
```
switch의 변수는 Primitive 타입, Enum, String, Wrapper 클래스가 가능하다.

여기서 주의할 점은 case A에 진입해서 처리를 하고 break가 되지 않으면 아래 case B에도 자동으로 진입하게 프로그램이 설계되어 있기 때문에

A에 진입했을 때 처리하고 싶은 내용만 처리하고 싶다면 break를 해줘서 switch문을 빠져나와야 한다.

---

### 💡 반복문

- **while**
```java
 while(조건식){
    // 조건식이 처음 부터 성립되지 않으면 애초에 반복문에 진입을 안할 수도 있음
    // 반복내용
 }
```
  
```java
 do{
    // 무조건 최소 1번은 반복문 실행
    // 반복내용
 } while(조건식); // 세미콜론 ';' 필수
```

- **for & for-each**

```java
for(초기화; 조건식; 증감식){
    // 반복내용
}
```

```java
for(데이터타입 집합원소 : 반복집합객체){
    //반복 가능한 집합들의 원소들을 꺼내어 처리
}
```
반복집합객체에는 array, iterable 타입이 올 수 있으며 enum의 경우 enum.values()를 반복집합객체로 사용한다.

for-each문을 사용하는 목적
1. 자료구조사용에 대한 추상화
2. 반복 가능한 집합의 원소)값의 수정이 불가능(조회 목적)
