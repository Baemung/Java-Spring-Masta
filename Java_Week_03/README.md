## ๐ฏ ๋ชฉํ
### ์๋ฐ๊ฐ ์ ๊ณตํ๋ ๋ค์ํ ์ฐ์ฐ์์ ์ ์ด๋ฌธ์ ์ตํ๊ธฐ.

### ๐ ํ์ตํ  ๊ฒ
- [์ฐ์  ์ฐ์ฐ์](#-์ฐ์ -์ฐ์ฐ์)
- [๋นํธ ์ฐ์ฐ์](#-๋นํธ-์ฐ์ฐ์)
- [๊ด๊ณ ์ฐ์ฐ์](#-๊ด๊ณ-์ฐ์ฐ์)
- [๋ผ๋ฆฌ ์ฐ์ฐ์](#-๋ผ๋ฆฌ-์ฐ์ฐ์)
- [instanceof](#-instanceof)
- [Assignment Operator](#-assignment-operator)
- [ํ์ดํ ์ฐ์ฐ์](#-ํ์ดํ-์ฐ์ฐ์)
- [3ํญ ์ฐ์ฐ์](#-3ํญ-์ฐ์ฐ์)
- [์ ํ๋ฌธ](#-์ ํ๋ฌธ)
- [๋ฐ๋ณต๋ฌธ](#-๋ฐ๋ณต๋ฌธ)

--- 

### ๐ก ์ฐ์  ์ฐ์ฐ์

์ฐ์  ์ฐ์ฐ์๋ +, -, *, / ์ด๋ ๊ฒ ์ฌ์น์ฐ์ฐ์ ๋ชจ๋๋ผ ์ฐ์ฐ %๋ก ์ด๋ฃจ์ด์ ธ ์๋ค.

```java
int A = 10;
int B = 3;

System.out.println(A + B); // 13
System.out.println(A - B); // 7
System.out.println(A * B); // 30
System.out.println(A / B); // 3
System.out.println(A % B); // 1

```

---

### ๐ก ๋นํธ ์ฐ์ฐ์

๋นํธ ์ฐ์ฐ์๋ `๋นํธ ๋ผ๋ฆฌ ์ฐ์ฐ์`์ `๋นํธ ์ํํธ ์ฐ์ฐ์`๋ก ๊ตฌ๋ถํ  ์ ์๋ค.

**`๋นํธ ๋ผ๋ฆฌ ์ฐ์ฐ์`**

๋นํธ ๋ผ๋ฆฌ ์ฐ์ฐ์๋ ํผ์ฐ์ฐ์๋ฅผ ๋นํธ๋จ์๋ก ๋ผ๋ฆฌ ์ฐ์ฐ์ํ๋ค.

ํผ์ฐ์ฐ์๋ก ์ค์๋ ํ์ฉํ์ง ์๊ณ , ์ ์(๋ฌธ์ ํฌํจ)๋ง ํ์ฉํ๋ค.

<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131247156-ddfe684b-2abd-4000-ba45-b978d22d99cd.png"></p>

**`๋นํธ ์ํํธ ์ฐ์ฐ์`**

ํผ์ฐ์ฐ์์ ๊ฐ ๋นํธ ์๋ฆฌ๋ฅผ '์ค๋ฅธ์ชฝ(>>)' ๋๋ '์ผ์ชฝ(<<)'์ผ๋ก ์ด๋(shift) ํ๋ค๊ณ  ํด์ `๋นํธ ์ํํธ ์ฐ์ฐ์`๋ผ๊ณ  ํ๋ค.
  
<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131247160-73eedc06-8955-4f10-8d2c-9fee78ed7ef0.png"></p>

---

### ๐ก ๊ด๊ณ ์ฐ์ฐ์

๊ด๊ณ ์ฐ์ฐ์๋ ์กฐ๊ฑด์์ ์์ฃผ ์ฐ์ด๋ ์ฐ์ฐ์๋ก 

๋ ๋น๊ต ๊ฐ๋ฅํ ๊ฐ์ด๋ ๊ฐ์ฒด์ ๊ด๊ณ๋ฅผ ๋น๊ตํ๋ ์ฐ์ฐ์์ด๋ค.

๊ด๊ณ ์ฐ์ฐ์๋ <, >, <=, >=, ==, != ์ผ๋ก ๊ตฌ์ฑ๋์ด ์๊ณ  boolean type์ ๋ฆฌํดํ๋ค.

```java
a < b // a๊ฐ b๋ณด๋ค ์์๊ฐ?
a > b // a๊ฐ b๋ณด๋ค ํฐ๊ฐ?
a <= b // a๊ฐ b๋ณด๋ค ์๊ฑฐ๋ ๊ฐ์๊ฐ?
a >= b // a๊ฐ b๋ณด๋ค ํฌ๊ฑฐ๋ ๊ฐ์๊ฐ?
a == b // a์ b๊ฐ ๊ฐ์๊ฐ?
a != b // a์ b๊ฐ ๋ค๋ฅธ๊ฐ?
```

==, != ๋ ๊ฐ์ฒด๋ฅผ ๋น๊ตํ  ๋ ๋ ํผ๋ฐ์ค๋ฅผ ๋น๊ตํ๊ธฐ ๋๋ฌธ์ ๊ฒ์ผ๋ก ๋ณด์ด๋ ๊ฐ์ ๊ฐ๋๋ผ๋ ์ฐธ์กฐํ๋ ๋ ํผ๋ฐ์ค๊ฐ ๋ค๋ฅด๋ฉด ์๋ํ์ง ์์ ๊ฒฐ๊ณผ๋ฅผ ์ป์ ์๋ ์๋ค.

---

### ๐ก ๋ผ๋ฆฌ ์ฐ์ฐ์

๋ผ๋ฆฌ ์ฐ์ฐ์๋ ๋ผ๋ฆฌ์ ๊ฒฐํฉ์ด๋, ๋ผ๋ฆฌ๋ฅผ ๋ค์ง์๋ ์ฌ์ฉํ๋ ์ฐ์ฐ์๋ก boolean type์ ๋ฆฌํดํ๋ค.

```java
A && B // A์ B ๋ชจ๋ true์ด๋ฉด ์ฐ์ฐ๊ฒฐ๊ณผ๋ true (and)
A || B // A์ B ๋ ์ค ํ๋๋ผ๋ true์ด๋ฉด ์ฐ์ฐ๊ฒฐ๊ณผ๋ true (or)
!A // ์ฐ์ฐ๊ฒฐ๊ณผ๋ A๊ฐ true์ด๋ฉด false, A๊ฐ false์ด๋ฉด true (not)
```

์ฌ๊ธฐ์ and ์ฐ์ฐ์ ์ฒซ๋ฒ์งธ ๋ผ๋ฆฌ๊ฐ false๋ฉด, ๋ค์ ๋ผ๋ฆฌ๋ฅผ ์ฒดํฌํ์ง ์๊ณ  false๋ฅผ ๋ฆฌํดํ๋ค.
๊ทธ๋ฆฌ๊ณ  or ์ฐ์ฐ์ ์ฒซ๋ฒ์งธ ๋ผ๋ฆฌ๊ฐ true๋ฉด, ๋ค์ ๋ผ๋ฆฌ๋ฅผ ์ฒดํฌํ์ง ์๊ณ  true๋ฅผ ๋ฆฌํดํ๋ค.

๊ทธ๋ ๊ธฐ ๋๋ฌธ์ ๋ผ๋ฆฌ ์ฐ์ฐ์๋ฅผ ์ฌ์ฉํ  ๋ ์๊ฐ, ๋ฉ๋ชจ๋ฆฌ์ ๋ญ๋น๋ ์์ ์ ์๊ณ , ๊ฒฝ์ฐ์ ๋ฐ๋ผ ๋ฐํ์์๋ฌ๊ฐ ๋ฐ์ํ  ์๋ ์๊ธฐ ๋๋ฌธ์ ๋ผ๋ฆฌ์ ์์๊ฐ ์๋นํ ์ค์ํ๋ค.

---

### ๐ก instanceof

์ฐธ์กฐ๋ณ์๊ฐ ์ฐธ์กฐํ๊ณ  ์๋ ์ธ์คํด์ค์ ์ค์  ํ์์ ์์๋ณผ ๋ instanceof ์ฐ์ฐ์๋ฅผ ์ฌ์ฉํ๋๋ฐ ์ด ์ฐ์ฐ์๋ boolean type์ ๋ฆฌํดํ๋ค.

"๊ฐ์ฒด instanceof ํด๋์ค" ํ์์ผ๋ก ์ฌ์ฉํ๋ฉฐ, ์ฃผ๋ก ์์๊ด๊ณ๋ฅผ ํ์ธํ  ๋ ์ฌ์ฉํ๋ค.

```java
class A { }

class B extends A { }

public class main {
    public static void main(String[] args){
        A a = new A();
        A ab = new B();
        B b = new B();
        
        System.out.println(a instanceof A);   //true
        System.out.println(ab instanceof A);  //true
        System.out.println(b instanceof A);   //true
        
        System.out.println(a instanceof B);   //false
        System.out.println(ab instanceof B);  //true
        System.out.println(b instanceof B);   //true
    }
}
```

์์ ๊ฐ์ฒด๋ ๋ถ๋ชจ ํด๋์ค์ instance์ง๋ง, ๋ถ๋ชจ ๊ฐ์ฒด๋ ์์ ํด๋์ค์ instance๊ฐ ์๋๋ค.

---

### ๐ก Assignment Operator

์ฐ๋ณ์ ๊ฐ์ ์ข๋ณ์ ๋ณ์์ ๋์ํ๋ ์ฐ์ฐ์์ด๋ค.

```java
A = B
```

๋์ ์ฐ์ฐ์๋ ๋ค์ํ ์ฐ์ฐ์์ ๊ฒฐํฉํ์ฌ ์๋์ ๊ฐ์ ๋ณตํฉ ๋์ ์ฐ์ฐ์๋ก ํ์ฉ๊ฐ๋ฅํ๋ค.

```java
A += B
A -= B
A *= B
A /= B
A %= B
A &= B
A |= B
A ^= B
A >>= B
A <<<= B
```

---

### ๐ก ํ์ดํ ์ฐ์ฐ์

(๋งค๊ฐ๋ณ์) -> {์คํ์ฝ๋}์ ๊ฐ์ ๋๋ค์์์ ํ์ดํ ์ฐ์ฐ์๋ฅผ ์ฌ์ฉํ๋ค.

์ฌ๊ธฐ์ ๋๋ค์์ด๋ "์๋ณ์์์ด ์คํ๊ฐ๋ฅํ ํจ์"๋ก, ํจ์๋ฅผ ๋ฐ๋ก ์ ์ธํ์ง ์๊ณ  ์ฝ๋ํ์ค์ ํจ์๋ฅผ ์จ์ ๊ทธ๊ฒ์ ํธ์ถํ๋ ๋ฐฉ์์ด๋ค.

๋ณดํต ํน์  ๊ธฐ์ค์ผ๋ก ์ ๋ ฌํ  ๋ ์์ฃผ ์ฌ์ฉํ๊ฒ ๋๋ค.

```java
Arrays.sort(list, (l1, l2) -> l1[0]) - l2[0]));
```

์ ์ฝ๋๋ 2์ฐจ์ ๋ฐฐ์ด์ ์ ๋ ฌํ  ๋, ๋ฐฐ์ด์ ์ฒซ๋ฒ์งธ ๊ฐ์ ๊ธฐ์ค์ผ๋ก ์ ๋ ฌํ๋ผ๋ ๋๋ค์์ด๋ค. 

๋ด๋ถ์ ์ผ๋ก๋ Comparator ์ธํฐํ์ด์ค์ compare(T o1, T o2)๋ฉ์๋๋ฅผ ์ค๋ฒ๋ผ์ด๋ฉํ ๊ฒ์ด๋ค. 

---

### ๐ก 3ํญ ์ฐ์ฐ์

```java
// ๋ณ์ = ์กฐ๊ฑด๋ฌธ ? ์ฐธ : ๊ฑฐ์ง;
min = A < B ? A : B;

// return ์กฐ๊ฑด๋ฌธ? ์ฐธ : ๊ฑฐ์ง;
return A < B ? A : B;
```
๋ณ์์ ๊ฐ์ ํ ๋นํ  ๋๋ง ์ผํญ์ฐ์ฐ์๋ฅผ ์ธ ์ ์๋๊ฒ์ด ์๋๋ผ, ๊ฐ์ ๋๊ฒจ์ฃผ๊ฑฐ๋ ์ถ๋ ฅํ๋ ๋ฑ ๊ฐ์ ๋ฐ์ ์ฒ๋ฆฌ๋ฅผ ํด์ค ์ ์์ผ๋ฉด ์ฌ์ฉ ๊ฐ๋ฅํ๋ค. 

---

### ๐ก ์ฐ์ฐ์ ์ฐ์  ์์

<p align="center"><img src="https://user-images.githubusercontent.com/51703260/131240291-29ad255c-2e62-4df1-b962-c4e8ae1b27de.png"></p>

๋ง์ฝ ๋์ผํ ์ฐ์ ์์์ธ ๊ฒฝ์ฐ๋ ํด๋น ์ฐ์ฐ์์ ์ฐ์ฐ๋ฐฉํฅ์์ ๋จผ์  ๋ฑ์ฅํ๋ ์ฐ์ฐ์๊ฐ ์ฐ์ ์ ์ผ๋ก ์ฐ์ฐ๋๋ค.

---

### ๐ก ์ ํ๋ฌธ

- **if - else if - else**

``` java
if(์กฐ๊ฑด์){ }
else if( ์ ์กฐ๊ฑด์ด ๊ฑฐ์ง์ผ ๊ฒฝ์ฐ ์กฐ๊ฑด){ }
else if( ์ ์กฐ๊ฑด์ด ๊ฑฐ์ง์ผ ๊ฒฝ์ฐ ์กฐ๊ฑด){ }
else { // ๋ชจ๋  ์กฐ๊ฑด๋ค์ด ๊ฑฐ์ง์ผ ๊ฒฝ์ฐ }
```

if๋ง ๋จ๋์ผ๋ก ์ฌ ์ ์๊ณ , else if์ else๋ if๋ฌธ์ด ์ ํ๋์ด์ผ์ง ๋ค ๋ฐ๋ผ ๋์ฌ ์ ์๋ค.

else if๋ if{} - else{ if{} } ์ ์ฝ์ ๊ฐ๋์ด๋ค.

- **switch - case - default**

```java
switch(๋ณ์) {
    case A : // ๋ณ์์ ๊ฐ์ด A์ผ ๋
        // ์ง์
        break;
    case B : // ๋ณ์์ ๊ฐ์ด B์ผ ๋
        // ์ง์
        break;
    default :
        // A์ B๊ฐ ์๋ ๊ฒฝ์ฐ
}
```
switch์ ๋ณ์๋ Primitive ํ์, Enum, String, Wrapper ํด๋์ค๊ฐ ๊ฐ๋ฅํ๋ค.

์ฌ๊ธฐ์ ์ฃผ์ํ  ์ ์ case A์ ์ง์ํด์ ์ฒ๋ฆฌ๋ฅผ ํ๊ณ  break๊ฐ ๋์ง ์์ผ๋ฉด ์๋ case B์๋ ์๋์ผ๋ก ์ง์ํ๊ฒ ํ๋ก๊ทธ๋จ์ด ์ค๊ณ๋์ด ์๊ธฐ ๋๋ฌธ์

A์ ์ง์ํ์ ๋ ์ฒ๋ฆฌํ๊ณ  ์ถ์ ๋ด์ฉ๋ง ์ฒ๋ฆฌํ๊ณ  ์ถ๋ค๋ฉด break๋ฅผ ํด์ค์ switch๋ฌธ์ ๋น ์ ธ๋์์ผ ํ๋ค.

---

### ๐ก ๋ฐ๋ณต๋ฌธ

- **while**
```java
 while(์กฐ๊ฑด์){
    // ์กฐ๊ฑด์์ด ์ฒ์ ๋ถํฐ ์ฑ๋ฆฝ๋์ง ์์ผ๋ฉด ์ ์ด์ ๋ฐ๋ณต๋ฌธ์ ์ง์์ ์ํ  ์๋ ์์
    // ๋ฐ๋ณต๋ด์ฉ
 }
```
  
```java
 do{
    // ๋ฌด์กฐ๊ฑด ์ต์ 1๋ฒ์ ๋ฐ๋ณต๋ฌธ ์คํ
    // ๋ฐ๋ณต๋ด์ฉ
 } while(์กฐ๊ฑด์); // ์ธ๋ฏธ์ฝ๋ก  ';' ํ์
```

- **for & for-each**

```java
for(์ด๊ธฐํ; ์กฐ๊ฑด์; ์ฆ๊ฐ์){
    // ๋ฐ๋ณต๋ด์ฉ
}
```

```java
for(๋ฐ์ดํฐํ์ ์งํฉ์์ : ๋ฐ๋ณต์งํฉ๊ฐ์ฒด){
    //๋ฐ๋ณต ๊ฐ๋ฅํ ์งํฉ๋ค์ ์์๋ค์ ๊บผ๋ด์ด ์ฒ๋ฆฌ
}
```
๋ฐ๋ณต์งํฉ๊ฐ์ฒด์๋ array, iterable ํ์์ด ์ฌ ์ ์์ผ๋ฉฐ enum์ ๊ฒฝ์ฐ enum.values()๋ฅผ ๋ฐ๋ณต์งํฉ๊ฐ์ฒด๋ก ์ฌ์ฉํ๋ค.

for-each๋ฌธ์ ์ฌ์ฉํ๋ ๋ชฉ์ 
1. ์๋ฃ๊ตฌ์กฐ์ฌ์ฉ์ ๋ํ ์ถ์ํ
2. ๋ฐ๋ณต ๊ฐ๋ฅํ ์งํฉ์ ์์)๊ฐ์ ์์ ์ด ๋ถ๊ฐ๋ฅ(์กฐํ ๋ชฉ์ )
