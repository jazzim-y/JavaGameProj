package Main;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Music.playBackground("src\\Main\\Music.wav", true);

        System.out.println();
        System.out.println(GREEN+"                           WELCOME TO"+RESET);
        System.out.println();

        // Bag-o UI
        System.out.println(CYAN +
                "██████╗ ██╗ ██████╗ ██╗██╗    ██╗ ██████╗ ██████╗ ██╗     ██████╗ \n" +
                "██╔══██╗██║██╔════╝ ██║██║    ██║██╔═══██╗██╔══██╗██║     ██╔══██╗\n" +
                "██║  ██║██║██║  ███╗██║██║ █╗ ██║██║   ██║██████╔╝██║     ██║  ██║\n" +
                "██║  ██║██║██║   ██║██║██║███╗██║██║   ██║██╔══██╗██║     ██║  ██║\n" +
                "██████╔╝██║╚██████╔╝██║╚███╔███╔╝╚██████╔╝██║  ██║███████╗██████╔╝\n" +
                "╚═════╝ ╚═╝ ╚═════╝ ╚═╝ ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ \n" +
                RESET);

        System.out.print("Enter your champion name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Champion";
        }

        Player player = new Player(playerName);
        System.out.println("\nWelcome, " + playerName + "!");
        System.out.println("Preparing your journey...\n");
        System.out.println("[Press ENTER to continue]");
        scanner.nextLine();

        StoryManager storyManager = new StoryManager(player);
        // Intro
        storyManager.playIntroduction();

        // Beast Selection
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      SELECT YOUR MECHA BEASTS          ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nProfessor Ai-P: Choose 3 Mecha Beasts to accompany you!");
        System.out.println("Choose wisely - different types have advantages and weaknesses.\n");


        MechaBeast[] availableBeasts = MechaBeastFactory.getAllStarterBeasts();

        // Selection Table
        System.out.println("┌────┬─────────────┬──────────┬──────┬───────┬───────┐");
        System.out.println("│ #  │ Name        │ Type     │  HP  │ Speed │ Mana  │");
        System.out.println("├────┼─────────────┼──────────┼──────┼───────┼───────┤");

        // Loop sa mga available beasts
        for (int i = 0; i < 8; i++) {
            MechaBeast beast = availableBeasts[i];
            System.out.printf("│ %-2d │ %-11s │ %-8s │ %-4d │ %-5d │ %-5d │%n",
                    (i + 1),
                    beast.getName(),
                    beast.getType().getDisplayName(),
                    beast.getMaxHp(),
                    beast.getSpeed(),
                    beast.getMaxMana()
            );
        }

        System.out.println("│ 9  │ ???         │ ???      │ ???? │ ???   │ ???   │");
        System.out.println("└────┴─────────────┴──────────┴──────┴───────┴───────┘");

        System.out.println("\n💡 TIP: Balance your team with different types!");
        System.out.println("   High HP = Tank | High Speed = First Strike | High Mana = Powerful Skills");
        System.out.println("   ⚠️ Option 9 is a hidden beast... try it if you dare!");

        // Select 3 Beasts
        boolean[] alreadyChosen = new boolean[9];
        int selection;
        for (selection = 1; selection <= 3; selection++) {
            System.out.println("\n╔══ SELECTION " + selection + "/3 ══╗");
            int choice;

            while (true) {
                System.out.print("Choose Mecha Beast " + selection + " (1-9): ");
                try {
                    choice = scanner.nextInt();

                    scanner.nextLine();

                    if (choice < 1 || choice > 9) {
                        throw new IllegalArgumentException("Please enter a number between 1 and 9.");
                    }

                    if (alreadyChosen[choice - 1]) {
                        throw new IllegalStateException("That beast is already chosen. Pick another.");
                    }


                    alreadyChosen[choice - 1] = true;
                    break;

                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a number: ");
                    scanner.nextLine();
                }
            }

            MechaBeast selectedBeast = availableBeasts[choice - 1];

            if (choice == 9) {
                System.out.println("\n⚠️ SECRET UNLOCKED! ⚠️");
                System.out.println("✓ Kingmantis (OVERPOWERED CHARACTER) added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
                System.out.println("  This is a CHEAT beast with incredible stats!");
            } else {
                System.out.println("✓ " + selectedBeast.getName() + " (" +
                        selectedBeast.getType().getDisplayName() + ") added to your team!");
                System.out.println("  HP: " + selectedBeast.getMaxHp() +
                        " | Speed: " + selectedBeast.getSpeed() +
                        " | Mana: " + selectedBeast.getMaxMana());
            }

            //Adding beast to player team
            player.addMechaBeast(selectedBeast.copy());
        }

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         YOUR TEAM IS READY!            ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nYour team:");

        MechaBeast[] playerBeasts = player.getMechaBeasts();
        for (int i = 0; i < player.getBeastCount(); i++) {
            MechaBeast beast = playerBeasts[i];
            System.out.printf("%d. %s (%s)%n", (i + 1), beast.getName(),
                    beast.getType().getDisplayName());
        }

        System.out.println("\nProfessor Ai-P: Excellent choices! Now let's begin the test!");
        System.out.println("\n[Press ENTER to continue]");
        scanner.nextLine();


        // Stage 1: Alpha Village
        storyManager.playStage1AlphaVillage();

        // Stage 2: Beta City
        storyManager.playStage2BetaCity();

        // Stage 3: The Collapse
        storyManager.playStage3Collapse();

        // Game Complete
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          FINAL STATISTICS              ║");
        System.out.println("╚════════════════════════════════════════╝");


        System.out.println("\nChampion: " + player.getName());
        System.out.println("\nYour Final Team:");

        // display final team
        for (int i = 0; i < player.getBeastCount(); i++) {
            MechaBeast beast = playerBeasts[i];
            String status;
            if (beast.isAlive()) {
                status = "✓ ALIVE";
            } else {
                status = "✗ FAINTED";
            }

            System.out.printf("%d. %-15s (%s) - %s%n",
                    (i + 1),
                    beast.getName(),
                    beast.getType().getDisplayName(),
                    status
            );
        }

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    Stages Completed: 3/3               ║");
        System.out.println("║    Rank: LEGENDARY CHAMPION            ║");
        System.out.println("║    Status: GAME SAVED                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\nThank you for testing DigiWorld!");
        System.out.println("Your feedback will help shape the future of gaming!");


    }
    public static final String RESET  = "\u001B[0m";
    public static final String CYAN   = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";

}
