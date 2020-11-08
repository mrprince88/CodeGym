import java.util.*;

class LowestCommonManager {

	static class OrgGraph {

		Map<Character, LinkedList<Character>> orgInfo = new HashMap<>();

		void addEntry(char manager, List<Character> workers) {
			LinkedList<Character> employees = new LinkedList<>(workers);
			orgInfo.put(manager, employees);
		}

		// O(N) time | O(D) space
		char getLowestCommonManager(char manager, char emp1, char emp2) {

			if (manager == '\0' || manager == emp1 || manager == emp2)
				return manager;

			boolean judgeemp1 = false, judgeemp2 = false;

			for (char em : orgInfo.get(manager)) {

				char result = getLowestCommonManager(em, emp1, emp2);

				if (result == emp1)
					judgeemp1 = true;

				else if (result == emp2)
					judgeemp2 = true;

				else if (result != '\0')
					return result;
			}

			if (judgeemp1 == true && judgeemp2 == true)
				return manager;

			else if (judgeemp1 == true)
				return emp1;

			else if (judgeemp2 == true)
				return emp2;

			return '\0';
		}
	}

	public static void main(String[] args) {
		OrgGraph orgInfo = new OrgGraph();
		orgInfo.addEntry('A', Arrays.asList('B', 'C', 'D', 'E', 'F'));
		orgInfo.addEntry('B', Arrays.asList('G', 'H', 'I'));
		orgInfo.addEntry('C', Arrays.asList('J'));
		orgInfo.addEntry('D', Arrays.asList('K', 'L'));
		orgInfo.addEntry('E', Arrays.asList());
		orgInfo.addEntry('F', Arrays.asList('M', 'N'));
		orgInfo.addEntry('G', Arrays.asList());
		orgInfo.addEntry('H', Arrays.asList('O', 'P'));
		orgInfo.addEntry('I', Arrays.asList());
		orgInfo.addEntry('J', Arrays.asList());
		orgInfo.addEntry('K', Arrays.asList());
		orgInfo.addEntry('L', Arrays.asList());
		orgInfo.addEntry('M', Arrays.asList());
		orgInfo.addEntry('N', Arrays.asList());
		orgInfo.addEntry('O', Arrays.asList());
		orgInfo.addEntry('P', Arrays.asList());
		System.out.println(orgInfo.getLowestCommonManager('A', 'I', 'P'));
	}
}