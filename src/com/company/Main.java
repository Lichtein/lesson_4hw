package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealth = {200, 260, 270, 300};
    public static int[] heroesDamage = {0, 10, 20, 5};
    public static String[] heroesAttackType = {"none", "Physical", "Magical", "Mental"};
    int counter = 0;

    public static void main(String[] args) {
        while (!isFinished()){
          round();
    }
}

    public static void round(){
        printStatistics();
        System.out.println("round was started");
        changeBossDefence();
        heroesHit();
        bossHit();
        printStatistics();
        medic();

   }
    public static void printStatistics(){
        System.out.println("------------");
        System.out.println("Boss health: " + bossHealth);
        System.out.println("Warrior health " + heroesHealth[1]);
        System.out.println("Magic health " + heroesHealth[2]);
        System.out.println("Kinetic health " + heroesHealth[3]);
        System.out.println("Medic health " + heroesHealth[0]);
        System.out.println("------------");
}
    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 &&
                heroesHealth[2] <= 0) {
            System.out.println("boss won!!");
            return true;
        }
        return false;
    }

    public static void bossHit(){
        for(int i = 0; i < heroesHealth.length; i++){
            if (heroesHealth[i] >0 && heroesHealth[i] > 0);
            if (heroesHealth[i] - heroesHealth[i] <0 ){
                heroesHealth[i] = 0;
            } else heroesHealth[i] = heroesHealth[i] - bossDamage;

        }
    }

    public static void medic(){
        int counter = 0;
        Random random = new Random();
        int healthXpMedic = random.nextInt(75) + 1;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && counter < 1 && heroesHealth[i] != heroesHealth[0] && heroesHealth[0] > 0){
                if (heroesHealth[i] >= 1 && heroesHealth [i] <100){
                    heroesHealth[i] = heroesHealth[i] + healthXpMedic;
                    counter++;
                }
            }

        }
    }

    public static void heroesHit(){
        for (int i = 0; i < heroesDamage.length; i++){
            if (heroesHealth[i] > 0 && bossHealth > 0){
                if (bossDefenceType == heroesAttackType[i]){
                    heroesDamage[i] = 0;
                }
                if (bossHealth - heroesDamage[i] < 0){
                    bossHealth = 0;
                } else heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
        }
    }

    public static void changeBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
            System.out.println("Boss defence type " + heroesAttackType[randomIndex]);
    }

}

