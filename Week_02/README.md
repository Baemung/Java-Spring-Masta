## 🎯 목표
### 자바의 Primitive 타입, 변수 그리고 배열을 사용하는 방법을 익히기.

### 📌 학습할 것
- [Primitive 타입 종류와 값의 범위 그리고 기본 값](#-primitive-타입-종류와-값의-범위-그리고-기본-값)
- [Primitive 타입과 Reference 타입](#-primitive-타입과-reference-타입)
- [Literal](#-literal)
- [변수의 스코프와 라이프타임](#-변수의-스코프와-라이프타임)
- [타입 변환, 캐스팅 그리고 타입 프로모션](#-타입-변환-캐스팅-그리고-타입-프로모션)
- [1차 및 2차 배열 선언하기](#-1차-및-2차-배열-선언하기)
- [타입 추론, var](#-타입-추론-var)

---

### 💡 Primitive 타입 종류와 값의 범위 그리고 기본 값
**Primitive type 종류**
- 원자성의 Data
- 수의 표현 범위 : byte < short < int < long < float < double     

```
                  타입 종류           용량          기본 값
-----------------------------------------------------------------------------------------------
                  boolean           1 bit	    false     (숫자 호환 X)
                  char              2 bytes         '\u0000'  ('a'(문자) != "a"(문자열 ; 객체))
                  
              |   byte              1 byte          0       ▲ 명시적 형변환
              |   short             2 bytes         0       |
              |   int(default)      4 bytes         0       |
              |   long              8 bytes         0L      |
              |   float             4 bytes         0.0f    |
묵시적 형변환  ▼   double(default)   8 bytes         0.0d    |

```

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

<p align="center"><img src="../img/chap2_2.png"></p>

> 하지만 
> String 도 객체인 것처럼, 엄연히 Wrapper Class도 객체임을 잊으면 안된다.
> 
> 경우에 따라, 위 이미지와 같은 상황도 발생할 수 있다.
> equals로 값은 동일하지만 == 가 서로 다르다는 결과를 보일 때도 있다.

### 💡 Literal
### 💡 변수 선언 및 초기화하는 방법
### 💡 변수의 스코프와 라이프타임
### 💡 타입 변환, 캐스팅 그리고 타입 프로모션
### 💡 1차 및 2차 배열 선언하기
### 💡 타입 추론, var
