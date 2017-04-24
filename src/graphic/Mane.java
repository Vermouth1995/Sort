package graphic;

public class Mane {

    public static void main(String[] args) {

        int num =200;
        Show sh = new Show(num, "冒泡排序");
        bubble_sort(sh);
        System.out.println(sh.getSortName() + ":" + sh.getTimes());
        System.out.println((sh.ok() ? " 排序成功" : " 排序错误"));
        sh.setVisible(false);

        sh = new Show(num, "鸡尾酒排序");
        cocktail_sort(sh);
        System.out.println(sh.getSortName() + ":" + sh.getTimes());
        System.out.println((sh.ok() ? " 排序成功" : " 排序错误"));
        sh.setVisible(false);

        sh = new Show(num, "插入排序");
        insert_sort(sh);
        System.out.println(sh.getSortName() + ":" + sh.getTimes());
        System.out.println((sh.ok() ? " 排序成功" : " 排序错误"));
        sh.setVisible(false);

        sh = new Show(num, "选择排序");
        select_sort(sh);
        System.out.println(sh.getSortName() + ":" + sh.getTimes());
        System.out.println((sh.ok() ? " 排序成功" : " 排序错误"));
        sh.setVisible(false);

        sh = new Show(num, "快速排序");
        quick_sort(sh);
        System.out.println(sh.getSortName() + ":" + sh.getTimes());
        System.out.println((sh.ok() ? " 排序成功" : " 排序错误"));
        sh.setVisible(false);
    }

    public static void bubble_sort(Show s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length()-i; j++) {
                if (s.get(j-1) > s.get(j)) {
                    int temp = s.get(j-1);
                    s.set(j-1,s.get(j));
                    s.set(j,temp);
                }
            }
        }
    }

    public static void cocktail_sort(Show s){
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (s.get(i) > s.get(i+1)) {
                    int temp1 = s.get(i);
                    s.set(i,s.get(i+1));
                    s.set(i+1,temp1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (s.get(i-1) > s.get(i)) {
                    int temp2 = s.get(i-1);
                    s.set(i-1,s.get(i));
                    s.set(i,temp2);
                }
            }
            left++;
        }
    }

    public static void insert_sort(Show s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j > 0; j--) {
                if (s.get(j-1) > s.get(j)) {
                    int temp = s.get(j-1);
                    s.set(j-1,s.get(j));
                    s.set(j,temp);
                }
            }
        }
    }

    public static void select_sort(Show s){
        for (int i = 0; i < s.length()-1; i++) {
            int min = i;
            for (int j = i+1; j < s.length(); j++) {
                if (s.get(j) < s.get(min)) {
                    min = j;
                }
            }
            int temp = s.get(min);
            s.set(min,s.get(i));
            s.set(i,temp);
        }
    }

    public static void quick_sort(Show s, int start, int end){
        int i = start;
        int j = end;
        int sentinel = start;

        while (i != j) {
            while (s.get(j) >= s.get(sentinel) && i < j) {
                j--;
            }
            while (s.get(i) <= s.get(sentinel) && i < j) {
                i++;
            }
            if (i < j) {
                int temp = s.get(i);
                s.set(i, s.get(j));
                s.set(j, temp);
            }
        }

        int temp = s.get(sentinel);
        s.set(sentinel, s.get(i));
        s.set(i, temp);

        quick_sort(s, start, i-1);
        quick_sort(s, i+1, end);
    }
}
