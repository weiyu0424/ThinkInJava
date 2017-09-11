package com.weiyu.offer.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Hello {
    class Interval {
        int i;
        int j;

        public Interval(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "[" + i + " ," + j + "]";
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List<Interval> inters = new ArrayList<>();
        for (int i = 0; i < dict.length; ++i) {
            List<Interval> it = findWord(s, dict[i]);
            if (!it.isEmpty()) {
                inters.addAll(it);
            }
        }
        if (inters.isEmpty()) return s;
        Collections.sort(inters, (a, b) -> (a.i != b.i ? a.i - b.i : a.j - b.j));
        List<Interval> mergedInterval = merge(inters);
        StringBuilder sb = new StringBuilder();
        int lst = 0;
        for (Interval it : mergedInterval) {
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

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        Interval merge = intervals.get(0);
        int start = merge.i;
        int end = merge.j;
        for (Interval it : intervals) {
            if (it.i > end + 1) {
                ans.add(new Interval(start, end));
                start = it.i;
                end = it.j;
            } else {
                end = Math.max(end, it.j);
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }

    private List<Interval> findWord(String s, String f) {
        List<Interval> ans = new ArrayList<>();
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
                ans.add(new Interval(j - fs.length + 1, j));
            }
            k -= l;
        }
        return ans;
    }
}