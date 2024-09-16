

# 1、前缀和

前缀和用于表示集合覆盖区间，当一个区间被集合覆盖n次时，则该区间处理后的值为n。常用处理是，该区间的开始点+1，结束位置+1处-1.

```java
//前后处理的过程
for (List<Integer> interval : nums) {
    diff[interval.get(0)]++;
    diff[interval.get(0)]++;
}
//前缀和相加处理
for (int i=1;i<diff.length;i++) {
    diff[i] += diff[i-1];
}
```

