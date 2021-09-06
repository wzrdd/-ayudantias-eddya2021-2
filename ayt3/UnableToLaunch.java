// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> st = new ArrayDeque<>();
        Queue<Integer> san = new ArrayDeque<>();

        for(int i = 0; i < students.length; i++){
            st.add(students[i]);
            san.add(sandwiches[i]);
        }

        int rechazados = 0;
        while(!st.isEmpty() && !san.isEmpty() && rechazados != san.size()){
            if(st.element() == san.element()){
                st.remove();
                san.remove();
                rechazados = 0;
            } else{
                rechazados++;
                st.add(st.remove());
            }
        }

        return rechazados;
    }
}
