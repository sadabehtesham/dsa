class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> result = new ArrayList<>();

        int strow=0;
        int stcol=0;
        int endrow=matrix.length-1;
        int endcol=matrix[0].length-1;

        while(strow<=endrow && stcol<=endcol){
            //top
            for(int j=stcol;j<=endcol;j++){
                result.add(matrix[strow][j]);
            }
            //right
            for(int i=strow+1;i<=endrow;i++){
                result.add(matrix[i][endcol]);
            }
            //bottom
            if(strow<endrow){
                for (int j = endcol - 1; j >= stcol; j--) {
                    result.add(matrix[endrow][j]);
                }
            }
            //left
            if (stcol < endcol) {
                for (int i = endrow - 1; i > strow; i--) {
                    result.add(matrix[i][stcol]);
                }
            }
            stcol++;
            strow++;
            endcol--;
            endrow--;
        }
        return result; 
    }
}