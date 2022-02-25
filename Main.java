package maluevArtem.homework_2_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Person andrey = new Person("Андрей", "Андреев", 18, Sex.MAN, Education.SECONDARY);
        Person oleg = new Person("Олег", "Сидоров", 25, Sex.MAN, Education.HIGHER);
        Person olga = new Person("Ольга", "Иванова", 19, Sex.WOMAN, Education.SECONDARY);
        Person elena = new Person("Елена", "Михалкова", 32, Sex.WOMAN, Education.HIGHER);
        Person anton = new Person("Антон", "Антонов", 16, Sex.MAN, Education.ELEMENTARY);
        Person sergey = new Person("Сергей", "Иванов", 42, Sex.MAN, Education.FURTHER);
        Person anna = new Person("Анна", "Таранкова", 54, Sex.WOMAN, Education.HIGHER);

        Collection<Person> persons = Arrays.asList(andrey, oleg, olga, elena, anton, sergey, anna);
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> recruits = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .filter(x -> x.getSex().equals(Sex.MAN))
                .map(value -> value.getFamily())
                .collect(Collectors.toList());
        System.out.println(recruits);

        List<String> efficientMans = persons.stream()
                .sorted(Comparator.comparing(value -> value.getFamily()))
                .filter(x -> x.getEducation().equals(Education.HIGHER) && x.getAge() >= 18)
                .filter(x -> (x.getSex().equals(Sex.MAN) && x.getAge() <= 65)
                        || (x.getSex().equals(Sex.WOMAN) && x.getAge() <= 60))
                .map(value -> value.getFamily())
                .collect(Collectors.toList());
        System.out.println(efficientMans);
    }
}
