package lab;

import java.util.Scanner;

public class Main {

    public static boolean StoreCreated = false;
    public static boolean OrderCreated = false;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Store store = new Store();
        Order order = new Order();

        int input;

        System.out.println("\t~~Первая программа на Java~~");

        do {
            System.out.println("\tГлавное меню:");
            System.out.println("1. Создать магазин пластинок");
            System.out.println("2. Посмотреть информацию о магазине");
            System.out.println("3. Посмотреть информацию о сотрудниках");
            System.out.println("4. Посмотреть ассортимент магазина");
            System.out.println("5. Создать заказ");
            System.out.println("6. Посмотреть информацию о заказе");
            System.out.println("0. Выход из программы\n");

            System.out.print("Выберите действие: ");
            while (!scan.hasNextInt()) {
                System.out.print("Некорректный ввод!\nВыберите действие: ");
                scan.next(); // Очищаем буфер после некорректного ввода
            }
            input = scan.nextInt();
            scan.nextLine(); // Очищаем буфер после ввода числа

            switch (input) {
                // 1. Создание магазина
                case 1:
                    // Создание нового магазина
                    if(!StoreCreated) {
                        store.inputStoreInfo();
                        StoreCreated = true;
                    // Пересоздание магазина, если он уже был создан
                    }else{
                        System.out.println("\n\t\t~~ПРЕДУПРЕЖДЕНИЕ~~");
                        System.out.println("-------------------------------------------");
                        System.out.println("Магазин уже создан. Хотите создать новый магазин?");
                        System.out.print("Введите ответ (да/нет): ");
                        String response = scan.nextLine().toLowerCase();
                        System.out.println("-------------------------------------------");

                        if (response.equals("да")) {
                            store.inputStoreInfo();
                            OrderCreated = false;
                        } else {
                            System.out.println("Магазин не будет пересоздан.");
                            System.out.println("-------------------------------------------\n");
                        }
                    }
                    break;
                // 2. Информация о магазине
                case 2:
                    if(StoreCreated)
                        store.outputStoreInfo();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 3. Информация о сотрудниках
                case 3:
                    if(StoreCreated)
                        store.outputEmployees();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                // 4. Информация о пластинках
                case 4:
                    if(StoreCreated)
                        store.outputVinylRecords();
                    else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                case 5:
                    if(StoreCreated) {
                        order.inputOrderInfo(store);
                        OrderCreated = true;
                    }else
                        System.out.println("Прежде чем воспользоваться этой функцией, создайте магазин!\n");
                    break;
                case 6:
                    if(StoreCreated && OrderCreated)
                        order.outputOrder();
                    else
                        System.out.println("Ни одного заказа не найдено!\n");
                    break;
                case 0:
                    System.out.println("\n\t--------------");
                    System.out.println("\t До свидания!");
                    System.out.println("\t--------------");
                    break;
                default:
                    System.out.println("Некорректный выбор!\n");
            }
        }while (input != 0);
    }

}
