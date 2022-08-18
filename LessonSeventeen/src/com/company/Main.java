package com.company;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // FileWriter, FileReader
        FileWriter fw = new FileWriter("1.txt");
        fw.write("hello\n");
        char[] chars = {'a', 'b', 'c', 'd', '\n'};
        fw.write(chars);
        fw.write("Python\n", 2, 5); // thon смещение по символам
        //fw.write(chars, 0 , 2);// ab смещение по массиву
        fw.flush(); //
        fw.close(); // закрытие файла, обязательно

        // открытие файла в режме добавления
        FileWriter fw2 = new FileWriter("2.txt", true);
        fw2.write("I am Senior! ");
        fw2.flush();
        fw2.close();

        // r = open file read mode
        // w = open file write mode
        // rw = open file read & write mode
        RandomAccessFile raf = new RandomAccessFile("2.txt", "rw");
        raf.seek(8); // смещение курсора
        raf.writeChars("ior");
        raf.close();

        FileReader fr = new FileReader("1.txt");
        char[] data = new char[2];
        fr.read(data);
        System.out.println(new String(data));

        while (true) {
            int c = fr.read();
            if (c == -1) { // конец файла
                break;
            }
            System.out.print((char)c);
        }
        fr.close();

        // Сериальзация (Serialization)
        // процесс представления объекта
        // в виде двоичных данных
        // (как он храниться в оперативной памяти)

        Person p = new Person();
        p.name = "Vasya";
        p.setAge(25);

        if (p instanceof Serializable) {} // проверка на наследование интефейса Serializable

        /*FileOutputStream fos = new FileOutputStream("data.bin"); // сначала создать FOS
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p); // передача объекта
        oos.writeInt(1200);
        oos.flush();
        fos.flush();
        oos.close();
        fos.close();*/

        FileInputStream fis = new FileInputStream("data.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // чтение (десерииаризация) должна проиходить
        // в том порядке, что и запись

        Person p2 = (Person) ois.readObject(); // преобразование
        int n = ois.readInt();
        ois.close();
        fis.close();
        System.out.println(p2);
        System.out.println(n);
    }
}
