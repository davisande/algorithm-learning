package hackerrankchalenge;

public class NumberLineJumps {

    public static void main(String[] args) {
        String result = kangaroo(2, 1, 2, 1);
        System.out.println(result);

        result = kangaroo(0, 3, 4, 2);
        System.out.println(result);

        result = kangaroo(0, 2, 5, 3);
        System.out.println(result);

        result = kangaroo(14, 4, 98, 2);
        System.out.println(result);

        result = kangaroo(21, 6, 47, 3);
        System.out.println(result);
    }


    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if((x1 < x2 && v1 < v2) || (x2 < x1 && v2 < v1)) {
            return "NO";
        } else {
            boolean keepCheck = true;
            int firstEvolutionKangaroo1 = x1 + v1 ;
            int firstEvolutionKangaroo2 = x2 + v2;
            int jump = 1;
            String result = "NO";
            while(keepCheck) {
                boolean isKangaroo1StartedFurther = firstEvolutionKangaroo1 > firstEvolutionKangaroo2;
                boolean isKangaroo2StartedFurther = firstEvolutionKangaroo2 > firstEvolutionKangaroo1;

                int evolutionNextJumpKangaroo1 = x1 + v1 * jump;
                int evolutionNextJumpKangaroo2 = x2 + v2 * jump;

                if((isKangaroo1StartedFurther && evolutionNextJumpKangaroo2 > evolutionNextJumpKangaroo1) ||
                        (isKangaroo2StartedFurther && evolutionNextJumpKangaroo1 > evolutionNextJumpKangaroo2)) {
                    result = "NO";
                    keepCheck = false;
                } else if(evolutionNextJumpKangaroo1 == evolutionNextJumpKangaroo2) {
                    result = "YES";
                    keepCheck = false;
                }

                jump++;
            }

            return result;
        }
    }

}
