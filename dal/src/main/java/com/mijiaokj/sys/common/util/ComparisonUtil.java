package com.mijiaokj.sys.common.util;

/**
 * Created by wb-scg178938 on 2017/6/15.
 */

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ComparisonUtil {
    static Log log = LogFactory.getLog(ComparisonUtil.class);

    public ComparisonUtil() {
    }

    public static boolean compareObjectsAllSame(Object... params) {
        if(null != params && params.length > 1) {
            Object expect = params[0];

            for(int i = 1; i < params.length; ++i) {
                Object actual = params[i];
                if(null != expect || null != actual) {
                    if(null == expect || null == actual) {
                        return false;
                    }

                    if(!compareObjects(actual, expect)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean compareObjectsNotSame(Object... params) {
        if(null != params && params.length > 1) {
            for(int i = 0; i < params.length - 1; ++i) {
                Object expect = params[i];

                for(int j = i + 1; j < params.length; ++j) {
                    Object actual = params[j];
                    if(null == expect && null == actual) {
                        return false;
                    }

                    if(null != expect && null != actual && compareObjects(actual, expect)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean compareMaps(Object obj1, Object obj2) {
        if(!(obj2 instanceof Map)) {
            return false;
        } else {
            Map m1 = (Map)obj1;
            Map m2 = (Map)obj2;
            if(m1.size() != m2.size()) {
                return false;
            } else {
                Iterator i$ = m1.keySet().iterator();

                Object key;
                do {
                    if(!i$.hasNext()) {
                        return true;
                    }

                    key = i$.next();
                    if(!m2.containsKey(key)) {
                        return false;
                    }
                } while(compareObjects(m1.get(key), m2.get(key)));

                return false;
            }
        }
    }

    public static boolean compareSets(Object obj1, Object obj2) {
        if(!(obj2 instanceof Set)) {
            return false;
        } else {
            Set s1 = (Set)obj1;
            Set s2 = (Set)obj2;
            List usedElements = new LinkedList();
            if(s1.size() != s2.size()) {
                Iterator i = s1.iterator();

                while(i.hasNext()) {
                    Object o1 = i.next();
                    boolean found = false;
                    Iterator ii = s2.iterator();

                    label44:
                    while(true) {
                        Object o2;
                        do {
                            if(!ii.hasNext()) {
                                break label44;
                            }

                            o2 = ii.next();
                        } while(!compareObjects(o1, o2));

                        boolean used = false;
                        Iterator iii = usedElements.iterator();

                        while(iii.hasNext()) {
                            Object o = iii.next();
                            if(o == o2) {
                                used = true;
                                break;
                            }
                        }

                        if(!used) {
                            usedElements.add(o2);
                            found = true;
                            break;
                        }
                    }

                    if(!found) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static boolean compareListsSequece(Object obj1, Object obj2) {
        if(!(obj2 instanceof List)) {
            return false;
        } else {
            ListIterator e1 = ((List)obj1).listIterator();
            ListIterator e2 = ((List)obj2).listIterator();

            while(e1.hasNext() && e2.hasNext()) {
                if(!compareObjects(e1.next(), e2.next())) {
                    return false;
                }
            }

            return !e1.hasNext() && !e2.hasNext();
        }
    }

    public static boolean compareLists(Object obj1, Object obj2) {
        if(null == obj1 && null == obj2) {
            return true;
        } else if(null != obj1 && null != obj2) {
            if(obj1 instanceof List && obj2 instanceof List) {
                if(((List)obj1).size() != ((List)obj2).size()) {
                    return false;
                } else {
                    Set set = new HashSet();
                    Iterator i$ = ((List)obj1).iterator();

                    Object objTmp;
                    while(i$.hasNext()) {
                        objTmp = i$.next();
                        if(null != objTmp) {
                            set.add(objTmp);
                        }
                    }

                    i$ = ((List)obj2).iterator();

                    do {
                        if(!i$.hasNext()) {
                            return true;
                        }

                        objTmp = i$.next();
                    } while(null == objTmp || set.contains(objTmp));

                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean compareArrays(Object obj1, Object obj2) {
        if(!obj2.getClass().isArray()) {
            return false;
        } else if(Array.getLength(obj1) != Array.getLength(obj2)) {
            return false;
        } else {
            for(int i = 0; i < Array.getLength(obj1); ++i) {
                if(!compareObjects(Array.get(obj1, i), Array.get(obj2, i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean compareObjects(Object obj1, Object obj2) {
        return obj1 == obj2?true:(null != obj1 && null != obj2?(obj1 instanceof Map?compareMaps(obj1, obj2):(obj1 instanceof List?compareLists(obj1, obj2):(obj1 instanceof Set?compareSets(obj1, obj2):(obj1.getClass().isArray()?compareArrays(obj1, obj2):obj1.equals(obj2))))):false);
    }

    public static boolean compareStrings(String... params) {
        if(null != params && params.length > 1) {
            String expect = params[0];

            for(int i = 1; i < params.length; ++i) {
                String actual = params[i];
                if(null != expect || null != actual) {
                    if(null == expect || null == actual) {
                        return false;
                    }

                    if(!expect.equals(actual)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }
}

