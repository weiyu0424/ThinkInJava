package com.weiyu.offer.pingduoduo;

import java.util.*;

class Node {
    public int x, y, sta, step;

    public Node(int x, int y, int sta, int step) {
        this.x = x;
        this.y = y;
        this.sta = sta;
        this.step = step;
    }
}
public class Four {
    static char[][] mp = new char[105][105];
    static boolean[][][] vis = new boolean[105][105][(1 << 10) + 5];
    static int sx, sy, ex, ey, n, m;
    static int[] st = new int[30];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> vec = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                String line = in.nextLine();
                Arrays.fill(mp,line);
                for (int j = 1; j <= m; j++) {
                    if (mp[i][j] == '2') {sx = i; sy = j;}
                    else if (mp[i][j] == '3') {ex = i; ey = j;}
                    else if (mp[i][j] >= 'a' && mp[i][j] <= 'z') {
                        vec.add(mp[i][j] - 'a');
                    }
                }
            }

            Collections.sort(vec);
            Arrays.fill(st,-1);
            for (int i = 0; i < vec.size(); i++) {
                int c = vec.get(i);
                st[c] = i;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (mp[i][j] >= 'a' && mp[i][j] <= 'z')
                        mp[i][j] = (char) (st[mp[i][j] - 'a'] + 'a');
                    else if (mp[i][j] >= 'A' && mp[i][j] <= 'Z')
                        mp[i][j] = (char) (st[mp[i][j] - 'A'] + 'A');
                }
            }

            bfs();
        }
    }

    public static void bfs() {
        Arrays.fill(vis, false);
        LinkedList<Node> que = new LinkedList<>();
        que.push(new Node(sx, sy, 0, 0));
        vis[sx][sy][0] = true;
        while (!que.isEmpty()) {
            Node now = que.element(); que.pop();
            if (now.x == ex && now.y == ey) {
                System.out.println(now.step);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i], ns = now.sta;
                if (nx < 1 || nx > n || ny < 1 || ny > m || mp[nx][ny] == '0') continue;
                if (mp[nx][ny] >= 'a' && mp[nx][ny] <= 'z') {
                    ns |= (1 << (mp[nx][ny] - 'a'));
                }
                if (vis[nx][ny][ns]) continue;
                if (mp[nx][ny] >= 'A' && mp[nx][ny] <= 'Z') {
                    int t = mp[nx][ny] - 'A';
                    if ((ns & (1 << t)) != 0) continue;
                }
                vis[nx][ny][ns] = true;
                que.push(new Node(nx, ny, ns, now.step + 1));
            }
        }
    }
}
