import java.util.Scanner;

public class AdaptiveQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;

        // 1. do-while loop: Runs the exam at least once and repeats if requested
        do {
            int score = 0;
            int difficulty = 2; // 1 = Easy, 2 = Medium, 3 = Hard
            System.out.println("\n--- Starting Adaptive Quiz ---");

            // 2. for loop: Asks a fixed number of questions (3 for this example)
            for (int i = 1; i <= 3; i++) {
                System.out.println("\nQuestion " + i + " (Current Difficulty: " + difficulty + ")");
                System.out.print("Simulate your answer (Type '1' for Correct, '0' for Wrong): ");
                int answer = scanner.nextInt();

                // 3. if-else statement: Checks if the user's answer is right or wrong
                if (answer == 1) {
                    System.out.println("Correct!");
                    score += (difficulty * 10); // Higher difficulty yields more points

                    // 4. nested if: Logic to increase difficulty if not already at max
                    if (difficulty < 3) {
                        difficulty++;
                        System.out.println("-> Leveling up! Next question will be harder.");
                    }
                } else {
                    System.out.println("Incorrect!");

                    // 4. nested if: Logic to decrease difficulty if not already at minimum
                    if (difficulty > 1) {
                        difficulty--;
                        System.out.println("-> Scaling back. Next question will be easier.");
                    }
                }
            }

            System.out.println("\nExam Complete! Your final score is: " + score);
            System.out.print("Do you want to retake the exam? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y'); 

        System.out.println("Exam session ended. Goodbye!");
        scanner.close();
    }
}
