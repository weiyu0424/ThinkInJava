package com.weiyu.offer.java8.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hello {
    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "[" + i + " ," + j + "]";
        }
    }

    private List<Pair> merge(List<Pair> pairs) {
        List<Pair> answer = new ArrayList<>();
        Pair merge = pairs.get(0);
        int start = merge.i;
        int end = merge.j;
        for (Pair it : pairs) {
            if (it.i > end + 1) {
                answer.add(new Pair(start, end));
                start = it.i;
                end = it.j;
            } else {
                end = Math.max(end, it.j);
            }
        }
        answer.add(new Pair(start, end));
        return answer;
    }

    private List<Pair> findSuitableWord(String s, String f) {
        List<Pair> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        char[] fs = f.toCharArray();
        int j = -1;
        for (int k = 0; k < cs.length; ++k) {
            int l = 0;
            while (l < fs.length && k < cs.length && cs[k] == fs[l]) {
                k++;
                l++;
            }
            j = k - 1;
            if (l == fs.length) {
                ans.add(new Pair(j - fs.length + 1, j));
            }
            k -= l;
        }
        return ans;
    }

    public String solution(String s, String[] dict) {
        List<Pair> inters = new ArrayList<>();
        for (int i = 0; i < dict.length; ++i) {
            List<Pair> it = findSuitableWord(s, dict[i]);
            if (!it.isEmpty()) {
                inters.addAll(it);
            }
        }
        if (inters.isEmpty()) return s;
        Collections.sort(inters, (a, b) -> (a.i != b.i ? a.i - b.i : a.j - b.j));
        List<Pair> mergedPair = merge(inters);
        StringBuilder sb = new StringBuilder();
        int lst = 0;
        for (Pair it : mergedPair) {
            int i = it.i;
            int j = it.j;
            sb.append(s.substring(lst, i));
            sb.append("<b>");
            sb.append(s.substring(i, j + 1));
            sb.append("</b>");
            lst = j + 1;
        }
        sb.append(s.substring(lst, s.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = new Hello().solution("aaabbcc", new String[]{"aaa", "aab", "bc"});
        System.out.println(result);
    }
}