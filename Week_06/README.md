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
- [java.lang.Enum](#javalangenum)
- [EnumSet](#enumset)

--- 

## 멀티쓰레드 프로그래밍

먼저 `Process` 와 `Thread`의 차이점을 이해하고 넘어가야 할 필요가 있다. 
 
- `프로세스(Process)` : OS 내에서 실행중인 프로그램

- `쓰레드(Thread)` : 프로세스 내에서 실제 작업이 실행되는 흐름의 단위

따라서 프로세스는 하나 이상의 쓰레드를 가지고 있다.

<br> 

일반적으로 한 프로그램(Process)은 하나의 스레드를 가지고 있지만, 프로그램 환경에 따라 둘 이상의 스레드를 동시에 실행할 수 있다. 이러한 실행 방식을 멀티스레드(multithread)라고 한다.

근데 왜 멀티 프로세스 프로그래밍이 아니라 멀티 쓰레드 프로그래밍을 할까?

멀티 프로세스와 멀티 스레드는 양쪽 모두 여러 흐름이 동시에 진행된다는 공통점을 가지고 있다. 

하지만 멀티 프로세스에서 각 프로세스는 독립적으로 실행되며 각각 별개의 메모리를 차지하고 있는 것과 달리 멀티 스레드는 프로세스 내의 메모리를 공유해 사용할 수 있다. 또한 프로세스 간의 전환에는 많은 비용이 소모되기 때문에 속도와 비용 측면에서 스레드가 유리하기 때문이다.

java에서는 쓰레드를 2가지 방식으로 구현할 수 있다. 

1. `Thread 클래스`를 상속
2. `Runnable 인터페이스`를 구현

---

### Thread 클래스

Thread 클래스를 상속받아 쓰레드를 구현하면, Thread 클래스 내의 run 메소드를 재정의(Override) 하면 된다.

```
public class ThreadByThread extends Thread {
    @Override
    public void run() {
        System.out.println("Run Thread By Thread");
    }
}
```

```
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

```
public class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Run Thread By Runnable");
    }
}
```

```
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
|생성|NEW|스레드 객체가 생성된 상태. 아직 start() 호출 전|
|대기|RUNNABLE|실행될 준비(스케줄러에 의해 선택 받기 전)를 마친 상태. start() 호출 됨|
|정지|WAITING|다른 스레드로부터 오는 이벤트를 대기하는 상태|
||TIMED_WAITING|주어진 시간 동안 대기하는 상태|
||BLOCKED|사용하고자 하는 객체의 lock이 풀릴 때까지 대기하는 상태|
|종료|TERNINATED|실행이 다 끝난 상태|

`NEW`로 쓰레드 객체를 생성하고, `start()` 메소드를 호출하면 곧바로 쓰레드가 실행되는 것처럼 보이지만 사실은 준비가 완료된 대기 상태이다. 

실행 대기 상태에 있는 쓰레드 중에서 쓰레드 스케줄링으로 선택된 쓰레드만이 실행 상태가 되고, 실행 상태의 쓰레드는 `run()` 메소드를 모두 실행하기 전에 쓰레드 스케줄링에 의해 다시 실행 대기 상태로 돌아갈 수 있다(interrupt). 

그리고 실행 대기 상태에 있는 다른 쓰레드가 선택(scheduler dispatch)되는 방식으로 쓰레드 스케줄링이 이루어 진다.

아래 표는 쓰레드의 상태를 조작할 수 있는 메소드이다. 

|메소드|설명|
|:-:|:-:|
|static void yield()|현재 쓰레드가 프로세서의 현재 사용을 양보(yield) 할 의사가 있다는 스케줄러에 대한 힌트이다.|
|static void sleep(long millis)|현재 실행중인 쓰레드가 지정된 밀리 초 동안 일시적으로 실행 중지 되도록 한다. 즉, TIMED_WAITING 상태로 만든다.|
|void join(long millis)|이 쓰레드가 작업이 완료 될 때까지 기다린다.|
|void interrupt()|이 쓰레드의 interrupted 상태를 true로 변경한다.|

---

### 쓰레드 우선순위



---

### Main 쓰레드

---

### 동기화

---

### 데드락

---

## Enum

---

### enum 정의하는 방법

---

### enum이 제공하는 메소드

---

### java.lang.Enum

---

### EnumSet

