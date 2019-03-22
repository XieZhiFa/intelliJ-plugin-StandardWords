package com.msd.idea.plugin.java;

import com.intellij.codeInsight.completion.*;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.msd.idea.plugin.BaseCompletionContributor;
import com.msd.idea.plugin.component.MyProjectComponentImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaCompletionContributor extends BaseCompletionContributor {
    public JavaCompletionContributor() {

        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(JavaTokenType.STRING_LITERAL).withLanguage(JavaLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {

                        PsiElement position = parameters.getOriginalPosition();
                        String inputText = position.getText();
                        if(inputText == null){
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

    @Nullable
    @Override
    public String handleEmptyLookup(@NotNull CompletionParameters parameters, Editor editor) {
        return super.handleEmptyLookup(parameters, editor);
    }

    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        super.beforeCompletion(context);
    }

}
