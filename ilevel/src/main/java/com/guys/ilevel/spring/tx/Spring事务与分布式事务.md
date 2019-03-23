事务的介绍：
    事务是逻辑上的一组操作，要么都执行，要么都不执行.
    事物的特性（ACID）：
        **原子性**： 事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用；
        **一致性**： 执行事务前后，数据保持一致；
        **隔离性**： 并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的；
        **持久性**: 一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响。

分布式事务：
    CAP理论：WEB服务无法同时满足一下3个属性
        一致性(Consistency) ： 客户端知道一系列的操作都会同时发生(生效)
        可用性(Availability) ： 每个操作都必须以可预期的响应结束
        分区容错性(Partition tolerance) ： 即使出现单个组件无法可用,操作依然可以完成
    BASE理论：
        Basically Available（基本可用）
        Soft state（软状态）
        Eventually consistent（最终一致性）
            BASE理论是对CAP中的一致性和可用性进行一个权衡的结果，理论的核心思想就是：**我们无法做到强一致，
       但每个应用都可以根据自身的业务特点，采用适当的方式来使系统达到最终一致性（Eventual consistency）**
    数据库支持的2PC，又叫做 XA Transactions：
         XA 是一个两阶段提交协议，该协议分为以下两个阶段：
         第一阶段：事务协调器要求每个涉及到事务的数据库预提交(precommit)此操作，并反映是否可以提交.
         第二阶段：事务协调器要求每个数据库提交数据。
    分布式事务解决方案：
        一、两阶段提交（2PC）
            优点： 尽量保证了数据的强一致，适合对数据强一致要求很高的关键领域。（其实也不能100%保证强一致）
            缺点： 实现复杂，牺牲了可用性，对性能影响较大，不适合高并发高性能场景，如果分布式系统跨接口调用，目前 .NET 界还没有实现方案。
        二、补偿事务（TCC）
            TCC 其实就是采用的补偿机制，其核心思想是：针对每个操作，都要注册一个与其对应的确认和补偿（撤销）操作。它分为三个阶段：
                1、Try 阶段主要是对业务系统做检测及资源预留
                2、Confirm 阶段主要是对业务系统做确认提交，Try阶段执行成功并开始执行Confirm阶段时，
            默认 Confirm阶段是不会出错的。即：只要Try成功，Confirm一定成功。
                3、Cancel 阶段主要是在业务执行错误，需要回滚的状态下执行的业务取消，预留资源释放。
            举个例子，假入 Bob 要向 Smith 转账，思路大概是：
            我们有一个本地方法，里面依次调用
                1、首先在 Try 阶段，要先调用远程接口把 Smith 和 Bob 的钱给冻结起来。
                2、在 Confirm 阶段，执行远程调用的转账的操作，转账成功进行解冻。
                3、如果第2步执行成功，那么转账成功，如果第二步执行失败，则调用远程冻结接口对应的解冻方法 (Cancel)。
            优点： 跟2PC比起来，实现以及流程相对简单了一些，但数据的一致性比2PC也要差一些
            缺点： 缺点还是比较明显的，在2,3步中都有可能失败。TCC属于应用层的一种补偿方式，
            所以需要程序员在实现的时候多写很多补偿的代码，在一些场景中，一些业务流程可能用TCC不太好定义及处理。
        **未完待续**
        
Spring的事务级别(定义了一个事务可能受其他并发事务影响的程度)：
    1、**TransactionDefinition.ISOLATION_DEFAULT**: 使用后端数据库默认的隔离级别，
    Mysql 默认采用的 REPEATABLE_READ隔离级别 Oracle 默认采用的 READ_COMMITTED隔离级别
    2、**TransactionDefinition.ISOLATION_READ_UNCOMMITTED**： 最低的隔离级别，
    允许读取尚未提交的数据变更，**可能会导致脏读、幻读或不可重复读**
    3、**TransactionDefinition.ISOLATION_READ_COMMITTED**: 允许读取并发事务已经提交的数据，
    **可以阻止脏读，但是幻读或不可重复读仍有可能发生**
    4、**TransactionDefinition.ISOLATION_REPEATABLE_READ**: 对同一字段的多次读取结果都是一致的，
    除非数据是被本身事务自己所修改，**可以阻止脏读和不可重复读，但幻读仍有可能发生**。
    5、**TransactionDefinition.ISOLATION_SERIALIZABLE**: 最高的隔离级别，完全服从ACID的隔离级别。
    所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，**该级别可以防止脏读、不可重复读以及幻读**。
    但是这将严重影响程序的性能。通常情况下也不会用到该级别。

Spring事务的传播行为（为了解决业务层方法之间互相调用的事务问题）：
    支持当前事务的情况：
    **TransactionDefinition.PROPAGATION_REQUIRED**： 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
    **TransactionDefinition.PROPAGATION_SUPPORTS**： 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    **TransactionDefinition.PROPAGATION_MANDATORY**： 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。（mandatory：强制性）
    不支持当前事务的情况：
    **TransactionDefinition.PROPAGATION_REQUIRES_NEW**： 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
    **TransactionDefinition.PROPAGATION_NOT_SUPPORTED**： 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
    **TransactionDefinition.PROPAGATION_NEVER**： 以非事务方式运行，如果当前存在事务，则抛出异常。
    其他情况：
    **TransactionDefinition.PROPAGATION_NESTED**： 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
