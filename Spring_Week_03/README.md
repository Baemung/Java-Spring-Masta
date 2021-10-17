## 🎯 목표
### 스프링 템플릿 이해하기.

### 📌 학습할 것
- [다시보는 초난감 DAO](#다시보는-초난감-dac)
- [변하는 것과 변하지 않는 것](#변하는-것과-변하지-않는-것)
- [JDBC 전략 패턴의 최적화](#jdbc-전략-패턴의-최적화)
- [컨텍스트와 DI](#컨텍스트와-di)
- [템플릿과 콜백](#템플릿과-콜백)
- [스프링의 JDBC 템플릿](#스프링의-jdbc-템플릿)

---

Week 01에서 초난감 DAO 코드에 DI를 적용해나가는 과정에서 관심사가 다른 코드들을 다양한 방법으로 분리해보았다.

이 과정에서 확장에는 자유롭게 열려 있고 변경에는 굳게 닫혀 있다는 `개방 폐쇄 원칙(OPC)`이 적용된 설계구조에 대해서 배울 수 있었다.

`OPC`는 코드에서 어떤 부분은 변경을 통해 그 기능이 다양해지고 확장하려는 성질이 있고, 어떤 부분은 고정되어 있고 변하지 않으려는 성질이 있음을 알려준다.

`템플릿`이란 후자의 성질처럼 변경이 거의 일어나지 않으며 일정한 패턴으로 유지되는 틍성을 가진 부분을 자유롭게 변경되는 성질을 가진 부분으로부터 독립시켜서 효과적으로 개발할 수 있도록 만들어주는 방법이다.

## 다시보는 초난감 DAO

이전까지 개선해왔던 UserDao의 코드에는 예외상황에 대한 적절한 처리가 없기 때문에 그 부분에 대한 개선이 필요하다.

### 예외처리 기능을 갖춘 DAO

DB 커넥션이라는 제한적인 리소스를 공유해 사용하는 서버에서 동작하는 JDBC 코드에 예외처리는 반드시 지켜야 할 원칙이다.

---

## 변하는 것과 변하지 않는 것


---

## JDBC 전략 패턴의 최적화

앞에서 `deleteAll()` 메소드에 담겨 있던 변하지 않는 부분, 자주 변하는 부분을 전략 패턴을 사용해 깔끔하게 분리해냈다. 

이번엔 `add()` 메소드에도 변하는 부분인 **PreparedStatement** 를 만드는 코드를 **AddStatement 클래스** 로 옮겨 담아보며 동일하게 적용해보자.

> UserDao의 add() 메소드
```java
private Datasource dataSource;

public void add(User user) throws ClassNotFoundException, SQLException {
  Connection c = dataSource.getConnection();
  
  PreparedStatement ps = c.preparedStatement("insert into users(id, name, password) values(?, ?, ?)");
  
  ps.setString(1, user.getId());
  ps.setString(2, user.getName());
  ps.setString(3, user.getPassword());
  
  ps.executeUpdate();
  
  ps.close();
  c.close();
}
```

> add() 메소드의 PreparedStatement 생성 로직을 분리한 AddStatement 클래스
```java

public class AddStatement implements StatementStrategy{
  User user; // deleteAll()과는 달리 add()에는 user라는 부가정인 정보가 필요하기 때문에 전략을 수행하기 위해서는 선언해줘야 함.
  
  public AddStatement(User user){ // 생성자를 통해  user 정보를 전달받음.
    this.user = user;
  }
  
  public PreparedStatement makePreparedStatement(Connection c) throws SQLException{
    PreparedStatement ps = c.preparedStatement("insert into users(id, name, password) values(?, ?, ?)");
    
    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());
    
    return ps;
  }
}
```

> user정보를 AddStatement에 전달해주는 add() 메소드
```java
public void add(User user) throws SQLException{
  StatementStrategy st = new AddStatement(user);
  jdbcContextWithStatementStrategy(st);
}
```

이렇게 `deleteAll()` 처럼 `add()` 또한 **PreparedStatement**를 실행하는 **JDBC try/catch/finally 컨텍스트**를 공유해서 사용할 수 있게 됐다.

앞으로 비슷한 기능의 DAO 메소드가 필요할 때 마다 위와 같은 전략을 사용하면 DAO 코드의 양을 많게는 70~80% 가량 줄일 수 있다.

### 전략과 클라이언트의 동거

현재 만들어진 구조를 진단하여 2가지 더 개선할 부분을 찾아보자.

1. DAO 메소드마다 새로운 **StatementStrategy 구현 클래스**를 만들어야 함.

    - 기존 UserDao때보다 클래스 파일의 개수가 많이 늘어나기 때문에, 런타임시에 동적으로 DI 해준다는 점을 제외하면 로직마다 상속을 사용하는 템플릿 메소드 패턴을 적용했을 때보다 그다지 나을 게 없게 된다는 것을 뜻하기 때문에 개선이 필요하다.
2. DAO 메소드에서 **StatementStrategy**에 전달할 User와 같은 부가적인 정보가 있는 경우, 이를 위해 전달받는 생성자와 이를 저장해둘 인스턴스 변수를 번거롭게 만들어야 함.

    - 이 오브젝트가 사용되는 시점은 컨텍스트가 전략 오브젝트를 호출할 때이므로 잠시라도 어딘가에 저장해둘 수밖에 없다.

> 1.을 해결할 수 있는 방법
### 로컬 클래스


> 2.를 해결할 수 있는 방법
### 익명 내부 클래스


---

## 컨텍스트와 DI


---

## 템플릿과 콜백


---

## 스프링의 JDBC 템플릿
