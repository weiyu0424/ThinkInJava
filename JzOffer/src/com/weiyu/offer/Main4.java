package com.weiyu.offer;
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        System.out.println(solution(txt));
    }

    public static String solution(String txt) {
        if(txt == null || txt.length() == 0){
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        int curVal = 0;
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            char curChar = txt.charAt(i);
            switch (curChar) {
                case '.':
                    flag = true;
                    curVal = (curVal << 1) + 1;
                    break;
                case '-':
                    flag = true;
                    curVal = curVal << 1;
                    break;
                case '#':
                    if(flag == true) {
                        char tmp = getCharacter(curVal);
                        if (tmp != ' ') {
                            sb.append(tmp);
                        }
                        curVal = 0;
                    }
                    flag = false;
                    break;
                default:
                    return "ERROR";
            }
            if (curVal > 51 || curVal < 0) {
                return "ERROR";
            }
        }

        if(flag == true) {
            char tmp = getCharacter(curVal);
            if (tmp != ' ') {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }

    public static char getCharacter(int val) {
        char c = ' ';
        switch (val) {
            case 0:
                c = 'F';
                break;
            case 1:
                c = 'G';
                break;
            case 2:
                c = 'R';
                break;
            case 3:
                c = 'S';
                break;
            case 4:
                c = 'T';
                break;
            case 5:
                c = 'L';
                break;
            case 6:
                c = 'M';
                break;
            case 7:
                c = 'N';
                break;
            case 8:
                c = 'O';
                break;
            case 9:
                c = 'P';
                break;
            case 10:
                c = 'Q';
                break;
            case 11:
                c = 'W';
                break;
            case 12:
                c = 'X';
                break;
            case 13:
                c = 'Y';
                break;
            case 14:
                c = 'Z';
                break;
            case 15:
                c = 'U';
                break;
            case 16:
                c = 'A';
                break;
            case 17:
                c = 'G';
                break;
            case 18:
                c = 'H';
                break;
            case 19:
                c = 'I';
                break;
            case 20:
                c = 'J';
                break;
            case 21:
                c = 'K';
                break;
            case 22:
                c = 'B';
                break;
            case 23:
                c = 'C';
                break;
            case 24:
                c = 'D';
                break;
            case 25:
                c = 'E';
                break;
            case 26:
                c = 'l';
                break;
            case 27:
                c = 'm';
                break;
            case 28:
                c = 'n';
                break;
            case 29:
                c = 'o';
                break;
            case 30:
                c = 'p';
                break;
            case 31:
                c = 'i';
                break;
            case 32:
                c = 'j';
                break;
            case 33:
                c = 'k';
                break;
            case 34:
                c = 'f';
                break;
            case 35:
                c = 'g';
                break;
            case 36:
                c = 'h';
                break;
            case 37:
                c = 'a';
                break;
            case 38:
                c = 'b';
                break;
            case 39:
                c = 'c';
                break;
            case 40:
                c = 'd';
                break;
            case 41:
                c = 'e';
                break;
            case 42:
                c = 'q';
                break;
            case 43:
                c = 'r';
                break;
            case 44:
                c = 'w';
                break;
            case 45:
                c = 'x';
                break;
            case 46:
                c = 'y';
                break;
            case 47:
                c = 'z';
                break;
            case 48:
                c = 's';
                break;
            case 49:
                c = 't';
                break;
            case 50:
                c = 'u';
                break;
            case 51:
                c = 'v';
                break;
            default:
                break;
        }
        return c;
    }
}