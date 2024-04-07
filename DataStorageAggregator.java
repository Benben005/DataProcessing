import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorageAggregator {

    private Map<String, List<Integer>> dataStorage;

    public DataStorageAggregator() {
        dataStorage = new HashMap<>();
    }

    public void addData(String key, int value) {
        if (dataStorage.containsKey(key)) {
            List<Integer> dataList = dataStorage.get(key);
            dataList.add(value);
        } else {
            List<Integer> dataList = new ArrayList<>();
            dataList.add(value);
            dataStorage.put(key, dataList);
        }
    }

    public int calculateSum(String key) {
        if (dataStorage.containsKey(key)) {
            List<Integer> dataList = dataStorage.get(key);
            int sum = 0;
            for (int value : dataList) {
                sum += value;
            }
            return sum;
        } else {
            return 0; // 没有找到指定的键
        }
    }

    public static void main(String[] args) {
        DataStorageAggregator aggregator = new DataStorageAggregator();

        // 添加数据
        aggregator.addData("A", 5);
        aggregator.addData("B", 10);
        aggregator.addData("A", 3);

        // 计算求和
        int sumA = aggregator.calculateSum("A");
        int sumB = aggregator.calculateSum("B");
        int sumC = aggregator.calculateSum("C");

        System.out.println("Sum of A: " + sumA);
        System.out.println("Sum of B: " + sumB);
        System.out.println("Sum of C: " + sumC);
    }
}
