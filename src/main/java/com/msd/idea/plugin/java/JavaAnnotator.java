package com.msd.idea.plugin.java;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.msd.idea.plugin.BaseAnnotator;
import org.jetbrains.annotations.NotNull;

public class JavaAnnotator extends BaseAnnotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {

        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

            if (value != null) {
                Project project = element.getProject();
//                String key = value.substring(7);
//                List<SimpleProperty> properties = SimpleUtil.findProperties(project, key);
//                if (properties.size() == 1) {
//                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 7,
//                            element.getTextRange().getStartOffset() + 7);
//                    Annotation annotation = holder.createInfoAnnotation(range, null);
//                    annotation.setTextAttributes(DefaultLanguageHighlighterColors.LINE_COMMENT);
//                } else if (properties.size() == 0) {
//                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 8,
//                            element.getTextRange().getEndOffset());
//                    holder.createErrorAnnotation(range, "非标准词语!");
//                }


                checkString(value, element, holder);
            }
        }
    }

}