import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RobotInstructions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numInstructions = sc.nextInt();
		int xTarget = sc.nextInt();
		int yTarget = sc.nextInt();
		int[] xInstructionsInput = new int[numInstructions];
		int xInstructionsCount = 0;
		int[] yInstructionsInput = new int[numInstructions];
		int yInstructionsCount = 0;

		for (int i = 0; i < numInstructions; ++i) {
			int xInstruction = sc.nextInt();
			int yInstruction = sc.nextInt();
			if (0 == xInstruction) {
				yInstructionsInput[yInstructionsCount] = yInstruction;
				++yInstructionsCount;
			} else {
				xInstructionsInput[xInstructionsCount] = xInstruction;
				++xInstructionsCount;
			}
		}

		int[] xInstructions = new int[xInstructionsCount];
		int[] yInstructions = new int[yInstructionsCount];
		System.arraycopy(xInstructionsInput, 0, xInstructions, 0, xInstructionsCount);
		System.arraycopy(yInstructionsInput, 0, yInstructions, 0, yInstructionsCount);

		List<Integer> xPossCombinations = new ArrayList<>();
		combination(xInstructions, xTarget, 0, xPossCombinations, 0);
		List<Integer> yPossCombinations = new ArrayList<>();
		combination(yInstructions, yTarget, 0, yPossCombinations, 0);

// System.out.println(xPossCombinations);
// System.out.println(yPossCombinations);
		int[] output = new int[numInstructions];
		for (int xCombination : xPossCombinations) {
			for (int yCombination : yPossCombinations) {
				int length = xCombination + yCombination - 1;
				output[length] = output[length] + 1;
			}
		}

		Arrays.stream(output).forEach(System.out::println);

	}

	private static StringBuilder combinationBuilder = new StringBuilder(8096);

	private static void combination(int[] inputInstructions, int target, int start, List<Integer> possibleCombinations,
			int value) {
		int curLength = 0;
		for (int i = start; i < inputInstructions.length; ++i) {
			combinationBuilder.append(i);
			value += inputInstructions[i];
			curLength = combinationBuilder.length();
			if (target == value) {
				possibleCombinations.add(curLength);
			}
			if (i < inputInstructions.length)
				combination(inputInstructions, target, i + 1, possibleCombinations, value);
			value -= inputInstructions[i];
			combinationBuilder.setLength(curLength - 1);
		}
	}
}
