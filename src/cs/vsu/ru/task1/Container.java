package cs.vsu.ru.task1;

import javax.lang.model.type.NullType;

/**
 * Класс контэйнер, описывающий все его свойства и методы
 */
public class Container {

    /** Массив элементов контэйнера */
    private ContainerElement[] mass;

    /** Количество элементов в контэйнере */
    int size;


    /**
     * Конструктор класс, создающий объекты контэйнера
     * @param n - количество элементов в контэйнере
     */
    Container(int n) {
        mass = new ContainerElement[16];
    }

    /**
     * Конструктор создаёт список объектов, количество оперделено заранее
     */
    Container(){
        mass = new ContainerElement[10];
    }

    /**
     * Функция определеяющая  максимальную вместимость массива
     * на данный момент времен
     * @return возвращает максимальную вместимость
     */
    int capasity(){
        return mass.length;
    }


    /**
     * Функция позволяющая в случае необходимости увеличить размерность массива
     */
    void ensureCapasity(){
        ContainerElement[] buf = mass;                  //создаем временный массив
        mass = new ContainerElement[buf.length * 2];    //записываем туда элементы

        int index=0;
        for (ContainerElement n : buf) {                //возвращаем элементы обратно
            if(n != null){
                mass[index] = n;
                index++;
            }
        }
    }

    /**
     * Функция позволяющая узнать количество элементов массива
     * @return количество элементов
     */
    int size(){
        return size;

    }

    /**
     * Функция позволяющая добавить элементы в массиве и
     * в случае нехватке массива - расширяет его
     * @param data - значение вставляемого элемента
     * @see Container#ensureCapasity()  расширяет массив
     */
    void add(int data){
        ContainerElement el=new ContainerElement(data);
        if((mass.length + 1) * 3/4 <= size){                //если мало места остаётся  в массиве
            ensureCapasity();                               //увеличиваем размерность массива
        }
        int index=0;
        while(mass[index]!=null){                           //находим пустое место
            index++;
        }
        ContainerElement elem=new ContainerElement(data);   //вставляем элемент
        mass[index]=elem;
        size++;

    }

    /**
     * Функция, позволяющая проверить наличие элемента в массиве
     * @param data - значение проверяемого элемента
     * @return true если элемент содержится в контэйнере
     */
    boolean contains(int data) {
        int index = 0;
        while (mass[index] != null) {
            if (mass[index].getData() == data) {
                return true;
            }
            index++;
        }

        return false;
    }

    /**
     * Функция позволяющая по индексу элемента , удалить его из контэйнера
     * @param index - индекс удаляемого элемента
     * @return true, если элемент успешно удалён
     */
    boolean removeByIndex(int index){
        if(index<mass.length && mass[index]!=null) {
            for (int i = index; i < size() - 1; i++) {
                mass[i] = mass[i + 1];                      //просто смещаем все элементы, тем самым элемент пропадает
            }

            mass[size - 1] = null;
            size--;                                         //количество элементов в массиве уменьшается
            return true;
        }
        else {

            System.out.println("\nУдаление не произошло, такого индекса  не существует");
            return  false;
        }
    }

    /**
     * Функция позволяющая удалить элемент по значению
     * @param data -значение удаляемого элемента
     * @return true, если элемент успешно удалён
     * @see Container#indexOf(int) определяет индекс элемента по его значению
     * @see Container#removeByIndex(int)   удаляет элемент по индексу
     */
    boolean removeByValue(int data){

        int index=indexOf(data);
        if (index!=-1)  {
            removeByIndex(index);
            return true;
        }
        else {
            System.out.println("Удаление не произошло, не удалось найти элемент с таким значением");
            return  false;
        }

    }

    /**
     * Функция позволяющая получить элемент по индексу
     * @param index -индекс получаемого элемента
     * @return значение элемента, которое мы ищем, но
     * если такого элемента нет - возвращаем -1
     * @see ContainerElement#getData()  получаетзначение эллемента
     */
    int get(int index){
        if(index<capasity()&& mass[index]!=null) return mass[index].getData();
        else{
            return -1;
        }
    }

    /**
     * Функция позволяющая определить индекс элемента
     * @param data -индекс получаемого элемента
     * @return индекс элемента, который искали, но
     * если такого элемента нет - возвращаем -1
     */
    int indexOf(int data){
        int index = 0;
        while (mass[index] != null) {
            if (mass[index].getData() == data) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Функция позволяющая распечатать элементы массива
     */
    public void print(){
        int index=0;
        System.out.print("Элементы контейнера: ");
        while (mass[index]!=null){
            System.out.print(mass[index].data+ " ");
            index++;
        }
        System.out.println("\n");
    }
}
