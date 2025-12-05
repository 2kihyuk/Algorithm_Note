package 처음부터_20251202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터_1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int len = line.length();

        Stack<Character> mainStack = new Stack<>();
        Stack<Character> popStack = new Stack<>();

        for(int i = 0; i<len; i++){
            mainStack.push(line.charAt(i));
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("P")){
                String secondOrder = st.nextToken();
                char sOrder = secondOrder.charAt(0);

                mainStack.push(sOrder);
            }else if(order.equals("L")){
                if(!mainStack.isEmpty()){
                    popStack.push(mainStack.pop());
                }
            }else if(order.equals("D")){
                if(!popStack.isEmpty()){
                    mainStack.push(popStack.pop());
                }
            }else{
                if(!mainStack.isEmpty()){
                    mainStack.pop();
                }
            }

//            abcd
//            3
//            P x
//            L
//            P y

//            L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
//            D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
//            B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
//            삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
//            P $	$라는 문자를 커서 왼쪽에 추가함
        }

        while (!popStack.isEmpty()) {
            mainStack.push(popStack.pop());
        }

// StringBuilder로 바로 만들기
        StringBuilder sb = new StringBuilder();

        while (!mainStack.isEmpty()) {
            sb.append(mainStack.pop());
        }

// 거꾸로 들어가 있으니까 뒤집어서 출력
        System.out.println(sb.reverse());


//        ArrayList<Character> list = new ArrayList<>();
//        for(int i = 0; i<len; i++){
//            list.add(line.charAt(i));
//        }
//        int cursor = len;
//
//        for(int i = 0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//            String order = st.nextToken();
//
//            if(order.equals("P")){
//                char[] x = order.toCharArray();
//                list.add(cursor,x[0]);
//            }else if(order.equals("D")){
//                if(cursor == list.size()+1) {
//                    cursor = list.size()+1;
//                }else {
//                    cursor++;
//                }
//            }else if(order.equals("L")){
//                if(cursor == 0){
//                    cursor = 0;
//                }else{
//                    cursor--;
//                }
//            }else if(order.equals("B")){
//                list.remove(cursor-1);
//            }
//        }
//
//        for(char a : list){
//            System.out.print(a);
//        }


    }
}
