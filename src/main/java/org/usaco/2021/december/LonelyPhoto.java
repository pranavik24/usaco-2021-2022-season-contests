import java.util.*;

public class LonelyPicture {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] cows = sc.next().toCharArray();
		long lonelyPhotos = 0;
		int hCount = 0;
		int gCount = 0;
		int endIndex = -1;
		int type = -1;
		char lonelyCow = 'L';
		char repeatingCow = 'L';
		for (int i = 0; i <= n - 3; i++) {
			endIndex = i + 2;
			type = -1;
			lonelyCow = 'L';
			repeatingCow = 'L';
			hCount = 0;
			gCount = 0;
			for (int j = i; j <= endIndex; j++) {
				if (cows[j] == 'H') {
					hCount++;
				} else {
					gCount++;
				}
			}
			if (hCount == 3) {
				type = 1;
				repeatingCow = 'H';
			}
			if (gCount == 3) {
				type = 1;
				repeatingCow = 'G';
			}
			if (hCount == 1) {
				type = 2;
				lonelyCow = 'H';
				lonelyPhotos++;
			}
			if (gCount == 1) {
				type = 2;
				lonelyCow = 'G';
				lonelyPhotos++;
			}
			++endIndex;
			while (endIndex <= n - 1) {
				if (type == 1) {
					if (cows[endIndex] != repeatingCow) {
						++lonelyPhotos;
						type = 2;
						if (repeatingCow == 'G') {
							lonelyCow = 'H';
						} else {
							lonelyCow = 'G';
						}
					}
				} else if (type == 2) {
					if (cows[endIndex] == lonelyCow) {
						break;
					} else {
						++lonelyPhotos;
					}
				}
				++endIndex;
			}
		}

		System.out.println(lonelyPhotos);
	}

}
