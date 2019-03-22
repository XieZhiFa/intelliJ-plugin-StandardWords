package com.msd.idea.plugin.html;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.xml.XmlTextImpl;
import com.intellij.psi.impl.source.xml.XmlTokenImpl;
import com.intellij.psi.xml.XmlTokenType;
import com.msd.idea.plugin.BaseAnnotator;
import com.msd.idea.plugin.ChinessUtil;
import org.jetbrains.annotations.NotNull;


/**
 * html 继承 xml
 */
public class XmlAnnotator extends BaseAnnotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {



        boolean isJavaScript = false;
        String text = null;
        if(element instanceof XmlTokenImpl){
            XmlTokenImpl xmlToken = (XmlTokenImpl) element;
            if(xmlToken.getTokenType() == XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN){
                text = xmlToken.getText();
            }

//            else if(xmlToken.getTokenType() == XmlTokenType.XML_DATA_CHARACTERS){
//                String tmp = xmlToken.getText();
//                if(ChinessUtil.checkcountname(tmp) && !tmp.matches("^[/<].*$")){
//                    text = tmp;
//                    System.out.println("检查: " + text);
//                }
//            }

        }else if(element instanceof XmlTextImpl){
            XmlTextImpl xmlText = (XmlTextImpl) element;
            String tmp = xmlText.getText().trim();
            if(tmp.length() <20 && ChinessUtil.checkcountname(tmp)){
                text = tmp;
            }
        }

        if(text == null){
            return;
        }

        //System.out.println(element.toString() + " = " + text);

        String value = text;
        if(value.matches("^[\\\"'].*[\\\"']$")) {
            value = value.substring(1, value.length() - 1);

        }

        if(value.trim().length() == 0){
            return;
        }

        checkString(value, element, holder);
    }
}