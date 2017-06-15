package com.mijiaokj.sys.common.util;

/**
 * Created by wb-scg178938 on 2017/6/15.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CatIOUtil {
    static Log log = LogFactory.getLog(CatIOUtil.class);
    private static final String EMPTY_STRING = "";

    public CatIOUtil() {
    }

    public static void writeObjectToFile(String cacheFilePath, Object obj) throws IOException {
        File cacheFile = new File(cacheFilePath);
        if(cacheFile.exists()) {
            try {
                cacheFile.delete();
            } catch (Exception var16) {
                ;
            }
        } else {
            File fileParentFolder = cacheFile.getParentFile();
            if(!fileParentFolder.exists()) {
                fileParentFolder.mkdirs();
            }
        }

        try {
            cacheFile.createNewFile();
        } catch (Exception var15) {
            ;
        }

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(cacheFile));
            out.writeObject(obj);
            out.flush();
        } catch (IOException var14) {
            throw var14;
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException var13) {
                    ;
                }
            }

        }

        changeFileAuth(cacheFilePath);
    }

    public static Object readObjectFromFile(String cacheFilePath) throws Exception {
        File cacheFile = new File(cacheFilePath);
        Object obj = null;
        if(cacheFile != null && cacheFile.exists()) {
            try {
                byte[] getBytes = getBytesFromFile(cacheFile);
                return getObjectFromBytes(getBytes);
            } catch (Exception var4) {
                throw var4;
            }
        } else {
            return obj;
        }
    }

    public static byte[] getBytesFromFile(File file) {
        if(file == null) {
            return null;
        } else {
            FileInputStream stream = null;
            ByteArrayOutputStream out = null;

            try {
                stream = new FileInputStream(file);
                out = new ByteArrayOutputStream(1000);
                byte[] b = new byte[1000];

                int n;
                while((n = stream.read(b)) != -1) {
                    out.write(b, 0, n);
                }

                stream.close();
                out.close();
                byte[] var5 = out.toByteArray();
                return var5;
            } catch (IOException var19) {
                ;
            } finally {
                if(null != stream) {
                    try {
                        stream.close();
                    } catch (IOException var18) {
                        ;
                    }
                }

                if(null != out) {
                    try {
                        out.close();
                    } catch (IOException var17) {
                        ;
                    }
                }

            }

            return null;
        }
    }

    public static Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if(objBytes != null && objBytes.length != 0) {
            ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            Object var3;
            try {
                var3 = oi.readObject();
            } catch (Exception var7) {
                throw var7;
            } finally {
                bi.close();
                oi.close();
            }

            return var3;
        } else {
            return null;
        }
    }

    public static void writeStringToFile(String fileContent, String filePath, String charset) throws FileNotFoundException, IOException {
        File cacheFile = new File(filePath);
        File fileContents;
        if(cacheFile.exists()) {
            try {
                cacheFile.delete();
            } catch (Exception var25) {
                ;
            }
        } else {
            fileContents = cacheFile.getParentFile();
            if(!fileContents.exists()) {
                fileContents.mkdirs();
            }
        }

        try {
            cacheFile.createNewFile();
        } catch (Exception var24) {
            ;
        }

        cacheFile = new File(filePath);
        if(cacheFile.exists()) {
//            fileContentsBytes = null;
            byte[] fileContentsBytes;
            if(null != charset && !charset.trim().isEmpty()) {
                fileContentsBytes = fileContent.getBytes(charset);
            } else {
                fileContentsBytes = fileContent.getBytes();
            }

            ByteBuffer buf = ByteBuffer.wrap(fileContentsBytes);
            FileOutputStream fout = null;
            FileChannel outc = null;

            try {
                fout = new FileOutputStream(filePath);
                outc = fout.getChannel();
                outc.write(buf);
            } catch (FileNotFoundException var22) {
                throw var22;
            } catch (IOException var23) {
                throw var23;
            } finally {
                if(fout != null) {
                    try {
                        fout.close();
                    } catch (IOException var21) {
                        ;
                    }
                }

                if(outc != null) {
                    try {
                        outc.close();
                    } catch (IOException var20) {
                        ;
                    }
                }

            }

        }
    }

    public static void writeStringToFile(String fileContent, String filePath) throws FileNotFoundException, IOException {
        writeStringToFile(fileContent, filePath, (String)null);
    }

    public static String getContentFromFile(String filePath) {
        File file = new File(filePath);
        if(!file.exists()) {
            return "";
        } else {
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                InputStream is = new FileInputStream(file);
                byte[] buffer = new byte[10000];

                int length;
                while((length = is.read(buffer)) != -1) {
                    os.write(buffer, 0, length);
                }
            } catch (Exception var14) {
                ;
            } finally {
                try {
                    os.close();
                } catch (Exception var13) {
                    ;
                }

            }

            ByteArrayOutputStream baos = (ByteArrayOutputStream)os;
            String fileContent = "";
            if(baos.size() != 0) {
                fileContent = baos.toString();
            }

            return fileContent;
        }
    }

    public static void deleteFolder(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            if(file.isFile()) {
                file.delete();
            } else if(file.isDirectory()) {
                File[] files = file.listFiles();

                for(int i = 0; i < files.length; ++i) {
                    deleteFolder(files[i]);
                }
            }

            file.delete();
        }

    }

    public static void deleteFolder(File file) {
        if(file.exists()) {
            if(file.isFile()) {
                file.delete();
            } else if(file.isDirectory()) {
                File[] files = file.listFiles();

                for(int i = 0; i < files.length; ++i) {
                    deleteFolder(files[i]);
                }
            }

            file.delete();
        }

    }

    public static long fileChannelCopy(String inFilePath, String outFilePath) throws Exception {
        long begin = System.currentTimeMillis();
        File inFile = new File(inFilePath);
        if(!inFile.exists()) {
            return 0L;
        } else {
            File outFile = new File(outFilePath);
            if(!outFile.exists()) {
                File parent = outFile.getParentFile();
                if(!parent.exists()) {
                    parent.mkdirs();
                }
            } else {
                outFile.delete();
            }

            outFile.createNewFile();
            FileInputStream fin = new FileInputStream(inFile);
            FileOutputStream fout = new FileOutputStream(outFile);
            FileChannel fcin = fin.getChannel();
            FileChannel fcout = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(true) {
                buffer.clear();
                int r = fcin.read(buffer);
                if(r == -1) {
                    changeFileAuth(outFilePath);
                    long end = System.currentTimeMillis();
                    long runtime = 0L;
                    if(end > begin) {
                        runtime = end - begin;
                    }

                    return runtime;
                }

                buffer.flip();
                fcout.write(buffer);
            }
        }
    }

    public static void changeFileAuth(String fileNamePath) {
        try {
            String osName = System.getProperties().getProperty("os.name");
            if(null != osName && osName.trim().toLowerCase().indexOf("windows") == -1) {
                String commond = "chmod 600 " + fileNamePath;
                Runtime.getRuntime().exec(commond);
            }
        } catch (Exception var3) {
            log.error("修改缓存文件" + fileNamePath + "权限失败。如果您使用了windows操作系统，请忽略该异常", var3);
        }

    }
}
