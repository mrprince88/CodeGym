import java.util.*;


class ApartmentHunting {

	static int solve(TreeMap < Integer, HashMap<String, Boolean>> buildings, String[]req) {
		int [][]position = new int[req.length][buildings.size()];
		int c = 0;
		for (String i : req)
			position[c++] = getclosestLeftRight(i, buildings);

		return getminMaximum(position, req.length, buildings.size());
	}

	static int[] getclosestLeftRight(String req, TreeMap < Integer, HashMap<String, Boolean>> buildings) {

		int []minDistance = new int[buildings.size()];
		int index = Integer.MAX_VALUE;
		List<Integer> set = new ArrayList<>(buildings.keySet());
		for (int i : set) {
			if (buildings.get(i).get(req))
				index = i;

			minDistance[i] = Math.abs(i - index);
		}
		Collections.reverse(set);
		for (int i : set) {
			if (buildings.get(i).get(req))
				index = i;

			minDistance[i] = Math.min(minDistance[i], Math.abs(i - index));
		}

		return minDistance;
	}

	static int getminMaximum(int [][]position, int row, int col) {
		int max = 0, min = Integer.MAX_VALUE, pos = 0, tempPos = 0;
		for (int j = 0; j < col; j++) {
			max = Integer.MIN_VALUE;
			for (int i = 0; i < row; i++) {
				if (max < position[i][j]) {
					max = position[i][j];
					tempPos = j;
				}
			}
			if (min > max) {
				min = max;
				pos = tempPos;
			}
		}
		return pos;
	}


	public static void main(String[] args) {

		TreeMap<Integer, HashMap<String, Boolean>> buildings = new TreeMap<>() {
			{
				put(0, new HashMap<String, Boolean>() {
					{
						put("School", true);
						put("Gym", false);
						put("Studio", false);
					}
				});
				put(1, new HashMap<String, Boolean>() {
					{
						put("School", false);
						put("Gym", true);
						put("Studio", false);
					}
				});
				put(2, new HashMap<String, Boolean>() {
					{
						put("School", true);
						put("Gym", true);
						put("Studio", false);
					}
				});
				put(3, new HashMap<String, Boolean>() {
					{
						put("School", true);
						put("Gym", false);
						put("Studio", false);
					}
				});
				put(4, new HashMap<String, Boolean>() {
					{
						put("School", true);
						put("Gym", false);
						put("Studio", true);
					}
				});
			}
		};

		String req[] = {"School", "Gym", "Studio"};
		System.out.println(solve(buildings, req));

	}
}