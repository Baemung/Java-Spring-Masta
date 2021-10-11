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
	public static void main(String[] args) {
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

1. 수동 확인 작업의 번거로움
    - UserDaoTest는 실제로 프로그램이 동일한지 테스트해주는 것이 아닌 콘솔에 값만 출력해줄 뿐이다. 결국 콘솔에 출력된 결과를 확인하고 타당성을 검증하는 주체는 사람이다.
    - 만약 검증해야 하는 양이 많고 복잡해지면 불편함을 느낄 수밖에 없게 되고, 또한 사람은 실수할 수도 있기 때문에 완벽한 테스트를 수행하지 못할 가능성이 존재한다.
2. 실행 작업의 번거로움
    - 간단히 실행되는 main() 메소드라도 만약 테스트 할 DAO가 수백 개가 된다면 main() 메소드 또한 수백 개가 되므로 테스트에 적잖은 수고가 필요할 수 있다.
    - 또한 수백개 DAO 테스트 결과들을 모두 눈으로 확인하고 정리하는 것은 보통 작업이 아니게 된다. 

---

## UserDaoTest 개선

앞에서 살펴본 UserDaoTest에 존재하는 두가지 문제점을 개선해보자.

### 테스트 검증의 자동화

첫 번째 문제점인 테스트 결과의 검증 부분을 코드로 만들어서 `add()`에 전달한 User 오브젝트에 담긴 사용자 정보와 `get()`을 통해 다시 DB에서 가져온 User 오브젝트의 정보가 서로 정확히 일치하는지 확인해보자.

먼저 모든 테스트는 성공과 실패 두 가지 결과를 가질 수 있다.

테스트 실패에는 **1. 테스트가 진행되는 동안 에러가 발생**하는 경우와 **2. 결과가 기대한 것과 다르게 나와서 실패**하는 경우가 있다.

앞으로 **2.** 만 `테스트 실패`로 부르고 **1.** 은 `테스트 에러`라고 구분하도록 하겠다.

`테스트 에러`는 에러 메시지와 함께 호출 스택 정보가 출력되기 때문에 쉽게 캐치할 수 있지만, `테스트 실패`는 별도의 확인 작업이 동반되어 그 결과가 있어야만 알 수 있다.




---

## Junit

---

## 테스트 적용

---

## 학습 테스트

