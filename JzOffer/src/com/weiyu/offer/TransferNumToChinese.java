package com.weiyu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei Yu on 2017/9/5.
 */
public class TransferNumToChinese {
    public static void main(String[] args) {
        String convert = convertToChinese(100100);
        System.out.println(convert);
    }

    public static String convertToChinese(int num) {
        String[] map = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] volume = {"十", "百", "千"};
        String[] level = {"万", "亿", "兆"};
        int count = 0;
        int value = num;
        while (value != 0) {
            value /= 10000;
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int remain = num % 10000;
            int tag = 0;
            int redudance = remain % 10;
            remain /= 10;
            boolean flag = false;
            if (0 != redudance) {
                sb.append(map[redudance]);
            }else {
                flag = true;
            }


            while (remain != 0) {
                redudance = remain % 10;
                remain /= 10;
                if (0 != redudance) {
                    sb.append(volume[tag]);
                    sb.append(map[redudance]);
                    flag = false;
                }

                if(0 == redudance && !flag) {
                    sb.append(map[redudance]);
                    flag = true;
                }
                tag++;
            }
            if (i != count - 1)
                sb.append(level[i]);
            num /= 10000;
        }
        return sb.reverse().toString();
    }

    public static String convert(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "零");
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        map.put(4, "四");
        map.put(5, "五");
        map.put(6, "六");
        map.put(7, "七");
        map.put(8, "八");
        map.put(9, "九");

        Map<Integer, String> volume = new HashMap<>();
        volume.put(0, "十");
        volume.put(1, "百");
        volume.put(2, "千");
//        volume.put(3,"万");
//        volume.put(4,"亿");

        if (num < 10) {
            return map.get(num);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        int redudance = num % 10;
        if (0 != redudance) {
            sb.append(map.get(redudance));
        }
        num /= 10;
        while (num != 0) {
            redudance = num % 10;
            int root = (count + 1) / 4;
            int floor = (count + 1) % 4;
            String tag = volume.get(count % 4);
            if (0 == floor) {
                if (1 == root) {
                    tag = "万";
                } else if (2 == root) {
                    tag = "亿";
                } else if (3 == root) {
                    tag = "兆";
                }
            }

            if (0 == floor) {
                sb.append(tag);
                if (0 != redudance)
                    sb.append(map.get(redudance));
            } else {
                if (0 != redudance) {
                    sb.append(tag);
                }
                sb.append(map.get(redudance));
            }
            num /= 10;
            count++;
        }
        sb.reverse();
        return sb.toString();
    }
}
