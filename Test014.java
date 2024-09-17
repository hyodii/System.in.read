import java.io.IOException;

public class Test014
	{
	public static void main(String[] args) throws IOException
	{
		// 주요 변수 선언
		char ch;   // 입력 받은 문자를 담을 변수
		int n;     // 입력 받은 정수를 담을 변수
		char temp;



		// 연산 및 처리
		// - 사용자에게 안내 메세지 출력 및 입력값 얻어오기
		System.out.print("한 문자 입력 : ");
		//System.in.read(); //import & throws 써야함 자바는 까탈스러우니까~!
		
		//문자를 받은 그래도 쓰고 싶다면
		//이러면 A를 가져오는것이 아니라 65를 가져온 것 int는 char에 담을 수 없음 그래서 형변환해야함! 
		ch = (char)System.in.read(); // A -> 65 -> A

		// ※ 입력 대기열에 남아있는 \r 과 \n을 스킵(건너뛰기) 해야함!!!!
		System.in.skip(2);
		//-- 매개변수(2)에 의해 두 글자를 읽지 않고 건너뛴다.(버린다.)


		// - 사용자에게 안내 메세지 출력 및 입력값 얻어오기
		System.out.print("한 자리 정수 입력 : ");
		n = System.in.read();  

		// 1 -> 49
		// 2 -> 50
		// 3 -> 51
		//   :
		// 9 -> 57

		// n 을 48 만큼 감소시켜라
		//n -= 48;
		temp = (char)n;
		

		// 결과 출력
		System.out.println();
		System.out.println(">> 입력한 문자 : " + ch);
		System.out.println(">> 입력한 정수 : " + temp);

	}
}


/*
한 문자 입력 : A
한 자리 정수 입력 : 5

>> 입력한 문자 : A
>> 입력한 정수 : 5
계속하려면 아무 키나 누르십시오 . . .

 */
