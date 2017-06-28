package com.mijiaokj.sys.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/6/28.
 */
public class Test {
    public static Money getNext(Money money, double d){
        money.multiplyBy(d);
        return money;
    }

    public static Money getLiR(Money money, Integer d){
        money.multiplyBy(d);
        return money;
    }

    public static Money getAll(List<Money> moneys) {
        Money moneyAll = new Money();
        for (Money money : moneys) {
            moneyAll.addTo(money);
        }
        return moneyAll;
    }

    public static void main(String argas[]){
        //188 388 588 888
        //10 15 20 30
        //132.4 273.4 405.4 582.4
        int pe = 2;
        String mo = "388";
        String li = "273.4";
        double fz = 0.15;
        List<Money> listMoney = new ArrayList<Money>();
        for(int i= 0 ;i<pe ;i++){
            Money money1 = new Money(mo);
            listMoney.add(money1);
        }
        Money money = getAll(listMoney);
        System.out.println("发展"+pe+"人，为"+mo+"元的会员 总收取"+money.getAmount());
        System.out.println("发展提成比率为"+fz+"的会员"+pe+"人 共支出"+(pe-1)+"人费用共计："+getNext(money.subtractFrom(new Money(mo)), fz).getAmount());
        System.out.println("发展"+pe+"人总利润："+getLiR(new Money(li),pe));
    }
}
