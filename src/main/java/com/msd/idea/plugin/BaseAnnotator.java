package com.msd.idea.plugin;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.msd.idea.plugin.component.MyProjectComponentImpl;
import org.jetbrains.annotations.NotNull;


public abstract class BaseAnnotator implements Annotator {


    protected void checkString(String value, @NotNull final PsiElement element, @NotNull AnnotationHolder holder){
//        String filePath = holder.getCurrentAnnotationSession().getFile().getVirtualFile().getPath();
//        String fileName = holder.getCurrentAnnotationSession().getFile().getVirtualFile().getName();
//
//        System.out.println(fileName);
//        System.out.println(element.hashCode());

        //如果包含了中文,即验证是否存在标准词语
        if(ChinessUtil.checkcountname(value)){
            if(!MyProjectComponentImpl.isExist(value.trim())){
                TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
                holder.createWarningAnnotation(range, "非标准词语!");
                MyProjectComponentImpl.addNonstandard(value.trim());
            }
        }
    }
}
