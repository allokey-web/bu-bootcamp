
import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    private static int invalidLines = 0;

    public static void main(String[] args) {

        System.out.println("Grade Analyzer Started");

        // Step 1: Read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Step 2: Handle empty or invalid files
        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            writeReport(scores, 0.0, 0, 0, "report.txt");
            return;
        }

        // Step 3: Calculate average
        double average = calculateAverage(scores);

        // Step 4: Find highest and lowest scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 5: Generate report
        writeReport(
            scores, average, highest, lowest, "report.txt"
        );
    }

    // Read and validate scores from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();
        invalidLines = 0;

        try (BufferedReader reader =
                new BufferedReader(new FileReader(filename))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);

                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        invalidLines++;
                        System.out.println(
                            "Warning: Invalid score on line "
                            + lineNumber + ": " + line
                        );
                    }

                } catch (NumberFormatException e) {
                    invalidLines++;
                    System.out.println(
                        "Warning: Invalid number on line "
                        + lineNumber + ": " + line
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error reading file: " + e.getMessage()
            );
        }

        return scores;
    }

    // Calculate average score
    public static double calculateAverage(
            ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Write and print the grade analysis report
    public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            String outputFile) {

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        // Count scores in each grade band
        for (int score : scores) {

            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        StringBuilder report = new StringBuilder();

        report.append("=== Grade Analysis Report ===\n");

        report.append(String.format(
            "Total scores processed: %d%n", scores.size()
        ));

        report.append(String.format(
            "Invalid lines skipped:   %d%n", invalidLines
        ));

        report.append(String.format(
            "Average score:           %.2f%n", avg
        ));

        if (!scores.isEmpty()) {
            report.append(String.format(
                "Highest score:           %d%n", high
            ));

            report.append(String.format(
                "Lowest score:            %d%n", low
            ));
        } else {
            report.append("Highest score:           N/A\n");
            report.append("Lowest score:            N/A\n");
        }

        report.append("\nGrade distribution:\n");

        report.append(String.format(
            "  A (90-100):  %d%n", countA
        ));

        report.append(String.format(
            "  B (80-89):   %d%n", countB
        ));

        report.append(String.format(
            "  C (70-79):   %d%n", countC
        ));

        report.append(String.format(
            "  D (60-69):   %d%n", countD
        ));

        report.append(String.format(
            "  F (below 60): %d%n", countF
        ));

        if (scores.isEmpty()) {
            report.append("\nNo valid scores to analyze.\n");
        }

        // Print report to terminal
        System.out.println(report);

        // Write report to file
        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(report.toString());

            System.out.println(
                "Report saved to " + outputFile
            );

        } catch (IOException e) {
            System.out.println(
                "Error writing report: " + e.getMessage()
            );
        }
    }
}
