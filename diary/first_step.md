###2016年06月03日16:03:41

####展望
根据[滴滴比赛规则](http://research.xiaojukeji.com/competition/detail.action?competitionId=DiTech2016), 给定的训练数据一共21``天``, 每天144个``时间片``, 每个时间片64个``地区``中所有的订单数据, 以及每个时间片所对应的``天气``, ``温度``, ``PM2.5``, 以及每个区域所对应的``基础建设``, 对应某个时间片的``道路拥堵信息``.

___问题定义___:

```
乘客打开滴滴出行app，输入出发地和目的地并点击“呼叫”后就完成一次发单(request)，有司机接单后就完成一次应答(answer)。
将一个城市划分为n个互不重叠的正方形区域D={d1,d2,⋯,dn }，将每一天的24小时划分为144个10分钟长的时间片t1,t2,⋯,t144。
对于区域di，在时间片tj，有rij个乘客发单，有aij个司机成功应答了aij次发单。
对于区域di，在时间片tj，定义需求demandij=rij，供给supplyij=aij，则有供需缺口gapij：gapij = rij - aij
给定每个区域在时间片tj,tj-1...的各项数据，预测gapi,j+1, ∀di∈D。
```

初步得到函数如下:

```
f(x) = gap
```

其中x包含如下:

```
A.出发地区
B.到达地区
C.时间
```

其中``A.出发地区``又包括如下:

```
A.1 地区特征, "poi_class"
A.2 拥堵程度
```

同时, ``B.出发地区``又有:
```
B.1 地区特征, "poi_class"
B.2 拥堵程度
```

``C.时间``又包括如下:

```
C.1 天气
C.2 温度
C.3 PM2.5值
```
基于以上, 适合使用线性回归处理
目前大致归纳需要步骤如下:
将每一条订单所相关的ABC信息收集在一起, 然后通过多样本回归去逼近真实函数f(x)


#### STEP1
将所有的原始数据入库, 分别建好索引

#### STEP2
通过job, 将5个表的数据join成一个宽表, 话句话说将每一个订单所对应的ABC数据拼凑在一起, 方便利用

#### STEP3
数学建模, 目前知道需要补充线性回归, 最小二乘法等知识
通过job, 将宽表所有数据跑完, 得出f(x)

#### STEP4
录入待预测时间的环境数据, 通过f(x), 计算所有需要预测时间片的gap, 上传第一版结果

#### TODO
```
回归在数学上来说是给定一个点集，能够用一条曲线去拟合之，如果这个曲线是一条直线，那就被称为线性回归，如果曲线是一条二次曲线，就被称为二次回归，回归还有很多的变种，如locally weighted回归，logistic回归

```
[回归与梯度下降](http://www.cnblogs.com/LeftNotEasy/archive/2010/12/05/mathmatic_in_machine_learning_1_regression_and_gradient_descent.html)

[什么是回归](http://www.cnblogs.com/jerrylead/archive/2011/03/05/1971867.html)

[机器学习专题](http://leftnoteasy.cnblogs.com/)


