public class ArrayHendler {

    public int[] getArray(int[] originArray){
        for (int i = originArray.length - 1; i >= 0; i--){
            if (originArray[i] == 4){
                return resultArray(i+1, originArray);
            }
        }
        throw new RuntimeException();
    }

    private int[] resultArray(int pos, int[] array) {
        int[] resultArray = new int[array.length - pos];
        for (int i = pos, j = 0; i < array.length; i++, j++){
            resultArray[j] = array[i];
        }
        return resultArray;
    }


    public boolean checkArray(int[] array){
        boolean hasOne = false;
        boolean hasFour = false;
        for (int i : array){
            if( i == 1 ){
                hasOne = true;
            }else if( i == 4 ){
                hasFour = true;
            }else {
                return false;
            }
        }
        return hasFour && hasOne;
    }
}
