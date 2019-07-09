package programmers;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumber2 {


    static Map<Integer, Integer> hash = new HashMap<>();

    public int solution(String numbers){

        //문자열을 int로 바꿔서 배열에 넣음
        String[] numsStr = numbers.split("");
        int[] nums = new int[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            nums[i] = Integer.parseInt( numsStr[i] );
        }

        for(int i=1; i<=numbers.length(); i++){
            permutation(nums,0, nums.length,i);
        }
        return hash.size();

    }

    //숫자세트 만들기
    private static void permutation(int[] arr, int depth, int n, int k) {

        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.

            //arr중 k번째까지가 유효
//            System.out.println( makeIntNumber(arr, k) );
            checkPrime( makeIntNumber(arr, k) );

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, k);
            swap(arr, depth, i); //원상복귀
        }
    }

    private static void swap(int[] arr, int i, int depth){
        int temp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = temp;
    }



    //배열의 안의 값을 k번째까지 이어붙여서 숫자로 만듦
    private static int makeIntNumber(int[] arr, int k){
        int result = 0;
        for(int i=0; i<k; i++){
            result += arr[i] * Math.pow(10, i);
        }
        return result;
    }



    //소수인지 체크(에라토스테네스의 체를 이용하여 성능개선 가능)
    public static void checkPrime(int number){

        if(number==0 || number==1) return;

        for(int i=2; i<number; i++){
            if(number%i==0) return;
        }

        //해쉬에 삽입(똑같은건 덮어씌워져서 중복체크 방지)
        hash.put(number, number);
    }


}