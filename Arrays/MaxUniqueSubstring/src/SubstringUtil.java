import java.util.Arrays;

public class SubstringUtil {
	public static void longestUniqueSubstring(String str) {
		if(str == null || str.length() == 0) {
			return;
		}
		
		int n = str.length();
		//visited[j] denotes the previous index of the character at str[j]
		//visited[j] = -1 denotes the character at str[j] is not visited
		int visited[] = new int[256];
		int maxLength = Integer.MIN_VALUE;
		int startIndex = -1;
		int currentLength = -1;
		
		Arrays.fill(visited, -1);
		
		visited[str.charAt(0)] = 0;
		currentLength = 1;
		maxLength = 1;
		startIndex = 0;
		
		int i = 1;
		for(i = 1; i < n; ++i) {
			int previousIndex = visited[str.charAt(i)];
			if(previousIndex == -1 || i - currentLength > previousIndex) {
				++currentLength;
			} else {
				if(currentLength > maxLength) {
					maxLength = currentLength;
					startIndex = i - currentLength + 1;
				}
				currentLength = i - previousIndex;			
			}	
			
			visited[str.charAt(i)] = i;
		}
		if(currentLength > maxLength) {
			maxLength = currentLength;
			startIndex = i - currentLength + 1;
		}
		
		System.out.println(maxLength);
		String substring = str.substring(startIndex, startIndex + maxLength);
		System.out.println(substring);
	}
}
