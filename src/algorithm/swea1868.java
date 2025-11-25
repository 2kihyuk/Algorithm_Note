package algorithm;

import java.util.ArrayDeque;
import java.util.Scanner;

class swea1868 {

    // 8방향 탐색을 위한 dx, dy 배열 (상하좌우 및 대각선)
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 테스트 케이스 개수

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt(); // 보드 크기
            char[][] board = new char[N][N]; // 원본 보드
            int[][] mineCounts = new int[N][N]; // 각 칸 주변의 지뢰 개수를 저장
            boolean[][] visited = new boolean[N][N]; // 방문 여부 (이미 공개된 칸)

            // 보드 입력 받기
            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            // 1. 각 칸 주변의 지뢰 개수를 미리 계산하여 mineCounts 배열에 저장
            // 이 과정은 board가 '*'일 때만 수행
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == '*') { // 현재 칸이 지뢰라면
                        // 그 지뢰의 8방향 주변 칸들의 mineCounts를 증가시킴
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dx[d];
                            int nc = c + dy[d];

                            // 보드 범위 내에 있는 경우에만 증가
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                mineCounts[nr][nc]++;
                            }
                        }
                    }
                }
            }

            int totalClicks = 0; // 총 클릭 횟수

            // 2. 0인 칸을 찾아 BFS로 연쇄 공개 처리
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 아직 방문하지 않았고, 지뢰가 아니며, 주변 지뢰 개수가 0인 칸인 경우
                    if (board[r][c] == '.' && !visited[r][c] && mineCounts[r][c] == 0) {
                        totalClicks++; // 이 칸을 클릭!

                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        q.add(new int[]{r, c});
                        visited[r][c] = true; // 시작 칸 방문 처리

                        // BFS 시작
                        while (!q.isEmpty()) {
                            int[] current = q.poll();
                            int curR = current[0];
                            int curC = current[1];

                            // 현재 칸이 0인 경우에만 그 주변 칸들을 탐색
                            // 이미 mineCounts[curR][curC]가 0인 경우에만 이 BFS가 시작되므로,
                            // 여기에 mineCounts[curR][curC] == 0 체크는 사실상 불필요하지만,
                            // 명확성을 위해 유지해도 무방 (혹은 시작 조건에 이미 포함)
                            // 핵심은 0인 칸을 열면 그 주변은 다 열리지만,
                            // 연쇄적으로 큐에 들어가는 것은 주변 칸 중 다시 '0'인 칸들만이어야 함
                            // 그런데 마인스위퍼 규칙상 0인 칸 주변은 '숫자' 칸도 열리므로,
                            // 큐에는 0인 칸만 넣고, visited는 0이 아니어도 갱신해야 함.

                            // 이 부분은 현재 칸이 0이었으므로, 그 주변 8칸은 모두 열립니다.
                            for (int d = 0; d < 8; d++) {
                                int nextR = curR + dx[d];
                                int nextC = curC + dy[d];

                                // 다음 칸이 보드 범위 내에 있고, 아직 방문하지 않았으며 (지뢰가 아님도 내포)
                                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC]) {
                                    // 중요: 지뢰가 아니면서 아직 방문하지 않은 칸은 모두 방문 처리
                                    // (0인 칸이 아니어도 0인 칸에 의해 공개되기 때문)
                                    // 단, 지뢰(*) 칸은 방문하지 않음.
                                    if(board[nextR][nextC] == '*') continue; // 지뢰 칸은 건너뛴다

                                    visited[nextR][nextC] = true;

                                    // 만약 다음 칸도 0이라면, 연쇄적으로 BFS 큐에 추가
                                    if (mineCounts[nextR][nextC] == 0) {
                                        q.add(new int[]{nextR, nextC});
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 3. 0인 칸 클릭으로 처리되지 않은 나머지 '.' 칸들 클릭
            // 이 칸들은 주변에 지뢰가 있어서 숫자가 표시되어야 하는 칸들이다.
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 아직 방문하지 않았고, 지뢰가 아닌 칸이라면
                    if (board[r][c] == '.' && !visited[r][c]) {
                        totalClicks++; // 개별적으로 클릭해야 함
                    }
                }
            }

            System.out.println("#" + test_case + " " + totalClicks);
        }
        sc.close();
    }
}