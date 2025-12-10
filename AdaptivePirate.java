import java.util.Random;
import java.util.Scanner;

    public class AdaptivePirate {
        private int gold;
        private int gems;
        private int supplies;
        /*private int day;
        private Random random;
        private Scanner scanner;
        private boolean gameOver;*/

        public AdaptivePirate() {
            this.gems = 20;
            this.gold = 100;
            this.supplies = 10;
            /*this.day = 1;
            this.random = new Random();
            this.scanner = new Scanner(System.in);
            this.gameOver = false;*/
        }

        public void start() {
            System.out.println("===========================================");
            System.out.println("Game \"Adaptive Pirate\"");
            System.out.println("===========================================");
            System.out.println();
            System.out.println("You are a pirate with limited resources.");
            System.out.println("Make a decision");
            System.out.println();

            while (!gameOver) {
                playTurn();
            }

            System.out.println("\n===========================================");
            System.out.println("GAME OVER");
            System.out.println("===========================================");
            System.out.println("You lasted " + (day - 1) + " days.");
            scanner.close();
        }

        private void playTurn() {
            System.out.println("\n-------------------------------------------");
            System.out.println("Day " + day);
            System.out.println("-------------------------------------------");
            displayResources();
            System.out.println();

            int choice = getPlayerChoice();
            processChoice(choice);

            checkGameOver();
            day++;
        }

        private void displayResources() {
            System.out.println("Gold: " + gold);
            System.out.println("Supplies: " + supplies);
            System.out.println("Gems: " + gems);
        }

        private int getPlayerChoice() {
            System.out.println("Chose an action:");
            System.out.println("1.Go to sea (30% risk)");
            System.out.println("-Chance to find treasure (+50 gold, +30 gems)");
            System.out.println("- get caught in a storm (-5 supplies)");
            System.out.println();
            System.out.println("2. Hunt (10% risk)");
            System.out.println("- +10 supplies");
            System.out.println("- stumble upon another pirate ship (-30 gold)");
            System.out.println();
            System.out.println("3. Take a break (0% risk)");
            System.out.println("- Consume 1 supply");
            System.out.println();
            System.out.print("Your choice (1-3): ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Error. Invalid choice.");
                    choice = 3;
                }
            } catch (Exception e) {
                scanner.nextLine(); // Clear buffer
                System.out.println("Error. Invalid choice.4");
                choice = 3;
            }

            return choice;
        }

        private void processChoice(int choice) {
            System.out.println();

            switch (choice) {
                case 1:
                    sailTheSea();
                    break;
                case 2:
                    hunt();
                    break;
                case 3:
                    rest();
                    break;
            }
        }

        private void sailTheSea() {
            System.out.println("You set out to sea...");

            int chance = random.nextInt(100);

            if (chance < 30) { // 30% ризику - шторм
                supplies -= 5;
                System.out.println("A storm has appeared. You lost 5 supplies.");
                System.out.println("Supplies: " + supplies);
            } else { // 70% - знайдено скарб
                gold += 50;
                gems += 30;
                System.out.println("Treasure! You gained +50 gold and +30 gems!");
                System.out.println("Gold: " + gold);
                System.out.println("Gems: " + gems);
            }
        }

        private void hunt() {
            System.out.println("You have gone hunting...");

            supplies += 10;
            System.out.println("Hunt was successful! +10 supplies.");

            int chance = random.nextInt(100);

            if (chance < 10) { // 10% ризику - ворожий корабель
                gold -= 30;
                System.out.println("Pirates! You lost -30 gold.");
                System.out.println("Gold: " + gold);
            }

            System.out.println("Supplies: " + supplies);
        }

        private void rest() {
            System.out.println("You are resting...");
            supplies -= 1;
            System.out.println("Consumed: -1 supply");
            System.out.println("Supplies: " + supplies);
        }

        private void checkGameOver() {
            if (gold <= 0) {
                System.out.println("\nYou have lost all your gold! GAME OVER.");
                gameOver = true;
            }

            if (supplies <= 0) {
                System.out.println("\nYou finished all of your supplies! GAME OVER.");
                gameOver = true;
            }
        }

        public static void main(String[] args) {
            AdaptivePirate game = new AdaptivePirate();
            game.start();
        }
    }

