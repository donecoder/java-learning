package com.mindasoft._01_data_type;

import org.junit.Test;

/**
 *
 *  算数运算符(9)：+  -  *  /  %  ++  --
 *  关系运算符(6)：==  !=  >  >=  <  <=
 *  条件运算符(三目运算符): <表达式1> ? <表达式2> : <表达式3>
 *  逻辑运算符(6)：&&  ||  !  &  |  ^
 *  &和|运算是把逻辑表达式全部计算完，而&&和||运算具有短路计算功能。^相同则为false
 *
 *  位运算是以二进制位为单位进行的运算，其操作数和运算结果都是整型值。
 *  位运算符(7)：与（&）、或（|）、异或（^）、非（~）、>>（右移）、<<（左移）、>>>（0填充的右移）
 *  <<  :运算符，num << 1,相当于num乘以2
 *  >>  :右移运算符，num >> 1,相当于num除以2
 *  >>> :无符号右移，忽略符号位，空位都以0补齐
 *
 *  简捷运算符 += -= *= /= %= &= |= ^= <<= >>= >>>=
 *  对象运算符 instanceof
 * Created by huangmin on 2017/9/19 15:41.
 */
public class _02_Operators {

    @Test
    public void oper01(){

        int a =1;
        int b =10;
        int c =10;
        b = - a;
        c -= a;
        System.out.println(b );
        System.out.println(c );

        if(true^false){
            System.out.println("1111111111");
        }

    }

    /**
     * 与（&） 只有两个位都是1，结果才是1
     */
    @Test
    public void oper08(){
        int a=129;
        int b=128;
        System.out.println("a 和b 与的结果是："+(a&b));  //128
        /**
         * & 是二进制计算,根据"与"运算符的运算规律，只有两个位都是1，结果才是1
         * 129 二进制是 1000 0001
         * 128 二进制是 1000 0000
         *    &的结果是 1000 0000
         */

    }

    /**
     * 或（|） 两个位只要有一个为1，那么结果就是1，否则就为0
     */
    @Test
    public void oper09(){
        int a=129;
        int b=128;
        System.out.println("a 和b 或的结果是："+(a|b)); // 129
        /**
         * 129 二进制是 1000 0001
         * 128 二进制是 1000 0000
         *    |的结果是 1000 0001
         */
    }

    /**
     * 两个操作数的位中，相同则结果为0，不同则结果为1。
     */
    @Test
    public void oper10(){
        int a=15;
        int b=2;
        System.out.println("a 与 b 异或的结果是："+(a^b)); // ‭13‬
        /**
         *
         * 15 二进制是 0000 ‭1111‬
         * 2  二进制是 0000 0010
         *    ^ 结果是 0000 1101
         */
    }

    /**
     * 非（~） 如果位为0，结果是1，如果位为1，结果是0 ， 即取反
     * 1：最高位为0代表正数，最高位为1的代表负数
       2：已知一个数的补码，求原码的操作分两种情况：
       （1）如果补码的符号位为“0”，表示是一个正数，所以补码就是该数的原码。
       （2）如果补码的符号位为“1”，表示是一个负数，求原码的操作可以是：符号位为1，其余各位取反，然后再整个数加1。
     */
    @Test
    public void oper11(){
        int a=5;
        System.out.println("a 非的结果是："+(~a));  // -6
        /**
         *  5  二进制是 0000 0101
         *    ~的结果是 1111 1010
         *    此时仍为补码，是计算机系统的存储模式，我们需要的结果是需要将补码转化为原码，
         *    换算过程：按位取反1000 0101 再整个+1，故原码为
         *    1000 0110 = -6（最高位为负，二进制转化为十进制为6）
         */
    }

}
