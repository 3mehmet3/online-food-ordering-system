package com.foodordering;

import com.foodordering.model.*;
import com.foodordering.payment.*;
import java.util.Scanner;

public class FoodOrderingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Restaurant restaurant;
    private static Customer currentCustomer;

    public static void main(String[] args) {
        initializeSystem();
        showWelcomeScreen();
        mainMenu();
    }

    private static void initializeSystem() {
        // Türkçe restoran ismi
        restaurant = new Restaurant(1, "Lezzet Durağı", "İstanbul, Kadıköy");

        // Türk mutfağından menü öğeleri
        restaurant.addMenuItem(new MenuItem(1, "Adana Kebap", "Közde pişmiş acılı kıyma kebap", 120.00, "Ana Yemek"));
        restaurant.addMenuItem(new MenuItem(2, "Urfa Kebap", "Közde pişmiş kıyma kebap", 115.00, "Ana Yemek"));
        restaurant.addMenuItem(new MenuItem(3, "Lahmacun", "İnce hamur üzerine kıymalı", 45.00, "Ana Yemek"));
        restaurant.addMenuItem(new MenuItem(4, "Pide", "Kaşarlı, kıymalı veya karışık", 85.00, "Ana Yemek"));
        restaurant.addMenuItem(new MenuItem(5, "Çoban Salata", "Taze mevsim sebzeleri", 40.00, "Meze"));
        restaurant.addMenuItem(new MenuItem(6, "Humus", "Nohut ezmesi, tahin ve zeytinyağı", 35.00, "Meze"));
        restaurant.addMenuItem(new MenuItem(7, "Cacık", "Yoğurt, salatalık ve sarımsak", 30.00, "Meze"));
        restaurant.addMenuItem(new MenuItem(8, "Kunefe", "Tel kadayıf, peynir ve şerbet", 65.00, "Tatlı"));
        restaurant.addMenuItem(new MenuItem(9, "Baklava", "Antep fıstıklı baklava", 70.00, "Tatlı"));
        restaurant.addMenuItem(new MenuItem(10, "Ayran", "Soğuk ayran 330ml", 15.00, "İçecek"));
        restaurant.addMenuItem(new MenuItem(11, "Şalgam", "Acı şalgam suyu", 12.00, "İçecek"));
        restaurant.addMenuItem(new MenuItem(12, "Türk Kahvesi", "Geleneksel Türk kahvesi", 25.00, "İçecek"));

        // Test müşterisi
        currentCustomer = new Customer(1, "Mehmet Karakaş", "mehmet@email.com",
                "password123", "05551234567",
                "Arel Üniversitesi, Tepekent/İstanbul");

        // Test puanları
        restaurant.addRating(4.7);
        restaurant.addRating(5.0);
        restaurant.addRating(4.9);
        restaurant.addRating(4.8);
    }

    private static void showWelcomeScreen() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   🍽️  ONLİNE YEMEK SİPARİŞ SİSTEMİ 🍽️  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        restaurant.displayInfo();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n═══ ANA MENÜ ═══");
            System.out.println("1. Menüyü Görüntüle");
            System.out.println("2. Sepete Ürün Ekle");
            System.out.println("3. Sepeti Görüntüle");
            System.out.println("4. Sepetten Ürün Çıkar");
            System.out.println("5. Sipariş Ver");
            System.out.println("6. Sipariş Geçmişi");
            System.out.println("7. Profilim");
            System.out.println("8. Restoran Puanla");
            System.out.println("9. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: restaurant.displayMenu(); break;
                case 2: addItemToCart(); break;
                case 3: currentCustomer.viewCart(); break;
                case 4: removeItemFromCart(); break;
                case 5: placeOrderWithPayment(); break;
                case 6: currentCustomer.viewOrderHistory(); break;
                case 7: currentCustomer.displayUserInfo(); break;
                case 8: rateRestaurant(); break;
                case 9:
                    System.out.println("Sistemimizi kullandığınız için teşekkürler!");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private static void addItemToCart() {
        restaurant.displayMenu();
        System.out.print("\nEklemek istediğiniz ürün ID'si: ");
        int itemId = scanner.nextInt();
        MenuItem item = restaurant.getMenuItemById(itemId);

        if (item != null) {
            currentCustomer.addToCart(item);
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    private static void removeItemFromCart() {
        currentCustomer.viewCart();
        System.out.print("\nÇıkarmak istediğiniz ürün ID'si: ");
        int itemId = scanner.nextInt();
        MenuItem item = restaurant.getMenuItemById(itemId);

        if (item != null) {
            currentCustomer.removeFromCart(item);
        }
    }

    private static void placeOrderWithPayment() {
        double total = currentCustomer.calculateTotal();
        if (total == 0) {
            System.out.println("Sepetiniz boş!");
            return;
        }

        System.out.println("\nToplam: " + total + " TL");
        System.out.println("\nÖdeme Yöntemi Seçin:");
        System.out.println("1. Kredi Kartı");
        System.out.println("2. Nakit");
        System.out.println("3. Online Ödeme");
        System.out.print("Seçim: ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        Payment payment = null;
        switch (paymentChoice) {
            case 1:
                System.out.print("Kart Numarası: ");
                String cardNum = scanner.nextLine();
                System.out.print("Kart Sahibi: ");
                String holder = scanner.nextLine();
                System.out.print("Son Kullanma Tarihi (AA/YY): ");
                String expiry = scanner.nextLine();
                payment = new CreditCardPayment(cardNum, holder, expiry);
                break;
            case 2:
                System.out.print("Ödeyeceğiniz Tutar: ");
                double cash = scanner.nextDouble();
                payment = new CashPayment(cash);
                break;
            case 3:
                System.out.print("Cüzdan Sağlayıcı (PayPal/Apple Pay): ");
                String provider = scanner.nextLine();
                System.out.print("Cüzdan ID: ");
                String walletId = scanner.nextLine();
                payment = new OnlinePayment(provider, walletId);
                break;
        }

        if (payment != null && payment.processPayment(total)) {
            currentCustomer.placeOrder();
        }
    }

    private static void rateRestaurant() {
        System.out.print(restaurant.getName() + " için puanınız (1-5): ");
        double rating = scanner.nextDouble();
        restaurant.addRating(rating);
        System.out.println("Geri bildiriminiz için teşekkürler!");
        System.out.println("Yeni ortalama puan: ⭐ " +
                String.format("%.1f", restaurant.getAverageRating()));
    }
}