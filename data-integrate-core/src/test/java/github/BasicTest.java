package github;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description
 * @author: jinwei.li@100credit.com
 * @date: 2018/10/30 16:27
 */
public class BasicTest {

    @Test
    public void testCalculate() {
        Map<Long, String> map = new HashMap<>();
        Random random = new Random();
        for (int j = 0; j < 10000000; j++) {
            StringBuilder ip = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                int tmp = random.nextInt(255);
                ip.append(String.valueOf(tmp));
                ip.append(".");
            }
            ip = ip.deleteCharAt(ip.length() - 1);
            String[] strs = ip.toString().split("\\.");
            Integer i1 = Integer.valueOf(strs[0]);
            Integer i2 = Integer.valueOf(strs[1]);
            Integer i3 = Integer.valueOf(strs[2]);
            Integer i4 = Integer.valueOf(strs[3]);
            long integer = (long) (i1 * Math.pow(256, 3) + i2 * Math.pow(256, 2) + i3 * 256 + i4);
            if (map.containsKey(integer) && !map.get(integer).contentEquals(ip))
                System.out.println(integer + "....." + ip + "---" + map.get(integer));
            map.put(integer, ip.toString());
        }
    }

    @Test
    public void testMath() {
        System.out.println((1* Math.pow(2, 32)));
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void testIP() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        System.out.println(ip);
        String[] strs = ip.split("\\.");
        Integer i1 = Integer.valueOf(strs[0]);
        Integer i2 = Integer.valueOf(strs[1]);
        Integer i3 = Integer.valueOf(strs[2]);
        Integer i4 = Integer.valueOf(strs[3]);
        long i = (long) (i1 * Math.pow(256, 3) + i2 * Math.pow(256, 2) + i3 * 256 + i4);
        System.out.println(i);
    }

    //byte 数组与 int 的相互转换
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

}
