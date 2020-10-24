package cs.vsu.ru.task1;

public class Main {

    public static void main(String[] args) {
        Container list=new Container(10);
        list.add(5);
        list.add(20);
        list.add(6);
        list.add(8);
        list.add(19);
        list.add(13);
        list.add(21);
        list.add(5);
        list.print();

        System.out.println("Вместимость массива "+list.capasity());

        System.out.println("Количество элементов в массиве "+ list.size());

        list.contains(5);

        System.out.println("Получение элемента по индексу "+ 2+" :"+list.get(2));

        System.out.println("Определение индекса элемента " +21+": "+ list.indexOf(21));

        System.out.println("Удаление элемента по индексу "+ 4);
        list.removeByIndex(4);

        System.out.println("Удаление элемента по значению произошло "+ 13);
        list.removeByValue(13);

        list.print();
    }
}
