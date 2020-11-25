package org.example;

class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isright = false;
        boolean p2isright = false;
        boolean p3isright = false;

        int BrojKojiTrebaPogodit = (int)(Math.random() * 10);
        System.out.println ("Razmisljam o broju izmedju 0 i 9 ... ");

        while (true){
            System.out.println ("Zamisljeni broj je " + BrojKojiTrebaPogodit);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println ("Player P1 guessed " + guessp1);
            guessp2 = p2.number;
            System.out.println ("Player P2 guessed " + guessp2);
            guessp3 = p3.number;
            System.out.println ("Player P3 guessed " + guessp3);

            if (guessp1 == BrojKojiTrebaPogodit){
                p1isright = true;
            }
            if (guessp2 == BrojKojiTrebaPogodit){
                p2isright = true;
            }
            if (guessp3 == BrojKojiTrebaPogodit){
                p3isright = true;
            }

            if (p1isright || p2isright || p3isright) {
                System.out.println ("We have winner!");
                System.out.println ("Is P1 got it right? " + p1isright);
                System.out.println ("Is P2 got it right? " + p2isright);
                System.out.println ("Is P3 got it right? " + p3isright);
                System.out.println ("Game is over");
                break;
            }
            else {
                System.out.println ("Players will have to try again!");
            }
        }
    }
}

class Player {
    int number = 0;

    public void guess() {
        number = (int) (Math.random()*10);
        System.out.println("I'm guessing " + number);
    }
}

class GameLauncher {
    public static void main (String[] imeStringa){
        GuessGame game = new GuessGame();
        game.startGame();
    }
}