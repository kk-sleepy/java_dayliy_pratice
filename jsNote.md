# 1、数据结构
***
## 1.1 优先队列

```js
//构造
let queue = PriorityQueue((a,b)=>{
    return a - b
})

//大根堆小根堆
const numbersQueue = new MinPriorityQueue();
//bid 为要排序数据
const bidsQueue = new MaxPriorityQueue((bid) => bid.value);

//出队
queue.dequeue()
queue.pop()

//入队
queue.push()
queue.enqueue()

//移除特定元素
numbersQueue.remove((n) => n === 4);

//将数组转换为堆
const pq = PriorityQueue.fromArray(numbers, (a, b) => a - b);
```