## 🎯 목표
### 자바의 I/O, Generic, Lambda에 대해 학습하기.

## 📌 학습할 것
### [I/O](#io-1)
- [Stream](#stream)
- [표준 Stream](#표준-stream)
- [Channel](#channel)
- [Buffer](#buffer)
- [InputStream](#inputstream)
- [OutputStream](#outputstream)
- [파일 읽고 쓰기](#파일-읽고-쓰기)

### [Generic](#generic)
- [BoundedType](#boundedtype)
- [WildCard](#wildcard)
- [Erasure](#erasure)

### [Lambda](#lambda)
- [Lambda 사용법](#lambda-사용법)
- [함수형 인터페이스](#함수형-인터페이스)
- [Variable Capture](#variable-capture)
- [메소드, 생성자 레퍼런스](#메소드-생성자-레퍼런스)

--- 

## I/O

`I/O`는 Input(입력) and Output(출력)의 약자이다.

I/O의 간단한 예시는, 키보드로 텍스트를 입력하고 모니터로 입력한 텍스트를 출력하는 것이다.

기존의 `IO(I/O)`방식은 스트림 방식의 입출력인데, 이 방식으로는 네트워크상에서 이루어지는 입출력의 속도가 하드웨어에서 이루어지는 입출력 속도에 비해 현저히 느리기 때문에 문제점이 생겼다.

또한 스트림 방식은 병목현상에 매우 취약하다는 단점이 있고 네트워크의 발전보다 하드웨어의 발전속도가 앞서나가면서 새로운 I/O 방식이 필요해졌다.

그래서 이러한 네트워크 환경에서의 문제점을 해결하기 위해서 `NIO(NEW I/O)`방식이 나타났다.

|구분|IO|NIO|
|:-:|:-:|:-:|
|입출력|스트림|채널|
|버퍼|non-버퍼|버퍼|
|비동기|지원 안함|지원|
|블로킹|블로킹만 지원|블로킹 / non-블로킹 모두 지원|

---

### Stream

Stream이란, 한 방향으로 연속적으로 흘러가는 것을 의미한다.

![Untitled](https://user-images.githubusercontent.com/51703260/134504606-d51eed4a-a9bd-41f8-9d45-4050e46ea012.png)

이 Stream이 프로그래밍에서는 자료의 입출력이 한방향으로 흘러갈 수 있도록 도와주는 매개체라는 의미로 사용된다.

Stream이 데이터를 어떤 방식으로 전달하느냐에 따라 2가지로 구분할 수 있다.

1. **`Byte Stream` (바이트 스트림)**
    - 데이터를 Byte 단위로 주고 받음
    - Binary 데이터를 입출력하는 스트림
    - **모든 종류의 데이터** 를 주고받을 수 있음
    - `InputStream`과 `OutputStream` 클래스를 상속받아 사용
    - ---
    - `FileInputStream` / `FileOutputStream` : 파일 입출력 스트림
    - `ByteArrayInputStream` / `ByteArrayOutputStream` : 메모리 입출력 스트림
    - `PipedInputStream` / `PipedOutputStream` : 프로세스 입출력 스트림
    - `AudioInputStream` / `AudioOutputStream` : 오디오 장치 입출력 스트림

자바에서 가장 작은 타입인 char 형이 2바이트이므로, 1바이트씩 전송되는 바이트 기반 스트림으로는 원활한 처리가 힘든 경우가 있다. 이러한 경우를 해결하기 위해 자바는 `Character Stream`을 지원함

2. **`Character Stream` (문자 스트림)**
    - 데이터를 Character 단위로 주고 받음
    - 문자 데이터를 인코딩 처리하여 입출력하는 스트림
    - 오직 **문자 데이터** 만 주고받을 수 있음
    - `Reader`와 `Writer` 클래스를 상속받아 사용
    - ---
    - `FileReader` / `FileWriter` : 파일 입출력 스트림
    - `CharArrayReader` / `CharArrayWriter` : 메모리 입출력 스트림
    - `PipedReader` / `PipedWriter` : 프로세스 입출력 스트림
    - `StringReader` / `StringWriter` : 문자열 입출력 스트림

두 Stream은 모두 처음에는 byte로 받아들이고, 그 다음은 각 Stream이 알아서 처리를 해준다.

---

### 표준 Stream

`System` Class는 자바에서 미리 정의해둔 표준 입출력 클래스이며, `java.lang` 패키지에 포함되어 있다.

- `System.in` : 표준 입력 스트림
- `System.out` : 표준 출력 스트림
- `System.err` : 표준 에러 출력 스트림

---

### Channel

`서버와 클라이언트간의 통신수단`을 의미한다. 

일반적으로 NIO(new I/O)의 모든 I/O는 채널로 시작한다. 

채널은 스트림과 유사하지만 몇 가지 차이점이 존재한다.
- **비동기적** 입출력
- `스트림`은 단방향 **입출력(읽기 또는 쓰기)** 만 가능하지만 `채널`을 통해서는 **양방향 입출력(읽고 쓰기)** 이 가능하다 있다.
- 항상 `버퍼`를 이용하여 입출력을 한다.

---

### Buffer

**데이터를 임시 저장하는 공간**을 의미한다.

`IO`에서는 출력 스트림이 1바이트를 쓰면 입력 스트림이 1바이트를 읽는다.

`NIO`에서 버퍼는 채널과 상호작용할 때 사용된다. 커널에 의해 관리되는 시스템 메모리를 직접 사용할 수 있는 채널에 의 해 직접 read 되거나 write 될 수 있는 배열과 같은 객체이다.

입출력을 담당하는 장치, 프로세스에서 고속 장치(프로세스)가 저속 장치(프로세스)가 작업을 하는 동안 기다리는 시간을 줄여 개별 작업들 간의 협동을 원활하게 지원하기 위해 존재한다.

따라서, 1바이트씩 전달이 아니라 기다리는 동안 버퍼에 데이터를 축척하여 한번에 전달하여 빠른 속도를 보인다.

---

### InputStream

`Byte Stream`기반의 입력 스트림의 최상위 클래스(추상클래스)로써 모든 Byte기반 입력 스트림은 이 클래스를 상속받고 데코레이터 패턴으로 기능을 추가하는 방식으로 스트림이 만들어진다.

`InputStream` 클래스에는 입력을 위해 필요한 기본적인 메소드들이 정의되어 있다.

- `int available()` : 현재 읽을 수 있는 byte수를 리턴
- `abstract int read()` : InputStream으로부터 1byte를 읽고 리턴.
- `int read(byte[] b)` : InputStream으로부터 읽은 바이트들을 byte[] b에 저장하고 읽은 바이트 수를 리턴.
- `int read(byte[] b, int off, int len)` : InputStream으로부터 **len** byte만큼 읽어 byte[] b의 b[ **off** ] 부터 **len** 개까지 저장한 후 읽은 byte 수인 **len** 개를 리턴. 만약 **len** 개보다 적은 byte를 읽는 경우 실제 읽은 byte수를 리턴
- `void close()` : 사용한 시스템 리소스를 반납 후 입력 스트림을 닫는 메소드.close() : 사용한 시스템 리소스를 반납 후 InputStream을 닫음.

---

### OutputStream

OutputStream 또한 `Byte Stream`기반의 출력 스트림의 최상위 클래스(추상클래스)로써 모든 Byte기반 출력 스트림은 이 클래스를 상속받고 데코레이터 패턴으로 기능을 추가하는 방식으로 스트림이 만들어진다.

`OutputStream` 클래스에도 출력을 위해 필요한 기본적인 메소드들이 정의되어 있다.

- `void flush()` : 버퍼에 남아있는 OutputStream을을 출력
- `abstract void write(int b)` : 정수 b의 하위 1byte를 출력
- `void write(byte[] b)` : 버퍼의 내용을 출력
- `void write(byte[] b, int off, int len)` : b 배열 안의 시작점 **off** 부터 **len** 만큼 출력
- `void close()` : 사용한 시스템 리소스를 반납 후 OutputStream을 닫음.

---

### 파일 읽고 쓰기

자바의 내장 클래스인 `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`를 사용하여 파일을 읽고 쓸 수 있다.

```java
File file = new File(PATH);

FileWriter fw = new FileWriter(file);
FileReader fr = new FileReader(file);
BufferedWriter bw = new BufferedWriter(fw);
BufferedReader br = new BufferedReader(fr);
```

`FileReader`, `FileWriter`와 `BufferedReader`, `BufferedWriter`는 데코레이터 패턴이 적용됨을 알 수 있다.

--- 

## Generic

`Java 5`부터 추가되어 클래스와 인터페이스, 메소드를 정의할 때 `타입 변수`를 사용할 수 있게 하는 방법이다.

- **`타입 변수`** : 일반적으로 대문자 알파벳 한 글자로 표현한다.
  - `<T>` :	Type
  - `<E>` :	Element
  - `<K>` :	Key
  - `<N>` :	Number
  - `<V>` :	Value
  - `<R>` :	Return

컴파일 시의 객체의 타입을 체크를 해주는 기능을 제공함으로써 안정성을 높이고 형변환의 번거로움을 줄여준다.

`Collection` 라이브러리에서 흔히 `Generic`이 활용된다.
```java
//List<T>
List<Integer> listG = new ArrayList<>(); // 제네릭
listG.add(1);
int temp = listG.get(0);

List listNG = new ArrayList(); // 제네릭 사용 X
listNG.add(1);
temp = (int)listNG.get(0); // 형변환 필요
```

Generic은 `Generic 타입`과 `Generic 메소드`로 구분할 수 있다.

#### `Generic 타입`

타입 변수가 있는 클래스 또는 인터페이스

```java
class GenericClass<T> {
     ...
}

interface  GenericInterface<T> {
     ...
}
```

#### `Generic 메소드`

매개 타입과 리턴 타입으로 타입 변수를 갖는 메소드

```java
public <T, R> R genericMethod(T t) { }
```

#### 제네릭을 사용할 수 없는 경우

1. **제네릭 타입의 배열을 생성할 경우** : new T[N]은 컴파일 타임에 배열의 타입을 알 수 없기 때문에 사용할 수 없다.

2. **static 변수에 사용할 경우** : static 변수는 인스턴스에 종속되지 않으므로 인스턴스별 타입이 변경될 수 없기 때문에 사용할 수 없다. (단, static 메소드에는 제네릭 사용 가능)

<br>

Generic의 주요 개념으로는 `Bounded-Type`과 `Wild-Card`가 있다.

---

### BoundedType

`Bounded-Type`은 제네릭으로 사용될 타입 변수의 범위를 제한하는 것이다.

Generic 타입에 `extends`를 사용하여 타입 변수의 범위를 제한한다. (인터페이스, 클래스 모두 상관없이 `extends`를 사용)

```java
public class CustomGeneric<T extends Number> {
     ...
}

CustomGeneric<Integer> listI = new CustomGeneric<();
CustomGeneric<String> listS = new CustomGeneric<>(); // Bounded-Type으로 타입 변수를 Number로 제한했기 때문에 컴파일 에러 발생!
```

```java
public class CustomGeneric<T extends ClassName & InterfaceName> { // & 기호를 사용하여 타입 변수를 클래스와 인터페이스 2개로 제한 가능 
     ...
}
```

---

### WildCard

제네릭 타입을 메소드의 매개값으로 전달할 때 구체적인 타입으로만 타입 제한이 생긴다 그러한 문제를 해결하기 위해 와일드 카드를 사용한다.

`?` 키워드를 사용하여 와일드 카드를 사용할 수 있다.

- `제네릭 타입 <?>` : 제한 없음. 모든 클래스나 인터페이스 가능
- `제네릭 타입 <? extends 상위 타입>` : 타입의 상한선 지정(해당 타입 및 하위타입만, 최상이 제시한 타입), 최대 제시된 상위 타입보다 더 상위 타입을 사용할 수 없음
- `제네릭 타입 <? super 하위 타입>` : 타입의 하한선 지정(해당 타입 및 상위타입만, 최하가 제시한 타입), 최소 제시된 하위 타입보다 더 하위 타입을 사용할 수 없음

---

### Erasure

- `제네릭의 타입 소거(Generics Type Erasure)` : 컴파일러는 제네릭 타입을 이용해 소스파일을 검사하고 런타임에는 해당 타입의 정보를 알 수 없다는 개념이다. 즉, 컴파일된 파일`*.class`에는 제네릭 타입에 대한 정보가 없다는 뜻.

#### Erasure 규칙
- `UnBounded-Type`은 Object
  - ex) `(<?>, <T>)` => Object
- `Bounded-Type`은 extends 뒤에 작성한 객체
  - ex) `<T extends Number>` => Number

---

## Lambda

---

### Lambda 사용법

---

### 함수형 인터페이스

---

### Variable Capture

---

### 메소드, 생성자 레퍼런스

