# 🍽️ Online Food Ordering System

A comprehensive Java-based food ordering system demonstrating core Object-Oriented Programming principles.

## ✨ Features

- 🍕 Menu Browsing
- 🛒 Shopping Cart
- 📦 Order Management
- 💳 Multiple Payment Methods
- ⭐ Restaurant Rating System
- 📊 Order History

## 🎯 OOP Concepts Demonstrated

### 1. Encapsulation
- Private fields with public getter/setter methods
- User class protects sensitive data (password, phoneNumber)

### 2. Inheritance
- Customer extends User (inherits properties and methods)

### 3. Polymorphism
- Multiple payment types: CreditCardPayment, CashPayment, OnlinePayment
- Same processPayment() method, different implementations

### 4. Abstraction
- Abstract classes: User, Payment
- Interface: Orderable

### 5. Interface Implementation
- Customer implements Orderable interface
# 🛠️ Technologies

- **Language**: Java (JDK 25)
- **IDE**: IntelliJ IDEA
- **Version Control**: Git & GitHub

## 📁 Project Structure
```
online-food-ordering-system/
├── src/main/java/com/foodordering/
│   ├── interfaces/
│   │   └── Orderable.java
│   ├── model/
│   │   ├── User.java
│   │   ├── Customer.java
│   │   ├── MenuItem.java
│   │   ├── Order.java
│   │   └── Restaurant.java
│   ├── payment/
│   │   ├── Payment.java
│   │   ├── CreditCardPayment.java
│   │   ├── CashPayment.java
│   │   └── OnlinePayment.java
│   └── FoodOrderingSystem.java
├── .gitignore
├── LICENSE
└── README.md
```

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Git

### Clone Repository
```bash
git clone https://github.com/3mehmet3/online-food-ordering-system.git
cd online-food-ordering-system
```

## 💻 Usage

### Compile and Run

#### Using Command Line:
```bash
cd src/main/java
javac com/foodordering/FoodOrderingSystem.java
java com.foodordering.FoodOrderingSystem
```

#### Using IntelliJ IDEA:
1. Open project in IntelliJ IDEA
2. Navigate to FoodOrderingSystem.java
3. Right-click → Run 'FoodOrderingSystem.main()'

### Sample Output
```
╔══════════════════════════════════════════╗
║   🍽️  ONLİNE YEMEK SİPARİŞ SİSTEMİ 🍽️  ║
╚══════════════════════════════════════════╝

=== Restoran Bilgileri ===
İsim: Lezzet Durağı
Adres: İstanbul, Kadıköy
Puan: ⭐ 4.9/5.0
```
## ‍ Author

**Mehmet Karakaş**
- University: Arel University
- Department: Computer Engineering (3rd Year)

