/*
실행 예)
『연도』를 입력하세요 : 2021
『월』을 입력하세요 : 8

        [ 2020년 8월 ]

  일  월  화  수  목  금  토
 =============================
   1   2   3   4   5   6   7
   8   9  10  11  12  13  14
  15  16  17  18  19  20  21
  22  23  24  25  26  27  28
  29  30  31
 =============================
 계속하려면 아무키나 누르세요....

○ 문제 분석 및 접근
	- 서기 1년 1월 1일 : 월요일
	- 연도가 4의 배수이면서 100의 배수가 아니거나,
	  400의 배수이면 2월은 29일(윤년),
	  나머지는 2월 28일(평년)
	- 만약 2021년 8월 달력을 그린다고 가정하면
	  1.1.1 ~ 2021.7.31 까지의 날 수를 구한다.
	  그 날 수에 『+1』 연산을 수행하면... (1.1.1 ~ 2021.8.1) 날 수 확인
	  이 날 수를 통해 2021년 8월 1일의 요일 확인


*/

// 2021 8 3 --> 화요일
// 2021 8 -> 2021 8 1 --> 일요일

import java.util.Scanner;

public class Test101
{
	public static void main(String[] args)
	{
		int nalsu, y, m, w;  //날수 년 월 요일
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("『연도』를 입력하세요 : ");
			y = sc.nextInt();
		}
		while (y<1);
		
		do
		{
			System.out.print("『월』을 입력하세요 : ");
			m = sc.nextInt();

		}
		while (m<1 || m>12);
		
		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] days = {"일","월","화","수","목","금","토"};
				
		// 입력받은 년도에 해당하는 2월의 마지막 날 계산
		if((y%4==0 && y%100!=0) || y%400==0)
			months[1] = 29;
		/* 현재 months 배열의 1번째 요소(즉, 2월)가 28로 구성되어 있는 상태이기 때문에 생략 가능
		else
			months[1] = 28;
		*/

		// 1. 1년 1월 1일부터 입력받은 년도의 이전년도 12월 31일 까지의 날 수 계산
		nalsu = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		// 2. 입력받은 월의 이전 월 까지의  날 수 계산 후 이 계산 결과를 1번의 결과에 더하는 연산
		for (int i=0;i<(m-1);i++ )
		{
			nalsu += months[i];
		}

		// 입력받은 월의 1일을 날 수 누적 연산
		nalsu += 1;  //++nalsu; 같은것

		//요일 산출 -> 입력받은 월의 1일이 무슨 요일인지 확인하기 위한 연산
		w = nalsu % 7;   // 0:일요일,1:월요일 .....

		// 출력(달력 그리기)		
		System.out.println();
		System.out.printf("\t[ %4d년 %2d월 ]\n",y,m);    // \t하면 탭임!!
		System.out.println();
		System.out.println("  일  월  화  수  목  금  토");  //4칸이 요일 하나 공백2개 글자1개가 2
		System.out.println("=============================");
		
		for (int i=0; i<w;i++)
		{
			System.out.print("    ");  //공백 4칸 발생
		}

		// 해달 월(입력한 월)의 날짜들이 출력될 수 있도록 반복문 구성
		for (int i=1; i<=months[m-1];i++)
		{
			System.out.printf("%4d",i);
			w++; //w는 1일이 무슨 요일인지 확인하기 위한것이니까 날짜를 처리할때마다 요일도 하나씩 증가

			// 일요일에 해당하는 날짜일 경우 개행
			if (w%7==0)
			{
				System.out.println();
			}
	
		}

		//2021년7월찍었을경우 불필요한 개행이 실행되는데 안나오게 처리!
		// 달의 마지막 날짜가 출력 형식을 모두 채웠을 경우
		// 이미 일요일 개행이 이루어 졌기 때문에 이 경우는 추가 개행을 하지않도록 처리~!!!
		if (w%7!=0)
		{
			System.out.println();
		}
		
		System.out.println("=============================");


	}
}
/*
『연도』를 입력하세요 : 2021
『월』을 입력하세요 : 8

        [ 2021년  8월 ]

  일  월  화  수  목  금  토
=============================
   1   2   3   4   5   6   7
   8   9  10  11  12  13  14
  15  16  17  18  19  20  21
  22  23  24  25  26  27  28
  29  30  31
=============================
계속하려면 아무 키나 누르십시오 . . .


『연도』를 입력하세요 : 1994
『월』을 입력하세요 : 12

        [ 1994년 12월 ]

  일  월  화  수  목  금  토
=============================
                   1   2   3
   4   5   6   7   8   9  10
  11  12  13  14  15  16  17
  18  19  20  21  22  23  24
  25  26  27  28  29  30  31

=============================
계속하려면 아무 키나 누르십시오 . . .


『연도』를 입력하세요 : 2021
『월』을 입력하세요 : 7

        [ 2021년  7월 ]

  일  월  화  수  목  금  토
=============================
                   1   2   3
   4   5   6   7   8   9  10
  11  12  13  14  15  16  17
  18  19  20  21  22  23  24
  25  26  27  28  29  30  31
=============================
계속하려면 아무 키나 누르십시오 . . .
*/