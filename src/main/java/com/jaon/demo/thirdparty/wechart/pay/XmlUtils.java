package com.jaon.demo.thirdparty.wechart.pay;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.BinaryStreamDriver;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.*;

import java.io.Serializable;

/**
 * https://www.jianshu.com/p/d8e6c5488353
 * XStream
 */
public class XmlUtils{
    public static String objectToXml(Serializable obj){
        /**
         * XmlFriendlyNameCoder
         * The default replacements are:
         * $ (dollar) chars are replaced with _- (underscore dash) string.
         * _ (underscore) chars are replaced with __ (double underscore) string.
         * other characters that are invalid in XML names are encoded with _.XXXX
         * (underscore dot followed by hex representation of character).
         * 这里默认使用_-替换java中的标识符$，默认使用__替换java中的_，默认使用_.前缀标识十六进制0xC0为_.0xC0
         * 下面是我自定义
         * 使用_-替换java中的标识符$
         * 使用_替换java中的标识符_
         * 使用_.前缀标识十六进制0xC0为_.0xC0
         * Xpp3DomDriver
         * Xpp3Driver输出的是带格式的xml字符，没有"<?xml version="1.0" encoding="utf-8"?>"头信息
         * StaxDriver输出的是压缩的xml字符，有<?xml version="1.0" ?>头信息，没有编码信息
         *
         * json-->bean 使用JettisonMappedXmlDriver
         * bean-->json 使用JsonHierarchicalStreamDriver
         *
         * XPP —— XML Pull Parser，XPP3是一个非常快的XML解析器，是第三版的XPP。
         * XPP2是XPP的第二版。
         * XPP3是XPP2的继承者，实现了 http://www.xmlpull.org 定义的 XmlPull API 。
         * XPP3只能用于解析XML，不支持节点树的增加操作。
         * 看到有人做的对比测试，XPP3 比 DOM4J 快6倍，也就是使用了1/6时间。
         */
        XStream xstream = new XStream(new StaxDriver(new XmlFriendlyNameCoder("_-", "_","_.")));
        /**
         * 使用xstream.autodetectAnnotations(true);这种自动开启注解（懒加载）的方式会在xml-->bean的时候报错，
         * https://blog.csdn.net/H_233/article/details/84946976
         * 所以建议使用processAnnotations（预加载）
         */
        /**
         * 开启注解的两种方式autodetectAnnotations\processAnnotations
         * xstream.processAnnotations(obj.getClass());
         */
        xstream.processAnnotations(new Class[]{obj.getClass()});
        String xml = xstream.toXML(obj);
        return xml;
    }


    public static void main(String[] args) {
        String s = objectToXml(new H5PayRequestParams());
        System.out.println(s);
    }
}
