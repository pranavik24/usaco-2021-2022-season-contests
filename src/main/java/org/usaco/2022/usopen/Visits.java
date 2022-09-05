import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Visits {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numCows = Integer.parseInt(reader.readLine());
		int[] graph = new int[numCows];
		int[] weights = new int[numCows];

		for (int i = 0; i < numCows; i++) {
			String[] values = reader.readLine().split(" ");
			graph[i] = Integer.parseInt(values[0]);
			weights[i] = Integer.parseInt(values[1]);
		}

// Find the max moos from each node
// Start off from edges with min weight
		int minWeight = Arrays.stream(weights).min().getAsInt();
		List<Integer> startCows = new ArrayList<Integer>();
		for (int i = 0; i < numCows; ++i) {
			if (weights[i] == minWeight) {
				if (weights[graph[i] - 1] != minWeight) {
					startCows.add(graph[i] - 1);
				}
			}
		}
		long maxMoo = 0;
		for (int curCow : startCows) {
			int cowVisits = 0;
			int startCow = curCow;

			long curMoo = 0;
			Set<Integer> travellingCows = new HashSet<>();
			Set<Integer> pendingCows = new HashSet<>();
			for (int i = 0; i < numCows; ++i) {
				pendingCows.add(i);
			}
			int visitCow = -1;
			while ((startCow != visitCow)) {
				visitCow = graph[curCow] - 1;
				pendingCows.remove(curCow);
				if (!travellingCows.contains(visitCow)) {
					curMoo += weights[curCow];
					travellingCows.add(curCow);
				} else {
					break;
				}
				curCow = visitCow;
				++cowVisits;
			}

			while (pendingCows.size() != 0) {
				visitCow = -1;
// sort pending cows
				ArrayList<Integer> pendingCowList = new ArrayList<>(pendingCows);
				Collections.sort(pendingCowList, (i, j) -> weights[i] - weights[j]);
				int pendingCow = pendingCowList.get(0);
				if (travellingCows.contains(graph[pendingCow] - 1)) {
					curMoo += weights[pendingCow];
					pendingCows.remove(pendingCow);
					startCow = pendingCow;
					curCow = startCow;
				} else {
					startCow = graph[pendingCow] - 1;
					curCow = startCow;
				}
				while (startCow != visitCow) {
					visitCow = graph[curCow] - 1;
					pendingCows.remove(curCow);
					if (!travellingCows.contains(visitCow)) {
						curMoo += weights[curCow];
						travellingCows.add(curCow);
					} else {
						break;
					}
					curCow = visitCow;
					++cowVisits;
				}
			}
			if (curMoo > maxMoo) {
				maxMoo = curMoo;
			}
		}
		System.out.println(maxMoo);
	}
}
