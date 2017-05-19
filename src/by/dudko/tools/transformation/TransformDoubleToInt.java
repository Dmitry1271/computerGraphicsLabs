package by.dudko.tools.transformation;

/**
 * Created by cplus on 17.05.2017.
 */
public class TransformDoubleToInt {
    public static int[] toIntMassNumbers(double[] array){
        int result[] = new int[array.length];
        for(int i=0; i<array.length;++i){
            result[i] = (int)array[i];
        }
        return result;
    }
}
