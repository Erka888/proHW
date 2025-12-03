package org.example;
public class Pet {

    String name;
    int hunger;
    int energy;
    int mood;

    public Pet(String petName, String breed) {
        name = petName;

        if (breed.equals("1")) { //кошка
            hunger = 30;
            energy = 80;
            mood = 60;
        } else if (breed.equals("2")) { //собака
            hunger = 40;
            energy = 90;
            mood = 50;
        } else if (breed.equals("3")) { //хомяк
            hunger = 20;
            energy = 70;
            mood = 80;
        } else if (breed.equals("4")) { //кролик
            hunger = 25;
            energy = 75;
            mood = 65;
        } else {   //по умолчанию
            hunger = 50;
            energy = 50;
            mood = 50;
        }
    }

    // Действия питомца
    public void feed() {
        hunger -= 20;
        mood += 5;
        normalize();
        System.out.println(name + " поел! ");
    }
    public void play() {
        mood += 20;
        hunger += 10;
        energy -= 15;
        normalize();
        System.out.println(name + " играет! ");
    }
    public void sleep() {
        energy += 25;
        hunger += 10;
        normalize();
        System.out.println(name + " спит! ");
    }
    public void doNothing() {
        hunger += 5;
        mood -= 5;
        normalize();
        System.out.println(name + " ничего не делает ");
    }
    // Ухудшение состояния со временем
    public void tick() {
        hunger += 3;
        mood -= 2;
        energy -= 1;
        normalize();
    }
    // Ограничение значений от 0 до 100
    void normalize() {
        if (hunger < 0) hunger = 0;
        if (hunger > 100) hunger = 100;

        if (energy < 0) energy = 0;
        if (energy > 100) energy = 100;

        if (mood < 0) mood = 0;
        if (mood > 100) mood = 100;
    }

    // Проверка, жив ли питомец
    boolean isAlive() {
        return hunger < 100 && energy > 0 && mood > 0;
    }

    String getFace() {
        if (!isAlive()) {
            if (hunger >= 100) return "Питомец умер от голода";
            if (energy <= 0) return "Питомец умер от усталости";
            if (mood <= 0) return "Питомец умер от плохого настроения";
            return "(x_x)";
        }

        if (energy < 30) return "(−﹏−)";
        if (mood < 30) return "(╥_╥)";
        if (hunger > 70) return "(ᵕ︵ᵕ)";
        if (mood > 70) return "(=^ ◡ ^=)";
        return "❤\uFE0F";
    }

    void printStatus() {
        System.out.println("-- Статус питомца --");
        System.out.println("Имя: " + name + " " + getFace());
        System.out.println("Голод: " + hunger);
        System.out.println("Энергия: " + energy);
        System.out.println("Настроение: " + mood);
        System.out.println("======================");
    }
}
