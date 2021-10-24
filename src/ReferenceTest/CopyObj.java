package ReferenceTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class CopyObj {

    public static void main(String[] args) {
        Temp2 temp2 = new Temp2();
        temp2.x = 1;
        temp2.y = 2;


        Temp temp1 = new Temp();

        temp1 = temp2;

        System.out.println(temp1.x);
        System.out.println(temp1.y);

        if(temp1 instanceof Temp){
            System.out.println("temp");
        } else if(temp1 instanceof Temp2) {
            System.out.println("temp2");
        }
    }
}

class Temp2 extends Temp {
    int z = 1;
}

class Temp {
    int x;
    int y;
}
