## π― λͺ©ν
### μλ°μ Class μ Interfaceμ λν΄ νμ΅νκΈ°.

### π νμ΅ν  κ²
### [ν΄λμ€](#-ν΄λμ€)
- [ν΄λμ€ μ μ](#-ν΄λμ€-μ μ)
- [ν΄λμ€ κ΅¬μ±](#-ν΄λμ€-κ΅¬μ±)
- [ν΄λμ€ μμ±](#-ν΄λμ€-μμ±)
- [new ν€μλ](#-new-ν€μλ)
- [this ν€μλ](#-this-ν€μλ)
- [super ν€μλ](#-super-ν€μλ)

### [μΆμ ν΄λμ€](#μΆμ-ν΄λμ€)

### [μΈν°νμ΄μ€](#-μΈν°νμ΄μ€)
- [μΈν°νμ΄μ€ μ μ](#-μΈν°νμ΄μ€-μ μ)
- [μΈν°νμ΄μ€ κ΅¬ν](#-μΈν°νμ΄μ€-κ΅¬ν)

--- 

## π¨π± ν΄λμ€
### π‘ ν΄λμ€ μ μ

μλ°μμ ν΄λμ€λ μ μ¬ν νΉμ§λ€μ μ§λ κ°μ²΄λ€μ μμ±κ³Ό νμλ€μ μ μν΄λμ μ€κ³λμ κ°μ κ²μ΄λ€.<br>
μ΄ μ€κ³λλ₯Ό μ΄μ©ν΄μ λμΌν νΉμ§μ κ°μ²΄λ₯Ό μ°μ΄λ΄λ νκ³Ό κ°μ μ­ν μ νλ€.

**`κ°μ²΄`** : μ€μΈκ³(Real World)μ μ‘΄μ¬νλ μ /λ¬΄νμ **λͺ¨λ  κ²**

μμ±(λͺμ¬ν)κ³Ό νμ(λμ¬ν)λ₯Ό κ°λλ€.

ex) **μλμ°¨** (μ ν)

- μμ± : μ£Όνκ±°λ¦¬, μ°¨μ’, μμ, λ§λ ₯,,, 
- νμ : μλμΌκΈ°, μλλκΈ°, μ£ΌννκΈ°,,, 
    
ex) **κ³μ’** (λ¬΄ν)

- μμ± : κ³μ’λ²νΈ, μκΈμ£Ό, μμ‘, μ΄μ²΄νλ,,,
- νμ : μμ‘μ‘°ν, μκΈ, μΆκΈ, μ‘κΈ,,, 

|ν΄λμ€|κ°μ²΄|
|:-:|:-:|
|λΆμ΄λΉ΅ν|λΆμ΄λΉ΅|
|κ³΅μ₯ μμ°λΌμΈ|μ ν|
|κ±΄λ¬Όμ€κ³λ|κ±΄λ¬Ό|

κ°μ ν΄λμ€λ‘λΆν° μμ±λ κ°μ²΄λ λͺ¨λ κ°μ μμ±κ³Ό νμλ₯Ό κ°μ§λλ°, κ°μ²΄λ§λ€ κ³ μ ν μμ±κ°μ κ°μ§ μ μλ€.

**μ¦, κ°μ ν΄λμ€μμ μμ±λ κ°μ²΄λΌλ λͺ¨λ λ€λ₯΄λ€!**

---

ν΄λμ€λ μ κ·Όμ μ΄μμ ν¨κ» `class ν€μλ`λ₯Ό μ¬μ©ν΄μ μ μν  μ μλ€.

```java
[μ κ·Ό μ μ΄μ] class XXX{
    νλ
    μμ±μ
    λ©μλ
}
```

λ§μ½ public classλ‘ ν΄λμ€λ₯Ό μ μνλ©΄ ν΄λΉ μμ€μ½λ(.java)μ μ΄λ¦μ λ°λμ ν΄λΉ ν΄λμ€μ μ΄λ¦μΌλ‘ μμ±λμ΄μΌ νλ€.

> ex) public class Baemung ==> Baemung.java

κ·Έλ¦¬κ³  ν΄λμ€λ₯Ό μ μν  λ, ν΄λμ€ μ΄λ¦ μ²«κΈμλ λ³΄ν΅ λλ¬Έμλ‘ μμνλ `νμ€μΉΌ νκΈ°λ²(PascalCase)`μ μ¬μ©νλ€.

ν΄λμ€μμ λ€λ₯Έ ν΄λμ€λ₯Ό μ μνλ κ²λ κ°λ₯νλ€. <br>
μ΄λ κ² νλμ ν΄λμ€ νμΌμ μ¬λ¬ ν΄λμ€λ₯Ό μ μνμ λ [μμ€μ½λλ₯Ό μ»΄νμΌνλ©΄ κ° ν΄λμ€λ§λ€ .class νμΌμ΄ μμ±λλ κ²μ νμΈν  μ μλ€.](../../../tree/main/Java_Week_01/#-μ»΄νμΌ-λ°-μ€ννλ-λ°©λ²)

ν΄λμ€λ₯Ό μ μν  λ κ°μ²΄λ€μ μμ±κ³Ό νμλ₯Ό `νλ`μ `λ©μλ`λ‘ μ μν  μ μλ€.

|κ°μ²΄|ν΄λμ€|
|:-:|:-:|
|μμ±|νλ (ν΄λμ€λ³μ(static), μΈμ€ν΄μ€λ³μ(non-static))|
|νμ|λ©μλ|

- μ¬λ (κ°μ²΄)
   - μμ± : μ΄λ¦, λμ΄
   - νμ : λμ΄λ¨ΉκΈ°, μ μκΈ°,,,


- Person (ν΄λμ€)

> Person.java

```java
public class Person{
    //field
    String name;
    int age;
    
    //constructor
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    //method
    increaseAge(){}
    Sleep(){}
}
```

### π‘ ν΄λμ€ κ΅¬μ±

#### 1. [**νλ(field)**](../../../tree/main/Java_Week_02/#-λ³μμ-μ€μ½νμ-λΌμ΄ννμ)

ν΄λμ€μ νλ(field)λ ν΄λμ€μ ν¬ν¨λ λ©€λ² λ³μ(variable)

- **`ν΄λμ€ λ³μ(static variable)`**
    - ν΄λμ€μ μν
    - ν΄λμ€ λ©λͺ¨λ¦¬ λ‘λμ 1λ²λ§ ν λΉ
    
- **`μΈμ€ν΄μ€ λ³μ(instance variable)`**
    - κ°μ²΄μ μν
    - κ°μ²΄ μμ±μλ§λ€ ν λΉ

#### 2. **λ©μλ(method)**

ν΄λμ€μμ λ©μλ(method)λ μ΄λ ν νΉμ  μμμ μννκΈ° μν λͺλ Ήλ¬Έμ μ§ν©

- **`ν΄λμ€ λ©μλ(static method)`**
    - ν΄λμ€ κ΄μ μμμ νμ
    - κ°μ²΄ μλ³μ ν΄μΌλ§νλ μμX
    - κ°μ²΄λ₯Ό μμ±νμ§ μκ³ λ μ€νν  μ μλ μμ
    
- **`μΈμ€ν΄μ€ λ©μλ(instance method)`**
    - κ°μ²΄ κ΄μ μμμ νμ
    - κ°μ²΄ μλ³μ ν΄μΌλ§ νλ μμ O
    - κ°μ²΄ κ΄λ ¨ μμ

#### 3. **μμ±μ(constructor)**

ν΄λμ€λ₯Ό μμ±ν  λ, νλ(μΈμ€ν΄μ€ λ³μ) κ°λ€μ μ΄κΈ°ν μν€κΈ° μν νΉλ³ν λ©μλ<br>
κ°μ²΄ μ΄κΈ°νμ λ€μμ± μ κ³΅

#### 4. **μ€μ²© ν΄λμ€(Nested Class, Inner Class)**
- ν΄λμ€ μ ν΄λμ€
    
#### 5. **Initializer**
- **Static Initializer**
> static{ μ€νλ¬Έμ₯ } : ν΄λμ€ λ©λͺ¨λ¦¬ λ‘λμ μλμ€ν 
- **Instance Initializer**
> { μ€νλ¬Έμ₯ } : κ°μ²΄ μμ±μ λ§λ€ μλμ€ν --> μμ±μ λλ¬Έμ μ μ¬μ© μν¨
    
--- 

### π‘ ν΄λμ€ μμ±

- ν¨ν€μ§ μ μΈλ¬Έ (0 or 1)
``` java
package top.sub....; 
// λ¬Όλ¦¬μ  : ν΄λ
// λ³΄ν΅ domain name(Unique!) μ­μμ¬μ©
```

- importλ¬Έ (0 ~ ε€) 
``` java
import top.sub...ν΄λμ€μ΄λ¦; // μμ€ ν΄λμ€λͺ λ°λ‘μ¬μ©
import top.sub...*; // all classes, interfaces
(not package) : importλ¨μλ ν¨ν€μ§ μλ!

ν ν΄λμ€μμμ μ°Έμ‘°, μ¬μ©νλ ν΄λμ€κ° μμ κ³Ό κ°μ ν¨ν€μ§κ° μλ κ²½μ° λͺμ
λ¨, java.langμ μλμΌλ‘ λΆλ¬μ΄
```

- class μ μ (1 ~ ε€)
``` java
** []λ μν©μ λ°λΌ μλ΅κ°λ₯ν¨

* ν΄λμ€μ μ
[μ κ·Όμ§μ μ] [νμ©μ§μ μ] class ν΄λμ€λͺ [extends λΆλͺ¨ν΄λμ€λͺ] [implements λΆλͺ¨μΈν°νμ΄μ€λͺ,,,] { } 

// μ κ·Όμ§μ μ
(default),public

// νμ©μ§μ μ
final : μμκΈμ§
abstract : μΆμν΄λμ€ (λ―Έμμ±ν΄λμ€)

// ν΄λμ€λͺ
λͺμ¬ν, μ²«κΈμ λλ¬Έμ, μΉ΄λ©νκΈ°λ²

// extends 
ν΄λμ€ λ¨μΌμμ

// implements
μΈν°νμ΄μ€ λ€μ€μμ



* λ©€λ²μ μ
[μ κ·Όμ§μ μ] [νμ©μ§μ μ] DataType λ³μλͺ [=μ΄κΈ°κ°];

// μ κ·Όμ§μ μ
public,protected,(default),private

// νμ©μ§μ μ
static : ν΄λμ€λ©€λ²
final : μμν, μμ±μμμ μ΄κΈ°ν νμ
static final : μ΄μ°¨νΌ μμμ΄κΈ° λλ¬Έμ staticμΌλ‘ μ¬μ©
transient : κ°μ²΄μ§λ ¬ν λμμ μΈ

// λ³μλͺ
λͺμ¬ν, μ²«κΈμ μλ¬Έμ, μΉ΄λ©νκΈ°λ²

// μ΄κΈ°κ°
μλ΅μ defaultκ°μΌλ‘ μ΄κΈ°ν (0, null, false)



* λ©μλμ μ
[μ κ·Όμ§μ μ] [νμ©μ§μ μ] returnType λ©μλλͺ ([λ§€κ°λ³μμ μΈ,,,]) [throws Exceptionλͺ,,,] 
{
    μ€νλ¬Έμ₯ 
    [return λ¦¬ν΄κ°]
}

// μ κ·Όμ§μ μ
public,protected,(default),private

// νμ©μ§μ μ
static : κ°μ²΄ μμ±μμ΄ 'ν΄λμ€μ΄λ¦.λ©μλμ΄λ¦()'μΌλ‘ νΈμΆ κ°λ₯, λ©μλ λ΄μμ μΈμ€ν΄μ€ λ³μ μ¬μ© λΆκ°
final : λ©μλ μ¬μ μ X
synchronized : κ°μ²΄ λκΈ°νλ₯Ό μν μ κΈ
abstract : λ©μλ μΆμν

// return λ¦¬ν΄κ°
void : μμ -> returnλ¬Έ μλ΅κ°λ₯
not void : returnκ° λͺμ



* μμ±μ
[μ κ·Όμ§μ μ] ν΄λμ€λͺ ([λ§€κ°λ³μμ μΈ,,,]) [throws Exceptionλͺ,,,] {}

// μ κ·Όμ§μ μ
public,protected,(default),private

```

### π‘ new ν€μλ

**κ°μ²΄λ₯Ό μμ±ν  λλ new λΌλ ν€μλλ₯Ό μ¬μ©νλ€.**

`new ν€μλ`λ λ©λͺ¨λ¦¬μμ κ³΅κ°μ ν λΉνκ³ , ν λΉλ°μ κ³΅κ°μ μ£Όμκ°μ λ°ννλ€.

μλ°μμ Primitive Typeμ μ μΈν νμ μ¦, Reference Typeμ λ³μλ₯Ό μ΄κΈ°ν μν€λ©΄ κ°μ²΄λ₯Ό Heap μμ­μ μ μ₯νκ³  λ νΌλ°μ€ νμμ λ³μμλ new ν€μλκ° μ£Όμκ°μ κ°μ§κ³  Stack μμ­μ μ μ₯λλ€.

new λΌλ ν€μλλ λ©λͺ¨λ¦¬μμ κ³΅κ°μ ν λΉνκ³ , ν λΉλ°μ κ³΅κ°μ μ£Όμλ₯Ό λ¦¬ν΄νλ€.


```java
// ν΄λμ€μ΄λ¦ μ°Έμ‘°λ³μ = new μμ±μνΈμΆ; -> κ°μ²΄μμ±μ μ΄κΈ°νλ₯Ό λ΄λΉνλ νΉλ³ν λ©μλ
Person p1 = new Person("λ°°λ¬Έκ·", 29);
Person p2 = new Person("μ λ€μ΄", 29);
```
μ μμ€μ½λλ₯Ό μ€ννλ©΄

1. Class Areaμ Person λ°μ΄νΈμ½λκ° μ¬λΌκ°

2. new ν€μλκ° λ©λͺ¨λ¦¬μμ κ³΅κ°μ ν λΉνμ¬ Heapμ μΈμ€ν΄μ€ λ³μκ° μ¬λ¦Ό

3. new ν€μλκ° μΈμ€ν΄μ€λ³μμ λ©λͺ¨λ¦¬ μ£Όμλ₯Ό λ¦¬ν΄νμ¬ Stackμ p1, p2 λ νΌλ°μ€ λ³μλ₯Ό μ μ₯ν΄μ μ¬λ¦Ό

![](https://user-images.githubusercontent.com/51703260/132106339-c2ffcdf1-54fc-46d7-982b-e44bece8a755.png)


--- 

### π‘ this ν€μλ

- `non-static μμ­`(instance λ©μλ, μμ±μ, instance initializer)μμ μ¬μ©ν¨.
- νμ¬ μμ±μ€μΈ, μ€νμ€μΈ κ·Έ κ°μ²΄ μκΈ°μμ μ μΌμ»«μ.

**μ¬μ©λ²**

#### 1. μ§μ­λ³μμ μΈμ€ν΄μ€λ³μλ₯Ό κ΅¬λΆνκΈ° μν΄μ
```java
void setName(String name){
   this.name=name;
}
```

#### 2. μμ±μκ° μ€λ²λ‘λ©λ κ²½μ°, μμ μ λ λ€λ₯Έ μμ±μλ₯Ό νΈμΆ μ thisλ₯Ό λΆλ₯Ό μ μλ€.
```java
this();
```

#### 3. μκΈ° μμ μ κ°μ²΄λ₯Ό λ©μλμ λ§€κ°λ³μλ‘ μ λ¬νκ±°λ λ¦¬ν΄νκΈ° μν΄μ
```java
XXX(){
   return this; // μκΈ° μμ μ λ¦¬ν΄
}

YYY(){
   obj.zzz(this); // μκΈ° μμ μ λ§€κ°λ³μλ‘ μ λ¬
}
```

---

### π‘ super ν€μλ

- thisμ λ§μ°¬κ°μ§λ‘ `non-static μμ­`(instance λ©μλ, μμ±μ, instance initializer)μμ μ¬μ©ν¨.
- νμ¬ μμ±μ€μΈ, μ€νμ€μΈ κ°μ²΄μ λΆλͺ¨λ₯Ό μλ―Ένλλ‘ μ¬μ©νλ λΌλ¦¬μ μΈ κ°λ

**μ¬μ©λ²**

#### 1. μμ μ λ©μλμ λΆλͺ¨μ λ©μλλ₯Ό κ΅¬λΆνκΈ° μν΄ μ¬μ©(λ©μλ μ¬μ μ μν©)

```java
this.XXX()
super.XXX()

// μ°Έκ³ λ‘, λ©μλ λ§κ³  λ©€λ²λ κ°λμ μΌλ‘ κ΅¬λΆνμ§ μμ
// λΆλͺ¨μ λ©€λ²λ μμμκ²λ μκΈ° λλ¬Έμ
```

#### 2. μμμ μμ±μμμ λΆλͺ¨ μμ±μλ₯Ό λͺμμ μΌλ‘ νΈμΆνκΈ° μν΄ μ¬μ©

```java
super();
```

thisμ 3λ² κ°λμ superμ μλ€. (μμ νμκ° μλ€.) 

--- 

## μΆμ ν΄λμ€

μΆμ ν΄λμ€λ₯Ό μ μΈνλ λ°©λ²μ class ν€μλ μμ **`abstract`** λ₯Ό λΆνμ μ μΈν  μ μλ€.

μΆμ ν΄λμ€λ λ―Έμμ± ν΄λμ€λ‘ new ν€μλλ‘ λ€μ΄λ νΈ κ°μ²΄ μμ±μ΄ λΆκ°λ₯νκ³  λ°λμ νμ ν΄λμ€λ₯Ό νμλ‘νλ€. <br>λμ  μμ κ°μ²΄μ μ°Έμ‘°λ³μλ‘ μ¬μ©κ°λ₯νλ€.

μΈν°νμ΄μ€μμ μ μΈν  μ μλ λ³μλ κ΅¬νλ λ©μλλ₯Ό ν¬ν¨μν¬ λ μ¬μ©νλ€.<br>
μΆμν΄λμ€λ κ²°κ΅­ ν΄λμ€μ΄κΈ° λλ¬Έμ λ¨μΌμμλ§ κ°λ₯νλ€.<br>

μΆμ ν΄λμ€λ 2κ°μ§λ‘ κ΅¬λΆν  μ μλ€.

1. **μΆμ λ©μλκ° μλ μΆμ ν΄λμ€**
    - ν΄λΉ ν΄λμ€μ κ°μ²΄μμ±μ λ§μ λ μ¬μ©
    - μμ λ°λ μμ ν΄λμ€μμ κ°λ³μ μΈ νΉμ±μ μΆκ°μ μΌλ‘ λΆμ¬ν ν κ°μ²΄ μμ±

2. **μΆμ λ©μλκ° μλ μΆμ ν΄λμ€**
    - ν΄λΉ μΆμ ν΄λμ€λ₯Ό μμλ°λ μμ ν΄λμ€μμ μΆμ λ©μλ μ€λ²λΌμ΄λ© νμ
    - μμ ν΄λμ€μκ² μΆμ λ©μλμ μ€λ²λΌμ΄λ© κ°μ μ±μ λΆμ¬νμ¬ νλ‘κ·Έλ¨μ μμ μ±μ ν₯μ
    - μΆμ λ©μλκ° μ‘΄μ¬νλ©΄ λ°λμ ν΄λΉ ν΄λμ€λ μΆμ ν΄λμ€

μ°Έκ³ λ‘, μ΅μμ ν΄λμ€λ₯Ό μμλ°λ μ€κ° ν΄λμ€μμ μ΅μμ ν΄λμ€μ λ©μλλ₯Ό μΆμλ©μλλ‘ μ€λ²λΌμ΄λ©μ ν  μ μλ€.<br>
μ΅μμν΄λμ€μμ μλ μλ¬΄μ±μ μ€κ° ν΄λμ€μμ μλλ‘ λΆμ¬ν  μλ μλ€.

## π?π³ μΈν°νμ΄μ€
### π‘ μΈν°νμ΄μ€ μ μ

μΈν°νμ΄μ€λ, μ΄λ ν κΈ°λ₯μ μ¬μ©νκΈ° μν μΌμ’μ **νμ€(μ½μ, λ°©λ²)** μ΄λ€. <br>μΈν°νμ΄μ€λ κΈ°λ₯μ μ¬μ©νλ **`μ¬μ©μ κ΄μ `** κ³Ό κΈ°λ₯μ μ κ³΅νλ **`μ κ³΅μ κ΄μ `** μΌλ‘ κ΅¬λΆν  μ μλ€.

**`κΈ°λ₯ μ¬μ©μ`** λ μΈν°νμ΄μ€λ₯Ό ν΅ν΄ μ¬μ©λ°©λ²μ μ μ μμΌλ©°, μΈν°νμ΄μ€μ μ ν μλλλ‘λ§ κΈ°λ₯μ μ¬μ©ν  μ μλ€. <br>λν, μ κ³΅μκ° μ΄λ»κ² κ΅¬ννλμ§μ λν΄ μμΈν μ νμκ° μμ΄ κ²°ν©λκ° λ?μμ§λ©° λͺ¨λνκ° κ°λ₯ν΄μ§λ€. 

**`κΈ°λ₯ μ κ³΅μ`** λ μ΄ κΈ°λ₯λ€μ κΌ­ κ΅¬νν΄μΌλ§ μ±μμ΄ λΆμ¬λμ§λ§ μμ μ μ½λλ₯Ό λΈμΆνμ§ μμλ λλ€λ μ₯μ μ κ°μ§κ³  μλ€.

- **`μ¬μ©μ κ΄μ ` :** μ¬μ©λ°©λ², μ½μ    
- **`μ κ³΅μ κ΄μ ` :** κ΅¬νμ μ±μ

κ΅¬νμ κ°μ νλ‘ μλ‘ λ€λ₯Έ λͺ¨λμ΄ κ°μ μΈν°νμ΄μ€λ₯Ό μμνλ€λ©΄ μ¬μ©μλ€μ μμ½κ² λͺ¨λ κ΅μ²΄κ° κ°λ₯

μλ‘ μμ κ΄κ³κ° μλ κ°μ μ μΈ ν΄λμ€λ€μκ² μΈν°νμ΄μ€λ₯Ό ν΅ν κ΄κ³ λΆμ¬λ‘ λ€νμ± νμ₯ κ°λ₯

--- 

### π‘ μΈν°νμ΄μ€ κ΅¬ν

ν΄λμ€λ₯Ό κ΅¬νν  λ class ν€μλλ₯Ό μ¬μ©νμ§λ§, μΈν°νμ΄μ€λ `interface` λΌλ ν€μλλ₯Ό μ¬μ©νλ€.

```java
** []λ μν©μ λ°λΌ μλ΅κ°λ₯ν¨

* μΈν°νμ΄μ€ μ μ
[μ κ·Όμ§μ μ] interface μΈν°νμ΄μ€λͺ [extends λΆλͺ¨ μΈν°νμ΄μ€λͺ]{ } 

// μ κ·Όμ§μ μ
(default),public
// ν΄λμ€λ μΈν°νμ΄μ€λ₯Ό μμλ°μ λ implementsν€μλλ₯Ό μ¬μ©νμ§λ§,
// μΈν°νμ΄μ€κ° μΈν°νμ΄μ€λ₯Ό μμλ°μ λλ extendsν€μλλ₯Ό μ¬μ©νλ€.

interface μΈν°νμ΄μ€λͺ{
	// 1. μμ
	[public static final]νμ μμλͺ = μμκ°;
	
	// 2. μΆμ λ©μλ
	[public abstract]νμ λ©μλλͺ(λ§€κ°λ³μ);

	// 3. λν΄νΈ λ©μλ
	default νμ λ©μλλͺ(λ§€κ°λ³μ){
		// κ΅¬ν
	}

	// 4. μ€νν± λ©μλ
	static νμ λ©μλλͺ(λ§€κ°λ³μ){
		// κ΅¬ν
	}
}
```

**Java 8 μ΄μ κΉμ§**λ μμμ μΆμ λ©μλλ§ μ μΈ κ°λ₯νμμ§λ§, <br>
**Java 8 μ΄νλΆν°λ** λν΄νΈ λ©μλμ μ€νν± λ©μλκ° μΆκ°λμλ€.

1. μμ **(μ λ)** : μΈν°νμ΄μ€μμ κ³ μ λ κ°λ§ μ κ³΅.
2. μΆμ λ©μλ **(κ°μ )** : μΈν°νμ΄μ€μμ **κ°μ΄λ**λ₯Ό μ κ³΅νκ³  μμλ°μ μ€λ²λΌμ΄λ©ν΄μ κ΅¬ν.
3. λν΄νΈ λ©μλ **(μ ν)** : μΈν°νμ΄μ€μμ κ΅¬ν λ©μλ μ κ³΅, **μ€λ²λΌμ΄λ© κ°λ₯**
4. μ€νν± λ©μλ **(μ λ)** : μΈν°νμ΄μ€μμ κ΅¬ν λ©μλ μ κ³΅, **μ€λ²λΌμ΄λ© λΆκ°**

κ·Όλ³Έμ μΌλ‘ μΆμ ν΄λμ€λ ν΄λμ€μ΄λ―λ‘ **"is-a : ~λ ~μ΄λ€." κ΄κ³** μ΄κΈ° λλ¬Έμ λ¨μΌ μμλ§ κ°λ₯ν κ²μ΄κ³ ,<br>
μΈν°νμ΄μ€λ ν΄λμ€κ° μλλ―λ‘ **"has-a : ~λ ~λ₯Ό ν  μ μλ€." κ΄κ³** μ΄κΈ° λλ¬Έμ λ€μ€ μμμ΄ κ°λ₯ν κ²μ΄λ€.

```java
// Baemungμ μ¬λμ΄λ©° μμ§μΌ μ μκ³ , λ€μ μ μκ³ , κ°λ°ν  μ μλ€.
class Baemung extends Person implements Movable, Hearable, Developable 
```

#### λ€νμ±μ μ‘°μν΄λμ€μ μ‘°μμΈν°νμ΄μ€ λͺ¨λ μ μ© κ°λ₯

```java
class IronMan implements Heroable, Fightable, Transformable {}

IronMan tony = new IronMan();
Object obj = tony;
Heroable hero = tony;
Fightable fighter = tony;
Transformable trans = tony;
```
