package com.mijiaokj.sys.common.util;

/**
 * Created by wb-scg178938 on 2017/6/15.
 */

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CsNetUtil {
    static Log log = LogFactory.getLog(CsNetUtil.class);

    public CsNetUtil() {
    }

    public static int getThreadSleepByDataSize(int dataSize) {
        int threadSleepMillions = 1800;

        try {
            int dataSizeKB = dataSize / 1024;
            int dataSizeMB = dataSize / 1024 / 1024;
            if(dataSizeKB > 512 && dataSizeMB <= 0) {
                threadSleepMillions = 1950;
            }

            if(dataSizeMB > 0) {
                threadSleepMillions = 2250 + dataSizeMB * 250;
            }
        } catch (Exception var4) {
            ;
        }

        return threadSleepMillions;
    }

    public static String getLocalHostFirstNetWorkIP() {
        try {
            Enumeration en = NetworkInterface.getNetworkInterfaces();

            while(en.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)en.nextElement();
                Enumeration ads = ni.getInetAddresses();

                while(ads.hasMoreElements()) {
                    InetAddress ip = (InetAddress)ads.nextElement();
                    if(!ip.isLoopbackAddress() && ip.isSiteLocalAddress()) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (Exception var4) {
            log.error("获取主机地址失败", var4);
        }

        return null;
    }

    public static boolean isActivePort(int port) {
        Socket socket = null;

        boolean var3;
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            socket = new Socket(localAddress, port);
            return true;
        } catch (ConnectException var20) {
            var3 = false;
        } catch (IOException var21) {
            return true;
        } finally {
            if(null != socket && socket.isConnected()) {
                try {
                    socket.close();
                } catch (IOException var18) {
                    ;
                } catch (Exception var19) {
                    ;
                }
            }

        }

        return var3;
    }

    public static void main(String[] args) {
        System.out.println(getLocalHostFirstNetWorkIP());
    }
}
