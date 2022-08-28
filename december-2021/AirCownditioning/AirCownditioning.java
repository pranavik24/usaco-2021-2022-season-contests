import java.util.*;

public class AirCownditioning {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] ideal = new int[n];
			int[] current = new int[n];

			for (int i = 0; i < n; i++) {
				ideal[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				current[i] = sc.nextInt();
			}

			int[] tempDiff = new int[n];
			for (int i = 0; i < n; i++) {
				tempDiff[i] = current[i] - ideal[i];
			}

			boolean notAllPerfect = true;
			int numberCommands = 0;
			int startRoom = -1;
			int endRoom = -1;
			for (int temp : tempDiff) {
				if (temp != 0) {
					notAllPerfect = true;
					break;
				}
			}
			while (notAllPerfect) {
				startRoom = changeStartIndex(tempDiff, 0);
				if (startRoom == -1) {
// nothing to do
					break;
				}
				endRoom = changeEndIndex(tempDiff, startRoom);
				if (endRoom == -1) {
					endRoom = n - 1;
				}
				changeTemp(getSign(tempDiff[startRoom]) * -1, startRoom, endRoom, tempDiff);
				++numberCommands;
				while (endRoom != n - 1) {
					startRoom = changeStartIndex(tempDiff, endRoom + 1);
					if (startRoom == -1) {
						break;
					}
					endRoom = changeEndIndex(tempDiff, startRoom);
					if (endRoom == -1) {
						endRoom = n - 1;
					}
					changeTemp(getSign(tempDiff[startRoom]) * -1, startRoom, endRoom, tempDiff);
					++numberCommands;
				}
				notAllPerfect = false;
				for (int temp : tempDiff) {
					if (temp != 0) {
						notAllPerfect = true;
						break;
					}
				}
			}

			System.out.println(numberCommands);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void changeTemp(int tempChange, int startIndex, int endIndex, int[] diff) {
		for (int i = startIndex; i <= endIndex; i++) {
			diff[i] += tempChange;
		}
	}

	public static int getSign(int number) {
		return number > 0 ? 1 : -1;
	}

	public static int changeStartIndex(int[] diff, int index) {
		for (int i = index; i < diff.length; i++) {
			if (diff[i] == 0) {
				if (i == index) {
					for (int j = i + 1; j < diff.length; j++) {
						if (diff[j] != 0) {
							return j;
						}
					}
					return -1;
				} else {
					if (i > index)
						return i - 1;
				}
			} else {
				return i;
			}
		}
		return -1;
	}

	public static int changeEndIndex(int[] diff, int index) {
		for (int i = index; i < diff.length; i++) {
			if (diff[i] == 0) {
				if (i == index) {
					for (int j = i + 1; j < diff.length; j++) {
						if (diff[j] != 0) {
							return j;
						}
					}
					return -1;
				} else {
					if (i > index)
						return i - 1;
				}
			}
			if (i > index) {
				if (getSign(diff[i]) != getSign(diff[i - 1])) {
					return i - 1;
				}
			}
		}
		return -1;
	}

}
