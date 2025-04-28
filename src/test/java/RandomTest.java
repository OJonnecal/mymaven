import com.jjou.domain.TestEntity;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2024-11-08 14:53
 * @Version 1.0
 */
public class RandomTest {

    @Test
    public void test() {

        ArrayList<TestEntity> doubles = new ArrayList<>();
        doubles.add(new TestEntity(1,1.0));
        doubles.add(new TestEntity(1,1.0));
        doubles.add(new TestEntity(2,2.0));
        doubles.add(new TestEntity(1,1.0));
        doubles.add(new TestEntity(2,2.0));
        doubles.add(new TestEntity(2,2.0));
        doubles.add(new TestEntity(3,3.0));
        for (int i = 0; i < doubles.size(); i++) {
            TestEntity testEntity = doubles.get(i);
            for (int j = 0; j < i; j++) {
                if(testEntity.getPrice() == doubles.get(j).getPrice()) {
                    doubles.get(j).setD(testEntity.getD() + doubles.get(j).getD());
                    doubles.remove(i);
                    System.out.println(doubles.size());
                    i--;
                }
            }
        }
        System.out.println(doubles);
    }
}
