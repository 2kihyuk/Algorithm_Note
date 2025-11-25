package 랜덤문제;

public class NH_2 {

    public static void main(String[] args) {
        //String str = "OneHundredPeopleHaveDTOIsRN";
        String str = "OnetWoThreefOurFIVResiXa";


        System.out.println(compress(str));   // OHPHDIR
    }

    // CamelCase + 중간에 DTO, RN 같은 약어 포함된 문자열을
    // 각 "단어"의 첫 대문자만 따서 압축
    static String compress(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 첫 글자는 무조건 대문자라고 했으니 바로 추가
        sb.append(arr[0]);

        for (int i = 1; i < n; i++) {
            char c = arr[i];
            if (!Character.isUpperCase(c)) continue; // 소문자는 단어 중간이니까 패스

            char prev = arr[i - 1];
            boolean isStart = false;


            // 1) 바로 앞이 소문자인 대문자: 새 단어 시작 (ex: One[O]ne -> H[Hundred])
            if (!Character.isUpperCase(prev)) {
                isStart = true;
            }
            // 2) 앞이 대문자이지만, 현재 대문자 바로 뒤가 소문자면
            //    DTOIs 에서 I 처럼 "약어 끝 + 새 단어 시작" 케이스
            else if (i + 1 < n && Character.isLowerCase(arr[i + 1])) {
                isStart = true;
            }

            if (isStart) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}