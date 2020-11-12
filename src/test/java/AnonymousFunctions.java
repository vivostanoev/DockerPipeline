import org.junit.Test;

public class AnonymousFunctions {

    public interface MyComparator {
        public boolean compare(int a1, int a2);
    }

    @Test
    public void testCompare() {

        MyComparator myComparator = (int a1, int a2) -> {
            return a1 > a2;
        };
        boolean result = myComparator.compare(2, 5);
        System.out.println(result);
    }
}