import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.IOException;
 
public class Main {
 
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<String> list = new LinkedList<>();
	
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]); // 식빵 개수
		int m = Integer.parseInt(nm[1]); // 암호문 개수
		
		// 소문자 알파벳이 적혀있는 식빵들의 상태를 나타내는 문자열이 공백없이 주어짐.
		String arr = br.readLine();
		for(char ch: arr.toCharArray())
			list.add(String.valueOf(ch));
		
		// Iterator 설
		ListIterator<String> it = list.listIterator(list.size());
		
		/**
		 * L :가리키는 위치 바로 앞에 있는 빵을 건너뛴 위치로 변경 (맨 앞 무시)
		 * R : 가리키는 위치 바로 뒤 빵을 건너뛴 위치로 변경 (맨 뒤 무시)
		 * D : 가리키는 위치 바로 뒤 빵을 제거 (맨 뒤 무시)
		 * P & : 가리키는 위치에 '&' 라는 문자가 적혀있는 식빵 추가 (이후 가리키는 위치는 추가된 문자 & 바로 뒤)
		 */
		for(int i=0; i<m; i++) {
			String[] temp = br.readLine().split(" ");
			
			switch(temp[0]){
				case "L":
					if(it.hasPrevious()) it.previous();
					break;
				case "R":
					if(it.hasNext()) it.next();
					break;
				case "D":
					if(it.hasNext()) {
						it.next();
						it.remove();
					}
					break;
				case "P":
					it.add(temp[1]);
					break;
			}
		}

		it = list.listIterator();
		while(it.hasNext())
			System.out.print(it.next());

	}

 
}