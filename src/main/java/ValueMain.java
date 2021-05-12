import entity.Address;

public class ValueMain {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;

        System.out.println("a == b :  " + (a==b));

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println("address1 == address2 : " + (address1==address2));
        System.out.println("address1 equals address2 : " + (address1.equals(address2))); //equals 재정의 전 -> false, equals 재정의 후 -> true
        //equals는 기본이 ==비교로 되어있기 때문에 재정의 전에 false가 나온 것
    }
}
