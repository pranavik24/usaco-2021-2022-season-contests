import java.util.Scanner;

public class EmailFiling {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);

			int numProblems = sc.nextInt();

			for (int i = 0; i < numProblems; ++i) {
				int numFolders = sc.nextInt();
				int numEmails = sc.nextInt();
				int maxCount = sc.nextInt();

				int[] emailFolderFilingList = new int[numEmails];
				for (int j = 0; j < numEmails; ++j) {
					emailFolderFilingList[j] = sc.nextInt();
				}
				System.out.println(solveProblem(numFolders, numEmails, maxCount, emailFolderFilingList));

			}
		} catch (Throwable exp) {
			exp.printStackTrace();
		}
	}

	public static String solveProblem(int numFolders, int numEmails, int maxCount, int[] emailFolderFilingList) {
		if (maxCount >= numEmails) {
			return "YES";
		}
		int[] curEmailSet = new int[maxCount];
// initialize set
		for (int i = 0; i < maxCount; ++i) {
			curEmailSet[i] = i;
		}

// Proceed with solution
		int nextEmail = maxCount;
		int maxFolder = maxCount;
		int minFolder = 1;
		boolean notSolved = true;
		int startElement = 0;
		while (notSolved) {
			for (int i = startElement; i < maxCount; ++i) {
				boolean isStartElement = (i == 0);
				while ((curEmailSet[i] != -1) && (emailFolderFilingList[curEmailSet[i]] >= minFolder
						&& emailFolderFilingList[curEmailSet[i]] <= maxFolder)) {
					if (nextEmail >= numEmails) {
						curEmailSet[i] = -1;
						if (isStartElement) {
							++startElement;
						}
					} else {
						curEmailSet[i] = nextEmail;
					}
					++nextEmail;
				}

				if ((curEmailSet[i] != -1) && (emailFolderFilingList[curEmailSet[i]] < minFolder)) {
					return "NO";
				}
			}

			if (startElement == maxCount) {
				notSolved = false;
			} else {
// Scroll folder down by 1
				++minFolder;
				++maxFolder;
				if (maxFolder > numFolders) {
					return "NO";
				}
			}
		}

		return notSolved ? "NO" : "YES";
	}

}
