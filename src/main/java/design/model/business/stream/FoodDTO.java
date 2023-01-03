package design.model.business.stream;


import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 食物dto
 *
 * @author 玉启锐  Yuqirui  email: 1464025388@qq.com
 * creation time: 2023/01/02 14:01:50
 */
public class FoodDTO implements Serializable {
    private static final long serialVersionUID = 6494243409567559485L;
    /**
     * id
     */
    private String id;

    /**
     * 食物名字
     */
    private String foodName;

    /**
     * 食物量热
     */
    private Integer foodQuantityHeat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodQuantityHeat() {
        return foodQuantityHeat;
    }

    public void setFoodQuantityHeat(Integer foodQuantityHeat) {
        this.foodQuantityHeat = foodQuantityHeat;
    }

    public FoodDTO() {
    }

    public FoodDTO(String id, String foodName, Integer foodQuantityHeat) {
        this.id = id;
        this.foodName = foodName;
        this.foodQuantityHeat = foodQuantityHeat;
    }

    @Override
    public String toString() {
        return "FoodDTO{" +
                "id='" + id + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodQuantityHeat=" + foodQuantityHeat +
                '}';
    }

    public static String getHeat() {
        return getHeat();
    }

    /*
     * java 流式编程
     * */
    public static void main(String[] args) {
        List<FoodDTO> foodDTOS = Arrays.asList(
                new FoodDTO("1", "苹果", 200),
                new FoodDTO("2", "面条", 200),
                new FoodDTO("3", "米饭", 600),
                new FoodDTO("4", "披萨", 400)
        );

        /*
         * 流使用内部迭代
         * */
        List<String> foodName = foodDTOS.stream().map(FoodDTO::getFoodName)
                .collect(Collectors.toList());
        System.out.println("流使用内部迭代=== \n" + foodName); // [苹果, 香蕉, 米饭, 披萨]



        /*
         * 代码中的filter、map、limit是中间操作
         * */
        foodName = foodDTOS.stream()
                .filter(k -> k.getFoodQuantityHeat() <= 400) // 建立操作流水线：首选选出热量小于等于400的
                .map(foodDTO -> foodDTO.getFoodName()) // 获取食物名称
                .limit(2) // limit(1) 只选择头2个
                .collect(Collectors.toList()); // 将结果集保存在另一个List中

        System.out.println("代码中的filter、map、limit是中间操作=== \n" + foodName); // [苹果, 面条]

        List<FoodDTO> collect = foodDTOS.stream()
                /*
                 * sorted()升序排序
                 * Comparator.comparing() 根据哪个属性进行排序
                 * reversed() 对排好序的集合进行反向排序，升序变倒叙
                 * */
                .sorted(Comparator.comparing(FoodDTO::getFoodQuantityHeat).reversed())
                .collect(Collectors.toList());
        System.out.println("使用流对列表进行排序===");
        collect.stream().forEach(System.out::println);
        /*
         * FoodDTO{id='3', foodName='米饭', foodQuantityHeat=600}
         * FoodDTO{id='4', foodName='披萨', foodQuantityHeat=400}
         * FoodDTO{id='1', foodName='苹果', foodQuantityHeat=200}
         * FoodDTO{id='2', foodName='面条', foodQuantityHeat=200}
         * */


        /*
         * 终端操作，将数据输出到终端上
         * */
        System.out.println("终端操作，将数据输出到终端上===");
        foodDTOS.stream().forEach(System.out::println);
        /*
         * FoodDTO{id='1', foodName='苹果', foodQuantityHeat=200}
         * FoodDTO{id='2', foodName='面条', foodQuantityHeat=200}
         * FoodDTO{id='3', foodName='米饭', foodQuantityHeat=600}
         * FoodDTO{id='4', foodName='披萨', foodQuantityHeat=400}
         * */



        /*
         * 返回流中的元素个数，long类型
         * */
        System.out.println("返回流中的元素个数，long类型 \n" + foodDTOS.stream().count()); // 4



        /*
         *元素去重
         * */
        System.out.println("元素去重=== \n" + foodDTOS.stream().distinct().collect(Collectors.toList()));
        /*
         * [
         * FoodDTO{id='1', foodName='苹果', foodQuantityHeat=200},
         * FoodDTO{id='2', foodName='面条', foodQuantityHeat=200},
         * FoodDTO{id='3', foodName='米饭', foodQuantityHeat=600},
         * FoodDTO{id='4', foodName='披萨', foodQuantityHeat=400}
         * ]
         * */



        /*
         * 根据集合对象中对象的某个属性进行去重
         * 引用Collectors两个静态方法collectingAndThen()和toCollection(),以及TreeSet<>来去重
         * */
        ArrayList<FoodDTO> list = foodDTOS.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(
                                        Comparator.comparing(FoodDTO::getFoodQuantityHeat)
                                )
                        ), ArrayList::new
                )
        );
        System.out.println("根据集合对象中对象的某个属性进行去重 \n" + list);
        /*
         * [
         * FoodDTO{id='1', foodName='苹果', foodQuantityHeat=200},
         * FoodDTO{id='4', foodName='披萨', foodQuantityHeat=400},
         * FoodDTO{id='3', foodName='米饭', foodQuantityHeat=600}
         * ]
         * */



        /*
         * 筛选各异元素 ：
         * distinct()：它会返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流
         * */
        List<Integer> integerList = Arrays.asList(1, 1, 3, 2, 4, 5, 7, 8, 8);
        List<Integer> integerList1 = integerList.stream()
                .filter(x -> x % 2 == 0) //查找偶数元素
                .collect(Collectors.toList());
        System.out.println("查找偶数元素 \n" + integerList1); //[2, 4, 8, 8]

        List<Integer> integerList2 = integerList.stream()
                .filter(x -> x % 2 == 0) //查找偶数元素
                .distinct() //去重，保证元素唯一性
                .collect(Collectors.toList());
        System.out.println("查找偶数元素&去重 \n" + integerList2); // [2, 4, 8]



        /*
         * limit(n)：该方法会返回一个不超过给定长度的流
         * */
        List<Integer> integerList3 = Arrays.asList(1, 1, 3, 2, 4, 5, 7, 8, 8);
        List<Integer> collect3 = integerList3.stream().filter(x -> x > 3) //寻找大于3的元素
                .collect(Collectors.toList());
        System.out.println("寻找大于3的元素 \n" + collect3); // [4, 5, 7, 8, 8]

        List<Integer> integerList4 = Arrays.asList(1, 1, 3, 2, 4, 5, 7, 8, 8);
        List<Integer> collect4 = integerList4.stream().filter(x -> x > 3) //寻找大于3的元素
                .limit(3) //只返回前三个
                .collect(Collectors.toList());

        System.out.println("寻找大于3的元素&只返回前三个 \n" + collect4); // [4, 5, 7]



        /*
         * skip方法返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一个空流
         * 该方法可配合limit()进行分页
         * */
        List<Integer> integerList5 = Arrays.asList(1, 1, 3, 2, 4, 5, 7, 8, 8);
        List<Integer> collect5 = integerList5.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("skip(n)->舍弃集合的前n个元素 \n" + collect5); // [5, 7, 8, 8]

        List<Integer> integerList6 = Arrays.asList(1, 1, 3, 2, 4, 5, 7, 8, 8);
        List<Integer> collect6 = integerList6.stream()
                .skip(5)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("skip(n)->舍弃集合的前n个元素, limit(n)->返回舍弃之后的集合的前n个元素 \n" + collect6); // [5, 7]



        /*
         * 使用流进行查找跟匹配
         * */

        // anyMatch() 是否至少匹配一个元素
        List<Integer> integerList7 = Arrays.asList(2, 2);
        if (integerList7.stream().anyMatch(x -> x % 2 == 1)) {
            //anyMatch()：查找该集合中是否有1个奇数元素
            System.out.println("integerList7 至少有1个奇数元素");
        } else {
            System.out.println("integerList7 没有奇数元素");
        }

        // allMatch() 是否匹配所有元素
        List<Integer> integerList8 = Arrays.asList(2, 2);
        if (integerList8.stream().anyMatch(x -> x % 2 == 1)) {
            //anyMatch()：查找该集合中是否有1个奇数元素
            System.out.println("integerList8 都是奇数");
        } else {
            System.out.println("integerList8 都是偶数");
        }

        //findAny() 返回当前流中的任意元素: 只返回匹配到的第一个元素
        List<Integer> integerList9 = Arrays.asList(2, 1, 0, 4);
        Optional<Integer> collect9 = integerList9.stream()
                .filter(x -> x % 2 == 0)
                .findAny();
        System.out.println("findAny() 返回当前流中的任意元素 \n" + collect9); //Optional[2]

        // findFirst()查找第一个元素
        List<Integer> integerList10 = Arrays.asList(2, 1, 0, 4);
        Optional<Integer> collect10 = integerList10.stream()
                .filter(x -> x % 2 == 0)
                .findFirst();
        System.out.println("findFirst()查找第一个元素 \n" + collect10); //Optional[2]



        /*
         * 使用流进行求和
         * reduce(sum, (x, y) -> x + y);  k: 初始值
         * */
        List<Integer> integerList11 = Arrays.asList(2, -1, 0, 4);
        // 写法1
        Integer sum = integerList11.stream().reduce(0, Integer::sum);
        System.out.println("reduce(): 使用流进行求和 \n" + sum); // 5
        // 写法2
        Integer sum2 = integerList11.stream().reduce(0, (x, y) -> (x + y));
        System.out.println("reduce(): 使用流进行求和 \n" + sum2); // 5



        /*
         * 使用流求最值
         * */
        List<Integer> integerList12 = Arrays.asList(2, -1, 0, 4);

        Optional<Integer> maxNumbers = integerList12.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println("最大值maxNumbers ：" + maxNumbers); // Optional[4]
        Optional<Integer> minNumbers = integerList12.stream().reduce((x, y) -> x < y ? x : y);
        System.out.println("最小值minNumbers: " + minNumbers); // Optional[-1]

        List<FoodDTO> foods = Arrays.asList(
                new FoodDTO("1", "苹果", 100),
                new FoodDTO("2", "香蕉", 400),
                new FoodDTO("3", "葡萄", 700),
                new FoodDTO("4", "橘子", 200)
        );
        // 将FoodDTO的热量映射到整数流中，然后进行求和
        // 写法1
        int heatSum = foods.stream().mapToInt(x -> x.getFoodQuantityHeat()).sum();
        System.out.println("食物热量总和heatSum：" + heatSum); // 1400
        // 写法2
        int heatSum2 = foods.stream().mapToInt(FoodDTO::getFoodQuantityHeat).sum();
        System.out.println("食物热量总和heatSum2：" + heatSum2); // 1400


        /*
         * 使用流进行分组
         *
         *
         * */
        List<FoodDTO> foods2 = Arrays.asList(
                new FoodDTO("1", "苹果", 100),
                new FoodDTO("2", "香蕉", 400),
                new FoodDTO("3", "葡萄", 700),
                new FoodDTO("4", "橘子", 200),
                new FoodDTO("4", "米饭", 450)
        );
        Map<String, List<FoodDTO>> foods2Map = foods2.stream().collect(Collectors.groupingBy(FoodDTO::getFoodName));
        System.out.println("根据名字进行分组 \n" + foods2Map);
        /*
         * {
         * 葡萄=[FoodDTO{id='3', foodName='葡萄', foodQuantityHeat=700}],
         * 香蕉=[FoodDTO{id='2', foodName='香蕉', foodQuantityHeat=400}],
         * 苹果=[FoodDTO{id='1', foodName='苹果', foodQuantityHeat=100}],
         * 米饭=[FoodDTO{id='4', foodName='米饭', foodQuantityHeat=450}],
         * 橘子=[FoodDTO{id='4', foodName='橘子', foodQuantityHeat=200}]
         * }
         * */

        Map<String, List<Integer>> foods2Map2 = foods2.stream()
                .collect(
                        Collectors.groupingBy(
                                FoodDTO::getFoodName,  // 根据食物名称进行分组，事务名称作为k
                                Collectors.mapping(
                                        FoodDTO::getFoodQuantityHeat, // map中值收集食物热量
                                        Collectors.toList() //存到进行集合中
                                )
                        )
                );
        System.out.println("根据名字(key)进行分组，热量作为value" + foods2Map2); // {葡萄=[700], 香蕉=[400], 苹果=[100], 米饭=[450], 橘子=[200]}

        Map<String, List<FoodDTO>> foods2Map3 = foods2.stream()
                .collect(
                        Collectors.groupingBy(
                                FoodDTO::getFoodName, // 名字作为key
                                Collectors.mapping(
                                        Function.identity(), // 对象作为map的value
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println("根据名字进行分组，对象作为value \n" + foods2Map3);
        /*
         * {
         * 葡萄=[FoodDTO{id='3', foodName='葡萄', foodQuantityHeat=700}],
         * 香蕉=[FoodDTO{id='2', foodName='香蕉', foodQuantityHeat=400}],
         * 苹果=[FoodDTO{id='1', foodName='苹果', foodQuantityHeat=100}],
         * 米饭=[FoodDTO{id='4', foodName='米饭', foodQuantityHeat=450}],
         * 橘子=[FoodDTO{id='4', foodName='橘子', foodQuantityHeat=200}]
         * }
         * */

        Map<String, List<FoodDTO>> foods2Map4 = foods2.stream()
                .collect(
                        Collectors.groupingBy(
                                FoodDTO::getId,
                                Collectors.mapping(
                                        Function.identity(),
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println("根据ID进行分组，对象作为value" + foods2Map4);
        /*
         * {1=[FoodDTO{id='1', foodName='苹果', foodQuantityHeat=100}],
         * 2=[FoodDTO{id='2', foodName='香蕉', foodQuantityHeat=400}],
         * 3=[FoodDTO{id='3', foodName='葡萄', foodQuantityHeat=700}],
         * 4=[FoodDTO{id='4', foodName='橘子', foodQuantityHeat=200}, FoodDTO{id='4', foodName='米饭', foodQuantityHeat=450}]
         * }
         * */
        Map<String, Double> foodsMap5 = foods2.stream()
                .collect(
                        Collectors.groupingBy(
                                FoodDTO::getId,
                                Collectors.averagingDouble(
                                        FoodDTO::getFoodQuantityHeat
                                )
                        )
                );
        System.out.println("根据id进行分组，求平均热量(value) \n" + foodsMap5); // {1=100.0, 2=400.0, 3=700.0, 4=325.0}
    }
}
