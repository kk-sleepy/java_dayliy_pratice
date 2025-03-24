# 1、数据结构——Java

## 1.1 哈希表

```java
//初始化哈希表,前面是key的类型，后面是value的类型
Map<Object,Object> map = new HashMap<>();
//双向链表形式的哈希表
Map<Object,Object> mapLinked = new LinkedHashMap<>();

//返回默认值,如果存在返回value，否则返回默认值
map.getOrDefault(key,默认值);

//computeIfAbsent,用于判断该哈希表中是否有该key，如果有则执行add加入value，否则加入newValue
map.computeIfAbsent(key,k->newValue).add(value);

//put，向哈希表中加入key，value
map.put(key,value);
    
//get，获得对应key的value
map.get(key);

//remove,删除
map.remove(key);

//size,计算map中有多少元素
map.size();

//keySet(),获取map中的所有key
map.keySet();

//values(),获取map中的所有值
map.values();

//merge(),合并map中相同key的value，合并规则自定义
map.merge(key,value,Integer::sum);

//entry,作为map迭代用的。
for(Map.Entry<Integer, Integer> entry : cnt.entrySet()){
    int data = entry.getKey(), count = entry.getValue();
}
```

## 1.2 栈

```java
// 初始化
Stack<Object> st = new Stack<>();

//查看栈顶元素
st.peak();

//弹出栈顶元素
st.pop();

//入栈
st.push();

//判断栈是否为空
st.empty() ;
```

## 1.3 String

```java
//初始化String数组，普通string直接初始化就可以
String[] s = new String[n];

//查找索引为i的元素
s.charAt(i);

//判断字符串s，是否是以word为前缀
s.startsWith(word);

//测试此字符串是否以此后缀为结束
s.endsWith(word);

//.concat()，可以用来拼接两个字符串，也可以直接用 + 
s.concat(str2);

//用于将字符串中所有 old 值转换为 new 值。
str2.replace(old,new);

//返回一个新字符串，范围为原串的[0,n)
str2.substring(0,n)
```

## 1.4  Stream流

```java
//filter里为函数式当结果为true时执行后续方法，这里执行的是count
Arrays.stream(words).filter(s::startsWith).count();
```

## 1.5 优先队列（堆）

```java
//非普通类型的优先队列定义，后面参数为重新定义的比较器
PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
    public int compare(int[] m,int[] n){
        return m[1] - n[1];
    }
}
);

//peek，用于获取堆顶元素
queue.peek();

//poll,用于弹出堆顶元素，返回堆顶元素的值，与remove类似
queue.poll();

//offer,向堆中加入新元素，与add相似
queue.offer(obj);
```



# 2、算法

## 2.1 前缀和

```python
#一维
def psum_1d(l: list) -> list:
    n = len(l)
    psum = [l[0]]
    for i in range(1,n):
        psum.append(psum[-1] + l[i])
    return psum

#二维
def psum_2d(l: list) -> list:
    n = len(l)
    m = len(l[0])
    psum = [[0]*n for _ in range(m)]
    for i in range(0, n):
        for j in range(0, m):
            psum[i][j] = l[i][j]
            if i > 0:
                psum[i][j] += psum[i - 1][j]
            if j > 0:
                psum[i][j] += psum[i][j - 1]
            if i > 0 and j > 0:
                psum[i][j] -= psum[i-1][j-1]
    return psum
```

## 2.2 差分

写法与前缀和类似，反着写就行。

## 2.3 离散化

需要引入二分查找库bisect，其中bisect_left返回大于等于x的第一个下标，bisect_right和bisect一样返回大于x的第一个下标。

```python
def discrete(li: list) -> list:
    tmp = sorted(li)
    dsl = []
    for x in li:
        dsl.append(bisect.bisect_left(tmp, x))
    return dsl
```

## 2.4 二分查找

```python
def bin_search_right(li: list, x: int) -> list:
    l = 0
    r = len(li) - 1
    while l + 1 != r:
        mid = (l + r) // 2
        if li[mid] <= x:
            l = mid
        else:
            r = mid
    return l

def bin_search_left(li: list, x: int) -> list:
    l = 0
    r = len(li) - 1
    while l + 1 != r:
        mid = (l + r) // 2
        if li[mid] >= x:
            r = mid
        else:
            l = mid
    return r
```

## 2.5 素数筛

```python
def getPrimes(n: int) -> list:
    prime = []
    is_prime = [False] * (n + 1)
    for i in range(2, n + 1):
        if not is_prime[i]:
            prime.append(i)
        j = 0
        while prime[j] * i <= n:
            is_prime[prime[j]*i] = True
            if i % prime[j] == 0:
                break
            j += 1
    return prime
```

## 2.6 辗转相除法（求最大公约数）

```python
def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return a
```

## 2.7 并查集

```python
def find(x: int, s: list) -> int:
    if x != s[x]:
        s[x] = find(s[x],s)
    return s[x]
```

使用例子

```python
def find(x: int, s: list) -> int:
    if x != s[x]:
        s[x] = find(s[x], s)
    return s[x]

if __name__ == '__main__':
    n, m = map(int, rd().split())
    s = [i for i in range(n + 1)]
    for i in range(m):
        x, y = map(int, rd().split())
        s[find(x, s)] = find(y, s)
    p = int(rd())
    for i in range(p):
        x, y = map(int, rd().split())
        if find(x, s) == find(y, s):
            print('Yes')
        else:
            print('No')
```

## 2.8 dijistra(求最短路径)

```python
import heapq
import collections
from math import inf
def dij(n: int, edges: list[list[int]]) -> list[int]:
    # 根据edges构建邻接表g，并且记录路径长度l
    g = collections.defaultdict(list)
    for u, v, l in edges:
        g[u].append((v, l))
        g[v].append((u, l))
    # 假设源点为0点
    # dij的前期准备，dis表示0到其它点的距离，0点先进入堆q，并构造集合vis表示已经找到距离0的最短路的点集合
    q = [(0, 0)]
    vis = set()
    dis = [inf] * n
    dis[0] = 0
    # dij最短路模板
    while q:
        # 每次取出距离0点最近的点u, 将u加入集合vis
        d, u = heapq.heappop(q)
        # 剪枝：如果某次d大于之前的0到u的距离，那么点u一定已经被遍历过了
        if d > dis[u]:
            continue
        vis.add(u)
        # 更新剩余节点到0的距离, 因为新加入了u, 所以发生变化的距离只有u的邻接点v
        for v, duv in g[u]:
            # 如果存在某个点到0的距离通过u变小了，就将它加入堆中
            if (v not in vis) and dis[u] + duv < dis[v]:
                dis[v] = dis[u] + duv
                heapq.heappush(q, (dis[v], v))
    return dis
```

## 2.9 Floyd[任意两点间的最短路径]

```python
class Solution:
    def floyd(self, n: int, w: List[List[int]]) -> List[int]:
        dp = [w[i].copy() for i in range(n)]
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
        return dp
```

## 2.10 N皇后问题

投机取巧打表法

```python
def totalNQueens(self, n: int) -> int:
    Dfind = [0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200]
    return Dfind[n]
```

基于集合的回溯法，设置3个集合，分别为列、对角线1，对角线2；其对角线1拥有：行-列差值相等的特点；对角线2具有行+列值相等的特点。

```python
class Solution:
    def totalNQueens(self, n: int) -> int:
        def backtrack(row: int) -> int:
            if row == n:
                return 1
            else:
                count = 0
                for i in range(n):
                    if i in col or row - i in diag1 or row + i in diag2:
                        continue
                    col.add(i)
                    diag1.add(row - i)
                    diag2.add(row + i)
                    count += backtrack(row + 1)
                    col.remove(i)
                    diag1.remove(row - i)
                    diag2.remove(row + i)
                return count

        col = set()
        diag1 = set()
        diag2 = set()
        return backtrack(0)
```

## 2.11 回文串判断

```python
#.isalnum()用于判断是否为字母或数字
#ss[::-1] == ss用于判断是否为回文串
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        ss = (''.join([char for char in s if char.isalnum()]))
        return ss[::-1] == ss
```

## 2.12 位运算求子集

```python
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        for mask in range(1 << n):
            t = []
            flag = True
            for i in range(n):
                if mask & (1 << i):
                    if i > 0 and not (mask & (1 << (i - 1))) and nums[i] == nums[i - 1]:
                        flag = False
                        break
                    t.append(nums[i])
            if flag:
                ans.append(t)
        return ans
```

## 2.13 快速排序

```python
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort(left) + middle + quick_sort(right)
```

## 2.14 KMP算法

```python
def get_next(b: str) -> list:
    n = len(b)
    nx = [0] * n
    j = 0
    for i in range(1, n):
        while j > 0 and b[i] != b[j]:
            j = nx[j - 1]
        if b[i] == b[j]:
            j += 1
        nx[i] = j
    return nx

def kmp(a: str, b: str) -> int:
    ans = 0
    nx = get_next(b)
    m, n = len(a), len(b)
    j = 0
    for i in range(m):
        while j > 0 and a[i] != b[j]:
            j = nx[j - 1]
        if a[i] == b[j]:
            j += 1
        if j == n:
            ans = i - j + 1
            break
    return ans
```

## 2.15 滑动窗口求至少类问题

```python
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mx = max(nums)
        ans = 0
        l = 0
        res = 0
        for r,x in enumerate(nums):
            if mx==x:
                res += 1
            while res>=k:
                if nums[l]==mx:
                    res -= 1
                l += 1
            ans += l
        return ans
```

## 2.16 矩阵旋转——不消耗额外的空间

- 如果是顺时针旋转，则先对矩阵进行转置，再将转置后的矩阵沿中心对称轴交换列
- 如果是逆时针旋转，则先对矩阵进行转置，再将转置后的矩阵沿中心对称轴交换行

```java
public void rotate(int[][] matrix){
        //先对矩阵进行转置
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再对矩阵按照中心对称的列进行转换
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
```

## 2.17 环形链表找环的入口

```java
public int findDuplicate(int[] nums){
        int slow = 0,fast=0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
```

## 2.18  单调队列

单调队列适用于解决像滑动窗口最大值这样对问题

```java
public int[] maxSlidingWindow(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&nums[i]>=nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            // 2. 出
            if (i - dq.getFirst() >= k) { // 队首已经离开窗口了
                dq.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
     }
```

## 2.19 trie树

```java
class Node{
    Node[] son = new Node[26];
    boolean end;
}

class Trie {
    private Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = this.root;
        for(char c : word.toCharArray()){
            c -= 'a';
            if(cur.son[c]==null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) > 0;
    }
    private int find(String words){
        Node cur = this.root;
        for(char c : words.toCharArray()){
            c -= 'a';
            if(cur.son[c]!=null){
                cur = cur.son[c];
            }else
                return 0;
        }
        if(cur.end)
            return 2;
        else
            return 1;
    }
}
```

