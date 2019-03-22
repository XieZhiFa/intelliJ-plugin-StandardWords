package com.msd.idea.plugin.html;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlTokenType;
import com.intellij.util.ProcessingContext;
import com.msd.idea.plugin.BaseCompletionContributor;
import com.msd.idea.plugin.component.MyProjectComponentImpl;
import org.jetbrains.annotations.NotNull;

public class XMLCompletionContributor extends BaseCompletionContributor {
    public XMLCompletionContributor() {

        extend(CompletionType.BASIC,
                XmlPatterns.psiElement(XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {

                        PsiElement position = parameters.getOriginalPosition();

                        String inputText = position.getText();
                        if(inputText == null){
                            return;
                        }

                        if(inputText.trim().length() == 0){
                            return;
                        }

                        resultSet.addAllElements(MyProjectComponentImpl.getList());
                    }
                }
                );
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
