## Partitions API

#### What does it offer?
- Splits a list of Integers into a list of N-Lists of Integers whose length are determined by a given size.
- Can be used by old and new Java Projects: 
    - If your project is running on an old Java Version (1.3+), you may use the **partitions-api-old** function.
    - If your project is running on a newer Java Version (1.8+), you may use the **partitions-api-new** function.
 
#### How may I use it? 
- To create the jars simply run _mvn install_ on the desired module. The Parent module will build both jars.
- Add the jar to your classPath and simply call it like any other external lib!

#### Usage examples
- Java 1.3+ compatible version
```java 
int[] originalPartition = new int[]{1,2,3,4};
int[][] splitParition = Partitions.getSplitPartition(originalPartition, 2);
// splitPartition = [[1,2],[3,4]]
```
-  Java 1.8+ compatible version
```java 
List<Integer> originalPartition = new ArrayList<>(){Arrays.asList(1,2,3,4)};
List<List<Intger> splitParition = Partitions.getSplitPartition(originalPartition, 2);
// splitPartition = [[1,2],[3,4]]
```