## 🎯 목표
### 자바의 멀티쓰레드 프로그래밍, Enum에 대해 학습하기.

## 📌 학습할 것
### [멀티쓰레드 프로그래밍](#멀티쓰레드-프로그래밍)
- [Thread 클래스](#thread-클래스)
- [Runnable 인터페이스](#runnable-인터페이스)
- [쓰레드 상태](#쓰레드-상태)
- [쓰레드 우선순위](#쓰레드-우선순위)
- [Main 쓰레드](#main-쓰레드)
- [동기화](#동기화)
- [데드락](#데드락)

### [Enum](#enum)
- [enum 정의하는 방법](#enum-정의하는-방법)
- [enum이 제공하는 메소드](#enum이-제공하는-메소드)
- [EnumSet](#enumset)

--- 

## 멀티쓰레드 프로그래밍

먼저 `Process` 와 `Thread`의 차이점을 이해하고 넘어가야 할 필요가 있다. 
 
- `프로세스(Process)` : OS 내에서 실행중인 프로그램

- `쓰레드(Thread)` : 프로세스 내에서 실제 작업이 실행되는 흐름의 단위

따라서 프로세스는 하나 이상의 쓰레드를 가지고 있다.

<br> 

일반적으로 한 프로그램(Process)은 하나의 쓰레드를 가지고 있지만, 프로그램 환경에 따라 둘 이상의 스레드를 동시에 실행할 수 있다. 이러한 실행 방식을 멀티쓰레드(multithread)라고 한다.

근데 왜 멀티프로세스 프로그래밍이 아니라 멀티쓰레드 프로그래밍을 할까?

멀티프로세스와 멀티쓰레드는 양쪽 모두 여러 흐름이 동시에 진행된다는 공통점을 가지고 있다. 

하지만 멀티프로세스에서 각 프로세스는 독립적으로 실행되며 각각 별개의 메모리를 차지하고 있는 것과 달리 멀티쓰레드는 프로세스 내의 메모리를 공유해 사용할 수 있다. 또한 프로세스 간의 전환에는 많은 비용이 소모되기 때문에 속도와 비용 측면에서 쓰레드가 유리하기 때문이다.

java에서는 쓰레드를 2가지 방식으로 구현할 수 있다. 

1. `Thread 클래스`를 상속
2. `Runnable 인터페이스`를 구현

---

### Thread 클래스

Thread 클래스를 상속받아 쓰레드를 구현하면, Thread 클래스 내의 run 메소드를 재정의(Override) 하면 된다.

```java
public class ThreadByThread extends Thread {
    @Override
    public void run() {
        System.out.println("Run Thread By Thread");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        ThreadByThread thread =new ThreadByThread();
        thread.start();
    }
}
```

Thread 클래스를 상속받은 객체를 생성하여 start 메소드를 호출함으로써 쓰레드를 생성할 수 있다.

---

### Runnable 인터페이스

Runnable 인터페이스를 구현하여 쓰레드를 구현하면, run 메서드 안에 쓰레드가 할 코드를 작성해주면 된다.

```java
public class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Run Thread By Runnable");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadByRunnable());
        thread.start();
    }
}
```

여기서 Runnable 객체는 Thread객체를 생성하여 Thread 생성자에 파라미터로 넘기어 Thread 타입으로 생성 후 start 메소드를 호출함으로써 쓰레드를 생성할 수 있다.

---

### 쓰레드 상태

`쓰레드 스케줄링`: 쓰레드의 개수가 코어(CPU)의 수보다 많을 경우, 쓰레드를 어떤 순서에 의해 concurrent하게 실행할 것인가를 정하는 작업

![20170126_214028](https://user-images.githubusercontent.com/51703260/134359608-dc4c8f7b-7daf-428c-be60-b4f2e10d5972.png)

`실행 상태`: 실행 대기 상태에 있는 쓰레드 중에서 쓰레드 스케줄링으로 선택된 쓰레드가 CPU를 점유하고 `run()`메소드를 실행한 상태

쓰레드 상태를 확인할 수 있도록 해주는 `getState()` 메소드는 쓰레드 상태에 따른 `Thread.State` 열거 상수를 리턴한다.

|상태|열거 상수|설명|
|:-:|:-:|:-:|
|생성|`NEW`|스레드 객체가 생성된 상태. 아직 `start()` 호출 전|
|대기|`RUNNABLE`|실행될 준비(스케줄러에 의해 선택 받기 전)를 마친 상태. `start()` 호출 됨|
|정지|`WAITING`|다른 스레드로부터 오는 이벤트를 대기하는 상태|
||`TIMED_WAITING`|주어진 시간 동안 대기하는 상태|
||`BLOCKED`|사용하고자 하는 객체의 lock이 풀릴 때까지 대기하는 상태|
|종료|`TERNINATED`|실행이 다 끝난 상태|

`NEW`로 쓰레드 객체를 생성하고, `start()` 메소드를 호출하면 곧바로 쓰레드가 실행되는 것처럼 보이지만 사실은 준비가 완료된 대기 상태이다. 

실행 대기 상태에 있는 쓰레드 중에서 쓰레드 스케줄링으로 선택된 쓰레드만이 실행 상태가 되고, 실행 상태의 쓰레드는 `run()` 메소드를 모두 실행하기 전에 쓰레드 스케줄링에 의해 다시 실행 대기 상태로 돌아갈 수 있다(interrupt). 

그리고 실행 대기 상태에 있는 다른 쓰레드가 선택(scheduler dispatch)되는 방식으로 쓰레드 스케줄링이 이루어 진다.

아래 표는 쓰레드의 상태를 조작할 수 있는 메소드이다. 

|메소드|설명|
|:-:|:-:|
|`static void yield()`|현재 쓰레드가 프로세서의 현재 사용을 양보(yield) 할 의사가 있다는 스케줄러에 대한 힌트이다.|
|`static void sleep(long millis)`|현재 실행중인 쓰레드가 지정된 밀리 초 동안 일시적으로 실행 중지 되도록 한다. 즉, `TIMED_WAITING` 상태로 만든다.|
|`void join(long millis)`|이 쓰레드가 작업이 완료 될 때까지 기다린다.|
|`void interrupt()`|이 쓰레드의 interrupted 상태를 true로 변경한다.|

---

### 쓰레드 우선순위

쓰레드에 우선순위를 부여함으로써 해당 쓰레드가 먼저 끝 날 확률을 높여준다.

하지만, 우선순위가 높다고 해서 무조건 먼저 끝나는 것은 아니다.

<br>

java에서 쓰레드의 우선순위를 설정하는 방법은 `setPriority(int weight)` 메소드를 통해 설정 할 수 있다.

`weight` 파라미터는 숫자가 클수록 우선순위가 높은것이며, 설정 범위는 1부터 10까지 우선순위를 설정할 수 있다.

디폴트 `weight`는 중간값인 5가 설정된다.

---

### Main 쓰레드

Main 쓰레드는 모든 자바 애플리케이션의 시작점이다.

Main 쓰레드로 프로그램이 시작되어 실행을 되고, 멀티 쓰레드는 싱글 쓰레드인 Main 쓰레드에서부터 파생되어 생성된 쓰레드라고 할 수 있다.

참고로, 멀티 쓰레드 어플리케이션에서는 Main 스레드가 종료되더라도 자식 스레드가 종료되지 않으면 어플리케이션이 종료되지 않는다.

```java
public static void main(String[] args) { // 메인 쓰레드 
      Thread thread = new Thread(new ThreadByRunnable());  // 멀티 쓰레드 생성
      thread.start();
}
```

---

### 동기화

멀티쓰레드 프로그래밍에서 여러 쓰레드가 한 프로세스내 자원을 공유하므로 한 쓰레드가 진행중인 작업을 다른 쓰레드 쪽에서 사용, 변경하는 일이 발생할 수 있다.

이러한 문제점을 해결 하기위해 하나의 쓰레드만 영역 내의 코드를 수행하도록 하는 쓰레드 동기화를한다.

java에서 2가지 방식으로 멀티쓰레드 프로그래밍 동기화 할 수 있다. 
 
1. `synchronized` 키워드 사용
2. `java.lang.Object` 클래스의 `wait()`, `notify()`, `notifyAll()` 메소드 사용

#### 1. `synchronized` 키워드 사용

`synchronized` 키워드로 실행 블록이나, 메소드를 임계 구역으로 만들어 동기화 시킬 수 있다.

> 동기화 블록

```java
synchronized(쓰레드 객체){
     // 동기화 시킬 코드
}
```

> 동기화 메소드

```java
public static synchronized void syncMethod(){
   		// 동기화 시킬 코드
}
```

해당 동기화 블록이나, 메소드는 하나의 쓰레드만이 진입될 수 있다.

#### java.lang.Object 클래스의  wait(), notify(), notifyAll() 메소드 사용 

아래 표의 메소드들은 임계 구역에서만 사용 가능하다.

|메소드|설명|
|:-:|:-:|
|`wait()`|다른 스레드가 `notify()`로 불러줄 때까지 대기한다.|
|`notify()`|무작위로 대기 중인 스레드를 깨워 `RUNNABLE` 상태로 변경, 2개 이상의 스레드가 대기 중이라도 오직 한 개의 스레드만 깨워 `RUNNABLE` 상태로 변경한다.|
|`notifyAll()`|대기 중인 모든 스레드를 깨우고 모두 `RUNNABLE` 상태로 변경한다.|

---

### 데드락

데드락은, 두 개 이상의 쓰레드들이 각자 자원을 점유한 상태에서 서로 다른 쓰레드의 자원을 요구하며 모두 무한정 대기중인 상태를 말한다.

즉, 쓰레드1이 자원1을 점유하였고, 쓰레드2가 자원2를 점유한 상태에서 쓰레드1이 자원2를 요청하는데 쓰레드2도 자원 1을 요청하여 서로 자원을 점유한 채 요청만 하며 양보하지 않고 버티는 상황이다.

그렇기 때문에 `yield()`를 사용하여 양보를 하기도 한다. 

---

## Enum

enum 이란 관련이 있는 "상수"의 집합을 정의하는 타입으로 클래스의 특수한 형식이다.

자바5부터 enum 타입이 도입되었고, 변수, 메소드, 생성자를 추가하여 사용할 수 있다.

enum 타입은 여러 특성들이 존재한다.

1. `java.lang.Enum` 클래스(추상 클래스)를 상속한 완전한 클래스이므로 필드와 메소드를 가질 수 있으며, 그러므로 다른 클래스를 상속받을 수 없다.
2. `public static final` 타입으로 공개되며 상수와 동일하게 명칭을 전부 대문자로 정의한다.
3. 고정된 상수들의 집합이기 때문에 런타임이 아닌 컴파일타임에 모든 값을 알고있어야 하므로 생성자의 접근지정자가 `private`로 동적으로 값을 변경하여 생성하면 안된다.
4. singleton 패턴이 적용되어 필드에 존재하는 상수 하나당 하나의 인스턴스가 된다.
5. 싱글톤으로 존재하므로 객체를 `equals()` 메소드가 아닌 `==` 로 비교가 가능하다.

---

### enum 정의하는 방법

```java
public enum CHICEKN {
    [public static final] BBQ("BBQ치킨"),  //CHICEKN.BBQ로 접근
    [public static final] PURADAK("푸다락치킨"), // ;가 아닌 ,
    [public static final] GOOBNE("굽네치킨"); // 내부적으로 new로 생성한 것과 같다.

    private final String name; // 필드를 가질 수 있음

    [private] CHICEKN(String name) { // private 생략
        this.name = name;
    }

    public String getName() { // 메소드를 가질 수 있음
        return name;
    }
}
```

---

### enum이 제공하는 메소드

enum 타입은 java.lang.Enum 클래스를 상속하므로 해당 클래스의 메소드를 사용할 수 있는데,

대표적인 메소드로는 `values()`, `valueOf()`, `ordinal()`이 있다.

|메소드|설명|
|:-:|:-:|
|`values()`|모든 enum 요소들을 enum 타입 배열로 반환|
|`valueOf()`|특정 문자열이 enum 타입으로 존재하면 반환(존재하지 않으면 exception 발생)|
|`ordinal()`|해당 enum 요소의 index를 반환|

---

### EnumSet

이름 그대로 Set을 기반으로 쉽고 빠르게 enum 타입 요소들을 다룰수 있는 기능을 제공한다.

enum은 싱글턴 패턴의 단일 객체임을 보장 함으로 해싱작업을 필요로 하지 않기 때문에 EnumSet은 enum의 요소 갯수가 64개를 넘지 않는다면, 내부적으로 long 데이터형의 64비트 필드를 이용하여 좋은 성능을 보여준다.

대표적인 EnumSet의 메소드로는 `.allOf(enum.class)`, `EnumSet.of(enum1, enum2...)`, `EnumSet.complementOf(enum of EnumSet)`, `EnumSet.range(enum1, enum4)` 가 있다.

|메소드|설명|
|:-:|:-:|
|`.allOf(enum.class)`|enum 타입의 모든 요소들을 가져오기|
|`EnumSet.of(enum1, enum2...)`|특정 enum요소들을 가져오기|
|`EnumSet.complementOf(enum of EnumSet)`|특정한 enum요소를 제외하고 가져오기|
|`EnumSet.range(enum1, enum4)`|범위로 요소들 가져오기|
