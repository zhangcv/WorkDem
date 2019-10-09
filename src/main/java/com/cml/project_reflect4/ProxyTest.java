package com.cml.project_reflect4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Creacted by jack on 2019/10/23 10:51
 **/
interface Human {
    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can Fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我吃了"+food);
    }
}

class HumanUtil{
    public void methodBefore(){
        System.out.println("通用方法之前============");
    }
    public void methodAfter(){
        System.out.println("通用方法之后============");
    }
}
/**
 * 要想动态代理，需要解决的问题？
 * 问题一： 如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a
 */

class ProxyFatory{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();

        handler.bind(obj);
        //obj:被代理类的对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//赋值时使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj=obj;
    }
    //当我们通过代理类的对象， 调用方法a时，就会自动的调用如下的方法：invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.methodBefore();
        //method : 代理类对象调用的方法，,此方法就作为了被代理类对象要调用的方法
        //obj： 被代理类的对象
        Object returnValue = method.invoke(obj, args);
        util.methodAfter();
        //方法的返回值作为invoke方法的返回值
        return returnValue;
    }
}
public class ProxyTest{
    public static void main(String[] args){
        SuperMan superMan= new SuperMan();
        //proxyInstance代理类的对象
        Human proxyInstance = (Human) ProxyFatory.getProxyInstance(superMan);
        //当通过代理类对象的调用方法时，会自动的调用被代理类中同名的方法
        String res = proxyInstance.getBelief();
        System.out.println(res);
        proxyInstance.eat("糖醋里脊");
        System.out.println("**********************");
        //只要提供被代理类
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory ProxyClothFatory = (ClothFactory) ProxyFatory.getProxyInstance(nikeClothFactory);

        ProxyClothFatory.produceCloth();
    }
/**
 * 通用方法之前============
 * 通用方法之后============
 * I believe I can Fly
 * 通用方法之前============
 * 我吃了糖醋里脊
 * 通用方法之后============
 * **********************
 * 通用方法之前============
 * Nike工厂生出一批衣服
 * 通用方法之后============
 */
}