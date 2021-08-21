## 🎯 목표
### 자바의 Primitive 타입, 변수 그리고 배열을 사용하는 방법을 익히기.

### 📌 학습할 것
- [Primitive 타입 종류와 값의 범위 그리고 기본 값](#-primitive-타입-종류와-값의-범위-그리고-기본-값)
- [Reference 타입](#-reference-타입)
- [Literal](#-literal)
- [변수 선언 및 초기화하는 방법](#-변수-선언-및-초기화하는-방법)
- [변수의 스코프와 라이프타임](#-변수의-스코프와-라이프타임)
- [타입 변환, 캐스팅 그리고 타입 프로모션](#-타입-변환-캐스팅-그리고-타입-프로모션)
- [배열](#-배열)
- [타입 추론, var](#-타입-추론-var)

---

### 💡 Primitive 타입 종류와 값의 범위 그리고 기본 값

<p align="center"><img src="../img/chap2_3.png"></p>

**Primitive type 종류**
- 원자성의 Data
- 수의 표현 범위 : byte < short < int < long < float < double     

```
                  타입 종류           용량          기본 값
-----------------------------------------------------------------------------------------------
                  boolean           1 bit	    false     (숫자 호환 X)
                  char              2 bytes         '\u0000'  ('a'(문자) != "a"(문자열 ; 객체))
                  
              |   byte              1 byte          0       ▲ 명시적 형변환 (Casting)
              |   short             2 bytes         0       |
              |   int(default)      4 bytes         0       |
              |   long              8 bytes         0L      |
              |   float             4 bytes         0.0f    |
묵시적 형변환  ▼   double(default)   8 bytes         0.0d    |
(Promotion)
```

---

### 💡 Reference 타입
**Reference type** = All type - Primitive type

**non-Primitive type**
- Reference type; 참조타입
- Class type
- Interface type
- Array type
    
java는 2Bytes체제의 유니코드를 지원한다. 
유니코드는 u0000 ~ uffff까지 표현됨
u00[**]에서 [**]의 1바이트는 ASCII코드
```java
char ch = 'A';
char ch = 65;
char ch = '\u0041'; //A의 유니코드표기 (4*16^1+1*16^0 = 65)
```

<p align="center"><img src="../img/chap2_1.png"></p>

> **Wrapper Class ?** Primitive Type을 Boxing하여 객체화하는 클래스!
> 
> 8개의 Primitive Type에 각각 대응되게 다 존재함.
> 
> java 5.0 부터 사용자들이 int와 Integer가 서로 호환되는 것 처럼 느껴지게 Auto Boxing, Auto UnBoxing을 지원함.
> 
> 따라서 java의 모든 데이터타입은 객체로 표현이 가능해진다. 그래서 최상위 타입인 Object Type은 다형성 때문에 존재.

```java
Integer i = new Integer(10);
```

> 하지만 
> String 도 객체인 것처럼, 엄연히 Wrapper Class도 객체임을 잊으면 안된다.
> 
> 경우에 따라, 아래 이미지와 같은 상황도 발생할 수 있다.
> equals로 값은 동일하지만 == 가 서로 다르다는 결과를 보일 때도 있다.

<p align="center"><img src="../img/chap2_2.png"></p>

---

### 💡 Literal
**Literal** : 자바 코드에 직접 '값'을 명시하면 리터럴로 분류함
소스 코드의 고정된 값을 대표하는 용어

**Literal 종류**

Primitive 타입과 같이 정수, 실수, 문자, 논리, 문자열 리터럴이 있다.

**1. 정수 리터럴**

10진수, 8진수, 16진수, 2진수 형태로 표현한 값이다.
```java
int a = 15;
int b = 015;
int c = 0x15;
int d = 0b0101;
```
정수 리터럴은 int 형이 default이다.

long 타입 리터럴은 숫자 뒤에 L 또는 l을 붙여 표시하여야 한다. ( long a = 26L; )

**2. 실수 리터럴**

소수점 형태나 지수 형태로 표현한 값이다.

실수 리터럴도 마찬가지로 double 형이 default이다.
```java
double a = 0.1234;
double b = 1234E-4; 
```
a = 0.1234 와 b = (1234*10*(-4)는 동일한 값

long 타입 리터럴은 숫자 뒤에 L 또는 l을 붙여 표시하여야 하듯이, float 타입 리터럴도 f를 꼭 붙여줘야한다. ( float h = 0.1234f; )

**3. 문자 리터럴**

단일 인용부호(' ')로 문자를 표현한다.
```java
char a = 'H';
char b = "한";
char c = \uae00;(유니코드값) // \u다음에 4자리 16진수로, 2바이트의 유니코드(Unicode))
```
아래와 같이 각각의 기능을 가지는 특수문자 리터럴도 존재한다.

<p align="center"><img src="../img/chap2_4.png"></p>

**4. 논리 리터럴**

boolean 타입 변수에 치환하거나 조건문에 이용한다.
```java
boolean flag1 = true;

//Java에서는 다른 언어와 달리 0 과 1이상 수가 논리 리터럴이 될 수 없다.
boolean flag2 = 1; // 컴파일 에러!
```
반드시 true, false만이 논리 리터럴이 된다.

**5. 문자열 리터럴**

문자열은 Primitive type이 아니고 엄연히 Reference type 객체이다. 

이중 인용부호 (" ")로 문자열을 표현한다. 
```java
String str1 = new String("a");  // identityHashCode : 1908981452
String str2 = new String("a");  // identityHashCode : 234231844
String str3 = "a";              // identityHashCode : 4332211222
String str4 = "a";              // identityHashCode : 4332211222
```
- str1과 str2는 새롭게 Heap 공간에 만듦, 즉 서로 참조값이 다른 다른 객체이다.
- str3에서 문자열 "a"를 선언하면 이 "a"는 heap에 올라가는 것이 아닌 재사용하기 위해 리터럴풀에 넣고 그 "a"를 참조한다.
- 문자열은 변경이 되지않고 변경을 하려면 새롭게 선언을 해야하기 때문에 리터럴로 활용이 가능하다.
- 그리고 str4에서 문자열 "a"를 다시 선언하면, str4는 리터럴풀을 둘러보고 "a"가 있는 것을 발견하고 그 "a"를 참조한다.
- 따라서 str3과 str4는 리터럴풀에 있는 같은 "a"를 참조한다. 
- str1은 Heap에 새롭게 만든 String 메모리를, str3는 리터럴풀의 "a"를 참조하므로 다른 참조값을 가진다.

---

### 💡 변수 선언 및 초기화하는 방법

```java
public class Person{
  // 멤버 변수 선언
  // 인스턴스 변수 선언
  int n, m, k;
  // 클래스 변수 선언
  int static s;
  
  // 생성자로 인스턴스 변수 초기화
  Person(int n, int m, int k){
      this.n = n;
      this.m = m;
      thos.k = k;
  }
  
  // 인스턴스 변수 블럭 초기화 
  { 
      n = 10;
      m = 20;
      k = 30;
  }
  
  // 클래스 변수 스태틱 블럭 초기화
  static {
      s = 40;
  }
  
  // 메소드 내 로컬 변수 선언 및 초기화
  void declare(){
      int a; // 선언
      a = 10; // 초기화
      int b = 10; // 선언과 동시에 초기화
  }
}

```

변수를 선언할 때 final 키워드를 붙혀서 final 변수로 선언할 수 있다.

final 변수는 바로 값을 초기화 하거나 생성자 또는 초기화 블럭에서 초기화 되어야한다.

final 변수는 4가지로 구분할 수 있다.

**1. 로컬 primitive type 변수** : final로 선언하면 한번 초기화된 변수는 변경할 수 없는 상수값이 된다.

**2. 로컬 reference type 변수** : final로 선언하면 그 변수에 다른 참조 값을 지정할 수 없게 되어, primitive type과 동일하게 한번 쓰여진 변수의 재변경이 불가해진다. 

단, 해당 인스턴스 자체가 변경 불가하다는 의미는 아니라 해당 참조 변수가 다른 인스턴스로 참조 변경이 불가능 한 것이지, 인스턴스의 속성은 변경 가능하다.

**3. 메소드 인자 변수** : 메소드 인자로 final 키워드를 붙인 변수는 , 메소드 안에서 변수값을 변경할 수 없다.

```java
public void changeVar(final int var) {
        //var = 1; //final 인자는 메서드안에서 변경할 수 없음
}
```

**4. 클래스 멤버 변수** :  final로 선언하면 상수값이 되거나 write-once 필드로 한 번만 쓰이게 된다. final로 선언하면 초기화되는 시점은 생성자 메서드가 끝나기 전에 초기화가 되지만, fianl static이냐  그냥 final이냐에 따라서 초기화 시점이 달라진다.

```java
public class InitVar{
    //static final 멤버 변수 
    static final inx a = 1; // 값과 함께 선언시
    static final int b;
    static {
        b = 2; // static 초기화 블럭에서
    }

    //instance final 멤버 변수 
    final int c = 3; // 값과 함께 선언시
    final int d;
    final int e;
    {
        d = 4; // 인스턴스 초기화 블럭에서 
    }
    
    InitVar(int e){
        this.e = e; // 생성자에서
    }
}
```
---

### 💡 변수의 스코프와 라이프타임

#### 변수의 Scope : 변수에 접근할 수 있는 유효 범위

#### 변수의 Lifetime : 변수가 메모리에 살아있는 기간

**인스턴스 변수**
- Scope: static 메소드를 제외한 클래스 전체
- Lifetime : 객체가 메모리에 남아있을 때까지

**클래스 변수**
- Scope: 클래스 전체
- Lifetime : 클래스가 메모리에 로딩 되어 있는 동안

**로컬 변수**
- Scope: 선언된 블록 내
- Lifetime : 선언 된 블록이 끝날 때까지

---

### 💡 타입 변환, 캐스팅 그리고 타입 프로모션

#### 캐스팅 : 명시적 형변환
#### 프로모션 : 묵시적 형변환

**Primitive Type**

**- 캐스팅 :** 큰 데이터 타입에서 작은 데이터 타입으로 형 변환 (강제적으로 앞에서 명시적 형변환을 해주지 않으면 에러 발생)

**- 프로모션 :** 작은 데이터 타입에서 큰 데이터 타입으로 형 변환 (자동 형변환)

```java
int a = 10;
short b = (short) a; // Casting
double c = a; // Promition
```

**Reference Type**

상속 관계인 경우 캐스팅 가능.

**- Up Casting :** 부모 클래스는 명시적인 타입캐스팅 없이 자식과 연결 할 수 있다.

**- Down Casting :** 자식 클래스는 명시적인 타입캐스팅이 있다면 부모와 연결할 수 있다.

```java
// Person <- Student로 클래스 상속 관계가 있다고 가정
Person p = new Student(); // Up Casting
Student s = (Student)p;   // Down Castinh

/* 
 * 참고로 조상 참조변수로 자식 객체를 생성하고 난 다음
 * 자식 객체로 캐스팅해주는것은 문제없으나,
 * 조상 객체를 생성하면서 자식 객체로 캐스팅하는것은 에러가 발생한다.
*/

Person p = new Person();
Student s = (Student)p;   // 컴파일 에러
```
---

### 💡 배열

<p align="center"><img src="../img/chap2_5.png"></p>

**Reference Type (즉, 배열도 객체)**

**장점**
- 데이터 관리 용이함
  - 반복문과 결합하여 일괄처리 가능
  - 리턴값, 매개변수 전달시 활용 가능

- 처리성능 효율적

**단점**
- 크기가 고정적 (하지만 고정이기 때문에 처리성능이 효율적이게 됨)
  - 크기를 변경하고 싶으면 배열 새로 생성

**배열 생성**
```java
// 1차원 배열 생성
데이터타입[] 참조변수 = new 데이터타입[size];

// 2차원 배열 생성
데이터타입[][] 참조변수 = new 데이터타입[size][]; // 새로 선언하는 배열의 사이즈만 명시해줘도 된다. 
```

**배열 사용**
```java
// 1차원 배열 사용
데이터타입 변수 = 참조변수[index];

// 2차원 배열 사용
데이터타입 변수 = 참조변수[index1][index2];
```
index는 첫번째 원소 기준 offset 개념

그렇기 때문에, 0 ~ 길이-1 까지가 유효인덱스가 됨

**배열 초기화**
```java
// 1차원 배열 초기화
데이터타입[] 참조변수 = new 데이터타입[]{값1,값2,,,,};
데이터타입[] 참조변수 = {값1,값2,,,,};

//초기화를 할 때는 들어간 초기값의 개수에 따라 자동으로 size가 결정되기 때문에 직접 size를 명시하지 않는다. 
데이터타입[] 참조변수 = new 데이터타입[size]{값1,값2,,,,}; // 컴파일 에러

// 2차원 배열 초기화
데이터타입[][] 참조변수 = new 데이터타입[][]{{값1, 값2,,,,}, {값1, 값2,,,,}, {값1, 값2,,,,}};
데이터타입[][] 참조변수 = {{값1, 값2,,,,}, {값1, 값2,,,,}, {값1, 값2,,,,}};
```

---

### 💡 타입 추론, var

#### 타입 추론 : 변수의 타입을 명시하지 않고 컴파일러가 타입을 추측해서 컴파일 하는것. 
#### var : 타입 추론을 위한 람다 타입. 

Java 10부터 var 키워드를 통해 변수를 선언할 수 있게 됐다.

지역 변수로만 사용 가능하고 반드시 선언과 동시에 초기화를 해야 하며, null을 대입 할 수 없다.

동적바인딩처럼 런타임에 var를 실제 타입으로 치환할 것 같지만, 실제 타입으로 치환하는 것은 컴파일 타임이다.

```java
public static void main(String[] args){
    var intNum = 10; // int
    var longNum = 10L; // long
    var floatNum = 0.1f; // float
    var doubleNum = 0.1; // double
    var bool = true; // boolean
    var str = "String"; // String
}
```
