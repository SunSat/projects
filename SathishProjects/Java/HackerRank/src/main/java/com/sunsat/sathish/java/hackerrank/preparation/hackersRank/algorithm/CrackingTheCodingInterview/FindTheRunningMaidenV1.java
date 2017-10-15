package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by ssundar2 on 04-02-2017.
 */
public class FindTheRunningMaidenV1 {
    public static void main(String[] args) throws Exception{
        try{
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            int max = 0;
            int array[] = {1000,1006,1012,1018,1024,1030,1036,1042,1048,1054,1060,1066,1072,1078,1084,1090,1096,1102,1108,1114,1120,1126,1132,1138,1144,1150,1156,1162,1168,1174,1180,1186,1192,1198,1204,1210,1216,1222,1228,1234,1240,1246,1252,1258,1264,1270,1276,1282,1288,1294,1300,1306,1312,1318,1324,1330,1336,1342,1348,1354,1360,1366,1372,1378,1384,1390,1396,1402,1408,1414,1420,1426,1432,1438,1444,1450,1456,1462,1468,1474,1480,1486,1492,1498,1504,1510,1516,1522,1528,1534,1540,1546,1552,1558,1564,1570,1576,1582,1588,1594,1600,1606,1612,1618,1624,1630,1636,1642,1648,1654,1660,1666,1672,1678,1684,1690,1696,1702,1708,1714,1720,1726,1732,1738,1744,1750,1756,1762,1768,1774,1780,1786,1792,1798,1804,1810,1816,1822,1828,1834,1840,1846,1852,1858,1864,1870,1876,1882,1888,1894,1900,1906,1912,1918,1924,1930,1936,1942,1948,1954,1960,1966,1972,1978,1984,1990,1996,2002,2008,2014,2020,2026,2032,2038,2044,2050,2056,2062,2068,2074,2080,2086,2092,2098,2104,2110,2116,2122,2128,2134,2140,2146,2152,2158,2164,2170,2176,2182,2188,2194,2200,2206,2212,2218,2224,2230,2236,2242,2248,2254,2260,2266,2272,2278,2284,2290,2296,2302,2308,2314,2320,2326,2332,2338,2344,2350,2356,2362,2368,2374,2380,2386,2392,2398,2404,2410,2416,2422,2428,2434,2440,2446,2452,2458,2464,2470,2476,2482,2488,2494,2500,2506,2512,2518,2524,2530,2536,2542,2548,2554,2560,2566,2572,2578,2584,2590,2596,2602,2608,2614,2620,2626,2632,2638,2644,2650,2656,2662,2668,2674,2680,2686,2692,2698,2704,2710,2716,2722,2728,2734,2740,2746,2752,2758,2764,2770,2776,2782,2788,2794,2800,2806,2812,2818,2824,2830,2836,2842,2848,2854,2860,2866,2872,2878,2884,2890,2896,2902};
            long pre = System.currentTimeMillis();
            for(int a_i=0; a_i < n; a_i++){
                //a[a_i] = array[a_i];//in.nextInt();
                //a[a_i] = in.nextInt();
                int value = in.nextInt();
                if(value < -1 && value > 100000) {
                    throw new Exception();
                }
                int pos = findPosition(a,0,a_i,value);
            }
            System.out.println(System.currentTimeMillis()-pre);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    static int findPosition(int[] a,int min,int max,int value) {
        int low = min;
        int high = max ;
        int middle = 0;
        while(low <= high ) {
            middle = (low+high) /2;
            if (value > a[middle] ){
                if(middle != min && value > a[middle-1]) {
                    break;
                }
                low = middle +1;
            } else if (value< a[middle]){
                if(middle != max-1 && value < a[middle+1]) {
                    break;
                }
                high = middle -1;
            }
        }
        return middle;
    }
    static int[] findSortingIndex(int[] a,int len,int value, int totalValue) {
        int newArr[] = new int[totalValue];
        int min = 0;
        int max = len;
        int mid = min+max/2;
        while(mid >= 0 && mid <=len) {
            if(a[mid] >= value) {
                mid = (mid-1)/2;
                if(mid == min || mid == max) break;
            } else if(a[mid] < value){
                mid = (mid+1)/2;
                if(mid == min || mid == max) break;
            }
        }
        newArr[mid] = value;
        if(mid == 0) {
            System.arraycopy(a,0,newArr,1,len);
        } else if(mid == len) {
            System.arraycopy(a,0,newArr,0,len);
        } else {
            System.arraycopy(a,0,newArr,0,mid-1);
            System.arraycopy(a,mid+1,newArr,mid+1,len);
        }
        return  newArr;
    }
    static double findTheMaiden(int[] arr, int len,int max) {

        return 0;
    }
}
