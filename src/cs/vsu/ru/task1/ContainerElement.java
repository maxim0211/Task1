package cs.vsu.ru.task1;

/**
 * Класс элемента контэйнера со свойствами next и data,
 * описывающий каждый отдельный элемент
 */
public class ContainerElement {

    /** Поле data- хранит данные каждого элемента */
    protected int data;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param data - значение
     */
    ContainerElement(int data){

        this.data=data;
    }

    /**
     * Функция получения значения поля {@link ContainerElement#data}
     * @return возвращает содержимое элемента
     */
    int getData() {
        return data;
    }

    /**
     * Функция получения значения поля {@link ContainerElement#data} и
     * устанавливает значение элемента для конкретного объекта
     * @param data определяет значение, которое должно присвоиться нашему элементу
     */
    void setData(int data) {
        this.data = data;
    }
}
