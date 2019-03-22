package com.msd.idea.plugin.js;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import com.msd.idea.plugin.BaseCompletionContributor;
import com.msd.idea.plugin.component.MyProjectComponentImpl;
import org.jetbrains.annotations.NotNull;

public class JsCompletionContributor extends BaseCompletionContributor {
    public JsCompletionContributor() {

        extend(CompletionType.BASIC,
                XmlPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {

                        PsiElement position = parameters.getOriginalPosition();
                        IElementType type = ((LeafPsiElement) position).getElementType();


                        //只有在输入属于的时候才触发
                        if("JS:STRING_LITERAL".equals(type.toString())){
                            String value = position.getText();
                            if(value == null){
                                return;
                            }

                            if(value.matches("^[\\\"'].*[\\\"']$")){
                                value = value.substring(1, value.length()-1);
                            }

                            if(value.trim().length() == 0){
                                return;
                            }


                            resultSet.addAllElements(MyProjectComponentImpl.getList());
                        }
                    }
                }
                );
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
