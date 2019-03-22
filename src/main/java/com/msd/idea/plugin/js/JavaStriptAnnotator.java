package com.msd.idea.plugin.js;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.msd.idea.plugin.BaseAnnotator;
import org.jetbrains.annotations.NotNull;

public class JavaStriptAnnotator extends BaseAnnotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {

        if(!(element instanceof LeafPsiElement)){
            return;
        }

        IElementType type = ((LeafPsiElement) element).getElementType();

        //只有在输入字符串的时候才触发
        if("JS:STRING_LITERAL".equals(type.toString())){
            String value = element.getText();

            if(value.matches("^[\\\"'].*[\\\"']$")){
                value = value.substring(1, value.length()-1);
            }
            checkString(value, element, holder);
        }
    }
}