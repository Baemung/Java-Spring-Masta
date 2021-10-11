## 🎯 목표
### 스프링 테스트 이해하기.

### 📌 학습할 것
- [UserDaoTest 리뷰](#userdaotest-리뷰)
- [UserDaoTest 개선](#userdaotest-개선)
- [Junit](#junit)
- [테스트 적용](#테스트-적용)
- [학습 테스트](#학습-테스트)

---

> **Q. 스프링이 개발자에게 제공하는 가장 중요한 가치는 무엇인가?**
>
> A. `객체지향` `테스트`

 어플리케이션은 계속 변하고 복합해지는데, 그러한 변화에 대응하는 **첫 번째 전략**이 확장과 변화를 고려한 객체지향적 설계를 효과적으로 담아낸 `IoC`/`DI`과 같은 기술이다.
 
 그리고 **두 번째 전략**은 변화된 코드가 여전히 정상적인 기능을 수행할 수 있는지 확신할 수 있게 해줘 변화에 유연하게 대처할 수 있는 자신감을 주는 `테스트` 기술이다.
 
 스프링으로 개발을 하면서 테스트를 만들지 않는다면 이는 스프링이 지닌 가치의 절반을 포기한다해도 과언이 아니다.
 
 또한 테스트는 스프링의 다양한 기술을 활용하는 방법을 이해하고 검증하고, 실전에 적용하는 방법을 익히는 가장 효과적인 방법의 하나이다.

## UserDaoTest 리뷰

> UserDaoTest.java
```java
public class UserDaoTest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("user");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}
} 
```

### UserDaoTest의 문제점
UserDaoTest가 수동 테스트와 비교해서 장점도 있지만, 문제점 또한 존재한다.

1. **수동 확인 작업의 번거로움**
    - UserDaoTest는 실제로 프로그램이 동일한지 테스트해주는 것이 아닌 콘솔에 값만 출력해줄 뿐이다. 결국 콘솔에 출력된 결과를 확인하고 타당성을 검증하는 주체는 사람이다.
    - 만약 검증해야 하는 양이 많고 복잡해지면 불편함을 느낄 수밖에 없게 되고, 또한 사람은 실수할 수도 있기 때문에 완벽한 테스트를 수행하지 못할 가능성이 존재한다.
2. **실행 작업의 번거로움**
    - 간단히 실행되는 main() 메소드라도 만약 테스트 할 DAO가 수백 개가 된다면 main() 메소드 또한 수백 개가 되므로 테스트에 적잖은 수고가 필요할 수 있다.
    - 또한 수백개 DAO 테스트 결과들을 모두 눈으로 확인하고 정리하는 것은 보통 작업이 아니게 된다. 

---

## UserDaoTest 개선

앞에서 살펴본 UserDaoTest에 존재하는 두가지 문제점을 개선해보자.

### 테스트 검증의 자동화

첫 번째 문제점인 테스트 결과의 검증 부분을 코드로 만들어서 `add()`에 전달한 User 오브젝트에 담긴 사용자 정보와 `get()`을 통해 다시 DB에서 가져온 User 오브젝트의 정보가 서로 정확히 일치하는지 확인해보자.

먼저 모든 테스트는 성공과 실패 두 가지 결과를 가질 수 있다.

테스트 실패에는 **1. 테스트가 진행되는 동안 에러가 발생**하는 경우와 **2. 결과가 기대한 것과 다르게 나와서 실패**하는 경우가 있다.

앞으로  **1.** 은 **테스트 에러** 라고 구분하고, **2.** 만 **테스트 실패** 로 부르도록 하겠다.

**테스트 에러**는 에러 메시지와 함께 호출 스택 정보가 출력되기 때문에 쉽게 캐치할 수 있지만, **테스트 실패**는 별도의 확인 작업이 동반되어 그 결과가 있어야만 알 수 있다.

<br>

밑의 코드는 기존의 UserDaoTest에서 `get()`으로 출력된 결과를 직접 사람이 확인해야 했던 것을 개선하여 테스트 코드에서 직접 결과를 확인하고 기대한 결과와 비교하는 코드이다.

만약 기대한 결과와 달라서 테스트 실패했을 경우 **"테스트 실패"** 라고 출력한다. 그리고 모든 확인 작업을 통과한다면, **"테스트 성공"** 이라고 출력한다.

```java
// 수정 전 테스트 코드
System.out.println(user2.getName());
System.out.println(user2.getPassword());
System.out.println(user2.getId() + " 조회 성공");
```

```java
// 수정 후 테스트 코드
if(!user.getName().equals(user2.getName())) 
	System.out.println("테스트 실패 (name)");
else if(!user.getPassword().equals(user2.getPassword())) 
	System.out.println("테스트 실패 (password)");
else 
	System.out.println("조회 테스트 성공");
```

위 테스트는 add()에 전달한 User 오브젝트와 get()을 통해 가져오는 User 오브젝트의 값을 필드별로 비교해서 확인하는 것이다.

add() 메소드 같은 경우는 호출하고 나서 에러가 발생하지 않으면 일단 성공으로 간주하고, get()을 통한 과정에서 테스트 하는 과정에서 사실 add()의 작업도 함께 확인한다고 할 수 있다.
 
만약 add() 메소드의 잘못으로 등록이 제대로 안됐다면 뒤의 테스트 코드를 통과하지 못하기 때문이다.

이 테스트는 수행과 테스트 값 적용, 결과 검증까지 모두 자동화하여 UserDao의 두 가지 기능 `add()` `get()` 이 정상적으로 동작하는지를 언제든지 손쉽게 확인할 수 있게 해준다.

<br>

### 테스트의 효율적인 수행과 결과 관리

자동화를 통해서 UserDaoTest에 존재하는 두가지 문제점 중 첫 번째 **수동 확인 작업의 번거로움**을 개선하고 테스트로서 필요한 기능은 모두 갖추게 되었다.

하지만 어플리케이션의 규모가 커지고 테스트 개수가 많아지게 되면 main() 메소드에서 테스트를 수행하고, 결과를 확인하기에는 부담이 있다.

이미 자바에는 단순하면서도 실용적인 테스트를 위한 도구가 여러 가지 존재한다. 그 중에서도 유명한 테스팅 프레임워크인 `JUnit`은 이름 그대로 자바로 단위 테스트를 만들 때 아주 유용하게 쓸 수 있다.

#### JUnit 테스트로 전환

이제 지금까지 만들었던 main() 메소드 테스트를 JUnit을 이용해서 다시 작성해보록 하자.

JUnit은 프레임워크라서 마찬가지로 `IoC`를 기본 동작원리로 동작한다. 따라서 프레임워크가 어플리케이션의 흐름을 제어하기 때문에 사용자가 작성한 **main() 메소드도 필요 없고, 오브젝트를 만들어서 실행시키는 코드 또한 필요없다.**

그렇기 때문에 가장 먼저 할 일은 main() 메소드에 있던 테스트 코드를 JUnit 프레임워크가 요구하는 2가지 조건을 따라 새로운 메소드로 작성하여야 한다.

1. **`@Test` Annotation을 붙여줘야 함**
2. **테스트 메소드가 `public`으로 선언돼야 함**


아래 코드는 JUnit 프레임워크에서 동작할 수 있도록 UserDaoTest의 main()메소드를 재구성하여 2가지 조건을 충족시킨 일반 메소드이다.

```java
import org.junit.Test;

public class UserDaoTest{
	// 조건 1. @Test Annotation을 붙여줘야 함
	@Test 
	// 조건 2. 테스트 메소드가 public으로 선언돼야 함
	public void addAndGet() throws SQLException { 
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
	}
}
```

#### 검증 코드 전환

이제 if/else로 작성했던 테스트 결과 검증 코드를 JUnit이 제공하는 방법으로 변경해보자.

```java
if(!user.getName().equals(user2.getName())) 
	System.out.println("테스트 실패 (name)");
else if(!user.getPassword().equals(user2.getPassword())) 
	System.out.println("테스트 실패 (password)");
```

위 코드는 아래와 같이 변경할 수 있다.

```java
assertThat(user2.getName(), is(user.getName()));
assertThat(user2.getPassword(), is(user.getPassword()));
```

`assertThat()` 메소드는 첫 번째 파라미터의 값을 뒤에 나오는 `매처(Matcher)`라고 불리는 조건으로 비교해서 일치하면 넘어가고, 불일치하면 테스트가 실패하도록 만들어준다.

`is()` 는 매처의 일종으로, `equals()`로 비교해주는 기능을 가졌다.

`JUnit`은 예외가 발생하거나, assertThat()에서 실패하지 않고 테스트 메소드의 실행이 완료되면 테스트가 성공했다고 인식하며, "테스트 성공"이라는 메세지를 굳이 출력할 필요없이 테스트를 실행하면 테스트 결과를 다양한 방법으로 알려준다.

아래 코드는 UserDaoTest 클래스를 JUnit 프레임워크에서 실행될 수 있게 수정한 코드다.

```java
import static org.harmcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
...

public class UserDaoTest{
	@Test 
	public void addAndGet() throws SQLException { 
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("user");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}
}
```
> 라이브러리 추가 : com.springsource.org.junit-X.X.X.jar (X.X.X는 JUnit 버전)

#### JUnit 테스트 실행

위 코드는 main() 메소드가 아니기 때문에 위 테스트 메소드를 실행할 수 있는 main() 메소드가 필요하다.

JUnit 프레임워크도 Spring 컨테이너와 마찬가지로 자바 코드로 만들어진 프로그램이므로 어딘가에서 한 번은 JUnit 프레임워크를 시작시켜 줘야 한다.

테스트를 실행 시킬 일반 main() 메소드안에 JUnitCore 클래스의 main() 메소드를 호출해주면 JUnit 프레임워크를 시작할 수 있다.

```java
import org.junit.runner.JUnitCore;
...
public static void main(String[] args){
	JUnitCore.main("springbook.user.dao.UserDaoTest");
}
```

위 코드를 실행하면 다음과 같은 메시지가 출력될 것이다.

```
JUnit version X.X // JUnit 버전
Time: 0.XXX // 테스트 실행하는 데 걸린 시간
OK (1 test) // 테스트 결과 및 몇 개의 테스트 메소드가 실행
```

만약  assertThat()의 검증에서 실패하여 테스트에 실패한다면 다음과 같은 메시지가 출력될 것이다.

```
JUnit version X.X // JUnit 버전
Time: 1.XXX // 테스트 실행하는 데 걸린 시간
There was 1 failure:
1) addAndGet(springbook.user.dao.UserDaoTest) // 검증에 실패한 테스트 메소드
java.lang.AssertionError: // 기대한 결과가 아닐 때 발생
Expected: is "백기선" // 기대 값
	got: null // 실행 값
	...
	at springbook.user.dao.UserDaoTest.main(UserDaoTest.java:36) // 검증에 실패한 테스트 코드 위치
FAILURES!!! // 테스트 실패
Tests run: 1, Failures: 1 // 총 몇 개의 테스트 메소드가 실행되고, 그 중 몇개의 테스트가 실패
```

테스트 수행 중에 assertThat()의 조건을 만족하지 못하거나, 일반 예외가 발생하면 테스트는 더 이상 진행되지 않고 중단되며 테스트는 실패하게 된다.

---

## Junit

---

## 테스트 적용

---

## 학습 테스트

