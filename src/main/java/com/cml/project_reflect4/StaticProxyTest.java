package com.cml.project_reflect4;

/**
 * 静态代理
 * 特点： 代理类和被代理类在编译期间，就确定下来了
 * Creacted by jack on 2019/10/23 10:40
 **/

interface ClothFactory {
    void produceCloth();
}


//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//拿被代理类的对象实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做的准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做后续工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生出一批衣服");
    }

}

public class StaticProxyTest {
    public static void main(String[] args){
        //创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }

}


