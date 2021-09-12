## 🎯 목표
### 자바의 상속, 예외처리, 패키지에 대해 학습하기.

## 📌 학습할 것
### [상속](#상속)
- [관계성](#관계성)
- [다형성](#다형성)
- [메소드 재정의](#메소드-재정의)
- [동적 바인딩](#동적-바인딩)

### [예외 처리](#예외-처리)
- [처리 방법](#처리-방법)
- [처리 규칙](#처리-규칙)

### [패키지](#패키지)
- [명명 규칙](#명명-규칙)
- [패키지 사용](#패키지-사용)
- [접근 제어자](#접근-제어자)
- [사용 예시](#사용-예시)

--- 

## 상속

기존 클래스를 **확장**하여 새로운 내용을 덧붙이거나 내용의 일부를 바꿔 **재정의**하여 사용하는 것.

`extends` 키워드로 상속받을 수 있다.

- **클래스** <- **클래스** : `extends` 키워드로 **단일** 상속
- **인터페이스** <- **인터페이스** : `extends` 키워드로 **다중** 상속
- **클래스** <- **인터페이스** : `implements` 키워드로 **다중** 상속 & 구현

**장점 :** 코드의 재사용 (有 -> 또 다른 有 창조), 확장용이
**단점 :** 높은 결합도

- **클래스상속 (구현상속)**
    - `Concrete클래스` 상속 : 온전한 클래스 -> **재정의 옵션**
    - `Abstract클래스` 상속 : 미완성 클래스
    
    	- 추상메소드 구현부 없이 선언으로만 이루어진 메소드
          설계상 의도적으로 추상클래스로 만드는 경우
          
    	- 추상메소드 **有** : XXX(); -> **재정의 필수**
    	- 추상메소드 **無** : XXX(){}; -> **재정의 옵션**
   		
      1) 추상클래스는 직접 new로 객체 생성을 못한다.
      
      2) 반드시 하위 클래스 요구!
      
  extends XXX (단일상속)
  
  "일반화"
            
- **인터페이스상속 (표준, 약속, spe, 방법)**

    - `사용자 관점` : 사용방법, 약속
    
    - `제공자 관점` : 구현의 책임
 
 implements XXX,YYY (다중상속)
 "실현"
 추상메소드와 상수로 이루어진 특별한 타입 -> **재정의 필수**
 
---

### 관계성

**1. `is a`** : 상속관계 (일반화)

**2. `has a`** : 소유 (연관관계 - 영구적)

**3. `use a`** : 사용 (의존관계 - 일시적)

---
### 메소드 재정의

`논리적 재정의`

**전제조건 :** 상속
- 전부다 뒤갈아 엎는 재정의
- 살짝 덧붙이는 구형의 재정의

**1.** 메소드 이름<br>
**2.** 매개변수 목록<br>
**3.** 리턴타입

1 ~ 3까지는 같아야 함

**4.** 접근지정자 같거나 넓게 **(넓어짐)**<br>
**5.** throws 구문 예외 같거나 하위타입으로 or 안던지거나 **(좁아짐)**

---

### 다형성

#### 상속이 전제조건!

형태가 다양한 성질 => 다양한 형태를 가질 수 있다.

- `객체 다형성` : **Type다형성**

- `메소드 다형성` : 다중정의(**오버로딩**), 재정의(**오버라이딩**)

#### Type 다형성

```java
 Object <- Employee <- Engineer
 big ----------------- small
 
 Engineer e1 = new Engineer();
 Employee e2 = new Engineer();
 Object e3 = new Engineer();
 
 big >= small
 잔 = 내용물
 커피잔 = 커피
 텀블러(with빨대) = 커피
 
 잔의 형태에 따라 커피마시는 방식이 결정된다.
 즉, 객체를 어디에 담느냐에 따라 객체의 사용방법이 달라진다.

 만약 Object에 a, Employee에 b, Engineer에 c가 선언되어 있다고 할 때,
 e3.a
 e2.a, e2.b
 e1.a, e1.b, e1.c 사용가능.
```

#### 다형성을 사용(활용)하는 경우

1. **이형 집합 배열**

만약 Engineer와 Manager등 다른 직무의 직원 총 100명의 샐러리를 관리할 리스트를 생성할 때 사용

```java
Employee[] list = new Employee[100];
```

2. **매개변수 다형성**

Engineer와 Manager등 다양한 직무의 직원들을 매개변수로 받아야 할 때 사용

```java

XXX(Employee e)
```

> "직원들 모이세요" -> "거기서 직원들 공통적인 이야기를 해야지, 엔지니어 or 매니저 이야기 하면 안됨"

3. **리턴타입 다형성**

경우에 따라 리턴타입을 다르게 전달해야 할 때 사용

```java
Employee XXX(){
   if(...) return new Engineer();
   else return new Manager();
}
```

---

### 동적 바인딩

`동적 바인딩 (Run-time)` <-> `정적 바인딩 (Compile-time)`

컴파일시에 컴파일러가 인지한 객체와 런타임시 실제 객체를 다르게 인지

```java
// Employee에 정의된 getInfo()를 
// Engineer에서 getInfo()를 오버라이딩 했을 때,

Employee e = new Engineer();
e.getInfo();
ㄴ Compile-time : Employee
ㄴ Run-time : Engineer

Employee e = new Engineer();에서 
e는 Engineer에 없는 메소드는 사용하지 못하지만
유일하게 Engineer가 영향을 주는것은 오버라이딩된 메소드이다.
```

---

## 예외 처리
예외 처리 키워드 5가지 : `try` `catch` `throw` `throws` `finally`

예외 처리란, 프로그램 실행 중 발생할 수 있는 예기치 못한 예외 발생에 대비한 코드를 작성하는 것이며,<br>
예외처리의 목적은 예외의 발생으로 인한 실행중인 프로그램의 갑작스런 비정상 종료를 막고 실행상태를 유지할 수 있도록 함

### 처리 방법

1. 예외가 발생한 메소드 내에서 직접 처리
    - `try` - `catch` - `finally`

try 구문은 예외가 발생 할 가능성이 있는 범위를 지정한다.<br>
try 구문에는 최소 하나 이상의 catch 구문이 따라와 위치해야 한다.<br>
finally 구문은 선택적으로 사용 가능하며, 예외 발생, catch 유무와 상관없이 반드시 수행된다.

```java
try{
	// 예외가 발생할 만한 코드
}catch (Exception e) {
    System.out.println(e.getMessage()); 
}finally{
    System.out.println("종료");
}
```

2. 예외가 발생한 메소드를 호출한 곳으로 예외 객체를 넘겨줌
    - `throws`

throws는 어떠한 메소드의 내부 소스코드에서 에러가 발생했을시 1번 방법처럼 예외를 직접 처리하는 것이 아니라,<br>
이 메소드를 호출하는 곳에서 처리를 하도록 예외 객체를 전달함.

```java
public void throwMethod() throws Exception{
    // 예외가 발생할 만한 코드
}

public static void main(String[] args) {
    try{ 
        throwMethod();
    }catch (Exception e) {
        System.out.println(e.getMessage()); 
    }finally{
        System.out.println("종료");
    }
}
```

3. 사용자 정의 예외를 생성하여 처리
    - `throw`

Exception 클래스를 상속받는 사용자 정의 예외 클래스를 생성하여 해당 예외 객체를 throw할 수 있다.

3번 방법은 앞선 1번 방법, 2번 방법을 모두 적용가능하다.

```java
public class CustomException extends Exception{
    public CustomException(){
        super("사용자 정의 예외 발생!");
    }
}
```

1번 방법처럼 try - catch문으로 예외가 발생한 메소드 내에서 직접 처리
```java
try{
    throw new CustomException();
}catch (CustomException e) {
    System.out.println(e.getMessage()); 
}finally{
    System.out.println("종료");
}
```

2번 방법처럼 해당 메소드를 호출한 곳으로 예외 객체를 넘겨줌
```java
public void thorwMethod() throws CustomException{
    if(예외 발생 조건) throw new CustomException();   
}
```

### 처리 규칙

#### 1. try-catch
```java
// 적절한 예외처리
try{
	// 예외가 발생할 만한 코드
} catch (XXException e){
	// 처리코드
} catch (YYException e){
	// 처리코드
} catch (Exception e){
	// 처리코드
}
```

```java
// 적절하지 않은 예외처리
try{
	// 예외가 발생할 만한 코드
} catch (Exception e){
	// 처리코드
} catch (YYException e){
	// 처리코드
} catch (XXException e){
	// 처리코드
}
```

JVM이 던진 예외는 catch문장을 찾을 때 다형성이 적용됨. <br>
상위 타입의 예외가 먼저 선언되는 경우 뒤에 등장하는 catch는 절대 실행되지 않음.

> Unreachable catch block for Exception.

상속 관계가 없는 경우는 무관하다.

작은 범위(자식)에서 큰 범위(부모)순으로 catch문을 정의하는것이 적절하게 예외처리하는 방법임.

#### 2. throws
```java
class Parent {

    void methodA() throws IOExeption{}
    
    void methodB() throws ClassNotFoundException{}
    
}

class Child extends Parent {

    @override
    void methodA() throws FileNotFoundException{}

    @override
    void methodB() throws Exception{} // 문제 발생!
    
}
```

자식이 부모의 메서드를 오버라이딩 할 때, 부모 클래스가 던지는 예외보다 더 부모의 예외를 던질 수 없다! (같거나 하위타입으로 or 안던지거나 **(좁아짐)**)

즉, 부모A가 던지는 어느 자식b가 있는데, A의 자식인 a가 이 b의 부모인 B를 던질 수는 없다.<br>
a는 b 또는 b보다 더 작은 자식부터 던질 수 있음.

---

## 패키지

- 클래스를 구분짓는 폴더 개념
- 패키지이름을 java 로 시작하면 안된다.
- 패키지 이름과 위치한 폴더의 이름이 같아야한다.
- 모든 클래스에는 정의가 되어있는 클래스 이름과 패키지 이름이 존재한다 (패키지를 따로 지정하지 않으면 디폴트 패키지).
- 패키지 이름 + 클래스 이름이 합쳐져야 클래스를 온전히 표현할 수 있으며 이를 `FQCN(Fully Qualified Class Name)`라고 한다. 

> ex) com.ssafy 패키지의 JavaTest 클래스를 FQCN로 표현하면 com.ssafy.JavaTest가 됨

#### 명명 규칙

- 자바 예약어 사용금지
- 소문자만 사용

#### 패키지 사용

- `import`키워드로 패키지명을 지정
- 해당 패키지의 모든 클래스를 사용하려면 `import com.ssafy.*;` 라고 선언하면 됨
- 특정 클래스만 사용하려면, * 대신 클래스명을 지정하면 됨

#### 접근 제어자

![99F2454B5B45C99728](https://user-images.githubusercontent.com/51703260/132984874-d731c312-7304-4e17-8505-d9c0ab1cce0b.png)

#### 사용 예시

- 패키지 선언문 (0 or 1)

``` java
package top.sub....;

// 물리적 : 폴더
// 보통 domain name(Unique!) 역순사용
```

- import문 (0 ~ 多) 

``` java
import top.sub...클래스이름;// 소스 클래스명 바로사용
import top.sub...*;// all classes, interfaces

// (not package) : import단위는 패키지가 아님, 클래스 단위!
```

현 클래스안에서 참조, 사용하는 클래스가 자신과 같은 패키지가 아닌 경우 명시
단, `java.lang`은 자동으로 불러옴
