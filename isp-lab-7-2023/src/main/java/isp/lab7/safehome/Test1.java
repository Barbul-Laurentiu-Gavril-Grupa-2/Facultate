package isp.lab7.safehome;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    private Map<String, String> validAccess;
    public static void main(String[] args) {
       HashMap validAccess = new HashMap<>();
       validAccess.put("ana","2");
       validAccess.put("marian","3");
        if (!validAccess.containsValue("3"))
            System.out.println("NUU");
    validAccess.remove("ana");
        if (!validAccess.containsValue("2"))
            System.out.println("NUU");
    }

}
