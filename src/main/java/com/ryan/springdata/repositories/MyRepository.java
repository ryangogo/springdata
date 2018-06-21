package com.ryan.springdata.repositories;

/**
 * Created by Administrator on 2018/6/21.
 * <p/>
 * 自定义的Repository
 * 步骤：
 * 1：定义一个接口：声明要添加的，并自实现的方法（我在这里声明的是MyRepository接口）
 * 2：提供该接口的实现类：类名需在声明的Repository后添加Impl，并实现方法
 * （注意了！！！敲黑板！！！ 最开始我对上面的那句话的理解是方法名就是自定义Repository名称 + Impl，因此我将自定义的实现类写成了MyRepositoryImpl
 * 然后就报了 No property test found for type User 这个错，然后百度了一下发现原来是要写成UserDao5Impl，代码就可以跑了，希望看到这句话的同学们
 * 不要在踩这个坑）
 * 3：声明Repository接口，并且继承1）声明的接口
 * 4：使用
 * 5：默认情况下，Spring Data会在base-package中查找“接口名Impl”作为实现类，也可以通过
 * repository-impl-postfix 声明后缀（不知道怎么实现，不过应该问题不大）
 */
public interface MyRepository {

    void test();

}
